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
    private BaseStats baseStats;

    //pokemon specific things
    private Nature nature;
    private IndividualValues iVs;

    private final String name;
    private String nickName = "";

    //stats
    private EffortValues eVs;
    private int level;

    private float hp;
    private float attack;
    private float defense;
    private float spAttack;
    private float spDefense;
    private float speed;

    private Moves move1;
    private Moves move2;
    private Moves move3;
    private Moves move4;

    public Pokemon(int startingLevel, BaseStats base){
        this.baseStats = base;
        this.level = startingLevel;

        //capitalize basestats name
        this.name = baseStats.name().substring(0,1) + baseStats.name().substring(1).toLowerCase();

        this.nature = Nature.generateNature();
        this.iVs = IndividualValues.generateIVs();
        this.eVs = EffortValues.generateEffortValues(EffortValues.EVYieldByPokemon.valueOf(baseStats.name())); //todo check errors

        this.hp = Calculator.calculateHPStat(this);
        this.attack = Calculator.calculateAttackStat(this);
        this.defense = Calculator.calculateDefenseStat(this);
        this.spAttack = Calculator.calculateSpecialAttackStat(this);
        this.spDefense = Calculator.calculateSpecialDefenseStat(this);
        this.speed = Calculator.calculateSpeedStat(this);



    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public Nature getNature() {
        return nature;
    }

    public IndividualValues getiVs() {
        return iVs;
    }

    public EffortValues geteVs() {
        return eVs;
    }

    public float getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        if(nickName.equals("")){
            return name;
        }else{
            return nickName;
        }
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getSpAttack() {
        return spAttack;
    }

    public float getSpDefense() {
        return spDefense;
    }

    public float getSpeed() {
        return speed;
    }

    public static void main(String[] args) {
        System.out.println(new Pokemon(5, BaseStats.BULBASAUR));
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
