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
    private GridPane borderPane;
    private FlowPane flowPane;
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

        //borderPane = new BorderPane();
        flowPane = new FlowPane();
        dominos = new Dominos(1,1);
//        dominos.setRectangle();
        humanPlayer.drawHumanHand(flowPane);
        flowPane.getChildren().add(dominos);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(flowPane);

//        borderPane.setBackground(new Background
//                (new BackgroundFill(blueGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(anchorPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
