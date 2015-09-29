package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {

    static final int WORLD_WIDTH = 640;
    static final int WORLD_HEIGHT = 640;


	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Super Jumper";
		config.width=WORLD_WIDTH;
		config.height=WORLD_HEIGHT;
		System.out.println(config.backgroundFPS);
		new LwjglApplication(new MyGdxGame(), config);
	}
}
