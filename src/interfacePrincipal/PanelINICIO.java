package interfacePrincipal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class PanelINICIO extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelINICIO() {
		
		setLayout(null);
		setSize(794, 548);
		
		JLabel lblTp = new JLabel("  TP DIED");
		lblTp.setForeground(Color.BLUE);
		lblTp.setBounds(163, 114, 488, 172);
		Font auxFont=lblTp.getFont(); 
		lblTp.setFont(new Font("Times New Roman", Font.BOLD, 100));
		add(lblTp);
		
		JLabel lblDied = new JLabel("  2019");
		lblDied.setForeground(Color.BLUE);
		Font auxFont2=lblTp.getFont();
		lblDied.setBounds(280, 297, 225, 98);
		lblDied.setFont(new Font(auxFont.getFontName(), auxFont2.getStyle(), 75));
		add(lblDied);
		
		JLabel lblLezcanoRodrigo = new JLabel("Lezcano Rodrigo");
		lblLezcanoRodrigo.setForeground(Color.BLUE);
		lblLezcanoRodrigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblLezcanoRodrigo.setBounds(35, 470, 184, 25);
		add(lblLezcanoRodrigo);
		
		JLabel lblMantovaniAlejo = new JLabel("Mantovani Alejo");
		lblMantovaniAlejo.setForeground(Color.BLUE);
		lblMantovaniAlejo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblMantovaniAlejo.setBounds(35, 495, 184, 25);
		add(lblMantovaniAlejo);
		
		JLabel lblAlumnos = new JLabel("Alumnos:");
		lblAlumnos.setForeground(Color.BLUE);
		lblAlumnos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlumnos.setBounds(10, 434, 100, 25);
		add(lblAlumnos);
		
		JLabel lblPortada = new JLabel("Portada");
		lblPortada.setForeground(Color.BLUE);
		lblPortada.setBounds(721, 523, 46, 14);
		add(lblPortada);
		
		
		
		
		
	}

	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);

		
	}
}
