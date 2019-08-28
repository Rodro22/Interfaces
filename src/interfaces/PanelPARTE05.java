package interfaces;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import auxiliar.*;
import auxiliar.InsumoCant;
import auxiliar.InsumoFaltante;
import auxiliar.Magica;
import auxiliar.MiModelo;
import baseDeDatos.BaseDeDatos;
import grafo.*;
import modelo.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelPARTE05 extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	public MiModelo modeloAux;
	public MiModelo modeloAux_1;
	public MiModelo modeloAux_2;
	public MiModelo modeloAux_3;
	public MiModelo modeloAux_4;
	public MiModelo modeloAux_5;
	public final String[] columnas = {"Id: ", "Nombre: "};
	public final String[] columnas_1 = {"Nombre: ", "Cantidad: ", "Faltante: "};
	public final String[] columnas_2 = {"Id: ", "Nombre: ", "Acopio: ", "Posicion PR: "};
	public final String[] columnas_3 = {"Id: ", "Marca: ", "Linea: ", "Capacidad: "};
	public final String[] columnas_4 = {"Id: ", "Duracion: ", "Distancia: ", "Capacidad: ", "Combinacion: "};
	public final String[] columnas_5 = {"Peso: " , "Beneficio: "};
	private JTable tableFlujoMax;
	private JTable table_5;
	Boolean control = true;
	
	
	public PanelPARTE05(BaseDeDatos unaBD) {
		setLayout(null);
		setSize(770, 540);
		inicializarPlanta(unaBD.listaPlantas);
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		
		Object obj[] = null;
		for (int i = 0; i < unaBD.listaPlantas.size(); i++) {
		modeloAux.addRow(obj);
		Planta getC = unaBD.listaPlantas.get(i);
		modeloAux.setValueAt(getC.getId(), i, 0);
		modeloAux.setValueAt(getC.getNombre_planta(), i, 1);
		}
		
		
		JLabel lblFlujoMaximo = new JLabel("Flujo Maximo:");
		lblFlujoMaximo.setBounds(190, 11, 110, 14);
		add(lblFlujoMaximo);
		
		JLabel lblPageRank = new JLabel("Page Rank:");
		lblPageRank.setBounds(10, 41, 64, 14);
		add(lblPageRank);
		
		JLabel lblInsumoFaltante = new JLabel("Lista Plantas:");
		lblInsumoFaltante.setBounds(10, 139, 110, 14);
		add(lblInsumoFaltante);
		
		JLabel lblListaCamionesDisponibles = new JLabel("Lista Camiones Disponibles:");
		lblListaCamionesDisponibles.setBounds(10, 310, 180, 15);
		add(lblListaCamionesDisponibles);
		
///////////////////////////////////////////////////////////////////////////////////////////////		
		
		JButton btnMostrarSolucion = new JButton("Mostrar Solucion");
		btnMostrarSolucion.setBounds(10, 465, 140, 23);
		add(btnMostrarSolucion);
		btnMostrarSolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double capacidad = 0.0;
				if (table_3.getSelectedRow() != -1) {
					capacidad =  (Double) modeloAux_3.getValueAt(table_3.getSelectedRow(), 3);
					System.out.println("Capacidad soportada " +capacidad +" KG");
				}
				
					Magica magica = new Magica();
					Vertice<Planta> v1aux = unaBD.grafo.vertices.get(0);
					Vertice<Planta> v2aux = unaBD.grafo.vertices.get(1);			
					List<InsumoFaltante> lista_insumoCant = new ArrayList<>();
					
					for(Auxiliar<Planta> aux5 : magica.filtrarPlantaConSusInsumosCant(unaBD.listaInsumos, unaBD.listaStockInsumo, unaBD.grafo.vertices)){
						
						for(InsumoCant inscant : aux5.insumocant) {
							int cant = inscant.cantidad;
							double benef = inscant.faltante * inscant.insumo.costo;
							int idInsumo = inscant.insumo.idinsumo;
							int idPlanta = aux5.planta.idplanta;
							
							InsumoFaltante var = new InsumoFaltante(cant, benef, idInsumo, idPlanta);
							lista_insumoCant.add(var);
							}			
					}
				Double pesoSoportado = 0.0;
				for(InsumoFaltante unInsumoCant : lista_insumoCant) {
					pesoSoportado = pesoSoportado + unInsumoCant.peso;
				}
				int tamaño = lista_insumoCant.size();
				InsumoFaltante[] listaFinal = new InsumoFaltante[tamaño];
				for(int i = 0; i<lista_insumoCant.size(); i++) {
					InsumoFaltante aux = new InsumoFaltante();
					aux = lista_insumoCant.get(i);
					listaFinal[i] = aux;
				}	
				
				Double pesoCarga = 0.0;
				if(capacidad == 0.0) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				} else {
				if(pesoSoportado<=capacidad) {
					pesoCarga = pesoSoportado;
				} else {
					pesoCarga = capacidad;
				}
				
				
				int tam = listaFinal.length;
				Cargamento base = new Cargamento(pesoCarga, tam);
				Cargamento opt = new Cargamento(pesoCarga, tam);
				
				magica.llenarCargamento(base, opt, listaFinal, false);
				
				inicializarPanelRecorrido(opt);
				}}});

