/**
 * 
 */
package com.IDG.controller;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import com.IDG.mapSimulator.Block;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Tower;

/**
 * class to save and retrieve game files
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 *
 */
public class GameFileManager {

	/**
	 * default directory to save the game file
	 */
	static String gameDirectory = "GameSave//";
	static String tempDirectory = "temp//";
	static String gameExtension = ".IDG";
	static String towerExtension = ".TOWER";

	/**
	 * function to load a saved game
	 * 
	 * @param loadFileName
	 * @return character array represented by game map
	 */
	public static char[][] loadSavedGame(File file) {

		char a2Array[][] = new char[20][20];
		Block block[][] = new Block[20][20];
		Game game = Game.getInstance();
		if (file != null) {
			int tempRow = 0;
			int tempCol = 0;
			int row = 0;
			int column = 0;
			char a = 0;
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					String line = input.nextLine();
					if (line != null && !line.isEmpty()) {
						tempCol = line.length();
						++tempRow;
					}
				}
				input.close();
				row = tempRow;
				column = tempCol;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			block = new Block[row][column];
			a2Array = new char[row][column];
			tempRow = 0;
			tempCol = 0;
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					String line = input.nextLine();
					tempCol = line.length();
					for (int i = 0; i < tempCol; i++) {
						a2Array[tempRow][i] = line.charAt(i);
					}
					++tempRow;
				}
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					a = a2Array[i][j];
				}
			}
			return a2Array;
		} else
			return null;

	}

	/**
	 * function to save the game files
	 * 
	 * @param block
	 *            character array to be saved
	 */
	public static void saveGameFile(Block[][] block) {
		JFileChooser fileChooser = new JFileChooser();
		Game game = Game.getInstance();
		int saveValue = fileChooser.showSaveDialog(game);
		if (saveValue == JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getName();
			String directory = fileChooser.getCurrentDirectory().toString();
			String absolutePath = directory + "\\" + filename;
			File file = new File(absolutePath);
			try {
				BufferedWriter output = new BufferedWriter(new FileWriter(file));
				for (int i = 0; i < block.length; i++) {
					for (int j = 0; j < block[0].length; j++) {
						char createId = block[i][j].createId;
						output.write(createId);
					}
					if (i < block.length - 1)
						output.newLine();
				}
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * function to save the serialized object with its index
	 * 
	 * @param towerBlocks
	 *            the object to be saved
	 * @param x
	 *            x coordinate of the object in the object array
	 * @param y
	 *            y coordinate of the object in the object array
	 */
	public static void saveTowerObject(Tower towerBlocks, int x, int y) {
		try {

			String fileName = tempDirectory
					+ Game.getInstance().getPlayingMapName() + x + y
					+ towerExtension;
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(towerBlocks); // write Tower object
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * function to get the serialized object with its index
	 * 
	 * @param x
	 *            x coordinate of the object in the object array
	 * @param y
	 *            y coordinate of the object in the object array
	 * @return object to be retrieved
	 */
	public static Tower getTowerObject(int x, int y) {
		Tower tower = new Tower();
		try {
			String fileName = tempDirectory
					+ Game.getInstance().getPlayingMapName() + x + y
					+ towerExtension;
			FileInputStream fos = new FileInputStream(fileName);
			ObjectInputStream oip = new ObjectInputStream(fos);
			tower = (Tower) oip.readObject();
			oip.close();
		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		return tower;
	}

	/**
	 * function to delete the serialized object with its index
	 * 
	 * @param tower
	 *            the object to be deleted
	 * @param x
	 *            x coordinate of the object in the object array
	 * @param y
	 *            y coordinate of the object in the object array
	 */
	public static void deleteTowerObject(Tower tower, int x, int y) {
		File file = new File("GameSave\\GameSave" + x + y);
		file.delete();
	}

	public static void deleteGameTowers() {
		File directory = new File(tempDirectory);
		for (File file : directory.listFiles()) {
			System.out.println(file.getName());
			file.delete();
		}
	}

	public void saveGameState(MapSimulatorView mapSimulatorView) {

		GameStateVO gameStateVO = new GameStateVO();
		gameStateVO.setGridRow(mapSimulatorView.gridRow);
		gameStateVO.setGridColumn(mapSimulatorView.gridColumn);
		gameStateVO.setMoney(mapSimulatorView.power);
		gameStateVO.setHealth(mapSimulatorView.health);
		gameStateVO.setGameValue(mapSimulatorView.gameValue);
		gameStateVO.setWaveLevel(mapSimulatorView.waveLevel);
		gameStateVO.setEnemiesOnMap(mapSimulatorView.enemiesOnMap);
		gameStateVO.setMoveEnemy(mapSimulatorView.moveEnemy);

		for (int i = 0; i < mapSimulatorView.gridRow; i++) {
			for (int j = 0; j < mapSimulatorView.gridColumn; j++) {
				char tileId = mapSimulatorView.gameValue[i][j];
				if (tileId == 'R' || tileId == 'G' || tileId == 'B') {
					Tower tower = getTowerObject(i, j);
					int index = Integer.parseInt(Integer.toString(i)
							+ Integer.toString(j));
					gameStateVO.getTowerMap().put(index, tower);
				}
			}
		}

		JFileChooser fileChooser = new JFileChooser();
		int saveValue = fileChooser.showSaveDialog(Game.getInstance());
		if (saveValue == JFileChooser.APPROVE_OPTION) {
			String fileName = fileChooser.getSelectedFile().getName();
			String directory = fileChooser.getCurrentDirectory().toString();
			String absolutePath = directory + "\\" + fileName + gameExtension;
			try {
				FileOutputStream fos = new FileOutputStream(absolutePath);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(mapSimulatorView); // write Tower object
				oos.close();

				XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
						new FileOutputStream(absolutePath)));
				encoder.writeObject(gameStateVO);
				encoder.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public MapSimulatorView loadGameState(MapSimulatorView mapSimulatorView) {
		GameStateVO gameStateVO = new GameStateVO();
		JFileChooser fileChooser = new JFileChooser();
		int openValue = fileChooser.showOpenDialog(Game.getInstance());
		if (openValue == JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getName();
			String directory = fileChooser.getCurrentDirectory().toString();
			String absolutePath = directory + "\\" + filename;
			try {

				XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
						new FileInputStream(absolutePath)));
				gameStateVO = (GameStateVO) decoder.readObject();
				decoder.close();

				mapSimulatorView.power = gameStateVO.getMoney();
				mapSimulatorView.health = gameStateVO.getHealth();
				mapSimulatorView.gridRow = gameStateVO.getGridRow();
				mapSimulatorView.gridColumn = gameStateVO.getGridColumn();
				mapSimulatorView.gameValue = gameStateVO.getGameValue();
				mapSimulatorView.waveLevel = gameStateVO.getWaveLevel();
				mapSimulatorView.enemiesOnMap = gameStateVO.getEnemiesOnMap();
				mapSimulatorView.moveEnemy = gameStateVO.isMoveEnemy();

				for (int i = 0; i < mapSimulatorView.gridRow; i++) {
					for (int j = 0; j < mapSimulatorView.gridColumn; j++) {
						char tileId = mapSimulatorView.gameValue[i][j];
						if (tileId == 'R' || tileId == 'G' || tileId == 'B') {
							int index = Integer.parseInt(Integer.toString(i)
									+ Integer.toString(j));
							Tower tower = gameStateVO.getTowerMap().get(index);
							saveTowerObject(tower, i, j);
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return mapSimulatorView;
	}
}
