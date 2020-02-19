package dominos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static dominos.Constants.*;

public class MainController extends Application {
    //private BorderPane borderPane;
    private FlowPane flowPane;
    private BorderPane borderPane;
    private VBox vBox;
    private Display display;
    private Dominos dominos;
    private Players humanPlayer = new Players();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        humanPlayer.humanPlayer();
        initGUI(primaryStage);
    }

    private void initGUI(Stage primaryStage) {

        HBox hBox = new HBox(new Display().buttonDraw(), new Display().labelPart());
        hBox.setAlignment(Pos.CENTER);
        hBox.setBackground(new Background
                (new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        vBox = new VBox();
        dominos = new Dominos(1,1);
        humanPlayer.drawHumanHand(vBox);
        vBox.getChildren().add(dominos);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(-10);
        vBox.setPrefWidth(200);
        vBox.setBackground(new Background(new BackgroundFill(yellowOrange, CornerRadii.EMPTY, Insets.EMPTY)));

        borderPane = new BorderPane();
        borderPane.setRight(vBox);
        borderPane.setBottom(hBox);;
        borderPane.setBackground(new Background
        (new BackgroundFill(blueGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
