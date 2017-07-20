package com.roadtovalhalla.games.lagertha.stages;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.roadtovalhalla.games.lagertha.actions.Action;

public class MainStage extends AbstractStage {

	public MainStage(Viewport viewPort) {
		super(viewPort);
	}

	public void act(Action action, float delta) {
		actors.forEach(a->a.act(action, delta));
		this.act();
	}
}
