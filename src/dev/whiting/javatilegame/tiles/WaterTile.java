package dev.whiting.javatilegame.tiles;

import dev.whiting.javatilegame.gfx.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}
