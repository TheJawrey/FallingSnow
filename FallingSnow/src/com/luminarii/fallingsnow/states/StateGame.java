package com.luminarii.fallingsnow.states;

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.luminarii.fallingsnow.FallingSnow;
import com.luminarii.fallingsnow.graphix.Graphix;
import com.luminarii.fallingsnow.sounds.SoundFX;;


public class StateGame extends BasicGameState{

	private Rectangle ground;
	private ArrayList<Circle> balls;
	private int timePassed;
	private Random random;
	private int score;
	private int lastExit;
	private ArrayList<Circle> superSnow;
	private int powerUp1;
	private int powerChance1;
	
	public static int STATE_ID = 2;
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		if(lastExit != StatePause.STATE_ID){
			balls.clear();
			ground.setCenterX(400);
			timePassed=0;
			score = 0;
			container.setMouseGrabbed(false);
			
			
		
		}
	}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		balls = new ArrayList<Circle>();
		ground = new Rectangle((container.getWidth()/2)-75, 570, 150, 15);
		timePassed = 0;
		random = new Random();
		score = 0;
		powerUp1 = 1;
		}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		Graphix.backdropGame.draw(0, 0);
		g.setColor(Color.red);
		g.fill(ground);
		for(Circle c : balls){
			Graphix.snowflake.draw(c.getX(), c.getY());
		}
		g.setColor(Color.white);
		Graphix.font.drawString(400 - (Graphix.font.getWidth(String.valueOf(score)) / 2), 30, String.valueOf(score));
	}
	

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		timePassed += delta;
		if(timePassed >350){
			timePassed = 0;
			powerChance1 = random.nextInt(10);
			balls.add(new Circle(100+random.nextInt(500), 0, 13));
		}
		for(Circle c : balls){
			c.setCenterY(c.getCenterY()+(delta/3.5f));
		}
		ground.setCenterX(container.getInput().getMouseX());

		for(int i = balls.size()-1; i >= 0; i--){
			Circle c = balls.get(i);
			if (c.getCenterY() > 610){
				FallingSnow.menu.gameOver(score);
				lastExit = StateMenu.STATE_ID;
				game.enterState(StateMenu.STATE_ID);
			}else if(c.intersects(ground)){
				balls.remove(i);
				score++;
				SoundFX.snowCatch.play(1.0f, 0.5f);
			}
		}
		if(container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			lastExit = StatePause.STATE_ID;
			game.enterState(StatePause.STATE_ID);
		}
	}

	@Override
	public int getID() {
		return STATE_ID;
	}
}
