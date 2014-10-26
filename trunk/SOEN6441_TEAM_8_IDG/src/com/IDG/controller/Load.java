package com.IDG.controller;

/**
 * 
 */


/**
 * @author Kariappa
 *
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.IDG.controller.MapButton;
import com.IDG.controller.wall;


public class Load  extends JFrame  {

	JPanel mapGrid=new JPanel();
	JPanel dMapGrid=new JPanel();
	JPanel udMapGrid=new JPanel();
	JPanel gameButtons=new JPanel();
	JPanel align =new JPanel();
	JFrame p2= new JFrame();
	String fileName1=null;
	String mapType1 = null;
	JButton save = new JButton("Save");
	JButton edit = new JButton("Edit");
	JButton game = new JButton("Start Game");
	JButton dMap4 = new JButton("Level4");
	JButton udMap4 = new JButton("Level4");
	JButton dMap1 = new JButton("Level1");
	JButton udMap1 = new JButton("Level1");
	JButton dMap2 = new JButton("Level2");
	JButton udMap2 = new JButton("Level2");
	JButton dMap3 = new JButton("Level3");
	JButton udMap3 = new JButton("Level3");

	public Load()
	{
		
		super("MAPBuilder V 2.0");
		p2.setSize(850,700);
		p2.setLocationRelativeTo(null);
		dMap1.setPreferredSize(new Dimension(60, 60));
		udMap1.setPreferredSize(new Dimension(60, 60));
		
		
		/*************************************************************MY CODE*********************************************************************/
		//Read ScreenShotHeaderFile
		setgridLayoutForMaps("CustomMaps",udMapGrid);
		setgridLayoutForMaps("DefaultMaps",dMapGrid);
		align.setLayout(new BorderLayout());
		align.add(udMapGrid,BorderLayout.EAST);
		align.add(dMapGrid,BorderLayout.WEST);
		gameButtons.setLayout(new GridLayout(1,3));
		gameButtons.add(save);
		gameButtons.add(edit);
		gameButtons.add(game);
		p2.setLayout(new BorderLayout());
		p2.add(align,BorderLayout.EAST);
		p2.add(gameButtons,BorderLayout.SOUTH);
		Component[] components = p2.getComponents();
		System.out.println("Number of Comp="+components.length);
		p2.setVisible(true);
	}
	
	public void setgridLayoutForMaps(String mapType,JPanel grid){
		Scanner sc=null;
		String line=null;
		try {
			sc = new Scanner(new File("Resource/"+mapType+"/ScreenShots/ScreenShotsHeader.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList <MapButton>udButtonList= new ArrayList <MapButton> ();
		while(sc.hasNextLine()) {
			line=sc.nextLine().toString();
			if(line!=null&&line!=""){
				setLabelsForScreenShots(line,udButtonList,mapType);
			}
		}
		if(udButtonList.size()==0) {
			grid.setLayout(new GridLayout(1,1));
		} else{
			grid.setLayout(new GridLayout(udButtonList.size(),udButtonList.size()));
		}
		for (int i=0;i<udButtonList.size();i++)
		{
			grid.add(udButtonList.get(i));
		}
	}
	
	public void setLabelsForScreenShots(String fileName,ArrayList <MapButton>buttonList,String mapType ){
		BufferedImage myPicture=null;
		fileName1=fileName;
		mapType1=mapType;
		try {
		//	myPicture = ImageIO.read(new File("Resource/CustomMaps/ScreenShots/"+fileName));
			myPicture = ImageIO.read(new File("D://end.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Snapshot code
		//Image scaledImage = myPicture.getScaledInstance(jPanel.getWidth(),jPanel.getHeight(),Image.SCALE_SMOOTH);
		fileName1=fileName1.replaceAll("png", "txt");
		fileName1=fileName1.replaceAll("ScreenShot", "Map");
		MapButton picLabel = new MapButton(fileName1);
		if(mapType.equals("CustomMaps")){
			picLabel.setText("User Defined Map "+(buttonList.size()+1));
		}else{
			picLabel.setText("Default Map "+(buttonList.size()+1));
		}
		//picLabel.setIcon(new ImageIcon(myPicture));
		//picLabel.setMaximumSize(new Dimension(10,10));
		picLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MapButton file = (MapButton)e.getSource();
				setGameMatrixOnPanel(new File("Resource/"+mapType1+"/GameMatrix/"+file.fileName));
			}
		});
		buttonList.add(picLabel);
	}
	
	public void setGameMatrixOnPanel(File mapFile){
		System.out.println(mapFile.getName());
		mapGrid.removeAll();
		mapGrid.revalidate();
		
		mapGrid.setVisible(false);
		
		//p2.dispose();
		List<String> lines=new ArrayList();
		Scanner sc=null;
		String line1=null;
		try {
			sc = new Scanner(mapFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNextLine()) {
			line1=sc.nextLine().toString().trim();
			if(line1!=null&&!line1.isEmpty()){
				lines.add(line1);
			}
		}

		// to array
		int rows = lines.size();              // number of rows
		int cols = 0;                         // number of columns
		for(String line : lines) {
			cols = Math.max(cols, line.length());
		}
		int i = 0,j=0;
		
		wall wl=null;
		int count=0;
		wall loadbuttons[][]=new wall[rows][cols];
		setPreferredSize(new Dimension(40, 40));
		for(String line : lines) {            // for each line, add the 1s
			char[] chars = line.toCharArray();
			
			for(j = 0 ; j < chars.length ; ++j) {
				wl=new wall();
				switch(chars[j]) {
				case '*':
					wl.setIcon(null);
					wl.setPath(false);
					break;
				case '-':
					wl.setIcon(wl.getPath());
					wl.setPath(true);
					break;
				case 'S':
					wl.setIcon(wl.getStart());
					wl.setStart(true);
					break;
				case 'E':
					wl.setIcon(wl.getEnd());
					wl.setEnd(true);
					break;
				
				}
				count++;
				loadbuttons[i][j]=wl;
			}
			i++;

		}
		
		for( i=0;i<loadbuttons.length;i++){
			for(j=0;j<loadbuttons[0].length;j++){
				loadbuttons[i][j].setPreferredSize(new Dimension(40,40));
				mapGrid.add(loadbuttons[i][j]);
			}}
		for ( i=0;i<loadbuttons.length;i++){
			for ( j=0;j<loadbuttons[0].length;j++){
				if(!loadbuttons[i][j].isPath)
				loadbuttons[i][j].setEnabled(false);
				
				
			}
		}
		mapGrid.setVisible(true);
		mapGrid.setLayout(new GridLayout(loadbuttons.length,loadbuttons[0].length));
		System.out.println("Number="+mapGrid.getComponentCount());
		p2.add(mapGrid,BorderLayout.CENTER);
		p2.setVisible(true);
	}
}
