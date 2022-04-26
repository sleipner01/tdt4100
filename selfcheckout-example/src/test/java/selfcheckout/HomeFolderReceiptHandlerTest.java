package selfcheckout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.BeforeAll;

public class HomeFolderReceiptHandlerTest extends ReceiptHandlerTest {

    @Override
    protected IReceiptHandler getReceiptHandler() {
        return new HomeFolderReceiptHandler();
    }

    @BeforeAll
    public void setup() throws IOException {
        Files.createDirectories(HomeFolderReceiptHandler.getReceiptFolderPath().resolve("testing"));
        Files.copy(new TemporaryFileReceiptHandler().getReceiptFile("testing/test_receipt").toPath(),
                new FileOutputStream(getReceiptHandler().getReceiptFile("testing/test_receipt")));
        Files.copy(new TemporaryFileReceiptHandler().getReceiptFile("testing/invalid_receipt").toPath(),
                new FileOutputStream(getReceiptHandler().getReceiptFile("testing/invalid_receipt")));
    }

}
