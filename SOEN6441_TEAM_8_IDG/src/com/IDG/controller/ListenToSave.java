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

/** ListenToSave class is a action listener, waiting for
 * users' action to save their created map. Before saving
 * map to a specific address, it will first call the 
 * MapValidityHelper class to check if this map is valid
 * to run.
 * @author Ajay
 */

public class ListenToSave implements ActionListener {
	wall buttons[][];
	PrintWriter writer=null;
	JFrame frame=new JFrame();
	JFrame p2;
	ArrayList<String> errorList=null;
	JTextArea tArea1;

/** Call the constructor setting initial values.
 * @param Area1 A set of string showing why the map is invalid.
 * @param buttons[][] Each contains the state of field where map is created.
 */
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
   
  /** Perform action to transfer map edited to the .txt file
    * to save.
    * @param gridMap[][] Read buttons[][] state and transfer to .txt file
    * <p>"S" means the start of the road. </p>
    * <p>"E" means the end of the road. </p>
    * <p>"-" means there exsits a road. </p>
    * <p>"*" means scenery.</p>
    */
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
