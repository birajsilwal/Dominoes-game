package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventListener;
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
    Display display;

    Board(MainController mainController, Players players) {
        flowPanePlayedDominoTop = new FlowPane();
        flowPanePlayedDominoBottom = new FlowPane();
        flowPaneHumanHand = new FlowPane(Orientation.VERTICAL, 20, 20);
        flowPaneComputerHand = new FlowPane(Orientation.VERTICAL, 20, 20);
        hBoxLabelPart = new HBox(15);
        playedDominoBoard = new VBox();
        playedDominoBoard.getChildren().addAll(flowPanePlayedDominoTop, flowPanePlayedDominoBottom);
        this.setLeft(flowPaneHumanHand);
        this.setRight(flowPaneComputerHand);
        this.setBottom(hBoxLabelPart);
        this.setCenter(playedDominoBoard);
        this.mainController = mainController;
        this.players = players;
        display = new Display();
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
        playersHandDesign(flowPaneComputerHand);
        Text computerHandString = new Text("Computer's Hand");
        flowPaneComputerHand.getChildren().add(computerHandString);
        for (Dominos dominos : computerHand) {
            flowPaneComputerHand.getChildren().add(new DrawPlayedDomino().setRectangle(dominos));
        }
    }

    /**@param humanHand are the 7 dominos of human*/
    public void drawHumanHand(List<Dominos> humanHand) {
        flowPaneHumanHand.getChildren().clear();
        playersHandDesign(flowPaneHumanHand);
        Text humanHandString = new Text("Human's Hand");
        flowPaneHumanHand.getChildren().add(humanHandString);
        for (Dominos dominos : humanHand) {
            flowPaneHumanHand.getChildren().add(new DrawDominoRectangle(mainController).setRectangle(dominos, humanHand));
        }
    }

    /* this method contains label elements */
    public void labelPart(int boneyardSize) {
        hBoxLabelPart.getChildren().clear();

        Image image = new Image("wood.png");
        Button btnDrawFromBoneyard = new Button("Draw from Boneyard.");
        btnDrawFromBoneyard.setFont(display.setFontt());
        btnDrawFromBoneyard.resize(60, 20);
        btnDrawFromBoneyard.setPadding(new Insets(5));
        btnDrawFromBoneyard.setBackground(new Background(new BackgroundImage(image, null, null, null, null)));

        btnDrawFromBoneyard.setOnMouseClicked(event -> {

        });

        Image image1 = new Image("wood.png");
        Button btnBoneyardSize = new Button("Boneyard contains " + boneyardSize + " dominos.");
        btnBoneyardSize.setFont(display.setFontt());
        btnBoneyardSize.resize(60, 20);
        btnBoneyardSize.setPadding(new Insets(5));
        btnBoneyardSize.setBackground(new Background(new BackgroundImage(image1, null, null, null, null)));

//        Image imageSoundOn = new Image("soundOn.png");
//        ImageView imageView = new ImageView();
//        imageView.setImage(image);
//        imageView.setImage(imageSoundOn);
//        imageView.setFitHeight(50);
//        imageView.setFitWidth(50);
//        Button soundOn = new Button(null, imageView);
//        soundOn.resize(500, 500);

        hBoxLabelPart.setPadding(new Insets(10));
        hBoxLabelPart.setAlignment(Pos.CENTER);
        hBoxLabelPart.getChildren().addAll(btnDrawFromBoneyard, btnBoneyardSize);

    }

    public void updateGUI() {
        drawPlayedDomino();
    }

    public void playersHandDesign(FlowPane flowPane) {
        flowPane.setPadding(new Insets(10, 5, 10, 5));
        flowPane.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));
        flowPane.setPrefWidth(rectangleWidth + 20);
        flowPane.setPrefHeight(borderPaneHeight);
        flowPane.setAlignment(Pos.TOP_CENTER);
    }
}
