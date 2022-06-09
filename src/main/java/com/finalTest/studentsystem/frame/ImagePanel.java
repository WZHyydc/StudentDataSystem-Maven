package com.finalTest.studentsystem.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private ImageIcon icon;  
	private Image img;
	
	public ImagePanel(){
		try {
			icon = new ImageIcon(ImageIO.read(new File("src/main/java/2.png")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		img=icon.getImage();
	}   
	public void paintComponent(Graphics g)  
	{   
		super.paintComponent(g);  
		g.drawImage(img,0,0,null );  
	}   
}
