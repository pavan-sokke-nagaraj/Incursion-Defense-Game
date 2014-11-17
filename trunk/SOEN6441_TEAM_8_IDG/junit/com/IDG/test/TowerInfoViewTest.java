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

import com.IDG.mapSimulator.Tower;
import com.IDG.mapSimulator.TowerInfoView;

/**
 * The class <code>TowerInfoViewTest</code> contains tests for the class
 * <code>{@link TowerInfoView}</code>.
 * @author wangguan
 *
 */
public class TowerInfoViewTest {
	Tower tower = new Tower();
	String attackType="";
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
		tower.towerId = 's';
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the TowerId is 's' the attackType of the tower should be not be null
	 * Test method for {@link com.IDG.mapSimulator.Tower#drawTowerInformation(java.awt.Graphics)}.
	 */
	@Test
	public void testDrawTowerInformation() {
		assertNotNull(attackType);
	}

}
