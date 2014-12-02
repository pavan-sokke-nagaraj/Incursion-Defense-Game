package com.IDG.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.IDG.controller.LayoutManager;
import com.IDG.mapBuilder.MapDetails;
import com.IDG.mapSimulator.MapSimulatorView;

public class SetHighScoreTest {

MapDetails highScore=new MapDetails();

@Before
public void setUp() throws Exception 
{
	highScore.highscore.add(500);
	highScore.highscore.add(50);
	highScore.highscore.add(100);
	highScore.highscore.add(300);
	highScore.highscore.add(700);
	MapSimulatorView.power=200;
}

@Test
public void testSetHighScoreHighest()
{
	highScore=LayoutManager.setHighScore(highScore);
	int highest=highScore.highscore.get(0);
	assertEquals(highest,700);
}


@Test
public void testSetHighscoreLowest()
{
	highScore=LayoutManager.setHighScore(highScore);
	int lowest=highScore.highscore.get(4);
	assertEquals(lowest,100);
}

@Test
public void testNoPopLeastHighScore()
{
	MapSimulatorView.power=40;
	//highScore.highscore.add(0);
	highScore=LayoutManager.setHighScore(highScore);
	int lowest=highScore.highscore.get(4);
	assertEquals(lowest,50);
}
@Test
public void testpopLeastHighScore()
{	MapSimulatorView.power=60;
	//highScore.highscore.add(60);
	highScore=LayoutManager.setHighScore(highScore);
	int test=highScore.highscore.get(4);
	assertEquals(test,60);
}

}

