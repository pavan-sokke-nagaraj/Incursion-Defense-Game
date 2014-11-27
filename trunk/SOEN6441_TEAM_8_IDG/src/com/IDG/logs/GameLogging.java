/**
 * 
 */
package com.IDG.logs;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.IDG.mapSimulator.MapSimulatorView;

/**
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 *
 */
public class GameLogging {

	private int selectedWaveLevel;

	public GameLogging() {
	}

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

	public void showTowerLog(int mapTowerXpos, int mapTowerYpos) {
		if (MapSimulatorView.arsenal.selectMapTower) {
			showLog("Tower logs");
		} else {
			JOptionPane.showMessageDialog(null,
					"Please click on a Game Tower to view logs");
		}

	}

	public void showAllTowerLog() {
		showLog("All Tower logs");

	}

	public void showWaveLog(int waveLevel) {
		if (waveLevel == 0) {
			JOptionPane.showMessageDialog(null,
					"No waves have been Finished playing");
		} else {
			if (createLogPanel(waveLevel)) {
				System.out.println(selectedWaveLevel);
				showLog("Wave " + selectedWaveLevel + " logs");
			}
		}

	}

	public void showGameLog() {
		showLog("Game logs");
	}

	public void showLog(String logMessage) {

		JFrame logFrame = new JFrame();
		logFrame.setTitle(logMessage);
		logFrame.setSize(800, 500);
		// logFrame.setResizable(false);
		logFrame.setLocationRelativeTo(null);

		BufferedReader br;
		String logsToDisplay = null;
		try {
			br = new BufferedReader(new FileReader("D:\\logs.txt"));

			StringBuilder sb = new StringBuilder();
			String line;

			line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			logsToDisplay = sb.toString();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		JTextArea logText = new JTextArea(logsToDisplay);
		logText.setEditable(false);
		// logFrame.add(log);

		JScrollPane areaScrollPane = new JScrollPane(logText);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		logFrame.add(areaScrollPane);
		logFrame.setVisible(true);

	}

}