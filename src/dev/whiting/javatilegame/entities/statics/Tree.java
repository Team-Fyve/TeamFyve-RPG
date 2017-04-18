package dev.whiting.javatilegame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.gfx.Assets;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, 64, 128);

		bounds.x = 16;
		bounds.y = 96;
		bounds.width = 32;
		bounds.height = 32;

	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), null);

		g.setColor(Color.RED);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	@Override
	public void die() {
		
	}

}
