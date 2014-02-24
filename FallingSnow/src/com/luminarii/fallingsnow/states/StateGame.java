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
import org.newdawn.slick.state.transition.*;

import com.luminarii.fallingsnow.FallingSnow;
public class StateGame extends BasicGameState{

	private Rectangle ground;
	private ArrayList<Circle> balls;
	private int timePassed;
	private Random random;
	int lives;
	int score;
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		balls.clear();
		ground.setCenterX(400);
		timePassed=0;
		lives = 3;
		score = 0;
		container.setMouseGrabbed(true);
	}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		balls = new ArrayList<Circle>();
		ground = new Rectangle((container.getWidth()/2)-75, 570, 150, 15);
		timePassed = 0;
		random = new Random();
		lives = 3;
		score = 0;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.fill(ground);
		g.drawString("lives:"+lives, 700, 40);
		g.setColor(Color.white);
		for(Circle c : balls){
			g.fill(c);
		}
		g.drawString("Score:" + score, 700, 60);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_1)){
			game.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
		timePassed += delta;
		if(timePassed >400){
			timePassed = 0;
			balls.add(new Circle(100+random.nextInt(500), 0, 10));
		}
		for(Circle c : balls){
			c.setCenterY(c.getCenterY()+(delta/4f));
		}
		ground.setCenterX(container.getInput().getMouseX());

		for(int i = balls.size()-1; i >= 0; i--){
			Circle c = balls.get(i);
			if (c.getCenterY() > 610){
				balls.remove(i);
				lives -= 1;
			}else if(c.intersects(ground)){
				balls.remove(i);
				score++;
			}
		}
		if(lives <= 0){
			FallingSnow.gameOver.passScore(score);
			game.enterState(3);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
}
