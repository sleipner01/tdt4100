package uke13.arv.bok_feil;


/**
 * Poenget med denne klassen er å belyse problemstillingen gitt i nest siste lysark
 * Ordbok sin konstruktør kaller super sin konstruktør
 * Super sin konstruktør kaller isValidTitle
 * isValidTitle er overskygget i Ordbok, så denne vil brukes i stedet
 * Ordbok.isValidTitle refererer til et felt i Ordbok, men dette er ikke satt ennå,
 * fordi vi fremdeles er i fasen der super() lages. Rot!
 */
public class Ordbok extends Bok {

    int antallOrd;
    String tittelslutt = "ordbok"; // Dette kunne ha vært viktig!


    
    public Ordbok(String title) {
        super(title);
        System.out.println("Ordbok.Constructor etter super.Constructor");

    }

    public void setAntallOrd(int antallOrd) {
        this.antallOrd = antallOrd;
    }
    
    @Override
    boolean isValidTitle(String title) {
        System.out.println("Ordbok.isValidTitle");
        if (super.isValidTitle(title))
            if (title.endsWith(tittelslutt))
                return true;
        return false;
    }

}
