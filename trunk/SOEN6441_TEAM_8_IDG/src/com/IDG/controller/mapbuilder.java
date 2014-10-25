package com.IDG.controller;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class mapbuilder extends JFrame {
	JPanel p=new JPanel();
	JFrame p1=new JFrame ();
	JFrame p2=new JFrame();
	JPanel p3=new JPanel();
	JPanel contentPane = new JPanel();
	MapEditorView mapeditorview = new MapEditorView();
    ArrayList<String> errorList = null;

    JTextArea tArea1 = new JTextArea(15,30);
    
	//JTextField textField = new JTextField(20);
	JMenuBar menuBar = new JMenuBar();
	JMenuItem save = new JMenuItem("Save");
	JLabel headerLabel;
	wall buttons[][];
	
	
	/**
	public static void main(String[] args)
	{ 
		new mapbuilder();
	}**/

public mapbuilder(int gridRow, int gridcolm){
	super("MAPBuilder V 1.0");
	//contentPane.setLayout(new GridLayout(1, 2, 2, 2));
	tArea1.setLineWrap(true);
	tArea1.setText("Validation Status");
	 JScrollPane scroller1 = new JScrollPane();
	 scroller1.setViewportView(tArea1);
	 contentPane.add(scroller1);
	buttons=new wall[gridRow][gridcolm];
	headerLabel = new JLabel("<html>Welcome to the MAP Editor <br>Click the buttons to build a path</html>");
	p2.setSize(850,700);
	p2.setResizable(false);
	p.setLayout(new GridLayout(gridRow,gridcolm));
	//p1.setLayout(new GridLayout(2,1));
	for(int i=0;i<gridRow;i++){
		for(int j=0;j<gridcolm;j++){
			buttons[i][j]=new wall();
			buttons[i][j].setPreferredSize(new Dimension(40, 40));
			p.add(buttons[i][j]);	
		}
	}
	errorList = new ArrayList<String>();
	save.addActionListener(new ListenToSave(buttons,p2,errorList,tArea1));
	
	
	menuBar.add(save);
	p3.add(headerLabel);
	//p1.setContentPane(contentPane);
	
	
	//load.addActionListener(new ListenToLoad());
	p2.setLayout(new BorderLayout());
	p2.add(p3,BorderLayout.NORTH);
	p2.add(contentPane,BorderLayout.EAST);
	p2.add(p,BorderLayout.CENTER);
	
	p2.setJMenuBar(menuBar);
	//add(p2);
	p2.setLocationRelativeTo(null);
    p2.setVisible(true);
	
	

}

}