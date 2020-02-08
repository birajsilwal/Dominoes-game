package dominos;

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

    /* flips left and right elements i.e. [a, b] --> [b, a] */
    public void flipDomino(int left, int right) {
        int temp = left;
        left = right;
        right = temp;

    }
}
