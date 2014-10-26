/**
 * 
 */
package com.IDG.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * this class manages the saving and loading pf the maps created by users 
 * the directory is specified as a string 
 * @author p_sokke
 *
 */
public class GameFileManager {
	static String directory = "GameSave";
/**
 * loading a saved game on the directory 
 * @param loadFileName takes the path to the game to be 
 * @author reem
 * 
 */
	public void loadSavedGame(String loadFileName) {

		String loadFilePath = directory + "/" + loadFileName;
		File file = new File(loadFilePath);
		// add a try catchy block ----:> fnf error
		try {
			Scanner loadScanner = new Scanner(file);
			while (loadScanner.hasNext()) {
				for (int y = 0; y < 10; y++) {
					// Arena.getDefaultLocale();
				}
				// for (int y = 0; y < PanelPractice.room.block.length; y++) {
				// for (int x = 0; x < PanelPractice.room.block[0].length; x++)
				// {
				// PanelPractice.room.block[y][x].createId = loadScanner
				// .nextInt();
				// }
				// }
			}

			loadScanner.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("FNF");
			fnf.printStackTrace();
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
/**
 * saving a game to a file it takes a 2 dimensional array of bits so the maps is saved as a series of digits 
 * @param block the maps to ba saves represented as a 2 D array
 * 
 * */
	public static void saveGameFile(Block[][] block) {

		JFileChooser fileChooser = new JFileChooser();
		int saveValue = fileChooser.showSaveDialog(World.getInstance());
		if (saveValue == JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().getName();
			String directory = fileChooser.getCurrentDirectory().toString();
			String absolutePath = directory + "\\" + filename;
			File file = new File(absolutePath);
			try {
				BufferedWriter output = new BufferedWriter(new FileWriter(file));
				for (int i = 0; i < block.length; i++) {
					for (int j = 0; j < block[0].length; j++) {
						// System.out.print(block[i][j].createId);
						Integer createId = block[i][j].createId;
						output.write(createId.toString());
					}
					if(i<block.length - 1)
						output.newLine();
					// System.out.println();
				}
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
