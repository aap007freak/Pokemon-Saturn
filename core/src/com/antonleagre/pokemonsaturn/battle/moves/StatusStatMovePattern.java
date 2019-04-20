package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.Pokemon;
import com.antonleagre.pokemonsaturn.battle.pokemon.Nature;

public class StatusStatMovePattern extends StatusMovePattern {

    private Nature.StatModifier statModifier;
    private int times;

    public StatusStatMovePattern(Pokemon.Type type, String name, int maxPP, Nature.StatModifier modifier, int times) {
        this.statModifier = modifier;
    }

    @Override
    public void trigger(Battle battle) {
        super.trigger(battle);
        battle.addEffectToSelf(statModifier, times);

    }
}
