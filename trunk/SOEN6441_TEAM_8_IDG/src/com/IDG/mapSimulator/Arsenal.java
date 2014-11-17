package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.IDG.controller.GameFileManager;
import com.IDG.playGame.EnemyPath;


/**
 * class arsenal holds the information of tower, upgrade and sell tower
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build1
 * @since Build1
 *
 */
public class Arsenal {

	/**
	 * variable to hold the number of tower
	 */
	public static int towerNumber = 4;
	/**
	 * variable to hold the tower width
	 */
	public static int towerWidth = 40;
	/**
	 * variable to hold the gap between each towers
	 */
	public static int gap = 20;
	/**
	 * variable to hold the starting x position of tower placing point
	 */
	public static int box1Xpos = 710;
	/**
	 * variable to hold the starting y position of tower placing point
	 */
	public static int box1Ypos = 90;

	/**
	 * variable to hold the starting x position to draw tower information
	 */
	// public int box2Xpos = 750;
	public int box2Xpos = 710;
	/**
	 * variable to hold the starting y position to draw tower information
	 */
	public int box2Ypos = 320;

	/**
	 * array of tower class to hold towers
	 */
	public static Tower[] towerBlocks = new Tower[towerNumber];
	/**
	 * array of rectangles to hold the dimensions of towers
	 */
	public Rectangle[] towers = new Rectangle[towerNumber];

	/**
	 * Rectangle to hold the dimensions of health button
	 */
	public Rectangle health;
	/**
	 * Rectangle to hold the dimensions of money button
	 */
	public Rectangle money;
	/**
	 * Rectangle to hold the dimensions of upgrade button
	 */
	public Rectangle upgradeButton;
	/**
	 * Rectangle to hold the dimensions of sell button
	 */
	public Rectangle sellButton;

	/**
	 * tower create value
	 */
	public static char heldValue = 'G';

	/**
	 * selected tower position
	 */
	public static int heldPosition = -1;
	/**
	 * selected tower x position
	 */
	public static int mapTowerXpos;
	/**
	 * selected tower y position
	 */
	public static int mapTowerYpos;

	/**
	 * flag to check if the tower is selected from tower market place
	 */
	public static boolean holdsTower = false;
	/**
	 * flag to check if the tower is selected from map
	 */
	public static boolean selectMapTower = false;
	/**
	 * flag to check if the tower information window to be cleared or not
	 */
	public static boolean clearInfo = false;
	/**
	 * flag to check if the upgrade button selected or not
	 */
	public static boolean upgradeConfirm = false;
	/**
	 * flag to check if the sell button is selected or not
	 */
	public static boolean sellConfirm = false;

	public Rectangle waveButton;
	public Rectangle gameReset;
	public Rectangle exitgame;

	public Rectangle weakTargetStratergy;
	public Rectangle strongTargetStratergy;
	public Rectangle nearTargetStratergy;
	public Rectangle randomTargetStratergy;
	public boolean isStrtergySelect = false;
	public int selectedStratergy;

