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
		setSize(780, 540);
		
		JLabel lblTp = new JLabel("TP DIED");
		lblTp.setForeground(Color.RED);
		lblTp.setBounds(172, 114, 399, 172);
		Font auxFont=lblTp.getFont(); 
		lblTp.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 100));
		add(lblTp);
		
		JLabel lblDied = new JLabel("2019");
		lblDied.setForeground(Color.RED);
		Font auxFont2=lblTp.getFont();
		lblDied.setBounds(280, 297, 193, 98);
		lblDied.setFont(new Font(auxFont.getFontName(), auxFont2.getStyle(), 75));
		add(lblDied);
		
		
		
		
		
	}

	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}
}
