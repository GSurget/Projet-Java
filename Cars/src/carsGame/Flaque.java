package carsGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Flaque {
	int x, y;
	Image flaque;
	double frottements = 1.0;
	
	public Flaque(int startX, int startY){
		x = startX;
		y = startY;
		
		ImageIcon imageFlaque = new ImageIcon("Images/Textures/flaque.png");
		flaque = imageFlaque.getImage();
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
	
	public double getFrottements(){
		return frottements;
	}
	
	public Image getImage(){
		return flaque;
	}
	
	public void setX(int newX){
		this.x = newX;
	}
	
	public void setY(int newY){
		this.y = newY;
	}
}
