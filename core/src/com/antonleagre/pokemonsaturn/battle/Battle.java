package com.antonleagre.pokemonsaturn.battle;

import com.antonleagre.pokemonsaturn.battle.moves.Move;
import com.antonleagre.pokemonsaturn.battle.moves.StatusWeatherMovePattern;
import com.antonleagre.pokemonsaturn.battle.pokemon.Nature;

public class Battle {

    //private fields
    private int numOfTurns = 1;

    //pokemons
    private Pokemon  yourPokemon;
    private Pokemon enemyPokemon;

    private Move moveToBeUsed;

    //battlefield modifiers
    private StatusWeatherMovePattern.Weather weather;


    public Battle(){

    }

    public void move(){
        System.out.println("STARTING MOVE:"  + numOfTurns);
        System.out.println("ENDING MOVE:"  + numOfTurns);
        numOfTurns++;

    }


    public void addWeather(StatusWeatherMovePattern.Weather weather) {
        System.out.println("weather hail added");
    }

    public void removeWeather(StatusWeatherMovePattern.Weather weather) {
        //note this has to be done at the end of every turnm
        System.out.println("weather hail removed");
    }

    public void addEffectToSelf(Nature.StatModifier statModifier, int times) {

    }
    public void addEffectToOpponent(){

    }
    public void addDamageToSelf(float damage){

    }
    public void addDamageToOpponent(float damage){

    }
}
