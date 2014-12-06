package com.IDG.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.IDG.enemyFactory.EnemyType;
import com.IDG.enemyFactory.StrongEnemy;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Tower;

public class CalculateEnemyBasedOnStrategy {

	Tower nnTower = new Tower();
	StrongEnemy strongEnemy1 = new StrongEnemy();
	StrongEnemy strongEnemy2 = new StrongEnemy();
	ArrayList<EnemyType> enemies=new ArrayList<EnemyType>();
	ArrayList<EnemyType> returnEnemyList=new ArrayList<EnemyType>();
	
	@Before
	public void setUp() throws Exception {
		strongEnemy1.enemyId=1;
		strongEnemy1.x = 10;
		strongEnemy1.y = 20;
		strongEnemy1.currentHealth=20;
		strongEnemy2.enemyId=2;
		strongEnemy2.x = 1;
		strongEnemy2.y = 2;
		strongEnemy2.currentHealth=40;
		enemies.add(strongEnemy1);
		enemies.add(strongEnemy2);
		nnTower.range = 2;
	}

	@Test
	public void test_ATTACK_FIRST_NEAR_TOWER_ENEMY() {
		nnTower.attackStrategy=nnTower.ATTACK_FIRST_NEAR_TOWER_ENEMY;
		returnEnemyList=nnTower.calculateEnemy(nnTower,enemies,50,50,0,0);
		assertEquals(((StrongEnemy)(returnEnemyList.get(0))).enemyId,1);
	}
	
	@Test
	public void test_ATTACK_MAX_HEALTH_ENEMY() {
		nnTower.attackStrategy=nnTower.ATTACK_MAX_HEALTH_ENEMY;
		returnEnemyList=nnTower.calculateEnemy(nnTower,enemies,50,50,0,0);
		assertEquals(((StrongEnemy)(returnEnemyList.get(0))).enemyId,2);
	}
	
	@Test
	public void test_ATTACK_MIN_HEALTH_ENEMY() {
		nnTower.attackStrategy=nnTower.ATTACK_MIN_HEALTH_ENEMY;
		returnEnemyList=nnTower.calculateEnemy(nnTower,enemies,50,50,0,0);
		assertEquals(((StrongEnemy)(returnEnemyList.get(0))).enemyId,1);
	}

}
