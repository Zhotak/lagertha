package com.roadtovalhalla.games.lagertha.sprites;

import static com.roadtovalhalla.games.lagertha.actions.Action.CLICK;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.actions.Action;

public class HumanSprite extends AbstractSprite implements LagerthaSprite {
	
	public HumanSprite(TextureRegion texture) {
		super(texture);
	}

	private float velocity = 150f;

	@Override
	public void processAction(Action action) {
		if (!action.equals(CLICK))
			this.move(action);
	}

	private void move(Action action) {
		final float aceleration = Gdx.graphics.getDeltaTime() * velocity;
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
		this.updatePosition(x, y);
	}

}
