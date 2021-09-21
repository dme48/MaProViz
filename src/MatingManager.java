import java.util.Random;

/**
 * Coordinates the people and their dates in the Mating Problem Simulation. Creates a TODO
 * to represent visually the current state and refreshes it on each iteration.
 */
public class MatingManager {
    private final int N;
    private final int[][] men;
    private final int[][] women;

    /**
     * @param   N   number of couples in the simulation
     */
    public MatingManager(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }

        this.N = N;
        this.men = new int[N][N];
        this.women = new int[N][N];

        for (int i = 0; i < N; i++) {
            men[i] = this.getRandomPreferences();
            women[i] = this.getRandomPreferences();
        }
    }

    private int[] getRandomPreferences() {
        int[] preferences = new int[N];
        for (int i = 0; i < this.N; i++) {
            preferences[i] = i;
        }
        shuffleArray(preferences);
        return preferences;
    }

    // Fisher–Yates shuffle
    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
