/**
 * 
 */
package com.IDG.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build1
 * @since Build1
 *
 */
public class Tower implements Serializable {

	/**
	 * variable to hold the tower id
	 */
	public char towerId;
	/**
	 * variable to hold the cost of tower to buy
	 */
	public int costToBuy;
	/**
	 * holds the tower level
	 */
	public int level;
	/**
	 * holds the tower range
	 */
	public int range;
	/**
	 * holds the tower power
	 */
	public int power;
	/**
	 * hold the tower attacking type (single or multiple)
	 */
	public String attackType;
	/**
	 * variable to hold the cost of tower to sell
	 */
	public int costToSell;
	/**
	 * variable to hold the cost of tower to upgrade
	 */
	public int costToUpgrade;

	/**
	 * variable to hold the starting x position to draw tower information
	 */
	int box2Xpos = 750;
	/**
	 * variable to hold the starting y position to draw tower information
	 */
	int box2Ypos = 320;

	/**
	 * class tower constructor to set the default values
	 */
	public Tower() {

		this.towerId = 'D';
		this.costToBuy = 0;
		this.level = 0;
		this.range = 0;
		this.power = 0;
		this.attackType = "";
		this.costToSell = 0;
		this.costToUpgrade = 0;

	}

	/**
	 * @param towerId
	 *            tower id
	 * @param costToBuy
	 *            cost of tower to buy
	 * @param level
	 *            tower level
	 * @param range
	 *            tower range
	 * @param power
	 *            holds the tower power
	 * @param attackType
	 *            tower's attacking type (single or multiple)
	 * @param costToSell
	 *            cost of tower to sell
	 * @param costToUpgrade
	 *            cost of tower to upgrade
	 */
	public Tower(char towerId, int costToBuy, int level, int range, int power,
			String attackType, int costToSell, int costToUpgrade) {
		this.towerId = towerId;
		this.costToBuy = costToBuy;
		this.level = level;
		this.range = range;
		this.power = power;
		this.attackType = attackType;
		this.costToSell = costToSell;
		this.costToUpgrade = costToUpgrade;
	}

	/**
	 * draw's the tower information to the main screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void drawTowerInformation(Graphics graphic) {

		graphic.clearRect(box2Xpos, box2Ypos, 250, 200);
		graphic.setColor(Color.WHITE);
		graphic.fillRect(box2Xpos, box2Ypos, 250, 200);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.setColor(new Color(255, 155, 0));
		graphic.drawString("TOWER INFORMATION", box2Xpos, box2Ypos + 20);

		// graphic.fillRect(noteX, noteY, 250, 200);
		if (towerId != 'D') {
			graphic.setFont(new Font("Courier New", Font.BOLD, 20));
			graphic.setColor(Color.GREEN);
			graphic.drawString("INITIAL COST: $" + costToBuy, box2Xpos,
					box2Ypos + 40);
			graphic.drawString("LEVEL: " + level, box2Xpos, box2Ypos + 60);
			graphic.drawString("RANGE: " + range + " Block Radius", box2Xpos,
					box2Ypos + 80);
			graphic.drawString("POWER: " + power + '%', box2Xpos,
					box2Ypos + 100);
			graphic.drawString("ATTACK TYPE: " + attackType, box2Xpos,
					box2Ypos + 120);

		}

	}

	/**
	 * Draw's the market place information to the screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void drawMarketInformation(Graphics graphic) {
		drawTowerInformation(graphic);

		graphic.setColor(Color.GREEN);
		graphic.fillRect(box2Xpos + 45, box2Ypos + 150, 160, 30);
		graphic.setColor(Color.magenta);
		graphic.drawString("UPGRADE @ $" + costToUpgrade, box2Xpos + 50,
				box2Ypos + 170);
		graphic.setColor(Color.RED);
		graphic.fillRect(box2Xpos + 45, box2Ypos + 125, 160, 20);
		graphic.setColor(Color.WHITE);
		graphic.drawString(" SELL @ $" + costToSell, box2Xpos + 50,
				box2Ypos + 140);

	}

	/**
	 * clear the tower information window
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void clearInformation(Graphics graphic) {
		graphic.clearRect(box2Xpos, box2Ypos, 250, 200);
	}

}
