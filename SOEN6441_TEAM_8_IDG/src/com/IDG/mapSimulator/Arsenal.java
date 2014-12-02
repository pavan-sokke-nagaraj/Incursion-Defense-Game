package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.IDG.controller.Game;
import com.IDG.controller.GameFileManager;
import com.IDG.controller.LayoutManager;
import com.IDG.logs.GameLogging;
import com.IDG.mapBuilder.MapDetails;
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
	/**
	 * Button for wave to start
	 */
	public Rectangle waveButton;
	/**
	 * Button for game to start
	 */
	public Rectangle gameResetButton;
	/**
	 * Button for game to exit
	 */
	public Rectangle exitGameButton;
	/**
	 * Button for exit after completion game.
	 */
	public static Rectangle exitgame1; 
	/**
	 * Different strategy patterns
	 */
	public Rectangle weakTargetStratergy;
	public Rectangle strongTargetStratergy;
	public Rectangle nearTargetStratergy;
	public Rectangle randomTargetStratergy;
	public boolean isStrtergySelect = false;
	public int selectedStratergy;
	public MapDetails exitupdatetofile =new MapDetails();

	/**
	 * class constructor to initialize tower data, health data, money data
	 * Upgrade: Build 2-> serialize he objects and retrieve data from xml files
	 */
	public Arsenal() {

		for (int i = 0; i < towerNumber; i++) {
			towers[i] = new Rectangle(box1Xpos + (gap * i) + (towerWidth * i),
					box1Ypos, towerWidth, towerWidth);
			if (i == 0) {
				towerBlocks[i] = new Tower('G', 50, 1, 1,25,25, 1,30, 30, 3);// Freezing//attack delay=50//Random
			} else if (i == 1) {
				towerBlocks[i] = new Tower('R', 150, 1, 1, 100, 100,2, 70, 10, 2);// Burning//attack delay=70//Random
			} else if (i == 2) {
				towerBlocks[i] = new Tower('B', 150, 1, 2, 200, 200,2, 15, 40, 1);// Splashing//attack Delay = Max Health
			} else if (i == 3) {
				towerBlocks[i] = new Tower('D', 0, 0, 0, 0, 0, 1, 10, 2, 2);
			}
		}

		health = new Rectangle(box1Xpos, box1Ypos + towerWidth, towerWidth,
				towerWidth);
		money = new Rectangle(box1Xpos + 100, box1Ypos + towerWidth,
				towerWidth, towerWidth);
		upgradeButton = new Rectangle(box2Xpos + 45, box2Ypos + 145, 160, 40);
		sellButton = new Rectangle(box2Xpos + 45, box2Ypos + 125, 160, 20);
		waveButton = new Rectangle(box2Xpos + 0, 565 + 125 - 100, 160, 60);
		gameResetButton = new Rectangle(box2Xpos + 165, 565 + 125 - 100, 160,
				60);
		exitGameButton = new Rectangle(box2Xpos + 330, 565 + 125 - 100, 150, 60);
		exitgame1=new Rectangle(10,400,150,60);
		weakTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 30, 160,
				30);
		strongTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 70,
				160, 30);
		nearTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 110,
				160, 30);
		randomTargetStratergy = new Rectangle(box2Xpos + 300, box2Ypos + 150,
				160, 30);

		pauseButton = new Rectangle(box2Xpos + 0, 565 + 125 - 100 + 70, 250,
				100);

