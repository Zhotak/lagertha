package com.roadtovalhalla.games.lagertha.adapter;

import static com.roadtovalhalla.games.lagertha.render.colors.Color.BLUE;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.InputProcessor;
import com.roadtovalhalla.games.lagertha.actions.Action;
import com.roadtovalhalla.games.lagertha.render.screens.ScreenSettings;
import com.roadtovalhalla.games.lagertha.screens.MainScreen;
import com.roadtovalhalla.games.lagertha.sprites.AbstractSprite;
import com.roadtovalhalla.games.lagertha.sprites.CatSprite;
import com.roadtovalhalla.games.lagertha.sprites.DogSprite;

public class MainGame extends Game {

	private SpriteBatch batch;
	private BitmapFont font;
	private MainScreen mainScreen;
	private MainScreen mainScreen2;
	private ScreenSettings settings;
	private List<AbstractSprite> sprites;
	private InputProcessor inputProcessor;

	@Override
	public void create() {
		inputProcessor = new InputProcessor();
		batch = new SpriteBatch();
		font = new BitmapFont();
		settings = new ScreenSettings();
		this.loadScreens();
		this.loadSprites();
		settings.setColor(BLUE, 1);
		this.setScreen(mainScreen);
	}

	private void loadScreens() {
		mainScreen = new MainScreen(this, "Pantalla 1");
		mainScreen2 = new MainScreen(this, "Pantalla 2");
	}

	private void loadSprites() {
		sprites = new LinkedList<AbstractSprite>();
		sprites.add(new DogSprite(new TextureRegion(new Texture("perrito.png"))));
		sprites.add(new CatSprite(new TextureRegion(new Texture("cat.png"))));
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		sprites.forEach(s -> s.dispose());
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

	public InputProcessor getInputProcessor() {
		return inputProcessor;
	}
	
	public ScreenSettings getSettings(){
		return settings;
	}
}
