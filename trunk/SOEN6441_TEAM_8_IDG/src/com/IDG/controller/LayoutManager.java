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

import com.IDG.controller.World.WorldMode;

/**
 * This view renders the main panel viewer for the application including the
 * header menu system and the windows of display
 * 
 * @author p_sokke
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
	 * The panel that houses the Map Editor
	 */
	private MapEditorView mapEditorView = new MapEditorView();

	/**
	 * The panel that houses the Simulator
	 */
	private MapSimulatorView mapSimulatorView = new MapSimulatorView();

	public LayoutManager() {

		// Builds the menu
		BuildMenu();
	}

	public JMenuBar getMenuBar() {
		return menu;
	}

	public JTabbedPane getTabs() {
		return tab;
	}

	private void BuildMenu() {

		// populates the file selector
		populateFileHeader();
		menu.add(fileMenu);

		// populate the tabs
		populateTabs();

		if (WorldMode.Editor == World.Mode) {
			renderMapEditor();
		} else if (WorldMode.Simulator == World.Mode) {
			// renderSimulator();
		}
	}

	private void populateFileHeader() {

		// Create the File -> Load entry in the menu and associate an
		// actionEvent
		// such that when clicked it will fire an event
		JMenuItem fileLoad = new JMenuItem(new AbstractAction("Load") {

			// We override the default action and redirect it to
			// the controller responsible

			/**
			 * The action that is performed when we click the load option
			 * 
			 * @param actionEvent
			 *            The event that triggered this action to occur
			 */
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
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
				int mapWidth  = mapEditorView.gridColumn;
				Block block [][] = mapEditorView.room.block;
//				for (int i = 0; i < mapHeight; i++) {
//					for (int j = 0; j < mapWidth; j++) {
//						System.out.print(block[i][j].createId);
//					}
//					System.out.println();
//				}
				
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
			}
		});
	}

	private void renderMapEditor() {
		System.out.println("In renderMapEditor");
		System.out.println(mapEditorView.getHeight());
		System.out.println(mapEditorView.getWidth());

		// Our control panel
//		mapEditorView.add(World.getInstance().controlPanel);
//		mapEditorView.add(World.getInstance()); 
//		mapEditorView.repaint();
		// Our graph panel editor
//		mapEditorView.add(World); 
		
//		World.getInstance().registerEditableMouseHandlers();
	

	}

}
