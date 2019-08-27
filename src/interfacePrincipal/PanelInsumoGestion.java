package interfacePrincipal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import auxiliar.MiModelo;
import modelo.Insumo;
import modelo.Planta;
import modelo.StockInsumo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class PanelInsumoGestion extends JPanel {

	public List<Insumo> listaInsumos_principal;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTable table_1;
	public MiModelo modeloAux;
	private final String[] columnas = {"Id: ", "Nombre: ", "Costo: ", "Descripcion: ", "Posicion: "};
	private JTextField textIdModificar;
	private JTextField textNombreModificar;
	private JTextField textDescripcionModificar;
	private JTextField textPrecioModificar;

	public PanelInsumoGestion(List<Insumo> listaInsumos, List<Planta> listaPlantas, List<StockInsumo> listaStockInsumos) {
		this.listaInsumos_principal = listaInsumos;
		setLayout(null);
		setSize(770, 540);
////////////////////////////////////////////////////////////////////////////////////////
		//ESTO ES LO QUE MUESTRA AL INICIO//
		//JLabel lblListaDeInsumos = new JLabel("Lista de Insumos:");
		//lblListaDeInsumos.setBounds(10, 136, 130, 14);
		//add(lblListaDeInsumos);
		//table_1 = new JTable(mostrarElementos(listaInsumos));
		//table_1.setBounds(40, 171, 595, 150);
		//JScrollPane scrollPane = new JScrollPane(table_1);
		//scrollPane.setBounds(40, 171, 595, 150);
		//add(scrollPane);
		inicializar(listaInsumos);
		//ESTO ME PERMITE TRABAJAR CON EL JTABLE
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaInsumos.size(); i++) {
		modeloAux.addRow(obj);
		Insumo getC = listaInsumos.get(i);
		modeloAux.setValueAt(getC.getId(), i, 0);
		modeloAux.setValueAt(getC.getNombre(), i, 1);
		modeloAux.setValueAt(getC.getCosto(), i, 2);
		modeloAux.setValueAt(getC.getDescripcion(), i, 3);
		modeloAux.setValueAt(i, i, 4);
		}

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 65, 14);
		add(lblNombre);
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 60, 90, 14);
		add(lblDescripcion);
		JLabel lblPrecio = new JLabel("Costo:");
		lblPrecio.setBounds(10, 85, 46, 14);
		add(lblPrecio);

		txtId = new JTextField();
		txtId.setBounds(110, 11, 130, 20);
		add(txtId);
		txtId.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(110, 36, 130, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(110, 60, 130, 20);
		add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(110, 85, 130, 20);
		add(txtPrecio);
		txtPrecio.setColumns(10);
/////////////////////////////////////////////////////////////////////////////
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(250, 56, 89, 23);
		add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((txtId.getText().length() != 0) && (txtNombre.getText().length() != 0) && (txtDescripcion.getText().length() != 0) && (txtPrecio.getText().length() != 0) ) {
					
					Insumo unInsumoAux = new Insumo(Integer.parseInt(txtId.getText()), txtNombre.getText(),txtDescripcion.getText(), Double.parseDouble(txtPrecio.getText()));
					listaInsumos.add(unInsumoAux);
					
					if (listaInsumos.contains(unInsumoAux)) {
						JOptionPane.showMessageDialog(null, "Elemento agregado correctamente", "Acción del sistema", JOptionPane.INFORMATION_MESSAGE);}	
					}	else {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);	}
				
					table_1 = new JTable(mostrarElementos2(listaInsumos));
					table_1.setBounds(40, 171, 595, 150);
					JScrollPane scrollPane = new JScrollPane(table_1);
					scrollPane.setBounds(40, 171, 595, 150);
					add(scrollPane);

			}
		});
		
