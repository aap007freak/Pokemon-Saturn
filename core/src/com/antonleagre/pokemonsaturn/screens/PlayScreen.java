package com.antonleagre.pokemonsaturn.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.Util;
import com.antonleagre.pokemonsaturn.controllers.MapSegmentController;
import com.antonleagre.pokemonsaturn.models.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class PlayScreen  implements Screen{

    public static boolean debug = false;

    private Texture playerTexture;
    private Main main;
    private StretchViewport viewPort;
    private OrthographicCamera camera;

    private Player player;

    private MapSegmentController mapSegmentController;

    private ShapeRenderer debugRenderer;

    public PlayScreen(Main main){
        this.main = main;

        camera = new OrthographicCamera();
        viewPort = new StretchViewport(Main.V_WIDTH / 2, Main.V_HEIGHT / 2, camera);
        camera.setToOrtho(false, viewPort.getWorldWidth(), viewPort.getWorldHeight());

        playerTexture = new Texture("prof.png");
        player = new Player(new Vector2(1,1), playerTexture);

        mapSegmentController = new MapSegmentController(player, camera);

        debugRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        System.out.println("NOW IN PLAYSCREEN");
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

        debugRenderer.begin(ShapeRenderer.ShapeType.Line);


        main.batch.begin();
        mapSegmentController.render(debugRenderer, main.batch);
        player.render(debugRenderer, main.batch);

        debugRenderer.end();
        main.batch.end();
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
