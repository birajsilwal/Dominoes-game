package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static dominos.Constants.*;

/* this class is responsible for displaying element into the pane */
public class Display {
    Players players = new Players();
    private int fontSize = 25;

    /* this method contains label elements */
    public VBox labelPart() {

        String boneyardSize = String.valueOf(players.getBoneyardsize());
        Text boneyardDominos = new Text("Boneyard contains " + boneyardSize + " dominos.");
        boneyardDominos.setFont(new Display().setFontt());

        String computerHandSize = String.valueOf(players.getComputerHandSize());
        Text computerDomino = new Text("computer has " + computerHandSize + " dominos.");
        computerDomino.setFont(new Display().setFontt());

        VBox vBox = new VBox(vBoxLabelSpacing, boneyardDominos, computerDomino);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(vBoxPadding));
        vBox.setPadding(new Insets(10, 50, 10, 50));
        return vBox;
    }

    /* this method contains element for the bottom part of the GUI */
    public HBox buttonDraw() {
        Button drawFromBoneyard = new Button();
        drawFromBoneyard.setText("Draw from boneyard");
        drawFromBoneyard.setFont(setFontt());

        HBox hBox = new HBox(drawFromBoneyard);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(0, 50, 0, 50));

        return  hBox;
    }

    /* method to change font style and size*/
    public Font setFontt() {
        return Font.font("Sans", FontWeight.MEDIUM, fontSize);
    }

    public VBox setRectangle(Dominos dominos) {
//        String dominoName = String.format("dominoImages/%d-%d.jpg", dominos.getLeft(), dominos.getRight());
        String dominoName = String.format("dominoImagess/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        Rectangle rectangle = new Rectangle();
//        rectangle.setRotate(rotateImageBy);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(rectangleHeight);
        rectangle.setWidth(rectangleWeigth);

        VBox vBox = new VBox();
        vBox.getChildren().add(rectangle);
        return vBox;
    }
}
