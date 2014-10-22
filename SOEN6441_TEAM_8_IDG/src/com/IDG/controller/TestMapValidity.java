import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//no loop: path should not cross itself.
//
public class TestMapValidity {

	public static void main(String[] args) {
		String[][] gridMap = new String[5][5];
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				gridMap[i][j]="*";
			}
		}
		gridMap[0][1]="S";
		gridMap[1][1]="-";
		gridMap[2][1]="-";
		gridMap[2][2]="-";
		gridMap[2][3]="-";
		gridMap[2][4]="-";
		gridMap[3][3]="-";
		gridMap[4][3]="E";
		for(int x=0;x<5;x++){
			for(int y=0;y<5;y++){
				System.out.print(gridMap[x][y]);
			}
			System.out.println("");
		}
		testMapValidity(gridMap);
	}
	/**
	 * Method check for the validity of the Game Map
	 * @param gridMap Game map matrix 
	 * @return boolean representing validity of the path
	 */
	public static boolean testMapValidity(String[][] gridMap){
		try{
			boolean isValidPath=false;
			File file = new File("MapError.txt");
			BufferedWriter errorOutput=null;
			errorOutput = new BufferedWriter(new FileWriter(file));
			StringBuffer errorDesc =new StringBuffer();
			System.out.println("Path Followed");
			List<String> errorList= new ArrayList<String>();
			String startPositionCoordinate=checkMapStartOrEndPoint(gridMap,"S",errorList);
			if(startPositionCoordinate==null){
				errorDesc.append(errorList.get(0)).append("\n");
				errorOutput.write(errorDesc.toString());
				errorOutput.close();
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);
				return false;
			}
			checkMapStartOrEndPoint(gridMap,"E",errorList);
			if(startPositionCoordinate==null){
				errorDesc.append(errorList.get(0)).append("\n");
				errorOutput.write(errorDesc.toString());
				errorOutput.close();
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);
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
				}
				if(yCoordinate<=4 && gridMap[xCoordinate][yCoordinate+1]!="*" && gridMap[xCoordinate][yCoordinate+1]!="?"){
					if(isPathFound){
						errorList.add("Branching of Path found at Row "+xCoordinate+" and Column "+yCoordinate);
						break;
					}
					isPathFound=true;
					tempYCoordinate=yCoordinate+1;
				}
				if(xCoordinate<=4 && gridMap[xCoordinate+1][yCoordinate]!="*" && gridMap[xCoordinate+1][yCoordinate]!="?"){
					if(isPathFound){
						errorList.add("Branching of Path found at Row "+xCoordinate+" and Column "+yCoordinate);
						break;
					}
					isPathFound=true;
					tempXCoordinate=xCoordinate+1;
				}
				if(yCoordinate!=0 && gridMap[xCoordinate][yCoordinate-1]!="*" && gridMap[xCoordinate][yCoordinate-1]!="?"){
					if(isPathFound){
						errorList.add("Branching of Path found at Row "+xCoordinate+" and Column "+yCoordinate);
						break;
					}
					isPathFound=true;
					tempYCoordinate=yCoordinate-1;
				}
				if(!isPathFound){
					isValidPath=false;
					errorList.add("Dead End found at Row "+xCoordinate+" and Column "+yCoordinate);
					break;
				}
				xCoordinate=tempXCoordinate;
				yCoordinate=tempYCoordinate;
				System.out.println("x="+xCoordinate+",y="+yCoordinate);
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
				errorOutput.write(errorDesc.toString());
				errorOutput.close();
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);
				return false;
			}else{
				errorOutput.write("Validation Succesfull");
				errorOutput.close();
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	private static void checkMapForIslandPath(String [][] gridMap,List<String> errorList){
		outerLoop:
			for(int i=0;i<gridMap.length;i++){
				for(int j=0;j<gridMap[0].length;j++){
					if(gridMap[i][j].equals("-")){
						errorList.add("Island Path found at Row "+i+" and Column "+j+"\n");
						break outerLoop;
					}
				}
			}
	}

	private static String checkMapStartOrEndPoint(String [][] gridMap,String position,List<String> errorList){
		int positionCount=0;
		int positionXCoordinate=0;
		int positionYCoordinate=0;
		for(int i=0;i<gridMap.length;i++){
			for(int j=0;j<gridMap[0].length;j++){
				if(gridMap[i][j].equals(position)){
					positionCount++;
					//check for more than one occurance of either Starting Point or End Point
					if (positionCount > 1){
						errorList.add("More than one "+position+" is not allowed");
						return null;
					}
					positionXCoordinate=i;
					positionYCoordinate=j;
				}
			}
		}
		// check for no End Point or Start Point
		if(positionCount == 0){
			errorList.add("Atleast one "+position+" should be there in the map");
			return null;
		}
		// return the Start Point Co-ordinates
		return new Integer(positionXCoordinate).toString()+","+new Integer(positionYCoordinate).toString();
	}
}
