package com.IDG.mapSimulator;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * class file to handle mouse movements and mouse clicks *
 * 
 * @author Pavan Sokke Nagaraj <pavansn8@gmail.com>
 * @version Build1
 * @since Build1
 */
public class KeyHandel implements MouseMotionListener, MouseListener {

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
		MapSimulatorView.arsenal.towerClick(event.getButton());

	}

	public void mouseReleased(MouseEvent event) {
	}

	public void mouseDragged(MouseEvent event) {
		MapSimulatorView.mse = new Point(event.getX(), event.getY());
	}

	public void mouseMoved(MouseEvent event) {
		MapSimulatorView.mse = new Point(event.getX(), event.getY());
	}

}