//		logButton = new Rectangle(box2Xpos + 255, 565 + 125 - 100 + 70, 230, 100);
		logButton = new Rectangle(50, 50, 230, 100);

		towerLogButton = new Rectangle(logButton.x + 3, logButton.y + 3, 110,
				45);
		allTowerLogButton = new Rectangle(logButton.x + 117, logButton.y + 3,
				110, 45);
		waveLogButton = new Rectangle(logButton.x + 3, logButton.y + 52, 110,
				45);
		gameLogButton = new Rectangle(logButton.x + 117, logButton.y + 52, 110,
				45);

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
		graphic.setColor(Color.BLACK);
		graphic.setFont(new Font("Courier New", Font.BOLD, 25));
		drawhighscore(graphic, LayoutManager.passvalue);
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
		graphic.drawString("START WAVE " + (MapSimulatorView.waveLevel + 1),
				waveButton.x + 5, waveButton.y + 20);

		drawGameResetExitButton(graphic);
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

		drawGamePauseWindow(graphic);
		drawGameLogsWindow(graphic);
	}

	public void drawGameResetExitButton(Graphics graphic) {

		graphic.setColor(Color.RED);
		graphic.fillRect(gameResetButton.x, gameResetButton.y,
				gameResetButton.width, gameResetButton.height);
		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("RESET GAME", gameResetButton.x + 20,
				gameResetButton.y + 20);

		graphic.fillRect(exitGameButton.x, exitGameButton.y,
				exitGameButton.width, exitGameButton.height);
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("EXIT GAME", exitGameButton.x + 20,
				exitGameButton.y + 20);
	}

	/**
	 * function to draw money information to screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */

	public static void resetGame ()
	{
		MapSimulatorView.gameLog.append("Game Has been Reset");
		MapSimulatorView.gameLog.append("\n");
		MapSimulatorView.waveLevel = 0;
		MapSimulatorView.moveEnemy = false;
		MapSimulatorView.enemiesOnMap.clear();
		MapSimulatorView.health = Game.getInstance().INITIAL_GAME_HEALTH;
		MapSimulatorView.power = Game.getInstance().INITIAL_GAME_POWER;
		for (int i = 0; i < MapSimulatorView.gridRow; i++) {
			for (int j = 0; j < MapSimulatorView.gridColumn; j++) {
				char createId = MapSimulatorView.gameValue[j][i];
				if (createId == 'R' || createId == 'G' || createId == 'B') {
					MapSimulatorView.gameValue[j][i] = '*';
				}
			}

		}
		MapSimulatorView.gameLog=new StringBuffer();
		MapSimulatorView.levelLogList=new LinkedList<StringBuffer>();
		MapSimulatorView.levelLog=new StringBuffer();
		MapSimulatorView.collectiveTowerlog=new StringBuffer();
		clearInfo = true;
		selectMapTower = false;
		MapSimulatorView.isGameReset = false;
		Game.getInstance().setGamePaused(false);
		
	}

	public static void drawhighscore(Graphics graphic,ArrayList<Integer> tempabc)
	{
		graphic.setColor(Color.YELLOW);
		graphic.fillRect(box1Xpos+300, box1Ypos-55,200, 250);
		graphic.setColor(Color.BLACK);
		graphic.drawString("HIGH SCORE", box1Xpos+300 , box1Ypos - 15);
		int j=0;
		
		for (int i=0;i<tempabc.size();i++)
		{	j=j+20;
			graphic.drawString(Integer.toString(tempabc.get(i)) ,box1Xpos+350 , 90+j);
		}
	}
	static int ctr=0;
	public static void drawendofgame (Graphics graphic,ArrayList<Integer> tempabc)
	{
		ctr++;
		//Arsenal.resetGame();
		graphic.setColor(Color.BLACK);
		
		graphic.fillRect(0, 0, 1239,709);
		graphic.setColor(Color.YELLOW);
		graphic.setFont(new Font("TimesRoman", Font.BOLD, 70));
		if(MapSimulatorView.isGameWon)
		graphic.drawString("GAME WON!!", 10, 70);
		else
			graphic.drawString("GAME LOST!!", 10, 70);
		graphic.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		graphic.drawString("HIGH SCORE", 10, 120);
		int j=0;
		for (int i=0;i<tempabc.size();i++)
		{	j=j+40;
			graphic.drawString(Integer.toString(tempabc.get(i)) ,10, 120+j);
		}
		graphic.fillRect(exitgame1.x, exitgame1.y, exitgame1.width,
				exitgame1.height);
		graphic.setColor(Color.RED);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.drawString("EXIT GAME", exitgame1.x + 20, exitgame1.y + 20);
		System.out.println(ctr);
	
	}
	/**
	 * Draws the Money Component
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
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
		Tower tower = GameFileManager
				.getTowerObject(mapTowerXpos, mapTowerYpos);
		if (tower.costToSell > 0) {
			MapSimulatorView.power = MapSimulatorView.power + tower.costToSell;
			drawMoney(graphic);
			tower.individualTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been sold at value of "+tower.costToSell);
			tower.individualTowerlog.append("\n");
			MapSimulatorView.collectiveTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been sold at value of "+tower.costToSell);
			MapSimulatorView.collectiveTowerlog.append("\n");
			MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been sold at value of "+tower.costToSell);
			MapSimulatorView.levelLog.append("\n");
			MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been sold at value of "+tower.costToSell);
			MapSimulatorView.gameLog.append("\n");
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
		Tower tower = GameFileManager
				.getTowerObject(mapTowerXpos, mapTowerYpos);
		if (MapSimulatorView.power >= tower.costToUpgrade) {
			MapSimulatorView.power = MapSimulatorView.power
					- tower.costToUpgrade;
			tower.individualTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been upgrade at value of "+tower.costToUpgrade);
			tower.individualTowerlog.append("\n");
			MapSimulatorView.collectiveTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been upgrade at value of "+tower.costToUpgrade);
			MapSimulatorView.collectiveTowerlog.append("\n");
			MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been upgrade at value of "+tower.costToUpgrade);
			MapSimulatorView.levelLog.append("\n");
			MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been upgrade at value of "+tower.costToUpgrade);
			MapSimulatorView.gameLog.append("\n");
			
			drawMoney(graphic);
			++tower.level;
			++tower.range;
			tower.damage = tower.damage + 5;
			tower.costToUpgrade = tower.costToUpgrade + 10;
			tower.costToSell = tower.costToSell + 5;
			tower.maxAttackDelay = tower.maxAttackDelay - 5;
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
									int xpos = MapSimulatorView.room.block[i][j].x;
									int ypos = MapSimulatorView.room.block[i][j].y;
									MapSimulatorView.room.block[i][j].createId = heldValue;
									Tower tower=towerBlocks[heldPosition];
									tower.individualTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been placed at X :: "+xpos+" , Y :: "+ypos);
									tower.individualTowerlog.append("\n");
									MapSimulatorView.collectiveTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been placed at X :: "+xpos+" , Y :: "+ypos);
									MapSimulatorView.collectiveTowerlog.append("\n");
									MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been placed at X :: "+xpos+" , Y :: "+ypos);
									MapSimulatorView.levelLog.append("\n");
									MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" has been placed at X :: "+xpos+" , Y :: "+ypos);
									MapSimulatorView.gameLog.append("\n");
									GameFileManager.saveTowerObject(
											tower, i, j);
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

				if (MapSimulatorView.waveLevel <= 10) {
					//MapSimulatorView.levelLog.add(particularLevelLog);
					//MapSimulatorView.levelLog=new StringBuffer();
					int actualHealth=0,currentHealth=0,value=0,enemyActualSpeed=0,enemyCurrentSpeed=0;
					int numberOFEnemies=0;
					MapSimulatorView.moveEnemy = true;
					MapSimulatorView.isGameLost = false;
					MapSimulatorView.isGameWon = false;
					MapSimulatorView.waveLevel++;
					MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Start of Level :: "+MapSimulatorView.waveLevel);
					MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Start of Level :: "+MapSimulatorView.waveLevel);
					if (MapSimulatorView.gridRow != 0
							|| MapSimulatorView.gridColumn != 0) {
						MapSimulatorView.enemyPath = EnemyPath.copyPath();
						if (1 <= MapSimulatorView.waveLevel
								&& MapSimulatorView.waveLevel <= 3) {
							MapSimulatorView.enemyType = "normalenemy";
							actualHealth = MapSimulatorView.waveLevel * 100;
							currentHealth = MapSimulatorView.waveLevel * 100;
							value = MapSimulatorView.waveLevel * 10;
							enemyActualSpeed = 5;
							enemyCurrentSpeed = 5;
							numberOFEnemies = 3 + (MapSimulatorView.waveLevel * 2);
						} else if (3 < MapSimulatorView.waveLevel
								&& MapSimulatorView.waveLevel <= 6) {
							MapSimulatorView.enemyType = "normalenemy";
							actualHealth = MapSimulatorView.waveLevel * 150;
							currentHealth = MapSimulatorView.waveLevel * 150;
							value = MapSimulatorView.waveLevel * 10;
							enemyActualSpeed = 8;
							enemyCurrentSpeed = 8;
							numberOFEnemies = 5 + (MapSimulatorView.waveLevel * 2);
						} else if (6 < MapSimulatorView.waveLevel
								&& MapSimulatorView.waveLevel <= 10) {
							MapSimulatorView.enemyType = "bossEnemy";
							actualHealth = MapSimulatorView.waveLevel * 600;
							currentHealth = MapSimulatorView.waveLevel * 600;
							value = MapSimulatorView.waveLevel * 20;
							enemyActualSpeed = 10;
							enemyCurrentSpeed = 10;
							numberOFEnemies = 7 + (MapSimulatorView.waveLevel * 2);
						}
						MapSimulatorView.levelLog.append("\n");
						MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Total No of Enemies :: "+numberOFEnemies);
						MapSimulatorView.levelLog.append("\n");
						MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemies Health:: "+actualHealth);
						MapSimulatorView.levelLog.append("\n");
						MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemies Value:: "+value);
						MapSimulatorView.levelLog.append("\n");
						MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemy Speed:: "+enemyActualSpeed);
						MapSimulatorView.levelLog.append("\n");
						MapSimulatorView.gameLog.append("\n");
						MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Total No of Enemies :: "+numberOFEnemies);
						MapSimulatorView.gameLog.append("\n");
						MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemies Health:: "+actualHealth);
						MapSimulatorView.gameLog.append("\n");
						MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemies Value:: "+value);
						MapSimulatorView.gameLog.append("\n");
						MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemy Speed:: "+enemyActualSpeed);
						MapSimulatorView.gameLog.append("\n");
						for (int i = 0; i < numberOFEnemies; i++) {
							MapSimulatorView.enemiesOnMap
									.add(MapSimulatorView.enemyFactory
											.getEnemyfromFactory(
													MapSimulatorView.enemyType,
													i,
													MapSimulatorView.enemyPath,
													i * 20, actualHealth,
													currentHealth, value,
													enemyActualSpeed,
													enemyCurrentSpeed));
						}
					}
				} else {
					// Arsenal.resetGame();
					// MapSimulatorView.isGameWon=true;
				}
			} else {
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

			if (gameResetButton.contains(MapSimulatorView.mse)) {
				MapSimulatorView.isGameReset = true;
				resetGame();
			} else if (exitGameButton.contains(MapSimulatorView.mse)) {
				MapSimulatorView.waveLevel = 0;
				MapSimulatorView.moveEnemy = false;
				MapSimulatorView.enemiesOnMap.clear();
				exitupdatetofile.mapid=LayoutManager.mapid;
				 exitupdatetofile=exitupdatetofile.readFromFile(exitupdatetofile);
				 exitupdatetofile.gamestatus.add("TERMINATED");
				 exitupdatetofile.writeToFile(exitupdatetofile);
				GameFileManager gameFileManager = new GameFileManager() ;
				gameFileManager.deleteGameTowers();
				System.exit(0);
				} 
			else if (exitgame1.contains(MapSimulatorView.mse))
			{
				if (MapSimulatorView.isGameLost||MapSimulatorView.isGameWon)
				{
				MapSimulatorView.waveLevel=0;
				MapSimulatorView.moveEnemy = false;
				MapSimulatorView.enemiesOnMap.clear();
				 exitupdatetofile.mapid=LayoutManager.mapid;
				 exitupdatetofile=exitupdatetofile.readFromFile(exitupdatetofile);
				 if (MapSimulatorView.isGameLost)
						 
				 exitupdatetofile.gamestatus.add("GAME LOST");
				 if(MapSimulatorView.isGameWon)
					 exitupdatetofile.gamestatus.add("GAME WON");
				 exitupdatetofile.writeToFile(exitupdatetofile);
				 GameFileManager gameFileManager = new GameFileManager() ;
					gameFileManager.deleteGameTowers();
				 
				 System.exit(0);
				}
			}
			else if (pauseButton.contains(MapSimulatorView.mse)) {
				if (Game.getInstance().isGamePaused()) {
					Game.getInstance().setGamePaused(false);
				} else {
					Game.getInstance().setGamePaused(true);
					// MapSimulatorView.paintThread.resume();
				}
			} else if (towerLogButton.contains(MapSimulatorView.mse)) {
				GameLogging log = new GameLogging();
				 log.showTowerLog(mapTowerXpos, mapTowerYpos);
			} else if (allTowerLogButton.contains(MapSimulatorView.mse)) {
				GameLogging log = new GameLogging();
				 log.showAllTowerLog();
			} else if (waveLogButton.contains(MapSimulatorView.mse)) {
				 GameLogging log = new GameLogging();
				 log.showWaveLog(MapSimulatorView.waveLevel);
			} else if (gameLogButton.contains(MapSimulatorView.mse)) {
				GameLogging log = new GameLogging();
				 log.showGameLog();
			} 
			
		}
	}

	/**
	 * function to draw the tower range on map
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 * @param circleX
	 *            Circle X Coordinate
	 * @param circleY
	 *            Circle Y Coordinate
	 * @param radius
	 *            Circle radius
	 */
	private void drawTowerRange(Graphics graphic, int circleX, int circleY,
			int radius) {
		radius = radius * towerWidth;
		circleX = circleX + (towerWidth / 2) - radius;
		circleY = circleY + (towerWidth / 2) - radius;
		graphic.setColor(Color.RED);
		graphic.drawOval(circleX, circleY, 2 * radius, 2 * radius);
	}

	/**
	 * function to draw the tower strategy information
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
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

	/**
	 * Function to apply particular startegy on selected tower
	 * 
	 * @param mapTowerXpos2
	 *            Tower X Coordinate
	 * @param mapTowerYpos2
	 *            Tower Y Coordinate
	 */
	private void applyStratergy(int mapTowerXpos2, int mapTowerYpos2) {
		Tower tower = GameFileManager
				.getTowerObject(mapTowerXpos, mapTowerYpos);
		tower.attackStrategy = selectedStratergy;
		tower.individualTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" new Enemy Choosing Strategy is  "+tower.attackStrategy);
		tower.individualTowerlog.append("\n");
		MapSimulatorView.collectiveTowerlog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" new Enemy Choosing Strategy is  "+tower.attackStrategy);
		MapSimulatorView.collectiveTowerlog.append("\n");
		MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" new Enemy Choosing Strategy is  "+tower.attackStrategy);
		MapSimulatorView.levelLog.append("\n");
		MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Tower "+tower.towerId+" new Enemy Choosing Strategy is  "+tower.attackStrategy);
		MapSimulatorView.gameLog.append("\n");
		GameFileManager.saveTowerObject(tower, mapTowerXpos, mapTowerYpos);
		isStrtergySelect = false;
	}

	public void drawGamePauseWindow(Graphics graphic) {

		graphic.setColor(Color.WHITE);
		graphic.fillRect(pauseButton.x, pauseButton.y, pauseButton.width,
				pauseButton.height);

		String pausePlay;
		Image image;
		if (Game.getInstance().isGamePaused()) {
			pausePlay = "RESUME";
			image = new ImageIcon("ImageSource/PLay.png").getImage();
		} else {
			pausePlay = "PAUSE";
			image = new ImageIcon("ImageSource/Pause.png").getImage();
		}

		graphic.drawImage(image, pauseButton.x + 10, pauseButton.y + 10, 80,
				80, null);
		graphic.setColor(Color.BLACK);
		graphic.setFont(new Font("Courier New", Font.BOLD, 40));
		graphic.drawString(pausePlay, pauseButton.x + 100, pauseButton.y + 60);

	}

	private void drawGameLogsWindow(Graphics graphic) {

		
		graphic.setColor(Color.GREEN);
		graphic.fillRect(logButton.x, logButton.y, logButton.width,
				logButton.height);
		
		graphic.setColor(Color.BLACK);
		graphic.fillRect(towerLogButton.x, towerLogButton.y,
				towerLogButton.width, towerLogButton.height);
		graphic.fillRect(allTowerLogButton.x, allTowerLogButton.y,
				allTowerLogButton.width, allTowerLogButton.height);
		graphic.fillRect(waveLogButton.x, waveLogButton.y, waveLogButton.width,
				waveLogButton.height);
		graphic.fillRect(gameLogButton.x, gameLogButton.y, gameLogButton.width,
				gameLogButton.height);
		

//		
//		towerLogButton = new Rectangle(logButton.x + 3, logButton.y + 3, 110,
//				45);
//		allTowerLogButton = new Rectangle(logButton.x + 117, logButton.y + 3,
//				110, 45);
//		waveLogButton = new Rectangle(logButton.x + 3, logButton.y + 52, 110,
//				45);
//		gameLogButton = new Rectangle(logButton.x + 117, logButton.y + 52, 110,
//				45);
		

		graphic.setColor(Color.WHITE);
		graphic.setFont(new Font("Courier New", Font.BOLD, 18));
		graphic.drawString("TOWER", towerLogButton.x + 30, towerLogButton.y + 18);
		graphic.drawString(" LOG", towerLogButton.x + 30, towerLogButton.y + 40);
		graphic.drawString("ALL TOWER", allTowerLogButton.x + 5, allTowerLogButton.y + 18);
		graphic.drawString(" LOG", allTowerLogButton.x + 30, allTowerLogButton.y + 40);
		graphic.drawString("WAVE", waveLogButton.x + 30, waveLogButton.y + 18);
		graphic.drawString(" LOG", waveLogButton.x + 30, waveLogButton.y + 40);
		graphic.drawString("GAME", gameLogButton.x + 30, gameLogButton.y + 18);
		graphic.drawString(" LOG", gameLogButton.x + 30, gameLogButton.y + 40);

	}

	public Rectangle pauseButton;

	public Rectangle logButton;
	public Rectangle towerLogButton;
	public Rectangle allTowerLogButton;
	public Rectangle waveLogButton;
	public Rectangle gameLogButton;

}
