package com.IDG.enemyFactory;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.IDG.mapBuilder.MapBuilderController;
import com.IDG.mapSimulator.MapSimulatorView;

public class EnemyFactory{
	
	public EnemyFactory() {
		if(!MapBuilderController.enemyCanBeCreated){
			
			JFrame popAlert = new JFrame();
			JButton button = new JButton("OK");
			JLabel label1 = new JLabel("             First create/load a map");
			popAlert.add(button, BorderLayout.SOUTH);
			popAlert.add(label1, BorderLayout.CENTER);
			button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					popAlert.dispose();
				}
				
			});
			popAlert.setSize(300, 200);
			popAlert.setVisible(true);
			popAlert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else{
			StartEnemy abc = null;
			abc= new StartEnemy();
			
			
		}
	}
	
	public EnemyType getEnemy(int enemyID){
		
		if(enemyID == 0)
			return new smallEnemies();
		else if(enemyID == 1)
			return new bossEnemy();
		else
			return null;
	}


}
