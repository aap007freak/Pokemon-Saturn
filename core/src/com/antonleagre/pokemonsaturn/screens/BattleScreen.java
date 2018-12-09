package com.antonleagre.pokemonsaturn.screens;

import com.antonleagre.pokemonsaturn.Main;
import com.antonleagre.pokemonsaturn.battle.Battle;
import com.antonleagre.pokemonsaturn.battle.moves.Moves;
import com.antonleagre.pokemonsaturn.battle.Pokemon;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BattleScreen implements Screen {

    private Main main;
    private Battle battle;

    private Stage stage;

    public BattleScreen(Main main){
        this.main = main;
        stage = new Stage(new ScreenViewport());
        battle = new Battle();

    }

    @Override
    public void show() {
        System.out.println("NOW IN BATTLESCREEN");
        Gdx.input.setInputProcessor(stage);
        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("someone has clicked");

            }
        });
        battle.initBattle(new Pokemon("Bulbasaur", Pokemon.Type.GRASS, 45, 49, 49, 65, 65, 40),
                          new Pokemon("Charmander", Pokemon.Type.FIRE, 1, 1, 1, 1,1, 1));
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                battle.move(Moves.POUND);
            }
        }, 1);
    }

    private void update(float dt){
        stage.act(dt);
    }
    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
        stage.dispose();
    }
}
