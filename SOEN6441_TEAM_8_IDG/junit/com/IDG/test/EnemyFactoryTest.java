/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.enemyFactory.EnemyFactory;

/**
 * The class <code>EnemyFactoryTest</code> contains tests for the class
 * <code>{@link EnemyFactory}</code>.
 * @author wangguan
 *
 */
public class EnemyFactoryTest {
	
	private EnemyFactory enemyType;
	
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
		enemyType = new EnemyFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * If give the enemyType is "Null" then the object will given SmallEnemy.class
	 * Test method for {@link com.IDG.enemyFactory.EnemyFactory#getEnemyfromFactory(java.lang.String, int, java.util.LinkedList, int, int, int, int, int, int)}.
	 */
	@Test
	public void testGetEnemyfromFactory() {
		
		assertNotNull(enemyType); 
	}

}
