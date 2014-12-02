package com.IDG.mapBuilder;

/**
 * 
 */

/**
 * @author Kariappa @author Arjun
 *
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.IDG.controller.LayoutManager;
import com.IDG.mapBuilder.MapBuilderModel;

/**
 * @author Ajay
 *
 */
public class MapBuilderController {

	/**
	 * Jpanel to hold the mapGrid
	 */
	JPanel mapGrid = new JPanel();
	
	/**
	 * ArrayList to Validate the user created Map
	 */
	ArrayList<String> errorList = null;
	
	MapBuilderModel temp[][] = null;
	
	MapBuilderModel temp1[][] = null;
	/**
	 * Buttons to hold the mapdata of previously saved Map
	 */
	MapBuilderModel loadbuttons[][];
	/**
	 * Jpanel to hold the Default Map buttons
	 */
	JPanel dMapGrid = new JPanel();
	/**
	 * Jpanel to hold the User Defined Map Buttons
	 */
	JPanel udMapGrid = new JPanel();
	/**
	 * Jpanel to hold the gameactionbuttons
	 */
	JPanel gameButtons = new JPanel();
	/**
	 * JPanel to encapsulate the above Panels
	 */
	JPanel align = new JPanel();
	/**
	 * Main Frame that holds the above Panels
	 */
	JFrame p2 = new JFrame();
	/**
	 * Stores filename of Map
	 */
	String fileName1 = null;
	/**
	 * Displays Mapbuilder caption
	 */
	JLabel headerLabel;
	/**
	 * Button to implement Map Save functionality
	 */
	JButton save = new JButton("Save");
	/**
	 * Button to implement Map Edit functionality
	 */
	JButton edit = new JButton("Edit");
	/**
	 * Button to implement Creat new Map functionality
	 */
	JButton create = new JButton("Create New MAP");
	/**
	 * Button to implement Start Game functionality
	 */
	JButton game = new JButton("Start Game!!");
	
	/**
	 * Text Area to display Validation status of Map and Also Map Logs
	 */
	JTextArea tArea1 = new JTextArea(15, 30);
	/**
	 * Object Holding all serialized data related to the MAP
	 */
	MapDetails playGame = new MapDetails();
	
	/**
	 * Temp Variables to store intermitent values
	 */
	Calendar time = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	int gridRow = 0;
	int gridColumn = 0;
	String mapType1 = null;
	int counter = 0;
	MapBuilderModel file = null;
	boolean isEditEnabled;
	MapBuilderModel tempLoadbuttons[][];

	

	public MapBuilderController() {
		tArea1.setLineWrap(true);
		tArea1.setText("Validation Status/Map log display");
		JScrollPane scroller1 = new JScrollPane();
		scroller1.setViewportView(tArea1);
		headerLabel = new JLabel("<html>Welcome to the MAP Editor <br>Click the buttons to build a path</html>");
		p2.setTitle("MAPBuilder v1.0");
		p2.setSize(1100, 600);
		p2.setLocationRelativeTo(null);
		// Read ScreenShotHeaderFile
		setgridLayoutForMaps("CustomMaps", udMapGrid);
		setgridLayoutForMaps("DefaultMaps", dMapGrid);
		gameactionbuttons();
		align.setLayout(new BorderLayout());
		align.add(udMapGrid, BorderLayout.EAST);
		align.add(dMapGrid, BorderLayout.CENTER);
		align.add(scroller1, BorderLayout.WEST);
		align.add(headerLabel, BorderLayout.NORTH);
		gameButtons.setLayout(new GridLayout(1, 4));
		gameButtons.add(save);
		gameButtons.add(edit);
		gameButtons.add(game);
		gameButtons.add(create);
		// save.setEnabled(false);
		p2.setLayout(new BorderLayout());
		p2.add(align, BorderLayout.EAST);
		p2.add(gameButtons, BorderLayout.SOUTH);
		Component[] components = p2.getComponents();
		System.out.println("Number of Comp=" + components.length);
		setGameMatrixOnPanel(new File(
				"Resource/CustomMaps/GameMatrix/Map585.txt"));
		p2.setVisible(true);

	}

