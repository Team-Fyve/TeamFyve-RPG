package dev.whiting.javatilegame.tiles;

import dev.whiting.javatilegame.gfx.Assets;

public class FenceTR extends Tile {
	
	public FenceTR(int id) {
		super(Assets.fenceTR, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}