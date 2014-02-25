package com.luminarii.fallingsnow.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StatePause extends BasicGameState{
	
	public static int STATE_ID = 3;
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.drawString("                     Paused\nLeft Click to resume game     Right Click to quit to menu", 150, 300);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			game.enterState(StateGame.STATE_ID);
		}
		if(container.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			game.enterState(StateMenu.STATE_ID);
		}
	}

	@Override
	public int getID() {
		return STATE_ID;
	}
}
