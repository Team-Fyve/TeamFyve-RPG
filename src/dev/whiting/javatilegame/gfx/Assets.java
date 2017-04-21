package dev.whiting.javatilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int sWidth = 32, sHeight = 50, tWidth = 64, tHeight = 64;
	
	public static BufferedImage grass, stone, wood, rock, water;
	public static BufferedImage tree, boulder;
	public static BufferedImage fenceLR, fenceTR, fenceTL, fenceTBR, fenceTBL;
	public static BufferedImage roadTB, roadLR, roadTL, roadTR, roadBL, roadBR, road4W;
	public static BufferedImage redButton, greenButton;
	public static BufferedImage inventoryScreen;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] btn_start;
	
	public static Font font28;

	public static void init() {
		
		font28 = FontLoader.loadFont("res/fonts/ARIAL.TTF", 28);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/TestSpriteSheet.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/GameTiles.png"));
		SpriteSheet redButton = new SpriteSheet(ImageLoader.loadImage("/textures/redbutton.png"));
		SpriteSheet greenButton = new SpriteSheet(ImageLoader.loadImage("/textures/greenbutton.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");

		wood = ImageLoader.loadImage("/textures/Wood.png");
		tree = ImageLoader.loadImage("/textures/Tree.png");
		
		boulder = ImageLoader.loadImage("/textures/Boulder.png");
		rock = ImageLoader.loadImage("/textures/Rock.png");
		
		btn_start = new BufferedImage[2];
		btn_start[0] = greenButton.crop(0, 0, 256, 256);
		btn_start[1] = redButton.crop(0, 0, 256, 256);
		
		player_down = new BufferedImage[4];
		player_down[0] = sheet.crop(0, 0, sWidth, sHeight);
		player_down[1] = sheet.crop(sWidth, 0, sWidth, sHeight);
		player_down[2] = sheet.crop(2 * sWidth, 0, sWidth, sHeight);
		player_down[3] = sheet.crop(3 * sWidth, 0, sWidth, sHeight);
		
		player_up = new BufferedImage[4];
		player_up[0] = sheet.crop(0, 3 * sHeight, sWidth, sHeight);
		player_up[1] = sheet.crop(sWidth, 3 * sHeight, sWidth, sHeight);
		player_up[2] = sheet.crop(2 * sWidth, 3 * sHeight, sWidth, sHeight);
		player_up[3] = sheet.crop(3 * sWidth, 3 * sHeight, sWidth, sHeight);
		
		player_right = new BufferedImage[4];
		player_right[0] = sheet.crop(0, 2 * sHeight, sWidth, sHeight);
		player_right[1] = sheet.crop(sWidth, 2 * sHeight, sWidth, sHeight);
		player_right[2] = sheet.crop(2 * sWidth, 2 * sHeight, sWidth, sHeight);
		player_right[3] = sheet.crop(3 * sWidth, 2 * sHeight, sWidth, sHeight);
		
		player_left = new BufferedImage[4];
		player_left[0] = sheet.crop(0, sHeight, sWidth, sHeight);
		player_left[1] = sheet.crop(sWidth, sHeight, sWidth, sHeight);
		player_left[2] = sheet.crop(2 * sWidth, sHeight, sWidth, sHeight);
		player_left[3] = sheet.crop(3 * sWidth, sHeight, sWidth, sHeight);
	
		grass = tiles.crop(0, 0, tWidth, tHeight);
		stone = tiles.crop(tWidth, 3 * tHeight, tWidth, tHeight);
		water = tiles.crop(tWidth * 2, tHeight * 3, tWidth, tHeight);
		
		fenceLR = tiles.crop(tWidth, 0, tWidth, tHeight);
		fenceTR = tiles.crop(2 * tWidth, 0, tWidth, tHeight);
		fenceTL = tiles.crop(3 * tWidth, 0, tWidth, tHeight);
		fenceTBR = tiles.crop(0, tHeight, tWidth, tHeight);
		fenceTBL = tiles.crop(tWidth, tHeight, tWidth, tHeight);
		
		roadTB = tiles.crop(2 * tWidth, tHeight, tWidth, tHeight);
		roadLR = tiles.crop(3 * tWidth, tHeight, tWidth, tHeight);
		roadTL = tiles.crop(0, 2 * tHeight, tWidth, tHeight);
		roadTR = tiles.crop(2 * tWidth, 2 * tHeight, tWidth, tHeight);
		roadBL = tiles.crop(tWidth, 2 * tHeight, tWidth, tHeight);
		roadBR = tiles.crop(3 * tWidth, 2 * tHeight, tWidth, tHeight);
		road4W = tiles.crop(0, 3 * tHeight, tWidth, tHeight);
		
	}
	
}