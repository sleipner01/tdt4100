// 1.
// Et forslag er å atomisere all informasjon,
// som å dele fornavn og etternavn inn i to egne variabler.

// 2.
    // 1.
    // Lagre infoen i et objekt, med fornavn, etternavn
    // domene, og landskode.

    // 2.
    // Splitte validert input og lagre domnene, og landskode i egne variabler.

package oving2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Person {

    private String name;
    private String email;
    private Date birthday;
    private char gender = '\0';
    private String SSN;

    private static final int[] SSNControlF = { 3, 7, 6, 1, 8, 9, 4, 5, 2 },
                               SSNControlG = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
    
    private static final String emailFormat = "^[A-Za-z.]+@[A-Za-z0-9.]+$";
    private static final List<String> landCodes = Arrays.asList(
        "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as",
        "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg",
        "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt",
        "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci",
        "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy",
        "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh",
        "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb",
        "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq",
        "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht",
        "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it",
        "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp",
        "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls",
        "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh",
        "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu",
        "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni",
        "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg",
        "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa",
        "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg",
        "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st",
        "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk",
        "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug",
        "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu",
        "wf", "ws", "ye", "yt", "za", "zm", "zw");


    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public char getGender() {
        return this.gender;
    }

    private boolean validateName(String name) throws IllegalArgumentException {
        if (!name.contains(" "))
            throw new IllegalArgumentException("You need to write both a first-name and sur-name, and split them with a space.");

        if (!name.matches("[a-zA-Z ]+")) 
            throw new IllegalArgumentException("The name has to contain valid characters from the alphabet.");

        
        String[] nameArray = name.split(" ");
        if(nameArray.length > 2)
            throw new IllegalArgumentException("The name can only contain a first-name and a sur-name.");
        if(nameArray[0].length() < 2)
            throw new IllegalArgumentException("The first-name need to have at least two characters.");
        if(nameArray[1].length() < 2)
            throw new IllegalArgumentException("The sur-name need to have at least two characters.");
        
        return true;
    }

    public void setName(String name) throws IllegalArgumentException {
        name = name.trim();
        validateName(name);
        this.name = name;
    }

    private boolean validateEmail(String email) {

        if(!Pattern.matches(emailFormat, email))
            throw new IllegalArgumentException("Your email pattern is wrong.");
             
        String[] nameArray = this.name.split(" ");
        String emailPrefix = nameArray[0].toLowerCase() + "." + nameArray[1].toLowerCase();
        if(!email.startsWith(emailPrefix))
        throw new IllegalArgumentException("The email must start with: " + emailPrefix);
        
        String[] emailParts = email.split("[.]");
        if(!landCodes.contains(emailParts[emailParts.length - 1]))
            throw new IllegalArgumentException("Invalid landcode.");

        return true;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    private boolean valiDate(Date date) throws IllegalArgumentException {
        Date today = new Date();

        if(today.before(date))
            throw new IllegalArgumentException("Cannot set a future date");
        
        return true;
    }

    public void setBirthday(Date birthday) throws IllegalArgumentException {
        valiDate(birthday);
        this.birthday = birthday;
    }

    private boolean validateGender(char genderInput) throws IllegalArgumentException {
        String validGenders = "MF\0";

        if (validGenders.indexOf(genderInput) == -1) 
            throw new IllegalArgumentException("The gender can only be F or M.");

        return true;
    }

    public void setGender(char gender) throws IllegalArgumentException {
        validateGender(gender);
        this.gender = gender;
    }

    private boolean validateSSN(String SSN) throws IllegalArgumentException, IllegalStateException {

        // Check if birthday and gender are set
        if (this.birthday == null || this.gender == '\0')
            throw new IllegalStateException("Use need to set birthday and gender before the SSN.");

        // Length of input
        if (SSN.length() < 11 || SSN.length() > 12)
            throw new IllegalArgumentException("The SSN must be 11 digits long.");


        // Birthday validation
        String SSNDatePattern = "ddMMyy";
        DateFormat df = new SimpleDateFormat(SSNDatePattern);
        String birthdayAsString = df.format(this.birthday);

        if(!SSN.startsWith(birthdayAsString))
            throw new IllegalArgumentException("The SSN is invalid.");

        // Gendercheck
        int genderNumber = Character.getNumericValue(SSN.charAt(SSN.length()-3));
        if(gender == 'F' && genderNumber%2 != 0)
            throw new IllegalArgumentException("The SSN is invalid for females");
        if(gender == 'M' && genderNumber%2 != 1)
            throw new IllegalArgumentException("The SSN is invalid for males");
    
        // K1 & K2
        int k1WeightSum = 0;
        int k2WeightSum = 0;
        int[] SSNIntegerArray = new int[SSN.length()];
        for (int i = 0; i < SSN.length(); i++){
            // Getting ACHII value, therefore - '0'
            SSNIntegerArray[i] = SSN.charAt(i) - '0';
            System.out.println("i" + i + ":" + SSNIntegerArray[i]);
        }

        for (int i = 0; i < 9; i++) {
            k1WeightSum += SSNIntegerArray[i]*SSNControlF[i]; 
        }

        if (controlFormula(k1WeightSum) != SSNIntegerArray[SSNIntegerArray.length - 2])
            throw new IllegalArgumentException("First control value is invalid");
        
        for (int i = 0; i < 10; i++) {
            k2WeightSum += SSNIntegerArray[i]*SSNControlG[i]; 
        }

        if (controlFormula(k2WeightSum) != SSNIntegerArray[SSNIntegerArray.length - 1])
            throw new IllegalArgumentException("Second control value is invalid");
        

        return true;
    }

    private int controlFormula(int weightSum) {
        return 11-(weightSum % 11);
    }

    public void setSSN(String SSN) throws IllegalArgumentException {
        validateSSN(SSN);
        this.SSN = SSN;
    }

    public String getSSN() {
        return this.SSN;
    }


    public static void main(String[] args) throws ParseException {

        Person person = new Person();
        person.setName("Ola Nordmann");
        person.setEmail("ola.nordmann@ntnu.no");
        person.setGender('M');
        Date date= new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2001");
        person.setBirthday(date);
        person.setSSN("10050191325");

    }

    @Override
    public String toString() {
        return "Person [Email=" + email + ", birthday=" + birthday + ", name=" + name + ", gender=" + gender + "]";
    }

}
