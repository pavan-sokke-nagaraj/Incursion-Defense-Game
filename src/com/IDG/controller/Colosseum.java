/**
 * 
 */
package com.IDG.controller;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * This is the Colosseum program that will instantiate a process of our
 * application
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build 1
 * @since Build 1
 *
 */
public class Colosseum extends JFrame {

	/**
	 * The constructor that will set the basic properties of Colosseum instance
	 * and the JFrame properties
	 */
	public Colosseum() {

		// Set JFrame basic features

		super(Game.GAME_NAME);

		// setExtendedState(Frame.MAXIMIZED_BOTH);
		// setVisible(true);
		setSize(Game.GAME_FRAME_WIDTH, Game.GAME_FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create an instance of layout to pin the menu bar,game editor and
		// simulator panels
		LayoutManager menu = new LayoutManager();
		setJMenuBar(menu.getMenuBar());
		add(menu.getTabs(), BorderLayout.CENTER);

		// Set JFrame visibility to true
		setVisible(true);
	}

	/**
	 * This is the main method which makes use of colosseum method.
	 * 
	 * @param args
	 *            Unused
	 */
	public static void main(String[] args) {
		// Create an instance of our game and set the layout
		// Colosseum colosseum = new Colosseum();
	}

}
