package eksamenOving.kode.kont2020.stuff;

import java.util.Collection;
import java.util.function.Predicate;

public class MovieRegister {


	// Add internal variables
	
	/**
	 * Add movie to register
	 * @param movie
	 */
	public void addMovie(Movie movie) {
	}
		
	/**
	 * 
	 * @param title
	 * @return the movie with matching title, or null if no such movie exists.
	 */
	Movie findMovie(String title) {
		return null; // dummy return value
	}
	
	/**
	 * Filter all registered movies based on a Predicate, and return them as a Collection.
	 * @param pred is the filter for which movies to watch
	 * @return A collection of movies testing true to pred.
	 */
	Collection<Movie> filterMovies(Predicate<Movie> pred) {
		return null; // dummy return value
	}
	
	/**
	 * Watch movie 'title'.
	 * @param title
	 * @throws IllegalStateException if the title does not exist.
	 */
	public void watch(String title) {
	}
	
	/**
	 * Small example of use of the class. Does NOT necessarily cover all uses of methods specified in assignment. 
	 * @param args
	 */
	public static void main(String[] args) {
		
//		MovieRegister cb = new MovieRegister();
//		cb.addMovie(new Movie("Das Boot"));
//		cb.watch("Das Boot");
//		System.out.println("Should be 1: " + cb.findMovie("Das Boot").getTimesWatched());
		
	}

}
