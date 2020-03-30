package dominos;

import javafx.scene.shape.Rectangle;

public class Dominos extends Rectangle {

    private int right;
    private int left;

    public Dominos (int left, int right) {
        this.left = left;
        this.right = right;
    }

    /**@return right element of the domino */
    public int getRight() {
        return right;
    }

    /**@return left element of the domino */
    public int getLeft() {
        return left;
    }

    /* flips left and right elements i.e. [a, b] --> [b, a] */
    public void flipDomino() {
        int temp = this.getLeft();
        left = this.getRight();
        right = temp;
    }

    /* String type method to change dominos into string */
    public String toString() {
        return "[" + getLeft() + ", " + getRight() + "]";
    }
}
