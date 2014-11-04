package com.IDG.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.IDG.utils.MapValidityHelper;

public class MapValidityTestCase {
	String[][] gridMap;
	ArrayList<String> errorList;
	@Before
	public void setUp() throws Exception {
		gridMap = new String[5][5];
		errorList= new ArrayList<String>();
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				gridMap[i][j]="*";
			}
		}
	}

	@Test
	public void testTestMapValidity() {
		gridMap[0][1]="S";
		gridMap[1][1]="-";
		gridMap[2][1]="-";
		gridMap[2][2]="-";
		gridMap[2][3]="-";
		//gridMap[2][4]="-";
		gridMap[3][3]="-";
		gridMap[4][3]="E";
		boolean result=MapValidityHelper.testMapValidity(gridMap,errorList);
		assertTrue(result);
	}
	@Test
	public void testCheckMapForIslandPath() {
		gridMap[1][4]="-";
		gridMap[0][1]="?";
		gridMap[1][1]="?";
		gridMap[2][1]="?";
		gridMap[2][2]="?";
		gridMap[2][3]="?";
		gridMap[2][4]="?";
		gridMap[3][3]="?";
		gridMap[4][3]="?";
		boolean result=MapValidityHelper.checkMapForIslandPath(gridMap, errorList);
		assertTrue(result);
	}
	@Test 
	public void testcheckMapStartOrEndPoint(){
		gridMap[1][4]="S";
		gridMap[0][1]="S";
		//Two Start
		assertNotNull(MapValidityHelper.checkMapStartOrEndPoint(gridMap, "S", errorList, "Start"));
		gridMap[1][4]="*";
		gridMap[0][1]="*";
		//No Start
		assertNotNull(MapValidityHelper.checkMapStartOrEndPoint(gridMap, "S", errorList, "Start"));
	}
}
