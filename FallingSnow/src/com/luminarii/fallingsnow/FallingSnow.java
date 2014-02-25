package com.luminarii.fallingsnow;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;

import com.luminarii.fallingsnow.states.*;

public class FallingSnow extends StateBasedGame {

	public static StateMenu menu;
	public static StateGame game;
	public static StatePause pause;
	
    public FallingSnow() {
        super("Falling Snow");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new FallingSnow());
            app.setTargetFrameRate(60);
            app.setDisplayMode(800, 600, false);
            app.setShowFPS(false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		menu = new StateMenu();
		game = new StateGame();
		pause = new StatePause();
		
		this.addState(menu);
		this.addState(game);
		this.addState(pause);
	}
}
