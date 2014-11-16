/**
 * 
 */
package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import com.IDG.controller.Game;
import com.IDG.controller.GameFileManager;
import com.IDG.enemyFactory.EnemyFactory;
import com.IDG.enemyFactory.EnemyType;
import com.IDG.playGame.EnemyPath;

/**
 * 
 * This class is the view for the Game Simulation GUI
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build 1
 * @since Build 1
 *
 */
public class MapSimulatorView extends JPanel implements Runnable {

	/**
	 * A simple thread intialized to repaint
	 */
	public Thread paintThread = new Thread(this);

	/**
	 * Static variable to hold number of rows in the map grid
	 */
	public static int gridRow;
	/**
	 * Static variable to hold number of columns in the map grid
	 */
	public static int gridColumn;

	/**
	 * variable to hold the game's power.The value is set from
	 * {@code Game.INITIAL_GAME_POWER}
	 */
	public static int power = Game.INITIAL_GAME_POWER;

	/**
	 * variable to hold the game's health.The value is set from
	 * {@code Game.INITIAL_GAME_HEALTH}
	 */
	public static int health = Game.INITIAL_GAME_HEALTH;

	/**
	 * variable to hold the each grids game value
	 */
	public static char[][] gameValue;

	/**
	 * class Room initialized to hold the grid
	 */
	public static Room room = new Room();

	/**
	 * A point representing a location in (x,y) JPanel MapSimulatorView space.
	 * Default value set to {@code Point(0, 0); }
	 */
	public static Point mse = new Point(0, 0);

	/**
	 * class Arsenal initialization which holds the towers
	 */
	public static Arsenal arsenal;
	

	// build 2 end

	public static LinkedList<Point> enemyPath = new LinkedList<Point>();
	//public static Enemy[] enemies = new Enemy[100];
	//public static ArrayList<Enemy> enemiesOnMap=new ArrayList<Enemy>();
	public static EnemyFactory enemyFactory = new EnemyFactory();
	public static String enemyType="normalenemy";
	public static ArrayList<EnemyType> enemiesOnMap=new ArrayList<EnemyType>();
	public static boolean moveEnemy = false;
	public static int mapXStart = 0;
	public static int mapYStart = 0;
	public static int level=0;

	/**
	 * Constructs a new object of our map simulator and start the paintThread
	 */
	public MapSimulatorView() {
		super();

		// B2 start
		// B2 end

		paintThread.start();
	}

	/**
	 * run's the painThread, initialize the arsenal class and repaint
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		addMouseListener(new KeyHandel());
		addMouseMotionListener(new KeyHandel());
		arsenal = new Arsenal();
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		while (true) {

			repaint();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 30 - timeDiff;

			if (sleep < 0) {
				sleep = 10;
			}

			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}

	}

	/**
	 * paint the game simulator GUI components
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics graphic) {

		// draws a white background
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, getWidth(), getHeight());
		// System.out.println(getWidth() + "\t\t" + getHeight());

		// draws a black box to enter text
		graphic.setColor(Color.BLACK);
		graphic.drawRect(20, 0, 1200, 30);

		// draw a yellow background for game grid
		graphic.setColor(Color.ORANGE);
		graphic.fillRect(20, 35, 650, 750);

		graphic.setColor(Color.LIGHT_GRAY);
		graphic.fillRect(700, 35, 500, 250);

		// game Tower board
		graphic.setColor(Color.GRAY);
		graphic.fillRect(700, 300, 500, 250);

		// game life board
		graphic.setColor(Color.DARK_GRAY);
		graphic.fillRect(700, 565, 500, 220);

		if (gridRow != 0 || gridColumn != 0) {
			room = new Room(gridColumn, gridRow, gameValue);
			room.drawGameArena(graphic, gameValue);

			arsenal.draw(graphic);

			long start = System.currentTimeMillis();
			/*if (moveEnemy) {
				enemyPath = EnemyPath.copyPath();
				for (int k = 0; k < enemies.length; k++) {
					enemies[k].update();
					enemies[k].draw(graphic);
					for (int i = 0; i < gridRow; i++) {
						for (int j = 0; j < gridColumn; j++) {
							if(gameValue[i][j] == 'G' || gameValue[i][j] == 'R'
									|| gameValue[i][j] == 'B'){
								Tower tower = GameFileManager
										.getTowerObject(i, j);
								int towerX = MapSimulatorView.room.block[i][j].x;
								int towerY = MapSimulatorView.room.block[i][j].y;
								tower.fire(enemies[k], towerX, towerY);
								tower.drawFireEffect(graphic, enemies[k], towerX, towerY);
							}
						}
					}
				}
			}*/
			if(moveEnemy){
				updateEnemies(graphic);
				updateTower(graphic);

			}
			long time = System.currentTimeMillis() - start ;
		}
	}
	public void updateEnemies(Graphics graphic){
		for (int k = 0; k < enemiesOnMap.size(); k++) {
			if(enemiesOnMap.size()>0){
				enemiesOnMap.get(k).update(graphic);
			}	
			if(enemiesOnMap.size()>0){
				enemiesOnMap.get(k).draw(graphic);
			}
		}
	}
	public void updateTower(Graphics graphic){
		for (int i = 0; i < gridRow; i++) {
			for (int j = 0; j < gridColumn; j++) {
				if(gameValue[i][j] == 'G' || gameValue[i][j] == 'R'
						|| gameValue[i][j] == 'B'){
					Tower tower = GameFileManager
							.getTowerObject(i, j);
					int towerX = MapSimulatorView.room.block[i][j].x;
					int towerY = MapSimulatorView.room.block[i][j].y;
					if(tower.hasHitOnce||tower.attackDelay>tower.maxAttackDelay){
						tower.hasHitOnce=true;
						ArrayList<EnemyType> currentEnemyList=tower.calculateEnemy(enemiesOnMap,towerX,towerY);
						if(currentEnemyList!=null){
							for(int k=0;k<currentEnemyList.size();k++){
								EnemyType currentEnemy=currentEnemyList.get(k);
								if(currentEnemy!=null){
									if(tower.towerAttackType==2||tower.towerAttackType==1){
										int temphealth1;
										temphealth1=currentEnemy.getCurrentHealth();
										temphealth1=temphealth1-tower.damage;
										currentEnemy.setCurrentHealth(temphealth1);
									}else if(tower.towerAttackType==3){
										int temphealth;
										temphealth=currentEnemy.getCurrentHealth();
										temphealth=temphealth-tower.damage;
										currentEnemy.setCurrentHealth(temphealth);
										currentEnemy.setSpeedSlow(true);
										currentEnemy.setEnemyCurrentSpeed(5);
									}
									//System.out.println(" Splash Applied to :: "+(k+1)+" Current Enemy :: "+currentEnemy.enemyId+"Hit by Tower :: "+tower.towerId);
									//System.out.println(" Enemy :: "+currentEnemy.enemyId+"Hit by Tower :: "+tower.towerId);
									//System.out.println("EnemyCurrentHealth :: "+ currentEnemy.currentHealth);
									tower.drawFireEffect(graphic, currentEnemy, towerX, towerY);
									tower.attackDelay=0;
								}
							}
						}
					}else{
						tower.attackDelay+=1;
						GameFileManager
						.saveTowerObject(tower,i, j);
					}
				}
			}
		}
	}
	//	public static boolean initalizeEnemy = true;

}
