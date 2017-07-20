package com.roadtovalhalla.games.lagertha.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.roadtovalhalla.games.lagertha.actions.Action;

public abstract class AbstractActor extends Actor implements Disposable {
	public abstract void act(Action action, float delta);
}
