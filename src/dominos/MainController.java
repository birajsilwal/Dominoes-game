package dominos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static dominos.Constants.*;

/* this is the main class of the game.
* this class is responsible for connecting all the other classes */
public class MainController extends Application {
    private FlowPane flowPane;
    private BorderPane borderPane;
    private VBox vBoxHumanHand;
    private HBox hBoxPlayedDominos;
    private Display display;
    private Dominos dominos;
    private Players players = new Players();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        players.humanPlayer();
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

        // Right item: displaying human hand
        FlowPane flowPaneHumanHand = new FlowPane(Orientation.VERTICAL, 0, 20);
        Text humanHandString = new Text("Human's Hand");
        flowPaneHumanHand.getChildren().add(humanHandString);
        humanHandString.setFont(Font.font(15));
        players.drawHumanHand2(flowPaneHumanHand);
        flowPaneHumanHand.setPadding(new Insets(10, 15, 10, 15));
        flowPaneHumanHand.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));

        // Center item: displaying played dominos
        hBoxPlayedDominos = new HBox();
        players.drawPlayedDomino(hBoxPlayedDominos);


        borderPane = new BorderPane();
        borderPane.setCenter(hBoxPlayedDominos);
        borderPane.setLeft(flowPaneHumanHand);
        borderPane.setBottom(hBox);;
        borderPane.setBackground(new Background
        (new BackgroundFill(blueGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
