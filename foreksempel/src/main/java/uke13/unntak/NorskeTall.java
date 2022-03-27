package uke13.unntak;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NorskeTall {

	private int value, tenvalue, onevalue;

	List<String> validTens = new ArrayList<>(Arrays.asList("tjue","tretti","førti","femti","seksti","sytti","åtti","nitti","hundre"));
	List<String> validOnes = new ArrayList<>(Arrays.asList("null","en","to","tre","fire","fem","seks","sju","åtte","ni"));
	List<String> validSpecial = new ArrayList<>(Arrays.asList("ti","elleve","tolv","tretten","fjorten","femten","seksten","sytten","atten","nitten"));


	public int getValue() {
		return value;
	}

	private void parseInput(String streng) {

		// Sjekker for tall mellom 11 og 19 først
		if (validSpecial.contains(streng)) {
			value = validSpecial.indexOf(streng) + 10;
			return;
		}

		// Sjekker for tall under 10, dvs 0 - 9
		if (validOnes.contains(streng)) {
			value = validOnes.indexOf(streng);
			return;
		}

		// Sjekker for hele tiere
		if (validTens.contains(streng)) {
			value = (validTens.indexOf(streng)+2)*10;
			return;
		}

		// SÅ kommer det vanskelige: sjekke substrenger.
		// Det vi vet: strengen MÅ inneholde en valid ener og en valid tier.
		// Vi må også sjekke for om strengen inneholder noe mer enn bare det...

		parseTensAndOnes(streng);
	}


	private void parseTensAndOnes(String streng) {
		// Sjekke først for tiere
//		System.out.println("Sjekker "+streng);
		for (int i = 0; i < validTens.size(); i++) {
			if (streng.contains(validTens.get(i)))  {// har tieren
//				System.out.println("Funnet tier: "+(i*10+20));
				tenvalue = i*10+20;

				// Så må vi fjerne substring av tiere fra hele strengen, 
				// hvis ikke utløses femtito av sjekk på fem.
				streng = streng.replace(validTens.get(i), "");
				break;
			}
		}
		// så sjekker vi enerne.
		for (int i = 0; i < validOnes.size(); i++) {
			if (streng.contains(validOnes.get(i)))  {// har eneren
//				System.out.println("Funnet ener: "+i);
				onevalue = i;
				break;
			}
		}

		if (onevalue == 0 && tenvalue == 0)
			throw new NorskeTallException("Feil med tiere og enere: "+streng);
		else if (onevalue == 0)
			throw new NorskeTallException("Feil med enere: "+streng);
		else if (tenvalue == 0)
			throw new NorskeTallException("Feil med tiere: "+streng);

		// Oppdatere der det er funnet både tiere og ener:
		value = tenvalue+onevalue;
	}



	public void sjekkTall(String streng) {
		this.parseInput(streng);
	}


	public NorskeTall(String streng) {
		parseInput(streng);
	}

	public static void main(String[] args) {

		
		System.out.println(new NorskeTall("nittisju").getValue());
		System.out.println(new NorskeTall("tretten").getValue());
		System.out.println(new NorskeTall("åtte").getValue());
		System.out.println(new NorskeTall("tjue").getValue());
		System.out.println(new NorskeTall("tjuetre").getValue());

		// Så de med feil:
		// System.out.println(new NorskeTall("firefire").getValue()); 
		// System.out.println(new NorskeTall("førtisytten").getValue());
		// System.out.println(new NorskeTall("fjørtifjire").getValue());



	}
}
