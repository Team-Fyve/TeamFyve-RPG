package dev.whiting.javatilegame.entities.creatures;

import dev.whiting.javatilegame.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.entities.Entity;
import dev.whiting.javatilegame.gfx.Animation;
import dev.whiting.javatilegame.gfx.Assets;

public class Player extends Creature {
	
	private Animation animDown;
	private Animation animUp;
	private Animation animRight;
	private Animation animLeft;
	
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

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
		
		checkAttacks();
	}
	
	private void checkAttacks() {
		
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown) {
			return;
		} 
		
		java.awt.Rectangle cb = getCollisionBounds(0,0);
		java.awt.Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if (handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		} else if (handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}
		
		attackTimer = 0;
		
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			} 
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(2);
				return;
			}
		}
		
	}
	
	@Override
	public void die() {
		System.out.println("You Lost");
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
		
		if (handler.getKeyManager().aRight || handler.getKeyManager().aLeft || 
				handler.getKeyManager().aUp || handler.getKeyManager().aDown && 
				attackTimer < attackCooldown) {
			g.setColor(Color.RED);
			g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
			(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
			bounds.width, bounds.height);
		} else {
			g.setColor(null);
		}
		
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
