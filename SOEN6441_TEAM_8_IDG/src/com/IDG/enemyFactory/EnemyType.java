package com.IDG.enemyFactory;
import java.awt.Graphics;


public interface EnemyType {

	public void spawnEnemy(int EnemyID);
	
	public void checkDeath();
	
	public void physics();
	
	public  boolean isDead();
	
	public  void deleteEnemy();
	
	public  void loseHealth(int amo);
	
	public  void draw(Graphics g);

	public  void setEnemyID(int enemyID);

	public  int getEnemyID();
}
