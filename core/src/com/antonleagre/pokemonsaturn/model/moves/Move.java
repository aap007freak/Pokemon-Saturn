package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.PMPair;
import com.antonleagre.pokemonsaturn.model.Pokemon;

public class Move {

    private Pokemon owner;
    private BaseMove move;

    private int pPleft;
    private boolean hardDisabled = false; //when the user can't click on the move at all (disable move)


    public  Move(Pokemon owner, BaseMove baseMove){
        this.owner = owner;
        this.move = baseMove;

        this.pPleft = baseMove.getMaxPP();
    }

    public boolean use(PMPair pmPair){ //pmPair contains info about target and such
        if (hardDisabled) return false;
        move.getFunctionality().trigger(pmPair);
        return true;
    }


    public BaseMove getBase() {
        return move;
    }

}
