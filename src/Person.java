import java.util.Random;

/**
 * Class representing a person (man or woman) in the Mating Problem.
 *
 * @author Diego Martínez
 */
public class Person {
    private final int[] preferences;
    private boolean married;
    private Person partner;

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
    public Person(int N) {
        this.preferences = Person.getShuffledArray(N);
        this.married = false;
        this.partner = null;
    }

    public Person getPartner() {
        if (this.partner == null) {
            System.out.println("Warning, accessing the partner of an unmarried person.");
        }
        return this.partner;
    }

    public void marry(Person newPartner) {
        this.partner = newPartner;
    }
}
