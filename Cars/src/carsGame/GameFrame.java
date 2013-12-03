package carsGame;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame(){
	
		this.setTitle("Cars Game"); // Titre de notre fenêtre
		//this.setLocation(null);// Position de notre fenêtre, null=>centrée dans l'écran
		this.setSize(600,600); // Taille de notre fenetre, 30 images de 20 pixels => 600
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Ferme la fenetre et arrete le programme en cliquant sur la croix
		this.add(new GameBoard());// Ajoute à la fenetre EditorBoard comme content pane
		this.setResizable(false);//Redimensionnement de la fenetre desactivé
		this.setVisible(true);//rend la fenetre et son contenu visible
	
	}
}
