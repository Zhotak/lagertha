package com.roadtovalhalla.games.lagertha.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.actions.Action;

public class CatSprite extends AbstractSprite implements LagerthaSprite {

	public CatSprite(TextureRegion texture) {
		super(texture);
	}

	@Override
	public void processAction(Action action) {
		if (action.equals(Action.CLICK))
			this.move();
	}

	private void move() {
		float x = Gdx.input.getX();
		float y = Gdx.graphics.getHeight() - Gdx.input.getY();
		this.updatePosition(x, y);
	}
}
