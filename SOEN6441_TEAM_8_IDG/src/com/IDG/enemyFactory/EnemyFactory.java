package com.IDG.enemyFactory;

import java.awt.Point;
import java.util.LinkedList;

import com.IDG.mapSimulator.MapSimulatorView;

/**
 * This is factory class to create different kind of enemies
 * @author Arjun
 * @author Kariappa
 *
 */
public class EnemyFactory {
/**
 * 
 * @param enemyType Type of enemy 
 * @param enemyId Id of enemy
 * @param enemyPath Path of enemy
 * @param movePoint Path of enemy
 * @param actualHealth Actual Health of enemy
 * @param currentHealth Current Health of enemy
 * @param value Value of enemy
 * @param enemyActualSpeed Actual Speed of enemy
 * @param enemyCurrentSpeed Current Speed of enemy
 * @return enemy
 */
public EnemyType getEnemyfromFactory(String enemyType,int enemyId,LinkedList<Point> enemyPath, int movePoint,int actualHealth,int currentHealth,int value,int enemyActualSpeed,int enemyCurrentSpeed)
{
	 if(enemyType == null)
      	return new SmallEnemy();
	 else if(enemyType.equalsIgnoreCase("normalenemy")){
		 	return new SmallEnemy(enemyId,enemyPath,movePoint,actualHealth,currentHealth,value,enemyActualSpeed,enemyCurrentSpeed);
	 }
	 else if(enemyType.equalsIgnoreCase("bossenemy")){
		 return new bossEnemy(enemyId,enemyPath,movePoint,actualHealth,currentHealth,value,enemyActualSpeed,enemyCurrentSpeed);
	 }
           
	 return null;
         
}

}
