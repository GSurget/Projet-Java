package carsGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Grass {
	int x, y;
	Image Grass;
	float frottements;
	
	public Grass(int startX, int startY){
		x = startX;
		y = startY;
		
		ImageIcon imageGrass = new ImageIcon("Images/grass.jpg");
		Grass = imageGrass.getImage();
	}
	
	public Rectangle getBounds(){
		Rectangle Boite = new Rectangle(x,y,30,30);
		return Boite;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public float getFrottements(){
		return frottements;
	}
	
	public Image getImage(){
		return Grass;
	}
	
	public void setX(int newX){
		this.x = newX;
	}
	
	public void setY(int newY){
		this.y = newY;
	}
	
	
}
