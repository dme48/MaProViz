import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Coordinates the people and their dates in the Mating Problem Simulation. Creates a TODO
 * to represent visually the current state and refreshes it on each iteration.
 *
 * @author Diego Martínez
 */
public class MatingManager {
    private final int N;
    private final Man[] men;
    private final Woman[] women;
    private final Set<Man> unmarriedMen;
    private final Set<Woman> unmarriedWomen;

    /**
     * Creates N couples of Man and Woman instances
     * @param   N   number of couples in the simulation
     */
    public MatingManager(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }

        this.N = N;
        this.men = new Man[N];
        this.women = new Woman[N];
        this.unmarriedWomen = new HashSet<>();
        this.unmarriedMen = new HashSet<>();

        for (int n = 0; n < N; n++) {
            this.men[n] = new Man(n, N);
            this.women[n] = new Woman(n, N);
            this.unmarriedWomen.add(this.women[n]);
            this.unmarriedMen.add(this.men[n]);
        }
    }

    /**
     * Calculates the amount of married couples (for this problem married man == married women == married couples)
     * @return  integer representing the amount of current married couples.
     */
    public int howManyMarried() {
        return this.N - this.unmarriedWomen.size();
    }

    public boolean hasFinished() {
        return (this.unmarriedWomen.size() == 0);
    }

    /**
     * Takes the current married women into account to set the amount of men rejections.
     * @example:
     * A man M has a set of ordered preferences (a, b, c), so he proposes to woman a, who rejects him. This sets his
     * rejection count from 0 to 1. Now, in that same iteration, the woman b has married some other man. In this case,
     * our man M has been "automatically rejected" by the woman b, and he shouldn't propose to her. Hence his rejection
     * count must be increased until his intention is to propose to an unmarried woman. relaxMenRejections increases
     * this rejection count accordingly for every man in the men array.
     */
    private void relaxMenRejections() {
        for (Man man : this.unmarriedMen) {
            Woman nextWoman = this.women[man.currentlyProposesTo()];
            while (nextWoman.isMarried()) {
                man.reject();
                nextWoman = this.women[man.currentlyProposesTo()];
            }
        }
    }

    /**
     * For every woman, gathers the interested men and feeds them to Woman.chooseProponent.
     * Then, it relaxes the men rejections.
     * this.marry modifies the this.unmarried* sets, hence the cloning at the for loop.
     */
    public void singleIteration() {
        Dictionary<Integer, Man>[] interestedIn = this.getInterests();
        for (Woman newWife : new HashSet<>(this.unmarriedWomen)) {
            Dictionary<Integer, Man> proponents = interestedIn[newWife.getPosition()];
            Man newHusband = newWife.chooseHusband(proponents);
            if (newHusband != null)
                this.marry(newWife, newHusband);
        }
        this.relaxMenRejections();
    }

    /**
     * Creates an array of dictionaries, with the i-eth entry corresponding to the i-eth Woman. Then each entry is
     * filled with the Man instances interested in that woman.
     * @return  Array of dictionaries: the i-eth entry corresponds to the i-eth woman; each entry of the dictionary is
     *          of the shape (position, man in position).
     */
    private Dictionary<Integer, Man>[] getInterests() {
        Dictionary<Integer, Man>[] interestedIn = new Dictionary[this.N];

        for (Man man : this.unmarriedMen) {
            int womanPosition = man.currentlyProposesTo();
            if (interestedIn[womanPosition] == null)
                interestedIn[womanPosition] = new Hashtable<>();
            interestedIn[womanPosition].put(man.getPosition(), man);
        }

        return interestedIn;
    }

    private void marry(Woman wife, Man husband) {
        wife.marry(husband);
        this.unmarriedMen.remove(husband);
        this.unmarriedWomen.remove(wife);
    }

    /**
     * Prints all of the married couples at the terminal.
     */
    public void printCouples() {
        String messageTemplate = "The Man on position %d is married to the woman in position %d.";
        for (Man man : this.men) {
            if (!man.isMarried())
                continue;
            Person woman = man.getPartner();
            System.out.println(String.format(messageTemplate, man.getPosition(), woman.getPosition()));
        }
    }

}
