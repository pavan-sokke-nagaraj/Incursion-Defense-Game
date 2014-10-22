/**
 * 
 */
package com.IDG.controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author p_sokke
 *
 */
public class Colosseum extends JFrame /*implements ActionListener*/ {
	public Colosseum() {
		
		super("Sparta's grid");
		System.out.println(World.Mode);
		// setTitle("Sparta's grid");
		// setSize(1006, 728);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LayoutManager menu = new LayoutManager();
		setJMenuBar(menu.getMenuBar());
		add(menu.getTabs(), BorderLayout.CENTER);
		
//		buildMenu();
//		init();
	}
	
	/*public void buildMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu mapOptionsMenu = new JMenu("FILE");
		JMenuItem createMapItem = new JMenuItem("CREATE MAP");
		createMapItem.addActionListener(this);
		mapOptionsMenu.add(createMapItem);
		menuBar.add(mapOptionsMenu);
		setJMenuBar(menuBar);

		Arena creaeMapArena = new Arena();
		add(creaeMapArena);
	}

	public void init() {
		setLayout(new GridLayout());

		JMenuBar menuBar = new JMenuBar();
		JMenu mapOptionsMenu = new JMenu("FILE");
		JMenuItem createMapItem = new JMenuItem("CREATE MAP");
		createMapItem.addActionListener(this);
		mapOptionsMenu.add(createMapItem);
		menuBar.add(mapOptionsMenu);
		setJMenuBar(menuBar);

		Arena creaeMapArena = new Arena();
		add(creaeMapArena);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "CREATE MAP") {
			// System.out.println("item clicked:\t" + e.getActionCommand());

			JPanel rowColPanel = new JPanel();
			JTextField rowField = new JTextField(2);
			JTextField colField = new JTextField(2);
			int gridRow = 0;
			int gridColumn = 0;
			rowColPanel.setLayout(new BoxLayout(rowColPanel, BoxLayout.Y_AXIS));
			rowColPanel.add(new JLabel("Number of Rows :(Maximum : 50)",
					SwingConstants.CENTER));
			rowColPanel.add(rowField);

			rowColPanel.add(Box.createVerticalStrut(10)); // a spacer
			rowColPanel.add(new JLabel("Number of Columns :(Maximum : 50)"));
			rowColPanel.add(colField);
			int result = JOptionPane.showConfirmDialog(null, rowColPanel,
					"Please Enter Nuber of rows and columns",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.out.println("rowField row value: " + rowField.getText());
				System.out.println("colField col value: " + colField.getText());
				gridRow = Integer.parseInt(rowField.getText());
				gridColumn = Integer.parseInt(colField.getText());
			}

			if (gridRow != 0 || gridColumn != 0) {
				// removeAll();
				// Arena creaeMapArena = new Arena();
				// creaeMapArena.setGridRow(gridRow);
				// creaeMapArena.setGridColumn(gridColumn);
				// repaint();
				// add(creaeMapArena);
				// revalidate();
				// setVisible(true);
				// removeAll();//or remove(JComponent)
				// revalidate();
				Arena creaeMapArena = new Arena();
				creaeMapArena.setGridRow(gridRow);
				creaeMapArena.setGridColumn(gridColumn);
				add(creaeMapArena);
				repaint();
				setVisible(true);

			}

		}
	}*/

}
