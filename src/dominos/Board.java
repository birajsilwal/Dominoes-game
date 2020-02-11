package dominos;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int leftOfTray;
    private int rightOfTray;
    private int trayDominoLeft;
    private int trayDominoRight;

    List<Dominos> trayDomino = new ArrayList<>();

    /** @param dominos
     * this method checks if left/right number of the domino is equal to
     * left/right of the dominos in tray */

    public boolean isValidMove(Dominos dominos) {

        int left = dominos.getLeft();
        int right = dominos.getRight();

        if (right == dominos.getRight())
            return right == 0 || right == trayDominoRight;
        else
            return left == 0 || left == trayDominoLeft;
    }

    public void leftOrRight() {
        System.out.println("Do you want to put left or right side?");

    }
}
