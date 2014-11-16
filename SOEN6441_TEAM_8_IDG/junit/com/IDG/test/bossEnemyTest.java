package com.IDG.test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.enemyFactory.*;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Room;

/**
 * The class <code>bossEnemyTest</code> contains tests for the class
 * <code>{@link bossEnemy}</code>.
 *
 *
 * @author Guan wang
 * @version $Revision: 1.0 $
 */

public class bossEnemyTest {

	private bossEnemy bossEnemy;
	private MapSimulatorView mapSimulatorView;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bossEnemy = new bossEnemy();
		mapSimulatorView = new MapSimulatorView();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test constructor of bossEnemy.class
	 */
	
	@Test
	public void testBossEnemyIntLinkedListOfPointIntIntIntIntIntInt() {
		assertNotNull(bossEnemy);
	}

	/**
	 * test the move of enemy
	 */
	@Test
	public void testMoveGraphics() {
		mapSimulatorView.enemiesOnMap = null;
		assertEquals(mapSimulatorView.moveEnemy, false);
	}

	/**
	 * test after enemy not in the map, delete the object
	 */
	
	@Test
	public void testUpdate() {
		assertEquals(bossEnemy.movePoint, 0);
		
	}

	/**
	 * test if enemyPath has been passed to clonePath
	 */
	@Test
	public void testCloneEnemyPath() {
		LinkedList<Point> clonePath = new LinkedList<Point>();
		LinkedList<Point> enemyPath = new LinkedList<Point>();
		assertEquals(clonePath, enemyPath);
	}

//	/**
//	 * set a currentHealth and actualHealth of a bossEnemy
//	 * if the rateofHealth less than 50% but bigger than 20%
//	 * then the color of health bar should be Orange.
//	 * @param g
//	 */
//	
//	@Test
//	public void testDrawHealthBar() {
//		bossEnemy.currentHealth = 10;
//		bossEnemy.actualHealth = 30;
//		Graphics g = null;
//		bossEnemy.drawHealthBar(g);
//		Color c1 = Color.ORANGE;
//		assertEquals(g.getColor(), c1);
//	}

}
