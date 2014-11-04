package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * class Block extends Rectangle, holds the coordinates of each tile in the
 * block and other details
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @author Reem
 * @version Build1
 * @since Build1
 */
public class Block extends Rectangle {

	/**
	 * Holds the tile type, if createId is *, then tile is a ground. if createId
	 * is S, then tile is a start point. if createId is E, then tile is a end
	 * point. if createId is -, then tile is a path.
	 */
	public static char createId;

	/**
	 * Constructor for Block class
	 */
	public Block() {
	}

	/**
	 * Sets the bounding Rectangle of this Rectangle to match the specified
	 * Rectangle.
	 * 
	 * @param x
	 *            starting x position of rectangle block
	 * @param y
	 *            starting y position of rectangle block
	 * @param width
	 *            width of the rectangle block
	 * @param height
	 *            height of the rectangle block
	 * @param createId
	 *            type of the tile(ground or start or path or end or tower )
	 */
	public Block(int x, int y, int width, int height, char createId) {
		setBounds(x, y, width, height);
		this.createId = createId;

	}

	/**
	 * function to draw the tiles
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void draw(Graphics graphic) {
		graphic.setColor(Color.BLACK);
		Image image = new ImageIcon("ImageSource/Ground.png").getImage();
		graphic.drawImage(image, x, y, width, height, null);
		if (createId == 'S') {
			graphic.setColor(Color.WHITE);
			graphic.fillRect(x, y, width, height);
			image = new ImageIcon("ImageSource/skull.JPG").getImage();
			graphic.drawImage(image, x, y, width, height, null);
		} else if (createId == '-') {
			graphic.setColor(Color.GREEN);
			graphic.fillRect(x, y, width, height);
			image = new ImageIcon("ImageSource/GRASS1.JPG").getImage();
			graphic.drawImage(image, x, y, width, height, null);
		} else if (createId == 'E') {
			graphic.setColor(Color.RED);
			graphic.fillRect(x, y, width, height);
			image = new ImageIcon("ImageSource/Castle.JPG").getImage();
			graphic.drawImage(image, x, y, width, height, null);
		} else if (createId == 'G') {
			graphic.setColor(Color.RED);
			graphic.fillRect(x, y, width, height);
			image = new ImageIcon("ImageSource/Tower.png").getImage();
			graphic.drawImage(image, x, y, width, height, null);
		} else if (createId == 'R') {
			image = new ImageIcon("ImageSource/Tower2.png").getImage();
			graphic.drawImage(image, x, y, width, height, null);
		}else if (createId == 'B') {
			image = new ImageIcon("ImageSource/Tower3.png").getImage();
			graphic.drawImage(image, x, y, width, height, null);
		}

	}

	/**
	 * function to draw a transperent rectangle over the tiles
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void drawBlockRect(Graphics graphic) {
		graphic.setColor(new Color(255, 255, 255, 150));
		graphic.fillRect(x, y, width, height);
	}

}
