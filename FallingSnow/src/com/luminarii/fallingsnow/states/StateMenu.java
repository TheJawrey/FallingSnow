package com.luminarii.fallingsnow.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.luminarii.fallingsnow.graphix.Graphix;
import com.luminarii.fallingsnow.sounds.SoundFX;

public class StateMenu extends BasicGameState{
	
	private int score;
	private boolean scoreToShow;
	private int highScore;
	
	public static int STATE_ID = 1;
	
	public void gameOver(int passedScore){
		score = passedScore;
		scoreToShow = true;
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		container.setMouseGrabbed(false);
		if(score > highScore){
			highScore = score;
		}
		}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		SoundFX.init();	
		scoreToShow = false;
        Graphix.init();
        SoundFX.songYay.play();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Graphix.backdropMenu.draw(0, 0);
		g.setFont(Graphix.font);
		if(scoreToShow){
			g.drawString(String.valueOf(score), 295, 485);
		}
		g.drawString(String.valueOf(highScore), 670, 481);
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
