package eksamenOving.kode.kont2021.task5to8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
 
public class Realtor implements Iterable<Property> {
 
    private String name;
    private double commission;
    private Collection<Property> pendingSales;

    /**
     * Creates a Realtor object
     *
     * @param name       the name of the realtor
     * @param commission the commission the realtor takes for a sale
     */
    public Realtor(String name, double commission) {
        this.name = name;
        this.setCommission(commission);
        this.pendingSales = new ArrayList<>();
    }
 
    /**
     *
     * @return the name of the realtor
     */
    public String getName() {
        return this.name;
    }
 
    /**
     *
     * @param commission the new commission of the realtor
     *
     * @throws IllegalArgumentException if the commission not between (excluding) 0
     *                                  and (including) 100.
     */
    public void setCommission(double commission) throws IllegalArgumentException {
        if(!(0 < commission && commission <= 100))
            throw new IllegalArgumentException("wrong value");

        this.commission = commission;
    }
 
    /**
     * Adds a property to the realtor's sale collection
     *
     * @param property a property
     */
    public void addProperty(Property property) {
        if(this.pendingSales.contains(property)) return;
        this.pendingSales.add(property);
    }
 
    /**
     * The total commission is calculated as the sum of the highest bid of each sold
     * property times the commission rate. The commission rate is calculated based
     * on the realtor's current commission rate and does not need to consider
     * historical commission rates
     *
     * A realtor with commission of 10 %, and two sold properties sold at 1000 each,
     * would have a total commission value of 200
     *
     * @return the calculated commission of the realtor
     */
    public double calculateTotalCommission() {
        Iterator<Property> iterator = this.iterator();
        int sum = 0;

        while(iterator.hasNext()) {
            Property next = iterator.next();
            if(next.isSold()) sum += (next.getHighestBid() * (this.commission/100));
        }

        return sum;
    }
 
    @Override
    public Iterator<Property> iterator() {
        return new Iterator<Property>() {
            private List<Property> properies = new ArrayList<>(pendingSales);
            private int index;

            public boolean hasNext(){
                if(index < properies.size()) return true;
                return false;
            }

            public Property next(){
                if(!hasNext()) return null;
                return properies.get(index++);
            }
        };
    }
 
    /**
     *
     * @return an iterator to be able to iterate through all the properties of this
     *         realtor
     */
    public Iterator<Property> iterable() {
        return this.iterator();
    }
 
    public static void main(String[] args) {
        Realtor realtor = new Realtor("test", 10);
        // The following will only work if BusinessProperty and Property has the correct
        // implementation
        Property p = new Property("name", 1500);
        p.bidReceived("BIDDER", 2000);
        p.setIsSold();
        realtor.addProperty(p);
        // Should be 200
        System.out.println(realtor.calculateTotalCommission());
    }
 
}