/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.enemyFactory.EnemyType;
import com.IDG.enemyFactory.StrongEnemy;
import com.IDG.mapSimulator.Tower;

/**
 * The class <code>TowerDistanceTest</code> contains tests for the class
 * <code>{@link Tower}</code>.
 * @author wangguan
 *
 */
public class TowerDistanceTest {

	
	Tower nnTower = new Tower();
	StrongEnemy strongEnemy = new StrongEnemy();
	EnemyType[] enemiesInRange=new EnemyType[strongEnemy.enemySize];
	ArrayList<EnemyType> returnEnemyList=new ArrayList<EnemyType>();
	double distance =0.0;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		strongEnemy.x = 1;
		strongEnemy.y = 1;
		nnTower.range = 2;
		distance = nnTower.distance(strongEnemy, 50, 50);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the distance of enemy and the tower is 70
	 */
	@Test
	public void testDistance() {
		assertEquals(70, distance, 1);
	}
	/**
	 * Test if the enemy and in the range of tower
	 */
	@Test
	public void testCalculateEnemy() {
		assertNotNull(enemiesInRange);
	}
	/**
	 * Test when the enemy has been shot, they go to returnEnemyList
	 */
	@Test
	public void testCalculateDeadEnemy() {
		assertNotNull(returnEnemyList);
	}

}
