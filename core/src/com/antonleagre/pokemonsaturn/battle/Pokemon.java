package com.antonleagre.pokemonsaturn.battle;

import com.antonleagre.pokemonsaturn.battle.moves.Moves;
import com.antonleagre.pokemonsaturn.battle.pokemon.Nature;

import static com.antonleagre.pokemonsaturn.battle.pokemon.Nature.LAX;

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



    public enum BasePokemon {

        PIKACHU(Type.ELECTRIC, 35f, 55f, 40f , 50f, 50f, 90f),
        BULBASAUR(Type.GRASS, Type.POISON, 45f, 49f, 49f, 65f, 65f, 45f),
        CHARMANDER(Type.FIRE, 39f, 52f, 43f, 60f, 50f, 65f),
        SQUIRTLE(Type.WATER, 44f, 48f, 65f, 50f, 64f, 43f),
        MARILL(Type.WATER, Type.FAIRY, 70f, 20f, 50f, 20f, 50f, 40f);

        BasePokemon(Type type1, Type type2, float hp, float attack, float defense, float spattack, float spDefense, float speed) {
            this.type1 = type1;
            this.type2 = type2;
            this.hp = hp;
            this.attack = attack;
            this.defense = defense;
            this.spattack = spattack;
            this.spDefense = spDefense;
            this.speed = speed;
        }

        BasePokemon(Type type, float hp, float attack, float defense, float spattack, float spDefense, float speed) {
            this.type1 = type;
            this.type2 = type;
            this.hp = hp;
            this.attack = attack;
            this.defense = defense;
            this.spattack = spattack;
            this.spDefense = spDefense;
            this.speed = speed;
        }

        private final Type type1;
        private final Type type2;
        private final float hp;
        private final float attack;
        private final float defense;
        private final float spattack;
        private final float spDefense;
        private final float speed;


    }

    //the base stats of that kind of pokemon
    private BasePokemon BasePokemon;

    //pokemon specific things
    private static Type type;

    private String name;
    private String nickName;
    private Nature nature;

    //stats; these need to be set by the constructor
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

    }

    public String getName() {
        if(nickName.equals(null)){
            return name;
        }else{
            return nickName;
        }
    }


    private  Pokemon generatePkmn(BasePokemon basePokemon){
       String lowerCase = basePokemon.name().toLowerCase();
       String name = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1); //capitalize

        return null;

    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-----POKEMON-").append(getName()).append("-START-----");
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
