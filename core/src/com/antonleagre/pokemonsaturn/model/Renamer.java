package com.antonleagre.pokemonsaturn.model;

import java.io.File;

public class Renamer {
    public static void main(String[] args) {
        final File inputDir = new File("C:\\Users\\Anton\\Desktop\\Pokemon Saturn\\art\\Trainer Sprites\\trainersfull32");
        Image[][] images = new Image[32][30];
        for (File file : inputDir.listFiles()){
            Image img = new Image(file);
            images[img.row][img.collum] = img;
        }

        String[][] names = {
                {"tProfElm", "tRival", "tSteven", "tMediumCandle", "tMediumNoCandle", "tTwinMale", "tTwinFemale", "tYoungster", "tBugCatcher", "tLass"},
                //todo finish this app for the trainernames
        };


        for (int i = 0; i < images.length; i += 4){
                for (int j = 0; j < images[i].length; j += 3) {
                    //(i,j) is the first image of the character sprites

                    String baseName;
                    try{
                         baseName = names[i/4][j/3];
                    }catch (ArrayIndexOutOfBoundsException e){ //no name specified
                        baseName = "nonameyet" + i + j;
                    }

                    images[i][j].rename(baseName + 1);
                    images[i][j+1].rename(baseName + 2);
                    images[i][j+2].rename(baseName + 3);
                    images[i + 1][j].rename(baseName + 4);
                    images[i + 1][j+1].rename(baseName + 5);
                    images[i + 1][j+2].rename(baseName + 6);
                    images[i + 2][j].rename(baseName + 7);
                    images[i + 2][j+1].rename(baseName + 8);
                    images[i + 2][j+2].rename(baseName + 9);
                    images[i + 3][j].rename(baseName + 10);
                    images[i + 3][j+1].rename(baseName + 11);
                    images[i + 3][j+2].rename(baseName + 12);
                }

            }
    }

    private static class Image{

        File original;
        int index;

        File newfile;

        int collum;
        int row;

        public Image(File file){
            this.original = file;
            this.index = Integer.parseInt(this.original.getName().substring(5).replace(".png", ""));
            this.row = (index - 1) / 30;
            this.collum = (index - 30*row) - 1;

        }

        public void rename(String newName){
            newfile = new File(original.getPath().substring(0, 73) + newName + ".png");
            original.renameTo(newfile);
        }
    }
}
