package dev.whiting.javatilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneTile = new StoneTile(1);
	public static Tile waterTiles = new WaterTile(2);
	
	public static Tile fenceLR = new FenceLR(3);
	public static Tile fenceTR = new FenceTR(4);
	public static Tile fenceTL = new FenceTL(5);
	public static Tile fenceTBR = new FenceTBR(6);
	public static Tile fenceTBL = new FenceTBL(7);
	
	public static Tile roadTB = new RoadTB(8);
	public static Tile roadLR = new RoadLR(9);
	public static Tile roadTL = new RoadTL(10);
	public static Tile roadTR = new RoadTR(11);
	public static Tile roadBL = new RoadBL(12);
	public static Tile roadBR = new RoadBR(13);
	public static Tile road4W = new Road4W(14);
	
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
}
