package dominos;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Dominos {

    private int right;
    private int left;
    private Rectangle rectangle;


    /**@param left if left element of the domino and right is right element.*/
    public Dominos (int left, int right) {
        this.left = left;
        this.right = right;

//        String dominoName = String.format("Resources/dominoImages/%d-%d.jpg", left, right);
        String dominoName = "Resources/dominoImages/0-0.jpg";

        Image image = new Image(dominoName);
//        ImageView iv = new ImageView(image);
//        iv.setImage(image);
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(new ImagePattern(image));

        this.rectangle = rectangle;
    }



    /**@return right element of the domino */
    public int getRight() {
        return right;
    }

    /**@return left element of the domino */
    public int getLeft() {
        return left;
    }

    public Rectangle getImageView() {
        return rectangle;
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
