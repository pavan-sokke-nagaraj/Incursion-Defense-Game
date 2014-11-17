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
	
	public int Xvalue();

	public int Yvalue();
	
	//Below return methods are getter and setter functions
	public int getActualHealth();
	
	public int getCurrentHealth();
	
	public void setActualHealth(int actualHealth); 
	
	public void setCurrentHealth(int currentHealth);
	
	public int getEnemyId();
	
	public int getEnemyCurrentSpeed();
	public boolean isSpeedSlow();
	
	public void setSpeedSlow(boolean isSpeedSlow);
	public void setEnemyCurrentSpeed(int enemyCurrentSpeed);


	public void setEnemyId(int enemyId);
	
}
