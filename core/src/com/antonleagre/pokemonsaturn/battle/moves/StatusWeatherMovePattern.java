package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.Pokemon;

public class StatusWeatherMovePattern extends StatusMovePattern {

    public enum Weather{
        CLEAR_SKIES,
        HARSH_SUNLIGHT,
        RAIN,
        SANDSTORM,
        HAIL,
        FOG
    }

    private Weather weather;

    private int numOfTurns;
    private int turnsActive;




    public StatusWeatherMovePattern(Pokemon.Type type, String name, Weather weatherToEffect, int numOfTurns, int maxPP) {
        this.weather = weatherToEffect;
        this.numOfTurns = numOfTurns;
    }

    @Override
    public void beginBattle() {
        super.beginBattle();
        turnsActive = 0;
    }

    @Override
    public void trigger(Battle battle) {
        turnsActive ++;
        super.trigger(battle);
        if(turnsActive == 1){
            //first turn of the weather effect move
            battle.addWeather(weather);
        }else if (turnsActive < numOfTurns){
            //during one of the turns
        }else if (turnsActive == numOfTurns){
            //the last turn
            battle.removeWeather(weather);
        }
    }
}
