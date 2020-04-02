package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.*;

public class Board extends GridPane {

    MainController mainController;
    FlowPane flowPanePlayedDomino;
    FlowPane flowPanePlayedDominoBottom;
    FlowPane flowPaneHumanHand;
    FlowPane flowPaneComputerHand;
    HBox hBoxLabelPart;
    List<Dominos> playedDominoTop;
    List<Dominos> playedDominoBottom;
    Players players;

    Board(MainController mainController, Players players) {
        flowPanePlayedDomino = new FlowPane();
        flowPanePlayedDominoBottom = new FlowPane();
        flowPaneHumanHand = new FlowPane(Orientation.HORIZONTAL, 20, 5);
        flowPaneComputerHand = new FlowPane(Orientation.HORIZONTAL, 20, 5);
        hBoxLabelPart = new HBox();
        add(flowPaneHumanHand, 0, 0);
        add(flowPaneComputerHand, 0, 1);
        add(flowPanePlayedDomino,0, 2);
        add(flowPanePlayedDominoBottom, 0, 3);
//        this.setBottom(hBoxLabelPart);
        this.mainController = mainController;
        this.players = players;
        playedDominoTop = new ArrayList<>();
        playedDominoBottom = new ArrayList<>();
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDominoTop.add(dominos);
        players.computerCases(playedDominoTop);
    }

    /*this methods draws played domino into the flowpane */
    public void drawPlayedDomino() {
        flowPanePlayedDomino.getChildren().clear();
        flowPanePlayedDominoBottom.getChildren().clear();
        flowPanePlayedDomino.setPadding(new Insets(50, 10, 10, 10));
//        flowPanePlayedDominoBottom.setPadding(new Insets(120, 10, 80, 10));
        flowPanePlayedDomino.setAlignment(Pos.CENTER);
        flowPanePlayedDominoBottom.setAlignment(Pos.BOTTOM_LEFT);

        for (Dominos dominos : playedDominoTop) {
            flowPanePlayedDomino.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
        for (Dominos dominos : playedDominoTop) {
            flowPanePlayedDominoBottom.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
    }

    public void drawComputerHand(List<Dominos> computerHand) {
        flowPaneComputerHand.getChildren().clear();
        Text humanHandString = new Text("Computer's Hand");
        humanHandString.setTextAlignment(TextAlignment.LEFT);
        flowPaneComputerHand.setPadding(new Insets(10, 5, 10, 5));
        flowPaneComputerHand.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));
        flowPaneComputerHand.setPrefWidth(borderPaneWidth);
        flowPaneComputerHand.setPrefHeight(rectangleHeight + 20);
        flowPaneComputerHand.setAlignment(Pos.CENTER);
        flowPaneComputerHand.getChildren().add(humanHandString);
        for (Dominos dominos : computerHand) {
            flowPaneComputerHand.getChildren().add(new DrawPlayedDomino().setRectangle(dominos));
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
