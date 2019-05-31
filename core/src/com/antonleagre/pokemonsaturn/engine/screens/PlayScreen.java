package com.antonleagre.pokemonsaturn.engine.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.Util;
import com.antonleagre.pokemonsaturn.engine.Player;
import com.antonleagre.pokemonsaturn.engine.controllers.MapSegmentController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen  implements Screen{

    public static boolean debug = false;

    private Main main;

    private Viewport viewPort;
    private OrthographicCamera camera;

    private Texture playerTexture;
    private Player player;

    private MapSegmentController mapSegmentController;

    private ShapeRenderer debugRenderer;

//    private Battle testBattle;

    public PlayScreen(Main main){
        this.main = main;

        camera = new OrthographicCamera();
        viewPort = new FitViewport(Main.V_WIDTH, Main.V_HEIGHT, camera);

        player = new Player(new Vector2(1,1), "tRival", main.assetManager.get("trainersyes.atlas", TextureAtlas.class));

        mapSegmentController = new MapSegmentController(player, main);

        debugRenderer = new ShapeRenderer();

//        testBattle = new Battle();
    }

    @Override
    public void show() {
        mapSegmentController.changeMap("newbarktown");
    }

    private void update(float delta) {

        player.update(delta);
        mapSegmentController.update(delta);
        Util.lockToTarget(camera, player);
    }
    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        main.batch.setProjectionMatrix(camera.combined);
        debugRenderer.setProjectionMatrix(camera.combined);

        //batch doesnt have to open for a map render call
        mapSegmentController.render();

        main.batch.begin();
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);

        player.render(debugRenderer, main.batch);
        mapSegmentController.renderDebugLines(debugRenderer, main.batch);

        main.batch.end();
        debugRenderer.end();


       // mapSegmentController.renderDebugLines(debugRenderer, main.batch);
        //player.renderDebugLines(debugRenderer, main.batch);

    }

    @Override
    public void resize(int width, int height) {
        viewPort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        mapSegmentController.dispose();
        player.dispose();
        playerTexture.dispose();
        debugRenderer.dispose();
    }
}
