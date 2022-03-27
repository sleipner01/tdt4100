package uke13.arv;

// Records har ingen kostruktører, gettere eller settere. 
// Ingen verdier kan endres, det er kun lagring. OG den har
// automatisk likhetskontroll som sjekker alle felt.
public record Point(double x, double y) {
    
    public static void main(String[] args) {
        Point p1 = new Point(2.3,  3.4); 
		Point p2 = new Point(2.3,  3.7);
		
        // Records har automatisk sjekk av likhet for alle felt
        System.out.println("equal: "+p1.equals(p2));


        // Men dersom alle felt er like...
		Point p3 = new Point(2.3,  3.4);
        System.out.println("equal: "+p1.equals(p3));

    }
}
