package com.IDG.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;


public class ListenToSave implements ActionListener {
	wall buttons[][];
	PrintWriter writer=null;

	public ListenToSave(wall buttons[][]){
		try{
			writer= new PrintWriter("F://map.txt", "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		this.buttons=buttons;
	}
	public void actionPerformed(ActionEvent e) {

		for (int i=0;i<buttons.length;i++){
			for (int j=0;j<buttons[0].length;j++){
				writer.print(buttons[i][j].getDirection());

			}
			writer.println();
		}
		writer.close();
		
	}
	
}

