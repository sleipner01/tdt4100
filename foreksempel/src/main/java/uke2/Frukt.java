package uke2;

public class Frukt {
    
double antall;
String type;


public Frukt(String type, double antall) {
    this.antall = antall;
    this.type = type;
}



public double getAntall() {
    return antall;
}

public String getType() {
    return type;
		
}

public static void main(String[] args) {
    Frukt f1 = new Frukt("Appelsin", 2);
		Frukt f2 = new Frukt("Banan", 1);
		System.out.println("Skrive ut objektreferanser:"); 
		// Følgende to utskrifter ser ikke helt bra ut. Det skrives ut hvilket objekt hver variabel er.
		// Legg merke til at begge er uke2.Frukt. Kjør programmet en gang til, og se at tegnene etter @ endrer seg.
		System.out.println(f1); 
		System.out.println(f2);

		System.out.println("Skrive ut objektinnhold.");
		// For å se det faktiske inneholdet av objektene må vi spørre etter dem (vi kan også gjør frukten mer presentabel, men det blir senere!)
		System.out.println(f1.getType() + " : "+f1.getAntall());
		System.out.println(f2.getType() + " : "+f2.getAntall());
	
}

}
