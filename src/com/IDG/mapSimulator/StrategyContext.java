package com.IDG.mapSimulator;

import java.util.ArrayList;

import com.IDG.enemyFactory.EnemyType;

public class StrategyContext {
	
	private TowerTargetingStrategy towerTargetingStrategy;
	
	public void setStrategy(TowerTargetingStrategy towerTargetingStrategy){
		this.towerTargetingStrategy=towerTargetingStrategy;
	}
	
	public ArrayList<EnemyType> executeStrategy(Tower tower,EnemyType[] enemiesInRange,ArrayList enemyHealthList,ArrayList enemyDistanceList){
		return this.towerTargetingStrategy.towerTarget(tower, enemiesInRange,enemyHealthList,enemyDistanceList);
	}

}
