package selfcheckout;

public class HomeFolderReceiptHandlerTest extends ReceiptHandlerTest {

    @Override
    protected IReceiptHandler getReceiptHandler() {
        return new HomeFolderReceiptHandler();
    }

}
