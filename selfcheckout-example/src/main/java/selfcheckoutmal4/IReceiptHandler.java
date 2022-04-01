package selfcheckoutmal4;

import java.io.IOException;

public interface IReceiptHandler {

    SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws IOException;

    void writeReceipt(String filename, SelfCheckout selfCheckout) throws IOException;

}
