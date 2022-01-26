package oving2;

import java.util.Date;

public class Person {

    private String name;
    private String Email;
    private Date birthday;
    private char sex;


    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.Email;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public char getSex() {
        // if (sex == '\0') return '\0';
        return this.sex;
    }

    private boolean validateName(String name, boolean throwExeption) {
    
        return true;
    }

    public void setName(String name, boolean throwExeption) {
        validateName(name, throwExeption);
        this.name = name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    private boolean valiDate(Date date, boolean throwExeption) {
        Date today = new Date();

        if(today.before(date)) {
            if(throwExeption)
                throw new IllegalArgumentException("Cannot set a future date");

            return false;
        }
        
        return true;
    }

    public void setBirthday(Date birthday, boolean throwExeption) {
        valiDate(birthday, throwExeption);
        this.birthday = birthday;
    }

    private boolean validateSex(char sex, boolean throwExeption) {

        if (sex != 'M' || sex != 'F') {
            if (throwExeption)
                throw new IllegalArgumentException("The gender can only be F or M.");
            
            return false;
        }

        return true;
    }

    public void setSex(char sex) {
        validateSex(sex, true);
        this.sex = sex;
    }


    public static void main(String[] args) {
        
    }

    @Override
    public String toString() {
        return "Person [Email=" + Email + ", birthday=" + birthday + ", name=" + name + ", sex=" + sex + "]";
    }

}
