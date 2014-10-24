package com.IDG.controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PopClickListener extends MouseAdapter {
	wall button=null;
	public PopClickListener(wall button){
		this.button=button;
	}
	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
        PopUpDemo menu = new PopUpDemo(button);
        menu.show(e.getComponent(), e.getX(), e.getY());
        
    }

}
