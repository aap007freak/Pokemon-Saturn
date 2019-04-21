package com.antonleagre.pokemonsaturn;

import com.antonleagre.pokemonsaturn.engine.AITrainer;
import com.antonleagre.pokemonsaturn.engine.Person;
import com.antonleagre.pokemonsaturn.engine.collision.Collidable;
import com.antonleagre.pokemonsaturn.engine.collision.CollisionLine;
import com.antonleagre.pokemonsaturn.engine.collision.CollisionRectangle;
import com.antonleagre.pokemonsaturn.engine.controllers.MapSegmentController;
import com.antonleagre.pokemonsaturn.engine.maps.tiles.SpecialTile;
import com.antonleagre.pokemonsaturn.engine.maps.tiles.TriggerTile;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.HashMap;

public class Util {
     /*

            CAMERA UTILS
     */
    public static void lockToTarget(Camera camera, Person person) {
        Vector3 newCamPosition = new Vector3();
        if(person.getState() == Person.states.WALKING){
            newCamPosition.set(person.getWalkingDrawPosition().cpy().scl(com.antonleagre.pokemonsaturn.Main.TILE_SIZE), 0);
        }
        else{
            newCamPosition.set(person.getPosition().cpy().scl(com.antonleagre.pokemonsaturn.Main.TILE_SIZE), 0);
        }
        camera.position.set(newCamPosition);
        camera.update();
    }

    /*
            MAP UTILS
     */


    // TODO: 1/10/2018 change all these arraylist to faster badlogic Array<>'s.
    // TODO: 1/10/2018 check for nullpointers when a certain type of tile just doesnt exist in that map

    public static ArrayList<Collidable> parseCollisionLayer(MapLayer collisionObjectLayer) {
        ArrayList<Collidable> collidables = new ArrayList<>();

        for(MapObject collisionObject : collisionObjectLayer.getObjects()){

            if(collisionObject instanceof RectangleMapObject){
                CollisionRectangle rect = new CollisionRectangle(((RectangleMapObject) collisionObject).getRectangle());
                collidables.add(rect);
            }

            if(collisionObject instanceof PolylineMapObject){
                float[] vertices = ((PolylineMapObject) collisionObject).getPolyline().getTransformedVertices();
                for(int i = 0; i < vertices.length / 2 - 1; i++){ //
                    if(i == 0){
                        CollisionLine line = new CollisionLine(vertices[0],vertices[1],vertices[2],vertices[3]);
                        collidables.add(line);
                    }else{
                        CollisionLine line = new CollisionLine(vertices[i + 1],vertices[i + 2],vertices[i + 3],vertices[i + 4]);
                        collidables.add(line);
                    }

                }
            }
        }
        System.out.println("PARSED A COLLISION LAYER WITH: " + collidables.size() + " COLLIDABLE OBJECTS");
        return collidables;
    }

    public static ArrayList<SpecialTile> parseSpecialTilesLayer(MapLayer specialTileObectLayer, MapSegmentController controller) {
        ArrayList<SpecialTile> tiles = new ArrayList<>();

        for(MapObject object  : specialTileObectLayer.getObjects()){
            if(object instanceof RectangleMapObject){

                com.badlogic.gdx.math.Rectangle pos = ((RectangleMapObject) object).getRectangle();
                String action = object.getProperties().get("action", String.class);
                SpecialTile tile;

                switch (action){
                    case "door" :
                        //get the map to change to
                        /**
                         *  String mapToChangeTo = object.getProperties().get("changemap", String.class);
                        int xToChangeTo = Integer.parseInt(object.getProperties().get("changetile", String.class).split(",")[0]);
                        int yToChangeTo = Integer.parseInt(object.getProperties().get("changetile", String.class).split(",")[1]);
                        tile = new DoorTile(pos, controller, mapToChangeTo, new Vector2(xToChangeTo, yToChangeTo));
                        tiles.add(tile);
                         */

                        break;
                    case "trigger" :
                        tile = new TriggerTile(pos);
                        tiles.add(tile);
                        break;

                    default:
                        System.out.println("COULDNT PARSE AN SPECIAL OBJECT TILE AT COORDINATES:" + pos.getX() + ", " + pos.getY() + ", IT MAY HAVE BEEN WRONGLY DEFINED IN TILED");

                }


            }
        }
        System.out.println("PARSED A SPECIAL TILE LAYER WITH: " + tiles.size() + " SPECIAL TILES");
        return tiles;
    }

    public static ArrayList<AITrainer> parseTrainerLayer(MapLayer layer){
        ArrayList<AITrainer> trainers = new ArrayList<>();
        for(MapObject object : layer.getObjects()){
            Rectangle pos = ((RectangleMapObject) object).getRectangle();
            AITrainer trainer = new AITrainer(new Vector2(pos.x, pos.y).cpy().scl(1/Main.TILE_SIZE), object.getProperties().get("texture", String.class));
            trainers.add(trainer);
        }

        return trainers;
    }


    /*
               TEXTURE UTILS

     */

    public static HashMap<String, Array<TextureRegion>> parseCharacterTextureRegions(Texture texture){
        HashMap<String, Array<TextureRegion>> fullHashmap = new HashMap<>();

        TextureRegion[][] regions = TextureRegion.split(texture, 32, 32);

        Array<TextureRegion> standing = new Array<>();
        standing.addAll(regions[0][0], regions[1][2], regions[2][0], regions[0][1]); //up down left and right
        fullHashmap.put("standing", standing);


        Array<TextureRegion> walkingLeft = new Array<>();
        walkingLeft.addAll(regions[1][0], regions[2][0], regions[3][0]); //first row and then column
        fullHashmap.put("left", walkingLeft);

        Array<TextureRegion> walkingRight = new Array<>();
        walkingRight.addAll(regions[0][1], regions[1][1], regions[2][1]);  //...
        fullHashmap.put("right", walkingRight);

        Array<TextureRegion> walkingUp= new Array<>();
        walkingUp.addAll(regions[0][0], regions[3][1], regions[0][2]);
        fullHashmap.put("up", walkingUp);

        Array<TextureRegion> walkingDown = new Array<>();
        walkingDown.addAll(regions[1][2], regions[2][2], regions[3][2]);
        fullHashmap.put("down", walkingDown);

        return fullHashmap;
    }
}
