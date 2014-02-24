package com.luminarii.fallingsnow.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StatePause extends BasicGameState{
	
	public static int STATE_ID = 2;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.drawString("Paused", 350, 300);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
			game.enterState(StateGame.STATE_ID);
		}
	}

	@Override
	public int getID() {
		return STATE_ID;
	}
}
