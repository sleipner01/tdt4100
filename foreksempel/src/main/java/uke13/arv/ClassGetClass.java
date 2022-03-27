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
			// Linjen over returnerer _klasseobjektet_, ikke en instans av klassen.
			cls = Class.forName("uke13.arv.Bok");
			System.out.println("Class found= "+ cls.getName());
			System.out.println("Package found= "+ cls.getPackage());

			// Det under brukes gjerne i 'reflective programming', som ikke er en viktig ting dette kurset
			Method[] methods = cls.getMethods();
			for (Method method : methods) {
				// System.out.println(method);
			}

			// Dette under er ikke pensum, men tenker det kan være med å klargjøre hva vi snakker om:
			// Vi kan bruke dette til blant annet å instansiere objekter ved kjøretid. Også for 'reflection'
			System.out.println("Antall konstruktører i Bok: "+cls.getConstructors().length); 
			System.out.println("Den første konstruktøren: "+cls.getConstructors()[0]); 
			Bok bok = (Bok) cls.getConstructors()[0].newInstance("Tittel");
			System.out.println("Bok: "+bok);

		} catch (ClassNotFoundException | IllegalArgumentException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
