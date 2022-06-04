package eksamenOving.kode.kont2021.task5to8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class RealtorComparator {
 
    /**
     *
     * @return a comparator that sorts Realtor objects based on the highest bid they
     *         have received on any of their properties from highest to lowest
     *
     *         Example output with a list of one "realtor1" with two properties,
     *         property1 with highest bid 1000, and property2 with highest bid 2000,
     *         and a second "realtor2" with one property with the highest bid of
     *         500, and a third "realtor3" with one property with the highest bid of
     *         3000 would yield the following result
     *
     *         realtor3
     *         realtor1
     *         realtor2
     *
     *         I.e: This sorts by the highest, single sale, and not the total of
     *         sales for each realtor.
     *
     *
     */
    public static Comparator<Realtor> sortRealtorsByHighestBidReceived() {
        return new Comparator<Realtor>() {
            public int compare(Realtor a, Realtor b) {
                int aHighest = 0;
                int bHighest = 0;
                for(Property property : a) {
                    int bid = property.getHighestBid();
                    if(bid > aHighest) aHighest = bid;
                }
                for(Property property : b) {
                    int bid = property.getHighestBid();
                    if(bid > bHighest) bHighest = bid;
                }

                return bHighest - aHighest;
            }
        };
    }
 
    public static void main(String[] args) {
        // This may not yield the correct results if Property/BusinessProperty/Realtor
        // has not been correctly implemented
        Realtor realtor = new Realtor("test1", 10);
        Realtor realtor2 = new Realtor("test2", 10);
        Property p = new BusinessProperty("name", 1500);
        p.bidReceived("BIDDER", 2000);
        Property p2 = new BusinessProperty("name2", 1000);
        p2.bidReceived("BIDDER", 1500);
        realtor.addProperty(p);
        realtor2.addProperty(p2);
        List<Realtor> realtors = Arrays.asList(realtor2, realtor);
        System.out.println(realtors);
        Collections.sort(realtors, sortRealtorsByHighestBidReceived());
        // A more useful to string method or using the debugger might be helpful here
        // Should be in the opposite direction with realtor, and then realtor2
        System.out.println(realtors);
 
    }
 
}
