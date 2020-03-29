package dominos;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;
import java.util.List;

public class Board extends FlowPane {

    List<Dominos> playedDomino = new ArrayList<>();
    List<Dominos> humanHand = new ArrayList<>();
    FlowPane flowPane;
    int count;

    Board() {
        flowPane = new FlowPane();
        getChildren().addAll(flowPane);
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDomino.add(dominos);
    }

    public FlowPane updateGUI() {

        flowPane.getChildren().clear();
        for (Dominos dominos : playedDomino) {
            flowPane.getChildren().addAll(new DrawDominoRectangle().setRectangle(dominos));
        }
        int temp = ++count;
        String value = String.valueOf(temp);
        Label label = new Label(value);
        flowPane.getChildren().addAll(label);
        System.out.println("updateGUI is executing");
        return flowPane;
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
