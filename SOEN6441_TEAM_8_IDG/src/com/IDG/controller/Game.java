package com.IDG.controller;

import javax.swing.JComponent;

/**
 * The Game is the class which holds the variables used in the application
 * 
 * @author p_sokke
 * @version Build 1
 * @since Build 1
 *
 */
public class Game extends JComponent {

	/**
	 * creates a SingleObject embedded as a static member of the Game class
	 * 
	 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
	 * @version Build 2
	 * @since Build 2
	 * 
	 * 
	 */
	private static Game instance = null;

	/**
	 * Make the constructor private so that Game class cannot be instantiated
	 * 
	 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
	 * @version Build 2
	 * @since Build 2
	 */
	private Game() {
	}

	/**
	 * 
	 * If the Game instance was not previously created, create the instance
	 * 
	 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
	 * @version Build 2
	 * @since Build 2
	 * @return return the created/existing Game instance
	 */
	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}

	/**
	 * set the game name
	 */
	public final static String GAME_NAME = "INCURSION DEFENSE GAME";

	/**
	 * set Game's Frame Width
	 */
	public final static int GAME_FRAME_WIDTH = 1250;

	/**
	 * set Game's Frame Height
	 */
	public final static int GAME_FRAME_HEIGHT = 900;

	/**
	 * set two enum types to editor and simulator
	 * 
	 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
	 * @version Build 1
	 * @since Build 1
	 */
	public enum GameMode {
		Editor, Simulator
	};

	/**
	 * Holds the current mode of the tab
	 */
	public static GameMode Mode = GameMode.Simulator;

	/**
	 * Variable to hold the game power
	 */
	public final static int INITIAL_GAME_POWER = 200;

	/**
	 * Variable to hold the game health
	 */
	public final static int INITIAL_GAME_HEALTH = 1000;

	private boolean isGamePaused = false;

	private String playingMapName;

	public String getPlayingMapName() {
		return playingMapName;
	}

	public void setPlayingMapName(String playingMapName) {
		this.playingMapName = playingMapName;
	}

	public boolean isGamePaused() {
		return isGamePaused;
	}

	public void setGamePaused(boolean isGamePaused) {
		this.isGamePaused = isGamePaused;
	}

}
