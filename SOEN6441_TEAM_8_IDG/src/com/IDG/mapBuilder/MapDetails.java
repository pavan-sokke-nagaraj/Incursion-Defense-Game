package com.IDG.mapBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import com.IDG.mapSimulator.MapSimulatorView;

public class MapDetails implements Serializable {

	public SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	public DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Date creationTime =null;
	public int rowSize;
	public int columnSize;
	public ArrayList<Date> modifiedTime = new ArrayList();
	
	public ArrayList<Date> lastPlayedTime = new ArrayList();
	
	public  int mapid;
	public StringBuffer mapdata=new StringBuffer();
	public ArrayList<Integer> highscore=new ArrayList(5);
    public ArrayList<String> gamestatus=new ArrayList();
   public MapDetails()
    {
	   
    }
    
    	
   public void writeToFile (MapDetails e)
   {
	   if(e.mapid==955||e.mapid==608||e.mapid==167)
	   {
		   try
	      {
		   
	         FileOutputStream fileOut=new FileOutputStream("Resource/DefaultMaps/GameMatrix/Map"+e.mapid+".txt");
	         
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /Resource/DefaultMaps/GameMatrix/Map"+e.mapid+".txt");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }

	   }
	   
	   else
	   {
		   try
	      {
		   
	         FileOutputStream fileOut=new FileOutputStream("Resource/CustomMaps/GameMatrix/Map"+e.mapid+".txt");
	         
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /Resource/CustomMaps/GameMatrix/Map"+e.mapid+".txt");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }

	   }
	  }


   public MapDetails readFromFile (MapDetails e1)
   {
	   MapDetails e=e1;
	if(e.mapid==955||e.mapid==608||e.mapid==167)
	{
		 try
		   {
		      FileInputStream fileIn = new FileInputStream("Resource/DefaultMaps/GameMatrix/Map"+e.mapid+".txt");
		      ObjectInputStream in = new ObjectInputStream(fileIn);
		      e = (MapDetails) in.readObject();
		      in.close();
		      fileIn.close();
		   }catch(IOException i)
		   {
		      i.printStackTrace();
	
		   }catch(ClassNotFoundException c)
		   {
		      System.out.println("Employee class not found");
		      c.printStackTrace();
		     
		   }
	}
   
	else
	{
		try
	
   {
      FileInputStream fileIn = new FileInputStream("Resource/CustomMaps/GameMatrix/Map"+e.mapid+".txt");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      e = (MapDetails) in.readObject();
      in.close();
      fileIn.close();
   }catch(IOException i)
   {
      i.printStackTrace();
     
   }catch(ClassNotFoundException c)
   {
      
      c.printStackTrace();
     
   }
	}
  
   return e;
   }
   
   

}

