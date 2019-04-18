package com.antonleagre.pokemonsaturn.battle;

import com.antonleagre.pokemonsaturn.battle.moves.Moves;

public class Battle {

    public enum Weathers{
        RAIN,
        HARSH_SUNLIGHT,

    }

    //pokemons
    private Pokemon  yourPokemon;
    private Pokemon enemyPokemon;

    //battlefield modifiers
    private Weathers weather;

    public Battle(){

    }

    public void initBattle(Pokemon yourPokemon, Pokemon enemyPokemon){
        this.yourPokemon = yourPokemon;
        this.enemyPokemon = enemyPokemon;

    }

    public void move(Moves move){
//        System.out.println(Calculator.calculate(yourPokemon, enemyPokemon, move));
    }

    public void setWeather(Weathers weather) {
        this.weather = weather;
    }

    public Weathers getWeather() {
        return weather;
    }
}
