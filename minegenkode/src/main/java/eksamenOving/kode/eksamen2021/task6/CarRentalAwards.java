package eksamenOving.kode.eksamen2021.task6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import eksamenOving.kode.eksamen2021.task5.LoyaltyUser;
 
public class CarRentalAwards extends LoyaltyAward {
 
    private Map<Integer, Integer> carBrandToPoints;
    private List<String> validNames;
 
    public CarRentalAwards(String awardName) {
        super(awardName);
        this.carBrandToPoints = Map.of(1, 1, 2, 10, 3, 100, 4, 200, 5, 500);
    }
 
    @Override
    /**
     * Updates the award name
     * @param: awardName The name of the award
     *
     * @throws IllegalArgumentException If the award name is not part of the valid
     *                                  names
     */
    public void setAwardName(String awardName) {
        this.validNames = Arrays.asList("CarRentalAgency1", "CarRentalAgency2");
        if (!validNames.contains(awardName)) {
            throw new IllegalArgumentException("Invalid award name");
        }
        super.setAwardName(awardName);
    }
 
    /**
     * Updates the status of the given LoyaltyUser with points based on the map
     * above. The map means that carBrand 1 will award 1 points, carBrand 2 will
     * award 10 points etc
     *
     * @param carBrand:    The brand of the car the user has rented. If the brand
     *                     does not exist 0 points should be awarded
     *
     * @param loyaltyUser: The user that rented the car
     *
     *
     */
    public void awardPoints(int carBrand, LoyaltyUser loyaltyUser) {
        Integer points = carBrandToPoints.get(carBrand);
        if (points != null) {
            loyaltyUser.addPoints(points);
        }
    }
 
    public static void main(String[] args) {
        LoyaltyUser user = new LoyaltyUser("Name");
        // What goes wrong here
        LoyaltyAward award = new CarRentalAwards("CarRentalAgency1");
        // What goes wrong here
        award.awardPoints(1, user);
        System.out.println(user.getPoints());
    }
 
}
