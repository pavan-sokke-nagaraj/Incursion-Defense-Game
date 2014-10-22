package com.IDG.controller;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Scanner;
public class mapbuilder extends JFrame  {
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	wall buttons[][];
	JButton save,reset,load;
	
	/**
	public static void main(String[] args)
	{ 
		new mapbuilder();
	}**/

public mapbuilder(int gridRow, int gridcolm){
	super("MAPBuilder V 1.0");
	buttons=new wall[gridRow][gridcolm];
	setSize(600,600);
	setResizable(false);
	p.setLayout(new GridLayout(10,10));
	int counter=0;
	for(int i=0;i<gridRow;i++){
		for(int j=0;j<gridcolm;j++){
			buttons[i][j]=new wall();
			buttons[i][j].setPreferredSize(new Dimension(40, 40));
			buttons[i][j].id=counter++;
			buttons[i][j].direction='B';
			p.add(buttons[i][j]);	
		}
	}
	p1.setLayout(new GridLayout(3,1));
	p1.add(save = new JButton("Save"));
	save.addActionListener(new ListenToSave(buttons));
	p1.add(reset = new JButton("Reset"));
	p1.add(load = new JButton("Load"));
	load.addActionListener(new ListenToLoad());
	p2.setLayout(new FlowLayout());
    p2.add(p);
    p2.add(p1);
    add(p2);
	setVisible(true);
	
	


}

}