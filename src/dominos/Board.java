package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.*;

public class Board extends BorderPane {

    MainController mainController;
    FlowPane flowPanePlayedDominoTop;
    FlowPane flowPanePlayedDominoBottom;
    FlowPane flowPaneHumanHand;
    FlowPane flowPaneComputerHand;
    HBox hBoxLabelPart;
    VBox playedDominoBoard;
    List<Dominos> playedDominoTop;
    List<Dominos> playedDominoBottom;
    Players players;

    Board(MainController mainController, Players players) {
        flowPanePlayedDominoTop = new FlowPane();
        flowPanePlayedDominoBottom = new FlowPane();
        flowPaneHumanHand = new FlowPane(Orientation.VERTICAL, 20, 20);
        flowPaneComputerHand = new FlowPane(Orientation.VERTICAL, 20, 20);
        hBoxLabelPart = new HBox();
        playedDominoBoard = new VBox();
        this.setLeft(flowPaneHumanHand);
        this.setRight(flowPaneComputerHand);
//        this.setBottom(hBoxLabelPart);
        playedDominoBoard.getChildren().addAll(flowPanePlayedDominoTop, flowPanePlayedDominoBottom);
        this.setCenter(playedDominoBoard);

        this.mainController = mainController;
        this.players = players;
        playedDominoTop = new ArrayList<>();
        playedDominoBottom = new ArrayList<>();
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino(Dominos dominos) {
        playedDominoTop.add(dominos);
        insertComputerDomino(dominos);
    }

    public void insertComputerDomino(Dominos dominos) {
        playedDominoBottom.add(dominos);
        players.computerCases(playedDominoBottom);
        playedDominoBottom.remove(dominos);
    }

    /*this methods draws played domino into the flowpane */
    public void drawPlayedDomino() {
        flowPanePlayedDominoTop.getChildren().clear();
        flowPanePlayedDominoTop.setPadding(new Insets(50, 10, 10, 10));
        flowPanePlayedDominoTop.setAlignment(Pos.CENTER);

        for (Dominos dominos : playedDominoTop) {
            flowPanePlayedDominoTop.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
        drawComputerPlayedDomino();
    }

    public void drawComputerPlayedDomino() {
        flowPanePlayedDominoBottom.getChildren().clear();
        flowPanePlayedDominoBottom.setPadding(new Insets(0, 0, 80, 110));
        flowPanePlayedDominoBottom.setAlignment(Pos.CENTER);

        for (Dominos dominos : playedDominoBottom) {
            flowPanePlayedDominoBottom.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
    }

    public void drawComputerHand(List<Dominos> computerHand) {
        flowPaneComputerHand.getChildren().clear();
        Text computerHandString = new Text("Computer's Hand");
        flowPaneComputerHand.setPadding(new Insets(10, 5, 10, 5));
        flowPaneComputerHand.setBackground(new Background(new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));
        flowPaneComputerHand.setPrefWidth(rectangleWidth + 20);
        flowPaneComputerHand.setPrefHeight(borderPaneHeight);
        flowPaneComputerHand.setAlignment(Pos.TOP_CENTER);
        flowPaneComputerHand.getChildren().add(computerHandString);
        for (Dominos dominos : computerHand) {
            flowPaneComputerHand.getChildren().add(new DrawPlayedDomino().setRectangle(dominos));
        }
    }

    /**@param humanHand are the 7 dominos of human*/
    public void drawHumanHand(List<Dominos> humanHand) {
        flowPaneHumanHand.getChildren().clear();
        Text humanHandString = new Text("Human's Hand");
        flowPaneHumanHand.setPadding(new Insets(10, 5, 10, 5));
        flowPaneHumanHand.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));
        flowPaneHumanHand.setPrefWidth(rectangleWidth + 20);
        flowPaneHumanHand.setPrefHeight(borderPaneHeight);
        flowPaneHumanHand.setAlignment(Pos.TOP_CENTER);
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
