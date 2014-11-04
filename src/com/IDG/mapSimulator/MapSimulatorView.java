/**
 * 
 */
package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.IDG.controller.Game;

/**
 * 
 * This class is the view for the Game Simulation GUI
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build 1
 * @since Build 1
 *
 */
public class MapSimulatorView extends JPanel implements Runnable {

	/**
	 * A simple thread intialized to repaint
	 */
	public Thread paintThread = new Thread(this);

	/**
	 * Static variable to hold number of rows in the map grid
	 */
	public static int gridRow;
	/**
	 * Static variable to hold number of columns in the map grid
	 */
	public static int gridColumn;

	/**
	 * variable to hold the game's power.The value is set from
	 * {@code Game.INITIAL_GAME_POWER}
	 */
	public static int power = Game.INITIAL_GAME_POWER;

	/**
	 * variable to hold the game's health.The value is set from
	 * {@code Game.INITIAL_GAME_HEALTH}
	 */
	public static int health = Game.INITIAL_GAME_HEALTH;

	/**
	 * variable to hold the each grids game value
	 */
	public static char[][] gameValue;

	/**
	 * class Room initialized to hold the grid
	 */
	public static Room room = new Room();

	/**
	 * A point representing a location in (x,y) JPanel MapSimulatorView space.
	 * Default value set to {@code Point(0, 0); }
	 */
	public static Point mse = new Point(0, 0);

	/**
	 * class Arsenal initialization which holds the towers
	 */
	public static Arsenal arsenal;

	/**
	 * Constructs a new object of our map simulator and start the paintThread
	 */
	public MapSimulatorView() {
		super();
		paintThread.start();
	}

	/**
	 * run's the painThread, initialize the arsenal class and repaint
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		addMouseListener(new KeyHandel());
		addMouseMotionListener(new KeyHandel());
		arsenal = new Arsenal();
		while (true) {
			repaint();
		}

	}

	/**
	 * paint the game simulator GUI components
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics graphic) {

		// draws a white background
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, getWidth(), getHeight());
//		System.out.println(getWidth() + "\t\t" + getHeight());

		// draws a black box to enter text
		graphic.setColor(Color.BLACK);
		graphic.drawRect(20, 0, 1200, 30);

		// draw a yellow background for game grid
		graphic.setColor(Color.ORANGE);
		graphic.fillRect(20, 35, 650, 750);

		graphic.setColor(Color.LIGHT_GRAY);
		graphic.fillRect(700, 35, 500, 250);

		// game Tower board
		graphic.setColor(Color.GRAY);
		graphic.fillRect(700, 300, 500, 250);

		// game life board
		graphic.setColor(Color.DARK_GRAY);
		graphic.fillRect(700, 565, 500, 220);

		if (gridRow != 0 || gridColumn != 0) {
			room = new Room(gridColumn, gridRow, gameValue);
			room.drawGameArena(graphic, gameValue);
			arsenal.draw(graphic);

		}

	}

}
