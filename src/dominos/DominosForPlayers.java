package dominos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DominosForPlayers {

    /* array list to store dominos for players*/
    List<Dominos> dominosOfPlayer = new ArrayList<>();

    /*randomize boneyard and get 7 dominos from boneyard and put it to array list than delete that domino */
    public DominosForPlayers (Boneyard boneyard) {
        for (int i = 0; i < 7; i++) {
            int rand = new Random().nextInt(boneyard.boneyardSize());
            dominosOfPlayer.add(boneyard.getDominos(rand));
            boneyard.deleteDomino(rand);
        }
    }

    /** @return size of the dominos of player*/
    public int getSizeOfDominosForPlayer() {
        return dominosOfPlayer.size();

    }

    // create dominos method to pass domino to board

}
