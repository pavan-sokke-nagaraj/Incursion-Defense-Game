package com.IDG.controller;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;
import com.IDG.mapSimulator.Block;
import com.IDG.mapSimulator.Tower;

/**
 * The class <code>GameFileManagerTest</code> contains tests for the class <code>{@link GameFileManager}</code>.

 * @version Revision: 1.0
 */
public class GameFileManagerTest {
	/**
	 * Run the GameFileManager() constructor test.
	 *
	 *
	 */
	@Test
	public void testGameFileManager_1()
		throws Exception {
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
	public void testDeleteTowerObject_1()
		throws Exception {
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
	public void testGetTowerObject_1()
		throws Exception {
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
	public void testGetTowerObject_2()
		throws Exception {
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
	public void testGetTowerObject_3()
		throws Exception {
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
	public void testGetTowerObject_4()
		throws Exception {
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
	public void testGetTowerObject_5()
		throws Exception {
		int x = 1;
		int y = 1;

		Tower result = GameFileManager.getTowerObject(x, y);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_1()
		throws Exception {
		File file = new File("");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_2()
		throws Exception {
		File file = new File("");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_3()
		throws Exception {
		File file = new File("");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testLoadSavedGame_4()
		throws Exception {
		File file = new File("");

		char[][] result = GameFileManager.loadSavedGame(file);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	/**
	 * Run the char[][] loadSavedGame(File) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	
	
	@Test
	public void testSaveGameFile_1()
		throws Exception {
		Block[][] block = new Block[][] {};

		GameFileManager.saveGameFile(block);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
	}

	/**
	 * Run the void saveGameFile(Block[][]) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testSaveGameFile_2()
		throws Exception {
		Block[][] block = new Block[][] {};

		GameFileManager.saveGameFile(block);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
	}

	/**
	 * Run the void saveGameFile(Block[][]) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testSaveGameFile_3()
		throws Exception {
		Block[][] block = new Block[][] {};

		GameFileManager.saveGameFile(block);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
	}

	/**
	 * Run the void saveGameFile(Block[][]) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	
	/**
	 * Run the void saveTowerObject(Tower,int,int) method test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testSaveTowerObject_1()
		throws Exception {
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
	public void testSaveTowerObject_2()
		throws Exception {
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
	public void testSaveTowerObject_3()
		throws Exception {
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
	public void testSaveTowerObject_4()
		throws Exception {
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
	public void testSaveTowerObject_5()
		throws Exception {
		Tower towerBlocks = new Tower();
		int x = 1;
		int y = 1;

		GameFileManager.saveTowerObject(towerBlocks, x, y);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 *
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 *
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 *
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameFileManagerTest.class);
	}
}