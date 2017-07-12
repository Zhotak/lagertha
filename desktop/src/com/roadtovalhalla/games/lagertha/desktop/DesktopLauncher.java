package com.roadtovalhalla.games.lagertha.desktop;

import com.roadtovalhalla.games.lagertha.desktop.app.GameApplication;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		GameApplication game = new GameApplication();
		game.startGame();
	}
}
