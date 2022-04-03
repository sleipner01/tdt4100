package uke13.arv;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ClassGetClass {

	

	public ClassGetClass() {
		System.out.println("Jeg er laget!");
	}

	public static void main(String[] args)  {

		Class cls;
		try {

			// GetClass()
			ClassGetClass cgc = new ClassGetClass();
			cls = cgc.getClass();
			System.out.println("class: "+cls);
			System.out.print("cls == ClassGetClass.class: ");
			System.out.println(cls == ClassGetClass.class);
			System.out.println("cls == Object.class: "+cls.equals(Object.class));

			// Hva er forskjellen med denne og den over?
			System.out.print("cgc instanceof ClassGetClass: ");
			System.out.println(cgc instanceof ClassGetClass);
			System.out.print("cgc instanceof Object: ");
			System.out.println(cgc instanceof Object);
			
			// Forskjellen er at instanceof også returnerer true for en subklasse. 


			// Linjen over returnerer _klasseobjektet_, ikke en instans av klassen.
			cls = Class.forName("uke13.arv.bok.Bok");
			System.out.println("Class found= "+ cls.getName());
			System.out.println("Package found= "+ cls.getPackage());

			// Det under brukes gjerne i 'reflective programming', som ikke er en viktig ting dette kurset
			Method[] methods = cls.getMethods();
			for (Method method : methods) {
				// System.out.println(method);
			}

			// Dette under er ikke viktig pensum, men tenker det kan være med å klargjøre hva vi snakker om:
			// Vi kan bruke dette til blant annet å instansiere objekter ved kjøretid. Også for 'reflection'
			System.out.println("Antall konstruktører i Bok: "+cls.getConstructors().length); 
			System.out.println("Den første konstruktøren: "+cls.getConstructors()[1]); 
			var bok = (uke13.arv.bok.Bok) cls.getConstructors()[1].newInstance("Tittel");
			System.out.println("Bok: "+bok);


		} catch (ClassNotFoundException | IllegalArgumentException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
