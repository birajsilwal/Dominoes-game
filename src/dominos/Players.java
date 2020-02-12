package dominos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Players {

    Boneyard boneyard = new Boneyard();
    private Dominos dominos;
    private List<Dominos> hands;
    private List<Dominos> computerHand;
    private List<Dominos> playedDomino = new ArrayList<>();
    private boolean currentTurn = true;

    public Players() {
        hands = boneyard.handsForPlayer();
        computerHand = boneyard.handsForPlayer();
    }

    public void humanPlayer() {
        System.out.print("Tray: ");
        System.out.println(hands);
        System.out.println("Human's Turn");
        System.out.println("[p] Play Domino");
        System.out.println("[d] Draw from boneyard");
        System.out.println("[q] Quit");
        cases();
        computerPlayer();
    }

    public void computerPlayer() {
        System.out.print("Tray: ");
        System.out.println(hands);
        System.out.println("Computer's Turn");




    }

    public void p() {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int input =  scanner.nextInt();
        System.out.println("Playing " + hands.get(input));
        playedDomino.add(hands.remove(input));
        System.out.println("Boneyard contains " + boneyard.getBoneyardSize() + " Dominos.");

        System.out.println(playedDomino + "\n");
        currentTurn = false;
//        humanPlayer();

    }

    public void switchTurn() {

    }

    public void cases() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("p")) {
            System.out.println("Which domino?");
            p();
        }
        else if (input.equals("d")) {
            System.out.println("Draw");
        }
    }



}





//        System.out.println("Do you want to flip the domino?");
//        Scanner scanner1 = new Scanner(System.in);
//        String ans = scanner1.nextLine();
//
//        if (ans.equals("yes")){
//            dominos.flipDomino(playedDomino);
//        }
