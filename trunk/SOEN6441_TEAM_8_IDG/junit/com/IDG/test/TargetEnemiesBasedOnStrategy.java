package com.IDG.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.IDG.enemyFactory.StrongEnemy;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Tower;

public class TargetEnemiesBasedOnStrategy {
	
	StrongEnemy currentEnemy = new StrongEnemy();
	Tower tower = new Tower();
	MapSimulatorView mapSimulatorView =null;
	
	
	@Before
	public void setUp() throws Exception {
		currentEnemy.enemyId=1;
		currentEnemy.x = 10;
		currentEnemy.y = 20;
		currentEnemy.currentHealth=100;
		currentEnemy.actualHealth=100;
		currentEnemy.enemyCurrentSpeed=10;
		currentEnemy.enemyActualSpeed=10;
		currentEnemy.value=10;
		mapSimulatorView =new MapSimulatorView();
	}

	@Test
	public void testBurningStrategy() {
		tower.towerAttackType=2;
		mapSimulatorView.attackEnemiesBasedOnStrategies(tower, currentEnemy, null, 0, 0);
		assertEquals(80,currentEnemy.currentHealth);
	}
	
	@Test
	public void testSplashingStrategy() {
		tower.towerAttackType=1;
		mapSimulatorView.attackEnemiesBasedOnStrategies(tower, currentEnemy, null, 0, 0);
		assertEquals(90,currentEnemy.currentHealth);
	}
	
	@Test
	public void testFreezingStrategy() {
		tower.towerAttackType=3;
		mapSimulatorView.attackEnemiesBasedOnStrategies(tower, currentEnemy, null, 0, 0);
		assertEquals(5,currentEnemy.enemyCurrentSpeed);
	}
	
}
