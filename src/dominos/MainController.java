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
        dominosForPlayers = new DominosForPlayers(boneyard);

    }

    public static void main(String[] args) {

    }
}
