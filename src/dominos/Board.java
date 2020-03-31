package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.*;

public class Board extends BorderPane {

    List<Dominos> playedDomino;
    FlowPane flowPanePlayedDomino;
    FlowPane flowPaneHumanHand;
    HBox hBoxLabelPart;
    MainController mainController;

    Board(MainController mainController) {
        flowPanePlayedDomino = new FlowPane();
        flowPaneHumanHand = new FlowPane(Orientation.HORIZONTAL, 20, 5);
        hBoxLabelPart = new HBox();
        this.setTop(flowPaneHumanHand);
        this.setCenter(flowPanePlayedDomino);
        this.setBottom(hBoxLabelPart);
        this.mainController = mainController;
        playedDomino = new ArrayList<>();
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDomino.add(dominos);
    }

    /*this methods draws played domino into the flowpane */
    public void drawPlayedDomino() {
        flowPanePlayedDomino.getChildren().clear();
        flowPanePlayedDomino.setPadding(new Insets(80, 10, 80, 10));
        flowPanePlayedDomino.setAlignment(Pos.CENTER);

        for (Dominos dominos : playedDomino) {
            flowPanePlayedDomino.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
    }

    /**@param humanHand are the 7 dominos of human*/
    public void drawHumanHand(List<Dominos> humanHand) {
        flowPaneHumanHand.getChildren().clear();
        Text humanHandString = new Text("Human's Hand");
        humanHandString.setTextAlignment(TextAlignment.LEFT);
        flowPaneHumanHand.setPadding(new Insets(10, 5, 10, 5));
        flowPaneHumanHand.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));
        flowPaneHumanHand.setPrefWidth(borderPaneWidth);
        flowPaneHumanHand.setPrefHeight(rectangleHeight + 20);
        flowPaneHumanHand.setAlignment(Pos.CENTER);
        flowPaneHumanHand.getChildren().add(humanHandString);
        for (Dominos dominos : humanHand) {
            flowPaneHumanHand.getChildren().add(new DrawDominoRectangle(mainController).setRectangle(dominos, humanHand));
        }
    }

    /* this method contains label elements */
    public void labelPart(List<Dominos> humanHand, int boneyardSize) {
        hBoxLabelPart.getChildren().clear();

        String humanHandSize = String.valueOf(humanHand.size());
        Text humanDomino = new Text("Human has " + humanHandSize + " dominos.");

        Text boneyard = new Text("Boneyard contains " + boneyardSize + " dominos.");

        hBoxLabelPart.getChildren().addAll(humanDomino, boneyard);

    }

    public void updateGUI() {
        drawPlayedDomino();
    }
}
