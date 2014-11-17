/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.IDG.enemyFactory.EnemyType;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Tower;

/**
 * @author wangguan
 *
 */
public class MapSimulatorViewTest {

	MapSimulatorView mapSimulatorView = new MapSimulatorView();
	Tower tower = new Tower();
	Thread thread;
	int i = 3, j = 3;
	
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
		thread = new Thread();
		tower.hasHitOnce = true;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test if there is a constructor has been created
	 * Test method for {@link com.IDG.mapSimulator.MapSimulatorView#MapSimulatorView()}.
	 */
	@Test
	public void testMapSimulatorView() {
		assertNotNull(mapSimulatorView);
	}
	
	/**
	 * Test if there is a thread has been created
	 * Test method for {@link com.IDG.mapSimulator.MapSimulatorView#MapSimulatorView()}.
	 */
	@Test
	public void testThread() {
		assertNotNull(thread);
	}
	
}
