package com.luminarii.fallingsnow.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateGameOver extends BasicGameState{

	private int score;
	
	public void passScore(int sco){
		score = sco;
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		container.setMouseGrabbed(false);
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.drawString("GAME OVER!\nScore of "+score+".\nClick anywhere to restart.", 280, 290);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int arg2) throws SlickException {
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			game.enterState(0);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
}
