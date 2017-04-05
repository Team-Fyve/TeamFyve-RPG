package dev.whiting.javatilegame.states;

import java.awt.Graphics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.worlds.World;

public class GameState extends State {

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		
		world.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		world.render(g);
		
	}

}
