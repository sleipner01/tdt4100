package arv;

public class ClassGetClass {

	public static void main(String[] args) {

		Class cls;
		try {
			cls = Class.forName("arv.ClassGetClass");
			System.out.println("Class found= "+ cls.getName());
			System.out.println("Package found= "+ cls.getPackage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
