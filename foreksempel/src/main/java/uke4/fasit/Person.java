package uke4.fasit;

/**
 * En veldig enkel Personklasse. Den har bare navn og alder, og gettere den trenger.
 * Den er derimot spennende når en ser på at den har tre konstruktører - der den ene 
 * bruker den andre, som igjen bruker den tredje.
 */
public class Person {

	String name;
	int age;
	
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}

	/**
	 * Konstruktører er fine - og en kan ha mange av dem. 
	 * en kan ha flere av dem. Det vanlige er å la ÉN av dem faktisk lage
	 * objektet, mens de andre peker til denne ved hjelp av this(). 
     * I dette eksempelet kaller konstruktøren med to parametre i bruk først
     * konstruktøren som kaller med én parameter, før den setter den siste.
     * Konstruktøren med én parameter kaller den uten parametre først, før
     * den setter sitt eget felt. 
     * 
     * Når jeg gjør det på denne måten kan man ha verifikasjon av stuff på et
     * passende sted, og slippe å ha ting flere steder.
     * 
     * this(), altså kall av en annen konstruktør, i samme klasse. Det MÅ skje på første linje i
     * konstruktøren. Dette er akkurat likt som når en kaller super().
     * 
	 */

	public Person(String name, int age) {
        this(name);
		this.age = age;
        System.out.println("Person: Inni 2 parameters konstruktør");
	}

	public Person(String name) { // Hvis ikke alder er nevnt, 0 år.
        this(); // Vi har ikke noen alder, sant? Da settes en standard i konstruktøren uten parametre. 
        this.name = name;
		System.out.println("Person: Inni 1 parameters konstruktør");
	}

	// Defaultverdier når en ikke spesifiserer noe.
	public Person() { 
		System.out.println("Person: Inni 0 parameters konstruktør");
		this.name = "Kari Nordmann";
		this.age = 0;
	}


	public static void main(String[] args) {
		Person p = new Person("Per",23);
		System.out.println(p.toString());
		System.out.println(new Person()); 
        /* På grunn av måten konstruktørene er laget her, så bør følgende nye Person
        ende opp med å skrive ut 0, 1, så 2 som konstruktørrekkefølge. Det er fordi
        vi kaller 2->1 og 1->0 FØR vi skriver ut at vi er inni konstruktørene.
        */

	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
