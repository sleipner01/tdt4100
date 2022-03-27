package uke13.arv;

public class UnderstandEquals {

	String streng;
	
	public UnderstandEquals(String ting) {
		this.streng = ting;
	}

	public static void main(String[] args) {
		// Kommentarer for utvidelse nederst

		String s1 = new String("Hallo");
		String s2 = new String("Hallo");
		
		System.out.println(s1.equals(s2));
		
		UnderstandEquals u1 = new UnderstandEquals("Hallo");
		UnderstandEquals u2 = new UnderstandEquals("Hallo");
		
		System.out.println(u1.equals(u2));
		
		System.out.println(u1);
		System.out.println(u2);

	// Hva skjer hvis jeg lar editoren automatisk lage equals og hashcode?

	// Hva skjer hvis jeg overskriver toString?
		
	
		
	}


}
