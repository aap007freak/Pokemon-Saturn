package com.antonleagre.pokemonsaturn.battle.moves;

import com.antonleagre.pokemonsaturn.battle.Battle;

public class WeatherMoveType extends MoveType {

    private Battle.Weathers weather;
    private boolean deleteOtherWeathers;

    private int numOfTurns;
    private int turnsLeft;

    public WeatherMoveType(Battle.Weathers weather, boolean deleteOtherWeathers, int numOfTurns) {
        this.weather = weather;
        this.deleteOtherWeathers = deleteOtherWeathers;
        this.numOfTurns = numOfTurns;
        turnsLeft = numOfTurns;
    }

    @Override
    void trigger(Battle battle) {
        if(numOfTurns == 5){
            battle.setWeather(weather);
        }
        if(numOfTurns == 0){
            battle.setWeather(null);
        }
        turnsLeft -= 1;
    }
}
