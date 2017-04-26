package dev.whiting.javatilegame.tiles;

import dev.whiting.javatilegame.gfx.Assets;

public class FenceTL extends Tile {
	
	public FenceTL(int id) {
		super(Assets.fenceTL, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}