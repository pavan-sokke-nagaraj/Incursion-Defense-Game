/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.enemyFactory.bossEnemy;
import com.IDG.playGame.EnemyPath;

/**
 * The class <code>EnemyPathTest</code> contains tests for the class
 * <code>{@link EnemyPath}</code>.
 * @author wangguan
 *
 */
public class EnemyPathTest {
	EnemyPath enemyPath = new EnemyPath();
	LinkedList<Point> copiedPath;
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
		copiedPath = new LinkedList<Point>();
		boolean pathCopied = false;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the path has been copied to copiedPath;
	 * Test method for {@link com.IDG.playGame.EnemyPath#copyPath()}.
	 */
	@Test
	public void testCopyPath() {
		assertNotNull(copiedPath);
	}

	/**
	 * Test EnemyPath constructor.
	 */
	@Test
	public void testEnemyPath() {
		assertNotNull(enemyPath);
	}

}
