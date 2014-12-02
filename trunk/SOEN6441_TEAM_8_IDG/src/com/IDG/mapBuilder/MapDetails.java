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
/**
 * Stores all Map related data
 * 
 * @author Kariappa 
 * @version Build 1
 * @since Build 3
 *
 */

public class MapDetails implements Serializable {
	/**
	 * Variable to change format of Date/Time Saved
	 */
	public SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	/**
	 * Variable to change format of Date/Time Saved
	 */
	public DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Variable to store creation date
	 */
	public Date creationTime = null;
	/**
	 * stores row size of Map
	 */
	public int rowSize;
	/**
	 * Stores Column Size of Map
	 */
	public int columnSize;
	/**
	 * ArrayList to store all time stamps when a Map is Modified
	 */
	public ArrayList<Date> modifiedTime = new ArrayList();
	/**
	 * ArrayList to store all time stamps when a Map is played
	 */
	public ArrayList<Date> lastPlayedTime = new ArrayList();
	/**
	 * Stores Mapid - Part of filename to  identify the map file.
	 */
	public int mapid;
	/**
	 * Stores the MAP 
	 */
	public StringBuffer mapdata = new StringBuffer();
	/**
	 * Arraylist  of size 5 to store the High Score
	 */
	public ArrayList<Integer> highscore = new ArrayList(5);
	/**
	 * Stores the Game status /WON/LOST/TERMINATED 
	 */
	public ArrayList<String> gamestatus = new ArrayList();

	public MapDetails() {

	}
	
	/**
	 * Function to Write Serialized object to File .
	 */
	public void writeToFile(MapDetails e) {
		if (e.mapid == 955 || e.mapid == 608 || e.mapid == 167) {
			try {
				FileOutputStream fileOut = new FileOutputStream(
						"Resource/DefaultMaps/GameMatrix/Map" + e.mapid
								+ ".txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(e);
				out.close();
				fileOut.close();
				System.out
						.printf("Serialized data is saved in /Resource/DefaultMaps/GameMatrix/Map"
								+ e.mapid + ".txt");
			} catch (IOException i) {
				i.printStackTrace();
			}
		} else {
			try {
				FileOutputStream fileOut = new FileOutputStream(
						"Resource/CustomMaps/GameMatrix/Map" + e.mapid + ".txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(e);
				out.close();
				fileOut.close();
				System.out
						.printf("Serialized data is saved in /Resource/CustomMaps/GameMatrix/Map"
								+ e.mapid + ".txt");
			} catch (IOException i) {
				i.printStackTrace();
			}

		}
	}

	/**
	 * Function to Read Serialized object from File .
	 */
	public MapDetails readFromFile(MapDetails e1) {
		MapDetails e = e1;
		if (e.mapid == 955 || e.mapid == 608 || e.mapid == 167) {
			try {
				FileInputStream fileIn = new FileInputStream(
						"Resource/DefaultMaps/GameMatrix/Map" + e.mapid
								+ ".txt");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				e = (MapDetails) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException i) {
				i.printStackTrace();

			} catch (ClassNotFoundException c) {
				System.out.println("Employee class not found");
				c.printStackTrace();

			}
		}

		else {
			try {
				FileInputStream fileIn = new FileInputStream(
						"Resource/CustomMaps/GameMatrix/Map" + e.mapid + ".txt");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				e = (MapDetails) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException i) {
				i.printStackTrace();

			} catch (ClassNotFoundException c) {

				c.printStackTrace();

			}
		}

		return e;
	}

}
