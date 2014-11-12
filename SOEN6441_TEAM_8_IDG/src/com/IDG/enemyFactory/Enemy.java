package com.IDG.enemyFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.IDG.mapSimulator.MapSimulatorView;
import com.IDG.mapSimulator.Room;


public class Enemy extends Rectangle implements EnemyType{

	private int health;
	private int healthSpace;
	private int healthHeight;
	private int damage;
	private int enemyID;
	private int enemySize;
	private int walkFrame;
	private int walkSpeed;
	public int xC, yC;
	public boolean inGame = false;
	public boolean hasUpward = false;
    public boolean hasDownward = false;
    public boolean hasLeft = false;
    public boolean hasRight = false;
    public int enemyWalk = 0;
    public int upward = 0, downward = 1, right = 2, left = 3;
    public int direction = right;
	
	public EnemyType enemyType;
	
	public Enemy() {
		
	}
	
	public void spawnEnemy(int enemyID){
		/*for(int y = 0; y < Room.mapColumn; y++){
			
			if(Room.block[y][0].createId == 'S'){
				setBounds(Room.block[y][0].x, Room.block[y][0].y, enemySize, enemySize);
				
					xC = 0;
					yC = y;
				}
			}*/
		/*for(int x = 0; x < Room.mapRow; x++){
			if(Room.block[0][x].createId == 'S'){
				setBounds(Room.block[0][x].x, Room.block[0][x].x, enemySize, enemySize);
				
				xC = x;
				yC = 0;
			}
		}*/
		this.enemyID = enemyID;
		health = enemySize;
		inGame = true;
	}
	
	public void loseHealth(int amo) {
		health -= amo;
		checkDeath();
	}
	
	public void deleteEnemy() {
		inGame = false;
	}
	

	public boolean isDead(){
		if(inGame){
			return false;
		}else{
			return true;
		}
	}
	
	public void draw(Graphics g){
		
		g.drawImage(MapSimulatorView.enemyImage[enemyID], xC, yC, width, height, null); 
	
		g.setColor(new Color(180, 50, 50));
		g.fillRect(xC, yC - (healthHeight + healthSpace), width, healthHeight);
		
		g.setColor(new Color(50, 180, 50));
		g.fillRect(xC, yC - (healthHeight + healthSpace), health, healthHeight);
		
		g.setColor(Color.BLACK);
		g.drawRect(xC, yC - (healthHeight + healthSpace), health - 1, healthHeight - 1);
	}

	@Override
	public void checkDeath() {
		if(health == 0){
			deleteEnemy();
		}		
	}

	@Override
	public void physics() {
		if(walkFrame >= walkSpeed){
            if(direction == right){
                    xC += 1;
            }
            else if(direction == upward){
                    yC -= 1;
            }
            else if(direction == downward){
                    yC += 1;
            }else if(direction == left){
                    xC -=1;
            }
            
            enemyWalk += 1;
            int blockSize = Room.blockSize;
			if(enemyWalk == blockSize){
                    if(walkFrame >= walkSpeed){
                            if(direction == right){
                                    xC += 1;
                                    hasRight = true;
                            }
                            else if(direction == upward){
                                    yC -= 1;
                                    hasUpward = true;
                            }
                            else if(direction == downward){
                                    yC += 1;
                                    hasDownward = true;
                            }
                            else if(direction == left){
                                    xC -= 1;
                                    hasLeft = true;
                            }
                    }
            
                    if(!hasUpward){
                            try{
                                    if(Room.block[yC+1][xC].createId == '-'){
                                            direction = downward;}
                            } catch(Exception e){}
                    }
                    if(!hasDownward){
                            try{
                                    if(Room.block[yC-1][xC].createId == '-'){
                                            direction = upward;}
                            } catch(Exception e){}
                    }
                    if(!hasLeft){
                            try{
                                    if(Room.block[yC][xC+1].createId == '-'){
                                            direction = right;}
                            } catch(Exception e){}
                    }
                    if(!hasRight){
                            try{
                                    if(Room.block[yC][xC-1].createId == '-'){
                                            direction = left;}
                            } catch(Exception e){}
                    }
                    
                    hasRight = false;
                    hasLeft = false;
                    hasUpward = false;
                    hasDownward = false;
                    enemyWalk = 0;
            	}
                    walkFrame = 0;
			}else{
    		walkFrame +=1;
    	}
	}

	@Override
	public void setEnemyID(int enemyID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getEnemyID() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
