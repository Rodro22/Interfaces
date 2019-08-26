package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import auxiliar.Magica;
import auxiliar.MiModelo;
import baseDeDatos.BaseDeDatos;
import grafo.Vertice;
import modelo.Camino;
import modelo.Insumo;
import modelo.Planta;
import modelo.Recorrido;
import modelo.StockInsumo;

import javax.swing.JList;
import java.awt.Color;

public class PanelPARTE04A extends JPanel {
	private JTable table;
	public MiModelo modeloAux;
	public MiModelo modeloAux_2;
	private final String[] columnas = {"Id: ", "Nombre: ", "Descripcion: ", "Costo: ", "Posicion: "};
	private final String[] columnas_2 = {"Recorrido"};
	private JTable tableMejorCamino;

	/**
	 * Create the panel.
	 */
	public PanelPARTE04A(List<Planta> listaPlantas, List<Insumo> listaInsumos, List<Camino> listaCaminos, BaseDeDatos unaBD) {
		setLayout(null);
		setSize(770, 540);

		
		PanelPARTE04AGrafo panelGrafo = new PanelPARTE04AGrafo(listaPlantas, listaCaminos, listaPlantas, listaPlantas, false);
		panelGrafo.setTitle("Plantas");
		panelGrafo.setSize(750, 320);
		panelGrafo.setLocation(0, 0);
		panelGrafo.setVisible(true);
		add(panelGrafo);
		
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
			modeloAux.setValueAt(getC.getDescripcion(), i, 2);
			modeloAux.setValueAt(getC.getCosto(), i, 2);
			modeloAux.setValueAt(i, i, 4);
		}
		
		JLabel lblListaInsumos = new JLabel("Lista insumos:");
		lblListaInsumos.setBounds(25, 331, 99, 14);
		add(lblListaInsumos);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					int idInsumo = (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
					Magica magica = new Magica();
					List<Vertice<Planta>> lista_plantasFINAL = magica.filtrarStock2(idInsumo, unaBD.listaStockInsumo, unaBD.grafo.vertices);
					List<Planta> listaPlantasFaltanteInsumo = new ArrayList<Planta>();
					Planta guia = new Planta();
					
					for(Vertice<Planta> unVertice: lista_plantasFINAL) {
//						System.out.println(unVertice.valor.getClass());
						
						if(unVertice.valor.getClass() == guia.getClass()) {
							Planta aux = new Planta();
							aux.setEsAcopio(unVertice.valor.esAcopio);
							aux.setId(unVertice.valor.idplanta);
							aux.setNombre(unVertice.valor.nombre_planta);
							listaPlantasFaltanteInsumo.add(aux);
						}
					}
					
//						System.out.println("Le falta el insumo a: "+listaPlantasFaltanteInsumo);
						
						if(listaPlantasFaltanteInsumo.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ninguna planta necesita este insumo", "Accion del sistema", JOptionPane.INFORMATION_MESSAGE);
						}
					Vertice<Planta> v1aux = unaBD.grafo.vertices.get(0);
					Vertice<Planta> v2aux = unaBD.grafo.vertices.get(1);
					Recorrido unRecorrido = magica.mejorRecorrido(magica.filtrarStock2(idInsumo, unaBD.listaStockInsumo, unaBD.grafo.vertices), unaBD.grafo.armarRecorridos(unaBD.grafo.caminos(v1aux, v2aux)));		
					
					List<Planta> listaPlantasparaArmarCamino = new ArrayList<Planta>();
					for(Vertice<Planta> unVertice: unRecorrido.recorrido) {
//						System.out.println(unVertice.valor.getClass());
						
						if(unVertice.valor.getClass() == guia.getClass()) {
							Planta aux = new Planta();
							aux.setEsAcopio(unVertice.valor.esAcopio);
							aux.setId(unVertice.valor.idplanta);
							aux.setNombre(unVertice.valor.nombre_planta);
							listaPlantasparaArmarCamino.add(aux);
						}
					}
					
//					System.out.println(listaPlantasparaArmarCamino);
					
					
					
					PanelPARTE04AGrafo panelGrafoInsumo = new PanelPARTE04AGrafo(listaPlantas, listaCaminos, listaPlantasparaArmarCamino, listaPlantasFaltanteInsumo, true);
					panelGrafoInsumo.setTitle("Plantas con faltante de insumo");
					panelGrafoInsumo.setSize(750, 320);
					panelGrafoInsumo.setLocation(0, 0);
					panelGrafoInsumo.setVisible(true);
					panelGrafo.setVisible(false);
					add(panelGrafoInsumo);
					
					
				}	
			}
		});
		btnMostrar.setBounds(25, 484, 89, 23);
		add(btnMostrar);
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		JButton btnMejorCamino = new JButton("Mejor Camino");
		
		btnMejorCamino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					int idInsumo = (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
//					JOptionPane.showMessageDialog(null, "Posicion: " + idInsumo);

					Magica aux = new Magica();
					Vertice<Planta> v1aux = unaBD.grafo.vertices.get(0);
					Vertice<Planta> v2aux = unaBD.grafo.vertices.get(1);
					Recorrido unRecorrido = aux.mejorRecorrido(aux.filtrarStock2(idInsumo, unaBD.listaStockInsumo, unaBD.grafo.vertices), unaBD.grafo.armarRecorridos(unaBD.grafo.caminos(v1aux, v2aux)));
					mostrar(unRecorrido);					
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnMejorCamino.setBounds(129, 484, 124, 23);
		add(btnMejorCamino);
		
		JLabel lblParteN = new JLabel("PARTE N\u00BA 4 \"A\"");
		lblParteN.setForeground(Color.BLUE);
		lblParteN.setBounds(670, 515, 100, 15);
		add(lblParteN);

	}
	
	
	public void inicializar(List<Insumo> listaInsumos) {

		table = new JTable(mostrarElementos2(listaInsumos));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 347, 745, 126);
		add(scrollPane);
		
		
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
			modeloAux.setValueAt(getC.getDescripcion(), i, 2);
			modeloAux.setValueAt(getC.getCosto(), i, 3);
			modeloAux.setValueAt(i, i, 4);
		}
		return modeloAux;
	}
	
	
	public void mostrar(Recorrido unRecorrido) {
		
		tableMejorCamino = new JTable(mostrarRecorridos(unRecorrido));
		JScrollPane scrollPaneCamino = new JScrollPane(tableMejorCamino);
		scrollPaneCamino.setBounds(260, 475, 510, 40);
		add(scrollPaneCamino);
	}
	
	public MiModelo mostrarRecorridos(Recorrido unRec) {
		modeloAux_2 = new MiModelo();
		modeloAux_2.setColumnIdentifiers(columnas_2);
		Object obj[] = null;
		modeloAux_2.addRow(obj);
		modeloAux_2.setValueAt(unRec.recorrido,0,0);
		return modeloAux_2;
	}
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}
	
	
}
