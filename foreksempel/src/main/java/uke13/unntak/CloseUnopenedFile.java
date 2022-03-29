package uke13.unntak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CloseUnopenedFile {
    
    private static void lesFil() {

        String filnavn = "C:/Users/borgeha/tdt4100-v2022/students/foreksempel/src/main/java/uke13/unntak/Linjer.txt"; 
        BufferedReader br = null;
        try (FileReader fr = new FileReader(filnavn)) {
            br = new BufferedReader(fr);
            int count = 0;
            String linje;

            while (br.ready()) {
                linje = br.readLine();
                count++;
                System.out.println("Linje nummer "+count+": "+linje);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        lesFil();
    }
}
