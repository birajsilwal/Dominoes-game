package dominos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.*;

/* this is the main class of the game.
* this class is responsible for connecting all the other classes */
public class MainController extends Application implements EventHandler<ActionEvent> {

    private BorderPane borderPane;
    private Board board;
    private Players players;
    private Boneyard boneyard;
    private List<Dominos> humanHand;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initGUI(primaryStage);
    }

    /* GUI starts from here */
    private void initGUI(Stage primaryStage) {
        board = new Board(this);
        boneyard = new Boneyard();
        players = new Players(boneyard.handsForPlayer(), boneyard.handsForPlayer);
        humanHand = new ArrayList<>();
        humanHand = players.getHumanHand();


        // Bottom item: horizontal part
//        HBox hBox = new HBox(display.buttonDraw(), display.labelPart());
//        hBox.setAlignment(Pos.CENTER);
//        hBox.setBackground(new Background
//                (new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));


        board.drawHumanHand(humanHand);
        board.updateGUI();

        // main displaying stuff going on here
        borderPane = new BorderPane();
        Image image = new Image("wooden.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(borderPaneHeight);
        imageView.setFitWidth(borderPaneWidth);
        borderPane.getChildren().addAll(imageView);
        borderPane.setCenter(board);

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addPlayedDominoToBoard(Dominos dominos) {
        board.insertDomino(dominos);
        board.drawPlayedDomino();
        board.drawHumanHand(humanHand);
        board.labelPart(humanHand, boneyard.getBoneyardSize());
    }

    @Override
    public void handle(ActionEvent event) {
        // need to implement other function like restart the game and draw from boneyard
    }
}
