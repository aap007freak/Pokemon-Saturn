package com.antonleagre.pokemonsaturn.util;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;

import java.io.File;


public class PokemonOverworldsTextureRenamer {

    private static final File inputDir = new File("C:\\Users\\Anton\\Pokemon-Saturn\\art\\gen3owswithoutlastrow");
    private static final File outputDir = new File("C:\\Users\\Anton\\Pokemon-Saturn\\art\\gen3output");
    private static final int numRows = 40;
    private static final int numCollumns = 26;

    public static void main(String[] args) {

        if (numRows * numCollumns != inputDir.listFiles().length){
            throw new IllegalArgumentException("The amount of files are not the same as the dimensions specified");
        }

        Image[][] images = new Image[numRows][numCollumns];
        for (File file : inputDir.listFiles()){
            Image img = new Image(file, numRows, numCollumns);
            images[img.row][img.collum] = img;
        }

        String[][] newNames = {
            {"Treecko", "Grovyle", "Sceptile", "Torchic", "Combusken", "Blaziken", "Mudkip", "Marshtomp", "Swampert", "Poochyena", "Mightyena", "Zigzagoon", "Linoone"},
            {"Wurmple", "Silcoon", "Beautifly", "Cascoon", "Dustox", "Lotad", "Lombre", "Ludicolo", "Seedot", "Nuzleaf", "Shiftry", "Taillow", "Swellow"},
            {"Wingull", "Pelipper", "Ralts", "Kirlia", "Gardevoir", "Surskit", "Masquerain", "Shroomish", "Breloom", "Slakoth", "Vigoroth", "Slaking", "Nincada"},
            {"Ninjask", "Shedinja", "Whismur", "Loudred", "Exploud", "Makuhita", "Hariyama", "Azurill", "Nosepass", "Skitty", "Delcatty", "Sableye", "Mawile"},
            {"Aron", "Lairon", "Aggron", "Meditite", "Medicham", "Electrike", "Manectric", "Plusle", "Minun", "Volbeat", "Illumise", "Roselia", "Gulpin"},
            {"Swalot", "Carvanha", "Sharpedo", "Wailmer", "Wailord", "Wailord2", "Numel", "Camerupt", "Torkoal", "Spoink", "Grumpig", "Spinda", "Trapinch"},
                    {"Vibrava", "Flygon", "Cacnea", "Cacturne", "Swablu", "Altaria", "Zangoose", "Seviper", "Lunatone", "Solrock", "Barboach", "Whiscash", "Corphish"},
            { "Crawdaunt", "Baltoy", "Claydol", "Lileep", "Cradily", "Anorith", "Armaldo", "Feebas", "Milotic", "Castform", "Kecleon", "Shuppet", "Banette"},
            {"Duskull", "Dusclops", "Tropius", "Chimecho", "Absol", "Wynaut", "Snorunt", "Glalie", "Spheal", "Sealeo", "Walrein", "Clamperl", "Huntail"},
            { "Gorebyss", "Relicanth", "Luvdisc", "Bagon", "Shelgon", "Salamence", "Beldum", "Metang", "Metagross", "Regirock", "Regice", "Registeel", "Latias"}

        };



        if (newNames.length != numRows / 4 || newNames[0].length != numCollumns / 2){
            throw new IllegalArgumentException("The dimensions of the names don't match the dimensions of the image array");
        }

         for (int i = 0; i < images.length; i += 4){
            for (int j = 0; j < images[i].length; j += 2) {
                //(i,j) is the first image of the character sprites

                String baseName;
                try{
                    String arrayName =  newNames[i/4][j/2];
                    if (arrayName.equals("")){
                        baseName = "nonameyet" + i + j;
                    }else{
                        baseName =  newNames[i/4][j/2];
                    }

                }catch (ArrayIndexOutOfBoundsException e){ //no name specified
                    baseName = "nonameyet" + i + j;
                }

                images[i][j].rename(baseName + 1);
                images[i][j+1].rename(baseName + 2);

                images[i + 1][j].rename(baseName + 3);
                images[i + 1][j+1].rename(baseName + 4);

                images[i + 2][j].rename(baseName + 5);
                images[i + 2][j+1].rename(baseName + 6);

                images[i + 3][j].rename(baseName + 7);
                images[i + 3][j+1].rename(baseName + 8);

            }

        }
    }


    private static class Image{

        File original;
        int index;

        File newfile;

        int collum;
        int row;

        public Image(File file, int numRows, int numCollumns){
            this.original = file;
            this.index = Integer.parseInt(this.original.getName().substring(5).replace(".png", ""));
            this.row = (index - 2) / numCollumns;
            this.collum = (index) % numCollumns;
        }

        public void rename(String newName){
            newfile = new File(original.getParentFile() + "\\" + newName + ".png");
            original.renameTo(newfile);
        }
    }

    /**
     *
     * @param startingNationalDexNumber
     * @param numPokemonsperRow
     * @param numPokemons
     * @return
     */
    private static String generateNameString(int startingNationalDexNumber, int numPokemonsperRow, int numPokemons){
        StringBuilder s = new StringBuilder();
        BasePokemon[] basePokemons = BasePokemon.values();
        for (int i = startingNationalDexNumber; i <= (startingNationalDexNumber + numPokemons - 1); i++){
            if(i % numPokemonsperRow == 0){ //last pokemon of a row
                s.append("\"").append(basePokemons[i-1].getName()).append("\", ");
            }else if(i % numPokemonsperRow == 1){ //first pokemon of a row
                s.append("\"").append(basePokemons[i-1].getName()).append("\", ");
            }else{
                s.append("\"").append(basePokemons[i-1].getName()).append("\", ");
            }
        }
        return s.toString();
    }

}
