package com.roadtovalhalla.games.lagertha.screens;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.roadtovalhalla.games.lagertha.actions.Action;
import com.roadtovalhalla.games.lagertha.adapter.MainGame;

public class MainScreen extends AbstractScreen {

	private String name;
	private BitmapFont font;
	private SpriteBatch batch;
	
	public MainScreen(MainGame game, String screenName) {
		super(game);
		name = screenName;
		font = new BitmapFont();
		this.batch = game.getBatch();
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		game.getSettings().paint();
		
		List<Action> actions = inputProcessor.processInput();
		if(actions.contains(Action.MOVE_DOWN))
			game.setScreen(game.getMainScreen());
		if(actions.contains(Action.CLICK))
			game.setScreen(game.getMainScreen2());
		batch.begin();
			font.draw(batch, name, 150, 150);
		batch.end();
	}

}
