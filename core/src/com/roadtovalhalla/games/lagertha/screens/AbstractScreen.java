package com.roadtovalhalla.games.lagertha.screens;

import com.badlogic.gdx.Screen;
import com.roadtovalhalla.games.lagertha.InputProcessor;
import com.roadtovalhalla.games.lagertha.adapter.MainGame;

public abstract class AbstractScreen implements Screen {

	protected MainGame game;
	protected InputProcessor inputProcessor;
	
	public AbstractScreen(MainGame game){
		this.game = game;
		inputProcessor = game.getInputProcessor();
	}

	@Override
	public void resize(int width, int height) {
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
	}

}
