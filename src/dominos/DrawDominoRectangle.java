package dominos;

import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.util.List;

import static dominos.Constants.*;

public class DrawDominoRectangle extends Pane {
    Players players = new Players();
    Rectangle rectangle = new Rectangle();
    VBox vBox = new VBox();
    HBox hBox = new HBox();
    FlowPane flowPane = new FlowPane();

    public Rectangle setRectangle(Dominos dominos, List<Dominos> humanHandList, List<Dominos> playedDomino, int index) {
        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(rectangleHeight);
        rectangle.setWidth(rectangleWeigth);

        getChildren().add(rectangle);

        rectangle.setOnMouseClicked(event -> {
            System.out.println("HumanHandList" + humanHandList);
            System.out.println("Domino" + "[" + dominos.getLeft() + ", " + dominos.getRight() + "]" + "& index: " +  index );
            players.addToPlayedDomino(index);
            System.out.println("Played domino at the specific index: " + humanHandList.get(index));
            playedDomino.add(humanHandList.get(index));
            System.out.println("Played domino list: " + playedDomino);
            System.out.println("");
            drawPlayed(flowPane, playedDomino);
        });
        return rectangle;
    }

    public FlowPane drawPlayed(FlowPane hBox, List<Dominos> dpd) {
        rectangle.setVisible(false);
        for (Dominos humanHandDomino : dpd) {
            hBox.getChildren().add(setRectangle(humanHandDomino));
        }
        System.out.println("DPD global: " + dpd);
        return hBox;
    }

    public Rectangle setRectangle(Dominos dominos) {
        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(rectangleHeight);
        rectangle.setWidth(rectangleWeigth);

        getChildren().add(rectangle);

        return rectangle;
    }
}
