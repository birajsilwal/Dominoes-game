package dominos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

//public class Dominos extends Rectangle implements EventHandler<MouseEvent> {
public class Dominos extends Rectangle {

    private int right;
    private int left;
    private Rectangle rectangle;
    private MainController mainController;

    /**@param left if left element of the domino and right is right element.*/
    public Dominos (int left, int right, MainController mainController) {
        this.left = left;
        this.right = right;
        this.mainController = mainController;
    }

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


//    @Override
//    public void handle(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY) {
//            mainController.addPlayedDominoToBoard(this);
//            System.out.println("Clicked");
//        }
//    }
}
