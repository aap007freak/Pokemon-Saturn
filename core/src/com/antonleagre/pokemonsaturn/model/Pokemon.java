package com.antonleagre.pokemonsaturn.model;

import com.antonleagre.pokemonsaturn.model.moves.Move;
import com.antonleagre.pokemonsaturn.model.pokemon.BaseStats;
import com.antonleagre.pokemonsaturn.model.pokemon.EffortValues;
import com.antonleagre.pokemonsaturn.model.pokemon.IndividualValues;
import com.antonleagre.pokemonsaturn.model.pokemon.Nature;


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

    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    public Pokemon(int startingLevel, BaseStats base){
        this.baseStats = base;
        this.level = startingLevel;

        //capitalize basestats name
        this.name = baseStats.name().substring(0,1) + baseStats.name().substring(1).toLowerCase();

        this.nature = Nature.generateNature();
        this.iVs = IndividualValues.generateIVs();
        this.eVs = EffortValues.generateEffortValues(EffortValues.EVYieldByPokemonDefeated.valueOf(baseStats.name())); //todo check errors

        setStats();
    }



    public void levelUp(){
        level++;
        setStats();
    }

    private void setStats(){
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

    public void minusHp(float f){
        hp -= f;
    }
    public void plusHp(float f){
        hp += f;
    }

    public Move getMove1() {
        return move1;
    }

    public void setMove1(Move move1) {
        this.move1 = move1;
    }

    public Move getMove2() {
        return move2;
    }

    public void setMove2(Move move2) {
        this.move2 = move2;
    }

    public Move getMove3() {
        return move3;
    }

    public void setMove3(Move move3) {
        this.move3 = move3;
    }

    public Move getMove4() {
        return move4;
    }

    public void setMove4(Move move4) {
        this.move4 = move4;
    }

    public static void main(String[] args) {
        System.out.println(new Pokemon(20, BaseStats.GARCHOMP));
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
