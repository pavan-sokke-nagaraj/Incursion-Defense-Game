/**
 * 
 */
package com.IDG.controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**ControlPanel class listen to the cunstomer's action
 * and according to the user's choice draw the width and
 * height of the map.
 * @author p_sokke
 *
 */
public class ControlPanel extends JToolBar {

	/**
	 * The action associated to inserting a new State
	 */
	private Action createGridAction = new NewNodeAction("Create");

	JLabel rowLabel = new JLabel("Number of Rows ");
	JLabel colLabel = new JLabel("Number of Rows ");

	JTextField rowField = new JTextField(2);
	JTextField colField = new JTextField(2);
	/**
	 * The button for inserting a State
	 */
	private JButton createButton = new JButton(createGridAction);

	public ControlPanel() {
		System.out.println("ControlPanel constructor");
		System.out.println("ControlPanel height" + getHeight());
		System.out.println("ControlPanel width" + getWidth());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// setLayout(new GridLayout(10, 20);
		setBackground(Color.RED);
		setFloatable(false);

		add(rowLabel);

		add(rowField);
		add(colLabel);
		add(colField);
		add(createButton);
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
		 *            The action that trigger this Action
		 */
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			int gridRow = 0;
			int gridColumn = 0;
			gridRow = Integer.parseInt(rowField.getText());
			gridColumn = Integer.parseInt(colField.getText());
			System.out.println(actionEvent.getActionCommand());
			System.out.println("rowField row value: " + gridRow);
			System.out.println("colField col value: " + gridColumn);
			Point p = new Point(
					Toolkit.getDefaultToolkit().getScreenSize().width / 2,
					Toolkit.getDefaultToolkit().getScreenSize().height / 3);
//			Block.addBlocks(gridRow, gridColumn, p);

			World.getInstance().repaint();
		}

	}
}
