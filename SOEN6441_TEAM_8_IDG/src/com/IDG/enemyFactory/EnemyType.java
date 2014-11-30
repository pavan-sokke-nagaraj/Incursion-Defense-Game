package com.IDG.enemyFactory;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public interface EnemyType {
	/**
	 * This function move enemies on map
	 * @param graphics
	 */
	public void move(Graphics graphics);
	/**
	 * This function update enemies movement
	 * @param g
	 */
	public void update(Graphics g);
	/**
	 * This function clone enemy movement
	 * @param enemyPath
	 * @return
	 */
	public LinkedList<Point> cloneEnemyPath(LinkedList<Point> enemyPath);
	/**
	 * Draw enemies on map
	 * @param g
	 */
	public void draw(Graphics g);
	/**
	 * Draw enemies health bar on screen
	 * @param g
	 */
	public void drawHealthBar(Graphics g);
	
	
	/**
	 * getter method for X
	 */
	public int Xvalue();
	/**
	 * getter method for Y
	 */
	public int Yvalue();
	
	/**
	 * getter method for actualhealth
	 */
	public int getActualHealth();
	/**
	 * getter method for currenthealth
	 */
	public int getCurrentHealth();
	/**
	 * Setter method for actualhealth
	 */
	public void setActualHealth(int actualHealth); 
	/**
	 * setter method for currenthealth
	 */
	public void setCurrentHealth(int currentHealth);
	/**
	 * getter method for EnemyId
	 */
	public int getEnemyId();
	/**
	 * getter method for CurrentSpeed()
	 */
	public int getEnemyCurrentSpeed();
	/**
	 * getter method for isSpeedSlow
	 */
	public boolean isSpeedSlow();
	/**
	 * getter method for EnemyId
	 */
	public void setSpeedSlow(boolean isSpeedSlow);
	/**
	 * getter method for EnemyCurrentSpeed
	 */
	public void setEnemyCurrentSpeed(int enemyCurrentSpeed);
	/**
	 * setter method for EnemyId
	 */
	public void setEnemyId(int enemyId);
	
	public void setBurning(boolean isBurning);
	
	public boolean isBurning();

}
