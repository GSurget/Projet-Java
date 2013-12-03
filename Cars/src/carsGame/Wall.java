package carsGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall {

	int x, y;
	Image Wall;
	
	public Wall(int startX, int startY){
		x = startX;
		y = startY;
		
		ImageIcon imageWall = new ImageIcon("Images/Wall.jpg");
		Wall = imageWall.getImage();
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
	
	public Image getImage(){
		return Wall;
	}
	
	public void setX(int newX){
		this.x = newX;
	}
	
	public void setY(int newY){
		this.y = newY;
	}
	

}
