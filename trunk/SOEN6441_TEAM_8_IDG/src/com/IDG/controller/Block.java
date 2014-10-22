package com.IDG.controller;

/**
 * @author p@!
 *
 */
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

public class Block extends Rectangle {

	private static List<Block> blocks = new ArrayList<Block>();

	private Point nodeCoordinates;

	// used during creation of the map ONLY!!!!
	// holds if the id is a block or the path
	// value block = 0
	// value path = 1
	public int createId; // id to sest the value of block/path to save/load/edit
							// the map

	public int groundId; // id to set the tower/block value during the game
	public int airId; // id to set the movement of the creatures during the game

	// Sets the bounding Rectangle of this Rectangle to match the specified
	// Rectangle.
	public Block(int x, int y, int width, int height, int createId, int airId) {
		setBounds(x, y, width, height);
		this.createId = createId;
		this.groundId = createId;
		this.airId = airId;
	}

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
