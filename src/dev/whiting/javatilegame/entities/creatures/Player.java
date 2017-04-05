package dev.whiting.javatilegame.entities.creatures;

import dev.whiting.javatilegame.Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.gfx.Animation;
import dev.whiting.javatilegame.gfx.Assets;

public class Player extends Creature {
	
	private Animation animDown;
	private Animation animUp;
	private Animation animRight;
	private Animation animLeft;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 8;
		bounds.y = 20;
		bounds.width = 17;
		bounds.height = 28;
		
		animDown = new Animation(200, Assets.player_down);
		animUp = new Animation(200, Assets.player_up);
		animRight = new Animation(200, Assets.player_right);
		animLeft = new Animation(200, Assets.player_left);
	}

	@Override
	public void tick() {
		
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
                        Game.sound.playBackGround("/sounds/fired");
		}
		if(handler.getKeyManager().down) {
			yMove = +speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = +speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.RED);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
		//(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
		//bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return Assets.player_down[0];
		}
	}

}
