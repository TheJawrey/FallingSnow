package com.luminarii.fallingsnow.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateMenu extends BasicGameState{
	
	private int score;
	private boolean scoreToShow;
	
	public static int STATE_ID = 1;
	
	public void gameOver(int passedScore){
		score = passedScore;
		scoreToShow = true;
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		container.setMouseGrabbed(false);
	}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		scoreToShow = false;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setBackground(Color.blue);
		g.setColor(Color.white);
		g.drawString("                   *Falling Snow*\nLeft Click to start game     Right Click to quit", 150, 300);
		if(scoreToShow){
			g.drawString("Last Score: "+score, 320, 350);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			game.enterState(StateGame.STATE_ID);
		}
		if(container.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			container.exit();
		}
	}

	@Override
	public int getID() {
		return STATE_ID;
	}
}
