package dominos;

import java.util.List;
import java.util.Scanner;

public class Players {

    private List<Dominos> humanHandList;
    private List<Dominos> computerHandList;
    int input;

    public Players(List<Dominos> humanHandList, List<Dominos> computerHandList) {
        this.humanHandList = humanHandList;
        this.computerHandList = computerHandList;
    }

    public int getComputerHandSize() { return computerHandList.size(); }

    public List<Dominos> getHumanHand() { return humanHandList; }

    public List<Dominos> getComputerHand() { return computerHandList; }

    /* method to quit the game */
    public void quit() {
        System.out.println("Thank you for playing this game.");
        System.exit(0);
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
    private void computerFlip(int i) {
        computerHandList.get(i).flipDomino();
    }

    /* this method have all the logic for computer player
     * depending on the different situation, computer player chooses dominos tiles*/
    public void computerCases(List<Dominos> playedDomino) {
        for (int i = 0; i < computerHandList.size(); i++) {
            Dominos computerDomino = computerHandList.get(i);

            int tempLeft = computerDomino.getLeft();
            int tempRight = computerDomino.getRight();
            int sizeOfPlayedDomino = playedDomino.size();

            if (playedDomino.get(sizeOfPlayedDomino-1).getRight() == tempLeft) {
                playedDomino.add(computerHandList.remove(i));
                break;
            }

            else if (playedDomino.get(sizeOfPlayedDomino-1).getRight() == tempRight) {
                computerFlip(i);
                playedDomino.add(computerHandList.remove(i));
                break;
            }

            else if (playedDomino.get(sizeOfPlayedDomino-1).getRight() != tempRight || playedDomino.get(sizeOfPlayedDomino-1).getRight() != tempLeft ) {
                if (tempRight == 0 || tempLeft == 0) {
                    playedDomino.add(computerHandList.remove(i));
                    break;
                }
            }
        }
    }

}