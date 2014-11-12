package com.IDG.enemyFactory;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.IDG.mapSimulator.Room;

public class smallEnemies extends Enemy{
	public smallEnemies() {
		super();
		int health = 10;
		int healthSpace = 3;
		int healthHeight = 2;
		int damage = 1;
		int enemyID = 0;
		int enemySize = (Room.blockSize)/2;
		int walkFrame = 0;
		int walkSpeed = 10;
	}


}
