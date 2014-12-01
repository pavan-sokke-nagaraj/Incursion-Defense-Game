package com.IDG.mapBuilder;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.IDG.mapBuilder.MapBuilderModel;
import com.IDG.utils.MapValidityHelper;

/** ListenToSave class is a action listener, waiting for
 * users' action to save their created map. Before saving
 * map to a specific address, it will first call the 
 * MapValidityHelper class to check if this map is valid
 * to run.
 * @author Ajay
 */

public class MapSaver  {
	/**
	 * Array of all Map buttons
	 */
	MapBuilderModel buttons[][];
	JFrame frame=new JFrame();
	/**
	 * List containing the error while saving the map
	 */
	ArrayList<String> errorList=null;
	/**
	 * Text Area to show error messages
	 */
	public static JTextArea tArea1=new JTextArea();
	/**
	 * Game panel
	 */
	JPanel gameMatrixPanel=null;
	/**
	 * Details of file to be saved
	 */
	//StringBuffer fileContent=new StringBuffer();
	int row=0,column=0;
	MapBuilderModel tempFile=null;
	boolean isEditEnabled;
	
	MapDetails mapdetail;
	MapDetails editmapdetail=new MapDetails();
	Calendar time = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
	/**
	 * This function saves the map along with screen shots
	 * @param buttons Actual Map to be saved
	 * @param errorList List of errors while saving
	 * @param tArea1 Text area to show error messages
	 * @param p panel currently working on
	 * @param row Current Row
	 * @param column Current Column
	 * @param isEditEnabled Check if edit of map is enabled or not
	 * @param tempFile File containing details
	 */
	public MapSaver(MapBuilderModel buttons[][],ArrayList<String> errorList, JTextArea tArea1,JPanel p,int row,int column,boolean isEditEnabled,MapBuilderModel tempFile)
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
		mapdetail=new MapDetails();
		for (int i=0;i<buttons.length;i++){
			for (int j=0;j<buttons[0].length;j++){
				if(buttons[i][j].isStart){
					mapdetail.mapdata.append("S");
					gridMap[i][j]="S";
				}
				else if(buttons[i][j].isEnd){
					mapdetail.mapdata.append("E");
					gridMap[i][j]="E";
				}
				else if(buttons[i][j].isPath){
					mapdetail.mapdata.append("-");
					gridMap[i][j]="-";
				}
				else{
					mapdetail.mapdata.append("*");
					gridMap[i][j]="*";
				}	

			}
			//mapdetail.mapdata.append(System.getProperty("line.separator"));
		}
		mapdetail.rowSize=buttons.length;
		mapdetail.columnSize=buttons[0].length;
		errorList=new ArrayList();
		boolean isValid=MapValidityHelper.testMapValidity(gridMap,errorList);
		StringBuffer erroCode=new StringBuffer();
		if(!isValid)
		{
			mapdetail.mapdata=new StringBuffer();
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
					int range = 1000 - 0 + 1;
					tArea1.setText(" ");
					Random rn = new Random();
					int fileName =rn.nextInt(range) + 0;
					
					
					/***************************************************START MAP SAVE CODE***************************************************/
					//Code to save file name to a header file
					
					//try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Resource/CustomMaps/GameMatrix/GameMatrixHeader.txt", true)))) {
					//	out.println("Map"+fileName+".txt");
					//}catch (IOException ed) {
					//}
					//Creating a Map File 
					//File file =new File("Resource/CustomMaps/GameMatrix/"+"Map"+fileName+".txt");
					//File logfile =new File("Resource/CustomMaps/GameMatrix/"+"Map"+fileName+".log");
					
					//if(!file.exists()){
						//file.createNewFile();
					//}else{
				//		PrintWriter writer = new PrintWriter(file);
					//	writer.print("");
					//	writer.close();
					//}
					
					 
				    
				   	
				       //get current date time with Date()
				      
					   	
					//try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
					//	out.println(mapdetail.mapdata.toString());
					//}catch (IOException ed) {
					//}
					
					Date date = new Date();
					
				    
					mapdetail.creationTime=time.getTime();
				   	//mapdetail.lastPlayedDate=null;
				   	//mapdetail.lastPlayedTime=null;
				   	mapdetail.mapid=fileName;
				   //	mapdetail.modifiedDate.add(null);
				   //	mapdetail.modifiedTime.add(null);	
				   //	mapdetail.highscore.add(null);
				   	mapdetail.writeToFile(mapdetail);
				   	mapdetail.readFromFile(mapdetail);
				   	
				   	
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
				}
				else{
					MapDetails e=new MapDetails();
					//File file =new File("Resource/CustomMaps/GameMatrix/"+tempFile.fileName);
					System.out.println("Resource/CustomMaps/GameMatrix/"+tempFile.fileName);
					int mapId;
					//if(!file.exists()){
						//file.createNewFile();
					//}else{
						//PrintWriter writer = new PrintWriter(file);
					//	writer.print("");
					//	writer.close();
					//}
					//try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
						//out.println(mapdetail.mapdata.toString());
					//}catch (IOException ed) {
					//}
					
					mapId=Integer.parseInt(tempFile.fileName.substring(tempFile.fileName.lastIndexOf("p") + 1, tempFile.fileName.indexOf(".")));
					System.out.println("Resource/CustomMaps/GameMatrix/"+"MAp"+mapId+".txt");
					e.mapid=mapId;
					e=e.readFromFile(e);
					Date date = new Date();
					e.modifiedTime.add(time.getTime());
					e.mapdata=mapdetail.mapdata;
					
					e.writeToFile(e);
					e.readFromFile(e);
				   	
					
					String tempFileName=tempFile.fileName.replaceAll("txt", "png");
					tempFileName=tempFileName.replaceAll("Map", "ScreenShot");
					
					BufferedImage matrixImage=null;
					matrixImage = new BufferedImage(gameMatrixPanel.getSize().width, gameMatrixPanel.getSize().height,BufferedImage.TYPE_INT_RGB);
					gameMatrixPanel.printAll (matrixImage.getGraphics());
					File file =new File("Resource/CustomMaps/ScreenShots/"+tempFileName);
					
					ImageIO.write(matrixImage, "png", file);
					
					//tempFileName=tempFileName.replaceAll("png","ser");
					//tempFileName=tempFileName.replaceAll("ScreenShot", "Map");
					//System.out.println("Resource/CustomMaps/GameMatrix/"+tempFileName);
					//mapId=Integer.parseInt(tempFileName.substring(tempFileName.lastIndexOf("p") + 1, tempFileName.indexOf(".")));
					//System.out.println("AJAYResource/CustomMaps/ScreenShots/"+mapId);
					
					
					
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
