package uke2;

public class KaffeMater {

    public void serverKaffe(Person person) {
        while (person.nokKaffe() == false) {
            person.drikkKaffe();
        }
    }

    public static void main(String[] args) {
        System.out.println("Inni main i KaffeMater");
        KaffeMater km = new KaffeMater();
        Person person = new Person("Idunn");
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        km.serverKaffe(person);
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
    }
}
