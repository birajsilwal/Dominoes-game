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
    private boolean currentTurn = true;

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
            int sizeofplayeddomino = playedDomino.size();

//            if(playedDomino.get(0).getLeft() == tempLeft) {
//
//            }
//
//
//
//            if(playedDomino.get(0).getRight() == tempRight){
//
//            }


            if (playedDomino.get(sizeofplayeddomino-1).getRight() == tempRight ||  playedDomino.get(sizeofplayeddomino-1).getRight() == tempLeft){
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
            p();
        }
        else if (input.equals("d")) {
            System.out.println("Draw");
        }
    }

    public void p() {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int input =  scanner.nextInt();
        System.out.println("Playing " + humanHand.get(input));
//        playedDomino.add(humanHand.remove(input));

        addToPlayedDomino(input);
        System.out.println("Boneyard contains " + boneyard.getBoneyardSize() + " Dominos.");

        System.out.println(playedDomino + "\n");
        currentTurn = false;
//        humanPlayer();

    }

    public void addToPlayedDomino(int index) {
        playedDomino.add(humanHand.remove(index));
    }


}



//        System.out.println("Do you want to flip the domino?");
//        Scanner scanner1 = new Scanner(System.in);
//        String ans = scanner1.nextLine();
//
//        if (ans.equals("yes")){
//            dominos.flipDomino(playedDomino);
//        }
