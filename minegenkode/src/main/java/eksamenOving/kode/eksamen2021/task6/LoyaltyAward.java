package eksamenOving.kode.eksamen2021.task6;

import eksamenOving.kode.eksamen2021.task5.LoyaltyUser;

public abstract class LoyaltyAward {
 
    private String awardName;
 
    public LoyaltyAward(String awardName) {
        this.setAwardName(awardName);
    }
 
    /**
     * Updates the name of the award
     * @param awardName the new award name
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
 
    /**
     * Adds the points to the given loyalty user.
     *
     * @param points      The points to award to the user
     * @param loyaltyUser The user that rented the car
     */
 
    public void awardPoints(int points, LoyaltyUser loyaltyUser) {
        loyaltyUser.addPoints(points);
    }
}
