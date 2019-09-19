package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.battle.Turn;
import com.antonleagre.pokemonsaturn.model.moves.BaseMove;
import com.antonleagre.pokemonsaturn.model.moves.Move;
import com.antonleagre.pokemonsaturn.model.pokemon.BaseStats;

public class TextMain {

    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon(5, BaseStats.PIKACHU);
        Pokemon marill = new Pokemon(5, BaseStats.MARILL);

        //in normal scenerios this is already set and we get the move chosen from the user
        pikachu.setMove1(new Move(pikachu, BaseMove.POUND)); //pikachu's own pound move
        marill.setMove1(new Move(marill, BaseMove.POUND)); //pikachu's own pound move


        PMPair myPMP = new PMPair(pikachu, pikachu.getMove1(), marill);
        PMPair enemyPMP = new PMPair(marill, marill.getMove1(), pikachu);


        //battle sequence

        //determine who goes first
        new Turn(myPMP, enemyPMP);

    }
}
