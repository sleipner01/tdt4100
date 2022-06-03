package eksamenOving.kode.kont2021.task5to8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Property {

	// Add any needed fields here
    private String name;
    private int price;
    private boolean isSold;
    private List<Bid> bids;
    private HashMap<Integer, List<Bid>> listeners;

    private final int ALL = 0;
    private final int HIGHEST = 1; 

	/**
	 * 
	 * @param name  the name of the property to be sold
	 * @param price the listing price of the property
	 */
	public Property(String name, int price) {
		this.name = name;
        this.price = price;
        this.bids = new ArrayList<>();
        
        this.listeners = new HashMap<>();
        this.listeners.put(ALL, new ArrayList<>());
        this.listeners.put(HIGHEST, new ArrayList<>());
	}

	/**
	 * 
	 * @return the name of the property
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return the price of the property
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @return whether the property is sold, default value is false
	 */
	public boolean isSold() {
		return this.isSold;
	}

	/**
	 * Sets the property as sold
	 * 
	 * @throws IllegalStateException if no bids have been received
	 */
	public void setIsSold() {
        if(this.getNumberOfBids() <= 0) throw new IllegalArgumentException("No bids recieved");
		this.isSold = true;
	}

	/**
	 * 
	 * @return the number of bids received on this property
	 */
	public int getNumberOfBids() {
		return this.bids.size();
	}

	/**
	 * 
	 * @param listener register listener to be notified of any bids to this property
	 */
	public void addListenerForAllBids(BidListener listener) {
		// TODO
	}

	/**
	 * 
	 * @param listener register listener to be notified of only bids that are new
	 *                 highest bids You do not need to handle the case where a
	 *                 listener gets registered both for highest bid and for all
	 *                 bids
	 */
	public void addListenerForHighestBids(BidListener listener) {
		// TODO
	}

	/**
	 * 
	 * @param listener removes listener from this property, registered with any of
	 *                 the above methods
	 */
	public void removeListener(BidListener listener) {
		// TODO
	}

	/**
	 * Creates a new bid object and notifies all listeners that a bid has been given
	 * 
	 * @param bidder the name of the bidder
	 * @param bid    the amount of the bid
	 * 
	 * @throws IllegalStateException - if the property is already sold
	 */
	public void bidReceived(String bidder, int bid) {
		// TODO
	}

	/**
	 * Notifies listeners that a bid has been received. There are currently no
	 * listeners implemented in the main method, but this is used for test purposes
	 * by us after the exam.
	 * 
	 * This is package private for testing purposes
	 * 
	 * @param bid the most recent bid
	 */
	void notifyListeners(Bid bid) {
		// TODO
	}

	/**
	 * 
	 * @return the current highest bid. If the property has no bids, return 0
	 */
	public int getHighestBid() {
		// TODO
		return 0;
	}

	public static void main(String[] args) {
		Property p = new Property("name", 1000);
		p.bidReceived("BIDDER", 500);
		// 500
		System.out.println(p.getHighestBid());
		p.bidReceived("BIDDER2", 1100);
		// 1100
		System.out.println(p.getHighestBid());
		// false
		System.out.println(p.isSold());
		p.setIsSold();
		// true
		System.out.println(p.isSold());

	}
}