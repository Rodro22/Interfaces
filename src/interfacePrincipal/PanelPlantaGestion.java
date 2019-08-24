package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Color;
import auxiliar.MiModelo;
import baseDeDatos.BaseDeDatos;
import modelo.*;

public class PanelPlantaGestion extends JPanel {
	private JTable table;
	public MiModelo modeloAux;
	private final String[] columnas = {"Id: ", "Nombre: ", "Acopio: ", "Stock", "Posicion: "};


	public PanelPlantaGestion(List<Planta> listaPlantas, JFrame frame, List<Insumo> listaInsumos, List<StockInsumo> listaStockInsumos, BaseDeDatos unaBD) {
		setLayout(null);
		setSize(770, 540);
		inicializarPlantas(unaBD.listaPlantas);
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < unaBD.listaPlantas.size(); i++) {
		modeloAux.addRow(obj);
		Planta getC = unaBD.listaPlantas.get(i);
		modeloAux.setValueAt(getC.getId(), i, 0);
		modeloAux.setValueAt(getC.getNombre_planta(), i, 1);
		modeloAux.setValueAt(getC.getEsAcopio(), i, 2);
		modeloAux.setValueAt(getC.unStock.lista_insumo, i, 3);
		modeloAux.setValueAt(i, i, 4);
		}
		
		JLabel lblListaDePlantas = new JLabel("Lista de plantas:");
		lblListaDePlantas.setBounds(24, 11, 100, 14);
		add(lblListaDePlantas);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////	BOTON MODIFICAR     //////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1 ) {
					
	        	 	Integer id =  (Integer) modeloAux.getValueAt(table.getSelectedRow(), 0);
	        	 	String nombre = (String) modeloAux.getValueAt(table.getSelectedRow(), 1);
	        	 	Boolean acopio =   (Boolean) modeloAux.getValueAt(table.getSelectedRow(), 2);        	 	    	 	
					Planta plantaModificar = new Planta(id, nombre, acopio);						
					JOptionPane.showMessageDialog(null, "Planta a modificar: "+plantaModificar.nombre_planta, "Accion del sistema", JOptionPane.INFORMATION_MESSAGE);
					
					PanelPlantaAuxModificar panelPlanta = new PanelPlantaAuxModificar(unaBD, plantaModificar);
					frame.setContentPane(panelPlanta);
					frame.setVisible(true);  
					
				} else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
					}
					}});
		btnModificar.setBounds(96, 288, 89, 23);
		add(btnModificar);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////	BOTON CREAR     //////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPlantaAuxAgregar panelPlanta = new PanelPlantaAuxAgregar(listaInsumos, listaStockInsumos, unaBD.listaPlantas);
				frame.setContentPane(panelPlanta);
				 frame.setVisible(true);  
				 }
		});
		
		btnCrear.setBounds(207, 288, 89, 23);
		add(btnCrear);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////	BOTON BORRAR     /////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int id =  (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
					JOptionPane.showMessageDialog(null, "Planta borrada: "+modeloAux.getValueAt(table.getSelectedColumn(), 1), "Accion del sistema", JOptionPane.INFORMATION_MESSAGE);
//					System.out.println(id);
//					for(Planta plantaAux : listaPlantas) {
//					System.out.println("Inicio: "+listaPlantas);
//					System.out.println("Inicio: " + unaBD.listaCaminos.size());
					
					for(int w=0; w<unaBD.listaPlantas.size(); w++) {
						if(unaBD.listaPlantas.get(w).idplanta == id) {

							int idStock = unaBD.listaPlantas.get(w).unStock.id_stock;
							for(int h = 0; h<unaBD.listaStockInsumo.size(); h++) {
								if(unaBD.listaStockInsumo.get(h).stock.id_stock == idStock) {
//									System.out.println(listaStockInsumos);
									unaBD.listaStockInsumo.remove(h);
									h--;
//									System.out.println(listaStockInsumos);
								}
							}
							unaBD.listaPlantas.remove(w);
							w--;
						}
						for(int x = 0 ; x< unaBD.listaCaminos.size() ; x++) {
							
							if(unaBD.listaCaminos.get(x).getPlanta_init().idplanta == id ) {
								unaBD.listaCaminos.remove(x);
								x--;
							}
							else if (unaBD.listaCaminos.get(x).getPlanta_end().idplanta == id ) {
								unaBD.listaCaminos.remove(x);
								x--;
							}
							}
						}
//					System.out.println("Fin: "+listaPlantas);	
//					System.out.println("Fin: " + unaBD.listaCaminos.size());
					inicializarPlantas(unaBD.listaPlantas);
				
				
				} 	else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
				}	}	);
		
		btnBorrar.setBounds(314, 288, 89, 23);
		add(btnBorrar);
		
		JLabel lblGestionPlantas = new JLabel("Gestion Plantas");
		lblGestionPlantas.setForeground(Color.BLUE);
		lblGestionPlantas.setBounds(670, 515, 100, 15);
		add(lblGestionPlantas);

	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////	INICIALIZAR TABLAS     ///////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void inicializarPlantas(List<Planta> listaPlantas) {

		table = new JTable(mostrarElementosPlantas(listaPlantas));
		table.setBounds(24, 36, 629, 227);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 36, 629, 227);
		add(scrollPane);
		
	}
	public DefaultTableModel mostrarElementosPlantas(List<Planta> listaPlantas) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaPlantas.size(); i++) {
		modeloAux.addRow(obj);
		Planta getC = listaPlantas.get(i);
		modeloAux.setValueAt(getC.getId(), i, 0);
		modeloAux.setValueAt(getC.getNombre_planta(), i, 1);
		modeloAux.setValueAt(getC.getEsAcopio(), i, 2);
		modeloAux.setValueAt(getC.unStock.lista_insumo, i, 3);
		modeloAux.setValueAt(i, i, 4);
		}
		return modeloAux;
	}
	
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
	}
	
	
}