////////////////////////////////////////////////////////////////////////////////////////////////		
	
		JButton btnMostrarFlujoMaximo = new JButton("Mostrar Flujo Maximo");
		btnMostrarFlujoMaximo.setBounds(10, 7, 157, 23);
		add(btnMostrarFlujoMaximo);
		btnMostrarFlujoMaximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Magica magica = new Magica();
				Vertice<Planta> v1aux = unaBD.grafo.vertices.get(0);
				Vertice<Planta> v2aux = unaBD.grafo.vertices.get(1);
				List<Recorrido> listaRecorridos = unaBD.grafo.armarRecorridos(unaBD.grafo.caminos(v1aux, v2aux));
			
				//tengo que mostrar el peso de unRecorrido
				Recorrido unRecorrido =  magica.mejorRecorridoPorPeso(unaBD.grafo.vertices, listaRecorridos, unaBD.grafo.aristas);
				
				inicializarRecorrido(unRecorrido);
				
			}
		});
		
//////////////////////////////////////////////////////////////////////////////////////////////
		
		
		JLabel lblInsumosFaltantes = new JLabel("Insumos faltantes:");
		lblInsumosFaltantes.setBounds(222, 139, 98, 14);
		add(lblInsumosFaltantes);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(10, 275, 89, 23);
		add(btnMostrar);
		

		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (table.getSelectedRow() != -1) {
					int id =  (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
					
					Magica magica = new Magica();
					
					List<Auxiliar<Planta>> listaAuxiliar = magica.filtrarPlantaConSusInsumosCant(unaBD.listaInsumos, unaBD.listaStockInsumo, unaBD.grafo.vertices);
					for(Auxiliar<Planta> aux : listaAuxiliar) {
						if(aux.planta.idplanta == id) {
							//idAux: es el id de la planta seleccionada
							List<InsumoCant> listaInsumoCant = aux.insumocant;	
									inicializarInsumoCant(listaInsumoCant);
									control = true;
									break;				}
												}
//					if(!control) {
//						JOptionPane.showMessageDialog(null, "La planta seleccionada no posee insumos faltantes", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
//					}
					} else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
						}
				}});
		
		
		

		////////////////////////////
		//lista plantas pagerank
		List<Planta> listaPlantasPR = unaBD.grafo.ordenarPlantasSegunPageRank(unaBD.grafo.vertices);
		inicializarPR(listaPlantasPR);
