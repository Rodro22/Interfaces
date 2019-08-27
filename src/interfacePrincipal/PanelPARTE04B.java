package interfacePrincipal;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import auxiliar.MiModelo;
import baseDeDatos.BaseDeDatos;
import grafo.Arista;
import grafo.Vertice;
import modelo.Camion;
import modelo.Planta;
import modelo.Recorrido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelPARTE04B extends JPanel {

	private JTable table, unatable, unatable_2;
	public MiModelo modeloAux;
	private final String[] columnas = {"Id: ", "Nombre: ", "Posicion: "};
	private final String[] columnasRecorrido = {"Id: ", "Tiempo: ", "Km: ", "Peso Max: ", "Recorrido: "};
	public Planta plantaInicial;
	public Planta plantaFinal;
	public int p1, p2;
	Boolean control1 = false;
	Boolean control2 = false;
	
	public PanelPARTE04B(BaseDeDatos unaBD) {
		setLayout(null);
		setSize(770, 540);
		
		inicioFrame(unaBD);

		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnas);
		Object obj[] = null;
		
		for (int i = 0; i < unaBD.listaPlantas.size(); i++) {
		modeloAux.addRow(obj);
		Planta getC = unaBD.listaPlantas.get(i);
		modeloAux.setValueAt(getC.getId(), i, 0);
		modeloAux.setValueAt(getC.getNombre_planta(), i, 1);		
		modeloAux.setValueAt(i, i, 2);
		}
		
		
		


	}
	
	public void inicializar(List<Planta> listaPlantas) {

		table = new JTable(mostrarElementos2(listaPlantas));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 25, 500, 70);
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
		modeloAux.setValueAt(i, i, 2);
		}
		return modeloAux;
	}
	
	public void inicioFrame(BaseDeDatos unaBD) {
		
		JInternalFrame internalFrame = new JInternalFrame("Seleccione planta INICIAL");
		internalFrame.getContentPane().setLayout(null);
		JTable unatable = new JTable(mostrarElementos2(unaBD.listaPlantas));
		JScrollPane scrollPane = new JScrollPane(unatable);
		scrollPane.setBounds(0, 0, 680, 130);
		internalFrame.getContentPane().add(scrollPane);
		internalFrame.setBounds(0, 0, 700, 200);
		
		JButton btnSeleccionar1 = new JButton("Seleccionar 1");
		
		btnSeleccionar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unatable.getSelectedRow() != -1 ) {
					int x = (int) modeloAux.getValueAt(unatable.getSelectedRow(), 2);
					plantaInicial = unaBD.listaPlantas.get(x);
					
					JOptionPane.showMessageDialog(null, "Planta seleccionada: "+ unaBD.listaPlantas.get(x));
					p1 = unaBD.listaPlantas.get(x).idplanta;
					control1 = true;
				}
				internalFrame.setVisible(false);
				finalFrame(unaBD.listaPlantas);
				System.out.println(plantaInicial);
			}
		});
		btnSeleccionar1.setBounds(10, 145, 120, 20);
		internalFrame.getContentPane().add(btnSeleccionar1);
		add(internalFrame);
		
		JButton btnMostrarRecorridos = new JButton("Mostrar Recorridos");
		btnMostrarRecorridos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(control1 && control2 ) {
				List<Recorrido> listaRecorridos= obtenerRecorridos(p1, p2, unaBD); 
				
				for(Recorrido auxR : listaRecorridos) {
					Double peso = peso_maximo(auxR, unaBD.grafo.aristas);
					auxR.pesoSoportado = peso;
				}
				
				inicializarRecorridos(listaRecorridos);
				System.out.println(listaRecorridos);
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar ambas opciones primero", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMostrarRecorridos.setBounds(10, 211, 150, 23);
		add(btnMostrarRecorridos);
		
		JLabel lblParteN = new JLabel("PARTE N\u00BA 4 \"B\"");
		lblParteN.setForeground(Color.BLUE);
		lblParteN.setBounds(670, 515, 100, 15);
		add(lblParteN);
		internalFrame.setVisible(true);
				
	}
	
	
	public void finalFrame(List<Planta> listaPlantas) {
		JInternalFrame internalFrame = new JInternalFrame("Seleccione planta FINAL");
		internalFrame.getContentPane().setLayout(null);
		JTable unatable_2 = new JTable(mostrarElementos2(listaPlantas));
		JScrollPane scrollPane = new JScrollPane(unatable_2);
		scrollPane.setBounds(0, 0, 680, 130);
		
		internalFrame.getContentPane().add(scrollPane);
		internalFrame.setBounds(0, 0, 700, 200);
		
		JButton btnSeleccionar2 = new JButton("Seleccionar 2");
		btnSeleccionar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unatable_2.getSelectedRow() != -1) {
					int x = (int) modeloAux.getValueAt(unatable_2.getSelectedRow(), 2);
					plantaFinal = listaPlantas.get(x);
					JOptionPane.showMessageDialog(null, "Planta seleccionada: "+ listaPlantas.get(x));
					p2 = listaPlantas.get(x).idplanta;
					control2 = true;
					}
				System.out.println(plantaFinal);
			}
		});
		btnSeleccionar2.setBounds(10, 145, 120, 20);
		
		internalFrame.getContentPane().add(btnSeleccionar2);
		add(internalFrame);
		internalFrame.setVisible(true);
		
		
				
	}
	
	public void inicializarRecorridos(List<Recorrido> listaRecorridos) {
		
		table = new JTable(mostrarRecorridos(listaRecorridos));
		
		TableColumn columna = table.getColumn("Id: ");
		columna.setMaxWidth(50);
		TableColumn columna1 = table.getColumn("Tiempo: ");
		columna1.setMaxWidth(60);
		TableColumn columna2 = table.getColumn("Km: ");
		columna2.setMaxWidth(50);
		TableColumn columna3 = table.getColumn("Peso Max: ");
		columna3.setMaxWidth(100);
//		TableColumn columna4 = table.getColumn("Recorrido: ");
//		columna4.setMaxWidth(200);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 245, 680, 250);
		scroll.setVisible(true);
		add(scroll);
			
	}
	public MiModelo mostrarRecorridos(List<Recorrido> listaRecorridos) {
		modeloAux = new MiModelo();
		modeloAux.setColumnIdentifiers(columnasRecorrido);
		
		Object obj[] = null;
		
		for (int i = 0; i < listaRecorridos.size(); i++) {
			modeloAux.addRow(obj);
			Recorrido getC = listaRecorridos.get(i);
			modeloAux.setValueAt(getC.id_recorrido, i, 0);
			modeloAux.setValueAt(getC.duracion_tiempo, i, 1);
			modeloAux.setValueAt(getC.duracion_km, i, 2);
			modeloAux.setValueAt(getC.pesoSoportado, i, 3);
			modeloAux.setValueAt(getC.recorrido, i, 4);
			
		}
		return modeloAux;
	}
	
	
	public List<Recorrido> obtenerRecorridos(int p1, int p2, BaseDeDatos bdAux){
	
			Vertice<Planta> v1 = null;
			Vertice<Planta> v2 = null;
				
			for(Vertice<Planta> unVertice : bdAux.grafo.vertices) {
				if(unVertice.valor.idplanta == p1) {
					v1 = unVertice;
				}
				if(unVertice.valor.idplanta == p2) {
					v2 = unVertice;
				}
			}
			List<Recorrido> rec= new ArrayList<>();
			rec = bdAux.grafo.armarRecorridos(bdAux.grafo.caminos(v1,v2));
			return rec;
			
	}
	
		
	public Double peso_maximo(Recorrido aux, List<Arista<Planta>> lista_aristas) {
		Double max = 10000000.0;
		Double pesoAux;
		for( int j = 0; j < (aux.recorrido.size() - 1) ; j++) {
			pesoAux = buscarPesoDeAristaEntre(aux.recorrido.get(j), aux.recorrido.get(j+1), lista_aristas);
			if(pesoAux < max) {
				max = pesoAux;
			}
		}
		
		
		return max;							
		}
	
    public Double buscarPesoDeAristaEntre(Vertice<Planta> v1, Vertice<Planta> v2, List<Arista<Planta>> lista_aristas){
    	for(Arista unaArista : lista_aristas) {
    		
    		if(unaArista.getInicio().equals(v1) && unaArista.getFin().equals(v2)) return unaArista.pesoMax;
    	}
    	return 0.0;
    }
	
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
	}
	
}
