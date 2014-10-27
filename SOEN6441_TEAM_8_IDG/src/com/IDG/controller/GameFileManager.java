/**
 * 
 */
package com.IDG.controller;

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
	static String directory = "GameSave";

	/**
	 * function to load a saved game
	 * 
	 * @param loadFileName
	 * @return character array represented by game map
	 */
	public static char[][] loadSavedGame(String loadFileName) {

		JFileChooser fileChooser = new JFileChooser();
		char a2Array[][] = new char[20][20];
		Block block[][] = new Block[20][20];
		Game game = new Game();
		int openValue = fileChooser.showOpenDialog(game);
		if (openValue == JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getName();
			String directory = fileChooser.getCurrentDirectory().toString();
			String absolutePath = directory + "\\" + filename;
			File file = new File(absolutePath);
			int tempRow = 0;
			int tempCol = 0;
			int row = 0;
			int column = 0;
			char a = 0;
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					String line = input.nextLine();
					tempCol = line.length();
					++tempRow;
				}
				input.close();
				row = tempRow;
				column = tempCol;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("ROW:\t" + row);
			System.out.println("COLUMN:\t" + column);
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

		}
		return a2Array;
	}

	/**
	 * function to save the game files
	 * 
	 * @param block
	 *            character array to be saved
	 */
	public static void saveGameFile(Block[][] block) {
		JFileChooser fileChooser = new JFileChooser();
		Game game = new Game();
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
			System.out.println("save");
			FileOutputStream fos = new FileOutputStream("GameSave\\GameSave"
					+ x + y);
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
			System.out.println("save");
			FileInputStream fos = new FileInputStream("GameSave\\GameSave" + x
					+ y);
			ObjectInputStream oip = new ObjectInputStream(fos);
			tower = (Tower) oip.readObject();
			oip.close();
		} catch (Exception ex) {
			ex.printStackTrace();
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
}