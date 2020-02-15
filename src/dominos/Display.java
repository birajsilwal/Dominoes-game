package dominos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static dominos.Constants.*;

public class Display {

    private int fontSize = 25;


    public VBox buttomPart() {
        Text boneyardDomios = new Text("Boneyard contains __ dominos." );
        boneyardDomios.setFont(new Display().setFontt());

        Text computerDomino = new Text("Computer has __ dominos.");
        computerDomino.setFont(new Display().setFontt());

        VBox vBox = new VBox(hBoxLabelSpacing, boneyardDomios, computerDomino);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(vBoxPadding));
        vBox.setBackground(new Background
                (new BackgroundFill(yellowGreen, CornerRadii.EMPTY, Insets.EMPTY)));
        return vBox;
    }


    /* method to change font style and size*/
    public Font setFontt() {
        return Font.font("Sans", FontWeight.MEDIUM, fontSize);
    }

}
