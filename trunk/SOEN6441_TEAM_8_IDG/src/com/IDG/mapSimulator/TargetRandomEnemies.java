package com.IDG.mapSimulator;

import java.util.ArrayList;
import java.util.Random;

import com.IDG.enemyFactory.EnemyType;

public class TargetRandomEnemies implements TowerTargetingStrategy{

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
			int enemy=new Random().nextInt(totalEnemies);
			int enemiesTaken=0;
			int k=0;

			while(true){
				if(enemiesTaken==enemy&&enemiesInRange[k]!=null){
					returnEnemyList.add(enemiesInRange[k]);
					if(tower.towerAttackType==tower.SPLASHINHG&&totalEnemies>1){
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
		return returnEnemyList;
	}
}
