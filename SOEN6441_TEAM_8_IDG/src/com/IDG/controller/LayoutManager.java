/**
 * 
 */
package com.IDG.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

	/**
	 * The header menu
	 */
	private JMenuBar menu = new JMenuBar();

	/**
	 * The File menu
	 */
	private JMenu fileMenu = new JMenu("File");

	/**
	 * The set of tabs to allow the user to switch between different modes in
	 * the application
	 */
	private JTabbedPane tab = new JTabbedPane();

	/**
	 * The panel that keeps the Map Editor
	 */
	private MapEditorView mapEditorView = new MapEditorView();

	/**
	 * The panel that simulates the game
	 */
	private MapSimulatorView mapSimulatorView = new MapSimulatorView();

	/**
	 * The constructor initializes the layout properties and generates the
	 * actions that can be performed
	 */
	public LayoutManager() {
		// populates the file selector and add to menu tab
		populateFileHeader();
		menu.add(fileMenu);
		// populate the tabs
		populateTabs();
	}

	/**
	 * Gets the menu headers
	 * 
	 * @return Menu header
	 */
	public JMenuBar getMenuBar() {
		return menu;
	}

	/**
	 * Gets the tab sets
	 * 
	 * @return A set of Tabs
	 */
	public JTabbedPane getTabs() {
		return tab;
	}

	/**
	 * The function which populates the file menu entries
	 */
	private void populateFileHeader() {

		// Create the File -> Load entry in the menu and associate an
		// actionEvent, such that when clicked it will call a event
		JMenuItem fileLoad = new JMenuItem(new AbstractAction("Load") {

			// Override the default action and redirect it to the controller
			// responsible

			/**
			 * The action that is performed when we click the load option
			 * 
			 * @param actionEvent
			 *            The event that triggered this action to occur
			 */
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				if (Game.Mode == Game.GameMode.Simulator) {
					GameFileManager gameFileMananger = new GameFileManager();
					char[][] gameValue = gameFileMananger.loadSavedGame("");
					MapSimulatorView.gameValue = gameValue;
					MapSimulatorView.gridRow = gameValue.length;
					MapSimulatorView.gridColumn = gameValue[0].length;
					MapSimulatorView.room.block = new Block[gameValue.length][gameValue[0].length];
				}
			}
		});
		fileMenu.add(fileLoad);

		JMenuItem fileSave = new JMenuItem(new AbstractAction("Save") {

			/**
			 * Performs the action when a user clicks the Save option in the
			 * menu
			 * 
			 * @param actionEvent
			 *            The event that triggered this action to occur
			 */
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("Save Click");
				int mapHeight = mapEditorView.gridRow;
				int mapWidth = mapEditorView.gridColumn;
				Block block[][] = mapEditorView.room.block;
				GameFileManager.saveGameFile(block);
			}
		});
		fileMenu.add(fileSave);
		fileMenu.addSeparator();
		JMenuItem fileExit = new JMenuItem(new AbstractAction("Exit") {

			/**
			 * Performs the action when a user clicks the Exit option in the
			 * menu
			 * 
			 * @param actionEvent
			 *            The event that triggered this action to occur
			 */
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
			}
		});
		fileMenu.add(fileExit);
	}

	/**
	 * The function to populate Editor tab and simulator tab
	 */
	private void populateTabs() {
		// Add our tab elements to them
		tab.addTab("Editor", mapEditorView);
		tab.addTab("Simulator", mapSimulatorView);

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
				System.out.println("tabSelectedIndex: \t" + tabSelectedIndex);
				if (tabSelectedIndex == 0) {
					Game.Mode = Game.GameMode.Editor;
				} else if (tabSelectedIndex == 1) {
					Game.Mode = Game.GameMode.Simulator;
				}
				// rebuildLayout();
			}

		});
	}
	// private void rebuildLayout() {
	// if (World.Mode == WorldMode.Simulator)
	// mapEditorView.removeAll();
	// else if (World.Mode == WorldMode.Editor)
	// mapSimulatorView.removeAll();
	// }
}
