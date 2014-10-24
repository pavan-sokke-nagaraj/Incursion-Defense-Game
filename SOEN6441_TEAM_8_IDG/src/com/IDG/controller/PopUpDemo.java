package com.IDG.controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class PopUpDemo extends JPopupMenu {
    JMenuItem wall;
    JMenuItem startPoint;
    JMenuItem endPoint;
    wall button=null;
	public PopUpDemo(wall but){
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
