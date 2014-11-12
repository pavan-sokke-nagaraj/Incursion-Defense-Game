package com.IDG.enemyFactory;

//import Enemy;

import java.awt.*;

import javax.swing.*;

import com.IDG.mapSimulator.MapSimulatorView;

public class StartEnemy extends JPanel implements Runnable{

	public static boolean isFirst = false;
	public static Enemy[] enemies = new Enemy[5];
	public Thread thread = new Thread(this);
	public static Image[] image_enemy = new Image[10];
	public static Image[] boss = new Image[10];

	public StartEnemy()
	{
		thread.start();
	}
	
	public void paintComponent (Graphics g){
		if(isFirst){
			define();
			isFirst = false;
		}
		
		for(int i = 0; i < enemies.length; i++){
			if(enemies[i].inGame){
				enemies[i].draw(g);
				
			}
		}
	}
	private void define() {
		image_enemy[0] = new ImageIcon("ImageSource/coin.png").getImage();
		for(int i = 0; i < enemies.length; i++){
			enemies[i] = new Enemy();
		}
		//enemies[enemies.length] = new bossEnemy();
		//boss[0] = new ImageIcon("ImageSource/boss.png").getImage();
	}
	
	public int spawnTime = 2;

	public int spawnFrame = 0;
	
	public void enemySpawner(){
		
		if(spawnFrame >= spawnTime){
			System.out.println("shaai");
			for(int i = 0; i< enemies.length; i++){
				if(!enemies[i].inGame){
					System.out.println("shai");
					enemies[i].spawnEnemy(0);
					break;
				}
			}//if(!enemies[enemies.length].inGame){
			//	enemies[enemies.length].spawnEnemy(1);
			//}
			
			spawnFrame = 0;
		}
		else{
			spawnFrame += 1;
		}
	}
	
	public void run() {
		
		while(true){
			if(!isFirst){
				enemySpawner();
				for(int i=0; i<enemies.length; i++){
					if(enemies[i].inGame){
						enemies[i].physics();
					}
				}
			}
			repaint();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



}
