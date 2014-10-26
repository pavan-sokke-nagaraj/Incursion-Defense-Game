
/**
 * 
 */
package com.IDG.controller;

/**
 * @author Kariappa
 *
 */
import java.awt.Component;
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
		setSize(600,600);
		setResizable(false);
		p2.setLayout(new GridLayout(20,20));
		
		//JFrame frame = new JFrame();
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame.setLocationRelativeTo(null);
        
      
		
		
		
		//p2.setLayout(new GridLayout(10,10));
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
		Component [] abc=p2.getComponents();
		System.out.println("Ajayqwerty"+abc.length);
		for(String line : lines) {            // for each line, add the 1s
			char[] chars = line.toCharArray();
			System.out.println("J Iteration"+chars.length);
			for(j = 0 ; j < chars.length ; ++j) {
				wl=new wall();
				wl.setDirection(chars[j]);

				switch(chars[j]) {
				case 'B':
					wl.setIcon(null);
					wl.setPath(false);

					break;
				case 'U':
					wl.setIcon(wl.getUpDirectionImg());
					wl.setPath(true);
					wl.setDirection('U');

					break;
				case 'R':
					wl.setIcon(wl.getRightDirectionImg());
					wl.setPath(true);
					wl.setDirection('R');
					break;
				case 'D':
					wl.setIcon(wl.getDownDirectionImg());
					wl.setPath(true);
					wl.setDirection('D');
					break;
				case 'L':
					wl.setIcon(wl.getLeftDirectionImg());
					wl.setPath(true);
					wl.setDirection('L');
					break;


				}
				count++;
				loadbuttons[i][j]=wl;
			}

			System.out.println("J Iteration Executed"+j);
			
			i++;

		}
		System.out.println("The times loadbutton is loaded::"+count);
		
		System.out.println("The Size of loaded Frame::"+(loadbuttons.length*loadbuttons[0].length));
		for( i=0;i<loadbuttons.length;i++){
			for(j=0;j<loadbuttons[0].length;j++){
				System.out.println("Check for each button direction::"+loadbuttons[i][j].getDirection());
					
		p2.add(loadbuttons[i][j]);
			}}
		Component [] XYZ=p2.getComponents();
		System.out.println("After"+XYZ.length);
		add(p2);
		setVisible(true);
		//frame.pack();
		//frame.setVisible(true);
		/*p2.repaint();
		p2.setLayout(new GridLayout(10,10));
		p2.setVisible(true);*/
	}

}
