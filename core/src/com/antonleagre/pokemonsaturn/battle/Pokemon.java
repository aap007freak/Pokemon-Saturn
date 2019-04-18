package com.antonleagre.pokemonsaturn.battle;

import com.antonleagre.pokemonsaturn.battle.moves.Moves;
import com.antonleagre.pokemonsaturn.battle.pokemon.BaseStats;
import com.antonleagre.pokemonsaturn.battle.pokemon.EffortValues;
import com.antonleagre.pokemonsaturn.battle.pokemon.IndividualValues;
import com.antonleagre.pokemonsaturn.battle.pokemon.Nature;

/*
       This class is enum paradise but hey
 */
public class Pokemon {

    public enum Type {
        NORMAL,
        FIGHTING,
        FLYING,
        POISON,
        GROUND,
        ROCK,
        BUG,
        GHOST,
        STEEL,
        FIRE,
        WATER,
        GRASS,
        ELECTRIC,
        PSYCHIC,
        ICE,
        DRAGON,
        DARK,
        FAIRY
    }

    //the base stats of that kind of pokemon
    private  BaseStats baseStats;

    //pokemon specific things
    private static Type type;
    private Nature nature;
    private IndividualValues iVs;

    private String name;
    private String nickName;

    //stats
    private EffortValues eVs;
    private float hp;
    private float level;
    private float attack;
    private float defense;
    private float spAttack;
    private float spDefense;
    private float speed;

    private Moves move1;
    private Moves move2;
    private Moves move3;
    private Moves move4;


    public Pokemon(){
        eVs = EffortValues.generateEffortValues(EffortValues.EVYieldByPokemon.MARILL);
    }

    public String getName() {
        if(nickName.equals(null)){
            return name;
        }else{
            return nickName;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Pokemon().eVs);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-----POKEMON-").append(getName()).append("-START-----");
        builder.append("\n");
        builder.append("Nature: ").append(nature);
        builder.append("\n");
        builder.append("IV's: ").append(iVs);
        builder.append("\n");
        builder.append("EV's: ").append(eVs);
        builder.append("\n");
        builder.append("Stats: HP: ").append(hp);
        builder.append("\n");
        builder.append("       Attack: ").append(attack);
        builder.append("\n");
        builder.append("       Defense: ").append(defense);
        builder.append("\n");
        builder.append("       Special Attack: ").append(spAttack);
        builder.append("\n");
        builder.append("       Special Defense: ").append(spDefense);
        builder.append("\n");
        builder.append("       Speed: ").append(speed);
        builder.append("\n");
        builder.append("-----POKEMON-").append(getName()).append("-END-------");
        return builder.toString();
    }
}
