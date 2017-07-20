package com.roadtovalhalla.games.lagertha.sprites;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.roadtovalhalla.games.lagertha.actions.Action;

public abstract class AbstractSprite extends Sprite implements LagerthaSprite {

	protected Animation<TextureRegion> animation;
	
	public AbstractSprite(TextureRegion texture) {
		super(texture);
		TextureRegion[][] temp = texture.split(13, 23);
		TextureRegion [] frames = new TextureRegion[12];
		int index = 0;
		for(int i = 0; i < temp.length; i++){
			for(int j = 0; j < temp[i].length; j++){
				frames[index++] = temp[i][j];
			}
		}
		
		animation = new Animation<>(0.2f, frames);
		
		
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

	public Animation<TextureRegion> getAnimation(){
		return animation;
	}

}
