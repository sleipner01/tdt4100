package selfcheckout;

import java.io.FileNotFoundException;

public interface ICheckoutReceipt {

    SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException;

    void writeReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException;

}
