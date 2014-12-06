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

		super(Game.getInstance().GAME_NAME);
		setSize(Game.getInstance().GAME_FRAME_WIDTH, Game.getInstance().GAME_FRAME_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
	}

}
