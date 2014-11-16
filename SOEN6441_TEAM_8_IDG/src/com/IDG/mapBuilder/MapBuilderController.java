package com.IDG.mapBuilder;

/**
 * 
 */


/**
 * @author Kariappa @author Arjun
 *
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.IDG.controller.LayoutManager;
import com.IDG.mapBuilder.MapBuilderModel;


public class MapBuilderController    {

	JPanel mapGrid=new JPanel();
	ArrayList<String> errorList = null;
	MapBuilderModel temp[][]=null;
	MapBuilderModel temp1[][]=null;
	MapBuilderModel loadbuttons[][];
	JPanel dMapGrid=new JPanel();
	JPanel udMapGrid=new JPanel();
	JPanel gameButtons=new JPanel();
	JPanel align =new JPanel();
	JFrame p2= new JFrame();
	String fileName1=null;
	JLabel headerLabel;
	JButton save = new JButton("Save");
	JButton edit = new JButton("Edit");
	JButton create = new JButton("Create New MAP");
	JButton game = new JButton("Start Game!!");
	JButton dMap4 = new JButton("Level4");
	JButton udMap4 = new JButton("Level4");
	JButton dMap1 = new JButton("Level1");
	JButton udMap1 = new JButton("Level1");
	JButton dMap2 = new JButton("Level2");
	JButton udMap2 = new JButton("Level2");
	JButton dMap3 = new JButton("Level3");
	JButton udMap3 = new JButton("Level3");
	JTextArea tArea1 = new JTextArea(15,30);
	int gridRow = 0;
	int gridColumn = 0;
	String mapType1 = null;
	int counter= 0;
	MapBuilderModel file=null;
	boolean isEditEnabled;
	MapBuilderModel tempLoadbuttons[][];
	public static File rfile;
	public MapBuilderController()
	{	//this.rfile=rfile;
		tArea1.setLineWrap(true);
		tArea1.setText("Validation Status");
		JScrollPane scroller1 = new JScrollPane();
		scroller1.setViewportView(tArea1);
		headerLabel = new JLabel("<html>Welcome to the MAP Editor <br>Click the buttons to build a path</html>");
		p2.setTitle("MAPBuilder v1.0");
		p2.setSize(1100,600);
		p2.setLocationRelativeTo(null);
		dMap1.setPreferredSize(new Dimension(60, 60));
		udMap1.setPreferredSize(new Dimension(60, 60));


		/*************************************************************MY CODE*********************************************************************/
		//Read ScreenShotHeaderFile
		setgridLayoutForMaps("CustomMaps",udMapGrid);
		setgridLayoutForMaps("DefaultMaps",dMapGrid);
		gameactionbuttons ();
		align.setLayout(new BorderLayout());
		align.add(udMapGrid,BorderLayout.EAST);
		align.add(dMapGrid,BorderLayout.CENTER);
		align.add(scroller1,BorderLayout.WEST);
		align.add(headerLabel,BorderLayout.NORTH);
		gameButtons.setLayout(new GridLayout(1,4));
		gameButtons.add(save);
		gameButtons.add(edit);
		gameButtons.add(game);
		gameButtons.add(create);
		//save.setEnabled(false);
		p2.setLayout(new BorderLayout());
		p2.add(align,BorderLayout.EAST);
		p2.add(gameButtons,BorderLayout.SOUTH);
		Component[] components = p2.getComponents();
		System.out.println("Number of Comp="+components.length);
		setGameMatrixOnPanel(new File("Resource/DefaultMaps/GameMatrix/Map129.txt"));
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
		ArrayList <MapBuilderModel>udButtonList= new ArrayList <MapBuilderModel> ();
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

	public void setLabelsForScreenShots(String fileName,ArrayList <MapBuilderModel>buttonList,String mapType ){
		BufferedImage myPicture=null;
		fileName1=fileName;
		mapType1=mapType;
		try {
			myPicture = ImageIO.read(new File("Resource/"+mapType+"/ScreenShots/"+fileName));
			//myPicture = ImageIO.read(new File("D://end.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Snapshot code
		fileName1=fileName1.replaceAll("png", "txt");
		fileName1=fileName1.replaceAll("ScreenShot", "Map");
		MapBuilderModel picLabel = new MapBuilderModel(fileName1,mapType1,mapType);
		if(mapType.equals("CustomMaps")){
			picLabel.setText("User Defined Map "+(buttonList.size()+1));
		}else{
			picLabel.setText("Default Map "+(buttonList.size()+1));
		}
		ImageIcon ii = new ImageIcon(myPicture);
		int scale = 10; // 2 times smaller
		int width = ii.getIconWidth();
		int newWidth = width / scale;
		picLabel.setIcon(new ImageIcon(ii.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
		picLabel.setMaximumSize(new Dimension(10,10));
		picLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				file = (MapBuilderModel)e.getSource();
				setGameMatrixOnPanel(new File("Resource/"+file.mapType+"/GameMatrix/"+file.fileName));
			}
		});
		buttonList.add(picLabel);
	}

	public void setGameMatrixOnPanel(File mapFile){
		System.out.println(mapFile.getName());
		mapGrid.removeAll();
		mapGrid.revalidate();
		List<String> lines=new ArrayList();
		Scanner sc=null;
		String line1=null;
		try {
			sc = new Scanner(mapFile);
		} catch (FileNotFoundException e) {
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
		MapBuilderModel wl=null;
		int count=0;
		tempLoadbuttons=new MapBuilderModel[rows][cols];
		
		for(String line : lines) {            // for each line, add the 1s
			char[] chars = line.toCharArray();

			for(j = 0 ; j < chars.length ; ++j) {
				wl=new MapBuilderModel();
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
				tempLoadbuttons[i][j]=wl;
			}
			i++;

		}

		for( i=0;i<tempLoadbuttons.length;i++)
		{
			for(j=0;j<tempLoadbuttons[0].length;j++)
			{
				tempLoadbuttons[i][j].setPreferredSize(new Dimension(40,40));
				mapGrid.add(tempLoadbuttons[i][j]);
			}
		}
		for ( i=0;i<tempLoadbuttons.length;i++)
		{
			for ( j=0;j<tempLoadbuttons[0].length;j++)
			{
				if(!tempLoadbuttons[i][j].isPath)
					tempLoadbuttons[i][j].setEnabled(false);
			}
		}
		mapGrid.setVisible(true);
		mapGrid.setLayout(new GridLayout(tempLoadbuttons.length,tempLoadbuttons[0].length));
		System.out.println("Number="+mapGrid.getComponentCount());
		p2.add(mapGrid,BorderLayout.CENTER);
		p2.setVisible(true);
		temp=tempLoadbuttons;
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!file.fileType.equals("DefaultMaps")){
					for ( int i=0;i<temp.length;i++){
						for ( int j=0;j<temp[0].length;j++){
							temp[i][j].setEnabled(true);
						}
					}
					temp1=temp;
					save.setEnabled(true);
					isEditEnabled=true;
				}
			}
		});

	}

	void gameactionbuttons ()
	{
		temp=loadbuttons;



		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel rowColPanel = new JPanel();
				
				JTextField rowField = new JTextField(2);
				JTextField colField = new JTextField(2);
				
				
				rowColPanel.setLayout(new BoxLayout(rowColPanel, BoxLayout.Y_AXIS));
				rowColPanel.add(new JLabel("Number of Rows (MAX 15)",
						SwingConstants.CENTER));
				rowColPanel.add(rowField);

				rowColPanel.add(Box.createVerticalStrut(10)); // a spacer
				rowColPanel.add(new JLabel("Number of Columns (MAX 15)"));
				rowColPanel.add(colField);
				int result = JOptionPane.showConfirmDialog(null, rowColPanel,
						"Please Enter Number of rows and columns",
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("rowField row value: " + rowField.getText());
					System.out.println("colField col value: " + colField.getText());
					gridRow = Integer.parseInt(rowField.getText());
					gridColumn = Integer.parseInt(colField.getText());
					
				}
				if(gridColumn>15 || gridRow>15 )
				{
					JFrame error= new JFrame();
					error.setTitle("");
					JOptionPane.showMessageDialog(error,
							"<html>Map creation failed!<br>Row and Column size limited to 15.<br>Please retry!</html> ");
					//error.add(new JLabel("Row and Column size limited to 15"),SwingConstants.CENTER);
					//JOptionPane.showConfirmDialog(null, rowColPanel,"Row and Column size limited to 15",
							//JOptionPane.OK_CANCEL_OPTION);
					
				}

				else
				{
				temp1=new MapBuilderModel[gridRow][gridColumn];
				mapGrid.removeAll();
				mapGrid.revalidate();
				//mapGrid.setVisible(false);
				for(int i=0;i<gridRow;i++){
					for(int j=0;j<gridColumn;j++){
						temp1[i][j]=new MapBuilderModel();
						temp1[i][j].setPreferredSize(new Dimension(40, 40));
						mapGrid.add(temp1[i][j]);	
					}
				}
				mapGrid.setLayout(new GridLayout(gridRow, gridColumn));
				mapGrid.setVisible(true);
				errorList = new ArrayList<String>();

			}
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MapSaver(temp1,errorList,tArea1,mapGrid,gridRow,gridColumn,isEditEnabled,file);
				System.out.println("SAve clicked");
				udMapGrid.removeAll();
				udMapGrid.revalidate();
				udMapGrid.repaint();
				setgridLayoutForMaps("CustomMaps",udMapGrid);
				if(tArea1.getText().toString().length()>17&&file!=null){
					isEditEnabled=true;
				}else{
					isEditEnabled=false;
				}


			}	

		});
		
		game.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p2.dispose();
				LayoutManager abc=new LayoutManager();
				File file1=new File("Resource/CustomMaps/ScreenShots/Metadata.txt");
			/**	if(!file1.exists()){
					try {
						file1.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					PrintWriter writer=null;
					try {
						writer = new PrintWriter(file1);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					writer.print("");
					writer.close();
				}**/
				try {
					PrintWriter writer=null;
					try {
						writer = new PrintWriter(file1);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					writer.print(file.fileName+","+file.fileType);
					writer.close();
					System.out.println(file.fileName+","+file.fileType);
					abc.populateFileHeader();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//tAre21.setText(file.fileName);
				
				//rfile=new File("Resource/"+file.fileType+"/GameMatrix/"+file.fileName);
}	

		});

System.out.println("AJAY"+rfile);
	}
}
