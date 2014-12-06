

/**
 * 
 */
package com.IDG.mapBuilder;


import javax.swing.*;

import com.IDG.utils.PopClickListener;

import java.awt.event.*;
/**
 * This is the Model class that defines the basic element of the MAPbuilder application (Buttons) . 
 * The class extends Jbuttons and creates a new data type MapbuilderModel that contains attributes that define th mapbuilder.
 *  
 * @author Kariappa @author Arjun
 * @version Build 1
 * @since Build 1
 *
 */

public class MapBuilderModel extends JButton implements ActionListener{
	
	/**
	 * Different Images for start, end and wall
	 */
	public ImageIcon path,start,end;
	int id=0;
	/**
	 * boolean to check if current element is start
	 */
	public boolean isStart;
	/**
	 * boolean to check if current element is End
	 */
	public boolean isEnd;
	/**
	 * boolean to check if current element is path
	 */
	public boolean isPath;
	/**
	 * boolean to check if current element is wall
	 */
	public boolean isWall;
	/**
	 * Value representing wall,path or start, end
	 */
	public byte value=0;
	public String fileName;
	public String mapType;
	public String fileType;
	
	
	/**
	 * constructor that will intialize all Mapbuilder-buttons created during runtime .
	 * 
	 */
	public MapBuilderModel()
	{
		isStart=false;  //class attribute used to indicate the Mapbuilder-button is a starting point .
		isEnd=false;    //class attribute used to indicate the Mapbuilder-button is an ending/finish point .
		isPath=false;	//class attribute used to indicate the Mapbuilder-button is part of the critter path.
		isWall=false;	//class attribute used to indicate the Mapbuilder-button is a brick .
		
		path=new ImageIcon("Resource/GameImages/green.jpg"); // filesystem-Paths to image for a path Mapbuilder-button
		start=new ImageIcon("Resource/GameImages/start.jpg"); // filesystem-Paths to image for a start Mapbuilder-button
		end=new ImageIcon("Resource/GameImages/end.png");     // filesystem-Paths to image for a end Mapbuilder-button
		
		this.addActionListener(this); // each button clicked to is hooked to an action listner that listens to left mouse click events .
		this.addMouseListener(new PopClickListener(this)); //each button clicked to is hooked to an action listner that listens to right mouse click event and invokes the constructor PopClickListener  .
	}
	
	
	/**
	 * @param fileName
	 * @param mapType
	 * @param fileType
	 */
	public MapBuilderModel(String fileName,String mapType,String fileType){
		this.fileName=fileName;
		this.mapType=mapType;
		this.fileType=fileType;
	}


	public void actionPerformed (ActionEvent e) 
	{


			if(this.isPath)
				this.setPath(false);
			value++;
			value%=2;
			System.out.println("Value"+value);
			switch(value) {
			case 0:
				setIcon(null);
				this.setPath(false);
				this.setStart(false);
				this.setEnd(false);
				break;
			case 1:
				setIcon(path);
				this.setPath(true);
				this.setStart(false);
				this.setEnd(false);
				break;
			
			}
		
		
		System.out.println("Button Pressed"+id+this.isPath());

	}

	
	/**
	 * Getter setter methods for all class defined attributes .
	 * 
	 */
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isStart() {
		return isStart;
	}


	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}


	public boolean isEnd() {
		return isEnd;
	}


	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}


	public boolean isPath() {
		return isPath;
	}


	public void setPath(boolean isPath) {
		this.isPath = isPath;
	}


	public boolean isWall() {
		return isWall;
	}


	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}


	public byte getValue() {
		return value;
	}


	public void setValue(byte value) {
		this.value = value;
	}


	public ImageIcon getPath() {
		return path;
	}


	public ImageIcon getStart() {
		return start;
	}


	public void setStart(ImageIcon start) {
		this.start = start;
	}


	public ImageIcon getEnd() {
		return end;
	}


	public void setEnd(ImageIcon end) {
		this.end = end;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMapType() {
		return mapType;
	}
	public void setMapType(String mapType) {
		this.mapType = mapType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
