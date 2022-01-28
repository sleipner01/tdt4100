package oving2;

import java.util.Date;

public class Person {

    private String name;
    private String Email;
    private Date birthday;
    private char gender = '\0';


    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.Email;
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

    public void setEmail(String Email) {
        this.Email = Email;
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

    }

    @Override
    public String toString() {
        return "Person [Email=" + Email + ", birthday=" + birthday + ", name=" + name + ", gender=" + gender + "]";
    }

}
