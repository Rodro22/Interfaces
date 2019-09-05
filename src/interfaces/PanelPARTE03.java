package interfaces;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import arbolesBinarios.ArbolBinario;
import auxiliar.MiModelo;
import baseDeDatos.BaseDeDatos;
import modelo.Insumo;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPARTE03 extends JPanel {
	private JTextField textNombre;
	private JTextField textId;
	public JTable table;
	public MiModelo modeloAux;
	public MiModelo modeloAux_1;
	private final String[] columnas = {"Id: ", "Nombre: ", "Costo: ", "Descripcion: ", "Posicion: "};
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public PanelPARTE03(List<Insumo> listaInsumos, BaseDeDatos unaBD ) {
		setSize(770, 540);
		inicializar(listaInsumos);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 11, 54, 14);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 45, 46, 14);
		
		textNombre = new JTextField();
		textNombre.setBounds(82, 8, 86, 20);
		textNombre.setColumns(10);
		
		textId = new JTextField();
		textId.setBounds(82, 42, 86, 20);
		textId.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textId.getText().length() != 0) && (textNombre.getText().length() != 0) ) {
				Insumo unInsumoAux = null;
				if((textNombre.getText().length() != 0) && (textId.getText().length() != 0)) {
					unInsumoAux = new Insumo(Integer.parseInt(textId.getText()), textNombre.getText());
					}
					Insumo buscar = buscarInsumo(unInsumoAux, listaInsumos);
					if(buscar.nombreInsumo.equalsIgnoreCase( (String)textNombre.getText())  ) {
						inicializarInsumo(buscar);
					}	else {
						JOptionPane.showMessageDialog(null, "El insumo no pertenece a la lista", "Accion del sistema", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnBuscar.setBounds(387, 7, 89, 23);
		
		JLabel lblListaInsumos = new JLabel("Lista insumos:");
		lblListaInsumos.setBounds(10, 99, 86, 14);
		
		JLabel lblMostrarPor = new JLabel("Mostrar por:");
		lblMostrarPor.setBounds(10, 267, 75, 14);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(20, 292, 65, 14);
		
		JLabel lblStock = new JLabel("Nombre: ");
		lblStock.setBounds(20, 334, 65, 14);
		
		JButton btnMinimo = new JButton("Ascendente");
		btnMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unaBD.armarArbolCosto(listaInsumos);
				ArbolBinario<Insumo> unArbol = unaBD.armarArbolCosto(listaInsumos);
				List<Insumo> unaListaInsumosCosto = unArbol.inOrden();
				inicializar(unaListaInsumosCosto);				
//				System.out.println(unaListaInsumosCosto);
			}
		});
		btnMinimo.setBounds(91, 288, 110, 23);
		
		JButton btnMaximo = new JButton("Descendente");
		btnMaximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unaBD.armarArbolCosto(listaInsumos);
				ArbolBinario<Insumo> unArbol = unaBD.armarArbolCosto(listaInsumos);
				List<Insumo> unaListaInsumosCosto = unArbol.inOrden();
				inicializar(reverse(unaListaInsumosCosto));				
//				System.out.println(reverse(unaListaInsumosCosto));
				
				
			}
		});
		btnMaximo.setBounds(230, 288, 110, 23);
		
		JButton btnAscendente = new JButton("Ascendente");
		btnAscendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unaBD.armarArbolNombre(listaInsumos);
				ArbolBinario<Insumo> unArbol = unaBD.armarArbolNombre(listaInsumos);
				List<Insumo> unaListaInsumosCosto = unArbol.inOrden();
				inicializar(unaListaInsumosCosto);				
//				System.out.println(unaListaInsumosCosto);
			}
		});
		btnAscendente.setBounds(91, 330, 110, 23);
		
		JButton btnDescendente = new JButton("Descendente");
		btnDescendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unaBD.armarArbolNombre(listaInsumos);
				ArbolBinario<Insumo> unArbol = unaBD.armarArbolNombre(listaInsumos);
				List<Insumo> unaListaInsumosCosto = unArbol.inOrden();
				inicializar(reverse(unaListaInsumosCosto));				
//				System.out.println(reverse(unaListaInsumosCosto));
			}
		});
		btnDescendente.setBounds(230, 330, 110, 23);
		setLayout(null);
		add(lblId);
		add(textId);
		add(lblListaInsumos);
		add(lblMostrarPor);
		add(lblCosto);
		add(btnMinimo);
		add(btnMaximo);
		add(lblStock);
		add(btnAscendente);
		add(btnDescendente);
		add(lblNombre);
		add(textNombre);
		add(btnBuscar);
		
		JLabel lblParteN = new JLabel("PARTE N\u00BA 03");
		lblParteN.setForeground(Color.BLUE);
		lblParteN.setBounds(670, 515, 100, 15);
		add(lblParteN);
		

		
		



	}
	
	public void inicializar(List<Insumo> listaInsumos) {

		table = new JTable(mostrarElementos2(listaInsumos));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 124, 669, 132);
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
			modeloAux.setValueAt(getC.costo, i, 2);
			modeloAux.setValueAt(getC.getDescripcion(), i, 3);
			modeloAux.setValueAt(i, i, 4);
		}
		return modeloAux;
	}
	
	
	public List<Insumo> reverse(List<Insumo> list) {
		if(list.size() > 1) { 
			Insumo value = list.remove(0);
			reverse(list); 
			list.add(value); } 
		return list; } 
	
	
	public Insumo buscarInsumo(Insumo unInsumo, List<Insumo> listaInsumos) {
		Insumo regresar = null;
		for(Insumo unInsumoAux : listaInsumos) {
			if(unInsumoAux.idinsumo == unInsumo.idinsumo) {
				regresar = unInsumoAux;
			}
		}
		return regresar;
		
	}
	
	public void inicializarInsumo(Insumo unInsumo) {
		
		table_1 = new JTable(mostrarInsumo(unInsumo));
		JScrollPane scrollPaneInsumo = new JScrollPane(table_1);
		scrollPaneInsumo.setBounds(187, 45, 495, 45);
		add(scrollPaneInsumo);
		}
	public MiModelo mostrarInsumo(Insumo unInsumo) {
		
			modeloAux_1 = new MiModelo();
			modeloAux_1.setColumnIdentifiers(columnas);
			Object obj[] = null;
			

				modeloAux_1.addRow(obj);
				modeloAux_1.setValueAt(unInsumo.getId(), 0, 0);
				modeloAux_1.setValueAt(unInsumo.getNombre(), 0, 1);
				modeloAux_1.setValueAt(unInsumo.costo, 0, 2);
				modeloAux_1.setValueAt(unInsumo.getDescripcion(), 0, 3);
			
			return modeloAux_1;
		}
		
		
		
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(pantalla1.unaImagen)).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		
		
	}
	
	
	
	
	
	
}
