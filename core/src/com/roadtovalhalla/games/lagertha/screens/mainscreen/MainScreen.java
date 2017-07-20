package com.roadtovalhalla.games.lagertha.screens.mainscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.roadtovalhalla.games.lagertha.actors.humans.Human;
import com.roadtovalhalla.games.lagertha.game.MainGame;
import com.roadtovalhalla.games.lagertha.screens.AbstractScreen;
import com.roadtovalhalla.games.lagertha.screens.mainscreen.inputprocessor.MainScreenInputProcessor;
import com.roadtovalhalla.games.lagertha.stages.MainStage;

public class MainScreen extends AbstractScreen {

	private String name;
	private BitmapFont font;
	private SpriteBatch batch;
	private MainScreenInputProcessor input;
	private MainStage mainStage;
	private Human player;

	public MainScreen(MainGame game, String screenName) {
		super(game);
		name = screenName;
		font = new BitmapFont();
		this.batch = game.getBatch();
	}

	@Override
	public void show() {
		input = new MainScreenInputProcessor();
		Gdx.input.setInputProcessor(input);

		mainStage = new MainStage(new ScreenViewport());
		player = new Human();
		mainStage.addActor(player);
	}

	@Override
	public void render(float delta) {
		game.getSettings().paint();
		// game.setScreen(game.getMainScreen2());
		batch.begin();
			font.draw(batch, name, 100, 100);
		batch.end();
		
		mainStage.act(input.getMovement(), delta);
		mainStage.draw();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void resize(int width, int height) {
		mainStage.getViewport().update(width, height);
	}
}
