package dominos;

import java.util.*;

public class DominosForPlayers {

    /* array list to store dominos for players*/
    List<Dominos> dominosOfPlayer = new ArrayList<>();

    Boneyard boneyard = new Boneyard();

    /*randomize boneyard and get 7 dominos from boneyard and put it to array list than delete that domino */
//    public List<Dominos> DominosForPlayers (Boneyard boneyard) {
//        for (int i = 0; i < 7; i++) {
//            int rand = new Random().nextInt(boneyard.boneyardSize());
//            dominosOfPlayer.add(boneyard.getDominos(rand));
//            boneyard.deleteDomino(rand);
//        }
//        return dominosOfPlayer;
//    }


    public DominosForPlayers () {

        int rand = new Random().nextInt(boneyard.boneyardSize());
        dominosOfPlayer.add(new Boneyard().getDominos(rand));
    }


    public List<Dominos> getDominosForPlayer() { return dominosOfPlayer; }


    /** @return size of the dominos of player*/
    public int getSizeOfDominosForPlayer() {
        return dominosOfPlayer.size();
    }

    // create dominos method to pass domino to board

}
