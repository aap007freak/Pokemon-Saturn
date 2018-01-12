package com.antonleagre.pokemonsaturn.controllers;

import com.antonleagre.pokemonsaturn.maps.MapSegment;
import com.antonleagre.pokemonsaturn.models.Player;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MapSegmentController {


    private static final String MAP_DIR = "map/";

    //the hashmap is specified as this: "string: the name of the map, without tmx and map/ ; the mapsegment
    private HashMap<String, MapSegment> allMaps;

    private MapSegment currentMap;
    private MapSegment oldMap;
    private OrthographicCamera mapCam;
    private Player player;

    public MapSegmentController(Player player, OrthographicCamera cam){
        this.mapCam = cam;
        this.player = player;
        allMaps = scanMaps();
    }

    /**
     * change the map that currently is updated and drawn
     * @param tmx the file name (without location or .tmx extension.
     */
    public void changeMap(String tmx){
        currentMap = oldMap;
        //load new map
        currentMap = allMaps.get(tmx);
        currentMap.load();

        //dispose old map
        if(oldMap != null){
            System.out.println(oldMap.getLocation());
            oldMap.dispose(); //when the first map there isnt an old map to dispose yet
        }
    }

    public void changeMap(String tmx, Vector2 newPosition){
        currentMap = oldMap;
        //load new map
        currentMap = allMaps.get(tmx);
        currentMap.load();
        player.set(newPosition);

        //dispose old map
        if(oldMap != null){
            System.out.println(oldMap.getLocation());
            oldMap.dispose(); //when the first map there isnt an old map to dispose yet
        }
    }


    public void update(float dt){
        currentMap.update();
    }

    public void render(ShapeRenderer srr, SpriteBatch sb){
        currentMap.render(srr, sb);
    }

    public void dispose(){
        currentMap.dispose();
        //dispose all maps;
    }

    /**
     * util function to scan the specified map directory for all the files, and return them in one big hashmap
     * @return
     */
    private HashMap<String, MapSegment> scanMaps(){
        HashMap<String, MapSegment> maps = new HashMap<String, MapSegment>();
        File[] mapFiles = new File(MAP_DIR).listFiles();

        //iterate through the files in the folder and add them all to the hashmap
        for (int i = 0; i < mapFiles.length; i++) {
            if (mapFiles[i].isFile()) {
                maps.put(mapFiles[i].getName().substring(0, mapFiles[i].getName().length() - 4),
                        new MapSegment(this, MAP_DIR + mapFiles[i].getName(), mapCam, player));  //creating the objects here isnt a problem because we dont actually load the map until mapsegment.load() is called
            }
        }
        System.out.println("CHECKED THE MAPS IN THE MAP FOLDER AND FOUND THESE FILES:");
        for(Map.Entry<String, MapSegment> entry : maps.entrySet()){
            System.out.println(entry.getValue().getLocation());
        }
        return maps;
    }
}
