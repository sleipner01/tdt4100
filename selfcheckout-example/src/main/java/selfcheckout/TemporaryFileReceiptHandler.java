package selfcheckout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TemporaryFileReceiptHandler implements IReceiptHandler {

    @Override
    public SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(getReceiptFile(filename))) {
            String phoneNumber = scanner.nextLine();
            if (!phoneNumber.equals("null")) {
                selfCheckout.registerPhoneNumber(phoneNumber);
            }
            while (scanner.hasNextLine()) {
                String[] properties = scanner.nextLine().split(";");
                selfCheckout.scanItem(new Item(properties[0], Double.parseDouble(properties[1]), properties[2]));
            }
        }
        return selfCheckout;
    }

    @Override
    public void writeReceipt(String filename, SelfCheckout selfCheckout) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(getReceiptFile(filename))) {
            System.out.println(getReceiptFile(filename));
            writer.println(selfCheckout.getPhoneNumber());
            for (Item item : selfCheckout.getShoppingCartItems()) {
                writer.println(String.format("%s;%s;%s", item.getName(), item.getPrice(), item.getCategory()));
            }
        }

    }

    @Override
    public File getReceiptFile(String filename) {
        return new File(TemporaryFileReceiptHandler.class.getResource("receipts").getFile() + filename + ".txt");
    }

}
