package dev.whiting.javatilegame.tiles;

import dev.whiting.javatilegame.gfx.Assets;

public class FenceTBL extends Tile {
	
	public FenceTBL(int id) {
		super(Assets.fenceTBL, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}