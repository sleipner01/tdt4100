package eksamenOving.kode.kont2021.task5to8;

public class Bid {
	
	private int bid;
	private Property property;
	private String bidder;
	
	public Bid(String bidder, Property property, int bid) {
		this.bid = bid;
		this.property = property;
		this.bidder = bidder;
	}

	public int getBid() {
		return bid;
	}

	public Property getProperty() {
		return property;
	}

	public String getBidder() {
		return bidder;
	}
	
	public boolean equals(Object otherBid) {
		
		if (otherBid instanceof Bid) {
			Bid bid2 = (Bid) otherBid;
			boolean isBidEqual = this.bid == bid2.bid;
			boolean isPropertyEqual = this.property.getName().equals(bid2.property.getName());
			boolean isBidderEqual = this.bidder.equals(bid2.bidder);
			boolean isEqual = isBidEqual &&  isPropertyEqual && isBidderEqual;
			return isEqual;
		}
		return false;

	}
	
	public String toString() {
		return this.property.getName() + bid;
	}
	

}
