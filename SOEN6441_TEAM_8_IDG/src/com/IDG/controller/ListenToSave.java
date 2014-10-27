package com.IDG.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.IDG.controller.wall;
import com.IDG.utils.MapValidityHelper;

/** ListenToSave class is a action listener, waiting for
 * users' action to save their created map. Before saving
 * map to a specific address, it will first call the 
 * MapValidityHelper class to check if this map is valid
 * to run.
 * @author Ajay
 */

public class ListenToSave  {
	wall buttons[][];
	JFrame frame=new JFrame();
	JFrame p2;
	ArrayList<String> errorList=null;
	JTextArea tArea1;
	JPanel gameMatrixPanel=null;
	StringBuffer fileContent=new StringBuffer();
	int row=0,column=0;
	MapButton tempFile=null;
	boolean isEditEnabled;

	public ListenToSave(wall buttons[][],ArrayList<String> errorList, JTextArea tArea1,JPanel p,int row,int column,boolean isEditEnabled,MapButton tempFile)
	{
		this.row=row;
		this.column=column;
		this.tArea1=tArea1;
		this.errorList=errorList;
		this.buttons=buttons;
		gameMatrixPanel=p;
		this.tempFile=tempFile;
		this.isEditEnabled=isEditEnabled;
		String [][] gridMap=new String[buttons.length][buttons[0].length];
		for (int i=0;i<buttons.length;i++){
			for (int j=0;j<buttons[0].length;j++){
				if(buttons[i][j].isStart){
					fileContent.append("S");
					gridMap[i][j]="S";
				}
				else if(buttons[i][j].isEnd){
					fileContent.append("E");
					gridMap[i][j]="E";
				}
				else if(buttons[i][j].isPath){
					fileContent.append("-");
					gridMap[i][j]="-";
				}
				else{
					fileContent.append("*");
					gridMap[i][j]="*";
				}	

			}
			fileContent.append(System.getProperty("line.separator"));
		}
		errorList=new ArrayList();
		boolean isValid=MapValidityHelper.testMapValidity(gridMap,errorList);
		StringBuffer erroCode=new StringBuffer();
		if(!isValid)
		{
			fileContent=new StringBuffer();
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
			try{

				if(!isEditEnabled){
					//Genrating Random File Name
					tArea1.setText(" ");
					Random rn = new Random();
					int range = 1000 - 0 + 1;
					int fileName =  rn.nextInt(range) + 0;
					/***************************************************START MAP SAVE CODE***************************************************/
					//Code to save file name to a header file
					try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Resource/CustomMaps/GameMatrix/GameMatrixHeader.txt", true)))) {
						out.println("Map"+fileName+".txt");
					}catch (IOException ed) {
					}
					//Creating a Map File 
					File file =new File("Resource/CustomMaps/GameMatrix/"+"Map"+fileName+".txt");
					if(!file.exists()){
						file.createNewFile();
					}else{
						PrintWriter writer = new PrintWriter(file);
						writer.print("");
						writer.close();
					}
					try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
						out.println(fileContent.toString());
					}catch (IOException ed) {
					}
					fileContent=new StringBuffer();
					/***************************************************END MAP SAVE CODE***************************************************/

					/***************************************************START SCREENSHOT CODE***************************************************/
					//Code to save file name to a header file
					try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Resource/CustomMaps/ScreenShots/ScreenShotsHeader.txt", true)))) {
						out.println("ScreenShot"+fileName+".png");
					}catch (IOException ed) {
					}
					//Code to save screen shots
					BufferedImage matrixImage=null;
					matrixImage = new BufferedImage(gameMatrixPanel.getSize().width, gameMatrixPanel.getSize().height,BufferedImage.TYPE_INT_RGB);
					gameMatrixPanel.printAll (matrixImage.getGraphics());
					ImageIO.write(matrixImage, "png", new File("Resource/CustomMaps/ScreenShots/"+"ScreenShot"+fileName+".png"));
					/***************************************************END SCREENSHOT CODE***************************************************/
				}else{
					File file =new File("Resource/CustomMaps/GameMatrix/"+tempFile.fileName);
					if(!file.exists()){
						file.createNewFile();
					}else{
						PrintWriter writer = new PrintWriter(file);
						writer.print("");
						writer.close();
					}
					try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
						out.println(fileContent.toString());
					}catch (IOException ed) {
					}
					fileContent=new StringBuffer();
					String tempFileName=tempFile.fileName.replaceAll("txt", "png");
					tempFileName=tempFileName.replaceAll("Map", "ScreenShot");
					BufferedImage matrixImage=null;
					matrixImage = new BufferedImage(gameMatrixPanel.getSize().width, gameMatrixPanel.getSize().height,BufferedImage.TYPE_INT_RGB);
					gameMatrixPanel.printAll (matrixImage.getGraphics());
					file =new File("Resource/CustomMaps/ScreenShots/"+tempFileName);
					ImageIO.write(matrixImage, "png", file);
				}
			} catch (Exception ef) {
				ef.printStackTrace();
			}

			JOptionPane.showMessageDialog(frame,
					"Map Saved Succesfully.");
			for (int i=0;i<row;i++){
				for(int j=0;j<column;j++)
				{
					buttons[i][j].setEnabled(false);
				}
			}
		}

	}
}
