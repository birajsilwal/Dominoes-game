package dominos;

import java.util.List;

public class Dominos {

    private int right;
    private int left;

    public Dominos (int right, int left) {
        this.left = left;
        this.right = right;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

//    public int setRight() {
//
//    }

    /* flips left and right elements i.e. [a, b] --> [b, a] */
    public void flipDomino(List<Dominos> dominos) {
        int temp = getLeft();
        left = getRight();
        right = temp;
    }

    /* String type method to change dominos into string */
    public String toString() {
        return "[" + getRight() + ", " + getLeft() + "]";
    }
}
