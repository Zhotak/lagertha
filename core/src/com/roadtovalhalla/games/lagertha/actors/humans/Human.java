package com.roadtovalhalla.games.lagertha.actors.humans;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.actions.Action;
import com.roadtovalhalla.games.lagertha.actors.AbstractActor;

public class Human extends AbstractActor {

	private TextureRegion textureRegion;
	private TextureRegion[] frames;
	private final float velocity = 50f;

	public Human() {
		TextureAtlas atlas = new TextureAtlas("atlas.atlas");
		textureRegion = atlas.findRegion("gutt");
		this.setPosition(50, 50);
		this.setSize(39, 92);
	}

	public void act(Action action, float delta) {
		this.move(action, delta);
		super.act(delta);
	}
	
	
	private void move(Action action, float delta) {
		final float aceleration = delta * velocity;
		float x = this.getX();
		float y = this.getY();
		switch (action) {
		case MOVE_RIGHT:
			x += aceleration;
			break;
		case MOVE_LEFT:
			x -= aceleration;
			break;
		case MOVE_UP:
			y += aceleration;
			break;
		case MOVE_DOWN:
			y -= aceleration;
			break;
		default:
			break;
		}
		this.setPosition(x, y);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// Color c = this.getColor();
		// batch.setColor(c.r, c.g, c.b, c.a);
		batch.draw(textureRegion, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(),
				this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
	}

	@Override
	public void dispose() {
		textureRegion.getTexture().dispose();
	}
}
