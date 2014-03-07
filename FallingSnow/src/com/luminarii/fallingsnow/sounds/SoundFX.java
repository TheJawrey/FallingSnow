package com.luminarii.fallingsnow.sounds;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class SoundFX {
	
	public static String CLASSPATH = "com/luminarii/fallingsnow/sounds/";
	
	public static Music songYay;
	public static Sound snowCatch;
	public static Sound gameOver;

	public static void init() throws SlickException{
		songYay = new Music(CLASSPATH+"YSfill.ogg",true);
		snowCatch = new Sound(CLASSPATH+"snowCatch.ogg");
		gameOver = new Sound(CLASSPATH+"gameOver.ogg");
	}

		
}
