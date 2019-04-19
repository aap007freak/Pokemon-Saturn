package com.antonleagre.pokemonsaturn.battle;

import com.antonleagre.pokemonsaturn.battle.moves.Move;
import com.antonleagre.pokemonsaturn.battle.moves.StatusWeatherMove;
import com.antonleagre.pokemonsaturn.battle.pokemon.Nature;

public class Battle {

    //private fields
    private int numOfTurns = 1;

    //pokemons
    private Pokemon  yourPokemon;
    private Pokemon enemyPokemon;

    private Move moveToBeUsed;

    //battlefield modifiers
    private StatusWeatherMove.Weather weather;


    public Battle(){
        moveToBeUsed = new StatusWeatherMove(Pokemon.Type.ICE, "Hail", StatusWeatherMove.Weather.HAIL, 5, 15);
    }

    public void move(){
        System.out.println("STARTING MOVE:"  + numOfTurns);
        moveToBeUsed.trigger(this);
        System.out.println("ENDING MOVE:"  + numOfTurns);
        numOfTurns++;

    }


    public void addWeather(StatusWeatherMove.Weather weather) {
        System.out.println("weather hail added");
    }

    public void removeWeather(StatusWeatherMove.Weather weather) {
        //note this has to be done at the end of every turnm
        System.out.println("weather hail removed");
    }

    public void addEffect(Nature.StatModifier statModifier, int times) {
    }
}
