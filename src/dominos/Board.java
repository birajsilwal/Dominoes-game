package dominos;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class Board extends Pane {

    List<Dominos> playedDomino = new ArrayList<>();
    List<Dominos> humanHand = new ArrayList<>();
    FlowPane flowPane;
    int count = 0;
    MainController mainController;

    Board(MainController mainController) {
        flowPane = new FlowPane();
        getChildren().addAll(flowPane);
        this.mainController = mainController;
    }

    /**@param dominos is added to the arraylist */
    public void insertDomino (Dominos dominos) {
        playedDomino.add(dominos);
    }

    public void updateGUI() {
        flowPane.getChildren().clear();
//        playedDomino.add(new Dominos(1,1));
        for (Dominos dominos : playedDomino) {
            flowPane.getChildren().addAll(new DrawPlayedDomino().setRectangle(dominos));
        }
        int temp = ++count;
        String value = String.valueOf(temp);
        Label label = new Label(value);
        flowPane.getChildren().addAll(label);
        System.out.println(temp);
        System.out.println("updateGUI is executing");
    }

    public FlowPane drawHumanHand(FlowPane flowPane) {
        Players players = new Players();
        humanHand = players.getHumanHand();
        for (int i = 0; i < 7; i++) {
            Dominos dominos = humanHand.get(i);
            flowPane.getChildren().add(new DrawDominoRectangle(mainController).setRectangle(dominos));
        }
        return flowPane;
    }
}
