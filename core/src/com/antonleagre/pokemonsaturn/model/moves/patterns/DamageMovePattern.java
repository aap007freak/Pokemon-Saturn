package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.Calculator;
import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

import java.util.Random;


/**
 * MovePattern that encapsulates all moves that do an amount of damage equal to its basepower (including modifiers and
 * stat boosts), including a normal accuracy calculation {@see} {@link com.antonleagre.pokemonsaturn.model.Calculator#calculateAccuracy}
 */
public class DamageMovePattern implements MovePattern {

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        float accuracy = Calculator.calculateAccuracy(pm, battle);
        float critRatio = pm.getUser().getCritRatio();
        if (willHit(accuracy)) {
            float damage = Calculator.calculateDamage(pm.getUser(), pm.getTarget(), pm.getMove().getBase(), pm.getMove().getBase().getBasePower());
            if (willCrit(critRatio)) {
                damage *= 2; // TODO: 5/02/2021 this *2 multiplier for crit is a bit more nuanced:
                // @see https://bulbapedia.bulbagarden.net/wiki/Critical_hit The Gen 2 onwards section
            }
            battle.inflictDamage(pm.getTarget(), damage);
        }
        return false;
    }

    @Override
    public void end() {

    }

    protected boolean willHit(float accuracy) {
        return new Random().nextFloat() <= accuracy;
    }

    protected boolean willCrit(float critRatio) {
        return new Random().nextFloat() <= critRatio;

    }


}
