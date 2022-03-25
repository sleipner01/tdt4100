package arv;

public class UnderstandEquals {

	String ting;
	
	public UnderstandEquals(String ting) {
		this.ting = ting;
	}

	
	
	public static void main(String[] args) {

	String s1 = new String("Hallo");
	String s2 = new String("Hallo");
	
	System.out.println(s1.equals(s2));
	
	UnderstandEquals u1 = new UnderstandEquals("Hallo");
	UnderstandEquals u2 = new UnderstandEquals("Hallo");
	
	System.out.println(u1.equals(u2));
	
	System.out.println(u1);
	System.out.println(u2);
		
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ting == null) ? 0 : ting.hashCode());
		return result;
	}


	// Hva skjer med sammenlikning av u1 og u2 når du fjerner denne?
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnderstandEquals other = (UnderstandEquals) obj;
		if (ting == null) {
			if (other.ting != null)
				return false;
		} else if (!ting.equals(other.ting))
			return false;
		return true;
	}


	// Prøv å fjerne denne metoden, se hva toString skriver ut da. Jo, Object sin!
	@Override
	public String toString() {
		// Prøv dette for moro skyld:
//		System.out.println(super.toString());
		return "UnderstandEquals [ting=" + ting + "]";
	}

}
