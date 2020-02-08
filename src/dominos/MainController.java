package dominos;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {

    private Boneyard boneyard;
    private Board board;
    private Dominos dominos;
    private Players players;
    private DominosForPlayers dominosForPlayers;


    public void startGame() {
        boneyard = new Boneyard();
        board = new Board();
        dominosForPlayers = new DominosForPlayers(boneyard);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
