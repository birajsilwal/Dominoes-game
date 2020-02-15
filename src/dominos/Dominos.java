package dominos;

public class Dominos {

    private int right;
    private int left;

    /**@param left if left element of the domino and right is right element.*/
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
        int temp = left;
        left = right;
        right = temp;
    }

    /* String type method to change dominos into string */
    public String toString() {
        return "[" + getLeft() + ", " + getRight() + "]";
    }

}
