package eksamenOving.kode.kont2020.stuff;

//import static org.junit.jupiter.api.Assertions.assertEquals;

public class Movie {

	// See the README file for a description of what is required for this file.

	private String title;
	private int timesWatched;
	private Integer rating;

	public Movie(String title) {
		if(title == null)
			throw new IllegalArgumentException("Has to be something");
		this.title = title;

		this.timesWatched = 0;
	}

	public String getTitle() {
		return this.title;
	}

	public void watch() {
		this.timesWatched++;
	}

	public int getTimesWatched() {
		return this.timesWatched;
	}

	public Integer getRating() {
		return this.rating;
	} 

	public void setRating(Integer rating) {
		if(rating < 1 || rating > 6)
			throw new IllegalArgumentException("Rating has to be between 1 and 6, or null");
		this.rating = rating;
	}

	public static void main(String[] args) {

		Movie db = new Movie("Das Boot");
		//assertEquals(0, db.getTimesWatched());
		//assertEquals("Das Boot", db.getTitle());
		
		db.watch();
		//assertEquals(1, db.getTimesWatched());
		
		//assertEquals(null, db.getRating());
		db.setRating(4);
		// assertEquals(4, (int)db.getRating());
	}

}
