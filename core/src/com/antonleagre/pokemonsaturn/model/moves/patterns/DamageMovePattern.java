package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.PMPair;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

public class DamageMovePattern implements MovePattern {

    private final float power;

    public DamageMovePattern(float power){
        this.power = power;
    }


    @Override
    public void trigger(PMPair pm) {
        System.out.println("A move was used LOL, it's power was " + power);
    }



}
