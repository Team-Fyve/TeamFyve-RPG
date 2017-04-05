package dev.whiting.javatilegame.entities.statics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
}
