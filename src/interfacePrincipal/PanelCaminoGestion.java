package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Camino;
import modelo.Camion;
import modelo.Insumo;
import modelo.Planta;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PanelCaminoGestion extends JPanel {
	public List<Camino> listaCaminos_principal;
	public List<Planta> listaPlantas_principal;
	public DefaultTableModel modeloAux;
	private final String[] columnas = {"Id: ", "Duracion: ", "Distancia: ", "Peso: ", "Planta Inicial: ", "Planta Final", "Posicion"};
	private JTable table_1;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Create the panel.
	 */
	public PanelCaminoGestion(List<Camino> listaCaminos, List<Planta> listaPlantas) {
		this.listaCaminos_principal = listaCaminos;
		this.listaPlantas_principal = listaPlantas;
		setLayout(null);
		inicializar(listaCaminos);
		
		//ESTO ME PERMITE TRABAJAR CON EL JTABLE
		modeloAux = new DefaultTableModel();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaCaminos.size(); i++) {
			modeloAux.addRow(obj);
			Camino getC = listaCaminos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getDuracion(), i, 1);
			modeloAux.setValueAt(getC.getDistancia(), i, 2);
			modeloAux.setValueAt(getC.getPeso_soportado(), i, 3);
			modeloAux.setValueAt(getC.getPlanta_init(), i, 4);
			modeloAux.setValueAt(getC.getPlanta_end(), i, 5);
			modeloAux.setValueAt(i, i, 6);
		}
		
		
		
		JLabel label = new JLabel("ID:");
		label.setBounds(10, 14, 46, 14);
		add(label);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(387, 52, 75, 20);
		add(textField_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(119, 11, 75, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 36, 75, 20);
		add(textField_2);
		
		JLabel label_1 = new JLabel("Duracion Minutos: ");
		label_1.setBounds(10, 39, 89, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Ditancia KM:");
		label_2.setBounds(10, 64, 89, 14);
		add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(119, 61, 75, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(119, 89, 75, 20);
		add(textField_4);
		
		JLabel label_3 = new JLabel("Peso m\u00E1ximo:");
		label_3.setBounds(10, 92, 89, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Planta Inicial Id:");
		label_4.setBounds(278, 17, 99, 14);
		add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(387, 14, 75, 20);
		add(textField_5);
		
		JLabel lblPlantaFinalId = new JLabel("Planta Final Id:");
		lblPlantaFinalId.setBounds(278, 55, 99, 14);
		add(lblPlantaFinalId);
		
		JButton button = new JButton("MODIFICAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
		        if (table_1.getSelectedRow() != -1) {

//		        	 i = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 6);
		        	int idM = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 6);
		        	JOptionPane.showMessageDialog(null, "Camino con id : "+ idM + " modificado");
//		        	int id1 = Integer.parseInt(textField_5.getText());
//		        	int id2 = Integer.parseInt(textField_6.getText());
		        	String plantaIni = textField_5.getText();
		        	String plantaFin = textField_6.getText();
		        	Planta aux1 = null;
		        	Planta aux2 = null;
		        	
		        	 for(Planta unaPlanta : listaPlantas) {
		        		 if(plantaIni == unaPlanta.getNombre()) {
		        			 aux1 = unaPlanta;
		        		 }
		        		 if(plantaFin == unaPlanta.getNombre()) {
		        			 aux2 = unaPlanta;
		        		 }
		        	 }
				        Camino unInsumoAux = new Camino(Integer.parseInt(textField_1.getText()),aux1, aux2, Double.parseDouble(textField_2.getText()),
				        		Double.parseDouble(textField_3.getText()), Double.parseDouble(textField_4.getText()));
				        
						table_1 = new JTable(modificarElemento2(listaCaminos, i, unInsumoAux));
//						table_1.setBounds(10, 183, 680, 172);
						inicializar2(listaCaminos, table_1);
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
		        }
		         
			}
		});
		
		button.setBounds(278, 103, 120, 23);
		add(button);
		
		JLabel lblSeleccioneUnCamino = new JLabel("Seleccione un camino:");
		lblSeleccioneUnCamino.setBounds(10, 165, 169, 14);
		add(lblSeleccioneUnCamino);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				if(table_1.getSelectedRow() != -1) {
					x = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 6);
					JOptionPane.showMessageDialog(null, "Posicion: "+ x);
					table_1.removeAll();
					table_1 = new JTable(eliminarElemento2(listaCaminos, x));
					table_1.setBounds(40, 171, 595, 150);
					JScrollPane scrollPane = new JScrollPane(table_1);
					scrollPane.setBounds(10, 183, 680, 172);
					add(scrollPane);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBorrar.setBounds(430, 103, 89, 23);
		add(btnBorrar);

	}
	public void inicializar(List<Camino> listaCaminos) {
		table_1 = new JTable(mostrarElementos2(listaCaminos));
//		table_1.setBounds(10, 183, 680, 172);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 183, 680, 172);
		add(scrollPane);
		
//		JButton btnActualizar = new JButton("ACTUALIZAR");
//		btnActualizar.setBounds(25, 366, 115, 23);
//		add(btnActualizar);
	}
	public DefaultTableModel mostrarElementos2(List<Camino> listaCaminos) {
		modeloAux = new DefaultTableModel();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaCaminos.size(); i++) {
			modeloAux.addRow(obj);
			Camino getC = listaCaminos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getDuracion(), i, 1);
			modeloAux.setValueAt(getC.getDistancia(), i, 2);
			modeloAux.setValueAt(getC.getPeso_soportado(), i, 3);
			modeloAux.setValueAt(getC.getPlanta_init(), i, 4);
			modeloAux.setValueAt(getC.getPlanta_end(), i, 5);
			modeloAux.setValueAt(i, i, 6);
		}
		return modeloAux;
	}
	
	public DefaultTableModel modificarElemento2(List<Camino> listaCaminos, int x, Camino aux) {
		
		modeloAux = new DefaultTableModel();
	
		modeloAux.setColumnIdentifiers(columnas);
		listaCaminos.add(x, aux);
		listaCaminos.remove(x+1);
		Object obj[] = null;
		for (int i = 0; i < listaCaminos.size(); i++) {
			modeloAux.addRow(obj);
			Camino getC = listaCaminos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getDuracion(), i, 1);
			modeloAux.setValueAt(getC.getDistancia(), i, 2);
			modeloAux.setValueAt(getC.getPeso_soportado(), i, 3);
			modeloAux.setValueAt(getC.getPlanta_init(), i, 4);
			modeloAux.setValueAt(getC.getPlanta_end(), i, 5);
			modeloAux.setValueAt(i, i, 6);
		}
		return modeloAux;}
	
	public void inicializar2(List<Camino> listaCamino, JTable table) {
		JLabel lblSeleccioneUnCamino = new JLabel("Seleccione un camino:");
		lblSeleccioneUnCamino.setBounds(10, 165, 169, 14);
		add(lblSeleccioneUnCamino);
		table = new JTable(mostrarElementos2(listaCamino));
		table.setBounds(40, 171, 595, 150);
		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(40, 171, 595, 150);
		scrollPane.setBounds(10, 183, 680, 172);
		add(scrollPane);
	}
	public DefaultTableModel eliminarElemento2(List<Camino> listaCaminos, int x) {
		modeloAux = new DefaultTableModel();
		modeloAux.setColumnIdentifiers(columnas);
		listaCaminos.remove(x);
		Object obj[] = null;
		for (int i = 0; i < listaCaminos.size(); i++) {
			modeloAux.addRow(obj);
			Camino getC = listaCaminos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getDuracion(), i, 1);
			modeloAux.setValueAt(getC.getDistancia(), i, 2);
			modeloAux.setValueAt(getC.getPeso_soportado(), i, 3);
			modeloAux.setValueAt(getC.getPlanta_init(), i, 4);
			modeloAux.setValueAt(getC.getPlanta_end(), i, 5);
			modeloAux.setValueAt(i, i, 6);
		}
		
		return modeloAux;
	}
	public DefaultTableModel limpiar(List<Camino> listaCaminos) {
		modeloAux = new DefaultTableModel();
		modeloAux.setColumnIdentifiers(columnas);

		Object obj[] = null;
		for (int i = 0; i < listaCaminos.size(); i++) {
			modeloAux.addRow(obj);
			Camino getC = listaCaminos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getDuracion(), i, 1);
			modeloAux.setValueAt(getC.getDistancia(), i, 2);
			modeloAux.setValueAt(getC.getPeso_soportado(), i, 3);
			modeloAux.setValueAt(getC.getPlanta_init(), i, 4);
			modeloAux.setValueAt(getC.getPlanta_end(), i, 5);
			modeloAux.setValueAt(i, i, 6);
		}
		return modeloAux;}
	

		
	}
	

