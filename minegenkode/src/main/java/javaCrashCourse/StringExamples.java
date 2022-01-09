package javaCrashCourse;

public class StringExamples {

    public static void main(String[] args) {
        String message = "   Hello World" + "!!   ";
        System.out.println(message.endsWith("!!"));
        System.out.println(message.length());
        System.out.println(message.indexOf("o")); // Returnerer -1 hvis det ikke finnes
        System.out.println(message.replace("!", "*")); // Endrer ikke originalstrengen
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message.trim());

        String message2 = "Hello \"Retard\"";
        System.out.println(message2);

        String filePath = "c:\\Windows\\...";
        System.out.println(filePath);

        String newLine = "c:\nWindows\t...";
        System.out.println(newLine);
    }
    
}
