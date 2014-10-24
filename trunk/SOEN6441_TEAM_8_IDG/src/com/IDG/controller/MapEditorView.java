/**
 * 
 */
package com.IDG.controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author p_sokke
 *
 */
public class MapEditorView extends JPanel {

	/**
	 * Constructs a new object of our map editor
	 */
	public MapEditorView() {
		super();
		repaint();

	}

	JLabel rowLabel = new JLabel("Number of Rows ");
	JLabel colLabel = new JLabel("Number of Column ");

	JTextField rowField = new JTextField(2);
	JTextField colField = new JTextField(2);

	private Action createGridAction = new NewNodeAction("Create");
	private JButton createButton = new JButton(createGridAction);
	private JOptionPane messageWindow= new JOptionPane();

	int gridRow = 0;
	int gridColumn = 0;

	Room room = new Room();

	public void paintComponent(Graphics graphic) {
		graphic.setColor(Color.LIGHT_GRAY);
		graphic.fillRect(0, 0, getWidth(), getHeight());

		// graphic.fillRect(20, 20, getWidth() -50 , 100);

		// setLayout(new FlowLayout(FlowLayout.LEFT));
		// setLayout(new GridLayout());
		// setLayout(new GridLayout(10, 20);

		// setFloatable(false);
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, getWidth(), 80);
		add(rowLabel);

		add(rowField);
		add(colLabel);
		add(colField);
		add(createButton);

		System.out.println("paint");
		System.out.println(getHeight());
		System.out.println(getWidth());

		if (gridRow != 0 || gridColumn != 0) {

			int xStart = 100;
			int yStart = 100;
			int size = 40;
			room = new Room(gridColumn, gridRow );
			room.drawArena(graphic);
		}
	}

	private class NewNodeAction extends AbstractAction {

		/**
		 * Instantiates this Action with the passed name
		 * 
		 * @param name
		 *            The name for this action
		 */
		public NewNodeAction(String name) {
			super(name);
		}

		/**
		 * Effectively inserts a new Node
		 * 
		 * @param actionEvent
		 *  The action that trigger this Action
		 */
		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			gridRow = Integer.parseInt(rowField.getText());
			gridColumn = Integer.parseInt(colField.getText());
			System.out.println(actionEvent.getActionCommand());
			System.out.println("rowField row value: " + gridRow);
			System.out.println("colField col value: " + gridColumn);
			repaint();

		}

	}

}
