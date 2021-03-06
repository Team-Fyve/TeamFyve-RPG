package dev.whiting.javatilegame.entities.statics;

import java.awt.Graphics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.gfx.Assets;
import dev.whiting.javatilegame.items.Item;
import dev.whiting.javatilegame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);

		bounds.x = 24;
		bounds.y = 96;
		bounds.width = 16;
		bounds.height = 32;

	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.wood.createNew((int) x, (int) y));
	}

}
