package com.github.theresajayne.spaceattack.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.theresajayne.spaceattack.SpaceAttack;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Attack";
		config.width = 2560;
		config.height = 1080;
		config.fullscreen = true;

		new LwjglApplication(new SpaceAttack(), config);
	}
}
