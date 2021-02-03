package com.antonleagre.pokemonsaturn.util;

import com.antonleagre.pokemonsaturn.model.pokemon.BasePokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;


/**
 * This class is only used to split the pokemon images on https://www.spriters-resource.com/ds_dsi/pokemonheartgoldsoulsilver/ the Battle section
 * (I called it fronts but should have called it battle sprites or something mb)
 *
 */
public class PokemonFrontsFileSplitter {

    /**
     *
     * FOR FURTHER USE:
     * Change the folders and file paths if necessary
     * width and height and position is a bit more difficult to change,
     *  by default: width and height 324 - 195
     *
     */
    private static void splitFile(){
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(500,500);
        try{
            final File source = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\art\\132566.png"); // gdx files internal did weird stuff cause it's not the standard gradle config; has to do with gradle not setting the input correctly
            final BufferedImage img = ImageIO.read(source);
            final JLabel imgLabel = new JLabel();
            final JTextField nameField = new JTextField();
            final JButton button = new JButton("OK");
            frame.add(imgLabel);
            frame.add(nameField);
            frame.add(button);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.show();
            //ten collumns eightteen rows

            final int[] pokemonIndex = {199};
            final int[] regionNum = {59};

            nameField.setText("pof" + BasePokemon.values()[pokemonIndex[0]].toString().toLowerCase());
            final BufferedImage[] subImage = {img.getSubimage(0, 0, 324, 195)};
            imgLabel.setIcon(new ImageIcon(subImage[0]));

            final String[] pokemonNames = Arrays.stream(BasePokemon.values()).map(o -> o.toString().toLowerCase()).toArray(String[]::new);

            button.addActionListener(e -> {
                //write images
                String name = nameField.getText();
                try {
                    File out = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "1.png");
                    out.createNewFile();
                    File out2 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "2.png");
                    out.createNewFile();
                    File out3 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "3.png");
                    out.createNewFile();
                    File out4 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "4.png");
                    out.createNewFile();
                    File out5 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "5.png");
                    out.createNewFile();
                    File out6 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "6.png");
                    out.createNewFile();
                    File out7 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "7.png");
                    out.createNewFile();
                    File out8 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "8.png");
                    out.createNewFile();
                    File out9 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name +  "9.png");
                    out.createNewFile();
                    File out10 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name + "10.png");
                    out.createNewFile();
                    File out11 = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + name + "11.png");
                    out.createNewFile();

                    ImageIO.write(subImage[0].getSubimage(1, 34, 80, 80), "png", out); //front 1
                    ImageIO.write(subImage[0].getSubimage(82, 34, 80, 80), "png", out2); //front 2
                    ImageIO.write(subImage[0].getSubimage(163, 34, 80, 80), "png", out3); // back 1
                    ImageIO.write(subImage[0].getSubimage(244, 34, 80, 80), "png", out4); // back 2
                    //simile for shiny forms
                    ImageIO.write(subImage[0].getSubimage(1, 115, 80, 80), "png", out5); //front 1
                    ImageIO.write(subImage[0].getSubimage(82, 115, 80, 80), "png", out6); //front 2
                    ImageIO.write(subImage[0].getSubimage(163, 115, 80, 80), "png", out7); // back 1
                    ImageIO.write(subImage[0].getSubimage(244, 115, 80, 80), "png", out8); // back 2
                    //tiny images, idk for what theyre useful
                    ImageIO.write(subImage[0].getSubimage(242, 17, 16, 16), "png", out9); //front 2
                    ImageIO.write(subImage[0].getSubimage(259, 1, 32, 32), "png", out10); // back 1
                    ImageIO.write(subImage[0].getSubimage(292, 1, 32, 32), "png", out11); // back 2
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                for (int q = 0; q < pokemonNames.length; q++) {

                    if(pokemonNames[q].equals(name.substring(3))){
                        System.out.println("TRUE");
                        pokemonIndex[0] = q+1;
                    }
                }

                //show next pokemon
                regionNum[0]++;
                //update indices
                int i = regionNum[0] / 10;
                int j = regionNum[0] % 10;

                nameField.setText("pof" + BasePokemon.values()[pokemonIndex[0]].toString().toLowerCase());
                subImage[0] = img.getSubimage(j * 324, i * 195, 324, 195);
                imgLabel.setIcon(new ImageIcon(subImage[0]));

            });


        }catch (IOException e){
            e.printStackTrace();
        }

        //renameWrongFemalesETC();
    }

    private static void renameWrongFemalesETC(){
        File outDir = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out");
        File[] to_replace = outDir.listFiles((dir, name) -> {
            String substring = name.substring(0, name.length() - 4);
            return substring.endsWith("_m9") || substring.endsWith("_m10") || substring.endsWith("_m11") ;
        });
        for(File f: to_replace){
            if(f.getName().endsWith("_m9.png")){
                String female_name = f.getName().split("_")[0] + "_f9.png";
                Path originalPath = Paths.get("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + female_name);
                Path copied = f.toPath();
                try {
                    Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(f.getName().endsWith("_m10.png")){
                String female_name = f.getName().split("_")[0] + "_f10.png";
                Path originalPath = Paths.get("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + female_name);
                Path copied = f.toPath();
                try {
                    Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(f.getName().endsWith("_m11.png")) {
                    String female_name = f.getName().split("_")[0] + "_f11.png";
                    Path originalPath = Paths.get("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\out\\" + female_name);
                    Path copied = f.toPath();
                    try {
                        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

    }

    private static void renameUnowns() throws Exception{
        File gen2dir = new File("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\art\\battle\\gen2");
        for(File file: gen2dir.listFiles()){
            if (file.getName().startsWith("pofunown")){
                if (file.getName().contains("9")){
                    Files.copy(Paths.get("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\art\\battle\\gen2\\pofunown_n9.png"),
                            file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                if (file.getName().contains("10")){
                    Files.copy(Paths.get("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\art\\battle\\gen2\\pofunown_n10.png"),
                            file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                if (file.getName().contains("11")){
                    Files.copy(Paths.get("C:\\Users\\Anton\\Desktop\\Pokemon-Saturn\\art\\battle\\gen2\\pofunown_n11.png"),
                            file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }

    }

    public static void main(String[] args) {
        splitFile();
        //renameWrongFemalesETC();

    }

}
