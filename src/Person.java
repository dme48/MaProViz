import java.util.Random;

/**
 * Class representing a person (man or woman) in the Mating Problem.
 *
 * @author Diego Martínez
 */
public abstract class Person {
    private final int position;
    private boolean married;
    private Person partner;

    /** Array with the preferences of the Person. preferences[i] = j means that for this person, their ith priority
     * would be the Person in position jth. Hence their best option is preferences[0] and their worst
     * preferences[N-1].*/
    private final int[] preferences;

    /**
     * Creates an ordered array and uses the Fisher-Yates algorithm to shuffle it.
     * @param N
     * @return  int array with shuffled numbers from 0 to N-1
     */
    static int[] getShuffledArray(int N){
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) ar[i] = i;
        Random rnd=new Random();
        for(int i=ar.length-1;i>0;i--) {
            int index=rnd.nextInt(i+1);
            int a=ar[index];
            ar[index]=ar[i];
            ar[i]=a;
        }
        return ar;
    }

    /**
     * Creates an array with the Person's preferences of size N. Sets the married attribute to false.
     *
     * @param N Number of males and females in the Mating Problem
     */
    public Person(int position, int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }

        this.position = position;
        this.preferences = Person.getShuffledArray(N);
        this.married = false;
        this.partner = null;
    }

    public boolean isMarried() {
        return this.married;
    }

    public Person getPartner() {
        if (this.partner == null) {
            System.out.println("Warning, accessing the partner of an unmarried person.");
        }
        return this.partner;
    }

    public void marry(Person newPartner) {
        this.partner = newPartner;
        this.married = true;
        if (!newPartner.married) {
            newPartner.partner = this;
            newPartner.married = true;
        }
    }

    public int[] getPreferences() {
        return this.preferences;
    }

    public int getPosition() {
        return this.position;
    }
}

