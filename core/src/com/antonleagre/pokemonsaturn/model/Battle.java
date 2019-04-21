package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.moves.BaseMove;
import com.antonleagre.pokemonsaturn.model.moves.Move;
import com.antonleagre.pokemonsaturn.model.moves.StatusWeatherMovePattern;
import com.antonleagre.pokemonsaturn.model.pokemon.BaseStats;
import com.antonleagre.pokemonsaturn.model.pokemon.Nature;

public class Battle {

    //private fields
    private int numOfTurns = 1;

    //pokemons
    private Pokemon  yourPokemon;
    private Pokemon opponentPokemon;

    private BaseMove baseMoveToBeUsed;

    //battlefield modifiers
    private StatusWeatherMovePattern.Weather weather;


    public Battle(){
        this.yourPokemon = new Pokemon(10, BaseStats.PIKACHU);
        yourPokemon.setMove1(new Move(BaseMove.POUND));
        this.opponentPokemon = new Pokemon(10, BaseStats.MARILL);
    }

    public void move(){
        System.out.println("STARTING MOVE:"  + numOfTurns);
        System.out.println("Pokemon that is going to attack: \n");
        System.out.println(yourPokemon);
        System.out.println("Pokemon that is going to defend: \n");
        System.out.println(opponentPokemon);
        yourPokemon.getMove1().use(this);
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
    public void addDamageToOpponent(float power){
        float damage = Calculator.calculateDamage(yourPokemon, opponentPokemon, power);
        opponentPokemon.minusHp(damage);
        //todo it will always add the damage to the opponent pokemon insted of to the other one, does that make sense?
    }
}
