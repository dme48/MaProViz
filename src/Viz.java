import Princeton.Draw;

import java.util.Set;

public class Viz {
    Draw d = new Draw("Unmarried couples");
    private final int DEFAULT_X_SCALE = 300;
    private final int DEFAULT_Y_SCALE = 400;
    private final int DEFAULT_WINDOW_WIDTH = 300;
    private final int DEFAULT_WINDOW_HEIGHT = 400;

    private Set<Man> representedMen;
    private Set<Woman> representedWomen;


    public Viz() {
        this.d.setCanvasSize(this.DEFAULT_WINDOW_WIDTH, this.DEFAULT_WINDOW_HEIGHT);
        this.d.setXscale(0, this.DEFAULT_X_SCALE);
        this.d.setYscale(0, this.DEFAULT_Y_SCALE);
        //TODO constructor
    }

    public void drawCouples(Set<Man> unmarriedMen, Set<Woman> unmarriedWomen) {
        this.representedMen = unmarriedMen;
        this.representedWomen = unmarriedWomen;
        //TODO drawCouples
    }

    public void addPropositionArrows() {
        //TODO addPropositionArrows
    }

    /**
     * Class that represents a person in the visualization.
     */
    private class PersonCircle {
        private int displayNumber;
        private int position;
        private boolean isMan;
        /**
         * Saves the necessary information for the class
         * @param displayNumber number of the person to be displayed
         * @param position position of the man, respective to the remaining men
         * @param isMan is a man (as opposed to a woman)
         */
        public PersonCircle(int displayNumber, int position, boolean isMan) {
            this.displayNumber = displayNumber;
            this.position = position;
            this.isMan = isMan;
        }

        public void drawSelf() {
            //TODO
        }

        public void drawProposalArrow() {
            //TODO
        }
    }

    public static void main(String[] args) {
        //TODO bit of unit testing
    }
}
