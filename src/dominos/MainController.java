package dominos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static dominos.Constants.*;

public class MainController extends Application {
    private BorderPane borderPane;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initGUI(primaryStage);
//        new Players().humanPlayer();
    }

    private void initGUI(Stage primaryStage) {

        borderPane = new BorderPane();
        borderPane.setBottom(new Display().buttomPart());
        borderPane.setBackground(new Background
                (new BackgroundFill(blueGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
