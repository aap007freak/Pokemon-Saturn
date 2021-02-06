package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.battle.StatusEffect;

/**
 * MovePattern that encapsulates all moves that do an amount of damage equal to its basepower (including modifiers and
 * stat boosts), including a normal accuracy calculation {@see} {@link com.antonleagre.pokemonsaturn.model.Calculator#calculateAccuracy}
 * <p>
 * These moves also have chance of inflicting a {@link StatusEffect} on the target, with a predetermined chance.
 */
public class DamageAndStatusMovePattern extends DamageMovePattern{

    private StatusEffect effect;
    private float chance;

    /**
     * @param effect Secondary effect
     * @param chance The chance of the secondary effect hitting (0 - 1)
     */
    public DamageAndStatusMovePattern(StatusEffect effect, float chance){
        this.effect = effect;
        this.chance = chance;
    }

    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        boolean result =  super.trigger(pm, battle);
        //secondary effect
        if(willHit(chance)){
            battle.inflictStatusEffect(pm.getTarget(), effect);
        }
        return result;
    }


}
