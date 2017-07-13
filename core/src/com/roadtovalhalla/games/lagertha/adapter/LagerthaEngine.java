package com.roadtovalhalla.games.lagertha.adapter;

import static com.roadtovalhalla.games.lagertha.render.colors.Color.BLUE;

import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.InputProcessor;
import com.roadtovalhalla.games.lagertha.actions.Action;
import com.roadtovalhalla.games.lagertha.render.screens.Screen;
import com.roadtovalhalla.games.lagertha.sprites.AbstractLagerthaSprite;
import com.roadtovalhalla.games.lagertha.sprites.CatSprite;
import com.roadtovalhalla.games.lagertha.sprites.DogSprite;

public class LagerthaEngine extends ApplicationAdapter {

	private SpriteBatch batch;
	private BitmapFont font;
	private Screen screen;
	private List<AbstractLagerthaSprite> sprites;
	private InputProcessor inputProcessor;

	@Override
	public void create() {
		inputProcessor = new InputProcessor();
		batch = new SpriteBatch();
		font = new BitmapFont();
		screen = new Screen();

		this.loadSprites();

		screen.setColor(BLUE, 1);
	}

	@Override
	public void render() {
		List<Action> actions = inputProcessor.processInput();
		sprites.forEach(s -> s.processActions(actions));
		this.renderGame();
	}

	private void loadSprites() {
		sprites.add(new DogSprite(new TextureRegion(new Texture("perrito.png"))));
		sprites.add(new CatSprite(new TextureRegion(new Texture("cat.png"))));
	}

	private void renderGame() {
		screen.paint();
		batch.begin();
		sprites.forEach(s -> s.draw(batch));
		font.draw(batch, "Hello cat", 50, 50);
		batch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		sprites.forEach(s -> s.dispose());
		font.dispose();
	}
}
