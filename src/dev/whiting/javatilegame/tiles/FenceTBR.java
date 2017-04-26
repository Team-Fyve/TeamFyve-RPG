package dev.whiting.javatilegame.tiles;

import dev.whiting.javatilegame.gfx.Assets;

public class FenceTBR extends Tile {
	
	public FenceTBR(int id) {
		super(Assets.fenceTBR, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}