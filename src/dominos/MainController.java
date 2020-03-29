package dominos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static dominos.Constants.*;

/* this is the main class of the game.
* this class is responsible for connecting all the other classes */
public class MainController extends Application {

    private BorderPane borderPane;
    Board board = new Board();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initGUI(primaryStage);
    }

    /* GUI starts from here */
    private void initGUI(Stage primaryStage) {
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
        flowPaneHumanHand.setPadding(new Insets(10, 15, 10, 15));
        flowPaneHumanHand.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));
        humanHandString.setFont(Font.font(15));
        flowPaneHumanHand = board.drawHumanHand(flowPaneHumanHand);

        // Right item: displaying played dominos
        FlowPane flowPanePlayedDomino = new FlowPane(Orientation.VERTICAL, 0, 20);
        Text humanHandString1 = new Text("Played Dominos");
        flowPanePlayedDomino.getChildren().add(humanHandString1);
        flowPanePlayedDomino.setPadding(new Insets(10, 15, 10, 15));
//        flowPanePlayedDomino.setBackground(new Background(new BackgroundFill(CornerRadii.EMPTY, Insets.EMPTY)));
        humanHandString.setFont(Font.font(15));

//        flowPanePlayedDomino = board.updateGUI(flowPanePlayedDomino);
//        DrawPlayedDomino drawPlayedDomino = new DrawPlayedDomino();

        // **********************************************


        board.updateGUI();
        Label label = new Label("biraj");
//        board.getChildren().add(label);


        // main displaying stuff going on here
        borderPane = new BorderPane();
//        borderPane.setRight(flowPanePlayedDomino);
        borderPane.setCenter(board);
        borderPane.setLeft(flowPaneHumanHand);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addPlayedDominoToBoard(Dominos dominos) {
        board.insertDomino(dominos);
        board.updateGUI();
    }

}
