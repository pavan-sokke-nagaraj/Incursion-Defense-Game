package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class TowerInfoView implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		Tower tower = (Tower) arg0;
		Graphics graphic = (Graphics) arg1;
		drawMarketInformation(tower, graphic);
	}

	public void drawMarketInformation(Tower tower, Graphics graphic) {
		drawTowerInformation(tower, graphic);

		graphic.setColor(Color.GREEN);
		graphic.fillRect(tower.box2Xpos + 45, tower.box2Ypos + 150, 160, 30);
		graphic.setColor(Color.magenta);
		graphic.drawString("UPGRADE @ $" + tower.costToUpgrade,
				tower.box2Xpos + 50, tower.box2Ypos + 170);
		graphic.setColor(Color.RED);
		graphic.fillRect(tower.box2Xpos + 45, tower.box2Ypos + 125, 160, 20);
		graphic.setColor(Color.WHITE);
		graphic.drawString(" SELL @ $" + tower.costToSell, tower.box2Xpos + 50,
				tower.box2Ypos + 140);

	}

	public void drawTowerInformation(Tower tower, Graphics graphic) {

		graphic.clearRect(tower.box2Xpos, tower.box2Ypos, 250, 200);
		graphic.setColor(Color.WHITE);
		graphic.fillRect(tower.box2Xpos, tower.box2Ypos, 250, 200);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.setColor(new Color(255, 155, 0));
		graphic.drawString("TOWER INFORMATION", tower.box2Xpos,
				tower.box2Ypos + 20);

		// graphic.fillRect(noteX, noteY, 250, 200);
		if (tower.towerId != 'D') {
			graphic.setFont(new Font("Courier New", Font.BOLD, 15));
			graphic.setColor(Color.BLACK);
			graphic.drawString("INITIAL COST: $" + tower.costToBuy,
					tower.box2Xpos, tower.box2Ypos + 40);
			graphic.drawString("LEVEL: " + tower.level, tower.box2Xpos,
					tower.box2Ypos + 55);
			graphic.drawString("RANGE: " + tower.range + " Block Radius",
					tower.box2Xpos, tower.box2Ypos + 70);
			graphic.drawString("POWER: " + tower.damage + '%', tower.box2Xpos,
					tower.box2Ypos + 85);
			String attackType = "";
			if (tower.towerAttackType == 1) {
				attackType = "Splashing";
			} else if (tower.towerAttackType == 2) {
				attackType = "Burning";
			} else if (tower.towerAttackType == 3) {
				attackType = "Freezing";
			}
			graphic.drawString("ATTACK TYPE: " + attackType, tower.box2Xpos,
					tower.box2Ypos + 100);
			graphic.drawString("ATTACK RATE: " + tower.maxAttackDelay
					+ "ms Delay", tower.box2Xpos, tower.box2Ypos + 115);
		}

	}

}
