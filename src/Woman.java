import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Representation of a woman in the Mating Problem
 *
 * @author Diego Martínez
 */
public class Woman extends Person {
    /**
     * Constructor just relays position and N to Person's constructor
     *
     * @param N Number of Men and Women in the Mating Problem.
     */
    public Woman(int position, int N) {
        super(position, N);
    }

    /**
     * Chooses the best proponent from a set of Man instances and marries him. Does nothing if dict. is empty.
     *
     * @param proponents    dictionary of (position, Man in position) with the men interested in the Woman.
     */
    public void chooseHusband(Dictionary<Integer, Man> proponents) {
        if (proponents.isEmpty())
            return;
        int [] preferences = this.getPreferences();
        Man chosen = null;

        for (int pref : preferences) {
            chosen = proponents.get(pref);
            if (chosen != null)
                break;
        }
        this.marry(chosen);
    }

    public static void main(String[] args) {
        int N = 10;
        Woman woman = new Woman(0, N);
        Dictionary<Integer, Man> proponents = new Hashtable<>();
        for (int i = 0; i < N-3; i++) {
            proponents.put(i, new Man(i, N));
        }
        System.out.println("Woman's preferences");
        for (int pref : woman.getPreferences()) System.out.println(pref + ", ");
        System.out.println("Proponents are ");
        for (int i = 0; i < N-3; i++) System.out.println(i + ", ");
        woman.chooseHusband(proponents);
    }
}
