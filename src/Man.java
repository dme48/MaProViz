/**
 * Representation of a woman in the Mating Problem
 *
 * @author Diego Martínez
 */
public class Man extends Person {
    private int timesRejected = 0;
    /**
     * Constructor just relays position and N to Person's constructor
     *
     * @param N Number of Men and Women in the Mating Problem.
     */
    public Man(int position, int N) {
        super(position, N);
    }

    /**
     * Increases the times the Man has been rejected
     */
    public void reject() {
        this.timesRejected++;
    }

    /**
     * @return  integer with the position of the woman he is going to propose to.
     */
    public int currentlyProposesTo() {
        return this.getPreferences()[this.timesRejected];
    }
}
