package com.IDG.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.IDG.utils.MapValidityHelper;


public class ListenToSave implements ActionListener {
	wall buttons[][];
	PrintWriter writer=null;
	JFrame frame=new JFrame();
	JFrame p2;

	public ListenToSave(wall buttons[][], JFrame p2){
		try{
			writer= new PrintWriter("F://map.txt", "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		this.buttons=buttons;
		this.p2=p2;

	}
	public void actionPerformed(ActionEvent e) {
		String [][] gridMap=new String[buttons.length][buttons[0].length];
		for (int i=0;i<buttons.length;i++){
			for (int j=0;j<buttons[0].length;j++){
				if(buttons[i][j].isStart){
					writer.print("S");
					gridMap[i][j]="S";
				}
				else if(buttons[i][j].isEnd){
					writer.print("E");
					gridMap[i][j]="E";
				}
				else if(buttons[i][j].isPath){
					writer.print("-");
					gridMap[i][j]="-";
				}
				else{
					writer.print("*");
					gridMap[i][j]="*";
				}	

			}
			writer.println();
		}
		boolean isValid=MapValidityHelper.testMapValidity(gridMap);
		if(!isValid){
		}else{
			writer.flush();
			writer.close();
			JOptionPane.showMessageDialog(frame,
					"Map Saved Succesfully.");
			p2.dispose();

		}

	}

}