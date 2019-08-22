package interfacePrincipal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Camino;
import modelo.Insumo;
import modelo.Planta;

import javax.swing.JList;
import java.awt.Color;

public class PanelCaminoAgregar extends JPanel {

	public List<Camino> listaCaminos_principal;
	public List<Planta> listaPlantas_principal;
	private JTextField textId;
	private JTextField textDuracion;
	private JTextField textDistancia;
	private JTextField textPeso;
	private JTextField textPinicial;
	private JTextField textPfinal;
	private JTable table;
	private JTable table_1;
	public DefaultTableModel modeloAux, modeloAux2;
	private final String[] columnas = {"Id: ", "Nombre: ", "Acopio: ", "Posicion"};
	public int x = 0;
	public int y = 0;
	
	
	public PanelCaminoAgregar(List<Camino> listaCaminos, List<Planta> listaPlantas) {
		this.listaCaminos_principal = listaCaminos;
		setLayout(null);
		setSize(770, 540);
		this.listaCaminos_principal = listaCaminos;
		this.listaPlantas_principal = listaPlantas;
		
		inicializar1(listaPlantas);
		inicializar2(listaPlantas);
		
		//ESTO ME PERMITE TRABAJAR CON EL JTABLE
		modeloAux = new DefaultTableModel();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaPlantas.size(); i++) {
			modeloAux.addRow(obj);
			Planta getC = listaPlantas.get(i);
			modeloAux.setValueAt(getC.idplanta, i, 0);
			modeloAux.setValueAt(getC.nombre_planta, i, 1);
			modeloAux.setValueAt(getC.esAcopio, i, 2);
			modeloAux.setValueAt(i, i, 3);
		}
		modeloAux2 = new DefaultTableModel();
		modeloAux2.setColumnIdentifiers(columnas);
		Object obj2[] = null;
		
		for (int i = 0; i < listaPlantas.size(); i++) {
			modeloAux2.addRow(obj);
			Planta getC = listaPlantas.get(i);
			modeloAux2.setValueAt(getC.idplanta, i, 0);
			modeloAux2.setValueAt(getC.nombre_planta, i, 1);
			modeloAux2.setValueAt(getC.esAcopio, i, 2);
			modeloAux2.setValueAt(i, i, 3);
		}
		
		
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 22, 46, 14);
		add(lblId);
		
		JLabel lblDuracionMinutos = new JLabel("Duracion Minutos: ");
		lblDuracionMinutos.setBounds(10, 47, 89, 14);
		add(lblDuracionMinutos);
		
		JLabel lblDitanciaKm = new JLabel("Ditancia KM:");
		lblDitanciaKm.setBounds(10, 72, 89, 14);
		add(lblDitanciaKm);
		
		JLabel lblPesoMximo = new JLabel("Peso maximo:");
		lblPesoMximo.setBounds(10, 100, 89, 14);
		add(lblPesoMximo);
		
		textId = new JTextField();
		textId.setBounds(119, 19, 75, 20);
		add(textId);
		textId.setColumns(10);
		
		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(119, 44, 75, 20);
		add(textDuracion);
		
		textDistancia = new JTextField();
		textDistancia.setColumns(10);
		textDistancia.setBounds(119, 69, 75, 20);
		add(textDistancia);
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(119, 97, 75, 20);
		add(textPeso);
		
		JLabel lblPlantaInicialId = new JLabel("Planta Inicial Id:");
		lblPlantaInicialId.setBounds(261, 25, 89, 14);
		add(lblPlantaInicialId);
		
		textPinicial = new JFormattedTextField ();
		textPinicial.setColumns(10);
		textPinicial.setBounds(370, 22, 75, 20);
		add(textPinicial);
		
		JLabel lblPlantaFinal = new JLabel("Planta Final Id:");
		lblPlantaFinal.setBounds(261, 63, 89, 14);
		add(lblPlantaFinal);
		
		textPfinal = new JFormattedTextField ();
		textPfinal.setColumns(10);
		textPfinal.setBounds(370, 60, 75, 20);
		add(textPfinal);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((table.getSelectedRow() != -1) && (table_1.getSelectedRow() != -1)) {
					x =  (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
					y =  (int) modeloAux2.getValueAt(table_1.getSelectedRow(), 0);
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos "+ x+ " "+y);
					textPinicial.setText((String) modeloAux.getValueAt(table.getSelectedRow(), 0));
					textPfinal.setText((String) modeloAux.getValueAt(table_1.getSelectedRow(), 0));
			}}
		});
		
		btnAgregar.setBounds(505, 366, 89, 23);
		add(btnAgregar);

		
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if((textId.getText().length() != 0) && (textDuracion.getText().length() != 0) && (textDistancia.getText().length() != 0) && (textPeso.getText().length() != 0)
						&& (textPinicial.getText().length() != 0) && (textPfinal.getText().length() != 0)) {
					Planta p1 = null;
					Planta p2 = null;
					for(Planta aux : listaPlantas) {
						if(x == aux.idplanta) { p1 = aux;}
						if(y == aux.idplanta) { p2 = aux;}
					}
					
					Camino unCamino = new Camino(Integer.parseInt(textId.getText()), p1, p2, Double.parseDouble(textDuracion.getText()), Double.parseDouble(textDistancia.getText()), 
							Double.parseDouble(textPeso.getText()));
					listaCaminos.add(unCamino);
					
					if (listaCaminos.contains(unCamino)) {
						JOptionPane.showMessageDialog(null, "Elemento agregado correctamente", "Acción del sistema", JOptionPane.INFORMATION_MESSAGE);}	
					}	else {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);	}


			
			}
		});
		btnCrear.setBounds(505, 96, 89, 23);
		add(btnCrear);
		
		JLabel lblSeleccionePlantaInicial = new JLabel("Seleccione Planta Inicial:");
		lblSeleccionePlantaInicial.setBounds(10, 141, 136, 14);
		add(lblSeleccionePlantaInicial);
		
		JLabel lblSeleccionePlantaFinall = new JLabel("Seleccione Planta Final:");
		lblSeleccionePlantaFinall.setBounds(10, 258, 136, 14);
		add(lblSeleccionePlantaFinall);
		
		table = new JTable();
		table.setBounds(32, 166, 640, 81);
		add(table);
		
		table_1 = new JTable();
		table_1.setBounds(32, 280, 640, 81);
		add(table_1);
		
		JLabel lblAgregarCamino = new JLabel("Agregar Camino");
		lblAgregarCamino.setForeground(Color.BLUE);
		lblAgregarCamino.setBounds(670, 515, 100, 15);
		add(lblAgregarCamino);
		
		
		
		
	}
	
	public void inicializar1(List<Planta> listaPlantas) {
		table = new JTable(mostrarElementos2(listaPlantas));
		table.setBounds(10, 183, 680, 172);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(32, 166, 640, 81);
		add(scrollPane);

	}
	public void inicializar2(List<Planta> listaPlantas) {
		table_1 = new JTable(mostrarElementos2(listaPlantas));
		table_1.setBounds(10, 183, 680, 172);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(32, 280, 640, 81);
		add(scrollPane);

	}
	public DefaultTableModel mostrarElementos2(List<Planta> listaPlantas) {
		modeloAux = new DefaultTableModel();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaPlantas.size(); i++) {
			modeloAux.addRow(obj);
			Planta getC = listaPlantas.get(i);
			modeloAux.setValueAt(getC.idplanta, i, 0);
			modeloAux.setValueAt(getC.nombre_planta, i, 1);
			modeloAux.setValueAt(getC.esAcopio, i, 2);
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


