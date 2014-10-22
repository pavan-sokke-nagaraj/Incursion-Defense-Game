package com.IDG.controller;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class World extends JComponent {
	
	private static World INSTANCE = null;

	public enum WorldMode {
		Editor, Simulator
	};

	/**
	 * Holds the current mode
	 */
	public static WorldMode Mode = WorldMode.Editor;
	
	/**
	 * The control panel for controlling actions
	 */
	public ControlPanel controlPanel = new ControlPanel();
	
	public Room room = new Room();
	
	public static World getInstance() {
		synchronized(World.class) {
			if (INSTANCE == null) {
				INSTANCE = new World();
			}
		}
		return INSTANCE;
	}
	
	public void paintComponent(Graphics graphic) {
		System.out.println("I am here!!!!!!!!!!");
		graphic.setColor(Color.BLUE);
		graphic.fillRect(0, 0, getWidth(), getHeight());
		graphic.setColor(Color.darkGray);
//		for (Block[] n : Room.getBlock()) {
//			
//		}
//		room.drawArena(graphic);
		
	}

}
