/**
 * 
 */
package com.IDG.controller;

import java.awt.Graphics;
import java.io.Serializable;

/**
 * @author p@!
 *
 */
public class Room implements Serializable {

	public Block[][] block;

	public static int mapWidth;// = 10;
	public static int mapHeight;// = 8;
	public int blockSize = 40;


	public Room() {
		define();
	}

	public Room(int x, int y) {
		mapWidth = x;
		mapHeight = y;
		block = new Block[mapHeight][mapWidth];
		for (int i = 0; y < block.length; y++) {
			for (int j = 0; x < block[0].length; x++) {
				block[i][j].createId = 1;
			}
		}
	}

	private void define() {
		// create a matrix of rectangles with no of rows & cols given by user
		block = new Block[mapHeight][mapWidth];

		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {
			}
		}
	}

	public static void setDimensions(int x, int y) {
		mapWidth = x;
		mapHeight = y;
	}

	public void drawArena(Graphics graphic) {

		int xStart = 100;
		int yStart = 100;
		int size = 40;

		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				block[j][i] = new Block((xStart + (i * size)),
						(yStart + (j * size)), (blockSize), (blockSize), 0, 0);
				block[j][i].draw(graphic);
			}
		}
		
		
	}

}
