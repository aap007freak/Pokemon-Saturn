package com.antonleagre.pokemonsaturn.engine.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.Util;
import com.antonleagre.pokemonsaturn.engine.entities.Player;
import com.antonleagre.pokemonsaturn.engine.controllers.MapSegmentController;
import com.antonleagre.pokemonsaturn.engine.ui.UIController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen  implements Screen{

    public static boolean debug = false;

    private Main main;

    private Viewport viewPort;
    private OrthographicCamera camera;

    private TextureRegion pokemonTexture;
    private Player player;

    private MapSegmentController mapSegmentController;
    private UIController uiController;

    private ShapeRenderer debugRenderer;

//    private Battle testBattle;

    public PlayScreen(Main main){
        this.main = main;

        camera = new OrthographicCamera();
        viewPort = new FitViewport(Main.V_WIDTH, Main.V_HEIGHT, camera);

        player = new Player(new Vector2(1,1), "tMom", main.assetManager.get("trainers.atlas", TextureAtlas.class));

        mapSegmentController = new MapSegmentController(player, main);

        debugRenderer = new ShapeRenderer();

        pokemonTexture = main.assetManager.get("pokemonOverworlds.atlas", TextureAtlas.class).findRegion("poPidgeot1");

        uiController = new UIController(Gdx.files.internal("skin/uiskin.json"));

    }

    @Override
    public void show() {
        mapSegmentController.changeMap("newbarktown");
    }

    private void update(float delta) {

        player.update(delta);
        mapSegmentController.update(delta);
        uiController.update(delta);
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
        mapSegmentController.renderBackground();

        main.batch.begin();
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);

        main.batch.draw(pokemonTexture, 0, 0);
        player.render(debugRenderer, main.batch);


        main.batch.end();
        mapSegmentController.renderForeground();
        mapSegmentController.renderDebugLines(debugRenderer, main.batch);
        debugRenderer.end();

        uiController.renderUI();


       // mapSegmentController.renderDebugLines(debugRenderer, main.batch);
        //player.renderDebugLines(debugRenderer, main.batch);

    }

    @Override
    public void resize(int width, int height) {
        viewPort.update(width, height);
        uiController.resize(width, height);
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
        debugRenderer.dispose();
        uiController.dispose();
    }
}
