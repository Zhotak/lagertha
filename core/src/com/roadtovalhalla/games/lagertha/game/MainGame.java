package com.roadtovalhalla.games.lagertha.game;

import static com.roadtovalhalla.games.lagertha.render.colors.Color.BLUE;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.roadtovalhalla.games.lagertha.render.screens.ScreenSettings;
import com.roadtovalhalla.games.lagertha.screens.mainscreen.MainScreen;

public class MainGame extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	private MainScreen mainScreen;
	private MainScreen mainScreen2;
	private ScreenSettings settings;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		settings = new ScreenSettings();
		this.loadScreens();
		settings.setColor(BLUE, 1);
		this.setScreen(mainScreen);
	}

	private void loadScreens() {
		mainScreen = new MainScreen(this, "Pantalla 1");
		mainScreen2 = new MainScreen(this, "Pantalla 2");
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}

	public MainScreen getMainScreen() {
		return mainScreen;
	}

	public MainScreen getMainScreen2() {
		return mainScreen2;
	}
	
	public ScreenSettings getSettings(){
		return settings;
	}
}
