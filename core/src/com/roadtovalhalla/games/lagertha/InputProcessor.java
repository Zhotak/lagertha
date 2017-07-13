package com.roadtovalhalla.games.lagertha;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.roadtovalhalla.games.lagertha.render.colors.RGB;

public class InputProcessor {
	
	public void processInput() {
		this.processKeyboard();
		this.processMouse();
	}

	private void processMouse() {
		float x = Gdx.input.getX();
		float y = screen.getHeight() - Gdx.input.getY();
		
		if(Gdx.input.isTouched()){
			xCat = x;
			yCat = y;
		}
		
		if(Gdx.input.justTouched())
			screen.setColor(new RGB(0f, 1f, 0f), 0.5f);
			
		dogSprite.setPosition(x, y);
	}

	private void processKeyboard() {
		boolean isRightPressed = Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);
		boolean isLeftPressed = Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
		boolean isUpPressed = Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
		boolean isDownPressed = Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);

		float aceleration = Gdx.graphics.getDeltaTime();

		if (isRightPressed)
			xCat = xCat + velocity * aceleration;

		if (isLeftPressed)
			xCat = xCat - velocity * aceleration;

		if (isUpPressed)
			yCat = yCat + velocity * aceleration;

		if (isDownPressed)
			yCat = yCat - velocity * aceleration;

		catSprite.setPosition(xCat, yCat);
	}
}
