/**
 * 
 */
package com.IDG.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.IDG.enemyFactory.EnemyType;
import com.IDG.mapSimulator.Tower;

/**
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 *
 */
public class GameStateVO implements Serializable {

	private int gridRow;

	private int gridColumn;

	private char[][] gameValue;

	private int health;

	private int money;

	private int waveLevel;

	private ArrayList<EnemyType> enemiesOnMap;

	private HashMap<Integer, Tower> towerMap = new HashMap<Integer, Tower>();

	private boolean moveEnemy;

	public HashMap<Integer, Tower> getTowerMap() {
		return towerMap;
	}

	public void setTowerMap(HashMap<Integer, Tower> towerMap) {
		this.towerMap = towerMap;
	}

	public boolean isMoveEnemy() {
		return moveEnemy;
	}

	public void setMoveEnemy(boolean moveEnemy) {
		this.moveEnemy = moveEnemy;
	}

	public ArrayList<EnemyType> getEnemiesOnMap() {
		return enemiesOnMap;
	}

	public void setEnemiesOnMap(ArrayList<EnemyType> enemiesOnMap) {
		this.enemiesOnMap = enemiesOnMap;
	}

	public int getWaveLevel() {
		return waveLevel;
	}

	public void setWaveLevel(int waveLevel) {
		this.waveLevel = waveLevel;
	}

	public int getGridRow() {
		return gridRow;
	}

	public void setGridRow(int gridRow) {
		this.gridRow = gridRow;
	}

	public int getGridColumn() {
		return gridColumn;
	}

	public void setGridColumn(int gridColumn) {
		this.gridColumn = gridColumn;
	}

	public char[][] getGameValue() {
		return gameValue;
	}

	public void setGameValue(char[][] gameValue) {
		this.gameValue = gameValue;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
