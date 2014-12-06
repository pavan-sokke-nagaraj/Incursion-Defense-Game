package com.IDG.test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.IDG.mapBuilder.MapDetails;
import com.IDG.mapSimulator.Arsenal;
import com.IDG.utils.MapValidityHelper;
/**
 * This Class contains the Test cases for Map Save and Load functionality.
 * 
 *
 *
 * @author Kariappa
 * @version 1.0
 */

public class MapSaverTest {

MapDetails testSave = new MapDetails();


@Before
public void setUp() throws Exception{
	
	Calendar time = Calendar.getInstance();testSave.mapid=100;
	testSave.columnSize=2;
	testSave.rowSize=2;
	testSave.creationTime=time.getTime();
	testSave.gamestatus.add("GAME WON");
	
	testSave.writeToFile(testSave);
	}
	
@Test
public void testMapsave() {
	
	File file=new File("Resource/CustomMaps/GameMatrix/Map" + testSave.mapid + ".txt");
	assertTrue(file.exists());
}
@Test
public void testMapload()
{
	MapDetails temp=new MapDetails();
	temp.mapid=100;
temp=temp.readFromFile(temp);
assertEquals(testSave.mapid,temp.mapid);
assertEquals(testSave.columnSize,temp.columnSize);
assertEquals(testSave.rowSize,temp.rowSize);
assertEquals(testSave.gamestatus,temp.gamestatus);
assertEquals(testSave.creationTime, temp.creationTime);
}

}
