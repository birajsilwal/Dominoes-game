package dominos;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.rectangleHeight;
import static dominos.Constants.rectangleWeigth;

public class DrawDominoRectangle extends Pane {
    Players players = new Players();
    Rectangle rectangle = new Rectangle();
    VBox vBox = new VBox();
    HBox hBox = new HBox();

    public List<Dominos> playedDomino = new ArrayList<>();


    public void setRectangle(Dominos dominos) {
//        String dominoName = String.format("dominoImages/%d-%d.jpg", dominos.getLeft(), dominos.getRight());
        String dominoName = String.format("dominoImagess/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(rectangleHeight);
        rectangle.setWidth(rectangleWeigth);

        getChildren().add(rectangle);

//        vBox.setOnMouseClicked(event -> {
////            drawPlayed(hBox);
//            players.drawPlayedDomino(hBox);
////            System.out.println("HumanHandList" + list);
////            System.out.println("Domino index: " + index);
//            players.addToPlayedDomino(index);
////            System.out.println("[" + dominos.getLeft() +
////                    ", " + dominos.getRight() + "]");
////            System.out.println("Played domino at the specific index: " + list.get(index));
//            playedDomino.add(list.get(index));
//            System.out.println("Played domino list: " + playedDomino);
////            System.out.println("");
//
//        });
    }



//    public HBox drawPlayed(HBox hBox) {
//        vBox.setVisible(false);
//        players.drawPlayedDomino(hBox);
////        System.out.println(playedDomino);
//        return hBox;
//    }
//
//    public VBox setRectangle(Dominos dominos) {
////        String dominoName = String.format("dominoImages/%d-%d.jpg", dominos.getLeft(), dominos.getRight());
//        String dominoName = String.format("dominoImagess/%d-%d.png", dominos.getLeft(), dominos.getRight());
//        Image image = new Image(dominoName);
//        rectangle.setFill(new ImagePattern(image));
//        rectangle.setHeight(rectangleHeight);
//        rectangle.setWidth(rectangleWeigth);
//
//        vBox.getChildren().add(rectangle);
//
//        return vBox;
//    }
}
