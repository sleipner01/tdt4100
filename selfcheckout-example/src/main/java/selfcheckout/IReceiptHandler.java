package selfcheckout;

import java.io.IOException;
import java.nio.file.Path;

public interface IReceiptHandler {

    SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws IOException;

    void writeReceipt(String filename, SelfCheckout selfCheckout) throws IOException;

    Path getReceiptPath(String filename);

}
