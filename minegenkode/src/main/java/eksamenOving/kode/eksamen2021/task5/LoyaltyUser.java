package eksamenOving.kode.eksamen2021.task5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
 
public class LoyaltyUser {
    private String username;
    private int points;
    private String status;
    public static List<String> validStatuses = Arrays.asList("Basic", "Gold", "Silver", "Platinum");
    // TODO - Add any extra needed fields here
    private HashMap<StatusListener, String> listeners = new HashMap<>();
 
    public LoyaltyUser(String username) {
        this.username = username;
        this.status = "Basic";
    }
 
    public String getUsername() {
        return this.username;
    }
 
    public int getPoints() {
        return this.points;
    }
 
    public String getStatus() {
        return this.status;
    }
 
    /**
     * Adds point to this user
     * @param points the points to add. Can also be a negative number
     */
    public void addPoints(int points) {
        this.points += points;
        this.checkForStatusUpgrade();
    }
 
    /**
     * Checks whether the user qualifies for a status upgrade/downgrade.
     *
     * TODO: If the user qualifies for a new status all observers interested in the new or old
     * status should be notified
     */
    public void checkForStatusUpgrade() {
        String oldStatus = this.status;

        if (this.points <= 1000) {
            this.status = "Basic";
        }
        if (this.points > 1000) {
            this.status = "Silver";
        }
        if (this.points > 5000) {
            this.status = "Gold";
        }
        if (this.points > 10000) {
            this.status = "Platinum";
        }

        if(!oldStatus.equals(this.status)) fireStatusChanged(oldStatus, this.status);
    }
 
    /**
     * Adds a listener that listens on when this specific status is obtained or
     * lost. If the user has been previously added, the old status should be
     * overridden and the listener should listen on the new status
     *
     * @param listener The listener that will observe
     *
     * @param status   The status the listener will listen to
     *
     * @throws IllegalArgumentException If the status is not valid
     */
    public void addListener(StatusListener listener, String status) {
        if(!validStatuses.contains(status)) throw new IllegalArgumentException("Not a valid status");
        
        if(listeners.containsKey(listener)) listeners.replace(listener, status);
        else listeners.put(listener, status);
    }
 
    /**
     * Remove the listener
     *
     * @param listener The listener to remove
     */
    public void removeListener(StatusListener listener) {
        listeners.remove(listener);
    }
 
    /**
     * Updates all listeners that were interested in either the old or the new
     * status that the status of the user has changed. Observers should only be
     * notified if oldStatus and newStatus is different
     *
     * @param oldStatus The old status of the user
     *
     * @param newStatus The new status of the user
     */
    private void fireStatusChanged(String oldStatus, String newStatus) {
        for(StatusListener listener : listeners.keySet()) {
            if(listeners.get(listener).equals(oldStatus) || listeners.get(listener).equals(newStatus))
                listener.statusChanged(this.getUsername(), oldStatus, newStatus);
        }
    }
}
