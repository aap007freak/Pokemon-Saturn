package com.antonleagre.pokemonsaturn.model.battle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A Turn in a battle is essentialy a sequence of PMPairs, together with external modifiers
 */
public class Turn {

    private final List<PMPair> pms;

    public Turn(PMPair... pmPairs) {
        this.pms = Arrays.asList(pmPairs);
        //sort the pms
        pms.sort(new MoveSorter().reversed());
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
    private class MoveSorter implements Comparator<PMPair>{
        //instead of using a customized sorter I could use Comparator.thenComparing() i guess
        @Override
        public int compare(PMPair p1, PMPair p2) {

            int priorityCompare = p1.getMove().getBase().getPriority() - p2.getMove().getBase().getPriority();
            if (priorityCompare != 0){
                return priorityCompare;
            }

            return (int) (p1.getUser().getSpeed() - p2.getUser().getSpeed());
        }
    }

}
