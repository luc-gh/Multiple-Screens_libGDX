package com.libgdx.screen;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.libgdx.screen.Jogo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Telas de jogo multiplas");
		config.setWindowedMode(500,500);
		config.setResizable(false);
		new Lwjgl3Application(new Jogo(), config);
	}
}