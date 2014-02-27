package com.luminarii.fallingsnow.graphix;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Graphix {
	
	public static String CLASSPATH = "com/luminarii/fallingsnow/graphix/";
	
	public static Image snowflake;
	public static Image backdrop;
	
	public static void init() throws SlickException{
		snowflake = new Image(CLASSPATH+"snowflake.png").getScaledCopy(.25f);
		backdrop = new Image(CLASSPATH+"backdrop.png");
	}
}
