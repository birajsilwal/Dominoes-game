package dominos;

import java.util.List;
import java.util.Scanner;

public class Players {

    Boneyard boneyard = new Boneyard();
    private List<Dominos> handsForPlayer;


    // create methods for turns of human and computer, then control them from main controller

    public Players() {
    }

    public void humanPlayer() {

        System.out.println("Tray: ");

        handsForPlayer = boneyard.handsForPlayer();

        System.out.println(handsForPlayer);



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
        System.out.println(handsForPlayer.remove(input));
        System.out.println(handsForPlayer);
    }
}
