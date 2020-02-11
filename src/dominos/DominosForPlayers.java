package dominos;

import java.util.*;

public class DominosForPlayers {

    /* array list to store dominos for players*/
    List<Dominos> dominosOfPlayer = new ArrayList<>();

    /*randomize boneyard and get 7 dominos from boneyard and put it to array list than delete that domino */



    public DominosForPlayers () {
        Boneyard boneyard = new Boneyard();
        int rand = new Random().nextInt(boneyard.boneyardSize());
        dominosOfPlayer.add(new Boneyard().getDominos(rand));
    }


    public List<Dominos> getDominosForPlayer() {
        return dominosOfPlayer;
    }






//    /** @return size of the dominos of player*/
//    public int getSizeOfDominosForPlayer() {
//        return dominosOfPlayer.size();
//    }



}
