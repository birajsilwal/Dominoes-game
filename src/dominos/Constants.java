package dominos;

import javafx.scene.paint.Color;

/* This class contains most of the constants in the program
 * to make the code more cleaner */
public interface Constants {

    // variables used in MainController class
    int borderPaneWidth = 1200;
    int borderPaneHeight = 680;
//    int borderPaneHeight = 650;

    int rotateImageBy = -90;
    int rectangleHeight = 50;
    int rectangleWeight = 100;

    int playedDominoRectangleHeight = 60;
    int playedDominoRectangleWidth = 110;

    /*custom colors used for better UI*/
    Color yellowOrange = Color.valueOf("#ffae42B3");
    Color yellowGreen = Color.valueOf("#9acd32B3");
    Color blueGreen = Color.valueOf("#0d98ba40");
}
