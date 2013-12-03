package carsEditorCircuit;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditorBoard extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

	//MouseListener : lecture des �v�nements de la souris (clic)
	//MouseMotionListener : lecture du mouvement de la souris
	//MouseWheelListener : lectured de la molette de la souris
	//KeyListener : lecture du clavier
	
	String editeur[][] = new String[20][20]; // Tableau g�rant notre panel de 20*20 images
	String imageSelect[] = {"WALL", "ROAD", "GRASS"}; //Tableau contenant les images 
	String imageCourante = "WALL"; // Image selectionn�e
	int mX, mY; //variable pour la position de la souris
	int index = 0; //index de l'image courante
	Image wall;//wall est du type image 
	Image road;
	Image grass;
	FileWriter fw;
	FileReader fr;
	
	// Constructeur //
	public EditorBoard(){
		ImageIcon imageGrass = new ImageIcon("Images/grass.jpg"); //importation de l'image "grass" dans la variable imageGrass
		grass = imageGrass.getImage();//copie de l'image contenue dans imageGrass vers la variable Grass
		
		ImageIcon imageRoad = new ImageIcon("Images/road.jpg");
		road = imageRoad.getImage();
		
		ImageIcon imageWall = new ImageIcon("Images/wall.jpg");
		wall = imageWall.getImage();
		
		setFocusable(true);
		
		addMouseListener(this);//instance en tant que param�tre 
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		addKeyListener(this);
	
	}

	public void paint (Graphics g){ //m�thode de dessin sur le panel
		
		super.paint(g); //appelle la m�thode paint de la classe parente de EditorBoad : JPanel
		Graphics2D g2d = (Graphics2D) g; //on caste g en Graphics2D qui offre plus de possibilit�s
		
		for(int i=0; i<19; i++){
			for(int j=0; j<19; j++){//deplacement dans le tableau de notre panel
				if(editeur[i][j] == "WALL"){
					g2d.drawImage(wall, i*30, j*30, null);//si l'editeur contient l'image WALL alors on dessine wall � l'emplacement i*30 et j*30 car l'image fait 30*30pixels
				}
				
				if(editeur[i][j] == "ROAD"){
					g2d.drawImage(road, i*30, j*30, null);
				}
				
				if(editeur[i][j] == "GRASS"){
					g2d.drawImage(grass, i*30, j*30, null);
				}
			}
		}
		
		if(imageCourante == "WALL"){
			g2d.drawImage(wall, mX, mY, null);//dessine l'image courante � la position de la souris
		}
		else if(imageCourante == "ROAD"){
			g2d.drawImage(road, mX, mY, null);
		}
		else if(imageCourante == "GRASS"){
			g2d.drawImage(grass, mX, mY, null);
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {//evenement touche relach�e
		char key = arg0.getKeyChar();//key vaut le cract�re du clavier relach�
		
		if(key == 's'){
			try{
				fw = new FileWriter (JOptionPane.showInputDialog(null, "Entrez le chemin de sauvegarde :", "EDITEUR DE CIRCUITS", JOptionPane.QUESTION_MESSAGE));//Ouvre une fenetre de dialogue pour entrez le chemin d'enregistrement du fichier
				for (int i=0; i<20; i++ ){
					for (int j=0; j<20; j++){// on parcourt le tableau editeur
						if(editeur[j][i] == "WALL"){
							fw.write('w');//on �crit dans le fichier un "0" si il y a un "wall" dans l'editeur
						}
						else if(editeur[j][i] == "ROAD"){
							fw.write('r');
						}
						else if(editeur[j][i] == "GRASS"){
							fw.write('g');
						}
						else if(editeur[j][i] == null){
							fw.write(' '); //on �crit un espace si il n'y a rien dans l'�diteur
						}
					}
					fw.write("\r\n"); //on �crit "\r\n" � la fin de chaque ligne
				}
				fw.close(); //on ferme la m�thode d'�criture
			}
			catch (Exception ex){}
		}
		else if(key == 'l'){
			try{
				fr = new FileReader (JOptionPane.showInputDialog(null, "Entrez le chemin de lecture :", "EDITEUR DE CIRCUITS", JOptionPane.QUESTION_MESSAGE));
				int i=0;
				int x=0, y=0;
				
				while((i = fr.read()) != -1){//on continue � lire tant qu'on a pas atteint -1, signifiant la fin de la lecture
					char strImg = (char) i; //on caste i en chaine de caract�re pour pouvoir lire le fichier
					
					if(strImg == 'w'){ 
						editeur[x][y] = "WALL";//si strImg vaut 'w' alors on met un "WALL" dans l'�diteur
					}
					else if(strImg == 'r'){
						editeur[x][y] = "ROAD";
					}
					else if(strImg == 'g'){
						editeur[x][y] = "GRASS";
					}
					else if(strImg == ' '){
						editeur[x][y] = null;
					}
					else if(strImg == '\n' || strImg == '\r'){//si on arrive � la fin de la ligne on d�cr�mente x afin de revenir � x=19
						x--;//
					}
					
					if(x == 19){
						y++;//si x=19 on avance d'une ligne et on remet x � 0
						x =0;
					}
					else{
						x++;//on incr�mente x
					}
				}
			}
			catch(Exception ex){}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {//mouvement sur la molette
		int rotation = arg0.getWheelRotation();//rotation indique le sens de rotation de la molette (+ ou -)
		
		if(rotation < 0){
			if(index > 0){//rotation n�gative => on d�cr�mente l'index correspondant aux images et il reste bloqu� sur l'image si inf�rieur
				index--;
			}
		}
		else if(rotation > 0){
			if(index < 2){//rotation positive => on incr�mente l'index qui reste bloqu� sur l'image si sup�rieur  
				index++;  
			}
		}
		
		imageCourante = imageSelect[index];//on met dans l'image courante l'image de num�ro index dans le tableau imageSelect
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mX = arg0.getX()-15;//la variable mX prend la coordonn�e x de la position de la souris � laquelle on soustrait 15 pour que l'image soit centr�e 
		mY = arg0.getY()-15;
		
		repaint(); //appelle la m�thode paint
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { //evenement bouton relach�
		int x = arg0.getX()/30; // x corrspond � l'index du tableau qui g�re notre circuit donc on divise la coordonn�e de la souris par 30 et on garde la partie r�elle (x est un int) pour avoir une valeur comprise entre 1 et 20
		int y = arg0.getY()/30;

		if(arg0.getButton() == MouseEvent.BUTTON1){// si le bouton 1 (clic gauche) est relach�
			editeur[x][y] = imageCourante;//on place l'image courante dans le tableau editeur
		}
		else if(arg0.getButton() == MouseEvent.BUTTON3){// si le bouton 1 (clic droit) est relach�
			editeur[x][y] = null;//on ne place rien dans le tableau editeur
		}
		
		repaint();
		
	}
}
