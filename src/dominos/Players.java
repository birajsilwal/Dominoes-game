package dominos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Players {

    Boneyard boneyard = new Boneyard();
    private Dominos dominos;
    private List<Dominos> humanHand;
    private List<Dominos> computerHand;
    private List<Dominos> playedDomino = new ArrayList<>();

    public Players() {
        humanHand = boneyard.handsForPlayer();
        computerHand = boneyard.handsForPlayer();
    }

    public void humanPlayer() {
        System.out.print("Tray: ");
        System.out.println(humanHand);
        System.out.println("Human's Turn");
        System.out.println("[p] Play Domino");
        System.out.println("[d] Draw from boneyard");
        System.out.println("[q] Quit");
        cases();
        computerPlayer();
        humanPlayer();
    }

    public void computerPlayer() {
        System.out.print("Tray: ");
        System.out.println(humanHand);

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

            if (playedDomino.get(sizeOfPlayedDomino-1).getRight() == tempRight ||  playedDomino.get(sizeOfPlayedDomino-1).getRight() == tempLeft){
                playedDomino.add(computerHand.remove(i));
            }
        }

        System.out.println("Computer's Turn");
        System.out.println("computer hand size: " + computerHand.size());
        System.out.println(playedDomino + "\n");
        System.out.println("==================================================");
    }

    public void cases() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("p")) {
            System.out.println("Which domino?");
            play();
        }
        else if (input.equals("d")) {
            System.out.println("Draw");
        }
        else if (input.equals("q")) {
            quit();
        }
    }

    public void play() {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int input =  scanner.nextInt();
        System.out.println("Playing " + humanHand.get(input));

        addToPlayedDomino(input);
        System.out.println("Boneyard contains " + boneyard.getBoneyardSize() + " Dominos.");

        System.out.println(playedDomino + "\n");
    }

    public void addToPlayedDomino(int index) {
        playedDomino.add(humanHand.remove(index));
    }

    public void flipOrNot() {
        int index = 1;
        System.out.println("Do you want to flip the domino?");
        Scanner scanner1 = new Scanner(System.in);
        String flipOrNot = scanner1.nextLine();

        if (flipOrNot.equals("yes")){
            dominos.flipDomino(playedDomino, index);
        }
    }

    public void quit() {
        System.out.println("Thank you for playing this game.");
        System.exit(0);
    }
}