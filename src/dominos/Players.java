package dominos;

import java.util.Scanner;

public class Players {

    // create methods for turns of human and computer, then control them from main controller

    public Players() {
    }

    public void humanPlayer() {
        System.out.println();
        System.out.println("Human's Turn");
        System.out.println("[p] Play Domino");
        System.out.println("[d] Draw from boneyard");
        System.out.println("[q] Quit");

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

    public void computerPlayer() {
    }

    public void p() {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int input =  scanner.nextInt();

        Dominos dominos = new DominosForPlayers().getSelectedDomino(input);
        System.out.println("[" + dominos.getLeft() + ", " + dominos.getRight() + "] ");

    }

}
