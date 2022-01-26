// Fra forelesning uke4

package car;

import java.util.ArrayList;
import java.util.Collection;

public class Car {
    
    private Person driver;
    private Plate plate;
    private int numberOfSeats;
    private Collection<Person> passengers = new ArrayList();

    public Car(String sign, int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        this.plate = new Plate(sign);
        System.out.println(this);
    }

    public void setDriver(Person person) {
        if (person.getAge() > 17) {
            this.driver = person;
            System.out.println(person + "drives the car.");
        }
        else {
            System.out.println(person + "can't drive the car.");
        }
    }


    public void addPassenger(Person person) {
        if (this.passengers.size() == this.numberOfSeats -1)
            System.out.println("Fullt bitch");
        else this.passengers.add(person);
    }

    // public void removePassenger(Person person) {
    //     if(this.passengers.contains(person)) {
    //         this.passengers.remove(person);
    //         System.out.println(person + " was removed from the car.");
    //     }
    //     else System.out.println("This person is not in the car. Have you forgot him?");
    // }
    public void removePassenger(Person person) {
        if(this.passengers.remove(person)) System.out.println(person + " was removed from the car.");
        else System.out.println("This person is not in the car. Have you forgot him?");
    }
        

    public static void main(String[] args) {
        System.out.println();
        System.out.println();





        Car car = new Car("AA41383", 3);
        System.out.println(car);

        Person person1 = new Person();
        System.out.println(person1);

        car.setDriver(person1);
        System.out.println(car);

        Person person2 = new Person("Jakob", "Hasselhoff", 11);
        car.setDriver(person2);
        car.addPassenger(person2);

        Person person3 = new Person("Magnus", "Byrkjeland", 20);
        car.addPassenger(person3);

        Person person4 = new Person("Magnus", "Allison", 20);
        car.addPassenger(person4);

        car.removePassenger(person2);
        car.addPassenger(person4);
        



        System.out.println(car);



        System.out.println();
        System.out.println();
    }

    @Override
    public String toString() {
        return "Car [driver=" + driver + ", numberOfSeats=" + numberOfSeats + ", passengers=" + passengers + ", plate="
                + plate + "]";
    }

}
