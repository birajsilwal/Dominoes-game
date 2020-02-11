package dominos;

import java.util.Arrays;

public class MainController {

    private Boneyard boneyard;
    private Board board;
    private Dominos dominos;
    private Players players;
    private DominosForPlayers dominosForPlayers;

    public void startGame() {
        boneyard = new Boneyard();
        board = new Board();

    }

    public static void main(String[] args) {

//        for (Dominos d : new Boneyard().getAllDominos()) {
//            System.out.println((d.getLeft() + " , " + d.getRight()));
//        }

//        Boneyard boneyard1 = new Boneyard();
//        DominosForPlayers humanPlayer = new DominosForPlayers();
//
//        for (int i = 0; i < 8; i++) {
//
//            humanPlayer.getDominosForPlayer(boneyard1.getDominos(i));
//
//        }

        System.out.print("Tray: ");
          for (int i = 0; i < 8; i++) {
              for (Dominos dominos : new DominosForPlayers().getDominosForPlayer()) {
                  System.out.print(("[" + dominos.getLeft() + ", " + dominos.getRight() + "] "));
              }
          }

    }
}
