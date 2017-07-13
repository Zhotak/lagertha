package com.roadtovalhalla.games.lagertha.adapter;

import static com.roadtovalhalla.games.lagertha.render.colors.Color.BLUE;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.roadtovalhalla.games.lagertha.InputProcessor;
import com.roadtovalhalla.games.lagertha.render.colors.RGB;
import com.roadtovalhalla.games.lagertha.render.screens.Screen;

public class GraphicEngine extends ApplicationAdapter {

	private SpriteBatch batch;
	private BitmapFont font;
	private Screen screen;
	private Texture dogTexture;
	private Texture catTexture;
	private Sprite catSprite;
	private Sprite dogSprite;
	private float xCat;
	private float yCat;
	private final float velocity = 150;
	private InputProcessor inputProcessor; 

	@Override
	public void create() {
		inputProcessor = new InputProcessor();
		batch = new SpriteBatch();
		font = new BitmapFont();
		screen = new Screen();
		
		this.loadTextures();
		this.initializeTextures();
		
		screen.setColor(BLUE, 1);
	}
	
	@Override
	public void render() {
		inputProcessor.processInput();
		this.renderGame();
	}
	
	private void loadTextures(){
		dogTexture = new Texture("perrito.png");
		dogSprite = new Sprite(dogTexture);
		catTexture = new Texture("cat.png");
		catSprite = new Sprite(catTexture);
	}
	
	private void initializeTextures(){
		catSprite.setBounds(400, 400, 150, 150);
		dogSprite.setBounds(0, 0, 150, 150);

		xCat = catSprite.getX();
		yCat = catSprite.getY();
	}
	
	private void renderGame() {
		screen.paint();
		batch.begin();
		catSprite.draw(batch);
		dogSprite.draw(batch);
		font.draw(batch, "Hello cat", 50, 50);
		batch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		catTexture.dispose();
		dogTexture.dispose();
		font.dispose();
	}
}
