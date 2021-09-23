/**
 * Creates and coordinates a MatingManager instance.
 * @author Diego Martínez
 */
public class Main {
    public static void main(String[] args) {
        int N = 10000;
        MatingManager manager = new MatingManager(N);
        while (!manager.hasFinished()) {
            System.out.println("Married couples:");
            System.out.println(manager.howManyMarried() * 100 / N + "%");
            manager.singleIteration();
        }
//        manager.printCouples();
    }
}
