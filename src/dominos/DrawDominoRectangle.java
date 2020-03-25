package dominos;

import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.DOMImplementation;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.*;

public class DrawDominoRectangle extends Pane {

    Rectangle rectangle = new Rectangle();
    FlowPane flowPane = new FlowPane();
    List<Dominos> globalPlayedDomino = new ArrayList<>();
    MainController mainController;

    DrawDominoRectangle(MainController mainController) {
        this.mainController = mainController;
    }

    public Rectangle setRectangle(Dominos dominos, List<Dominos> humanHandList, List<Dominos> playedDomino, int index) {
//    public Rectangle setRectangle(Dominos dominos) {
        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
        Image image = new Image(dominoName);
        rectangle.setFill(new ImagePattern(image));
        rectangle.setHeight(rectangleHeight);
        rectangle.setWidth(rectangleWeigth);

        getChildren().add(rectangle);

//        rectangle.setOnMouseClicked(event -> {
//            playedDomino.add(humanHandList.get(index));
//            System.out.println("Played domino list: " + playedDomino);
////            globalPlayedDomino.add(playedDomino.get(index));
//            drawPlayed(flowPane, playedDomino);
//
//        });

        rectangle.setOnMouseClicked(event -> {
            System.out.println("rectangle on click");
            playedDomino.add(humanHandList.get(index));
            System.out.println(playedDomino);
//            rectangle.setVisible(false);
            for (Dominos dominos1 : playedDomino) {
                mainController.addPlayedDominoToBoard(dominos1);
            }
        });
        return rectangle;
    }

//    public void drawPlayed(FlowPane flowPanePlayedDomino, List<Dominos> dpd) {
//        rectangle.setVisible(false);
////        System.out.println("DPD global: " + dpd);
//        for (Dominos humanHandDomino : dpd) {
//            flowPanePlayedDomino.getChildren().add(setRectangle(humanHandDomino));
//        }
//
//    }

//    public Rectangle setRectangle(Dominos dominos) {
//        String dominoName = String.format("dominoImages/%d-%d.png", dominos.getLeft(), dominos.getRight());
//        Image image = new Image(dominoName);
//        rectangle.setFill(new ImagePattern(image));
//        rectangle.setHeight(rectangleHeight);
//        rectangle.setWidth(rectangleWeigth);
//        getChildren().add(rectangle);
//        return rectangle;
//    }

//    @Override
//    public void handle(MouseEvent event) {
//        if (event.getButton() == MouseButton.PRIMARY) {
////            mainController.updateGUI(this);
//            System.out.println("Clicked");
//            System.out.println(event.getX());
//        }
//    }

}
