package dev.whiting.javatilegame.states;

import java.awt.Graphics;

import dev.whiting.javatilegame.Handler;
import dev.whiting.javatilegame.gfx.Assets;
import dev.whiting.javatilegame.ui.ClickListener;
import dev.whiting.javatilegame.ui.UIImageButton;
import dev.whiting.javatilegame.ui.UIManager;
import javafx.application.Platform;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(230, 128, 256, 128, Assets.start, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		
		uiManager.addObject(new UIImageButton(230, 280, 256, 128, Assets.quit, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				System.exit(0);
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
