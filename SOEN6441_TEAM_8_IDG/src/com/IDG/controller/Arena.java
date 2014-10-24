\/**
 * 
 */
package com.IDG.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * @author p_sokke
 *
 */
public class Arena extends JPanel {

	public Arena() {
		setBackground(Color.YELLOW);
		System.out.println("A" + this.gridRow);
		System.out.println("A" + gridColumn);
//		thread.start();
//		 repaint();
	}

	private int gridRow;
	private int gridColumn;
	private boolean isMapCreated = false;
//	private Thread thread = new Thread(this);
	private BattleField createBattleField;
	private GameFileManager gameFileManager;
	// Image array to import and set it to rectangles
	private Image[] tileset_grass = new Image[100];
	// Image array to import and set it to rectangles
	private Image[] tileset_attack = new Image[100];

	public int getGridRow() {
		return gridRow;
	}

	public void setGridRow(int gridRow) {
		this.gridRow = gridRow;
	}

	public int getGridColumn() {
		return gridColumn;
	}

	public void setGridColumn(int gridColumn) {
		this.gridColumn = gridColumn;
	}

	public boolean isMapCreated() {
		return isMapCreated;
	}

	public BattleField getCreateBattleField() {
		return createBattleField;
	}

	public void setCreateBattleField(BattleField createBattleField) {
		this.createBattleField = createBattleField;
	}

	public GameFileManager getGameFileManager() {
		return gameFileManager;
	}

	public void setGameFileManager(GameFileManager gameFileManager) {
		this.gameFileManager = gameFileManager;
	}

	public void setMapCreated(boolean isMapCreated) {
		this.isMapCreated = isMapCreated;
	}

//	public Thread getThread() {
//		return thread;
//	}
//
//	public void setThread(Thread thread) {
//		this.thread = thread;
//	}

	public Image[] getTileset_grass() {
		return tileset_grass;
	}

	public void setTileset_grass(Image[] tileset_grass) {
		this.tileset_grass = tileset_grass;
	}

	public Image[] getTileset_attack() {
		return tileset_attack;
	}

	public void setTileset_attack(Image[] tileset_attack) {
		this.tileset_attack = tileset_attack;
	}

	public void paintComponent(Graphics graphics) {
		 System.out.println("paintComponent x:\t"+this.gridRow);
		 System.out.println("paintComponent y:\t"+gridColumn);
//		 setOpaque(true);
//		 setBackground(Color.RED);
//		 graphics.fillOval(50, 50, 50, 50);
//		 removeAll();
		 super.paintComponent(graphics);
		 int xOff = 30;
		 int yOff = 30;
			
		graphics.clearRect(0, 0, getWidth(), getHeight());
		for (int row = 0; row < gridRow; row++) {
			for (int col = 0; col < gridColumn; col++) {
//				Rectangle cell = new Rectangle(xOffset + (col * cellWidth),
//						yOffset + (row * cellHeight), cellWidth, cellHeight);
				graphics.drawRect(row*30, col*30, 30, 30);
			}
		}
		 
		/*if (isMapCreated) {
			defineGame();
		}
		setMapCreated(true)*/;
//		graphics.clearRect(0, 0, getWidth(), getHeight());
		// Draw game arena to specify path and validate the same... :])
//		createBattleField.drawArena(graphics);
//		repaint();
	}

	private void defineGame() {
		
//		setBackground(Color.RED);
//		setVisible(true);
		System.out.println("define the grid game here");
		/*createBattleField = new BattleField();
		gameFileManager = new GameFileManager();
		for (int i = 0; i < tileset_grass.length; i++) {
			tileset_grass[i] = new ImageIcon("res/grass.jpg").getImage();
			tileset_grass[i] = createImage(new FilteredImageSource(
					tileset_grass[i].getSource(), new CropImageFilter(0,
							256 * i, 256, 256)));
		}
		
		 * tileset_air/defense/tower initalization and decleration
		 
		for (int i = 0; i < tileset_attack.length; i++) {
			tileset_attack[i] = new ImageIcon("res/road.jpg").getImage();
			tileset_attack[i] = createImage(new FilteredImageSource(
					tileset_attack[i].getSource(), new CropImageFilter(0,
							64 * i, 64, 64)));
		}

		// Code to load a saved game details.......--:> the tile details to
		// textfile.pa1
		gameFileManager.loadSavedGame("game1.pa1");*/
	}

	/*@Override
	public void run() {
		while (true) {
			if (!isMapCreated) {
				createBattleField = new BattleField();
				createBattleField.createField();
				defineGame();
			}
			repaint();
			try {
				thread.sleep(1);
			} catch (Exception exp) {
				exp.printStackTrace();
			} finally {
			}
		}

	}*/

}
