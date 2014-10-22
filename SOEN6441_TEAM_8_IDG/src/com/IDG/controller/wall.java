import javax.swing.*;
import java.awt.event.*;

public class wall extends JButton implements ActionListener{
	public ImageIcon upDirectionImg,downDirectionImg,rightDirectionImg,leftDirectionImg;
	int id=0;
	boolean isStart;
	boolean isEnd;
	boolean isPath;
	boolean isWall;
	byte value=0;
	char direction;
	
	public wall()
	{
		leftDirectionImg=new ImageIcon("F://path3.png");
		rightDirectionImg=new ImageIcon("F://path2.png");
		upDirectionImg=new ImageIcon("F://path.png");
		downDirectionImg=new ImageIcon("F://path4.png");
		
		isStart=false;
		isEnd=false;
		isPath=false;
		isWall=false;
		this.addActionListener(this);
	}


	public void actionPerformed (ActionEvent e) 
	{


			this.setPath(true);
			value++;
			value%=5;
			System.out.println("Value"+value);
			switch(value) {
			case 0:
				setIcon(null);
				this.setPath(false);
				this.setDirection('B');
				break;
			case 1:
				setIcon(rightDirectionImg);
				this.setPath(true);
				this.setDirection('R');
				break;
			case 2:
				setIcon(leftDirectionImg);
				this.setPath(true);
				this.setDirection('L');
				break;
			case 3:
				setIcon(upDirectionImg);
				this.setPath(true);
				this.setDirection('U');
				break;
			case 4:
				setIcon(downDirectionImg);
				this.setPath(true);
				this.setDirection('D');
				break;
				

			}
		
		
		System.out.println("Button Pressed"+id+this.isPath());

	}

	public char getDirection() {
		return direction;
	}


	public void setDirection(char direction) {
		this.direction = direction;
	}


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


	public ImageIcon getUpDirectionImg() {
		return upDirectionImg;
	}


	public void setUpDirectionImg(ImageIcon upDirectionImg) {
		this.upDirectionImg = upDirectionImg;
	}


	public ImageIcon getDownDirectionImg() {
		return downDirectionImg;
	}


	public void setDownDirectionImg(ImageIcon downDirectionImg) {
		this.downDirectionImg = downDirectionImg;
	}


	public ImageIcon getRightDirectionImg() {
		return rightDirectionImg;
	}


	public void setRightDirectionImg(ImageIcon rightDirectionImg) {
		this.rightDirectionImg = rightDirectionImg;
	}


	public ImageIcon getLeftDirectionImg() {
		return leftDirectionImg;
	}


	public void setLeftDirectionImg(ImageIcon leftDirectionImg) {
		this.leftDirectionImg = leftDirectionImg;
	}
}