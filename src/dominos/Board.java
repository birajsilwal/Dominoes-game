package dominos;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/* Please disregard this class. Currently this class is not in use */
public class Board extends GridPane {
    List<Dominos> playedDomino;
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
}
