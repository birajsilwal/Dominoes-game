package dominos;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import static dominos.Constants.*;

public class Dominos extends StackPane {

    private int right;
    private int left;
    private Rectangle rectangle;

    /**@param left if left element of the domino and right is right element.*/
    public Dominos (int left, int right) {
        this.left = left;
        this.right = right;
    }

    /* this method creates rectangle and sets domino image from the file*/
//    public void setRectangle() {
//        String dominoName = String.format("dominoImages/%d-%d.jpg", left, right);
//        Image image = new Image(dominoName);
//        Rectangle rectangle = new Rectangle();
//        rectangle.setRotate(rotateImageBy);
//        rectangle.setFill(new ImagePattern(image));
//        rectangle.setHeight(rectangleHeight);
//        rectangle.setWidth(rectangleWeigth);
//        getChildren().add(rectangle);
//
//        this.setOnMouseClicked(event -> {
//            rectangle.setVisible(false);
////            getChildren().add(rectangle);
////            setRec();
//        });
//    }

//    public void setRec() {
//        String dominoName = String.format("dominoImages/%d-%d.jpg", left, right);
//        Image image = new Image(dominoName);
//        Rectangle rectangle = new Rectangle();
//        rectangle.setRotate(rotateImageBy);
//        rectangle.setFill(new ImagePattern(image));
//        rectangle.setHeight(rectangleHeight);
//        rectangle.setWidth(rectangleWeigth);
//        getChildren().add(rectangle);
//    }


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
