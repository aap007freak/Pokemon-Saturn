package com.antonleagre.pokemonsaturn;

import com.antonleagre.pokemonsaturn.engine.screens.BattleScreen;
import com.antonleagre.pokemonsaturn.engine.screens.MenuScreen;
import com.antonleagre.pokemonsaturn.engine.screens.PlayScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Main extends Game{

	//World Coordinates, these are the coordinates of the DSi top screen
	public static final int V_WIDTH = 256;
	public static final int V_HEIGHT = 192;

	//Scale
	public static final int DESKTOP_SCALE = 2;
	public static final String DESKTOP_TITLE = "Pokemon Saturn";

	public static final int TILE_SIZE = 16;

	public SpriteBatch batch;
	public AssetManager assetManager;

	public MenuScreen menuScreen;
	public PlayScreen playScreen;
	public BattleScreen battleScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		loadAssets();
		menuScreen = new MenuScreen(this);
		playScreen = new PlayScreen(this);
		battleScreen = new BattleScreen(this);

		setScreen(menuScreen);
	}

	private void loadAssets() {
		assetManager.load("trainersyes.atlas", TextureAtlas.class);
		assetManager.finishLoading();
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		assetManager.dispose();
		menuScreen.dispose();
		playScreen.dispose();
//		battleScreen.dispose();
		batch.dispose();
	}
}
