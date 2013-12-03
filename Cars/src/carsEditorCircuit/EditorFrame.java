package carsEditorCircuit;

import javax.swing.*;

public class EditorFrame extends JFrame {
	
	// Constructeur //
	public EditorFrame(){
		this.setTitle("Circuit Editor !"); // Titre de notre fen�tre
		//this.setLocation(null);// Position de notre fen�tre, null=>centr�e dans l'�cran
		this.setSize(600,600); // Taille de notre fenetre, 30 images de 20 pixels => 600
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Ferme la fenetre et arrete le programme en cliquant sur la croix
		this.add(new EditorBoard());// Ajoute � la fenetre EditorBoard comme content pane
		this.setResizable(false);//Redimensionnement de la fenetre desactiv�
		this.setVisible(true);//rend la fenetre et son contenu visible
	}

}
