package com.antonleagre.pokemonsaturn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.antonleagre.pokemonsaturn.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Main.DESKTOP_TITLE;
		config.width = Main.V_WIDTH;
		config.height = Main.V_HEIGHT;
		new LwjglApplication(new Main(), config);
	}
}
