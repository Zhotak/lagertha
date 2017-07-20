package com.roadtovalhalla.games.lagertha.screens.mainscreen;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.actions.Action;
import com.roadtovalhalla.games.lagertha.game.MainGame;
import com.roadtovalhalla.games.lagertha.screens.AbstractScreen;
import com.roadtovalhalla.games.lagertha.screens.mainscreen.inputprocessor.MainScreenInputProcessor;
import com.roadtovalhalla.games.lagertha.sprites.AbstractSprite;
import com.roadtovalhalla.games.lagertha.sprites.HumanSprite;

public class MainScreen extends AbstractScreen {

	private TextureAtlas atlas;
	private String name;
	private BitmapFont font;
	private SpriteBatch batch;
	private MainScreenInputProcessor input;
	private List<AbstractSprite> sprites;
	private float duration = 0f;
	
	public MainScreen(MainGame game, String screenName) {
		super(game);
		name = screenName;
		font = new BitmapFont();
		this.batch = game.getBatch();
	}

	@Override
	public void show() {
		atlas = new TextureAtlas("atlas.atlas");
		input = new MainScreenInputProcessor();
		Gdx.input.setInputProcessor(input);
		this.loadSprites();
	}

	private void loadSprites() {
		sprites = new LinkedList<AbstractSprite>();
		sprites.add(new HumanSprite(atlas.findRegion("gutt")));
	}

	@Override
	public void render(float delta) {
		game.getSettings().paint();
		
//		if(actions.contains(Action.CLICK))
//			game.setScreen(game.getMainScreen2());
		Action movementAction = input.getMovement();
		if(movementAction != Action.NONE)
			sprites.forEach(s->s.processAction(movementAction));
		
		duration += delta;
	
		batch.begin();
			sprites.forEach(s->{
				TextureRegion region = s.getAnimation().getKeyFrame(duration, true);
				batch.draw(region, 100, 100);
			});
			sprites.forEach(s->s.draw(batch));
			font.draw(batch, name, 150, 150);
			font.draw(batch, "Movement: " + movementAction.toString(), 20, 20);
		batch.end();
	}
	
	@Override
	public void dispose() {
		sprites.forEach(s->s.dispose());
		super.dispose();
	}

}
