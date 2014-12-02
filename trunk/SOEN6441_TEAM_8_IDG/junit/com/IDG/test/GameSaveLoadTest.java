/**
 * 
 */
package com.IDG.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.IDG.controller.Game;
import com.IDG.controller.GameFileManager;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Tower;

/**
 * @author p_sokke
 *
 */
public class GameSaveLoadTest {

	public int testMapId = 282;
	public int testPower = Game.getInstance().INITIAL_GAME_POWER;
	public int testHealth = Game.getInstance().INITIAL_GAME_HEALTH;
	public int testWaveLevel = 2;
	public char[][] testGameValue = new char[][] { { 'S', '*', '*' },
			{ '*', '-', '*' }, { '*', '*', 'E' } };

	public StringBuffer testWaveLevelLog = new StringBuffer();
	public StringBuffer testGameLog = new StringBuffer();
	public StringBuffer testCollectiveTowerlog = new StringBuffer();
	public StringBuffer testIndividualTowerlog = new StringBuffer();

	/**
	 * junit method to test save and load of tower log
	 */
	@Test
	public void testSaveLoadIndividualTowerLog() {
		testIndividualTowerlog = new StringBuffer("individualTowerlog TEST");
		Tower testTower = new Tower();
		testTower.individualTowerlog = testIndividualTowerlog;

		Game.getInstance().setPlayingMapName("testTower");
		GameFileManager gameFileManager = new GameFileManager();
		gameFileManager.saveTowerObject(testTower, 1, 1);

		testTower = gameFileManager.getTowerObject(1, 1);
		assertTrue(testTower.individualTowerlog.toString().equals(
				testIndividualTowerlog.toString()));
	}

	/**
	 * junit method to test save and load of game state
	 */
	@Test
	public void testSaveLoadGameState() {
		MapSimulatorView mapSimulatorView = new MapSimulatorView();
		mapSimulatorView.power = testPower;
		mapSimulatorView.health = testHealth;
		mapSimulatorView.waveLevel = testWaveLevel;
		mapSimulatorView.mapid = testMapId;
		mapSimulatorView.gameValue = testGameValue;
		GameFileManager gameFileManager = new GameFileManager();
		gameFileManager.saveGameState(mapSimulatorView);

		mapSimulatorView = new MapSimulatorView();
		mapSimulatorView = gameFileManager.loadGameState(mapSimulatorView);
		assertNotNull(mapSimulatorView);
		assertTrue(mapSimulatorView.power == testPower);
		assertTrue(mapSimulatorView.health == testHealth);
		assertTrue(mapSimulatorView.waveLevel == testWaveLevel);
		testGameValue(mapSimulatorView.gameValue);
	}

	/**
	 * junit method to test save and load of game value
	 * 
	 * @param loadGameValue
	 *            loaded game value
	 */
	public void testGameValue(char loadGameValue[][]) {
		for (int i = 0; i < loadGameValue.length; i++) {
			for (int j = 0; j < loadGameValue[0].length; j++) {
				assertTrue(loadGameValue[i][j] == testGameValue[i][j]);
			}
		}
	}

	/**
	 * junit method to test save and load of game log
	 */
	@Test
	public void testSaveLoadGameLog() {
		testWaveLevelLog = new StringBuffer("LEVEL LOG TEST");
		testGameLog = new StringBuffer("gameLog TEST");
		testCollectiveTowerlog = new StringBuffer("collectiveTowerlog TEST");

		MapSimulatorView mapSimulatorView = new MapSimulatorView();
		mapSimulatorView.mapid = testMapId;

		mapSimulatorView.levelLog = testWaveLevelLog;
		mapSimulatorView.gameLog = testGameLog;
		mapSimulatorView.collectiveTowerlog = testCollectiveTowerlog;

		GameFileManager gameFileManager = new GameFileManager();
		gameFileManager.saveGameState(mapSimulatorView);

		mapSimulatorView = new MapSimulatorView();
		mapSimulatorView = gameFileManager.loadGameState(mapSimulatorView);
		assertTrue(mapSimulatorView.levelLog.toString().equals(
				testWaveLevelLog.toString()));
		assertTrue(mapSimulatorView.gameLog.toString().equals(
				testGameLog.toString()));
		assertTrue(mapSimulatorView.collectiveTowerlog.toString().equals(
				testCollectiveTowerlog.toString()));
	}

	@Test
	public void testSaveLoadTowerLog() {
		testIndividualTowerlog = new StringBuffer("individualTowerlog TEST");
		Tower testTower = new Tower();
		testTower.individualTowerlog = testIndividualTowerlog;

		Game.getInstance().setPlayingMapName("testTower");
		GameFileManager gameFileManager = new GameFileManager();
		gameFileManager.saveTowerObject(testTower, 1, 1);

		testTower = gameFileManager.getTowerObject(1, 1);
		assertTrue(testTower.individualTowerlog.toString().equals(
				testIndividualTowerlog.toString()));
	}

	@Test
	public void testSaveLoadWaveLog() {
		testWaveLevelLog = new StringBuffer("LEVEL LOG TEST");

		MapSimulatorView mapSimulatorView = new MapSimulatorView();
		mapSimulatorView.mapid = testMapId;

		mapSimulatorView.levelLog = testWaveLevelLog;

		GameFileManager gameFileManager = new GameFileManager();
		gameFileManager.saveGameState(mapSimulatorView);

		mapSimulatorView = new MapSimulatorView();
		mapSimulatorView = gameFileManager.loadGameState(mapSimulatorView);
		assertTrue(mapSimulatorView.levelLog.toString().equals(
				testWaveLevelLog.toString()));
	}

}
