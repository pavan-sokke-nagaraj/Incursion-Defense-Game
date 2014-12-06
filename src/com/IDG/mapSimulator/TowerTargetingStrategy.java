package com.IDG.mapSimulator;

import java.util.ArrayList;

import com.IDG.enemyFactory.EnemyType;

public interface TowerTargetingStrategy {
	
	public ArrayList<EnemyType> towerTarget(Tower tower,EnemyType[] enemiesInRange,ArrayList enemyHealthList,ArrayList enemyDistanceList);

}
