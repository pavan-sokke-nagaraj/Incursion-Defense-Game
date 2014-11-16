/**
 * 
 */
package com.IDG.mapSimulator;

import java.awt.Graphics;
import java.io.Serializable;

/**
 * Room Class is a clas which holds the map data and it's edited contents
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build1
 * @since Build1
 */
public class Room implements Serializable {

	/**
	 * a 2 dimensoinal array of Blocks to hold the map tiles
	 */
	public static Block[][] block;

	/**
	 * Static variable to hold number of rows in the map grid
	 */
	public static int mapRow;

	/**
	 * Static variable to hold number of columns in the map grid
	 */
	public static int mapColumn;

	/**
	 * variable to hold the size of each map tile
	 */
	public int blockSize = 40;

	/**
	 * Room class constructer to set the number of rows and columns to matrix
	 */
	public Room() {
		// create a matrix of rectangles with the number of rows & column read
		// from the saved map
		block = new Block[mapRow][mapColumn];
	}

	/**
	 * Room class constructer to set the number of rows and columns to matrix
	 * 
	 * @param x
	 *            number of tiles in x axis of map
	 * @param y
	 *            number of tiles in y axis of map
	 * @param gameValue
	 *            the game value which it holds
	 */
	public Room(int x, int y, char[][] gameValue) {
		mapColumn = x;
		mapRow = y;
		block = new Block[mapRow][mapColumn];
	}

	/**
	 * function to draw the map tiles
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 * @param gameValue
	 *            A 2 dimensional array which holds the values for path, start,
	 *            end and tiles
	 */
	public void drawGameArena(Graphics graphic, char[][] gameValue) {
		// set the starting position(x,y) to the center of the rectangle to be
		// drawn
		int xStart = 335 - ((mapColumn * blockSize) / 2);
		MapSimulatorView.mapXStart = xStart ;
		int yStart = 390 - ((mapRow * blockSize) / 2);
		MapSimulatorView.mapYStart = yStart ;
		// Draw each tile 
		for (int i = 0; i < mapColumn; i++) {
			for (int j = 0; j < mapRow; j++) {
				block[j][i] = new Block((xStart + (i * blockSize)),
						(yStart + (j * blockSize)), (blockSize), (blockSize),
						gameValue[j][i]);
				block[j][i].draw(graphic);
				if (block[j][i].contains(MapSimulatorView.mse)
						&& gameValue[j][i] == '*') {
					block[j][i].drawBlockRect(graphic);
				}
//				if(MapSimulatorView.moveEnemy &&  gameValue[j][i] == '-'){
//					Enemy enemy = new Enemy();
//					enemy.x = block[j][i].x;
//					enemy.y = block[j][i].y;
//					enemy.width = block[j][i].width;
//					enemy.height = block[j][i].height;
//					enemy.draw(graphic);
//				}
			}
		}
	}

}
