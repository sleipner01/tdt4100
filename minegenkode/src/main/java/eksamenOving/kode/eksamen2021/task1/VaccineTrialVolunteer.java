package eksamenOving.kode.eksamen2021.task1;

public class VaccineTrialVolunteer {

    private String id;
    private boolean placebo;
    private boolean gotSick;
 
    public VaccineTrialVolunteer(String id, boolean placebo) {
        this.id = id;
        this.placebo = placebo;
    }
 
    public String getId() {
        return this.id;
    }
 
    /* Whether the volunteer was given a placebo or the actual vaccine */
    public boolean isPlacebo() {
        return this.placebo;
    }
 
    /* Whether the volunteer got sick during the trial period,
     * the default value for this should be false */
    public boolean gotSick() {
        return this.gotSick;
    }
 
    /*
     * Updates whether the participant got sick during the trial period
     */
    public void setGotSick(boolean gotSick) {
        this.gotSick = gotSick;
    }
 
}
 
 
