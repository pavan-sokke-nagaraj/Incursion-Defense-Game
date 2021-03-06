/**
 * 
 */
package com.IDG.enemyFactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.ImageIcon;

import com.IDG.mapSimulator.MapSimulatorView;

/**
 * This class file creates a different kind of enemy called boss enemy
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 *
 */
public class SmallEnemy extends Rectangle implements EnemyType{
	/**
	 * Size of enemy
	 */
	public int enemySize = 40;
	/**
	 * Enemy path on map
	 */
	public static LinkedList<Point> enemyPath;
	/**
	 * Cloned path on map
	 */
	public LinkedList<Point> enemyPathClone;
	/**
	 * Enemy start position
	 */
	public Point startPoint;
	/**
	 * Enemy next position
	 */
	public Point nextPoint;
	/**
	 * current X and Y position of enemy
	 */
	public int x, y;
	public int movePoint;
	public static int moveStandard = 0;
	/**
	 * Id of enemy
	 */
	public int enemyId;
	/**
	 * value of enemy
	 */
	public int value;
	/**
	 * Actual Health of enemy
	 */
	public int actualHealth;
	/**
	 * Current Health of enemy
	 */
	public int currentHealth;
	/**
	 * Actual Speed of enemy
	 */
	public int enemyActualSpeed=1;
	/**
	 * Current Speed of enemy
	 */
	public int enemyCurrentSpeed=1;
	
	public boolean isSpeedSlow=false;

	public int slowCounter=0;
	
	public boolean isBurning=false;
	public SmallEnemy() {
	}

	public SmallEnemy(int enemyId,LinkedList<Point> enemyPath, int movePoint,int actualHealth,int currentHealth,int value,int enemyActualSpeed,int enemyCurrentSpeed) {
		this.enemyId=enemyId;
		this.enemyPath = enemyPath;
		this.enemyPathClone = cloneEnemyPath(enemyPath);
		this.startPoint = enemyPathClone.pollFirst();
		this.movePoint = movePoint;
		this.y = startPoint.y;
		this.x = startPoint.x;
		this.nextPoint = enemyPathClone.pollFirst();
		this.actualHealth = actualHealth;
		this.currentHealth = currentHealth;
		this.value=value;
		this.enemyActualSpeed=enemyActualSpeed;
		this.enemyCurrentSpeed=enemyCurrentSpeed;
	}

