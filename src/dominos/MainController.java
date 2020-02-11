package dominos;

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

        Boneyard boneyard1 = new Boneyard();
        DominosForPlayers humanPlayer = new DominosForPlayers();

//        for (int i = 0; i < 8; i++) {
//                boneyard1.handsForPlayer();
//        }


        System.out.print("Human's Dominos: ");
//          for (int i = 0; i < 7; i++) {
//              for (Dominos dominos : new DominosForPlayers().getDominosForPlayer()) {
//                  System.out.print(("[" + dominos.getLeft() + ", " + dominos.getRight() + "] "));
//              }
//          }



        new Players().humanPlayer();

    }
}
