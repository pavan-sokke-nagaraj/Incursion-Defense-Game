package com.IDG.controller;

/**
 * 
 */


/**
 * @author Kariappa
 *
 */
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;


public class Load  extends JFrame  {

	JPanel p2=new JPanel();

	public Load()
	{
		
		super("MAPBuilder V 2.0");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		//p2.setLayout(new GridBagLayout());
		
		//JFrame frame = new JFrame();
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame.setLocationRelativeTo(null);
        
      
		
		
		
		p2.setLayout(new GridLayout(10,10));
		JFileChooser choice = new JFileChooser();
		int option = choice.showOpenDialog(this);
		File mapFile=null;
		if (option == JFileChooser.APPROVE_OPTION) {
			try{
				mapFile=choice.getSelectedFile();
			}catch(Exception e){
			}
		}
		List<String> lines=new ArrayList();
		Scanner sc=null;
		try {
			sc = new Scanner(mapFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}

		// to array
		int rows = lines.size();              // number of rows
		int cols = 0;                         // number of columns
		for(String line : lines) {
			cols = Math.max(cols, line.length());
		}
		int i = 0,j=0;
		wall wl=null;
		int count=0;
		wall loadbuttons[][]=new wall[rows][cols];
		setPreferredSize(new Dimension(40, 40));
		for(String line : lines) {            // for each line, add the 1s
			char[] chars = line.toCharArray();
			
			for(j = 0 ; j < chars.length ; ++j) {
				wl=new wall();
				//wl.setDirection(chars[j]);

				switch(chars[j]) {
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
				count++;
				loadbuttons[i][j]=wl;
			}
			i++;

		}
		
		for( i=0;i<loadbuttons.length;i++){
			for(j=0;j<loadbuttons[0].length;j++){
				loadbuttons[i][j].setPreferredSize(new Dimension(40,40));
				p2.add(loadbuttons[i][j]);
			}}
		add(p2);
		setVisible(true);
		p2.setLayout(new GridLayout(loadbuttons.length,loadbuttons[0].length));
		//frame.pack();
		//frame.setVisible(true);
		/*p2.repaint();
		p2.setLayout(new GridLayout(10,10));
		p2.setVisible(true);*/
	}

}
