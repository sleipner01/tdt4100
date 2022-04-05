package selfcheckout;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class ReceiptHandlerTest {

    private static final String test_receipt_file_content = """
            null
            Egg, 6 stk;41.59;breakfast
            Hvitost, Synnøve;90.0;diary
            Leverpostei;29.99;breakfast
            """;;

    private static final String invalid_receipt_file_content = """
            Egg, 6 stk;;breakfast
            ;90.0;diary
            ;90.0;
            ;;
            Leverpostei;
            """;;

    private String adminPassword = "test123";
    private String day = "mon";

    protected abstract IReceiptHandler getReceiptHandler();

    private SelfCheckout getPlainTestSelfCheckoutObject() {
        return new SelfCheckout(day, adminPassword);
    }

    private SelfCheckout getFilledTestSelfCheckoutObject() {
        SelfCheckout testSelfCheckoutObject = getPlainTestSelfCheckoutObject();
        testSelfCheckoutObject.scanItem(new Item("Egg, 6 stk", 41.59, "breakfast"));
        testSelfCheckoutObject.scanItem(new Item("Hvitost, Synnøve", 90.0, "diary"));
        testSelfCheckoutObject.scanItem(new Item("Leverpostei", 29.99, "breakfast"));
        return testSelfCheckoutObject;
    }

    @BeforeAll
    public void setup() throws IOException {
        Files.write(getReceiptHandler().getReceiptPath("test_receipt"), test_receipt_file_content.getBytes());
        Files.write(getReceiptHandler().getReceiptPath("invalid_receipt"), invalid_receipt_file_content.getBytes());
    }

    @Test
    public void testReadReceipt() throws IOException {
        SelfCheckout expectedSelfCheckoutObject = getFilledTestSelfCheckoutObject();
        SelfCheckout actualSelfCheckoutObject = getReceiptHandler().readReceipt("test_receipt",
                getPlainTestSelfCheckoutObject());
        assertEquals(actualSelfCheckoutObject.getPhoneNumber(), expectedSelfCheckoutObject.getPhoneNumber(),
                "Phone number is not the same");

        Iterator<Item> expectedIterator = expectedSelfCheckoutObject.getShoppingCartItems().iterator();
        Iterator<Item> actualIterator = actualSelfCheckoutObject.getShoppingCartItems().iterator();

        while (expectedIterator.hasNext()) {
            try {
                Item expectedItem = expectedIterator.next();
                Item actualItem = actualIterator.next();
                assertEquals(expectedItem, actualItem,
                        "Element mismatch, expected: " + expectedItem + " but got: " + actualItem);
            } catch (IndexOutOfBoundsException e) {
                fail("The read list does not contain the correct number of items.");
            }
        }
    }

    @Test
    public void testLoadNonExistingFile() {
        assertThrows(
                IOException.class,
                () -> getReceiptHandler().readReceipt("non_existing_file", getPlainTestSelfCheckoutObject()),
                "IOException should be thrown if file does not exist!");
    }

    @Test
    public void testReadInvalidReceipt() {
        assertThrows(
                IllegalArgumentException.class,
                () -> getReceiptHandler().readReceipt("invalid_receipt", getPlainTestSelfCheckoutObject()),
                "Only IllegalArgumentException should be thrown if content of file is invalid!");
    }

    @Test
    public void testWriteReceipt() throws IOException {
        getReceiptHandler().writeReceipt("new_receipt", getFilledTestSelfCheckoutObject());
        Path expectedFile = getReceiptHandler().getReceiptPath("test_receipt");
        Path actualFile = getReceiptHandler().getReceiptPath("new_receipt");
        assertEquals(Files.mismatch(expectedFile, actualFile), -1,
                "Contents of files are not the same");
    }

    @AfterAll
    public void teardown() {
        getReceiptHandler().getReceiptPath("new_receipt").toFile().delete();
        getReceiptHandler().getReceiptPath("test_receipt").toFile().delete();
        getReceiptHandler().getReceiptPath("invalid_receipt").toFile().delete();
    }
}
