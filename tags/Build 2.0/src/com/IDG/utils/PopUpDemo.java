package com.IDG.utils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.IDG.mapBuilder.MapBuilderModel;

/**
 * This file handles the event that happen when user click on the submenu
 * @author Arjun
 *
 */
public class PopUpDemo extends JPopupMenu {
    JMenuItem wall;
    JMenuItem startPoint;
    JMenuItem endPoint;
    MapBuilderModel button=null;
	public PopUpDemo(MapBuilderModel but){
    	this.button=but;
    	startPoint = new JMenuItem("Start Point");
    	startPoint.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	button.isStart=true;
            	System.out.println("Start Point");
            	button.setIcon(button.getStart());
            }
        });
    	endPoint = new JMenuItem("End Point");
    	endPoint.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	button.isEnd=true;
            	System.out.println("End Point");
            	button.setIcon(button.getEnd());
            }
        });
    	add(startPoint);
        add(endPoint);
    }

}
