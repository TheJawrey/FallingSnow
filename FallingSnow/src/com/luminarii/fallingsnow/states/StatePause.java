package com.luminarii.fallingsnow.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.luminarii.fallingsnow.graphix.Graphix;
import com.luminarii.fallingsnow.sounds.SoundFX;

public class StatePause extends BasicGameState{
	
	public static int STATE_ID = 3;
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		SoundFX.songYay.setVolume(0.3f);
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Graphix.backdropPause.draw(0, 0);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			SoundFX.songYay.setVolume(1.0f);
			game.enterState(StateGame.STATE_ID);
		}
		if(container.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			SoundFX.songYay.setVolume(1.0f);
			game.enterState(StateMenu.STATE_ID);
		}
	}

	@Override
	public int getID() {
		return STATE_ID;
	}
}
