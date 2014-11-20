/**
 * 
 */
package com.IDG.mapSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

import com.IDG.enemyFactory.EnemyType;

/**
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build2
 * @since Build1
 *
 */
public class Tower extends Observable implements Serializable {

	/**
	 * variable to hold the tower id
	 */
	public char towerId;
	/**
	 * variable to hold the cost of tower to buy
	 */
	public int costToBuy;
	/**
	 * holds the tower level
	 */
	public int level;
	/**
	 * holds the tower range
	 */
	public int range;
	/**
	 * variable to hold the cost of tower to sell
	 */
	public int costToSell;
	/**
	 * variable to hold the cost of tower to upgrade
	 */
	public int costToUpgrade;

	/**
	 * variable to hold the starting x position to draw tower information
	 */
	int box2Xpos = 710;
	/**
	 * variable to hold the starting y position to draw tower information
	 */
	int box2Ypos = 320;

	int towerSize = 40;

	/**
	 * Different Enemy Choosing Strategy
	 */
	public static final int ATTACK_FIRST_NEAR_TOWER_ENEMY=1;//Attack enemy nearest to tower

	public static final int ATTACK_RANDOM_ENEMY=2;//Attack random enemy

	public static final int ATTACK_MIN_HEALTH_ENEMY=3;//Attack Min Health Enemy

	public static final int ATTACK_MAX_HEALTH_ENEMY=4;//Attack Max Health Enemy

	/**
	 * Selected Strategy to choose enemies
	 */
	public int attackStrategy;

	/**
	 * Damage cost by tower to enemies
	 */
	int damage=0;

	/**
	 * Current Rate of hit of tower
	 */
	public int attackDelay=0;
	/**
	 * Max Rate of hit of tower
	 */
	public int maxAttackDelay;
	/**
	 * Type of tower
	 */
	int towerAttackType=0;

	public static final int SPLASHINHG=1;

	public static final int BURNING=2;

	public static final int FREEZING=3;

	public boolean hasHitOnce=true;



	/**
	 * class tower constructor to set the default values
	 */
	public Tower() {

		this.towerId = 'D';
		this.costToBuy = 0;
		this.level = 0;
		this.range = 0;
		this.costToSell = 0;
		this.costToUpgrade = 0;
		this.attackStrategy=2;
		this.damage =10;

	}
	/**
	 * @param towerId tower id
	 * @param costToBuy cost of tower to buy
	 * @param level tower level
	 * @param range tower range
	 * @param costToSell cost of tower to sell
	 * @param costToUpgrade cost of tower to upgrade
	 * @param attackStrategy tower's attacking Startegy
	 * @param damage damage it causes to enemy
	 * @param maxAttackDelay after how much delay it attacks again
	 * @param towerAttackType tower's attacking type
	 */
	public Tower(char towerId, int costToBuy, int level, int range, int costToSell, int costToUpgrade,int attackStrategy,int damage,int maxAttackDelay,int towerAttackType) {
		this.towerId = towerId;
		this.costToBuy = costToBuy;
		this.level = level;
		this.range = range;
		this.costToSell = costToSell;
		this.costToUpgrade = costToUpgrade;
		this.attackStrategy=attackStrategy;
		this.damage =damage;
		this.maxAttackDelay=maxAttackDelay;
		this.towerAttackType=towerAttackType;
	}

