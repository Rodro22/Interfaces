package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import auxiliar.InsumoCant;
import auxiliar.MiModelo;
import baseDeDatos.BaseDeDatos;
import grafo.Arista;
import grafo.Vertice;
import modelo.Insumo;
import modelo.Planta;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class PanelPlantaAuxModificar extends JPanel {
	private JTextField testId;
	private JTextField testNombre;
	private JTextField textCantMax;
	private JTextField textCantInicial;
	private JTable table;
	public MiModelo modeloAux;
	public MiModelo modeloAux_1;
	private final String[] columnas = {"Id: ", "Nombre: ", "Costo: ", "Descripcion: ", "Posicion: "};
	private JTable table_1;
	
	public Boolean control = false;
	public int idPlantaModificar = 0;
	
	
	public PanelPlantaAuxModificar(BaseDeDatos unaBD, Planta unaPlanta) {
		setLayout(null);
		setSize(770, 540);
		
		inicializarInsumos(unaBD.listaInsumos);
		
		for(Planta plantaAux : unaBD.listaPlantas) {
			if(plantaAux.idplanta == unaPlanta.idplanta) {
				unaPlanta.setUnStock(plantaAux.unStock);
			}
		}
		List<Insumo> listaInsumoPlantaSeleccionada = new ArrayList<Insumo>();
		for(Insumo insumoAux : unaPlanta.unStock.lista_insumo) {
			listaInsumoPlantaSeleccionada.add(insumoAux);
		}

		inicializarInsumosPlanta(listaInsumoPlantaSeleccionada);
		
		
		
/////////////////////////////////////////////////////////////////////////////////		
		
		JLabel label = new JLabel("Nombre: ");
		label.setBounds(20, 14, 69, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Id: ");
		label_1.setBounds(20, 50, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Acopio: ");
		label_2.setBounds(21, 81, 46, 14);
		add(label_2);
		
		testId = new JTextField();
		testId.setColumns(10);
		testId.setBounds(100, 50, 214, 20);
		add(testId);
		
		testNombre = new JTextField();
		testNombre.setToolTipText("");
		testNombre.setColumns(10);
		testNombre.setBounds(100, 11, 214, 20);
		add(testNombre);
		
		JRadioButton rdbAcopio = new JRadioButton("Seleccionar");
		rdbAcopio.setBounds(140, 77, 109, 23);
		add(rdbAcopio);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textCantMax.getText().length() != 0) && (textCantInicial.getText().length() != 0)) { 
					if(table.getSelectedRow() != -1) {
	        	 	
						Integer id = (int) modeloAux.getValueAt(table.getSelectedRow(), 0);
						String nombre = (String) modeloAux.getValueAt(table.getSelectedRow(), 1);
						Double costo = (Double) modeloAux.getValueAt(table.getSelectedRow(), 2);
						String descripcion = (String) modeloAux.getValueAt(table.getSelectedRow(), 3);        	 	
						Insumo agregar = new Insumo (id, nombre, descripcion, costo);
					
					if(control) {
						//Si modifique la planta trabajo sobre el elemento que le pase
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == idPlantaModificar) {
								plantaAux.unStock.lista_insumo.add(agregar);
							}
						}
						
						//////
						List<Insumo> listaInsumoPlanta = new ArrayList<Insumo>();
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == idPlantaModificar) {
								listaInsumoPlanta.addAll(plantaAux.unStock.lista_insumo);
							}
						}

						inicializarInsumoAgregado(listaInsumoPlanta);
						//////
						
						InsumoCant unInsumo = new InsumoCant(agregar, Integer.parseInt( textCantMax.getText() ), Integer.parseInt( textCantInicial.getText() ) );
						//No tenemos una lista con los elementos InsumoCant
						//No tenemos una lista con los elementos Auxiliar
						//Solo puedo llegar hasta esto con los elementos que tengo
						
					}
					else if (!control) {
						//Si no modifique la planta trabajo sobre el elemento que le pase
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == unaPlanta.idplanta) {
								plantaAux.unStock.lista_insumo.add(agregar);
							}
						}
						//////
						List<Insumo> listaInsumoPlanta = new ArrayList<Insumo>();
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == unaPlanta.idplanta) {
								listaInsumoPlanta.addAll(plantaAux.unStock.lista_insumo);
							}
						}

						inicializarInsumoAgregado(listaInsumoPlanta);
						//////
						
						InsumoCant unInsumo = new InsumoCant(agregar, Integer.parseInt( textCantMax.getText() ), Integer.parseInt( textCantInicial.getText() ) );
						//No tenemos una lista con los elementos InsumoCant
						//No tenemos una lista con los elementos Auxiliar
						//Solo puedo llegar hasta esto con los elementos que tengo
					
					
					
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un insumo de la lista", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
				} else {
					
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAgregar.setBounds(396, 310, 89, 23);
		add(btnAgregar);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if((testId.getText().length() != 0) && (testNombre.getText().length() != 0)) { 
					
					int idPlanta = Integer.parseInt(testId.getText());
					int posicion = obtenerPosicion(unaBD.listaPlantas, unaPlanta);
					unaBD.listaPlantas.get(posicion).setEsAcopio(rdbAcopio.isSelected());
					unaBD.listaPlantas.get(posicion).setId(Integer.parseInt(testId.getText()));
					unaBD.listaPlantas.get(posicion).setNombre(testNombre.getText());
					
					Planta plantaNueva = unaBD.listaPlantas.get(posicion);
					//////////// PARTE DEL GRAFO //////////////////////////
					Vertice<Planta> unVertice = new Vertice(plantaNueva);
					System.out.println("Inicio de modificacion de vertices: " +unaBD.grafo.vertices);
					unaBD.grafo.vertices.remove(posicion);
					unaBD.grafo.vertices.add(posicion, unVertice);
					System.out.println("Fin de la modificacion de vertices: "+unaBD.grafo.vertices);
					System.out.println("---------------");
					
					System.out.println("Inicio de la modificacion de aristas" + unaBD.grafo.aristas);
					for(Arista<Planta> aristaAux : unaBD.grafo.aristas) {
						if(aristaAux.inicio.valor.idplanta == idPlanta) {
							aristaAux.inicio.valor.idplanta = plantaNueva.idplanta;
							aristaAux.inicio.valor.esAcopio = plantaNueva.esAcopio;
							aristaAux.inicio.valor.nombre_planta = plantaNueva.nombre_planta;
						} else if(aristaAux.fin.valor.idplanta == idPlanta) {
							aristaAux.fin.valor.idplanta = plantaNueva.idplanta;
							aristaAux.fin.valor.esAcopio = plantaNueva.esAcopio;
							aristaAux.fin.valor.nombre_planta = plantaNueva.nombre_planta;
						} 
					}
					System.out.println("Fin de la modificacion de aristas" + unaBD.grafo.aristas);
					
					///////////////////////////////////////////////////
					control = true;
					idPlantaModificar = plantaNueva.idplanta;
							
					List<Insumo> listaInsumoPlanta = new ArrayList<Insumo>();
					for(Insumo insumoAux : plantaNueva.unStock.lista_insumo) {
						listaInsumoPlanta.add(insumoAux);
					}
					inicializarInsumosPlanta(listaInsumoPlanta);
					JOptionPane.showMessageDialog(null, "Planta modificada", "Accion del sistema", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setBounds(396, 27, 120, 23);
		add(btnModificar);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_1.getSelectedRow() != -1) {
	        	 	
					Integer id = (int) modeloAux.getValueAt(table_1.getSelectedRow(), 0);
					String nombre = (String) modeloAux.getValueAt(table_1.getSelectedRow(), 1);
					Double costo = (Double) modeloAux.getValueAt(table_1.getSelectedRow(), 2);
					String descripcion = (String) modeloAux.getValueAt(table_1.getSelectedRow(), 3);        	 	
					Insumo agregar = new Insumo (id, nombre, descripcion, costo);
				
					if(control) {
						//Si modifique la planta trabajo sobre el elemento que le pase
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == idPlantaModificar) {
								plantaAux.unStock.lista_insumo.remove(agregar);
							}
						}
						
						//////
						List<Insumo> listaInsumoPlanta = new ArrayList<Insumo>();
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == idPlantaModificar) {
								listaInsumoPlanta.addAll(plantaAux.unStock.lista_insumo);
							}
						}

						inicializarInsumoAgregado(listaInsumoPlanta);
						
						InsumoCant unInsumo = new InsumoCant(agregar, Integer.parseInt( textCantMax.getText() ), Integer.parseInt( textCantInicial.getText() ) );

						
					}
					else if (!control) {
						//Si no modifique la planta trabajo sobre el elemento que le pase
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == unaPlanta.idplanta) {
								plantaAux.unStock.lista_insumo.remove(agregar);
							}
						}
						//////
						List<Insumo> listaInsumoPlanta = new ArrayList<Insumo>();
						for(Planta plantaAux : unaBD.listaPlantas) {
							if(plantaAux.idplanta == unaPlanta.idplanta) {
								listaInsumoPlanta.addAll(plantaAux.unStock.lista_insumo);
							}
						}

						inicializarInsumoAgregado(listaInsumoPlanta);
						
						
					
					
					
					}
				}	else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un insumo de la lista", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBorrar.setBounds(20, 493, 89, 23);
		add(btnBorrar);


