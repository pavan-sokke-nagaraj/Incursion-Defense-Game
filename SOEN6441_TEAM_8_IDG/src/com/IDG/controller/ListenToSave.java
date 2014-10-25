package com.IDG.controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.IDG.utils.MapValidityHelper;


public class ListenToSave implements ActionListener {
	wall buttons[][];
	PrintWriter writer=null;
	JFrame frame=new JFrame();
	JFrame p2;
	ArrayList<String> errorList=null;
	JTextArea tArea1;

	public ListenToSave(wall buttons[][], JFrame p2,ArrayList<String> errorList, JTextArea tArea1){
		try{
			writer= new PrintWriter("F://map.txt", "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		this.tArea1=tArea1;
		this.errorList=errorList;
		this.buttons=buttons;
		this.p2=p2;

	}
	public void actionPerformed(ActionEvent e) {

		System.out.println(" Printed ");
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
		errorList=new ArrayList();
		boolean isValid=MapValidityHelper.testMapValidity(gridMap,errorList);
		StringBuffer erroCode=new StringBuffer();
		if(!isValid)
		{
			if (errorList.size()>0)
			{
				for(int i=0;i<errorList.size();i++)
				{
					erroCode.append(errorList.get(i));
					erroCode.append(System.getProperty("line.separator"));
				}
				tArea1.setText(erroCode.toString());
			}


		}else{
			writer.flush();
			writer.close();
			JOptionPane.showMessageDialog(frame,
					"Map Saved Succesfully.");
			p2.dispose();

		}

	}

}
