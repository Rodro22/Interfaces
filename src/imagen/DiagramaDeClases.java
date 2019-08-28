package imagen;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

import interfaces.pantalla1;

public class DiagramaDeClases extends JPanel {


	public DiagramaDeClases() {
		setLayout(null);
		setSize(800, 500);		
	}
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
//		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/imagen/Diagrama de clases.PNG")));
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imagen/Diagrama de clases.PNG")); 
		g.drawImage(imagen1.getImage(), 0, 0, tam.width, tam.height, null);

		
	}
	
}
