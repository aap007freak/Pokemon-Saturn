package com.antonleagre.pokemonsaturn.model.battle;

import com.antonleagre.pokemonsaturn.model.PMPair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A Turn in a battle is essentialy a sequence of PMPairs, together with external modifiers
 */
public class Turn {


    private List<PMPair> pms;

    public Turn(PMPair... pmPairs) {
        this.pms = Arrays.asList(pmPairs);
        //sort the pms
        pms.sort(new Sorter().reversed());
    }

    public void next(){
        PMPair nextPM = pms.get(0);
        nextPM.use();
        pms.remove(0);
    }

    /**
     * implemented: speed, priority
     * todo: items and environmental changes
     */
    private class Sorter implements Comparator<PMPair>{
        //instead of using a customized sorter I could use Comparator.thenComparing() i guess
        @Override
        public int compare(PMPair p1, PMPair p2) {

            int priorityCompare = p1.getMove().getBase().getPriority() - p2.getMove().getBase().getPriority();
            if (priorityCompare != 0){
                return priorityCompare;
            }

            int speedCompare = (int) (p1.getUser().getSpeed() - p2.getUser().getSpeed());
            if (speedCompare != 0) return speedCompare;

            return 0;
        }
    }

}
