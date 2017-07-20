package com.roadtovalhalla.games.lagertha.screens.mainscreen.inputprocessor;

import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_DOWN;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_LEFT;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_RIGHT;
import static com.roadtovalhalla.games.lagertha.actions.Action.MOVE_UP;
import static com.roadtovalhalla.games.lagertha.actions.Action.NONE;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.roadtovalhalla.games.lagertha.actions.Action;

public class MainScreenInputProcessor extends InputAdapter {

	private List<Action> movementActions;

	public MainScreenInputProcessor() {
		movementActions = new ArrayList<Action>();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return true;
	}

	@Override
	public boolean keyDown(int keycode) {
		List<Action> newActions = new ArrayList<Action>();

		switch (keycode) {
		case Input.Keys.D:
			if (!movementActions.contains(MOVE_RIGHT)) {
				newActions.add(MOVE_RIGHT);
			}
			break;
		case Input.Keys.A:
			if (!movementActions.contains(MOVE_LEFT)) {
				newActions.add(MOVE_LEFT);
			}
			break;
		case Input.Keys.W:
			if (!movementActions.contains(MOVE_UP)) {
				newActions.add(MOVE_UP);
			}
			break;
		case Input.Keys.S:
			if (!movementActions.contains(MOVE_DOWN)) {
				newActions.add(MOVE_DOWN);
			}
			break;
		default:
		}
		newActions.addAll(movementActions);
		movementActions = newActions;
		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Input.Keys.D:
			if (movementActions.contains(MOVE_RIGHT)) {
				movementActions.remove(MOVE_RIGHT);
			}
			break;
		case Input.Keys.A:
			if (movementActions.contains(MOVE_LEFT)) {
				movementActions.remove(MOVE_LEFT);
			}
			break;
		case Input.Keys.W:
			if (movementActions.contains(MOVE_UP)) {
				movementActions.remove(MOVE_UP);
			}
			break;
		case Input.Keys.S:
			if (movementActions.contains(MOVE_DOWN)) {
				movementActions.remove(MOVE_DOWN);
			}
			break;
		default:
		}
		return true;
	}

	public Action getMovement() {
		return movementActions.isEmpty() ? NONE : movementActions.get(0);
	}
}
