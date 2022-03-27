package uke13.unntak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilLesing {
    
    private static void lesFil() {

        BufferedReader br = null; // For å initialisere den...

        try {
            String filnavn = "C:/Users/borgeha/tdt4100-v2022/students/foreksempel/src/main/java/uke13/unntak/Linjer.txt"; 
            FileReader fr = new FileReader(filnavn);
            br = new BufferedReader(fr);
            int count = 0;
            String linje;

            while (br.ready()) {
                linje = br.readLine();
                count++;
                System.out.println("Linje nummer "+count+": "+linje);
            }
            // int a = 3/0;
        } catch (IOException e) {
            System.out.println("IOException: "+e.getMessage());;
        }

        try {
            System.out.println("Før close");
            br.close();
            System.out.println("Etter close");
        } catch (IOException e) {
            System.out.println("Close feilet: "+e.getMessage());
        }

    }

    public static void main(String[] args) {
        lesFil();
    }
}
