package uke13.arv;

public class UnderstandEquals {

	String streng;
	
	public UnderstandEquals(String ting) {
		this.streng = ting;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((streng == null) ? 0 : streng.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnderstandEquals other = (UnderstandEquals) obj;
		if (streng == null) {
			if (other.streng != null)
				return false;
		} else if (!streng.equals(other.streng))
			return false;
		return true;
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
