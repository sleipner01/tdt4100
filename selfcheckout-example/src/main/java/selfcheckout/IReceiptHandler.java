package selfcheckout;

import java.io.File;
import java.io.IOException;

public interface IReceiptHandler {

    SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws IOException;

    void writeReceipt(String filename, SelfCheckout selfCheckout) throws IOException;

    File getReceiptFile(String filename);

}
