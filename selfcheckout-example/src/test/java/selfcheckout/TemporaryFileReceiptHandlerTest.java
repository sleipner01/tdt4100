package selfcheckout;

public class TemporaryFileReceiptHandlerTest extends ReceiptHandlerTest {

    @Override
    protected IReceiptHandler getReceiptHandler() {
        return new TemporaryFileReceiptHandler();
    }

}
