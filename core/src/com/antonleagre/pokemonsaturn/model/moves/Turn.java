package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.PMPair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Turn {


    private PMPair[] pmPairs;
    private int currentIndex;

    public Turn(PMPair... pmPairs){
        this.pmPairs = pmPairs;
        sort();
        currentIndex = 0;
    }

    public void next(){
        pmPairs[currentIndex].getMove().getMove().getFunctionality().trigger();
        currentIndex++;

    }

    private void sort(){

        //for now we only track speed priority and move priority
        //todo add more to the speed system.
        Arrays.sort(this.pmPairs, Collections.reverseOrder(new Comparator<PMPair>() {
            @Override
            public int compare(PMPair o1, PMPair o2) {
                return (int) (( o1.getMove().getMove().getPriority() * 1000 + o1.getUser().getSpeed() )- (o2.getMove().getMove().getPriority() * 1000 + o2.getUser().getSpeed()));
            }
        }));
    }
}
