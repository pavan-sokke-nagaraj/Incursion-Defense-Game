package com.IDG.mapBuilder;

import javax.swing.*;
import java.awt.event.*;
/**
 * this class implements the actionListener of the map built, depends on where the button was pressed certain actions are invoked
 * 
 * */
public class Wall extends JButton implements ActionListener{
	public ImageIcon path,brick,start,end;



	int id=0;
    boolean isStart;// isStart of the path
    boolean isEnd;// is end of the path
    boolean isPath;// is it on the path
    boolean isWall;// is it a wall not a path
    byte value=0;// the value of the tile
	
	
	public Wall()
	{
		path=new ImageIcon("Resource/GameImages/green.jpg");
		brick=new ImageIcon("D://path2.png");
		start=new ImageIcon("Resource/GameImages/start.jpg");
		end=new ImageIcon("Resource/GameImages/end.png");
		
		
		isStart=false;
		isEnd=false;
		isPath=false;
		isWall=false;
		this.addActionListener(this);
		this.addMouseListener(new PopClickListener(this));
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
* setters and getters on the class data members 
* */
    



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
}
