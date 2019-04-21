package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.Battle;

/**
 * Please note that the DamageMovePatten class is blind to the battle environment, so it can only pass trough the power value.
 * Actual damage Calculation doesn't happen here
 */
public class DamageMovePattern implements MovePattern{

    private float power;

    public DamageMovePattern(float power) {
        this.power = power;
    }

    @Override
    public void beginBattle() {

    }

    @Override
    public void trigger(Battle battle) {
        battle.addDamageToOpponent(power);
    }

    @Override
    public void endBattle() {

    }
}
