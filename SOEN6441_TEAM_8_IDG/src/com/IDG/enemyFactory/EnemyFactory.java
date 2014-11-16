package com.IDG.enemyFactory;

import java.awt.Point;
import java.util.LinkedList;


public class EnemyFactory {

public EnemyType getEnemyfromFactory(String enemyType,int enemyId,LinkedList<Point> enemyPath, int movePoint,int actualHealth,int currentHealth,int value)
{
	 if(enemyType == null)
      	return new SmallEnemy();
	 else if(enemyType.equalsIgnoreCase("normalenemy")){
		 	//SmallEnemy [] array= new SmallEnemy[5];
		 	 return new SmallEnemy(enemyId,enemyPath,movePoint,actualHealth,currentHealth,value);
	 }
	 else if(enemyType.equalsIgnoreCase("bossenemy")){
		 //bossEnemy [] array= new bossEnemy[5];
		 return new bossEnemy(enemyId,enemyPath,movePoint,actualHealth,currentHealth,value);
	 }
           
	 return null;
         
}

}
