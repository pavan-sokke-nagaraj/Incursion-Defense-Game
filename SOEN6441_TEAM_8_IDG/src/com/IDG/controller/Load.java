package com.IDG.controller;

/**
 * 
 */


/**
 * @author Kariappa
 *
 */
import java.awt.BorderLayout;
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

	JPanel mapGrid=new JPanel();
	JPanel dMapGrid=new JPanel();
	JPanel udMapGrid=new JPanel();
	JPanel gameButtons=new JPanel();
	JPanel align =new JPanel();
	JFrame p2= new JFrame();
	
	JButton save = new JButton("Save");
	JButton edit = new JButton("Edit");
	JButton game = new JButton("Start Game");
	JButton dMap4 = new JButton("Level4");
	JButton udMap4 = new JButton("Level4");
	JButton dMap1 = new JButton("Level1");
	JButton udMap1 = new JButton("Level1");
	JButton dMap2 = new JButton("Level2");
	JButton udMap2 = new JButton("Level2");
	JButton dMap3 = new JButton("Level3");
	JButton udMap3 = new JButton("Level3");

	public Load()
	{
		
		super("MAPBuilder V 2.0");
		p2.setSize(850,700);
		p2.setLocationRelativeTo(null);
		//p2.setResizable(false);
		
		
		//p2.setLayout(new GridBagLayout());
		
		//JFrame frame = new JFrame();
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame.setLocationRelativeTo(null);
        
      
		dMap1.setPreferredSize(new Dimension(60, 60));
		udMap1.setPreferredSize(new Dimension(60, 60));
		
		
		mapGrid.setLayout(new GridLayout(20,20));
		udMapGrid.setLayout(new GridLayout(4,4));
		udMapGrid.add(udMap1);
		udMapGrid.add(udMap2);
		udMapGrid.add(udMap3);
		udMapGrid.add(udMap4);
		dMapGrid.setLayout(new GridLayout(4,4));
		dMapGrid.add(dMap1);
		dMapGrid.add(dMap2);
		dMapGrid.add(dMap3);
		dMapGrid.add(dMap4);
		align.setLayout(new BorderLayout());
		align.add(udMapGrid,BorderLayout.EAST);
		align.add(dMapGrid,BorderLayout.WEST);
		gameButtons.setLayout(new GridLayout(1,3));
		gameButtons.add(save);
		gameButtons.add(edit);
		gameButtons.add(game);
		
		
		
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
				mapGrid.add(loadbuttons[i][j]);
			}}
		p2.setLayout(new BorderLayout());
		p2.add(mapGrid,BorderLayout.CENTER);
		
		//p2.add(udMapGrid,BorderLayout.EAST);
		//p2.add(dMapGrid,BorderLayout.EAST);
		p2.add(align,BorderLayout.EAST);
		p2.add(gameButtons,BorderLayout.SOUTH);
		Component[] components = p2.getComponents();
		System.out.println("Number of Comp="+components.length);
		//add(p2);
		for ( i=0;i<loadbuttons.length;i++){
			for ( j=0;j<loadbuttons[0].length;j++){
				if(!loadbuttons[i][j].isPath)
				loadbuttons[i][j].setEnabled(false);
				
			}
		}
		p2.setVisible(true);
		//p2.setLayout(new GridLayout(loadbuttons.length,loadbuttons[0].length));
		
		//frame.pack();
		//frame.setVisible(true);
		/*p2.repaint();
		p2.setLayout(new GridLayout(10,10));
		p2.setVisible(true);*/
	}

}
