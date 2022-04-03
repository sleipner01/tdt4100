package selfcheckout;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class HomeFolderReceiptHandler implements IReceiptHandler {

    @Override
    public SelfCheckout readReceipt(String filename, SelfCheckout selfCheckout) throws IOException {
        try (Scanner scanner = new Scanner(getReceiptFolderPath())) {
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
    public void writeReceipt(String filename, SelfCheckout selfCheckout) throws IOException {
        Files.createDirectories(getReceiptFolderPath());
        try (PrintWriter writer = new PrintWriter(getReceiptFolderPath().resolve(filename + ".txt").toFile())) {
            writer.println(selfCheckout.getPhoneNumber());
            for (Item item : selfCheckout.getShoppingCartItems()) {
                writer.println(String.format("%s;%s;%s", item.getName(), item.getPrice(), item.getCategory()));
            }
        }

    }

    private static Path getReceiptFolderPath() {
        return Path.of(System.getProperty("user.home"), "tdt4100files", "receipts");
    }

}
