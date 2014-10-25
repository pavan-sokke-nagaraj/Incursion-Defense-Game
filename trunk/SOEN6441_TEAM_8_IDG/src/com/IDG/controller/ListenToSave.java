package com.IDG.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.IDG.utils.MapValidityHelper;


public class ListenToSave implements ActionListener {
	wall buttons[][];
	JFrame frame=new JFrame();
	JFrame p2;
	StringBuffer matrix=new StringBuffer();
	public ListenToSave(wall buttons[][], JFrame p2){
		this.buttons=buttons;
		this.p2=p2;

	}
	public void actionPerformed(ActionEvent e) {
		String [][] gridMap=new String[buttons.length][buttons[0].length];
		for (int i=0;i<buttons.length;i++){
			for (int j=0;j<buttons[0].length;j++){
				if(buttons[i][j].isStart){
					matrix.append("S");
					gridMap[i][j]="S";
				}
				else if(buttons[i][j].isEnd){
					matrix.append("E");
					gridMap[i][j]="E";
				}
				else if(buttons[i][j].isPath){
					matrix.append("-");
					gridMap[i][j]="-";
				}
				else{
					matrix.append("*");
					gridMap[i][j]="*";
				}	

			}
			matrix.append(System.getProperty("line.separator"));
		}
		boolean isValid=MapValidityHelper.testMapValidity(gridMap);
		if(!isValid){
			//If validation fails then show the error message
			matrix=new StringBuffer();
			JOptionPane.showMessageDialog(frame,
					"Error");
					
		}else{
			//if validation is succesfull ask the user to choose the destination as where to save the map file
			try{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Select the directory to Save");   
				JFrame parentFrame = new JFrame();
				int userSelection = fileChooser.showSaveDialog(parentFrame);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();
					FileOutputStream out = new FileOutputStream(fileToSave.getPath()+".txt");
					byte[] b = matrix.toString().getBytes(Charset.forName("UTF-8"));
					out.write(b);
					out.close();
				}
			}catch(Exception ef){
				ef.printStackTrace();
			}
		
			JOptionPane.showMessageDialog(frame,
			"Map Saved Succesfully.");
			p2.dispose();
		}
	}
}