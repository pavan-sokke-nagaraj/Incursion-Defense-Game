/**
 * 
 */
package com.IDG.controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.IDG.mapBuilder.MapBuilderController;
import com.IDG.mapBuilder.MapDetails;
import com.IDG.mapSimulator.Arsenal;
import com.IDG.mapSimulator.Block;
import com.IDG.mapSimulator.MapSimulatorView;

/**
 * This view renders the main panel viewer for the application including the
 * header menu system and the windows of display
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build 1
 * @since Build 1
 *
 */
public class LayoutManager {

	private JMenuBar menu = new JMenuBar();
	private JMenu fileMenu = new JMenu("Game");
	private JTabbedPane tab = new JTabbedPane();
	private MapSimulatorView mapSimulatorView = new MapSimulatorView();
	public MapDetails showHighScore= new MapDetails();
	public static ArrayList<Integer> passvalue= new ArrayList(5);
	public static int mapid;
	public static boolean saveClicked=false;
	public static boolean loadClicked=false;
	public LayoutManager() {
		// populates the file selector and add to menu tab
		// populateFileHeader();
		menu.add(fileMenu);
		fileMenu.add(fileLoad);
		fileMenu.add(saveGame);
		fileMenu.add(loadGame);

		fileMenu.addSeparator();
		// populate the tabs
		populateTabs();
	}
	public static String fileType=null,fileName=null;
	public JMenuBar getMenuBar() {
		return menu;
	}

	public JTabbedPane getTabs() {
		return tab;
	}

	JMenuItem fileLoad = new JMenuItem(new AbstractAction("Create/Load Map") {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			new MapBuilderController();
		}
	});

	/**
	 * This method populate saved map file header
	 */
	public void populateFileHeader() {

		if (Game.getInstance().Mode == Game.GameMode.Simulator) {
			Scanner sc = null;
			String line1 = null;
			try {
				sc = new Scanner(new File(
						"Resource/CustomMaps/ScreenShots/Metadata.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while (sc.hasNextLine()) {
				line1 = sc.nextLine().toString().trim();
				if (line1 != null && !line1.isEmpty()) {
					System.out.println("csdsadsadsadsadsad" + line1);
					fileName = line1.substring(0, line1.indexOf(","));
					fileType = line1.substring(line1.indexOf(",") + 1);
				}
			}
			GameFileManager gameFileMananger = new GameFileManager();
			File tempFile = new File("Resource/" + fileType + "/GameMatrix/"
					+ fileName);
			char[][] gameValue = gameFileMananger.loadSavedGame(tempFile);
			if (gameValue != null) {
				Game.getInstance().setPlayingMapName(
						fileName.substring(0, fileName.lastIndexOf('.')));
				mapid=Integer.parseInt(LayoutManager.fileName.substring(LayoutManager.fileName.lastIndexOf("p") + 1, LayoutManager.fileName.indexOf(".")));
				showHighScore.mapid=mapid;
				showHighScore=showHighScore.readFromFile(showHighScore);
				passvalue=showHighScore.highscore;
				mapSimulatorView = new MapSimulatorView();
				mapSimulatorView.gameValue = gameValue;
				mapSimulatorView.gridRow = gameValue.length;
				mapSimulatorView.gridColumn = gameValue[0].length;
				mapSimulatorView.room.block = new Block[gameValue.length][gameValue[0].length];
				mapSimulatorView.arsenal = new Arsenal();
				mapSimulatorView.power = Game.getInstance().INITIAL_GAME_POWER;
			}
		}
	}

	/**
	 * The function to populate Editor tab and simulator tab
	 */
	private void populateTabs() {
		// Add our tab elements to them
		tab.addTab("PLAY GAME", mapSimulatorView);

		// Add a listener to the tabs
		tab.addChangeListener(new ChangeListener() {

			/**
			 * A function that handles the state changed
			 * 
			 * @param event
			 *            The event that caused this change of state
			 */
			@Override
			public void stateChanged(ChangeEvent event) {

				int tabSelectedIndex = ((JTabbedPane) event.getSource())
						.getSelectedIndex();
				if (tabSelectedIndex == 0) {
					Game.getInstance().Mode = Game.GameMode.Editor;
				} else if (tabSelectedIndex == 1) {
					Game.getInstance().Mode = Game.GameMode.Simulator;
				}
			}

		});
	}

	JMenuItem saveGame = new JMenuItem(new AbstractAction("Save Game") {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			if (Game.getInstance().Mode == Game.GameMode.Simulator) {
				GameFileManager gameFileManager = new GameFileManager();
				gameFileManager.saveGameState(mapSimulatorView);
				saveClicked=true;
			}
		}
	});

	JMenuItem loadGame = new JMenuItem(new AbstractAction("Load Game") {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Calendar time = Calendar.getInstance();
			if (Game.getInstance().Mode == Game.GameMode.Simulator) {
				GameFileManager gameFileManager = new GameFileManager();
				mapSimulatorView = gameFileManager
						.loadGameState(mapSimulatorView);
				if(mapSimulatorView!=null)
				{
				loadClicked=true;
				LayoutManager.mapid=mapSimulatorView.mapid;
				showHighScore.mapid=LayoutManager.mapid;
				showHighScore=showHighScore.readFromFile(showHighScore);
				Date date = new Date();
				showHighScore.lastPlayedTime.add(time.getTime());
				LayoutManager.passvalue=showHighScore.highscore;
				showHighScore.writeToFile(showHighScore);
				}
			}
		}
	});
}