	/**
	 * @param mapType to store type of map Userdefined or Default
	 * @param grid Stores the Values of the Map Grid
	 *Function to setmap grid when Map thumbnails are clicked
	 */
	public void setgridLayoutForMaps(String mapType, JPanel grid) {
		Scanner sc = null;
		String line = null;
		try {
			sc = new Scanner(new File("Resource/" + mapType
					+ "/ScreenShots/ScreenShotsHeader.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<MapBuilderModel> udButtonList = new ArrayList<MapBuilderModel>();
		while (sc.hasNextLine()) {
			line = sc.nextLine().toString();
			if (line != null && line != "") {
				setLabelsForScreenShots(line, udButtonList, mapType);
			}
		}
		if (udButtonList.size() == 0) {
			grid.setLayout(new GridLayout(1, 1));
		} else {
			grid.setLayout(new GridLayout(udButtonList.size(), udButtonList
					.size()));
		}
		for (int i = 0; i < udButtonList.size(); i++) {
			grid.add(udButtonList.get(i));
		}
	}

	public void setLabelsForScreenShots(String fileName,
			ArrayList<MapBuilderModel> buttonList, String mapType) {
		BufferedImage myPicture = null;
		fileName1 = fileName;
		mapType1 = mapType;
		try {
			myPicture = ImageIO.read(new File("Resource/" + mapType
					+ "/ScreenShots/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Snapshot code
		fileName1 = fileName1.replaceAll("png", "txt");
		fileName1 = fileName1.replaceAll("ScreenShot", "Map");
		MapBuilderModel picLabel = new MapBuilderModel(fileName1, mapType1,
				mapType);
		if (mapType.equals("CustomMaps")) {
			picLabel.setText("User Defined Map " + (buttonList.size() + 1));
		} else {
			picLabel.setText("Default Map " + (buttonList.size() + 1));
		}
		ImageIcon ii = new ImageIcon(myPicture);
		int scale = 10; // 2 times smaller
		int width = ii.getIconWidth();
		int newWidth = width / scale;
		picLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(
				newWidth, -1, java.awt.Image.SCALE_SMOOTH)));
		picLabel.setMaximumSize(new Dimension(10, 10));
		picLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MapDetails displayArea = new MapDetails();
				StringBuffer todisplay = new StringBuffer();
				file = (MapBuilderModel) e.getSource();
				tArea1.setText(" ");

				displayArea.mapid = Integer.parseInt(file.getFileName()
						.substring(file.getFileName().lastIndexOf("p") + 1,
								file.getFileName().indexOf(".")));
				displayArea = displayArea.readFromFile(displayArea);
				tArea1.setFont(new Font("Serif", Font.PLAIN, 12));
				String reportDate = df.format(displayArea.creationTime);
				tArea1.append(reportDate);
				tArea1.append(":[MAP CREATED]");

				if (displayArea.modifiedTime.size() > 0) {
					for (int i = 0; i < displayArea.modifiedTime.size(); i++)

					{
						reportDate = df.format(displayArea.modifiedTime.get(i));
						tArea1.append("\n" + reportDate);
						tArea1.append(":[MAP MODIFIED]");

					}
				}

				if (displayArea.lastPlayedTime.size() > 0) {
					System.out.println("lastPlayedTime Size"
							+ displayArea.lastPlayedTime.size());
					System.out.println("Game Status Size"
							+ displayArea.gamestatus.size());

					for (int i = 0; i < displayArea.lastPlayedTime.size(); i++) {

						reportDate = df.format(displayArea.lastPlayedTime
								.get(i));
						tArea1.append("\n" + reportDate);
						tArea1.append(":[MAP PLAYED]");
						tArea1.append(displayArea.gamestatus.get(i));

					}
				}

				if (displayArea.highscore.size() > 0) {
					String temp = null;
					tArea1.append("\n\n High Score:");
					tArea1.append("\n");
					for (int i = 0; i < displayArea.highscore.size(); i++) {
						temp = Integer.toString(displayArea.highscore.get(i));
						tArea1.append(temp);
						tArea1.append("\n");
					}
				}
				// tArea1.setText(todisplay.toString());
				setGameMatrixOnPanel(new File("Resource/" + file.mapType
						+ "/GameMatrix/" + file.fileName));
				System.out.println("Resource/" + file.mapType + "/GameMatrix/"
						+ file.fileName);
			}
		});
		buttonList.add(picLabel);
	}

	public void setGameMatrixOnPanel(File mapFile) {
		MapDetails setGrid = new MapDetails();
		String filename = mapFile.getName();

		setGrid.mapid = Integer.parseInt(filename.substring(
				filename.lastIndexOf("p") + 1, filename.indexOf(".")));
		System.out.println(setGrid.mapid);
		setGrid = setGrid.readFromFile(setGrid);
		System.out.println(mapFile.getName());
		mapGrid.removeAll();
		mapGrid.revalidate();
		// List<String> lines=new ArrayList();
		String tempstr = new String(setGrid.mapdata);
		// tempstr.replaceAll(" ", "");

		char[] chars = new String(tempstr).toCharArray();
		char[] tempChar = new char[chars.length];

		int rows = setGrid.rowSize; // ; lines.size(); // number of rows
		int cols = setGrid.columnSize; // number of columns

		int i = 0, j = 0, k = 0;
		MapBuilderModel wl = null;
		int count = 0;
		tempLoadbuttons = new MapBuilderModel[rows][cols];

		// for(String line : lines) { // for each line, add the 1s
		// char[] chars = line.toCharArray();
		for (i = 0; i < rows; i++) {
			for (j = 0; j < cols; j++) {

				wl = new MapBuilderModel();
				switch (chars[k++]) {
				case '*':
					wl.setIcon(null);
					wl.setPath(false);
					break;
				case '-':
					wl.setIcon(wl.getPath());
					wl.setPath(true);
					break;
				case 'S':
					wl.setIcon(wl.getStart());
					wl.setStart(true);
					break;
				case 'E':
					wl.setIcon(wl.getEnd());
					wl.setEnd(true);
					break;

				}

				tempLoadbuttons[i][j] = wl;
				count++;

			}

		}

		for (i = 0; i < tempLoadbuttons.length; i++) {
			for (j = 0; j < tempLoadbuttons[0].length; j++) {
				tempLoadbuttons[i][j].setPreferredSize(new Dimension(40, 40));
				mapGrid.add(tempLoadbuttons[i][j]);
			}
		}
		for (i = 0; i < tempLoadbuttons.length; i++) {
			for (j = 0; j < tempLoadbuttons[0].length; j++) {
				if (!tempLoadbuttons[i][j].isPath)
					tempLoadbuttons[i][j].setEnabled(false);
			}
		}
		mapGrid.setVisible(true);
		mapGrid.setLayout(new GridLayout(tempLoadbuttons.length,
				tempLoadbuttons[0].length));
		System.out.println("Number=" + mapGrid.getComponentCount());
		p2.add(mapGrid, BorderLayout.CENTER);
		p2.setVisible(true);
		temp = tempLoadbuttons;
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!file.fileType.equals("DefaultMaps")) {
					for (int i = 0; i < temp.length; i++) {
						for (int j = 0; j < temp[0].length; j++) {
							temp[i][j].setEnabled(true);
						}
					}
					temp1 = temp;
					save.setEnabled(true);
					isEditEnabled = true;
				}
			}
		});

	}

	/**
	 * Function that defines all game action buttons and their action menthods 
	 */
	void gameactionbuttons() {
		temp = loadbuttons;
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel rowColPanel = new JPanel();

				JTextField rowField = new JTextField(2);
				JTextField colField = new JTextField(2);

				rowColPanel.setLayout(new BoxLayout(rowColPanel,
						BoxLayout.Y_AXIS));
				rowColPanel.add(new JLabel("Number of Rows (MAX 15)",
						SwingConstants.CENTER));
				rowColPanel.add(rowField);

				rowColPanel.add(Box.createVerticalStrut(10)); // a spacer
				rowColPanel.add(new JLabel("Number of Columns (MAX 15)"));
				rowColPanel.add(colField);
				int result = JOptionPane.showConfirmDialog(null, rowColPanel,
						"Please Enter Number of rows and columns",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("rowField row value: "
							+ rowField.getText());
					System.out.println("colField col value: "
							+ colField.getText());
					gridRow = Integer.parseInt(rowField.getText());
					gridColumn = Integer.parseInt(colField.getText());

				}
				if (gridColumn > 15 || gridRow > 15) {
					JFrame error = new JFrame();
					error.setTitle("");
					JOptionPane
							.showMessageDialog(
									error,
									"<html>Map creation failed!<br>Row and Column size limited to 15.<br>Please retry!</html> ");
				}

				else {
					temp1 = new MapBuilderModel[gridRow][gridColumn];
					mapGrid.removeAll();
					mapGrid.revalidate();
					// mapGrid.setVisible(false);
					for (int i = 0; i < gridRow; i++) {
						for (int j = 0; j < gridColumn; j++) {
							temp1[i][j] = new MapBuilderModel();
							temp1[i][j].setPreferredSize(new Dimension(40, 40));
							mapGrid.add(temp1[i][j]);
						}
					}
					mapGrid.setLayout(new GridLayout(gridRow, gridColumn));
					mapGrid.setVisible(true);
					errorList = new ArrayList<String>();

				}
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MapSaver(temp1, errorList, tArea1, mapGrid, gridRow,
						gridColumn, isEditEnabled, file);
				System.out.println("SAve clicked");
				udMapGrid.removeAll();
				udMapGrid.revalidate();
				udMapGrid.repaint();
				setgridLayoutForMaps("CustomMaps", udMapGrid);
				if (tArea1.getText().toString().length() > 17 && file != null) {
					isEditEnabled = true;
				} else {
					isEditEnabled = false;
				}

			}

		});

		game.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p2.dispose();
				LayoutManager abc = new LayoutManager();
				File file1 = new File(
						"Resource/CustomMaps/ScreenShots/Metadata.txt");
				try {
					PrintWriter writer = null;
					try {
						writer = new PrintWriter(file1);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					writer.print(file.fileName + "," + file.fileType);
					writer.close();
					System.out.println("FileName=" + file.fileName
							+ "FileType=" + file.fileType);
					String tempFileName = file.fileName;

					System.out.println("FileName=" + tempFileName);

					playGame.mapid = Integer.parseInt(tempFileName.substring(
							tempFileName.lastIndexOf("p") + 1,
							tempFileName.indexOf(".")));
					System.out.println("MAPID=" + playGame.mapid);
					playGame = playGame.readFromFile(playGame);
					System.out.println("Mapid=" + playGame.mapid);
					Date date = new Date();

					playGame.lastPlayedTime.add(time.getTime());
					playGame.writeToFile(playGame);
					playGame.readFromFile(playGame);
					abc.populateFileHeader();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
