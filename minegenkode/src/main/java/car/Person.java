package car;

public class Person {
    
    private String firstName;
    private String surName;
    private int age;
    private boolean hasLicence;

    public Person(String firstName, String surName, int age) {
        this();
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    public Person() {
        System.out.println("Setting initial values");
        this.firstName = "Jack";
        this.surName = "Smith";
        this.age = 18;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        Person person1 = new Person();
        System.out.println(person1);

        System.out.println();
        System.out.println();

    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", firstName=" + firstName + ", hasLicence=" + hasLicence + ", surName=" + surName
                + "]";
    }

}