	/**
	 * This function will move enemies on the screen
	 */
	public void move(Graphics graphics) {
		int mapXStart = MapSimulatorView.mapXStart;
		int mapYStart = MapSimulatorView.mapYStart;
		double column = (double) (x - mapXStart) / enemySize;
		double row = (double) (y - mapYStart) / enemySize;
		int mapRow = MapSimulatorView.gridRow;
		int mapCol = MapSimulatorView.gridRow;
		if (row < mapRow && column < mapCol && nextPoint != null
				&& currentHealth > 0) {
			if (y < nextPoint.y) {
				y += this.enemyCurrentSpeed;
			}

			if (x < nextPoint.x) {
				x += this.enemyCurrentSpeed;
			}

			if (x > nextPoint.x) {
				x -= this.enemyCurrentSpeed;
			}
			if (y > nextPoint.y) {
				y -= this.enemyCurrentSpeed;
			}

			if (x == nextPoint.x && y == nextPoint.y) {
				nextPoint = enemyPathClone.pollFirst();
			}
		}else{
			if(currentHealth <= 0){
				MapSimulatorView.power = MapSimulatorView.power + this.value ;
				MapSimulatorView.enemiesOnMap.remove(this);
				System.out.println("Died Enemy NO :: "+this.enemyId);
				MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemy :: "+this.enemyId+" Died");
				MapSimulatorView.levelLog.append("\n");
				MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" Enemy :: "+this.enemyId+" Died");
				MapSimulatorView.gameLog.append("\n");
				if(MapSimulatorView.enemiesOnMap.size()==0){
					MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" All Enemies Died Or Escaped");
					MapSimulatorView.levelLog.append("\n");
					MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" End of Level :: "+MapSimulatorView.waveLevel);
					MapSimulatorView.levelLog.append("\n");
					MapSimulatorView.levelLogList.add(MapSimulatorView.levelLog);
					MapSimulatorView.levelLog=new StringBuffer();
					MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" All Enemies Died Or Escaped");
					MapSimulatorView.gameLog.append("\n");
					MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" End of Level :: "+MapSimulatorView.waveLevel);
					MapSimulatorView.gameLog.append("\n");
					MapSimulatorView.moveEnemy=false;
				}
			}else{
				MapSimulatorView.health = MapSimulatorView.health - this.value ;
				MapSimulatorView.enemiesOnMap.remove(this);
				if(MapSimulatorView.enemiesOnMap.size()==0){
					MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" All Enemies Died Or Escaped");
					MapSimulatorView.levelLog.append("\n");
					MapSimulatorView.levelLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" End of Level :: "+MapSimulatorView.waveLevel);
					MapSimulatorView.levelLog.append("\n");
					MapSimulatorView.levelLogList.add(MapSimulatorView.levelLog);
					MapSimulatorView.levelLog=new StringBuffer();
					MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" All Enemies Died Or Escaped");
					MapSimulatorView.gameLog.append("\n");
					MapSimulatorView.gameLog.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+" End of Level :: "+MapSimulatorView.waveLevel);
					MapSimulatorView.gameLog.append("\n");
					MapSimulatorView.moveEnemy=false;
				}
			}
		}
	}

	/**
	 * This function will update the enemies movement
	 */
	public void update(Graphics graphics) {

		if (movePoint == moveStandard) {
			move(graphics);
		} else {
			movePoint--;
		}
	}

	/**
	 * This method will clone the enemy path
	 */
	public LinkedList<Point> cloneEnemyPath(LinkedList<Point> enemyPath) {
		LinkedList<Point> clonePath = new LinkedList<Point>();
		for (ListIterator<Point> iterator = enemyPath.listIterator(); iterator
				.hasNext();) {
			clonePath.add(iterator.next());
		}
		return clonePath;
	}
	
	/**
	 * This method will draw enemies on the map
	 */
	public void draw(Graphics g) {

		Image image = new ImageIcon("ImageSource/monster.gif").getImage();

		g.drawImage(image, x, y, enemySize, enemySize, null);
		drawHealthBar(g);

	}
	/**
	 * This method will draw health bar of enemy
	 */
	public void drawHealthBar(Graphics g) {
		if (currentHealth > 0) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y + enemySize - 6, enemySize, 5);
			double healthRate = (double) currentHealth / actualHealth;

			g.setColor(Color.GREEN);

			if (healthRate < 0.5) {
				g.setColor(Color.ORANGE);
			}

			if (healthRate < 0.2) {
				g.setColor(Color.RED);
			}

			g.fillRect(x, y + enemySize - 6, (int) (enemySize * healthRate), 5);
		}
	}

	/**
	 * getter method for X
	 */
	public int Xvalue()
	{
	return x;
	}
	/**
	 * getter method for Y
	 */
	public int Yvalue()
	{
		return y;
	}
	/**
	 * getter method for actualhealth
	 */
	public int getActualHealth() {
		return actualHealth;
	}
	/**
	 * Setter method for actualhealth
	 */
	public void setActualHealth(int actualHealth) {
		this.actualHealth = actualHealth;
	}
	/**
	 * getter method for currenthealth
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	/**
	 * setter method for currenthealth
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	/**
	 * getter method for EnemyId
	 */
	public int getEnemyId() {
		return enemyId;
	}
	/**
	 * getter method for CurrentSpeed()
	 */
	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}
	/**
	 * getter method for isSpeedSlow
	 */
	public boolean isSpeedSlow() {
		return isSpeedSlow;
	}/**
	 * getter method for EnemyId
	 */

	public void setSpeedSlow(boolean isSpeedSlow) {
		this.isSpeedSlow = isSpeedSlow;
	}
	/**
	 * getter method for EnemyCurrentSpeed
	 */
	public int getEnemyCurrentSpeed() {
		return enemyCurrentSpeed;
	}
	/**
	 * setter method for EnemyId
	 */
	public void setEnemyCurrentSpeed(int enemyCurrentSpeed) {
		this.enemyCurrentSpeed = enemyCurrentSpeed;
	}

	public boolean isBurning() {
		return isBurning;
	}

	public void setBurning(boolean isBurning) {
		this.isBurning = isBurning;
	}

}
