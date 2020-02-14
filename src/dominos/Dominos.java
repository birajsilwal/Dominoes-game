package dominos;

import java.util.List;

public class Dominos {

    private int right;
    private int left;

    public Dominos (int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    /* flips left and right elements i.e. [a, b] --> [b, a] */
    public void flipDomino(List<Dominos> dominos, int index) {
        int temp = dominos.get(index).getLeft();
        left = dominos.get(index).getRight();
        right = temp;
    }

    /* String type method to change dominos into string */
    public String toString() {
        return "[" + getLeft() + ", " + getRight() + "]";
    }

}
