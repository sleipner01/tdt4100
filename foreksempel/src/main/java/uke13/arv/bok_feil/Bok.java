package uke13.arv.bok_feil;

public class Bok {
    
    String title;

    public Bok(String title) {
        System.out.println("Bok.Contructor");
        setTitle(title);
    }

    boolean isValidTitle(String tittel) {
        System.out.println("Bok.isValidtitle");
        if (tittel.equals("Invalid")) return false;
        return true;

    }

    public void setTitle(String tittel) {
        System.out.println("Bok.setTitle");
        if (isValidTitle(tittel))
            this.title = tittel;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static void main(String[] args) {
        // Bok bok = new Bok("Valid");
        // System.out.println(bok);

        Ordbok ordbok = new Ordbok("Tittel");
    }
}