//		System.out.println(listaPlantasPR);
		//////////////////////////////
		inicializarCamiones(unaBD.listaCamiones);
		
		
		
		
		
	}
	
	
	public void inicializarPlanta(List<Planta> listaPlantas) {

		table = new JTable(mostrarElementosPlanta(listaPlantas));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 155, 200, 110);
		add(scrollPane);	
	}
	
	public MiModelo mostrarElementosPlanta(List<Planta> listaPlantas) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaPlantas.size(); i++) {
		modeloAux.addRow(obj);
		Planta getC = listaPlantas.get(i);
		modeloAux.setValueAt(getC.getId(), i, 0);
		modeloAux.setValueAt(getC.getNombre_planta(), i, 1);
		}
		return modeloAux;
	}
	
	public void inicializarInsumoCant(List<InsumoCant> listaInsumoCant){

		table_1 = new JTable(mostrarElementosInsumoCant(listaInsumoCant));
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(230, 155, 500, 110);
		add(scrollPane_1);
		
	}
	
	public MiModelo mostrarElementosInsumoCant(List<InsumoCant> listaInsumoCant) {
		
		modeloAux_1 = new MiModelo();
		modeloAux_1.setColumnIdentifiers(columnas_1);
		Object obj[] = null;
		
		for (int i = 0; i < listaInsumoCant.size(); i++) {
		modeloAux_1.addRow(obj);
		InsumoCant getC = listaInsumoCant.get(i);
		modeloAux_1.setValueAt(getC.insumo.nombreInsumo, i, 0);
		modeloAux_1.setValueAt(getC.cantidad, i, 1);
		modeloAux_1.setValueAt(getC.faltante, i, 1);
		}
		return modeloAux_1;
		
		
	}

	public void inicializarPR(List<Planta> listaPlantasPR) {
		table_2 = new JTable(mostrarElementosPR(listaPlantasPR));
		JScrollPane scrollPane = new JScrollPane(table_2);
		scrollPane.setBounds(10, 60, 720, 70);
		add(scrollPane);
	}
	
	public MiModelo mostrarElementosPR(List<Planta> listaPlantasPR) {
		modeloAux_2 = new MiModelo();
		modeloAux_2.setColumnIdentifiers(columnas_2);
		Object obj[] = null;
		
		for (int i = 0; i < listaPlantasPR.size(); i++) {
		modeloAux_2.addRow(obj);
		Planta getC = listaPlantasPR.get(i);
		modeloAux_2.setValueAt(getC.getId(), i, 0);
		modeloAux_2.setValueAt(getC.getNombre_planta(), i, 1);
		modeloAux_2.setValueAt(getC.esAcopio, i, 2);
		modeloAux_2.setValueAt(i, i, 3);
		}
		return modeloAux_2;
	}
	
	public void inicializarCamiones(List<Camion> listaCamiones) {

		table_3 = new JTable(mostrarElementosCamiones(listaCamiones));
		JScrollPane scrollPaneCamiones = new JScrollPane(table_3);
		scrollPaneCamiones.setBounds(10, 335, 720, 110);
		add(scrollPaneCamiones);	
		
		JLabel lblParteN = new JLabel("PARTE N\u00BA 5");
		lblParteN.setForeground(Color.BLUE);
		lblParteN.setBounds(670, 515, 100, 15);
		add(lblParteN);
		


	}
	
	public MiModelo mostrarElementosCamiones(List<Camion> listaCamiones) {
		modeloAux_3 = new MiModelo();
		modeloAux_3.setColumnIdentifiers(columnas_3);
		Object obj[] = null;
		
		for (int i = 0; i < listaCamiones.size(); i++) {
			modeloAux_3.addRow(obj);
		Camion getC = listaCamiones.get(i);
		modeloAux_3.setValueAt(getC.getId(), i, 0);
		modeloAux_3.setValueAt(getC.getMarca(), i, 1);
		modeloAux_3.setValueAt(getC.linea, i, 2);
		modeloAux_3.setValueAt(getC.getCapacidad(), i, 3);
		}
		return modeloAux_3;
	}

	
	public void inicializarRecorrido(Recorrido rec) {
		tableFlujoMax = new JTable(mostrarRecorrido(rec));
		
		TableColumn columna = tableFlujoMax.getColumn("Id: ");
		columna.setMaxWidth(30);
		TableColumn columna1 = tableFlujoMax.getColumn("Duracion: ");
		columna1.setMaxWidth(60);
		TableColumn columna2 = tableFlujoMax.getColumn("Distancia: ");
		columna2.setMaxWidth(60);
		TableColumn columna3 = tableFlujoMax.getColumn("Capacidad: ");
		columna3.setMaxWidth(60);
//		TableColumn columna4 = tableFlujoMax.getColumn("Combinacion: ");
//		columna4.setMaxWidth(100);
		
		JScrollPane unScroll = new JScrollPane(tableFlujoMax);
		unScroll.setBounds(270, 8, 500, 45);
		add(unScroll);
	}
	public MiModelo mostrarRecorrido(Recorrido unRec) {
		modeloAux_4 = new MiModelo();
		modeloAux_4.setColumnIdentifiers(columnas_4);
		Object obj[] = null;
		modeloAux_4.addRow(obj);
		modeloAux_4.setValueAt(unRec.id_recorrido,0,0);
		modeloAux_4.setValueAt(unRec.duracion_tiempo,0,1);
		modeloAux_4.setValueAt(unRec.duracion_km,0,2);
		modeloAux_4.setValueAt(unRec.pesoSoportado,0,3);
		modeloAux_4.setValueAt(unRec.recorrido,0,4);
		return modeloAux_4;
	}
	
	public void inicializarPanelRecorrido(Cargamento opt) {
		
		table_5 = new JTable(mostrarElementosPanelRecorrido(opt));
		JScrollPane scrollPaneRecorrido = new JScrollPane(table_5);
		scrollPaneRecorrido.setBounds(165, 465, 520, 40);
		add(scrollPaneRecorrido);
		
	}
	public MiModelo mostrarElementosPanelRecorrido(Cargamento opt) {
		
		modeloAux_5 = new MiModelo();
		modeloAux_5.setColumnIdentifiers(columnas_5);
		Object obj[] = null;
		modeloAux_5.addRow(obj);
		modeloAux_5.setValueAt(opt.pesoActual,0,0);
		modeloAux_5.setValueAt(opt.beneficio,0,1);
		return modeloAux_5;
		
	}
	
	
	
	
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}
	
	
	
}
