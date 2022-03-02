package uke9.personpredicate;

//interface 
import java.util.*; 

class Person { 
	String fornavn; 
	String etternavn;
	int age; 
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return etternavn + " " + fornavn;
	}
	
	// Constructor 
	public Person(String fornavn, String etternavn, int alder) 
	{ 
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.age = alder; 
	} 
	
	public String toString() 
	{ 
		return this.fornavn + " " + this.etternavn + "\t"+ this.age; 
	}
	
	
	public static void main (String[] args) 
	{ 
		ArrayList<Person> personer = new ArrayList<Person>(); 
		personer.add(new Person("Jens", "Hansen", 12)); 
		personer.add(new Person("Ida", "Hansen", 33)); 
		personer.add(new Person("Småen", "Sund", 3)); 
		personer.add(new Person("Karl", "Stiansen", 32)); 
		personer.add(new Person("Karoline", "Sund", 17)); 
		personer.add(new Person("Karolinus", "Sund", 17)); 
		personer.add(new Person("Farfar", "Sund", 133)); 
		
		// Skrive ut alle personer over 17 år:
		for (Person person : personer) {
			if (person.getAge() > 17) {
				System.out.println(person);
			}
		}
	}
	
} 

