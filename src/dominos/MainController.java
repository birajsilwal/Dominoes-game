package dominos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static dominos.Constants.*;

/* this is the main class of the game.
* this class is responsible for connecting all the other classes */
public class MainController extends Application implements EventHandler<ActionEvent> {

    private BorderPane borderPane;
    private Board board;

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
        Display display = new Display();

        // Bottom item: horizontal part
        HBox hBox = new HBox(display.buttonDraw(), display.labelPart());
        hBox.setAlignment(Pos.CENTER);
        hBox.setBackground(new Background
                (new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        // Left item: displaying human hand
        FlowPane flowPaneHumanHand = new FlowPane(Orientation.VERTICAL, 0, 20);
        Text humanHandString = new Text("Human's Hand");
        flowPaneHumanHand.getChildren().add(humanHandString);
        flowPaneHumanHand.setPadding(new Insets(10, 5, 10, 5));
        flowPaneHumanHand.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));
        humanHandString.setFont(Font.font(15));
        board.drawHumanHand();

        // Right item: displaying played dominos
        FlowPane flowPanePlayedDomino = new FlowPane(Orientation.VERTICAL, 0, 20);
        Text playedDominosString = new Text("Played Dominos");
        flowPanePlayedDomino.getChildren().add(playedDominosString);
        flowPanePlayedDomino.setPadding(new Insets(10, 15, 10, 15));
        flowPanePlayedDomino.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        humanHandString.setFont(Font.font(15));

        // **********************************************

        board.updateGUI();

        // main displaying stuff going on here
        borderPane = new BorderPane();
        borderPane.setCenter(board);
        borderPane.setLeft(flowPaneHumanHand);
//        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addPlayedDominoToBoard(Dominos dominos) {
        board.insertDomino(dominos);
        board.drawPlayedDomino();
    }

    @Override
    public void handle(ActionEvent event) {
        // need to implement other function like restart the game and draw from boneyard
    }
}
