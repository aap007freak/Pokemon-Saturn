package com.antonleagre.pokemonsaturn.util;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MoveGrabber {

    private static void grabMoves(String url){
        try {
            Document parsed = Jsoup.connect(url).get();
            Element table = parsed.selectFirst("tbody");
            Elements moves = table.select("tr"); //rows
            for (int i = 2; i <= 469; i++) { //first two rows in moves is a header
                StringBuilder builder = new StringBuilder();
                Elements tds = moves.get(i).select("td");// regex removes all characters that are not alpha or spaces
                String enumName = tds.get(1).text().toUpperCase().replace(" ", "_").replaceAll("[^a-zA-Z_]", "");;
                builder.append(enumName);
                builder.append("(");
                String name = tds.get(1).text().replaceAll("[^a-zA-Z\\s]", "");;
                builder.append("\"").append(name).append("\", ");
                Element type = tds.get(2).selectFirst(" a > span");
                builder.append("Type.").append(type.text().toUpperCase()).append(", ");
                Element category = tds.get(3).selectFirst(" a > span");
                builder.append("Category.").append(category.text().toUpperCase()).append(", ");
                //this commented code can be used to import contest info
                /*
                Element contest = tds.get(4).selectFirst(" a > span");
                builder.append("Contest.").append(contest.text().toUpperCase()).append(", ");
                 */
                String maxPP = tds.get(5).text().replaceAll("[\\D]", ""); //removes all non numbers
                builder.append(maxPP).append(", ");
                String basePower = tds.get(6).text().replaceAll("[\\D]", ""); //removes all non numbers
                if (basePower.equals("")) basePower = "null";
                builder.append(basePower).append(", ");
                String accuracy = tds.get(7).text().replaceAll("[\\D]", ""); //removes all non numbers
                if (accuracy.equals("")) accuracy = "null";
                builder.append(accuracy).append(", ");
                builder.append("null").append("),");

                System.out.println(builder.toString());


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        grabMoves("https://bulbapedia.bulbagarden.net/wiki/List_of_moves");
    }


}
