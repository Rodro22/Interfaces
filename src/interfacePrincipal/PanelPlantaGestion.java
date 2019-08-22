package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import auxiliar.MiModelo;
import modelo.Camion;
import modelo.Insumo;
import modelo.Planta;
import modelo.Stock;
import modelo.StockInsumo;

import javax.swing.JTable;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPlantaGestion extends JPanel {
	private JTable table;
	public MiModelo modeloAux;
	private final String[] columnas = {"Id: ", "Nombre: ", "Acopio: ", "Stock", "Posicion: "};


	public PanelPlantaGestion(List<Planta> listaPlantas, JFrame frame, List<Insumo> listaInsumos, List<StockInsumo> listaStockInsumos) {
		setLayout(null);
		
		inicializar(listaPlantas);
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
		
		
		
		
		
		JLabel lblListaDePlantas = new JLabel("Lista de plantas:");
		lblListaDePlantas.setBounds(24, 11, 100, 14);
		add(lblListaDePlantas);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPlantaAuxModificar panelPlanta = new PanelPlantaAuxModificar();
				frame.setContentPane(panelPlanta);
				frame.setVisible(true);  }
		});
		
		btnModificar.setBounds(96, 288, 89, 23);
		add(btnModificar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelPlantaAuxAgregar panelPlanta = new PanelPlantaAuxAgregar(listaInsumos, listaStockInsumos, listaPlantas);
				frame.setContentPane(panelPlanta);
				 frame.setVisible(true);  
				 }
		});
		
		btnCrear.setBounds(207, 288, 89, 23);
		add(btnCrear);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int id =  (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
					System.out.println(id);
//					for(Planta plantaAux : listaPlantas) {
					System.out.println("Inicio: "+listaPlantas);
					for(int w=0; w<listaPlantas.size(); w++) {
						if(listaPlantas.get(w).idplanta == id) {
							//////////////
							///
							/////////////
							///
							int idStock = listaPlantas.get(w).unStock.id_stock;
							for(int h = 0; h<listaStockInsumos.size(); h++) {
								if(listaStockInsumos.get(h).stock.id_stock == idStock) {
									System.out.println(listaStockInsumos);
									listaStockInsumos.remove(h);
									h--;
									System.out.println(listaStockInsumos);
								}
							}
							listaPlantas.remove(w);
							w--;
						}
							/////
							///
							/////
							////////////////
						}
					System.out.println("Fin: "+listaPlantas);	
				}}}
		);
		
		btnBorrar.setBounds(314, 288, 89, 23);
		add(btnBorrar);

	}

	public void inicializar(List<Planta> listaPlantas) {

		table = new JTable(mostrarElementos2(listaPlantas));
		table.setBounds(24, 36, 629, 227);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 36, 629, 227);
		add(scrollPane);
		
	}
	public DefaultTableModel mostrarElementos2(List<Planta> listaPlantas) {
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











}
