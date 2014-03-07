package com.luminarii.fallingsnow.graphix;

import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Graphix {
	
	public static String CLASSPATH = "com/luminarii/fallingsnow/graphix/";
	
	public static Image snowflake;
	public static Image backdropGame;
	public static Image backdropPause;
	public static Image backdropMenu;
	public static Font font;
	
	public static void init() throws SlickException{
		snowflake = new Image(CLASSPATH+"snowflake.png").getScaledCopy(.25f);
		backdropGame = new Image(CLASSPATH+"backdropGame.png");
		backdropPause = new Image(CLASSPATH+"backdropPause.png");
		backdropMenu = new Image(CLASSPATH+"backdropMenu.png");
		font = new TrueTypeFont(new java.awt.Font("Verdana", 1, 27), false);
	}
}
