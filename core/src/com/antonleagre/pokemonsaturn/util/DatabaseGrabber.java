package com.antonleagre.pokemonsaturn.util;

import com.antonleagre.pokemonsaturn.model.pokemon.EggGroup;
import com.antonleagre.pokemonsaturn.model.pokemon.ExpGrowth;
import com.antonleagre.pokemonsaturn.model.pokemon.Gender;
import com.antonleagre.pokemonsaturn.model.pokemon.Type;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import sun.security.pkcs11.wrapper.Constants;

import java.awt.geom.FlatteningPathIterator;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class DatabaseGrabber {

    public static final int LAST_POKEDEX_NUM_TO_BE_ADDED = 251;

    public static void main(String[] args) {
        newer(251);
    }

    /**
     * Gets the data link from the Serebii database, which is the only one that has "outdated" info (i. e. without fairy).
     */
    public static void newer(int lastPokedexNum){
        for (int i = 1; i <= lastPokedexNum; i++){
            try {
                Element parsed = Jsoup.connect(String.format("https://www.serebii.net/pokedex-dp/%03d.shtml", i)).get();

                Elements rows = parsed.select("table.dextable > tbody > tr");
                /*
                    Dextables are tables with:
                        1 Row with the name of the data
                        1 Row with the actual data
                        1 Row with the name of the data
                        1 Row with the actual data
                        ...

                        So if you want to get data at spot 2 with 4 collums, its actually at td 6
                 */

                /*
                    third and fourth rows store:
                        name
                        jpname
                        no
                        gender ratio
                        type
                 */
                Element row4 = rows.get(3); //first three rows aren't relevant
                Elements row4data = row4.children();

                //name
                String name = row4data.get(0).text(); //1st of second row

                //no
                Element noTD = row4data.get(2);
                Elements noTDrows = noTD.select("td"); //this also selects nested stuff, and that's why the code below is a bit weird
                int nationalIndex = 0;
                int johtoIndex = 0;
                if (noTDrows.size() < 6){ //only has national and johto
                     nationalIndex = Integer.parseInt(noTDrows.get(2).text().substring(1));
                     johtoIndex = Integer.parseInt(noTDrows.get(4).text().substring(1));
                }else if(noTDrows.size() == 7){ //has national, johto and sinnoh
                    nationalIndex = Integer.parseInt(noTDrows.get(2).text().substring(1));
                    johtoIndex = Integer.parseInt(noTDrows.get(6).text().substring(1));
                }else{
                    // TODO: 13/09/2020 error catching
                    System.out.println("Parsed incorrectly");
                }

                //female to male ratio
                Element mfTD = row4data.get(3);
                Elements mfTDrows = mfTD.select("td");
                float ratio = 0;//genderless pokemon can have ratio null (no 0, because there are pokemon that are excl. female
                if (mfTDrows.size() == 5){
                    String text = mfTDrows.get(2).text();
                    ratio = Float.parseFloat(text.substring(0, text.length() - 1)) / 100;
                }

                //type(s)
                Element typeTD = row4data.get(4);
                Elements typeA = typeTD.select("a");
                String type1text = typeA.get(0).attr("href");
                Type type1 = Type.valueOf(type1text.substring(12, type1text.length() - 6).toUpperCase());
                Type type2 = null;
                if(typeA.size() == 2){
                    String type2text = typeA.get(1).attr("href");
                    type2 = Type.valueOf(type2text.substring(12, type2text.length() - 6).toUpperCase());
                }

                /*
                    fifth and sixth rows store:
                        ability
                 */
                // TODO: 13/09/2020 ability

                /*
                    seventh and eighth rows store:
                        classification
                        height
                        weight
                        capture rate
                        base egg steps
                 */
                Element row8 = rows.get(7); //first three rows aren't relevant
                Elements row8data = row8.children();

                //classification
                String classification = row8data.get(0).text();

                //height
                String height = row8data.get(1).text();

                //weight in pounds
                String weightText = row8data.get(2).text();
                float weight = Float.parseFloat(weightText.substring(0, weightText.length() - 3));

                //capture rate
                float captureRate = Float.parseFloat(row8data.get(3).text());

                //base egg steps
                int baseEggSteps = Integer.parseInt(row8data.get(4).text().replace(",", ""));

                /*
                    ninth and tenth rows store:
                        Experience growth
                        base happiness
                        EV values earned
                        Colour
                        Safari zone flee rate
                 */
                Element row10 = rows.get(9); //first three rows aren't relevant
                Elements row10data = row10.children();

                //experience info
                String expInfo = row10data.get(0).text();
                String[] splits = expInfo.split("\\s+");
                int expPointsNeeded = Integer.parseInt(splits[0].replace(",", ""));
                ExpGrowth growth;
                if (splits.length == 3){ //speed is one word (erratic, fast, slow
                    growth = ExpGrowth.valueOf(splits[2].toUpperCase());
                }else{ //speed is to words
                    growth = ExpGrowth.valueOf(splits[2].toUpperCase() + "_" + splits[3].toUpperCase());
                }

                //Base happiness
                int baseHappiness = Integer.parseInt(row10data.get(1).text());

                //EV
                // TODO: 13/09/2020 parse ev values

                //color
                String color = row10data.get(3).text();

                //safari zone flee rate
                int safariZoneFleeRate = Integer.parseInt(row10data.get(4).text());

                /*
                    eleventh and twelfth rows store:
                        Damage taken (not necessary)
                 */

                /*
                    14th and 15th rows store:
                        Wild hold item
                        Egg groups
                 */
                Element row15 = rows.get(14); //first three rows aren't relevant
                Elements row15data = row15.children();
                //wild hold item
                // TODO: 13/09/2020 parse wild hold item
                //Egg groups
                Elements eggGroupAs = row15data.select("a");
                EggGroup eggGroup1 = EggGroup.NO_EGGS;
                EggGroup eggGroup2 = EggGroup.NO_EGGS;
                if (eggGroupAs.size() != 0){
                    String eggroup1Text = eggGroupAs.get(0).attr("href");
                    if (eggroup1Text.startsWith("/pokedex-dp/egg")){

                        eggGroup1 = EggGroup.valueOf(eggroup1Text.substring(16,eggroup1Text.length() - 6).toUpperCase());
                    }
                    if (eggGroupAs.size() == 2){
                        String eggroup2Text = eggGroupAs.get(1).attr("href");
                        if (eggroup2Text.startsWith("/pokedex-dp/egg")){
                            eggGroup2 = EggGroup.valueOf(eggroup2Text.substring(16,eggroup2Text.length() - 6).toUpperCase());
                        }
                    }else if (eggGroupAs.size() == 3){
                        String eggroup21Text = eggGroupAs.get(1).attr("href");
                        if (eggroup21Text.startsWith("/pokedex-dp/egg")){
                            eggGroup2 = EggGroup.valueOf(eggroup21Text.substring(16,eggroup21Text.length() - 6).toUpperCase());
                        }
                        String eggroup2Text = eggGroupAs.get(2).attr("href");
                        eggGroup2 = EggGroup.valueOf(eggroup2Text.substring(16,eggroup2Text.length() - 6).toUpperCase());
                    }
                }
                 /*
                    16th and 17th rows store:
                    evolution info
                 */

                /*
                    18th til 23th rows store:
                    flavour text
                */
                Element row22 = rows.get(21); //hg row
                String hgFlavourText = row22.select("td").get(1).text();
                Element row23 = rows.get(22); //ss row
                String ssFlavourText = row23.select("td").get(1).text();

                //basestats are at the bottom
                Collections.reverse(rows);
                Elements basestatsTDs = rows.get(6).select("td");
                int hp = Integer.parseInt(basestatsTDs.get(1).text());
                int attack = Integer.parseInt(basestatsTDs.get(2).text());
                int defense = Integer.parseInt(basestatsTDs.get(3).text());
                int spattack = Integer.parseInt(basestatsTDs.get(4).text());
                int spdefense = Integer.parseInt(basestatsTDs.get(5).text());
                int speed = Integer.parseInt(basestatsTDs.get(6).text());


                //name nation joth index gender ratio type12 class height wiehgt capturerate baseeggsteps exppointsneeded growth basehapines color safarizone egg groups flavourtext basestats

                if(type2 ==null){
                    System.out.println(name.toUpperCase() + "(\"" + name + "\", " + nationalIndex + ", " + johtoIndex + ", " + hp + "f, " + attack + "f, " + defense + "f, " + spattack + "f," + spdefense + "f, " + speed + "f, " + ratio + "f, Type." + type1 + " ,\"" +
                            classification + "\", \"" + height + ", " + weight + ", " + captureRate + ", " + baseEggSteps + ", " + expPointsNeeded + ", ExpGrowth." + growth +
                            ", " + baseHappiness + ", \"" + color + "\", " + safariZoneFleeRate + ", EggGroup." + eggGroup1 + ", EggGroup." + eggGroup2 + ", \"" + hgFlavourText + "\", \"" + ssFlavourText + "\"),");
                }else{
                    System.out.println(name.toUpperCase() + "(\"" + name + "\", " + nationalIndex + ", " + johtoIndex + ", " + hp + "f, " + attack + "f, " + defense + "f, " + spattack + "f," + spdefense + "f, " + speed + "f, " + ratio + "f, Type." +
                            type1 + ", Type." + type2 + " ,\"" + classification + "\", \"" + height + ", " + weight + ", " + captureRate + ", " + baseEggSteps + ", " + expPointsNeeded + ", ExpGrowth." + growth +
                            ", " + baseHappiness + ", \"" + color + "\", " + safariZoneFleeRate + ", EggGroup." + eggGroup1 + ", EggGroup." + eggGroup2 + ", \"" + hgFlavourText + "\", \"" + ssFlavourText + "\"),");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void old(){

        try {
            //here it is a local file, but it's basically just a html file of the https://pokemondb.net/pokedex/all page.
            Document parsed = Jsoup.parse(new File("C:\\Users\\Anton\\Desktop\\Pokemon Saturn\\core\\src\\blank.html"), "UTF-8");
            Element table = parsed.select("tbody").first();
            Elements rows  = table.select("tr");

            int lastPokemonNum = 0;
            for(Element row : rows){
                int pokedexNum = Integer.parseInt(row.select("td>span.infocard-cell-data").html());
                if (!(pokedexNum == lastPokemonNum) && (pokedexNum <= LAST_POKEDEX_NUM_TO_BE_ADDED)){//if there are multiple entries for one pokemon > megas for example

                    //name
                    String pokemonName = row.select("td>a.ent-name").html();


                    //stats
                    int hpBase = Integer.parseInt(row.select("td").get(4).html());
                    int attackBase = Integer.parseInt(rows.select("td").get(5).html());
                    int DefenseBase = Integer.parseInt(rows.select("td").get(6).html());
                    int specattackBase = Integer.parseInt(row.select("td").get(7).html());
                    int specdefenseBase = Integer.parseInt(row.select("td").get(8).html());
                    int speedBase = Integer.parseInt(row.select("td").get(9).html());

                    //type
                    Element typeElement = row.select("td").get(2);
                    if (typeElement.select("a").size() == 2){ //if the pokemon has two types
                        String type1 = "Type." + typeElement.select("a").get(0).html().toUpperCase();
                        String type2 = "Type." + typeElement.select("a").get(1).html().toUpperCase();
                        System.out.println(pokemonName.toUpperCase() + "("+ type1 + ", "+ type2 + ", " + hpBase + "f, " + attackBase+ "f, " + DefenseBase + "f, " + specattackBase + "f, " + specdefenseBase+ "f, " + speedBase+ "), ");

                    }else{ //the pokemon has one type
                        String type = "Type." + typeElement.select("a").get(0).html().toUpperCase();
                        System.out.println(pokemonName.toUpperCase() + "(" + type + ", " + hpBase + "f, " + attackBase+ "f, " + DefenseBase + "f, " + specattackBase + "f, " + specdefenseBase+ "f, " + speedBase+ "), ");

                    }

                    lastPokemonNum = pokedexNum;
                }



                /*
                if (i !=)
                System.out.println(row.select("td>a").first().html());
                i++;
                 */

            }

            /*
             for (int i = 0; i < rows.size(); i++) {
                String pokemonName = rows.get(i + 1).select("td").get(2).select("a").html();



                //PIKACHU(Type.ELECTRIC, 35f, 55f, 40f , 50f, 50f, 90f),



            }
             */


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
