package dominos;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Board extends Pane {

    List<Dominos> playedDomino;
    List<Dominos> humanHand = new ArrayList<>();
    FlowPane flowPane;

    Board() {
        playedDomino = new ArrayList<>();
        flowPane = new FlowPane();
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDomino.add(dominos);
    }

    public void updateGUI() {
        flowPane.getChildren().clear();
        for (Dominos domino : playedDomino) {
            flowPane.getChildren().add(new DrawPlayedDomino().setRectangle(domino));
        }
        System.out.println("updateGUI");
    }

    public FlowPane drawHumanHand(FlowPane flowPane) {
        Players players = new Players();
        humanHand = players.getHumanHand();
        for (int i = 0; i < 7; i++) {
            Dominos dominos = humanHand.get(i);
            flowPane.getChildren().add(new DrawPlayedDomino().setRectangle(dominos));
        }
        return flowPane;
    }
}
