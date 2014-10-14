import java.awt.Image;

import javax.swing.ImageIcon;


public class Tower {

	public String towerDesign = "";
	public Image design ;
	public static final Tower lightingTower = new TowerLighting(0).getDesignFile("fightingTower");
	public static final Tower[] towerTypes = new Tower[200];
	public int towerID;
	
	public Tower(int towerID){
		if (towerTypes[towerID] != null) {
			System.out.println("Two towers initialized with same id ! id = " + towerID);
			
		}
		else { 
			towerTypes[towerID] = this;
			this.towerID = towerID;
		
		}
	}		
	
	public Tower getDesignFile(String str){
		this.towerDesign = str;
		this.design = new ImageIcon("res/tower/"+ this.towerDesign + ".png").getImage();
		return null;
		
	}
}