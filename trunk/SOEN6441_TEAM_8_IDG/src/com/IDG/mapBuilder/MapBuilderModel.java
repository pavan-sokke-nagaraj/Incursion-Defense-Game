package com.IDG.mapBuilder;


import javax.swing.*;

import com.IDG.utils.PopClickListener;

import java.awt.event.*;
/**
 * Model for the MapBuilder where each element is a JBtutton
 * @author Arjun Kariappa
 * this class implements the actionListener of the map built, depends on where the button was pressed certain actions are invoked
 * 
 * */
public class MapBuilderModel extends JButton implements ActionListener{
	public ImageIcon path,brick,start,end;
	int id=0;
	public boolean isStart;
	public boolean isEnd;
	public boolean isPath;
	public boolean isWall;
	public byte value=0;
	public String fileName;
	public String mapType;
	public String fileType;
	/**
	 * This constructor will initialize the the members of the class.
	 */
	public MapBuilderModel()
	{
		path=new ImageIcon("Resource/GameImages/green.jpg");
		start=new ImageIcon("Resource/GameImages/start.jpg");
		end=new ImageIcon("Resource/GameImages/end.png");
		isStart=false;
		isEnd=false;
		isPath=false;
		isWall=false;
		this.addActionListener(this);
		this.addMouseListener(new PopClickListener(this));
	}

	public MapBuilderModel(String fileName,String mapType,String fileType){
		this.fileName=fileName;
		this.mapType=mapType;
		this.fileType=fileType;
	}

	/**
	 * Invoked when an action occurs, if the byte value on the map is 0(where the button is pressed), the icon is set to null and the path is set to false
	 * the start point  and end point is set to false
	 * if the byte value is 1 then the icon is set show the path image ans the path is set to true,
	 * the start and end points are set to false
	 * */
	public void actionPerformed (ActionEvent e) 
	{
		if(this.isPath)
			this.setPath(false);
		value++;
		value%=2;
		switch(value) {
		case 0:
			//Indicate wall
			setIcon(null);
			this.setPath(false);
			this.setStart(false);
			this.setEnd(false);
			break;
		case 1:
			//Indicate Path
			setIcon(path);
			this.setPath(true);
			this.setStart(false);
			this.setEnd(false);
			break;

		}
	}
	
	/**
	 * Setters and Getters of the data members
	 **/
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


	public ImageIcon getBrick() {
		return brick;
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
