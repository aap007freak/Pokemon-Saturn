package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.Pokemon;
import com.antonleagre.pokemonsaturn.battle.pokemon.Nature;

public class StatusStatMove extends StatusMove {

    private Nature.StatModifier statModifier;
    private int times;

    public StatusStatMove(Pokemon.Type type, String name, int maxPP, Nature.StatModifier modifier, int times) {
        super(type, name, maxPP);
        this.statModifier = modifier;
    }

    @Override
    public void trigger(Battle battle) {
        super.trigger(battle);
        battle.addEffect(statModifier, times);

    }
}
