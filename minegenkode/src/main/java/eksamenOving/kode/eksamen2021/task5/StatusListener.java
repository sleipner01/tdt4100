package eksamenOving.kode.eksamen2021.task5;

public interface StatusListener {
     
    /**
     *
     * @param username The username of the user
     * @param oldStatus The old status of the user
     * @param newStatus The new status of the user
     */
    public void statusChanged(String username, String oldStatus, String newStatus);
 
}