	/**
	 * class constructor to initialize tower data, health data, money data
	 * Upgrade: Build 2-> serialize he objects and retrieve data from xml files
	 */
	public Arsenal() {

		for (int i = 0; i < towerNumber; i++) {

			towers[i] = new Rectangle(box1Xpos + (gap * i) + (towerWidth * i),
					box1Ypos, towerWidth, towerWidth);
			if (i == 0) {
				towerBlocks[i] = new Tower('G', 50, 1, 1,25,25, 2,20, 60, 2);// freezing//attack delay=50//Random
			} else if (i == 1) {
				towerBlocks[i] = new Tower('R', 150, 1, 2, 100, 100,3, 25, 40, 1);// Splashing//attack delay=70//Min Health
			} else if (i == 2) {
				towerBlocks[i] = new Tower('B', 350, 1, 3, 200,200, 4, 35, 20, 2);// Burning//attack Delay = Max Health
			} else if (i == 3) {
				towerBlocks[i] = new Tower('D', 0, 0, 0, 0, 0, 1, 10, 2,2);
			}
		}

		health = new Rectangle(box1Xpos, box1Ypos + towerWidth, towerWidth,
				towerWidth);
		money = new Rectangle(box1Xpos + 100, box1Ypos + towerWidth,
				towerWidth, towerWidth);
		upgradeButton = new Rectangle(box2Xpos + 45, box2Ypos + 145, 160, 40);
		sellButton = new Rectangle(box2Xpos + 45, box2Ypos + 125, 160, 20);
		waveButton = new Rectangle(box2Xpos + 0, 565 + 125 - 100, 160, 60);
		gameReset= new Rectangle(box2Xpos + 165, 565 + 125 - 100, 160, 60);
		exitgame=new Rectangle  (box2Xpos + 330, 565 + 125 - 100 ,150, 60);

		// box2Xpos+280, box2Ypos, 200, 200
		weakTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 30, 160,
				30);
		strongTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 70,
				160, 30);
		nearTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 110,
				160, 30);
		randomTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 150, 160,
				30);
	}

	/**
	 * function to draw GUI to screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void draw(Graphics graphic) {

		// Draw towers
		graphic.setColor(Color.GREEN);
		graphic.setFont(new Font("Courier New", Font.BOLD, 30));
		graphic.drawString("SELECT TOWERS", box1Xpos - 5, box1Ypos - 15);

		Image image = null;
		for (int i = 0; i < towerNumber; i++) {
			graphic.fillRect(box1Xpos + (gap * i) + (towerWidth * i), box1Ypos,
					towerWidth, towerWidth);
			if (towerBlocks[i].towerId == 'G')
				image = new ImageIcon("ImageSource/Tower.png").getImage();
			else if (towerBlocks[i].towerId == 'R')
				image = new ImageIcon("ImageSource/Tower2.png").getImage();
			else if (towerBlocks[i].towerId == 'B')
				image = new ImageIcon("ImageSource/Tower3.png").getImage();
			else if (towerBlocks[i].towerId == 'D')
				image = new ImageIcon("ImageSource/Trash.png").getImage();

			graphic.drawImage(image, box1Xpos + (gap * i) + (towerWidth * i),
					box1Ypos, towerWidth, towerWidth, null);

			if (towers[i].contains(MapSimulatorView.mse)) {
				graphic.setColor(new Color(255, 255, 255, 150));
				graphic.fillRect(box1Xpos + (gap * i) + (towerWidth * i),
						box1Ypos, towerWidth, towerWidth);
				towerBlocks[i].drawTowerInformation(graphic);
				selectMapTower = false;
				clearInfo = false;
			}
		}

		// Draw Healath
		graphic.setColor(Color.GREEN);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("\tHEALTH\t", box1Xpos, box1Ypos + towerWidth + 40);

		image = new ImageIcon("ImageSource/Health.png").getImage();
		graphic.drawImage(image, box1Xpos + 10, box1Ypos + towerWidth + 45,
				towerWidth, towerWidth, null);
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("Courier New", Font.BOLD, 25));
		graphic.drawString("" + MapSimulatorView.health, box1Xpos + 10,
				box1Ypos + towerWidth + 110);

		// Draw Power
		graphic.setColor(Color.GREEN);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("\tPOWER\t", box1Xpos + 100, box1Ypos + towerWidth
				+ 40);
		image = new ImageIcon("ImageSource/Power.png").getImage();
		graphic.drawImage(image, box1Xpos + 110, box1Ypos + towerWidth + 45,
				towerWidth, towerWidth, null);

		// draw waveButton
		graphic.fillRect(waveButton.x, waveButton.y, waveButton.width,
				waveButton.height);
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("START WAVE", waveButton.x + 20, waveButton.y + 20);

		graphic.fillRect(gameReset.x, gameReset.y, gameReset.width,
				gameReset.height);
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("RESET GAME", gameReset.x + 20, gameReset.y + 20);

		graphic.fillRect(exitgame.x, exitgame.y, exitgame.width,
				exitgame.height);
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("EXIT GAME", exitgame.x + 20, exitgame.y + 20);
		drawMoney(graphic);

		drawMoney(graphic);

		if (holdsTower) {
			if (heldValue == 'G')
				image = new ImageIcon("ImageSource/Tower.png").getImage();
			else if (heldValue == 'R')
				image = new ImageIcon("ImageSource/Tower2.png").getImage();
			else if (heldValue == 'B')
				image = new ImageIcon("ImageSource/Tower3.png").getImage();
			else
				image = null;
			graphic.drawImage(image, MapSimulatorView.mse.x,
					MapSimulatorView.mse.y, towerWidth, towerWidth, null);
			towerBlocks[heldPosition].drawTowerInformation(graphic);
			drawTowerRange(graphic, MapSimulatorView.mse.x,
					MapSimulatorView.mse.y, towerBlocks[heldPosition].range);
		}
		if (selectMapTower) {
			Tower tower = GameFileManager.getTowerObject(mapTowerXpos,
					mapTowerYpos);
			TowerInfoView towerInfoView = new TowerInfoView();
			tower.addObserver(towerInfoView);
			tower.drawMarketInformation(graphic);
			int circleX = MapSimulatorView.room.block[mapTowerXpos][mapTowerYpos].x;
			int circleY = MapSimulatorView.room.block[mapTowerXpos][mapTowerYpos].y;
			drawTowerRange(graphic, circleX, circleY, tower.range);
			drawStratergyWindow(graphic);
		}
		if (upgradeConfirm) {
			drawUpgradeTowerInfo(graphic);
		}
		if (sellConfirm) {
			drawSellTowerInfo(graphic);
		}
		if (clearInfo) {
			graphic.setColor(Color.GRAY);
			graphic.fillRect(box2Xpos, box2Ypos, 250, 200);
		}
		if (isStrtergySelect) {
			applyStratergy(mapTowerXpos, mapTowerYpos);
		}

		// System.out.println("Moveenemey:\t" + MapSimulatorView.moveEnemy);
	}

	/**
	 * function to draw money information to screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */

	public static void resetGame ()
	{
		MapSimulatorView.level=0;
		MapSimulatorView.moveEnemy = false;
		MapSimulatorView.enemiesOnMap.clear();
		MapSimulatorView.health=1000;
		MapSimulatorView.power=200;
		for(int i=0;i<MapSimulatorView.gridRow;i++){
			for(int j = 0;j<MapSimulatorView.gridColumn;j++){
				char createId = MapSimulatorView.gameValue[j][i];
				if(createId == 'R' || createId == 'G' || createId == 'B'){
					MapSimulatorView.gameValue[j][i] = '*';
				}
			}

		}
		clearInfo = true ;
		selectMapTower = false ;
	}
	private void drawMoney(Graphics graphic) {
		graphic.setFont(new Font("Courier New", Font.BOLD, 25));
		graphic.setColor(new Color(255, 200, 0));
		graphic.drawString("" + MapSimulatorView.power, box1Xpos + 110,
				box1Ypos + towerWidth + 110);
	}

	/**
	 * function to draw the sold tower information
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	private void drawSellTowerInfo(Graphics graphic) {
		// System.out.println("While drawUpgradeTowerInfo" + mapTowerXpos +
		// "\t\t"
		// + mapTowerYpos);
		Tower tower = GameFileManager
				.getTowerObject(mapTowerXpos, mapTowerYpos);
		if (tower.costToSell > 0) {
			MapSimulatorView.power = MapSimulatorView.power + tower.costToSell;
			drawMoney(graphic);
			MapSimulatorView.gameValue[mapTowerXpos][mapTowerYpos] = '*';
			MapSimulatorView.room.block[mapTowerXpos][mapTowerYpos].createId = '*';
			MapSimulatorView.room.block[mapTowerXpos][mapTowerYpos]
					.draw(graphic);
			sellConfirm = false;
			upgradeConfirm = false;
			selectMapTower = false;
			mapTowerXpos = -1;
			mapTowerYpos = -1;
			tower.drawTowerInformation(graphic);
			GameFileManager
			.deleteTowerObject(tower, mapTowerXpos, mapTowerYpos);
		}
	}

	/**
	 * function to draw the upgraded tower information
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	private void drawUpgradeTowerInfo(Graphics graphic) {
		// System.out.println("While drawUpgradeTowerInfo" + mapTowerXpos +
		// "\t\t"
		// + mapTowerYpos);
		Tower tower = GameFileManager
				.getTowerObject(mapTowerXpos, mapTowerYpos);
		if (MapSimulatorView.power >= tower.costToUpgrade) {
			MapSimulatorView.power = MapSimulatorView.power
					- tower.costToUpgrade;
			drawMoney(graphic);
			++tower.level;
			++tower.range;
			tower.damage = tower.damage + 5;
			tower.costToUpgrade = tower.costToUpgrade + 10;
			tower.costToSell = tower.costToSell + 5;
			tower.maxAttackDelay=tower.maxAttackDelay-5;
			TowerInfoView towerInfoView = new TowerInfoView();
			tower.addObserver(towerInfoView);
			tower.drawMarketInformation(graphic);
			GameFileManager.saveTowerObject(tower, mapTowerXpos, mapTowerYpos);
			upgradeConfirm = false;
			sellConfirm = false;
		}
	}

	/**
	 * function to check the selection of towers and to update the information
	 * 
	 * @param mouseClick
	 *            number of mouse clicked
	 */
	public void towerClick(int mouseClick) {
		sellConfirm = false;
		if (mouseClick == 1) {
			// Code to select the clicked tower and it's information
			for (int i = 0; i < towerNumber; i++) {
				if (towers[i].contains(MapSimulatorView.mse)) {
					if (towerBlocks[i].towerId == 'D') {
						holdsTower = false;
					} else {
						heldPosition = i;
						heldValue = towerBlocks[i].towerId;
						holdsTower = true;
					}
				}
			}
			// Code to select and populate market place tower information to
			// groid tower information
			if (holdsTower) {
				if (MapSimulatorView.power >= towerBlocks[heldPosition].costToBuy) {
					for (int i = 0; i < MapSimulatorView.room.mapRow; i++) {
						for (int j = 0; j < MapSimulatorView.room.mapColumn; j++) {
							if (MapSimulatorView.room.block[i][j]
									.contains(MapSimulatorView.mse)) {
								char createId = MapSimulatorView.gameValue[i][j];
								if (createId == '*') {
									MapSimulatorView.gameValue[i][j] = heldValue;
									// MapSimulatorView.towers[i][j] =
									// towerBlocks[heldPosition];
									MapSimulatorView.room.block[i][j].createId = heldValue;
									GameFileManager.saveTowerObject(
											towerBlocks[heldPosition], i, j);
									MapSimulatorView.power = MapSimulatorView.power
											- towerBlocks[heldPosition].costToBuy;
									holdsTower = false;
								}
							}
						}
					}

				}
			} else if (upgradeButton.contains(MapSimulatorView.mse)) {
				upgradeConfirm = true;
				sellConfirm = false;
			} else if (sellButton.contains(MapSimulatorView.mse)) {
				sellConfirm = true;
				upgradeConfirm = false;
			} else if (nearTargetStratergy.contains(MapSimulatorView.mse)) {
				isStrtergySelect = true;
				selectedStratergy = Tower.ATTACK_FIRST_NEAR_TOWER_ENEMY;
			} else if (randomTargetStratergy.contains(MapSimulatorView.mse)) {
				isStrtergySelect = true;
				selectedStratergy = Tower.ATTACK_RANDOM_ENEMY;
			} else if (strongTargetStratergy.contains(MapSimulatorView.mse)) {
				isStrtergySelect = true;
				selectedStratergy = Tower.ATTACK_MAX_HEALTH_ENEMY;
			} else if (weakTargetStratergy.contains(MapSimulatorView.mse)) {
				isStrtergySelect = true;
				selectedStratergy = Tower.ATTACK_MIN_HEALTH_ENEMY;
			} else if (waveButton.contains(MapSimulatorView.mse)) {

				if (MapSimulatorView.level <= 10) {
					int actualHealth=0,currentHealth=0,value=0,enemyActualSpeed=0,enemyCurrentSpeed=0;
					int numberOFEnemies=0;
					MapSimulatorView.moveEnemy = true;
					MapSimulatorView.isGameLost=false;
					MapSimulatorView.isGameWon=false;
					MapSimulatorView.level++;
					if (MapSimulatorView.gridRow != 0
							|| MapSimulatorView.gridColumn != 0) {
						MapSimulatorView.enemyPath = EnemyPath.copyPath();
						if(1<=MapSimulatorView.level&&MapSimulatorView.level<=3){
							MapSimulatorView.enemyType="normalenemy";
							actualHealth=MapSimulatorView.level * 100;
							currentHealth=MapSimulatorView.level * 100;
							value=MapSimulatorView.level * 10;
							enemyActualSpeed=5;
							enemyCurrentSpeed=5;
							numberOFEnemies=3+(MapSimulatorView.level*2);
						}else if(3<MapSimulatorView.level&&MapSimulatorView.level<=6){
							MapSimulatorView.enemyType="normalenemy";
							actualHealth=MapSimulatorView.level * 150;
							currentHealth=MapSimulatorView.level * 150;
							value=MapSimulatorView.level * 20;
							enemyActualSpeed=8;
							enemyCurrentSpeed=8;
							numberOFEnemies=5+(MapSimulatorView.level*2);
						}else if(6<MapSimulatorView.level&&MapSimulatorView.level<=10){
							MapSimulatorView.enemyType="bossEnemy";
							actualHealth=MapSimulatorView.level * 200;
							currentHealth=MapSimulatorView.level * 200;
							value=MapSimulatorView.level * 50;
							enemyActualSpeed=10;
							enemyCurrentSpeed=10;
							numberOFEnemies=7+(MapSimulatorView.level*2);
						}
						for (int i = 0; i < numberOFEnemies; i++) {
							MapSimulatorView.enemiesOnMap
							.add(MapSimulatorView.enemyFactory
									.getEnemyfromFactory(
											MapSimulatorView.enemyType,
											i,
											MapSimulatorView.enemyPath,
											i * 20,
											actualHealth,
											currentHealth,
											value,
											enemyActualSpeed,
											enemyCurrentSpeed));
						}
					}
				} else {
					// TODO
				}
			}
			else if(gameReset.contains(MapSimulatorView.mse))

			{

				resetGame();
			}

			else if (exitgame.contains(MapSimulatorView.mse))
			{
				MapSimulatorView.level=0;
				MapSimulatorView.moveEnemy = false;
				MapSimulatorView.enemiesOnMap.clear();
				System.exit(0);

			}
			else {
				for (int i = 0; i < MapSimulatorView.room.mapRow; i++) {
					for (int j = 0; j < MapSimulatorView.room.mapColumn; j++) {
						char createId = MapSimulatorView.gameValue[i][j];
						if (MapSimulatorView.room.block[i][j]
								.contains(MapSimulatorView.mse)) {
							mapTowerXpos = i;
							mapTowerYpos = j;

							// System.out.println("I click");
							if (createId == 'G' || createId == 'R'
									|| createId == 'B') {
								selectMapTower = true;
								clearInfo = false;
							} else {
								clearInfo = true;
								selectMapTower = false;
							}
						}
					}
				}
			}
		}
	}

	private void drawTowerRange(Graphics graphic, int circleX, int circleY,
			int radius) {
		radius = radius * towerWidth;
		circleX = circleX + (towerWidth / 2) - radius;
		circleY = circleY + (towerWidth / 2) - radius;
		graphic.setColor(Color.RED);
		graphic.drawOval(circleX, circleY, 2 * radius, 2 * radius);
	}

	private void drawStratergyWindow(Graphics graphic) {
		graphic.clearRect(box2Xpos + 280, box2Ypos, 200, 200);
		graphic.setColor(Color.WHITE);
		graphic.fillRect(box2Xpos + 280, box2Ypos, 200, 200);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.setColor(Color.BLACK);
		graphic.drawString("SELECT STRATERGY", box2Xpos + 280, box2Ypos + 20);

		graphic.setColor(new Color(255, 155, 0));
		graphic.fillRect(weakTargetStratergy.x, weakTargetStratergy.y,
				weakTargetStratergy.width, weakTargetStratergy.height);
		graphic.fillRect(strongTargetStratergy.x, strongTargetStratergy.y,
				strongTargetStratergy.width, strongTargetStratergy.height);
		graphic.fillRect(nearTargetStratergy.x, nearTargetStratergy.y,
				nearTargetStratergy.width, nearTargetStratergy.height);
		graphic.fillRect(randomTargetStratergy.x, randomTargetStratergy.y,
				randomTargetStratergy.width, randomTargetStratergy.height);

		graphic.setColor(Color.RED);
		graphic.drawString("WEAK TARGET", weakTargetStratergy.x,
				weakTargetStratergy.y + 20);
		graphic.drawString("STRONG TARGET", strongTargetStratergy.x,
				strongTargetStratergy.y + 20);
		graphic.drawString("NEAR TARGET", nearTargetStratergy.x,
				nearTargetStratergy.y + 20);
		graphic.drawString("RANDOM TARGET", randomTargetStratergy.x,
				randomTargetStratergy.y + 20);

	}

	private void applyStratergy(int mapTowerXpos2, int mapTowerYpos2) {
		Tower tower = GameFileManager
				.getTowerObject(mapTowerXpos, mapTowerYpos);
		tower.attackStrategy = selectedStratergy;
		System.out.println(selectedStratergy);
		GameFileManager.saveTowerObject(tower, mapTowerXpos, mapTowerYpos);
		isStrtergySelect = false;
	}

}
