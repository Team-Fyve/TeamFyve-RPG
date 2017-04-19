package dev.whiting.javatilegame.worlds;

import java.awt.Graphics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.entities.EntityManager;
import dev.whiting.javatilegame.entities.creatures.Player;
import dev.whiting.javatilegame.entities.statics.Tree;
import dev.whiting.javatilegame.items.ItemManager;
import dev.whiting.javatilegame.tiles.Tile;
import dev.whiting.javatilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	private EntityManager entityManager;
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 250, 250));
		itemManager = new ItemManager(handler);
		
		entityManager.addEntity(new Tree(handler, 200, 400));
		entityManager.addEntity(new Tree(handler, 250, 400));
		entityManager.addEntity(new Tree(handler, 300, 400));
		entityManager.addEntity(new Tree(handler, 150, 400));
		entityManager.addEntity(new Tree(handler, 100, 400));
		entityManager.addEntity(new Tree(handler, 350, 400));
		
		entityManager.addEntity(new Tree(handler, 200, 500));
		entityManager.addEntity(new Tree(handler, 250, 500));
		entityManager.addEntity(new Tree(handler, 300, 500));
		entityManager.addEntity(new Tree(handler, 100, 500));
		entityManager.addEntity(new Tree(handler, 150, 500));
		entityManager.addEntity(new Tree(handler, 350, 500));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);;
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.stoneTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
