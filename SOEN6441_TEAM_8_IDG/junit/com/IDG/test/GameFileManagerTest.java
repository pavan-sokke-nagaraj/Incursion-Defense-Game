package com.IDG.test;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.IDG.controller.GameFileManager;
import com.IDG.mapSimulator.Block;
import com.IDG.mapSimulator.Tower;
import com.IDG.test.GameFileManagerTest;

/**
 * The class <code>GameFileManagerTest</code> contains tests for the class
 * <code>{@link GameFileManager}</code>.
 * 
 * @version Revision: 1.0
 */
public class GameFileManagerTest {
	/**
	 * Run the GameFileManager() constructor test.
	 *
	 *
	 */
	@Test
	public void testGameFileManager_1() throws Exception {
		GameFileManager result = new GameFileManager();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void deleteTowerObject(Tower,int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testDeleteTowerObject_1() throws Exception {
		Tower tower = new Tower();
		int x = 1;
		int y = 1;

		GameFileManager.deleteTowerObject(tower, x, y);

	}

	/**
	 * Run the Tower getTowerObject(int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testGetTowerObject_1() throws Exception {
		int x = 1;
		int y = 1;

		Tower result = GameFileManager.getTowerObject(x, y);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Tower getTowerObject(int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testGetTowerObject_2() throws Exception {
		int x = 1;
		int y = 1;

		Tower result = GameFileManager.getTowerObject(x, y);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Tower getTowerObject(int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_1() throws Exception {
		File file = new File("Resource/DefaultMaps/GameMatrix/Map167.txt");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertNotEquals(0, result.length);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_2() throws Exception {
		File file = new File("Resource/DefaultMaps/GameMatrix/Map167.txt");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertNotEquals(0, result.length);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_3() throws Exception {
		File file = new File("Resource/DefaultMaps/GameMatrix/Map167.txt");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertNotEquals(0, result.length);
	}

		/**
	 * Run the void saveGameFile(Block[][]) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testSaveTowerObject_1() throws Exception {
		Tower towerBlocks = new Tower();
		int x = 1;
		int y = 1;

		GameFileManager.saveTowerObject(towerBlocks, x, y);

		// add additional test code here
	}

	/**
	 * Run the void saveTowerObject(Tower,int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testSaveTowerObject_2() throws Exception {
		Tower towerBlocks = new Tower();
		int x = 1;
		int y = 1;

		GameFileManager.saveTowerObject(towerBlocks, x, y);

		// add additional test code here
	}

	/**
	 * Run the void saveTowerObject(Tower,int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */

	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 *
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 *
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameFileManagerTest.class);
	}
}
