package oving2;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Person {

    private String name;
    private String email;
    private Date birthday;
    private char gender = '\0';
    
    private static final String emailFormat = "^[A-Za-z.]+@[A-Za-z.]+$";
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
        
        System.out.println(nameArray[0]);
        System.out.println(nameArray[1]);



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

    private boolean valiDate(Date date) throws IllegalAccessException {
        Date today = new Date();

        if(today.before(date)) {
            //if(throwExeption)
            throw new IllegalArgumentException("Cannot set a future date");
        }
        
        return true;
    }

    public void setBirthday(Date birthday) throws IllegalAccessException {
        valiDate(birthday);
        this.birthday = birthday;
    }

    private boolean validateGender(char genderInput, boolean throwExeption) {
        // if (genderInput == 'm' || genderInput == 'f') {
        //     genderInput = Character.toUpperCase(genderInput);
        // }

        if (genderInput != 'M' || genderInput != 'F') {
            if (throwExeption)
                throw new IllegalArgumentException("The gender can only be F or M.");
            
            return false;
        }

        return true;
    }

    public void setGender(char gender) {
        validateGender(gender, true);
        this.gender = gender;
    }


    public static void main(String[] args) {

        Person person = new Person();
        person.setEmail("ola.nordmann@ntnu");

    }

    @Override
    public String toString() {
        return "Person [Email=" + email + ", birthday=" + birthday + ", name=" + name + ", gender=" + gender + "]";
    }

}
