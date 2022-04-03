package uke13.arv.bok;

public class Ordbok extends Bok{
    
    int antallOrd;

    public Ordbok() {
        super();
    }

    public Ordbok(String tittel, int antallOrd) {
        super(tittel);
        this.antallOrd = antallOrd;
    }

    public void setAntallOrd(int antallOrd) {
        this.antallOrd = antallOrd;
    }

    public int getAntallOrd() {
        return antallOrd;
    }
    
    // Skygger over Bok.getToStringAttributes(), men bruker den!
    protected String getToStringAttributes() {
		return super.getToStringAttributes() + ", antallOrd=" + antallOrd;
	}

    public static void main(String[] args) {

        Bok bok = new 

        Bok bok = new Ordbok();
        bok.setTittel("Lawrence of Arabia");
        System.out.println(bok); 

        Ordbok ordbok = new Ordbok("Nynorsk ordbok", 654);
        System.out.println(ordbok);
    }
}
