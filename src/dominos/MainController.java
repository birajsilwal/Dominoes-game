package dominos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static dominos.Constants.*;

public class MainController extends Application {
    private BorderPane borderPane;
    private Display display;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initGUI(primaryStage);
//        new Players().humanPlayer();
    }

    private void initGUI(Stage primaryStage) {

        HBox hBox = new HBox(new Display().buttonDraw(), new Display().labelPart());
        hBox.setAlignment(Pos.CENTER);
        hBox.setBackground(new Background
                (new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setBackground(new Background
                (new BackgroundFill(blueGreen, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(borderPane, borderPaneWidth, borderPaneHeight);
        primaryStage.setTitle("Dominos Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
