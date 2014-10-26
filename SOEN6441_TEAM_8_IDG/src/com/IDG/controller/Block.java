package com.IDG.controller;


import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * the class Blocks saves the maps created by the users, if the user specifies a tile as a block it saves a value of 0 in that block
 * and a value of 1 if the users specifies a value as a path.
 * the values of the tiles are saved in an arrayList that helps when the user want to save or load a map the values of the tiles determins 
 * the map display 
 * @author p@!
 * @author reem
 *
 */
public class Block extends Rectangle {

	private static List<Block> blocks = new ArrayList<Block>(); //arrayList saving the values of the tiles in the created map

	private Point nodeCoordinates; // the position of the tiles

	// used during creation of the map ONLY!!!!
	// holds if the id is a block or the path
	// value block = 0
	// value path = 1
	public int createId; // id to sets the value of block/path to save/load/edit the map

	public int groundId; // id to set the tower/block value during the game
	
	public int airId; // id to set the movement of the creatures during the game
/**
 * Sets the bounding Rectangle of this Rectangle to match the specified
 * Rectangle
 * @param x - the new X coordinate for the upper-left corner of this Rectangle
 * @param y the new Y coordinate for the upper-left corner of this Rectangle
 * @param width the new width for this Rectangle
 * @param height  the new height for this Rectangle
 * @param createId  id to sets the value of block/path to save/load/edit the map
 * @param airId  id to set the movement of the critter during the game
 *
 */

	public Block(int x, int y, int width, int height, int createId, int airId) {
		setBounds(x, y, width, height);
		this.createId = createId;
		this.groundId = createId;
		this.airId = airId;
	}
/**
 *@param Graphics : Sets this graphics context's current color to the specified color.
 * All subsequent graphics operations using this graphics context use this specified color.
 * Draws the outline of the specified rectangle. The left and right edges of the rectangle are at x and x + width.
 *The top and bottom edges are at y and y + height. The rectangle is drawn using the graphics context's current color.
 */
	// draw tower spreadsheet
	// draw ground spreadsheet
	public void draw(Graphics gp) {
		gp.setColor(Color.RED);
		gp.drawRect(x, y, width, height);

		if (createId == 1) {
			// gp.drawImage(PanelPractice.tileset_attack[createId], x, y, width,
			// height, null);
		}
	}

}
