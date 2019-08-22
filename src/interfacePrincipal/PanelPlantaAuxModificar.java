package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class PanelPlantaAuxModificar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	 /**
	 * Create the panel.
	 */
	public PanelPlantaAuxModificar() {
		setLayout(null);
		setSize(770, 540);
		
		JLabel label = new JLabel("Nombre: ");
		label.setBounds(21, 14, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Id: ");
		label_1.setBounds(21, 56, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Acopio: ");
		label_2.setBounds(21, 81, 46, 14);
		add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 50, 214, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(100, 11, 214, 20);
		add(textField_1);
		
		JRadioButton radioButton = new JRadioButton("Seleccionar");
		radioButton.setBounds(140, 77, 109, 23);
		add(radioButton);
		
		JButton btnBorrar_1 = new JButton("Borrar");
		btnBorrar_1.setBounds(396, 310, 89, 23);
		add(btnBorrar_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(379, 27, 89, 23);
		add(btnModificar);
		
		JLabel label_3 = new JLabel("Seleccione Insumo:");
		label_3.setBounds(21, 116, 149, 28);
		add(label_3);
		
		JLabel label_4 = new JLabel("Ingrese Cantidad Maxima: ");
		label_4.setBounds(36, 283, 160, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Ingrese Cantidad Inicial: ");
		label_5.setBounds(39, 314, 142, 14);
		add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(231, 280, 120, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(231, 311, 120, 20);
		add(textField_3);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(396, 279, 89, 23);
		add(btnBorrar);
		
		JLabel lblModificarPlanta = new JLabel("Modificar Planta");
		lblModificarPlanta.setForeground(Color.BLUE);
		lblModificarPlanta.setBounds(670, 515, 100, 15);
		add(lblModificarPlanta);

	}
	
	
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}

}
