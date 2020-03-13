package dominos;

/* Please disregard this class. Currently this class is not in use */
public class Board {

    private int leftOfTray;
    private int rightOfTray;
    private int trayDominoLeft;
    private int trayDominoRight;

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

    /* this allows user to place domino to the left or right*/
    public void leftOrRight() {
        System.out.println("Do you want to put left or right side?");
    }
}
