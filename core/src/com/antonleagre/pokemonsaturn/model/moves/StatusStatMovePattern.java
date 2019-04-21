package com.antonleagre.pokemonsaturn.model.moves;

import com.antonleagre.pokemonsaturn.model.Battle;
import com.antonleagre.pokemonsaturn.model.Pokemon;
import com.antonleagre.pokemonsaturn.model.pokemon.Nature;

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
