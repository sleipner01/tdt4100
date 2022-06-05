package eksamenOving.kode.eksamen2021.task1;

import java.util.ArrayList;
import java.util.List;

public class VaccineTrial {
 
    // Add any needed fields here
    private List<VaccineTrialVolunteer> volunteers = new ArrayList<>();
 
    /**
     * Adds a new VaccineTrialVolunteer to the trial
     *
     * @param id      The id of the volunteer
     *
     * @param placebo Whether the volunteer was given a placebo, or the actual
     *                vaccine
     */
 
    public void addVolunteer(String id, boolean placebo) throws IllegalArgumentException{

        for(VaccineTrialVolunteer tempVolunteer : volunteers)
            if(tempVolunteer.getId().equals(id)) throw new IllegalArgumentException("This ID is already in use");

        volunteers.add(new VaccineTrialVolunteer(id, placebo));
    }
 
    /**
     * Returns whether the vaccine's effectiveness rate is higher than the provided
     * limit. The effectiveness of the vaccine is calculated as follows:
     *
     * 1- (number of people that received the vaccine and got sick/
     *         number of people that got sick)
     *
     * If there is no sick people, the vaccine is not effective
     *
     * @param limit A limit to compare against
     *
     * @throws IllegalArgumentException If limit is not between (including) 0 and 1.
     *
     * @return Whether the vaccine effectiveness rate is higher than the limit
     */
    public boolean isMoreEffectiveThanLimit(double limit) {
        if(limit < 0 || limit > 1) throw new IllegalArgumentException("Limit has to be between 0 and 1");
 
        double gotSick = 0;
        double vaccineAndGotSick = 0;

        for(VaccineTrialVolunteer volunteer : volunteers) {
            if(volunteer.gotSick()) gotSick++;
            if(volunteer.gotSick() && (!volunteer.isPlacebo())) vaccineAndGotSick++;
        }
        
        double effectiveness = 1.0 - (gotSick / vaccineAndGotSick);
        return effectiveness > limit;
    }
 
    /**
     * Updates the sick state of a VaccineTrialVolunteer
     *
     * @param id The id of the volunteer to set sick.
     * @throws IllegalArgumentException if there is no volunteer with the given id
     */
    public void setSick(String id) {
        for(VaccineTrialVolunteer volunteer : volunteers) {
            if(volunteer.getId().equals(id)) {
                volunteer.setGotSick(true);
                return;
            }
        }

        throw new IllegalArgumentException("There exists no volunteer with this id");
    }
 
    /**
     * Get's the volunteer with the given ID
     *
     * @param id The id of the volunteer to set sick.
     *
     * @return The vaccine trial volunteer with the given ID. If the ID is not valid
     *         for any volunteer, return null
     */
    public VaccineTrialVolunteer getVolunteer(String id) {
        for(VaccineTrialVolunteer volunteer : volunteers) {
            if(volunteer.getId().equals(id)) return volunteer;
        }

        return null;
    }
 
}
