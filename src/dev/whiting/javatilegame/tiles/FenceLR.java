package dev.whiting.javatilegame.tiles;

import dev.whiting.javatilegame.gfx.Assets;

public class FenceLR extends Tile {
	
	public FenceLR(int id) {
		super(Assets.fenceLR, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
