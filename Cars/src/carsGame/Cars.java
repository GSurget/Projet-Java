package carsGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Cars {
	int x=237,y=267;
	int vitesseX=0, vitesseY=0;
	String car = "CAR";
	Image Car;

	
	public Cars(int startX, int startY, int startVitesseX, int startVitesseY){
		x = startX;
		y = startY;
		vitesseX = startVitesseX;
		vitesseY = startVitesseY;
		
		ImageIcon imageCar = new ImageIcon("Images/car.jpg");
		Car = imageCar.getImage();
	}
	
	public Rectangle getBounds(){
		Rectangle Boite = new Rectangle(x,y,20,30);
		return Boite;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getVitesseX(){
		return vitesseX;
	}
	
	public int getVitesseY(){
		return vitesseY;
	}
	
	public void setX(int newX){
		this.x = newX;
	}
	
	public void setY(int newY){
		this.y = newY;
	}
	
	public void setVitesseX(int newVitesseX){
		this.vitesseX = newVitesseX;
	}
	public void setVitesseY(int newVitesseY){
		this.vitesseY = newVitesseY;
	}
	
	public Image getImage(){
		return Car;
	}
	
}
