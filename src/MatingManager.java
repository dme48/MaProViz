/**
 * Coordinates the people and their dates in the Mating Problem Simulation. Creates a TODO
 * to represent visually the current state and refreshes it on each iteration.
 *
 * @author Diego Martínez
 */
public class MatingManager {
    private final int N;

    /**
     * @param   N   number of couples in the simulation
     */
    public MatingManager(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }

        this.N = N;

    }

}
