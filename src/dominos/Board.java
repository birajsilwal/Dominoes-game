package dominos;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Board extends FlowPane {

    List<Dominos> playedDomino;
    List<Dominos> humanHand = new ArrayList<>();
    FlowPane flowPane;
    Label label;

    Board() {
        playedDomino = new ArrayList<>();
        flowPane = new FlowPane();
        label = new Label("Name updated");
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDomino.add(dominos);
    }

    public void updateGUI() {

        flowPane.getChildren().clear();
        playedDomino.add(new Dominos(1,1));
        for (Dominos dominos : playedDomino) {
            flowPane.getChildren().add(new DrawDominoRectangle().setRectangle(dominos));
        }
        flowPane.getChildren().add(label);
        System.out.println("updateGUI is executing");
    }

    public FlowPane drawHumanHand(FlowPane flowPane) {
        Players players = new Players();
        humanHand = players.getHumanHand();
        for (int i = 0; i < 7; i++) {
            Dominos dominos = humanHand.get(i);
            flowPane.getChildren().add(new DrawDominoRectangle().setRectangle(dominos));
        }
        return flowPane;
    }
}
