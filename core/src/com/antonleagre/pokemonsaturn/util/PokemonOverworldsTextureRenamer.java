package com.antonleagre.pokemonsaturn.util;

import java.io.File;

public class PokemonOverworldsTextureRenamer {

    public static void main(String[] args) {
        final File inputDir = new File("C:\\Users\\Anton\\Desktop\\Pokemon Saturn\\art\\Pokemon Overworlds Sprites\\kantohalfsplit");

        int numRows = 28;
        int numCollumns = 30;
        if (numRows * numCollumns != inputDir.listFiles().length){
            throw new IllegalArgumentException("The amount of files are not the same as the dimensions specified");
        }

        Image[][] images = new Image[numRows][numCollumns];
        for (File file : inputDir.listFiles()){
            Image img = new Image(file, numRows, numCollumns);
            images[img.row][img.collum] = img;
        }

        String[][] newNames = {
                {"poBulbasaur", "poIvysaur", "poVenosaurMale", "poVenosaurfemale", "poCharmander", "poCharmeleon", "poCharizard", "poSquirtle", "poWartortle", "poBlastoise", "poCaterpie", "poMetapod", "poButterfree", "poWeedle", "poKakuna"},
                {"poBeedrill", "poPidgey", "poPidgeotto", "poPidgeot", "poRattata", "poRaticate", "poSpearow", "pofearow", "poEkans", "poArbok", "poPikachuMale", "poPikachufemale", "poRaichu", "poSandslash", "poSandshrew"}

        };

        //todo finish this app for the pokemon overworlds, can also be used for johto

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
            this.row = (index - 1) / numCollumns;
            this.collum = (index - 30*row) - 1;

        }

        public void rename(String newName){
            newfile = new File(original.getPath().substring(0, 84) + newName + ".png");
            original.renameTo(newfile);
        }
    }

}
