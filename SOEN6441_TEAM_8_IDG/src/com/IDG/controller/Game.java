package com.IDG.controller;

import javax.swing.JComponent;

/**
 * The Game is the class which holds the variables used in the
 * application
 * 
 * @author p_sokke
 * @version Build 1
 * @since Build 1
 *
 */
public class Game extends JComponent {

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

}
