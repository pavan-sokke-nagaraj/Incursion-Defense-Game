package com.IDG.utils;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class will test the validity of the map.
 * It will be called while saving the class. 
 * @author Arjun
 * @version 1.0
 */
public class MapValidityHelper {

	/**
	 * This Method check for the validity of the Game Map.
	 * @param gridMap Game map matrix 
	 * @return boolean representing validity of the path
	 */
	public static boolean testMapValidity(String[][] gridMap , ArrayList<String> errorList){
		try{
			boolean isValidPath=false;
			StringBuffer errorDesc =new StringBuffer();
			String startPositionCoordinate=checkMapStartOrEndPoint(gridMap,"S",errorList,"Start");
			String endPositionCoordinate=checkMapStartOrEndPoint(gridMap,"E",errorList,"End");
			if(endPositionCoordinate==null||startPositionCoordinate==null){
				for(int i=0;i<errorList.size();i++){
					errorDesc.append(errorList.get(i)).append(System.getProperty("line.separator"));
				}
				return false;
			}

			int xCoordinate=0;
			int yCoordinate=0;
			if(startPositionCoordinate!=null){
				xCoordinate=Integer.parseInt(startPositionCoordinate.substring(0, startPositionCoordinate.indexOf(",")));
				yCoordinate=Integer.parseInt(startPositionCoordinate.substring(startPositionCoordinate.indexOf(",")+1));
			}
			// Set the start point as traversed path.
			gridMap[xCoordinate][yCoordinate]="?";
			int tempXCoordinate=0;
			int tempYCoordinate=0;
			while(!isValidPath){
				boolean isPathFound=false;
				/**
				 * Check for a valid path in each of the 4 position, starting from top and then going clockwise.
				 * For each direction, firstly border check is done so as not traverse out of bound. 
				 * Secondly, check is done to find out if the next element is a path or not.
				 * Thirdly, check is done to find if that path has already been traversed before.
				 */
				if(xCoordinate!=0 && gridMap[xCoordinate-1][yCoordinate]!="*" && gridMap[xCoordinate-1][yCoordinate]!="?"){
					isPathFound=true;
					tempXCoordinate=xCoordinate-1;
					tempYCoordinate=yCoordinate;
				}
				if(yCoordinate<(gridMap[0].length-1) && gridMap[xCoordinate][yCoordinate+1]!="*" && gridMap[xCoordinate][yCoordinate+1]!="?"){
					if(isPathFound){
						errorList.add("Branching found at Row "+(xCoordinate+1)+" and Column "+(yCoordinate+1));
						break;
					}
					isPathFound=true;
					tempYCoordinate=yCoordinate+1;
					tempXCoordinate=xCoordinate;
				}
				if(xCoordinate<(gridMap.length-1) && gridMap[xCoordinate+1][yCoordinate]!="*" && gridMap[xCoordinate+1][yCoordinate]!="?"){
					if(isPathFound){
						errorList.add("Branching found at Row "+(xCoordinate+1)+" and Column "+(yCoordinate+1));
						break;
					}
					isPathFound=true;
					tempYCoordinate=yCoordinate;
					tempXCoordinate=xCoordinate+1;
				}
				if(yCoordinate!=0 && gridMap[xCoordinate][yCoordinate-1]!="*" && gridMap[xCoordinate][yCoordinate-1]!="?"){
					if(isPathFound){
						errorList.add("Branching found at Row "+(xCoordinate+1)+" and Column "+(yCoordinate+1));
						break;
					}
					isPathFound=true;
					tempYCoordinate=yCoordinate-1;
					tempXCoordinate=xCoordinate;
				}
				if(!isPathFound){
					isValidPath=false;
					errorList.add("Dead End found at Row "+(xCoordinate+1)+" and Column "+(yCoordinate+1));
					break;
				}
				xCoordinate=tempXCoordinate;
				yCoordinate=tempYCoordinate;
				if(gridMap[xCoordinate][yCoordinate]=="-"){
					// '?' denotes that the path is already traversed and hence no need to traverse again.
					gridMap[xCoordinate][yCoordinate]="?";
				}else if(gridMap[xCoordinate][yCoordinate]=="E"){
					isValidPath=true;
				}
			}

			checkMapForIslandPath(gridMap,errorList);
			if(errorList.size()>0){
				for(int i=0;i<errorList.size();i++){
					errorDesc.append(errorList.get(i)).append(System.getProperty("line.separator"));
				}
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method check for the validation of Island Paths
	 * @param gridMap Game Map Matrix
	 * @param errorList List to be updated with errors
	 */
	public static boolean checkMapForIslandPath(String [][] gridMap,List<String> errorList){
		for(int i=0;i<gridMap.length;i++){
			for(int j=0;j<gridMap[0].length;j++){
				if(gridMap[i][j].equals("-")){
					errorList.add("Island Path found at Row "+(i+1)+" and Column "+(j+1)+"\n");
				}
			}
		}
		if(errorList.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * This method check for the validation on Start Point and End Point
	 * @param gridMap Game Map Matrix
	 * @param position Start or End
	 * @param errorList List to be updated with errors
	 * @param positionName Name for the start or end
	 * @return Co oridinates for start or end
	 */
	public static String checkMapStartOrEndPoint(String [][] gridMap,String position,List<String> errorList,String positionName){
		int positionCount=0;
		int positionXCoordinate=0;
		int positionYCoordinate=0;
		for(int i=0;i<gridMap.length;i++){
			for(int j=0;j<gridMap[0].length;j++){
				if(gridMap[i][j].equals(position)){
					positionCount++;
					//check for more than one occurence of either Starting Point or End Point
					if (positionCount > 1){
						errorList.add("More than one "+positionName+" is not allowed");
					}
					positionXCoordinate=i;
					positionYCoordinate=j;
				}
			}
		}
		// check for no End Point or Start Point
		if(positionCount == 0){
			errorList.add("Atleast one "+positionName+" should be there in the map");
		}
		//check if start or end are at boundry positions
		if(!(((positionXCoordinate>=0)&&(positionYCoordinate==0))||((positionYCoordinate>=0)&&(positionXCoordinate==0))||((positionXCoordinate>=0)&&(positionYCoordinate==(gridMap[0].length-1)))||((positionYCoordinate>=0)&&(positionXCoordinate==(gridMap.length-1))))){
			errorList.add(positionName+" should be at the boundry positions");
		}
		//Check if there is a wall gap between end and start
		if(position=="S"&&((positionXCoordinate>0&&gridMap[positionXCoordinate-1][positionYCoordinate]=="E")||((positionXCoordinate<(gridMap.length-1))&&gridMap[positionXCoordinate+1][positionYCoordinate]=="E")||((positionYCoordinate<(gridMap[0].length-1))&&gridMap[positionXCoordinate][positionYCoordinate+1]=="E")||((positionYCoordinate>0)&&gridMap[positionXCoordinate][positionYCoordinate-1]=="E"))){
			errorList.add("Atleast a wall gap should be there between Start and End");
		}
		if(errorList.size()>0){
			return null;
		}
		// return the start and end Point Co-ordinates
		return new Integer(positionXCoordinate).toString()+","+new Integer(positionYCoordinate).toString();
	}
}