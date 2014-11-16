/**
 * 
 */
package com.IDG.enemyFactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.ImageIcon;

import com.IDG.mapSimulator.MapSimulatorView;

/**
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 *
 */
public class SmallEnemy extends Rectangle implements EnemyType{
	public int enemySize = 40;
	public static LinkedList<Point> enemyPath;
	public LinkedList<Point> enemyPathClone;
	public Point startPoint;
	public Point nextPoint;
	public int x, y;
	public int movePoint;
	public static int moveStandard = 0;
	public int enemyId;
	public boolean atExit;
	public int value; // value of critter
	public int speedOffsetX;
	public int speedOffsetY;

	public int actualHealth;
	public int currentHealth;

	public SmallEnemy() {
	}

	public SmallEnemy(int enemyId,LinkedList<Point> enemyPath, int movePoint,int actualHealth,int currentHealth,int value) {
		this.enemyId=enemyId;
		this.enemyPath = enemyPath;
		this.enemyPathClone = cloneEnemyPath(enemyPath);
		this.startPoint = enemyPathClone.pollFirst();
		this.movePoint = movePoint;
		this.y = startPoint.y;
		this.x = startPoint.x;

		this.nextPoint = enemyPathClone.pollFirst();

		this.speedOffsetX = 5;
		this.speedOffsetY = 5;
		this.actualHealth = actualHealth;
		this.currentHealth = currentHealth;
		this.value=value;

		// System.out.println("Enemy():\tx:\t"+x+"\tY:\t"+y);
	}

	public void move(Graphics graphics) {
		int mapXStart = MapSimulatorView.mapXStart;
		int mapYStart = MapSimulatorView.mapYStart;
		double column = (double) (x - mapXStart) / enemySize;
		double row = (double) (y - mapYStart) / enemySize;
		int mapRow = MapSimulatorView.gridRow;
		int mapCol = MapSimulatorView.gridRow;
		// System.out.println("move():\tx:\t"+x+"\tY:\t"+y+"  row:  "+row+"  col:\t"+column);

		if (row < mapRow && column < mapCol && nextPoint != null
				&& currentHealth > 0) {
			if (y < nextPoint.y) {
				y += speedOffsetY;
			}

			if (x < nextPoint.x) {
				x += speedOffsetX;
			}

			if (x > nextPoint.x) {
				y -= speedOffsetY;
				x -= speedOffsetX;
			}
			if (y > nextPoint.y) {
				y -= speedOffsetY;
				x -= speedOffsetX;
			}

			if (x == nextPoint.x && y == nextPoint.y) {
				nextPoint = enemyPathClone.pollFirst();
			}
		}else{
			//graphics.drawImage(null, x, y, enemySize, enemySize, null);
			MapSimulatorView.power = MapSimulatorView.power + this.value ;
			MapSimulatorView.enemiesOnMap.remove(this);
			System.out.println("Died Enemy NO :: "+this.enemyId);
			if(MapSimulatorView.enemiesOnMap.size()==0){
				MapSimulatorView.moveEnemy=false;
			}
		}
		//TODO what to do when critters exit the path
	}

	public void update(Graphics graphics) {

		if (movePoint == moveStandard /* && currentHp > 0 */) {
			move(graphics);
			// endOfGameCheck();
			// System.out.println("CHECK");

		} else {
			movePoint--;
		}
	}

	public LinkedList<Point> cloneEnemyPath(LinkedList<Point> enemyPath) {
		LinkedList<Point> clonePath = new LinkedList<Point>();
		for (ListIterator<Point> iterator = enemyPath.listIterator(); iterator
				.hasNext();) {
			clonePath.add(iterator.next());
		}
		return clonePath;
	}

	public void draw(Graphics g) {

		Image image = new ImageIcon("ImageSource/enemy.png").getImage();

		g.drawImage(image, x, y, enemySize, enemySize, null);
		drawHealthBar(g);

	}

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

	public int Xvalue()
	{
	return x;
	}
	public int Yvalue()
	{
		return y;
	}

	public int getActualHealth() {
		return actualHealth;
	}

	public void setActualHealth(int actualHealth) {
		this.actualHealth = actualHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}

}
