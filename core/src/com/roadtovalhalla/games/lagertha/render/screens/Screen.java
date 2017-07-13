package com.roadtovalhalla.games.lagertha.render.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.roadtovalhalla.games.lagertha.render.colors.Color;
import com.roadtovalhalla.games.lagertha.render.colors.RGB;

public class Screen {

	public void setColor(RGB rgb, float alpha) {
		Gdx.gl.glClearColor(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), alpha);
	}

	public void setColor(Color color, float alpha) {
		this.setColor(color.getRGB(), alpha);
	}

	public void paint() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	public int getHeight(){
		return Gdx.graphics.getHeight();	
	}
	
	public int getWidth(){
		return Gdx.graphics.getWidth();
	}
	
}
