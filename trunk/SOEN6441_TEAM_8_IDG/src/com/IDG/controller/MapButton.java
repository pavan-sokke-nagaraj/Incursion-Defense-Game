package com.IDG.controller;

import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class MapButton extends JButton{
	String fileName;
	String mapType;
	String fileType;
	MapButton(String fileName,String mapType,String fileType){
		this.fileName=fileName;
		this.mapType=mapType;
		this.fileType=fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMapType() {
		return mapType;
	}
	public void setMapType(String mapType) {
		this.mapType = mapType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