	/**
	 * draw's the tower information to the main screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void drawTowerInformation(Graphics graphic) {

		graphic.clearRect(box2Xpos, box2Ypos, 250, 200);
		graphic.setColor(Color.WHITE);
		graphic.fillRect(box2Xpos, box2Ypos, 250, 200);
		graphic.setFont(new Font("Courier New", Font.BOLD, 20));
		graphic.setColor(new Color(255, 155, 0));
		graphic.drawString("TOWER INFORMATION", box2Xpos, box2Ypos + 20);

		if (towerId != 'D') {
			graphic.setFont(new Font("Courier New", Font.BOLD, 15));
			graphic.setColor(Color.BLACK);
			graphic.drawString("INITIAL COST: $" + costToBuy, box2Xpos,
					box2Ypos + 40);
			graphic.drawString("LEVEL: " + level, box2Xpos, box2Ypos + 55);
			graphic.drawString("RANGE: " + range + " Block Radius", box2Xpos,
					box2Ypos + 70);
			graphic.drawString("POWER: " + damage + '%', box2Xpos,
					box2Ypos + 85);
			String attackType="";
			if(towerAttackType==1){
				attackType="Splashing";
			}else if(towerAttackType==2){
				attackType="Burning";
			}else if(towerAttackType==3){
				attackType="Freezing";
			}
			graphic.drawString("ATTACK TYPE: " + attackType, box2Xpos,
					box2Ypos + 100);
			graphic.drawString("ATTACK RATE: " + maxAttackDelay + "ms Delay", box2Xpos,
					box2Ypos + 115);
		}

	}

	/**
	 * Draw's the market place information to the screen
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void drawMarketInformation(Graphics graphic) {
		setChanged();
		notifyObservers(graphic);

	}

	/**
	 * clear the tower information window
	 * 
	 * @param graphic
	 *            Graphic variable to draw the Components
	 */
	public void clearInformation(Graphics graphic) {
		graphic.clearRect(box2Xpos, box2Ypos, 250, 200);
	}
	/**
	 * This function calculate the distance between the Tower and enemy
	 * @param enemy Enemy for which the distance has to be calcuated
	 * @param towerX X Coordinate of Tower 
	 * @param towerY Y Coordinate of Tower
	 * @return distance between tower and enemy
	 */
	public double distance(EnemyType enemy, int towerX, int towerY) {

		int enemyX = enemy.Xvalue();

		int enemyY = enemy.Yvalue();

		enemyCenterX = enemyX + towerSize / 2;

		enemyCenterY = enemyY + towerSize / 2;

		towerCenterX = towerX + towerSize / 2;

		towerCenterY = towerY + towerSize / 2;

		double distance = Math.sqrt(Math.pow(enemyCenterX - towerCenterX, 2) +

				Math.pow(enemyCenterY - towerCenterY, 2));

		return distance;

	}
	/**
	 * This method draw a Fire effect making a contact line between a tower and its enemies in range
	 * @param graphic Graphic for the tower
	 * @param enemy Enemy for which line has to be drawn
	 * @param towerX X Coordinate of Tower
	 * @param towerY Y Coordinate of Tower
	 */
	public void drawFireEffect(Graphics graphic, EnemyType enemy, int towerX, int towerY) {
		double distance = distance(enemy, towerX, towerY);
		if(distance <=range * towerSize){
			graphic.setColor(Color.black);
			graphic.drawLine(enemyCenterX, enemyCenterY, towerCenterX, towerCenterY);
		}
	}
	/**
	 * This method return the list of enemies that are in range of tower based on different strategy
	 * @param enemies List of enemies currently running on map
	 * @param towX X Coordinat of Tower
	 * @param towY Y Coordinat of Tower
	 * @return List of enemies in range
	 */
	public ArrayList<EnemyType> calculateEnemy(ArrayList<EnemyType> enemies,int towX,int towY){

		EnemyType[] enemiesInRange=new EnemyType[enemies.size()];
		ArrayList enemyDistanceList=new ArrayList();
		ArrayList enemyHealthList=new ArrayList();
		ArrayList<EnemyType> returnEnemyList=new ArrayList<EnemyType>();
		for(int i=0;i<enemies.size();i++){
			if(enemies.get(i)!=null){
				EnemyType enemy=enemies.get(i);
				double distance = distance(enemy, towX, towY);

				if (distance <= range * towerSize && enemy.getCurrentHealth() > 0 )
				{
					enemiesInRange[i]=enemy;
					enemyDistanceList.add((double)distance);
					enemyHealthList.add((double)enemy.getCurrentHealth());

				}else{
					if(this.attackStrategy==ATTACK_FIRST_NEAR_TOWER_ENEMY||this.attackStrategy==ATTACK_MIN_HEALTH_ENEMY){
						enemyDistanceList.add(400000000.00);
						enemyHealthList.add(40000000000.00);
					}else{
						enemyDistanceList.add(-1.00);
						enemyHealthList.add(-1.00);
					}
				}
			}
		}
		if(this.attackStrategy==ATTACK_RANDOM_ENEMY){
			int totalEnemies=0;
			for(int i=0;i<enemiesInRange.length;i++){
				if(enemiesInRange[i]!=null){
					totalEnemies++;
				}
			}
			if(totalEnemies>0){
				int enemy=new Random().nextInt(totalEnemies);
				int enemiesTaken=0;
				int k=0;

				while(true){
					if(enemiesTaken==enemy&&enemiesInRange[k]!=null){
						returnEnemyList.add(enemiesInRange[k]);
						if(this.towerAttackType==SPLASHINHG&&totalEnemies>1){
							for(int j=0;j<enemiesInRange.length;j++){
								if(j!=enemy&&enemiesInRange[j]!=null){
									returnEnemyList.add(enemiesInRange[j]);
								}
							}
						}
						return returnEnemyList;
					}
					if(enemiesInRange[k]!=null){
						enemiesTaken++;
					}
					k++;
				}
			}
		}else if(this.attackStrategy==ATTACK_FIRST_NEAR_TOWER_ENEMY){
			int totalEnemies=0;
			for(int i=0;i<enemiesInRange.length;i++){
				if(enemiesInRange[i]!=null){
					totalEnemies++;
				}
			}
			if(totalEnemies>0){
				int minIndex = enemyDistanceList.indexOf(Collections.min(enemyDistanceList));
				if(enemiesInRange[minIndex]!=null){
					returnEnemyList.add(enemiesInRange[minIndex]);
					if(this.towerAttackType==SPLASHINHG&&totalEnemies>1){
						enemyDistanceList.set(minIndex, 40000000.00);
						minIndex = enemyDistanceList.indexOf(Collections.min(enemyDistanceList));
						returnEnemyList.add(enemiesInRange[minIndex]);
					}
					return returnEnemyList;
				}
			}
		}else if(this.attackStrategy==ATTACK_MIN_HEALTH_ENEMY){
			int totalEnemies=0;
			for(int i=0;i<enemiesInRange.length;i++){
				if(enemiesInRange[i]!=null){
					totalEnemies++;
				}
			}
			if(totalEnemies>0){
				int minIndex = enemyHealthList.indexOf(Collections.min(enemyHealthList));
				if(enemiesInRange[minIndex]!=null){
					returnEnemyList.add(enemiesInRange[minIndex]);
					if(this.towerAttackType==SPLASHINHG&&totalEnemies>1){
						enemyDistanceList.set(minIndex, 40000000.00);
						minIndex = enemyDistanceList.indexOf(Collections.min(enemyDistanceList));
						returnEnemyList.add(enemiesInRange[minIndex]);
					}
					return returnEnemyList;
				}
			}
		}else if(this.attackStrategy==ATTACK_MAX_HEALTH_ENEMY){
			int totalEnemies=0;
			for(int i=0;i<enemiesInRange.length;i++){
				if(enemiesInRange[i]!=null){
					totalEnemies++;
				}
			}
			if(totalEnemies>0){
				int minIndex = enemyHealthList.indexOf(Collections.max(enemyHealthList));
				if(enemiesInRange[minIndex]!=null){
					returnEnemyList.add(enemiesInRange[minIndex]);
					if(this.towerAttackType==SPLASHINHG&&totalEnemies>1){
						enemyDistanceList.set(minIndex, -1.00);
						minIndex = enemyDistanceList.indexOf(Collections.min(enemyDistanceList));
						returnEnemyList.add(enemiesInRange[minIndex]);
					}
					return returnEnemyList;
				}
			}
		}
		return null;
	}
	public int enemyCenterX ;
	public int enemyCenterY ;
	public int towerCenterX ;
	public int towerCenterY ;


}
