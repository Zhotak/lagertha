package com.roadtovalhalla.games.lagertha.render.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class ScreenSettings {

	public void paint() {
		Gdx.gl.glClearColor(1f, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public int getHeight(){
		return Gdx.graphics.getHeight();	
	}
	
	public int getWidth(){
		return Gdx.graphics.getWidth();
	}
	
}
