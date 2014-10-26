package com.IDG.controller;

import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class MapButton extends JButton{
	String fileName;
	String mapType;
	MapButton(String fileName,String mapType){
		this.fileName=fileName;
		this.mapType=mapType;
	}
}
