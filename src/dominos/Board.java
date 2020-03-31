package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.vBoxLabelSpacing;
import static dominos.Constants.vBoxPadding;

public class Board extends GridPane {

    List<Dominos> playedDomino;
    List<Dominos> humanHand;
    FlowPane flowPanePlayedDomino;
    FlowPane flowPaneHumanHand;
    VBox hBoxLabelPart;
    MainController mainController;
    Display display;
    Players players;

    Board(MainController mainController) {
        flowPanePlayedDomino = new FlowPane();
        flowPaneHumanHand = new FlowPane(Orientation.VERTICAL, 0, 20);
        hBoxLabelPart = new VBox();
        add(flowPanePlayedDomino, 3,2);
        add(flowPaneHumanHand, 0,0);
        add(hBoxLabelPart, 0,4);
        this.mainController = mainController;
        display = new Display();
        players = new Players();
        playedDomino = new ArrayList<>();
        humanHand = new ArrayList<>();
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDomino.add(dominos);
    }

    public void drawPlayedDomino() {
        flowPanePlayedDomino.getChildren().clear();
        for (Dominos dominos : playedDomino) {
            humanHand.remove(dominos);
            flowPanePlayedDomino.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
    }

    public void drawHumanHand() {
        flowPaneHumanHand.getChildren().clear();
        Players players = new Players();
        humanHand = players.getHumanHand();
        for (int i = 0; i < 7; i++) {
            Dominos dominos = humanHand.get(i);
            flowPaneHumanHand.getChildren().add(new DrawDominoRectangle(mainController).setRectangle(dominos, humanHand));
        }
    }

    /* this method contains label elements */
    public void labelPart() {

        String boneyardSize = String.valueOf(players.getBoneyardsize());
        Text boneyardDominos = new Text("Boneyard contains " + boneyardSize + " dominos.");

        String computerHandSize = String.valueOf(players.getComputerHandSize());
        Text computerDomino = new Text("computer has " + computerHandSize + " dominos.");

        String humanHandSize = String.valueOf(humanHand.size());
        Text humanDomino = new Text("Human has " + humanHandSize + " dominos.");

//        VBox vBox = new VBox(vBoxLabelSpacing, boneyardDominos, computerDomino);
        hBoxLabelPart.getChildren().addAll(computerDomino, boneyardDominos, humanDomino);

    }

    public void updateGUI() {
        drawPlayedDomino();
        labelPart();
    }
}
