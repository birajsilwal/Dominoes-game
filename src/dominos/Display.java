package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static dominos.Constants.*;

/* this class is responsible for displaying element into the pane */
public class Display {

    private int fontSize = 25;

    /* this method contains label elements */
    public VBox labelPart() {
        Text boneyardDomios = new Text("Boneyard contains __ dominos." );
        boneyardDomios.setFont(new Display().setFontt());

        Text computerDomino = new Text("Computer has __ dominos.");
        computerDomino.setFont(new Display().setFontt());

        VBox vBox = new VBox(vBoxLabelSpacing, boneyardDomios, computerDomino);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(vBoxPadding));
        vBox.setPadding(new Insets(10, 50, 10, 50));
        return vBox;
    }

    /* this method contains element for the bottom part of the GUI */
    public HBox buttonDraw() {
        Button drawFromBoneyard = new Button();
        drawFromBoneyard.setText("Draw from boneyard");
        drawFromBoneyard.setFont(setFontt());

        HBox hBox = new HBox(drawFromBoneyard);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(0, 50, 0, 50));

        return  hBox;
    }

    /* method to change font style and size*/
    public Font setFontt() {
        return Font.font("Sans", FontWeight.MEDIUM, fontSize);
    }
}
