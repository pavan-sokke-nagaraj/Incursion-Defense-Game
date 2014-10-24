package com.IDG.controller;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class mapbuilder extends JFrame {
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JFrame p2=new JFrame();
	JTextField textField = new JTextField(20);
	wall buttons[][];
	JButton save,reset,load;
	
	/**
	public static void main(String[] args)
	{ 
		new mapbuilder();
	}**/

public mapbuilder(int gridRow, int gridcolm){
	super("MAPBuilder V 1.0");
	JLabel headerLabel,headerLabel1;
	
	headerLabel = new JLabel("<html>Welcome to the MAP Editor <br>Click the buttons to set a Path</html>");
	
	buttons=new wall[gridRow][gridcolm];
	p2.setSize(850,700);
	p2.setResizable(true);
	p.setLayout(new GridLayout(gridRow,gridcolm));
	int counter=0;
	for(int i=0;i<gridRow;i++){
		for(int j=0;j<gridcolm;j++){
			buttons[i][j]=new wall();
			buttons[i][j].setPreferredSize(new Dimension(40, 40));
			buttons[i][j].id=counter++;
			
			p.add(buttons[i][j]);	
		}
	}
	p1.setLayout(new GridLayout(3,1));
	save = new JButton("Save");
	save.setPreferredSize(new Dimension(200,100));
	save.addActionListener(new ListenToSave(buttons,p2));
	p1.add(headerLabel);
	p1.add(save);
	p1.add(textField);
	
	
	
	//p1.add(reset = new JButton("Reset"));
	//p1.add(load = new JButton("Load"));
	//load.addActionListener(new ListenToLoad());
	p2.setLayout(new GridBagLayout());
	p2.add(p);
	p2.add(p1);
    
	//add(p2);
	//pack();
	p2.setLocationRelativeTo(null);
	p2.setVisible(true);
	

}

}