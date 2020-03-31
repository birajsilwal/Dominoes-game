package dominos;

import javafx.scene.paint.Color;

/* This class contains most of the constants in the program
 * to make the code more cleaner */
public interface Constants {

    // variables used in Display class
    int vBoxPadding = 20;
    int vBoxLabelSpacing = 10;

    // variables used in MainController class
    int borderPaneWidth = 900;
    int borderPaneHeight = 680;
//    int borderPaneHeight = 650;

    int rotateImageBy = -90;
    int rectangleHeight = 40;
    int rectangleWeight = 90;

    /*custom colors used for better UI*/
    Color yellowOrange = Color.valueOf("#ffae42B3");
    Color yellowGreen = Color.valueOf("#9acd32B3");
    Color blueGreen = Color.valueOf("#0d98ba40");
}
