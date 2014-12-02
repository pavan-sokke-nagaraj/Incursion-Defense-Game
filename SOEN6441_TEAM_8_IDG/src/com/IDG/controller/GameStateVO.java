/**
 * 
 */
package com.IDG.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.IDG.enemyFactory.EnemyType;
import com.IDG.mapSimulator.Tower;

/**
 * Class to hold the value objects of game to be saved and loaded during the
 * game play
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 *
 */
public class GameStateVO implements Serializable {

	/**
	 * Variable to hold number of grids
	 */
	private int gridRow;

	/**
	 * Variable to hold number of columns
	 */
	private int gridColumn;

	/**
	 * Variable to hold game vale
	 */
	private char[][] gameValue;

	/**
	 * Variable to hold game health
	 */
	private int health;

	/**
	 * Variable to hold game money
	 */
	private int money;

	/**
	 * Variable to hold playing game wave level
	 */
	private int waveLevel;

	/**
	 * variable to hold playing enemies on game
	 */
	private ArrayList<EnemyType> enemiesOnMap;

	/**
	 * Variable to hold tower details on map
	 */
	private HashMap<Integer, Tower> towerMap = new HashMap<Integer, Tower>();

	/**
	 * boolean value to hold movement of enemy
	 */
	private boolean moveEnemy;

	/**
	 * variable to hold game logs
	 */
	private StringBuffer gameLog = new StringBuffer();

	/**
	 * Variable to hold wave logs
	 */
	private StringBuffer waveLog = new StringBuffer();

	/**
	 * Variable to hold all the wave logs
	 */
	private LinkedList<StringBuffer> waveLogList = new LinkedList<StringBuffer>();

	/**
	 * Variable to hold all the tower logs
	 */
	public StringBuffer collectiveTowerlog = new StringBuffer();

	/**
	 * variable to hold the map Id being played
	 */
	public int mapid;

	/**
	 * get the current gridRow
	 * 
	 * @return current gridRow
	 */
	public int getGridRow() {
		return gridRow;
	}

	/**
	 * sets the gridRow
	 * 
	 * @param gridRow
	 *            get the current value of gridRow
	 */
	public void setGridRow(int gridRow) {
		this.gridRow = gridRow;
	}

	/**
	 * get the current gridColumn
	 * 
	 * @return current gridColumn
	 */
	public int getGridColumn() {
		return gridColumn;
	}

	/**
	 * sets the current value to gameValue
	 * 
	 * @param gameValue
	 *            set the current value to gameValue
	 */
	public void setGridColumn(int gridColumn) {
		this.gridColumn = gridColumn;
	}

	/**
	 * get the current gameValue
	 * 
	 * @return current gameValue
	 */
	public char[][] getGameValue() {
		return gameValue;
	}

	/**
	 * sets the current value to gameValue
	 * 
	 * @param gameValue
	 *            set the current value to gameValue
	 */
	public void setGameValue(char[][] gameValue) {
		this.gameValue = gameValue;
	}

	/**
	 * get the current health
	 * 
	 * @return current health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * sets the current value to
	 * 
	 * @param health
	 *            set the current value to health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * get the current money
	 * 
	 * @return current money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * sets the current value to waveLevel
	 * 
	 * @param waveLevel
	 *            set the current value to waveLevel
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * get the current waveLevel
	 * 
	 * @return current waveLevel
	 */
	public int getWaveLevel() {
		return waveLevel;
	}

	/**
	 * sets the current value to waveLevel
	 * 
	 * @param waveLevel
	 *            set the current value to waveLevel
	 */
	public void setWaveLevel(int waveLevel) {
		this.waveLevel = waveLevel;
	}

	/**
	 * get the current enemiesOnMap
	 * 
	 * @return current enemiesOnMap
	 */
	public ArrayList<EnemyType> getEnemiesOnMap() {
		return enemiesOnMap;
	}

	/**
	 * sets the current value to enemiesOnMap
	 * 
	 * @param enemiesOnMap
	 *            set the current value to enemiesOnMap
	 */
	public void setEnemiesOnMap(ArrayList<EnemyType> enemiesOnMap) {
		this.enemiesOnMap = enemiesOnMap;
	}

	/**
	 * get the current towerMap
	 * 
	 * @return current towerMap
	 */
	public HashMap<Integer, Tower> getTowerMap() {
		return towerMap;
	}

	/**
	 * sets the current value to towerMap
	 * 
	 * @param towerMap
	 *            set the current value to towerMap
	 */
	public void setTowerMap(HashMap<Integer, Tower> towerMap) {
		this.towerMap = towerMap;
	}

	/**
	 * get the current moveEnemy
	 * 
	 * @return current moveEnemy
	 */
	public boolean isMoveEnemy() {
		return moveEnemy;
	}

	/**
	 * sets the current value to moveEnemy
	 * 
	 * @param moveEnemy
	 *            set the current value to moveEnemy
	 */
	public void setMoveEnemy(boolean moveEnemy) {
		this.moveEnemy = moveEnemy;
	}

	/**
	 * get the current gameLog
	 * 
	 * @return current gameLog
	 */
	public StringBuffer getGameLog() {
		return gameLog;
	}

	/**
	 * sets the current value to gameLog
	 * 
	 * @param gameLog
	 *            set the current value to gameLog
	 */
	public void setGameLog(StringBuffer gameLog) {
		this.gameLog = gameLog;
	}

	/**
	 * get the current waveLog
	 * 
	 * @return current waveLog
	 */
	public StringBuffer getWaveLog() {
		return waveLog;
	}

	/**
	 * sets the current value to waveLog
	 * 
	 * @param waveLog
	 *            set the current value to waveLog
	 */
	public void setWaveLog(StringBuffer waveLog) {
		this.waveLog = waveLog;
	}

	/**
	 * get the current waveLogList
	 * 
	 * @return current waveLogList
	 */
	public LinkedList<StringBuffer> getWaveLogList() {
		return waveLogList;
	}

	/**
	 * sets the current value to waveLogList
	 * 
	 * @param waveLogList
	 *            set the current value to waveLogList
	 */
	public void setWaveLogList(LinkedList<StringBuffer> waveLogList) {
		this.waveLogList = waveLogList;
	}

	/**
	 * get the current collectiveTowerlog
	 * 
	 * @return current collectiveTowerlog
	 */
	public StringBuffer getCollectiveTowerlog() {
		return collectiveTowerlog;
	}

	/**
	 * sets the current value to collectiveTowerlog
	 * 
	 * @param collectiveTowerlog
	 *            set the current value to collectiveTowerlog
	 */
	public void setCollectiveTowerlog(StringBuffer collectiveTowerlog) {
		this.collectiveTowerlog = collectiveTowerlog;
	}

}