////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel label_3 = new JLabel("Seleccione Insumo:");
		label_3.setBounds(21, 116, 149, 28);
		add(label_3);
		
		JLabel label_4 = new JLabel("Ingrese Cantidad Maxima: ");
		label_4.setBounds(36, 283, 160, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Ingrese Cantidad Inicial: ");
		label_5.setBounds(36, 314, 142, 14);
		add(label_5);
		
		textCantMax = new JTextField();
		textCantMax.setColumns(10);
		textCantMax.setBounds(231, 280, 120, 20);
		add(textCantMax);
		
		textCantInicial = new JTextField();
		textCantInicial.setColumns(10);
		textCantInicial.setBounds(231, 311, 120, 20);
		add(textCantInicial);
		
		
		JLabel lblModificarPlanta = new JLabel("Modificar Planta");
		lblModificarPlanta.setForeground(Color.BLUE);
		lblModificarPlanta.setBounds(670, 515, 100, 15);
		add(lblModificarPlanta);
		
	
		
		JLabel lblInsumosQuePosee = new JLabel("Insumos que posee la planta:");
		lblInsumosQuePosee.setBounds(20, 345, 175, 15);
		add(lblInsumosQuePosee);
		

	}
	public void inicializarInsumos(List<Insumo> listaInsumos) {

		table = new JTable(mostrarElementosInsumos(listaInsumos));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 145, 700, 125);
		add(scrollPane);
		
	}
	
	public DefaultTableModel mostrarElementosInsumos(List<Insumo> listaInsumos) {
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
	
	public void inicializarInsumosPlanta(List<Insumo> listaInsumosAuxiliar) {
		table_1 = new JTable(mostrarElementosInsumosPlanta(listaInsumosAuxiliar));
		JScrollPane scrollPanePlanta = new JScrollPane(table_1);
		scrollPanePlanta.setBounds(20, 370, 700, 115);
		add(scrollPanePlanta);
	}
	public DefaultTableModel mostrarElementosInsumosPlanta(List<Insumo> listaInsumos) {
		modeloAux_1 = new MiModelo();
		modeloAux_1.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < listaInsumos.size(); i++) {
			modeloAux_1.addRow(obj);
			Insumo getC = listaInsumos.get(i);
			modeloAux_1.setValueAt(getC.getId(), i, 0);
			modeloAux_1.setValueAt(getC.getNombre(), i, 1);
			modeloAux_1.setValueAt(getC.costo, i, 2);
			modeloAux_1.setValueAt(getC.getDescripcion(), i, 3);
			modeloAux_1.setValueAt(i, i, 4);
		}
		return modeloAux_1;
	}
	
	public int obtenerPosicion(List<Planta> lista, Planta aux) {
		
		for(int i = 0; i<lista.size() ; i++) {
			if(lista.get(i).idplanta == aux.idplanta) {
				return i;
			}
		}
		return 0;
	}
	
	
	public void inicializarInsumoAgregado(List<Insumo> listaInsumos) {
		table_1 = new JTable(mostrarElementosInsumosPlanta(listaInsumos));
		JScrollPane scrollPanePlanta = new JScrollPane(table_1);
		scrollPanePlanta.setBounds(20, 370, 700, 115);
		add(scrollPanePlanta);
		
		
	}
	
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}
}
