package com.roadtovalhalla.games.lagertha.stages;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.roadtovalhalla.games.lagertha.actors.AbstractActor;

public abstract class AbstractStage extends Stage {

	protected List<AbstractActor> actors;

	public AbstractStage(Viewport viewPort) {
		super(viewPort);
		actors = new ArrayList<AbstractActor>();
	}
}
