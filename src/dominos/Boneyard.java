package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* this class contains all the possible dominos i.e. 28 */
public class Boneyard {

    private int dominosForPlayer = 7;
    /**@var handsForPlayer is the list that contains 7 dominos for each player */
    List<Dominos> handsForPlayer;
    private List<Dominos> boneyardList = new ArrayList<>();

    /* index of j starts from i because we only need items from upper triangular matrix*/
    public Boneyard() {
        for (int i = 0; i < dominosForPlayer; i++){
            for (int j = i; j < dominosForPlayer; j++){
                Dominos dominos = new Dominos(i, j);
                boneyardList.add(dominos);
            }
        }
        Collections.shuffle(boneyardList);
    }

    /* generate 7 random dominos for each player from boneyard (from 28 total)*/
    public List<Dominos> handsForPlayer() {
        List<Dominos> handsForPlayer = new ArrayList<>();

        for (int i = 0; i < dominosForPlayer; i++) {
            int rand = new Random().nextInt(getBoneyardSize());
            handsForPlayer.add(getDominos(rand));
        }
        return handsForPlayer;
    }

    public Dominos getSelectedDomino(int index) {
        return handsForPlayer.get(index);
    }

    /**
     * @param index is the index of the domino
     * @return domino of the given specific index */
    public Dominos getDominos(int index) { return boneyardList.remove(index); }

    public List<Dominos> getAllDominos() { return boneyardList; }

    public int getBoneyardSize() { return boneyardList.size(); }

    /* this method is used to get domino from boneyard if needed */
    public void drawFromBoneyard() {
        if (boneyardList.size() >= 1)
            getDominos(0);
            boneyardList.remove(0);
    }

    /** @return true if the size of the boneyard is 0 or less*/
    public boolean isEmpty() {
        return boneyardList.size() <= 0;
    }

    /**@return the first indexed domino from the boneyard */
    public Dominos pickFromBoneYard () {
        return boneyardList.remove(0);
    }

}
