package interfaces;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import auxiliar.MiModelo;
import modelo.Camion;
import modelo.Insumo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;

public class PanelCAMIONGestion extends JPanel {
	
	private JTextField textMarca;
	private JTextField textCapacidad;
	private JTextField textId;
	private JTextField textMarcaM;
	private JTextField textCapacidadM;
	private JTextField textIdM;
	public MiModelo modeloAux;
	private JTable table, tableAux;
	private final String[] columnas = {"Id: ", "Marca: ", "Capacidad: ", "Posicion: "};

	
	public PanelCAMIONGestion(List<Camion> listaCamiones) {
		setLayout(null);
		setSize(770, 540);
		inicializar(listaCamiones);
		
//		modeloAux = new MiModelo();
//		modeloAux.setColumnIdentifiers(columnas);
//		Object obj[] = null;
//		
//		for (int i = 0; i < listaCamiones.size(); i++) {
//		modeloAux.addRow(obj);
//		Camion getC = listaCamiones.get(i);
//		modeloAux.setValueAt(getC.getId(), i, 0);
//		modeloAux.setValueAt(getC.getMarca(), i, 1);
//		modeloAux.setValueAt(getC.getCapacidad(), i, 2);
//		modeloAux.setValueAt(i, i, 3);
//		}
		
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 21, 46, 14);
		add(lblId);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 59, 46, 14);
		add(lblMarca);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(10, 91, 67, 14);
		add(lblCapacidad);
		
		textMarca = new JTextField();
		textMarca.setBounds(95, 53, 86, 20);
		add(textMarca);
		textMarca.setColumns(10);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(95, 88, 86, 20);
		add(textCapacidad);
		textCapacidad.setColumns(10);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(95, 18, 86, 20);
		add(textId);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( (textId.getText().length() != 0) && (textMarca.getText().length() != 0) && (textCapacidad.getText().length() != 0) ) {
					
					Camion unCamion = new Camion(Integer.parseInt(textId.getText()), textMarca.getText(), Double.parseDouble(textCapacidad.getText()));
					listaCamiones.add(unCamion);
				
					if (listaCamiones.contains(unCamion)) {
						JOptionPane.showMessageDialog(null, "Elemento agregado correctamente", "Acción del sistema", JOptionPane.INFORMATION_MESSAGE);
						}	
				} else {
				JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);	}
			
				table = new JTable(mostrarElementos2(listaCamiones));
				table.setBounds(40, 171, 595, 150);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(40, 171, 595, 150);
				add(scrollPane);
			}
		});
		btnCrear.setBounds(208, 55, 89, 23);
		add(btnCrear);
		
		JLabel label = new JLabel("Id:");
		label.setBounds(345, 24, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Marca:");
		label_1.setBounds(345, 62, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Capacidad:");
		label_2.setBounds(345, 94, 67, 14);
		add(label_2);
		
		textMarcaM = new JTextField();
		textMarcaM.setColumns(10);
		textMarcaM.setBounds(430, 56, 86, 20);
		add(textMarcaM);
		
		textCapacidadM = new JTextField();
		textCapacidadM.setColumns(10);
		textCapacidadM.setBounds(430, 91, 86, 20);
		add(textCapacidadM);
		
		textIdM = new JTextField();
		textIdM.setColumns(10);
		textIdM.setBounds(430, 21, 86, 20);
		add(textIdM);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
		        if (table.getSelectedRow() != -1) {		        	
		        	 i = (int) modeloAux.getValueAt(table.getSelectedRow(), 3);
		        	 JOptionPane.showMessageDialog(null, "Posicion: "+ i);
		        	 	Camion unCamion = new Camion(Integer.parseInt(textIdM.getText()), textMarcaM.getText(), Double.parseDouble(textCapacidadM.getText()));
				        table = new JTable(modificarElemento2(listaCamiones, i, unCamion));
						inicializar2(listaCamiones, table);	
//				        inicializar(listaCamiones);
		        } else {
		            JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		btnModificar.setBounds(543, 58, 104, 23);
		add(btnModificar);
		
		JLabel lblSeleccioneUnCamion = new JLabel("Seleccione un camion: ");
		lblSeleccioneUnCamion.setBounds(10, 148, 171, 14);
		add(lblSeleccioneUnCamion);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = 0;
				if(table.getSelectedRow() != -1) {
					x = (int) modeloAux.getValueAt(table.getSelectedRow(), 3);
					JOptionPane.showMessageDialog(null, "Posicion: "+ x);
					table = new JTable(eliminarElemento2(listaCamiones, x));
					table.setBounds(40, 171, 595, 150);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(40, 171, 595, 150);
					add(scrollPane);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBorrar.setBounds(546, 339, 89, 23);
		add(btnBorrar);
		
		JLabel lblGestionCamiones = new JLabel("Gestion Camiones");
		lblGestionCamiones.setForeground(Color.BLUE);
		lblGestionCamiones.setBounds(650, 515, 110, 15);
		add(lblGestionCamiones);
		
//		table = new JTable();
//		table.setBounds(20, 173, 652, 154);
//		add(table);

	}
	
	public void inicializar(List<Camion> listaCamiones) {

		table = new JTable(mostrarElementos2(listaCamiones));
//		table.setBounds(40, 171, 595, 150);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 171, 595, 150);
		scrollPane.setVisible(true);
		add(scrollPane);
	}
	public void inicializar2(List<Camion> listaCamiones, JTable table) {
		table = new JTable(mostrarElementos2(listaCamiones));
//		table.setBounds(40, 171, 595, 150);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 171, 595, 150);
		add(scrollPane);
	}
	public DefaultTableModel mostrarElementos2(List<Camion> listaCamiones) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaCamiones.size(); i++) {
			modeloAux.addRow(obj);
			Camion getC = listaCamiones.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getMarca(), i, 1);
			modeloAux.setValueAt(getC.getCapacidad(), i, 2);
			modeloAux.setValueAt(i, i, 3);
		}
		return modeloAux;
	}
	
	public DefaultTableModel eliminarElemento2(List<Camion> listaCamiones, int x) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		listaCamiones.remove(x);
		Object obj[] = null;
		
		for (int i = 0; i < listaCamiones.size(); i++) {
			modeloAux.addRow(obj);
			Camion getC = listaCamiones.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getMarca(), i, 1);
			modeloAux.setValueAt(getC.getCapacidad(), i, 2);
			modeloAux.setValueAt(i, i, 3);
		}
		
		return modeloAux;
	}
	
	public DefaultTableModel modificarElemento2(List<Camion> listaCamiones, int x, Camion aux) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		listaCamiones.add(x, aux);
		listaCamiones.remove(x+1);
		Object obj[] = null;
		for (int i = 0; i < listaCamiones.size(); i++) {
			modeloAux.addRow(obj);
			Camion getC = listaCamiones.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getMarca(), i, 1);
			modeloAux.setValueAt(getC.getCapacidad(), i, 2);
			modeloAux.setValueAt(i, i, 3);
		}
		return modeloAux;
		}
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}

	
	
	
	
}
