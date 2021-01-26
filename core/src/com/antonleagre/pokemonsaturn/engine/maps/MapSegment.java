package com.antonleagre.pokemonsaturn.engine.maps;

import com.antonleagre.pokemonsaturn.Util;
import com.antonleagre.pokemonsaturn.engine.entities.NPC;
import com.antonleagre.pokemonsaturn.engine.entities.Player;
import com.antonleagre.pokemonsaturn.engine.collision.Collidable;
import com.antonleagre.pokemonsaturn.engine.controllers.MapSegmentController;
import com.antonleagre.pokemonsaturn.engine.maps.tiles.SpecialTile;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;

public class MapSegment {

    private final MapSegmentController controller;

    private final String location;
    private final Player player;

    private TiledMap map;
    
    private ArrayList<Collidable> collidables;
    private ArrayList<SpecialTile> specialTiles;
    private final ArrayList<NPC> npcs;


    public MapSegment(MapSegmentController controller, String tmxLcation, Player player){
        this.controller = controller;
        this.location = tmxLcation;
        this.player = player;
        collidables = new ArrayList<>();
        specialTiles = new ArrayList<>();
        npcs = new ArrayList<>();
    }


    public void load(){
        //load the map
        map = new TmxMapLoader().load(location);
        //parse the collision obs
        if(map.getLayers().get("colObs") != null){
            collidables = Util.parseCollisionLayer(map.getLayers().get("colObs"));
        }

        //parse the special tiles
        if(map.getLayers().get("specTiles") != null){

            specialTiles = Util.parseSpecialTilesLayer(map.getLayers().get("specTiles"), controller);
        }


        //add the collision obs and the special tiles to the collision checker (we want to check special tiles for collision as well so that we can detect when a player hits a special tile)
        ArrayList<Collidable> allCollidableObjects = new ArrayList<>();
        allCollidableObjects.addAll(collidables);
        allCollidableObjects.addAll(specialTiles);

        player.getMovementController().setObstacles(allCollidableObjects);

    }

    public void dispose(){
        map.dispose();
    }
    
    public ArrayList<Collidable> getCollidables() {
        return collidables;
    }

    public ArrayList<SpecialTile> getSpecialTiles() {
        return specialTiles;
    }

    public TiledMap getMap() {
        return map;
    }

    public String getLocation() {
        return location;
    }
}
