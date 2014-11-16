package com.IDG.enemyFactory;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public interface EnemyType {
	
	public void move(Graphics graphics);
	
	public void update(Graphics g);
	
	public LinkedList<Point> cloneEnemyPath(LinkedList<Point> enemyPath);
	
	public void draw(Graphics g);
	
	public void drawHealthBar(Graphics g);
	
	public int Xvalue();

	public int Yvalue();
	
	public int getActualHealth();
	
	public int getCurrentHealth();
	
	public void setActualHealth(int actualHealth); 
	
	public void setCurrentHealth(int currentHealth);
	
	public int getEnemyId();


	public void setEnemyId(int enemyId);
	
}
