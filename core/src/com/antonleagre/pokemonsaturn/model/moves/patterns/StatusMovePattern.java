package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.PMPair;
import com.antonleagre.pokemonsaturn.model.battle.StatusEffect;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

public class StatusMovePattern implements MovePattern {

    private StatusEffect statusEffect;

    public StatusMovePattern(StatusEffect effect){
        this.statusEffect = effect;
    }


    @Override
    public void trigger(PMPair pm) {

    }
}
