package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

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

	}

}
