package com.IDG.utils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.IDG.mapBuilder.MapBuilderModel;


public class PopClickListener extends MouseAdapter {
	MapBuilderModel button=null;
	public PopClickListener(MapBuilderModel button){
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
