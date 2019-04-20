package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;

public class DamageMovePattern implements MovePattern{

    private float damage;

    public DamageMovePattern(float damage) {
        this.damage = damage;
    }

    @Override
    public void beginBattle() {

    }

    @Override
    public void trigger(Battle battle) {
        battle.addDamageToOpponent(damage);
    }

    @Override
    public void endBattle() {

    }
}
