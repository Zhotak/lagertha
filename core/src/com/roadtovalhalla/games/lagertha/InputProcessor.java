package com.roadtovalhalla.games.lagertha;

import static com.roadtovalhalla.games.lagertha.actions.Action.CLICK;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_DOWN;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_LEFT;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_RIGHT;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_UP;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.roadtovalhalla.games.lagertha.actions.Action;

public class InputProcessor {

	public List<Action> processInput() {
		List<Action> actions = new LinkedList<Action>();
		this.processKeyboard(actions);
		this.processMouse(actions);
		return actions;

	}

	private void processMouse(List<Action> actions) {
		if (Gdx.input.justTouched())
			actions.add(CLICK);
	}

	private void processKeyboard(List<Action> actions) {
		if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			actions.add(MOVE_RIGHT);

		if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT))
			actions.add(MOVE_LEFT);

		if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP))
			actions.add(MOVE_UP);

		if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN))
			actions.add(MOVE_DOWN);
	}
}
