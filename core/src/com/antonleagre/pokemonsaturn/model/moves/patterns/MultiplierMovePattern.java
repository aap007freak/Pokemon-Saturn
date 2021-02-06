package com.antonleagre.pokemonsaturn.model.moves.patterns;

import com.antonleagre.pokemonsaturn.model.battle.Battle;
import com.antonleagre.pokemonsaturn.model.battle.PMPair;
import com.antonleagre.pokemonsaturn.model.moves.MovePattern;

/**
 * MovePattern for moves that change in-battle stats, like {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove#SWORDS_DANCE
 * Swords Dance}.
 */
public class MultiplierMovePattern implements MovePattern {

    public enum AffectedStat {
        ATTACK,
        DEFENSE,
        SPECIAL_ATTACK,
        SPECIAL_DEFENSE,
        SPEED,
        EVASION,
        ACCURACY;
    }

    private final AffectedStat[] affectedStats;
    private final int stages;

    public MultiplierMovePattern(int stages, AffectedStat... affectedStats) {
        this.affectedStats = affectedStats;
        this.stages = stages;
    }

    // TODO: 6/02/2021 this should be checked with negative numbers
    @Override
    public boolean trigger(PMPair pm, Battle battle) {
        for(AffectedStat affectedStat: affectedStats){
            switch (affectedStat) {
                case ATTACK:
                    pm.getUser().raiseAttackModifier(stages);
                    break;
                case DEFENSE:
                    pm.getUser().raiseDefenseModifier(stages);
                    break;
                case SPECIAL_ATTACK:
                    pm.getUser().raiseSpecialAttackModifier(stages);
                    break;
                case SPECIAL_DEFENSE:
                    pm.getUser().raiseSpecialDefenseModifier(stages);
                    break;
                case SPEED:
                    pm.getUser().raiseSpeedModifier(stages);
                    break;
                case ACCURACY:
                    pm.getUser().raiseAccuracyModifier(stages);
                    break;
                case EVASION:
                    pm.getUser().raiseEvasionModifier(stages);
            }
        }
        return false;
    }

    @Override
    public void end() {

    }


}
