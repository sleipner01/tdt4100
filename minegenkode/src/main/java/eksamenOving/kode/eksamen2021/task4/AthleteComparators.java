package eksamenOving.kode.eksamen2021.task4;

import java.util.Comparator;
import java.util.List;

public class AthleteComparators {
 
    /**
     * @return a comparator that compares athletes based on their name. Using this
     *          comparator, Ane should come before Berit
     */
    public static Comparator<Athlete> getSimpleComparator() {
        return (a, b) -> { return b.getName().compareTo(a.getName()); };
    }
 
    /**
     * @return A comparator that compares athletes based on the number of medals of
     *          different valour. The comparator will be used for sorting athletes
     *          based on putting the athlete with the highest number of medals of the best valour
     *          first.
     *
     *          If one athlete has more "Gold" medals than the other athlete it
     *          should come before that one. If they have equal number of "Gold"
     *          medals they should be compared on the number of "Silver" medals, and
     *          if that is equal on the number of "Bronze" medals. If they have the
     *          same number of medals of all valour, they should be compared based
     *          on the name similar to getSimpleComparator
     *         
     *          The spelling and order of the medals can be seen in the list validMetals in the Medal class.
     */
    public static Comparator<Athlete> getAdvancedComparator() {
        return (a, b) -> {
            List<Medal> aMedals = a.getMedals();
            List<Medal> bMedals = b.getMedals();

            for (String metal : Medal.validMetals) {
                int aMedals2 = (int) aMedals.stream().filter(medal -> medal.getMetal().equals(metal))
                        .count();
                int bMedals2 = (int) bMedals.stream().filter(medal -> medal.getMetal().equals(metal))
                        .count();
                if (aMedals2 != bMedals2) {
                    return bMedals2 - aMedals2;
                }
            }

            // int aGold = 0;
            // int bGold = 0;
            // aGold = (int)aMedals.stream().filter(medal -> medal.getMetal().equals(Medal.validMetals.get(0))).count();
            // bGold = (int)bMedals.stream().filter(medal -> medal.getMetal().equals(Medal.validMetals.get(0))).count();
            
            // if(bGold > aGold) return 1;
            // else if (bGold < aGold) return -1;


            // int aSilver = 0;
            // int bSilver = 0;
            // aSilver = (int)aMedals.stream().filter(medal -> medal.getMetal().equals(Medal.validMetals.get(1))).count();
            // bSilver = (int)bMedals.stream().filter(medal -> medal.getMetal().equals(Medal.validMetals.get(1))).count();

            // if(bSilver > aSilver) return 1;
            // else if (bSilver < aSilver) return -1;


            // int aBronze = 0;
            // int bBronze = 0;
            // aBronze = (int)aMedals.stream().filter(medal -> medal.getMetal().equals(Medal.validMetals.get(2))).count();
            // bBronze = (int)bMedals.stream().filter(medal -> medal.getMetal().equals(Medal.validMetals.get(2))).count();

            // if(bBronze > aBronze) return 1;
            // else if (bBronze < aBronze) return -1;

            return b.getName().compareTo(a.getName());
        };

    }
}
