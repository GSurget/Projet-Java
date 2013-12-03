package carsGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements MouseListener{
	
	String Game[][] = new String[20][20];
	private static ArrayList<Wall> Walls;
	private static ArrayList<Road> Roads;
	private static ArrayList<Grass> Grasses;
	
	int numero = 1;
	Wall wall;
	Road road;
	Grass grass;
	Cars car1;
	Font levelFont = new Font("SansSerif", Font.BOLD, 30);
	FileReader fr;
	
	public GameBoard(){
		chargerCircuit();
		setFocusable(true);
		addMouseListener(this);
	}
	
	public void chargerCircuit(){
		try{
			fr = new FileReader("Circuits/circuit"+numero+".circuit");
			int x = 0, y = 0, i = 0;
			
			Walls = new ArrayList<Wall>();
			Roads = new ArrayList<Road>();
			Grasses = new ArrayList<Grass>();
			
			while((i = fr.read()) != -1){
				char strImg = (char) i;
				
				if(strImg == 'w'){
					Game[x][y] = "WALL";
					wall = new Wall(x*30, y*30);
					Walls.add(wall);
				}
				else if(strImg == 'r'){
					Game[x][y] = "ROAD";
					road = new Road(x*30, y*30);
					Roads.add(road);
				}
				else if(strImg == 'g'){
					Game[x][y] = "GRASS";
					grass = new Grass(x*30, y*30);
					Grasses.add(grass);
				}
				else if(strImg == ' '){
					Game[x][y] = null;
				}
				else if(strImg == '\r' || strImg == '\n'){
					x--;
				}
				if(x == 19){
					y++;
					x=0;
				}
				else{
					x++;
				}
			}
		}
		catch(Exception ex){}
		
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;//on utilise Graphics2D pour pouvoir dessiner des images, sachant que Graphics ne le permet pas
		
		for(int i=0; i<Walls.size(); i++){
			wall = (Wall) Walls.get(i);
			g2d.drawImage(wall.getImage(), wall.getX(), wall.getY(), null);
		}
		
		for(int i=0; i<Roads.size(); i++){
			road = (Road) Roads.get(i);
			g2d.drawImage(road.getImage(), road.getX(), road.getY(), null);
		}
		
		for(int i=0; i<Grasses.size(); i++){
			grass = (Grass) Grasses.get(i);
			g2d.drawImage(grass.getImage(), grass.getX(), grass.getY(), null);
		}
		
		try{
			/*
			ImageIcon imageVoit = new ImageIcon("Images/car.jpg");
			Image voit = imageVoit.getImage();
			g2d.drawImage(voit, 137, 267,null);
			*/
			Image voit = car1.getImage();
			g2d.drawImage(voit, car1.getX(), car1.getY(),null);
		}
		catch(Exception ex){}
		
		g.setColor(Color.BLACK);
		g.setFont(levelFont);
		g.drawString("Circuit "+numero, 10, 25);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int sourisX = arg0.getX();
		int sourisY = arg0.getY();
		System.out.println("x ="+sourisX);
		System.out.println("y ="+sourisY);
		
	//	car1.setX(sourisX);
	//	car1.setY(sourisY);
		/*
		car1.setX(car1.getX() + car1.getVitesseX());
		car1.setY(car1.getY() + car1.getVitesseY());
		
		car1.setVitesseX((sourisX - car1.getX())/10);
		car1.setVitesseY((sourisY - car1.getY())/10);
		*/
		checkCollision();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkCollision(){
		
	}
}
