package carsGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Road {
	int x,y;
	Image Road;
	float frottements;
	
	public Road(int startX, int startY){
		x = startX;
		y = startY;	
		
		ImageIcon imageRoad = new ImageIcon("Images/road.jpg");
		Road = imageRoad.getImage();
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
		return Road;
	}
	
	public void setX(int newX){
		this.x = newX;
	}
	
	public void setY(int newY){
		this.y = newY;
	}
	

}
