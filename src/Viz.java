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

    public static void main(String[] args) {
        //TODO bit of unit testing
    }
}
