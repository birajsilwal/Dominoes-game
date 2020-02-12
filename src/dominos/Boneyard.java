package dominos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Boneyard {

    private List<Dominos> boneyardList = new ArrayList<>();
    private List<Dominos> handsForPlayer = new ArrayList<>();


    /* index of j starts from i because we only need items from upper triangular matrix*/
    public Boneyard() {
        for (int i = 0; i < 7; i++){
            for (int j = i; j < 7; j++){
                Dominos dominos = new Dominos(i, j);
                boneyardList.add(dominos);
            }
        }
        Collections.shuffle(boneyardList);
    }


    public List<Dominos> handsForPlayer() {

        for (int i = 0; i < 7; i++) {
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
    public Dominos getDominos(int index) {
//        Dominos d = boneyardList.get(index);
//        boneyardList.remove(d);
        return boneyardList.remove(index);
    }


    public List<Dominos> getAllDominos() { return boneyardList; }






    public int getBoneyardSize() {
        return boneyardList.size();
    }


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

}
