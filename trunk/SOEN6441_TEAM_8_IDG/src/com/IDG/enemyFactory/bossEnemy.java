package com.IDG.enemyFactory;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.IDG.mapSimulator.Room;

public class bossEnemy extends Enemy{
	public bossEnemy() {
		super();
		int health = 20;
		int healthSpace = 3;
		int healthHeight = 2;
		int damage = 5;
		int enemyID = 1;
		int enemySize = Room.blockSize;
		int walkFrame = 0;
		int walkSpeed = 20;

	}

}
