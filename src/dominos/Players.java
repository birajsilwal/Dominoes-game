package dominos;

import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Players {

    Display display;

    Boneyard boneyard = new Boneyard();
    private Dominos dominos;
    private List<Dominos> humanHandList;
    private List<Dominos> computerHand;
    private List<Dominos> playedDomino = new ArrayList<>();
    int input;

    public Players() {
        humanHandList = boneyard.handsForPlayer();
        computerHand = boneyard.handsForPlayer();
    }


//    public void drawHumanHand2(FlowPane flowPane) {
//        for (Dominos humanHandDomino : humanHandList) {
//            flowPane.getChildren().add(new DrawDominoRectangle().setRectangle(humanHandDomino));
//        }
//    }

    public void drawHumanHand2(FlowPane flowPane) {
        for (int i = 0; i < 7; i++) {
            Dominos humanHandDomino = humanHandList.get(i);
//            flowPane.getChildren().add(new DrawDominoRectangle().setRectangle(humanHandDomino, i, humanHandList));
            flowPane.getChildren().add(new DrawDominoRectangle().setRectangle(humanHandDomino));
        }
    }

//    /**@param hBox is used to display all the played dominos*/
//    public void drawPlayedDomino(HBox hBox) {
//        for (int i = 0; i < 7; i++) {
//            Dominos playedDominos = playedDomino.get(i);
//            hBox.getChildren().add(new DrawDominoRectangle()
//                    .setRectangle(playedDominos));
//            System.out.println(playedDominos);
//        }
//    }

//    /**@param hBox is used to display all the played dominos*/
//    public void drawPlayedDomino(HBox hBox) {
//        for (Dominos playedDominos : playedDomino) {
//            System.out.println("x" + playedDomino);
//            hBox.getChildren().add(new DrawDominoRectangle()
//                    .setRectangle(playedDominos));
//        }
//    }

    /*all the instructions and human player logic are in this method\
    * different cases are used inside this method*/
    public void humanPlayer() {
        System.out.print("Human's Tray: ");
        System.out.println(humanHandList);
        System.out.print("Computer's Tray: ");
        System.out.println(computerHand);
        System.out.println("Human's Turn");
        System.out.println("[p] Play Domino");
        System.out.println("[d] Draw from boneyard");
        System.out.println("[q] Quit");
//        humanCases();
//        computerPlayer();
//        humanPlayer();
    }

    /*this method have computer player instructions and cases*/
    public void computerPlayer() {
        System.out.print("Human's Tray: ");
        System.out.println(humanHandList);
        System.out.print("Computer's Tray: ");
        System.out.println(computerHand);

        computerCases();

        System.out.println("Computer's Turn");
        System.out.println("computer hand size: " + computerHand.size());
        System.out.println("Played dominos: " + playedDomino + "\n");
        System.out.println("==================================================");
    }

    /* this method have logic for different cases such as play, draw, quit for human player */
    public void humanCases() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "p":
                System.out.println("Which domino?");
                play();
                break;
            case "d":
                System.out.println("Draw");
                break;
            case "q":
                quit();
                break;
        }
    }

    /* this method have all the logic for computer player
    * depending on the different situation, computer player chooses dominos tiles*/
    public void computerCases() {
        for (int i = 0; i < computerHand.size(); i++) {
            Dominos computerDomino = computerHand.get(i);

            int tempLeft = computerDomino.getLeft();
            int tempRight = computerDomino.getRight();
            int sizeOfPlayedDomino = playedDomino.size();

//            if(playedDomino.get(0).getLeft() == tempLeft) {
//
//            }

//            if(playedDomino.get(0).getRight() == tempRight){
//
//            }

            if (playedDomino.get(sizeOfPlayedDomino-1).getRight() == tempLeft) {
                playedDomino.add(computerHand.remove(i));
                break;
            }

            if (playedDomino.get(sizeOfPlayedDomino-1).getRight() == tempRight) {
                computerFlip();
                playedDomino.add(computerHand.remove(i));
                break;
            }
        }
    }

    /* this method is to play the game */
    public void play() {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        input =  scanner.nextInt();
        System.out.println("Playing " + humanHandList.get(input));

        flipOrNot();

        addToPlayedDomino(input);
        System.out.println("Boneyard contains " + boneyard.getBoneyardSize() + " Dominos.");
        System.out.println("Played dominos: " + playedDomino + "\n");
    }

    /* option for user if they want to flip their dominos or not */
    private void flipOrNot() {
        System.out.println("Do you want to flip the domino?");
        Scanner scanner1 = new Scanner(System.in);
        String flipOrNot = scanner1.nextLine();

        if (flipOrNot.equals("yes")){
            humanHandList.get(input).flipDomino();
        }
    }

    /* upon method call, computer flips the dominos */
    private void computerFlip() {
            humanHandList.get(input).flipDomino();
    }

    /* adding played dominos into the array list */
    public void addToPlayedDomino(int index) {
        playedDomino.add(humanHandList.remove(index));
    }

    public void addToPlayedDomino1(Dominos dominos) {
        playedDomino.add(dominos);
    }

    /* method to quit the game */
    public void quit() {
        System.out.println("Thank you for playing this game.");
        System.exit(0);
    }

    public int getBoneyardsize() { return boneyard.getBoneyardSize();}

    public int getComputerHandSize() {return computerHand.size();}

    public List<Dominos> getPlayedDomino() { return playedDomino;}
}