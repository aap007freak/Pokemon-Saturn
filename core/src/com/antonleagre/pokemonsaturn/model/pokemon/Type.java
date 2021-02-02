package com.antonleagre.pokemonsaturn.model.pokemon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Each Pokemon has one Type or two Types which determine how much damage it will take from certain moves. It also
 * comes up in other aspects of the game and other calculations like STAB @see {@link
 * com.antonleagre.pokemonsaturn.model.Calculator}
 */
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
    FAIRY;

    /**
     * We use a float array here instead of declaring type effectiveness in the enum constructors like in the {@link
     * Nature} enum for two
     * reasons:
     *
     * <p>1. We will often need those values in calculations<p>
     *
     * <p>2. We cant say NORMAL( (weak to) TYPE.FIGHTING)) 'cause that would be a recursive problem<p>
     *
     * <p>
     * The Float Array is the same as on <a href="https://bulbapedia.bulbagarden.net/wiki/Type/Type_chart">Bulbapedia</a>
     * Namely the Attacking type is vertical, the defending type is horizontal
     */
    public static final float[][] typeEffectivenessChart = {
            {1, 1, 1, 1, 1, 0.5f, 1, 0, 0.5f, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 1, 0.5f, 0.5f, 1, 2, 0.5f, 0, 2, 1, 1, 1, 1, 0.5f, 2, 1, 2},
            {1, 2, 1, 1, 1, 0.5f, 2, 1, 0.5f, 1, 1, 2, 0.5f, 1, 1, 1, 1},
            {1, 1, 1, 0.5f, 0.5f, 0.5f, 1, 0.5f, 0, 1, 1, 2, 1, 1, 1, 1, 1},
            {1, 1, 0, 2, 1, 2, 0.5f, 1, 2, 2, 1, 0.5f, 2, 1, 1, 1, 1},
            {1, 0.5f, 2, 1, 0.5f, 1, 2, 1, 0.5f, 2, 1, 1, 1, 1, 2, 1, 1},
            {1, 0.5f, 0.5f, 0.5f, 1, 1, 1, 0.5f, 0.5f, 0.5f, 1, 2, 1, 2, 1, 1, 2},
            {0, 1, 1, 1, 1, 1, 1, 2, 0.5f, 1, 1, 1, 1, 2, 1, 1, 0.5f},
            {1, 1, 1, 1, 1, 2, 1, 1, 0.5f, 0.5f, 0.5f, 1, 0.5f, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 0.5f, 2, 1, 2, 0.5f, 0.5f, 2, 1, 1, 2, 0.5f, 1},
            {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5f, 0.5f, 1, 1, 1, 0.5f, 1},
            {1, 1, 0.5f, 0.5f, 2, 2, 0.5f, 1, 0.5f, 0.5f, 2, 0.5f, 1, 1, 1, 0.5f, 1},
            {1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5f, 0.5f, 1, 1, 0.5f, 1},
            {1, 2, 1, 2, 1, 1, 1, 1, 0.5f, 1, 1, 1, 1, 0.5f, 1, 1, 0},
            {1, 1, 2, 1, 2, 1, 1, 1, 0.5f, 0.5f, 0.5f, 2, 1, 1, 0.5f, 2, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0.5f, 1, 1, 1, 1, 1, 1, 2, 1},
            {1, 0.5f, 1, 1, 1, 1, 1, 2, 0.5f, 1, 1, 1, 1, 2, 1, 1, 0.5f}
    }; // TODO: 2/02/2021 This chart obvously has no FAIRY, so checking for FAIRY type will give errors

    //helper method
    private static int getIndexFromType(Type type) {
        return IntStream.range(0, 17)
                .filter(i -> type.equals(Type.values()[i]))
                .findFirst().getAsInt();
    }

    //helper method
    private static Type getTypeFromIndex(int i) {
        return Type.values()[i];
    }

    /**
     * Gives a Set of Types that the attacking type is super effective to.
     * <p>
     * E.g. getTypesSuperEffectiveToWhenAttacking(Type.FIGHTING) returns [ICE, DARK, NORMAL, ROCK, STEEL]
     *
     * @param type An Attacking Type
     *
     * @return A Set of Types the parameter type will be super effective to when attacking
     */
    public static Set<Type> getTypesSuperEffectiveToWhenAttacking(Type type) {
        int typeIndex = getIndexFromType(type);
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < typeEffectivenessChart[typeIndex].length; i++) {
            if (typeEffectivenessChart[typeIndex][i] == 2) {
                indices.add(i);
            }
        }

        return indices.stream().map(Type::getTypeFromIndex).collect(Collectors.toSet());
    }

    /**
     * Gives a Set of Types that the attacking type is not very effective to.
     * <p>
     * E.g. getTypesNotVeryEffectiveToWhenAttacking(Type.FIGHTING) returns [PSYCHIC, FLYING, POISON, BUG]
     *
     * @param type An Attacking Type
     *
     * @return A Set of Types the parameter type will be not very effective to when attacking
     */
    public static Set<Type> getTypesNotVeryEffectiveToWhenAttacking(Type type) {
        int typeIndex = getIndexFromType(type);
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < typeEffectivenessChart[typeIndex].length; i++) {
            if (typeEffectivenessChart[typeIndex][i] == 0.5f) {
                indices.add(i);
            }
        }

        return indices.stream().map(Type::getTypeFromIndex).collect(Collectors.toSet());
    }

    /**
     * Gives a Set of Types that the attacking type will do no damage to - the defending Pokemon is immune.
     * <p>
     * E.g. getTypesImmuneToWhenAttacking(Type.FIGHTING) returns [GHOST]
     *
     * @param type An Attacking Type
     *
     * @return A Set of Types the parameter type will do no damage to
     */
    public static Set<Type> getTypesImmuneToWhenAttacking(Type type) {
        int typeIndex = getIndexFromType(type);
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < typeEffectivenessChart[typeIndex].length; i++) {
            if (typeEffectivenessChart[typeIndex][i] == 0) {
                indices.add(i);
            }
        }

        return indices.stream().map(Type::getTypeFromIndex).collect(Collectors.toSet());
    }

    /**
     * Gives a Set of Types that the attacking type will be normal effective to.
     * <p>
     * E.g. getTypesNormalEffectivenessToWhenAttacking(Type.FIGHTING) returns [WATER, ELECTRIC, GRASS, FIGHTING, GROUND,
     * DRAGON, FIRE]
     *
     * @param type An Attacking Type
     *
     * @return A Set of Types the parameter type will be normal effective to
     */
    public static Set<Type> getTypesNormalEffectivenessToWhenAttacking(Type type) {
        int typeIndex = getIndexFromType(type);
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < typeEffectivenessChart[typeIndex].length; i++) {
            if (typeEffectivenessChart[typeIndex][i] == 1) {
                indices.add(i);
            }
        }

        return indices.stream().map(Type::getTypeFromIndex).collect(Collectors.toSet());
    }

    /**
     * @param attackingType Type of attacking {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove move}
     * @param defendingType Type of defending {@link com.antonleagre.pokemonsaturn.model.Pokemon}
     *
     * @return 0, 0.5f, 1, 2; depending on the combinations of attackingType and defendingType
     */
    public static float getTypeModifier(Type attackingType, Type defendingType) {
        return typeEffectivenessChart[getIndexFromType(attackingType)][getIndexFromType(defendingType)];
    }

    /**
     * @param attackingtype Type of attacking {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove move}
     * @param defendingType Type of defending {@link com.antonleagre.pokemonsaturn.model.Pokemon}
     *
     * @return if the defendingType is immune to the type of the attacking move
     */
    public static boolean isImmuneTo(Type attackingtype, Type defendingType) {
        return getTypesImmuneToWhenAttacking(attackingtype).contains(defendingType);
    }

    /**
     * @param attackingtype Type of attacking {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove move}
     * @param defendingType Type of defending {@link com.antonleagre.pokemonsaturn.model.Pokemon}
     *
     * @return if the type of the attacking move is super effective to the defending type
     */
    public static boolean isSuperEffectiveTo(Type attackingtype, Type defendingType) {
        return getTypesSuperEffectiveToWhenAttacking(attackingtype).contains(defendingType);
    }

    /**
     * @param attackingType Type of attacking {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove move}
     * @param defendingType Type of defending {@link com.antonleagre.pokemonsaturn.model.Pokemon}
     *
     * @return if the type of the attacking move is not very effective to the defending type
     */
    public static boolean isNotVeryEffictiveTo(Type attackingType, Type defendingType) {
        return getTypesNotVeryEffectiveToWhenAttacking(attackingType).contains(defendingType);
    }

    /**
     * @param attackingType Type of attacking {@link com.antonleagre.pokemonsaturn.model.moves.BaseMove move}
     * @param defendingType Type of defending {@link com.antonleagre.pokemonsaturn.model.Pokemon}
     *
     * @return if the type of the attacking move normal effective to the defending type
     */
    public static boolean isNormaEffectiveTo(Type attackingType, Type defendingType) {
        return getTypesNormalEffectivenessToWhenAttacking(attackingType).contains(defendingType);
    }

    //I normally use this url:  https://bulbapedia.bulbagarden.net/wiki/Type/Type_chart
    static EffortValues grabTypeEffectivenessChart(String url) {
        try {
            Document parsed = Jsoup.connect(url).get();
            Element table = parsed.select("table.roundy").get(1); // the first table is from Gen I
            Elements rows = table.select("tr"); //rows

            for (Element row : rows) {
                StringBuilder outString = new StringBuilder("{");
                Elements tds = row.select("td");
                for (Element td : tds) {
                    String text = td.text();
                    if (text.startsWith("2")) {
                        outString.append("2, ");
                    } else if (text.startsWith("1")) {
                        outString.append("1, ");
                    } else if (text.startsWith("0")) {
                        outString.append("0, ");
                    } else { // some weird character that's not in UTF-8
                        outString.append("0.5f, ");
                    }
                }
                outString.append("},");
                System.out.println(outString);
                //String rowstring = row.select("td").stream().map(Element::text).reduce((s, s2) -> s + ", " + s2).get();
                //fancy streams didn't work out as intended

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Type.getTypesNormalEffectivenessToWhenAttacking(Type.FIGHTING));
    }
}
