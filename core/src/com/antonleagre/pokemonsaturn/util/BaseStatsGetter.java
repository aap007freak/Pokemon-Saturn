package com.antonleagre.pokemonsaturn.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class BaseStatsGetter {

    public static final int LAST_POKEDEX_NUM_TO_BE_ADDED = 250;

    public static void main(String[] args) {

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
