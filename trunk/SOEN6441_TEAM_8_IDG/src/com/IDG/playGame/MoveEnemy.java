package com.IDG.playGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.IDG.enemyFactory.SmallEnemy;
import com.IDG.mapSimulator.MapSimulatorView;

public class MoveEnemy {

	// Build 2 start
	public static SmallEnemy[] enemies = new SmallEnemy[5];

	private static LinkedList<Point> enemyPath = new LinkedList<Point>();
	// private ArrayList<Enemy> enemies;
	private SmallEnemy enemy;

	public static void drawEnimies(Graphics graphic) {

//		enemyPath = EnemyPath.copyPath();
		
//		for(int i = 0; i<enemies.length;i++){
//			enemies[i] = new Enemy (enemyPath);
////			enemies[i].physic();
//			}

		// for (Iterator iterator = enemyPath.iterator(); iterator.hasNext();) {
		// Point point = (Point) iterator.next();
		// System.out.println("X:\t"+ point.x+"\tY:\t"+point.y);
		// Image image = new ImageIcon("ImageSource/enemy.png").getImage();
		// int x = MapSimulatorView.room.block[point.x][point.y].x;
		// int y = MapSimulatorView.room.block[point.x][point.y].y;
		// int width = MapSimulatorView.room.block[point.x][point.y].width;
		// int height = MapSimulatorView.room.block[point.x][point.y].height;
		// graphic.drawImage(image, x, y, width, height, null);
		// }

//		for (int i = 0; i < enemies.length; i++) {
//			enemies[i].draw(graphic);
//
//		}
	}

}
