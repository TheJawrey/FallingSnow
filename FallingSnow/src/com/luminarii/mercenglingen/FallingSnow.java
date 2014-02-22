package com.luminarii.mercenglingen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.StateBasedGame;
import com.luminarii.mercenglingen.states.*;

public class FallingSnow extends StateBasedGame {

	public static StateGame game;
	public static StateGameOver gameOver; 
	
    public FallingSnow() {
        super("Falling Snow");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new FallingSnow());
            app.setTargetFrameRate(60);
            app.setDisplayMode(800, 600, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		game = new StateGame();
		gameOver = new StateGameOver();
		this.addState(game);
		this.addState(gameOver);
	}
}
