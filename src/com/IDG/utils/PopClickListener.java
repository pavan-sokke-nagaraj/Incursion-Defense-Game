package com.IDG.utils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.IDG.mapBuilder.MapBuilderModel;

/**
 * This class is to handle Right Mouse Click events on the Map Builder
 * @author Arjun
 *
 */
public class PopClickListener extends MouseAdapter {
	MapBuilderModel button=null;
	/**
	 * Constructor to hold the instance of button that is clicked
	 */
	public PopClickListener(MapBuilderModel button){
		this.button=button;
	}
	/**
	 * When mouse is pressed this method is called
	 */
	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }
	/**
	 * When mouse is released this method is called
	 */
    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }
    /**
     * Show the sub menu when clicked right
     */
    private void doPop(MouseEvent e){
        PopUpDemo menu = new PopUpDemo(button);
        menu.show(e.getComponent(), e.getX(), e.getY());
        
    }

}