//		JButton btnBorrar = new JButton("Borrar");
//		btnBorrar.setBounds(311, 132, 89, 23);
//		add(btnBorrar);
//		btnBorrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int x = Integer.parseInt(textFilaB.getText());
//				table_1 = new JTable(eliminarElemento(listaInsumos, x));
//				table_1.setBounds(40, 171, 595, 150);
//				JScrollPane scrollPane = new JScrollPane(table_1);
//				scrollPane.setBounds(40, 171, 595, 150);
//				add(scrollPane);
//				
//			}
//		});
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(311, 132, 89, 23);
		add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int x = 0;
			if(table_1.getSelectedRow() != -1) {
				
				x = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 4);
				
				
				Insumo auxInsumo = new Insumo((Integer) modeloAux.getValueAt(table_1.getSelectedRow(), 0));
				
				
				eliminarInsumo(listaPlantas, auxInsumo);
				eliminarStockInsumo(listaStockInsumos, auxInsumo);
			
				JOptionPane.showMessageDialog(null, "Posicion: "+ x);
				
				table_1 = new JTable(eliminarElemento2(listaInsumos, x));
				table_1.setBounds(40, 171, 595, 150);
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(40, 171, 595, 150);
				add(scrollPane);
				
				
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}

				
			}});
		

//		public void actionPerformed(ActionEvent e) {
//			int i = 0;
//	        if (table_1.getSelectedRow() != -1) {
//
//	        	 i = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 4);
//	        	 JOptionPane.showMessageDialog(null, "Posicion: "+ i);
//			        Insumo unInsumoAux = new Insumo(Integer.parseInt(textIdModificar.getText()), textNombreModificar.getText(),textDescripcionModificar.getText(), Double.parseDouble(textPrecioModificar.getText()));
//					table_1 = new JTable(modificarElemento2(listaInsumos, i, unInsumoAux));
//					table_1.setBounds(40, 171, 595, 150);
//					JScrollPane scrollPane = new JScrollPane(table_1);
//					scrollPane.setBounds(40, 171, 595, 150);
//					add(scrollPane);
//	            
//	        } else {
//	            JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
//	        }
//	         
//		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		JButton btnModificar = new JButton("Modificar");
//		btnModificar.setBounds(375, 132, 89, 23);
//		add(btnModificar);
//		btnModificar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Insumo unInsumoAux = new Insumo(Integer.parseInt(txtId.getText()), txtNombre.getText(),txtDescripcion.getText(), Double.parseDouble(txtPrecio.getText()));
//				int x = Integer.parseInt(textFilaM.getText());
//				table_1 = new JTable(modificarElemento(listaInsumos, x, unInsumoAux));
//				table_1.setBounds(40, 171, 595, 150);
//				JScrollPane scrollPane = new JScrollPane(table_1);
//				scrollPane.setBounds(40, 171, 595, 150);
//				add(scrollPane); 
//			}
//		});
		
		JLabel label = new JLabel("Costo: ");
		label.setBounds(349, 85, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Descripcion: ");
		label_1.setBounds(349, 60, 76, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Nombre: ");
		label_2.setBounds(349, 36, 65, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Id: ");
		label_3.setBounds(349, 11, 46, 14);
		add(label_3);
		
		textIdModificar = new JTextField();
		textIdModificar.setColumns(10);
		textIdModificar.setBounds(435, 11, 130, 20);
		add(textIdModificar);
		
		textNombreModificar = new JTextField();
		textNombreModificar.setColumns(10);
		textNombreModificar.setBounds(435, 36, 130, 20);
		add(textNombreModificar);
		
		textDescripcionModificar = new JTextField();
		textDescripcionModificar.setColumns(10);
		textDescripcionModificar.setBounds(435, 60, 130, 20);
		add(textDescripcionModificar);
		
		textPrecioModificar = new JTextField();
		textPrecioModificar.setColumns(10);
		textPrecioModificar.setBounds(435, 85, 130, 20);
		add(textPrecioModificar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(588, 56, 89, 23);
		add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
		        if (table_1.getSelectedRow() != -1) {

		        	 i = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 4);
		        	 JOptionPane.showMessageDialog(null, "Posicion: "+ i);
				        
		        	 	//insumo viejo
		        	 	Integer id = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 0);
		        	 	String nombre = (String) modeloAux.getValueAt(table_1.getSelectedRow(), 1);
		        	 	Double costo = (Double) modeloAux.getValueAt(table_1.getSelectedRow(), 2);
		        	 	String descripcion = (String) modeloAux.getValueAt(table_1.getSelectedRow(), 3);        	 	
		        	 	Insumo unInsumoViejo = new Insumo (id, nombre, descripcion, costo);
		        	 	//insumo nuevo
		        	 	Insumo unInsumoNuevo = new Insumo(Integer.parseInt(textIdModificar.getText()), textNombreModificar.getText(),textDescripcionModificar.getText(), Double.parseDouble(textPrecioModificar.getText()));
						
		        	 	modificarInsumo(listaPlantas, unInsumoViejo, unInsumoNuevo);
				        table_1 = new JTable(modificarElemento2(listaInsumos, i, unInsumoNuevo));
						
				        
				        modificarStockInsumo(listaStockInsumos, unInsumoViejo, unInsumoNuevo);
						
				        System.out.println(listaStockInsumos);
				        
						inicializar2(listaInsumos, table_1);
//						table_1.setBounds(40, 171, 595, 150);
//						JScrollPane scrollPane = new JScrollPane(table_1);
//						scrollPane.setBounds(40, 171, 595, 150);
//						add(scrollPane);
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
		        }
		         
			}
		});
		JLabel lblListaDeInsumos = new JLabel("Lista de Insumos:");
		lblListaDeInsumos.setBounds(10, 136, 130, 14);
		add(lblListaDeInsumos);
		
		JLabel lblGestionInsumos = new JLabel("Gestion Insumos");
		lblGestionInsumos.setForeground(Color.BLUE);
		lblGestionInsumos.setBounds(670, 515, 100, 15);
		add(lblGestionInsumos);


		


	}
	public void inicializar(List<Insumo> listaInsumos) {

		table_1 = new JTable(mostrarElementos2(listaInsumos));
//		table_1.setBounds(40, 171, 595, 150);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(40, 171, 595, 150);
		add(scrollPane);
		
	}
	public void inicializar2(List<Insumo> listaInsumos, JTable table) {
		table = new JTable(mostrarElementos2(listaInsumos));
//		table.setBounds(40, 171, 595, 150);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 171, 595, 150);
		add(scrollPane);
	}
	
	public DefaultTableModel mostrarElementos(List<Insumo> listaInsumos) {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Id: ");
		modelo.addColumn("Nombre: ");
		modelo.addColumn("Descripcion: ");
		modelo.addColumn("Precio: ");
		modelo.addColumn("Posicion: ");
		Object obj[] = null;

		for (int i = 0; i < listaInsumos.size(); i++) {
			modelo.addRow(obj);
			Insumo getC = listaInsumos.get(i);
			modelo.setValueAt(getC.getId(), i, 0);
			modelo.setValueAt(getC.getNombre(), i, 1);
			modeloAux.setValueAt(getC.costo, i, 2);
			modelo.setValueAt(getC.getDescripcion(), i, 3);
			modelo.setValueAt(i, i, 4);
		}
		return modelo;
	}
	
	public DefaultTableModel mostrarElementos2(List<Insumo> listaInsumos) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaInsumos.size(); i++) {
			modeloAux.addRow(obj);
			Insumo getC = listaInsumos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getNombre(), i, 1);
			modeloAux.setValueAt(getC.costo, i, 2);
			modeloAux.setValueAt(getC.getDescripcion(), i, 3);
			modeloAux.setValueAt(i, i, 4);
		}
		return modeloAux;
	}
	
	public DefaultTableModel eliminarElemento(List<Insumo> listaInsumos, int x) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Id: ");
		modelo.addColumn("Nombre: ");
		modelo.addColumn("Descripcion: ");
		modelo.addColumn("Precio: ");
		modelo.addColumn("Posicion: ");
		Object obj[] = null;
		listaInsumos.remove(x);
		for (int i = 0; i < listaInsumos.size(); i++) {
			modelo.addRow(obj);
			Insumo getC = listaInsumos.get(i);
			modelo.setValueAt(getC.getId(), i, 0);
			modelo.setValueAt(getC.getNombre(), i, 1);
			modelo.setValueAt(getC.getDescripcion(), i, 2);
			modeloAux.setValueAt(getC.costo, i, 2);
			modelo.setValueAt(i, i, 4);
		}
		return modelo;
	}
	
	public DefaultTableModel eliminarElemento2(List<Insumo> listaInsumos, int x) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		
		listaInsumos.remove(x);
		
		Object obj[] = null;
		
		for (int i = 0; i < listaInsumos.size(); i++) {
			modeloAux.addRow(obj);
			Insumo getC = listaInsumos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getNombre(), i, 1);
			modeloAux.setValueAt(getC.costo, i, 2);
			modeloAux.setValueAt(getC.getDescripcion(), i, 3);
			
			modeloAux.setValueAt(i, i, 4);
		}
		System.out.println(listaInsumos);
		return modeloAux;
	}
	
	public DefaultTableModel modificarElemento2(List<Insumo> listaInsumos, int x, Insumo aux) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		listaInsumos.add(x, aux);
		listaInsumos.remove(x+1);
		Object obj[] = null;
		for (int i = 0; i < listaInsumos.size(); i++) {
			modeloAux.addRow(obj);
			Insumo getC = listaInsumos.get(i);
			modeloAux.setValueAt(getC.getId(), i, 0);
			modeloAux.setValueAt(getC.getNombre(), i, 1);
			modeloAux.setValueAt(getC.costo, i, 2);
			modeloAux.setValueAt(getC.getDescripcion(), i, 3);
			
			modeloAux.setValueAt(i, i, 4);}
		return modeloAux;}
	
	public void eliminarInsumo(List<Planta> listaPlantas, Insumo unInsumo) {
		
		for(int i=0; i<listaPlantas.size(); i++) {
			
			for(int j=0; j<listaPlantas.get(i).unStock.lista_insumo.size(); j++) {
				
				if(	listaPlantas.get(i).unStock.lista_insumo.get(j).idinsumo== unInsumo.idinsumo) {
//					System.out.println("se elimino: " + listaPlantas.get(i).unStock.lista_insumo.get(j));
					listaPlantas.get(i).unStock.lista_insumo.remove(j);
				}
			}
		}
		
		
		
	}
	
	public void eliminarStockInsumo(List<StockInsumo> listaStockInsumos, Insumo unInsumo){
	
		for(int i = 0; i<listaStockInsumos.size() ; i++) {
			
			if(listaStockInsumos.get(i).insumo.idinsumo == unInsumo.idinsumo ) {
				listaStockInsumos.remove(unInsumo);	
			}		} }
	
	
	public void modificarInsumo(List<Planta> listaPlantas, Insumo insumoViejo, Insumo insumoNuevo) {
		
		for(int i=0; i<listaPlantas.size(); i++) {
			
			for(int j=0; j<listaPlantas.get(i).unStock.lista_insumo.size(); j++) {
				
				if(	listaPlantas.get(i).unStock.lista_insumo.get(j).idinsumo == insumoViejo.idinsumo) {
//					System.out.println("se elimino: " + listaPlantas.get(i).unStock.lista_insumo.get(j));
					listaPlantas.get(i).unStock.lista_insumo.remove(j);
					listaPlantas.get(i).unStock.lista_insumo.add(insumoNuevo);
					break;
				}
			}
		}	
	}
	
	public void modificarStockInsumo(List<StockInsumo> listaStockInsumos, Insumo insumoViejo, Insumo insumoNuevo){
			
		int tamLista = listaStockInsumos.size();
		List<StockInsumo> listaAux = new ArrayList<StockInsumo>();
		
		for(int i = 0; i<tamLista ; i++) {
			
			if(listaStockInsumos.get(i).insumo.idinsumo == insumoViejo.idinsumo ) {
				StockInsumo unStockInsumo = new StockInsumo(insumoNuevo, listaStockInsumos.get(i).stock, listaStockInsumos.get(i).cant_max, listaStockInsumos.get(i).cant_disponible);
				listaAux.add(unStockInsumo);
				listaStockInsumos.remove(i);
				tamLista--;
				
			}		} 
		listaStockInsumos.addAll(listaAux);
	}
	
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}
	
	
	
	

}
