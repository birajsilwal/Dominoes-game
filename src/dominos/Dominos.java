package dominos;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Dominos extends StackPane {

    private int right;
    private int left;
    private Rectangle rectangle;



    /**@param left if left element of the domino and right is right element.*/
    public Dominos (int left, int right) {
        this.left = left;
        this.right = right;
    }


    public void setRectangle(){
        String dominoName = String.format("dominoImages/%d-%d.jpg", left, right);
//        String dominoName = "dominoImages/6-6.jpg";

        Image image = new Image(dominoName);
        Rectangle rectangle = new Rectangle();
        rectangle.setRotate(90);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(60);
        rectangle.setWidth(50);
        getChildren().add(rectangle);
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
        int temp = this.getLeft();
        left = this.getRight();
        right = temp;
    }

    /* String type method to change dominos into string */
    public String toString() {
        return "[" + getLeft() + ", " + getRight() + "]";
    }

}
