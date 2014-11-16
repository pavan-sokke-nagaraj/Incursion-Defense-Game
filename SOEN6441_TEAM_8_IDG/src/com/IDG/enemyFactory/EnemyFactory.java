package com.IDG.enemyFactory;

import java.awt.Point;
import java.util.LinkedList;

import com.IDG.mapSimulator.MapSimulatorView;


public class EnemyFactory {

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
