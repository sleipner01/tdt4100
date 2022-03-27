package uke13.unntak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Feiltyper {


		// Diverse feiltyper!
	public static void main(String[] args) {


		// Nullpointerexception:
		// String foo = null;
		// int length = foo.length();   

		// Classcastexception:
		// Object i = Integer.valueOf(42);
		// String s = (String)i; 

		// Indexoutofboundserror:
		// List<String> ls=new ArrayList<>();
		//   ls.add("a");
		//   ls.add("b");
		//   ls.get(2);

		// nosuchelementexception:
		// List<String> ls = new ArrayList<>();
		// Iterator<String> it = ls.iterator();
		// System.out.println(it.next());

		// UnsupportedOperationException
		// String[] flowers = { "Ageratum", "Allium", "Poppy", "Catmint" }; 
		// List<String> flowerList = Arrays.asList(flowers);  // Hold musen over asList, den er fixed-size!
		// // List<String> flowerList = new ArrayList<>(Arrays.asList(flowers)); // Løsningen
		// // For en beskrivelse se feks https://www.javacodexamples.com/examples/why-does-arrays-aslist-return-a-fixed-size-list
		// flowerList.add("Celosia");
		// flowerList.forEach(System.out::println);


		// IllegalArgumentException:
		// Map<String, Integer> tempMap = Map.of(
		// 		"Ost",    13,
		// 		"Pølse",      19,
		// 		"Ost",    13, // !
		// 		"Bacalao",      14
		// );
	}

}
