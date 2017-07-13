package com.roadtovalhalla.games.lagertha.sprites;

import java.util.List;

import com.roadtovalhalla.games.lagertha.actions.Action;

public interface LagerthaSprite {

	void processActions(List<Action> actions);

	void processAction(Action action);
}
