/**
 * 
 */
package com.IDG.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author p_sokke
 *
 */
public class GameFileManager {
	public void loadSavedGame(String loadFileName) {
		String directory = "GameSave";
		String loadFilePath = directory + "/" + loadFileName;
		File file = new File(loadFilePath);
		// add a try catchy block ----:> fnf error
		try {
			Scanner loadScanner = new Scanner(file);
			while (loadScanner.hasNext()) {
				for(int y = 0; y < 10;y++){
					Arena.getDefaultLocale();
				}
//				for (int y = 0; y < PanelPractice.room.block.length; y++) {
//					for (int x = 0; x < PanelPractice.room.block[0].length; x++) {
//						PanelPractice.room.block[y][x].createId = loadScanner
//								.nextInt();
//					}
//				}
			}

			loadScanner.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("FNF");
			fnf.printStackTrace();
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
}
