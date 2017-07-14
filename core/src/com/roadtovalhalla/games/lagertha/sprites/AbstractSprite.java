package com.roadtovalhalla.games.lagertha.sprites;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.actions.Action;

public abstract class AbstractSprite extends Sprite implements LagerthaSprite {

	public AbstractSprite(TextureRegion texture) {
		super(texture);
		this.setBounds(0, 0, 150, 150);
	}

	public void processActions(List<Action> actions) {
		actions.forEach(action -> this.processAction(action));
	}

	protected void updatePosition(float x, float y) {
		this.setPosition(x, y);
	}

	public void dispose() {
		this.getTexture().dispose();
	}

}
