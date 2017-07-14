package com.roadtovalhalla.games.lagertha.desktop.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.roadtovalhalla.games.lagertha.adapter.LagerthaGame;
import com.roadtovalhalla.games.lagertha.desktop.configurations.GameConfiguration;

public class GameApplication {
	
	private GameConfiguration configuration;
	private LagerthaGame adapter;
	
	public void startGame(){
		this.loadConfiguration();
		this.loadAdapter();
		new LwjglApplication(adapter, configuration);
	}
	
	private void loadConfiguration(){
		configuration = new GameConfiguration(); 
	}
	
	private void loadAdapter(){
		adapter = new LagerthaGame();
	}
}
