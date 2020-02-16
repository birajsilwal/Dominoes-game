package dominos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static dominos.Constants.*;

public class MainController {
    //private BorderPane borderPane;
    private GridPane borderPane;
    private Display display;
    private Dominos dominos;

    public static void main(String[] args) {
        new Players().humanPlayer();


    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
////        initGUI(primaryStage);
//    }

//    private void initGUI(Stage primaryStage) {
//
//        HBox hBox = new HBox(new Display().buttonDraw(), new Display().labelPart());
//        hBox.setAlignment(Pos.CENTER);
//        hBox.setBackground(new Background
//                (new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));
//
//        //borderPane = new BorderPane();
//        borderPane = new GridPane();
//        //borderPane.setBottom(hBox);
//        //dominos.setRectangle();
////        borderPane.getChildren().add();
//
//        AnchorPane anchorPane = new AnchorPane();
//        anchorPane.getChildren().add(borderPane);
//
//       // borderPane.setBackground(new Background
//           //     (new BackgroundFill(blueGreen, CornerRadii.EMPTY, Insets.EMPTY)));
//
//        Scene scene = new Scene(anchorPane, borderPaneWidth, borderPaneHeight);
//        primaryStage.setTitle("Dominos Game");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }


}
