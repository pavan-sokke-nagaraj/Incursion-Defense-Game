/**
 * 
 */
package com.IDG.logs;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.IDG.controller.GameFileManager;
import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Tower;

/**
 * Class file to handle game logging
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build 3
 * @since Build 3
 *
 */
public class GameLogging {

	/**
	 * Variable to hold the selected wave level to show logs
	 */
	private int selectedWaveLevel;

	public GameLogging() {
	}

	/**
	 * method to construct the log panel
	 * 
	 * @param waveLevel
	 *            number of waves
	 * @return return if the wave is selected or not
	 */
	public boolean createLogPanel(int waveLevel) {
		JPanel loggingWindow;

		loggingWindow = new JPanel();
		loggingWindow.setLayout(new FlowLayout());

		ButtonGroup group = new ButtonGroup();
		Boolean flag = true;
		for (int i = 1; i <= waveLevel; i++) {
			JRadioButton radio = new JRadioButton("WAVE " + i, flag);
			group.add(radio);
			selectedWaveLevel = 1;
			flag = false;
			loggingWindow.add(radio);

			radio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String asdf = radio.getText().substring(5);
					selectedWaveLevel = Integer.parseInt(asdf);
				}
			});

		}
		int result = JOptionPane.showConfirmDialog(null, loggingWindow,
				"SELECT TYPE", JOptionPane.OK_CANCEL_OPTION);

		if (result != JOptionPane.OK_OPTION) {
			selectedWaveLevel = 0;
			return false;
		} else {
			return true;
		}
	}

	/**
	 * method to show tower log
	 * 
	 * @param mapTowerXpos
	 *            tower's x position in game grid
	 * @param mapTowerYpos
	 *            tower's y position in game grid
	 */
	public void showTowerLog(int mapTowerXpos, int mapTowerYpos) {
		if (MapSimulatorView.arsenal.selectMapTower) {
			Tower tower = (Tower) GameFileManager.getTowerObject(mapTowerXpos,
					mapTowerYpos);
			showLog("Tower logs", tower.individualTowerlog);
		} else {
			JOptionPane.showMessageDialog(null,
					"Please click on a Game Tower to view logs");
		}
	}

	/**
	 * method to show all tower logs
	 */
	public void showAllTowerLog() {
		showLog("All Tower logs", MapSimulatorView.collectiveTowerlog);
	}

	/**
	 * method to show selected wave log
	 * 
	 * @param waveLevel
	 *            selected wave to show logs
	 */
	public void showWaveLog(int waveLevel) {
		String log = MapSimulatorView.levelLogList.get(0).toString();
		if (waveLevel == 0) {
			JOptionPane.showMessageDialog(null,
					"No waves have been Finished playing");
		} else {
			if (createLogPanel(waveLevel)) {
				System.out.println(selectedWaveLevel);
				showLog("Wave " + selectedWaveLevel + " logs",
						MapSimulatorView.levelLogList
								.get(selectedWaveLevel - 1));
			}
		}
	}

	/**
	 * method to show the game log
	 */
	public void showGameLog() {
		showLog("Game logs", MapSimulatorView.gameLog);
	}

	/**
	 * method to draw a text panel and show logs
	 * 
	 * @param logMessage
	 *            header of the text panel to be shown
	 * @param logBuffer
	 *            string to be draw3n on text panel
	 */
	public void showLog(String logMessage, StringBuffer logBuffer) {
		JFrame logFrame = new JFrame();
		logFrame.setTitle(logMessage);
		logFrame.setSize(800, 500);
		logFrame.setLocationRelativeTo(null);

		JTextArea logText = new JTextArea(logBuffer.toString());
		logText.setEditable(false);

		JScrollPane areaScrollPane = new JScrollPane(logText);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		logFrame.add(areaScrollPane);
		logFrame.setVisible(true);
	}

}
