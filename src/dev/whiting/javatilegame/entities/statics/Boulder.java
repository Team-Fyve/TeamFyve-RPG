package dev.whiting.javatilegame.entities.statics;

import java.awt.Graphics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.gfx.Assets;
import dev.whiting.javatilegame.items.Item;
import dev.whiting.javatilegame.tiles.Tile;

public class Boulder extends StaticEntity {

	public Boulder(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

		bounds.x = 5;
		bounds.y = 5;
		bounds.width = Tile.TILE_WIDTH - 5;
		bounds.height = Tile.TILE_HEIGHT - 5;

	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.boulder, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rock.createNew((int) x, (int) y));
	}

}