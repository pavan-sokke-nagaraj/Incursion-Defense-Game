package com.IDG.mapSimulator;

import java.util.ArrayList;
import java.util.Collections;

import com.IDG.enemyFactory.EnemyType;

public class TargetNearBaseEnemies implements TowerTargetingStrategy {

	@Override
	public ArrayList<EnemyType> towerTarget(Tower tower,EnemyType[] enemiesInRange,ArrayList enemyHealthList,ArrayList enemyDistanceList) {
		ArrayList<EnemyType> returnEnemyList=new ArrayList<EnemyType>();
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
				if(tower.towerAttackType==tower.SPLASHINHG&&totalEnemies>1){
					enemyDistanceList.set(minIndex, 40000000.00);
					minIndex = enemyDistanceList.indexOf(Collections.min(enemyDistanceList));
					returnEnemyList.add(enemiesInRange[minIndex]);
				}
				return returnEnemyList;
			}
		}
		return returnEnemyList;
	}
}
