package interfacePrincipal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import grafo.*;
import modelo.*;
import baseDeDatos.BaseDeDatos;
import modelo.Camino;
import modelo.Camion;
import modelo.Insumo;
import modelo.Planta;
import modelo.Stock;
import modelo.StockInsumo;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;





public class pantalla1 extends JFrame{
	

	public JFrame frame;
	public DefaultTableModel modelo;
	public static String unaImagen = "/imagen/8AD.jpg";


	public static void main(String[] args) {
/*		
///////////////////////////////////////////////////////////////////////////////////
		List<Camion> listaCamiones = new ArrayList<Camion>();
		Camion c1 = new Camion(45, "Iveco", 2000.0);
		Camion c2 = new Camion(47, "Fiat", 2500.0);
		Camion c3 = new Camion(48, "Scania", 2400.0);
		listaCamiones.add(c1);
		listaCamiones.add(c2);
		listaCamiones.add(c3);
///////////////////////////////////////////////////////////////////////////////////
		List<Insumo> listaInsumos = new ArrayList<Insumo>();
		Insumo i1 = new Insumo(78, "Piedra","descrpcion", 500.0);
		Insumo i2 = new Insumo(77, "Arena", "descrpcion",800.0);
		Insumo i3 = new Insumo(71, "Cemento", "descrpcion",1000.0);
		Insumo i4 = new Insumo(73, "Cal", "descrpcion",300.0);
		Insumo i5 = new Insumo(76, "Merca","descrpcion", 300.0);
		Insumo i6 = new Insumo(70, "Blanca", "descrpcion",300.0);
		Insumo i7 = new Insumo(72, "De la buena", "descrpcion",300.0);
		Insumo i8 = new Insumo(79, "ATR", "descrpcion",300.0);
		Insumo i9 = new Insumo(75, "Puto el que lee", "descrpcion",300.0);
		listaInsumos.add(i1);
		listaInsumos.add(i2);
		listaInsumos.add(i3);
		listaInsumos.add(i4);
		listaInsumos.add(i5);
		listaInsumos.add(i6);
		listaInsumos.add(i7);
		listaInsumos.add(i8);
		listaInsumos.add(i9);
///////////////////////////////////////////////////////////////////////////////////
		List<Insumo> lista1 = new ArrayList<Insumo>();
		lista1.add(i1);
		lista1.add(i2);
		lista1.add(i3);
		Stock s1 = new Stock(1,1, lista1);
		
		List<Insumo> lista2 = new ArrayList<Insumo>();
		lista2.add(i4);
		lista2.add(i5);
		lista2.add(i6);
		Stock s2 = new Stock(2,2, lista2);
		
		List<Insumo> lista3 = new ArrayList<Insumo>();
		lista3.add(i7);
		lista3.add(i8);
		lista3.add(i9);
		Stock s3 = new Stock(3,3, lista3);
		
		List<Insumo> lista4 = new ArrayList<Insumo>();
		lista4.add(i7);
		lista4.add(i1);
		lista4.add(i9);
		Stock s4 = new Stock(4,4, lista4);
		
		List<Insumo> lista5 = new ArrayList<Insumo>();
		lista5.add(i2);
		lista5.add(i8);
		lista5.add(i5);
		Stock s5 = new Stock(5,5, lista5);
		
		List<Insumo> lista6 = new ArrayList<Insumo>();
		lista6.add(i1);
		lista6.add(i8);
		lista6.add(i7);
		Stock s6 = new Stock(6,6, lista6);
///////////////////////////////////////////////////////////////////////////////////		
		List<Planta> listaPlantas = new ArrayList<Planta>();
		Planta p1 = new Planta(001, "planta 1", true, s1);
		Planta p2 = new Planta(002, "planta 2", true, s2);
		Planta p3 = new Planta(003, "planta 3", false, s3);
		Planta p4 = new Planta(004, "planta 4", false, s4);
		Planta p5 = new Planta(005, "planta 5", false, s5);
		Planta p6 = new Planta(006, "planta 6", false, s6);
		listaPlantas.add(p1);
		listaPlantas.add(p2);
		listaPlantas.add(p3);
		listaPlantas.add(p4);
		listaPlantas.add(p5);
		listaPlantas.add(p6);
/////////////////////////////////////////////////////////////////////////////////////
//		List<Camino> listaCaminos = new ArrayList<Camino>();
//		Camino ca1 = new Camino(001, p1, p2, 100.0, 70.0, 1000.0);
//		Camino ca2 = new Camino(002, p2, p3, 50.0, 30.0, 1200.0);
//		Camino ca3 = new Camino(003, p3, p1, 80.0, 45.0, 1500.0);
//		listaCaminos.add(ca1);
//		listaCaminos.add(ca2);
//		listaCaminos.add(ca3);
///////////////////////////////////////////////////////////////////////////////////		
		List<Camino> listaCaminos = new ArrayList<Camino>();
		Camino camino1 = new Camino(1,p1, p3, 20.0, 10.0,3000.0); //Ver el peso soportado(ultimo valor).
		Camino camino2 = new Camino(2,p1, p4, 25.0, 15.0,3000.0);
		Camino camino3 = new Camino(3,p1, p5, 20.0, 10.0,3000.0);
		
		Camino camino4 = new Camino(4,p3, p4, 5.0, 5.0,3000.0);
		Camino camino5 = new Camino(5,p3, p6, 20.0, 10.0,3000.0);
		
		Camino camino6 = new Camino(6,p4, p3, 15.0, 7.0,3000.0);
		Camino camino7 = new Camino(7,p4, p5, 5.0, 5.0,3000.0);
		Camino camino8 = new Camino(8, p4, p3, 5.0, 5.0,3000.0);
		
		Camino camino9 = new Camino(9, p5, p4, 5.0, 5.0,3000.0);
		Camino camino10 = new Camino(10,p5, p6, 25.0, 10.0,3000.0);
		
		Camino camino11 = new Camino(11,p6, p2, 10.0, 10.0,3000.0);
		
///////////////////////////////////////////////////////////////////////////////////		
*/

		
		Vertice<Planta> v1 = null;
		Vertice<Planta> v2 = null;
		
		BaseDeDatos BD = new BaseDeDatos();	
		
		for(Vertice<Planta> unVertice : BD.grafo.vertices) {
			if(unVertice.valor.idplanta == 1) {
				v1 = unVertice;
			}
			if(unVertice.valor.idplanta == 2) {
				v2 = unVertice;
			}
		}
		
			
		List<Recorrido> rec= new ArrayList<>();
		
		rec = BD.grafo.armarRecorridos(BD.grafo.caminos(v1,v2));
		
		
///////////////////////////////////////////////////////////////////////////////////
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla1 window = new pantalla1(BD.listaPlantas, BD.listaCaminos, BD.listaInsumos,BD.listaStockInsumo, BD);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

	
	
	
	}

	public pantalla1(List<Planta> listaPlanta, List<Camino> listaCaminos, List<Insumo> listaInsumos, List<StockInsumo> listaStockInsumo, BaseDeDatos unaBD ) {
		initialize(listaPlanta, listaCaminos, listaInsumos, listaStockInsumo, unaBD);
	}

	private void initialize(List<Planta> listaPlanta, List<Camino> listaCaminos, List<Insumo> listaInsumos, List<StockInsumo> listaStockInsumo, BaseDeDatos unaBD) {
		
		
		frame = new JFrame("Aplicacion DIED 2019");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		PanelINICIO inicio = new PanelINICIO();
		frame.add(inicio);
		frame.getContentPane().setLayout(null);
				
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////	MENUBAR    ///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
////////////////////////////////////////////////////////////////////////////////////////////		
		
		JMenu mnPlantas = new JMenu("Plantas");
		mnOpciones.add(mnPlantas);
		JMenuItem mntmGestionPlantas = new JMenuItem("Gestion Plantas");
		mnPlantas.add(mntmGestionPlantas);
		mntmGestionPlantas.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				PanelPlantaGestion panel = new PanelPlantaGestion(listaPlanta, frame, listaInsumos, listaStockInsumo, unaBD);
				  frame.setContentPane(panel);
				  frame.setVisible(true);  }			 });
			
////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenu mnCamiones = new JMenu("Camiones");
		mnOpciones.add(mnCamiones);
		JMenuItem mntmGESTIONCamion = new JMenuItem("Gestion Camiones");
		mnCamiones.add(mntmGESTIONCamion);
		mntmGESTIONCamion.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				PanelCAMIONGestion panelGESTION = new PanelCAMIONGestion(unaBD.listaCamiones);
				  frame.setContentPane(panelGESTION);
				  frame.setVisible(true);  }			 });
		
//////////////////////////////////////////////////////////////////////////////////////////////				
		
		JMenu mnCaminos = new JMenu("Caminos");
		mnOpciones.add(mnCaminos);
		JMenuItem mntmAgregarCaminos = new JMenuItem("Agregar Caminos");
		mnCaminos.add(mntmAgregarCaminos);
		mntmAgregarCaminos.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				PanelCaminoAgregar panelCaminoAgregar = new PanelCaminoAgregar(unaBD.listaCaminos, unaBD.listaPlantas, unaBD);
				  frame.setContentPane(panelCaminoAgregar);
				  frame.setVisible(true);  }			 });
		
		JMenuItem mntmGestionarCaminos = new JMenuItem("Gestionar Caminos");
		mnCaminos.add(mntmGestionarCaminos);
		mntmGestionarCaminos.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  PanelCaminoGestion panelCaminoGestion2 = new PanelCaminoGestion(unaBD.listaCaminos, unaBD.listaPlantas);
				  frame.setContentPane(panelCaminoGestion2);
				  frame.setVisible(true);  }			 });
		
//////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenu mnInsumos = new JMenu("Insumos");
		mnOpciones.add(mnInsumos);
		JMenuItem mntmGestionInsumos = new JMenuItem("Gestion Insumos");
		mnInsumos.add(mntmGestionInsumos);
		mntmGestionInsumos.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				PanelInsumoGestion panelGestion = new PanelInsumoGestion(unaBD.listaInsumos, unaBD.listaPlantas, unaBD.listaStockInsumo);
				  frame.setContentPane(panelGestion);
				  frame.setVisible(true);  }			 });
		
//////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenu mnParte03 = new JMenu("Parte 03");
		menuBar.add(mnParte03);
		JMenuItem Mostrar = new JMenuItem("Mostrar");
		Mostrar.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				PanelPARTE03 panel03 = new PanelPARTE03(unaBD.listaInsumos, unaBD);
				frame.setContentPane(panel03);
				frame.setVisible(true);
				}
		});
		mnParte03.add(Mostrar);
		
//////////////////////////////////////////////////////////////////////////////////////////////
		JMenu mnParte04 = new JMenu("Parte 04");
		menuBar.add(mnParte04);
		
		JMenuItem MostrarA = new JMenuItem("Mostrar Parte A");
		MostrarA.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				PanelPARTE04A panel04A = new PanelPARTE04A(unaBD.listaPlantas, unaBD.listaInsumos, unaBD.listaCaminos, unaBD);
				frame.setContentPane(panel04A);
				frame.setVisible(true);
				}
		});
		mnParte04.add(MostrarA);
		
		JMenuItem MostrarB = new JMenuItem("Mostrar Parte B");
		MostrarB.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				PanelPARTE04B panel04B = new PanelPARTE04B(unaBD);
				frame.setContentPane(panel04B);
				frame.setVisible(true);
				}
		});
		mnParte04.add(MostrarB);
		
////////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenu mnParte05 = new JMenu("Parte 05");
		menuBar.add(mnParte05);
		JMenuItem parte05 = new JMenuItem("Mostrar");
		parte05.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				PanelPARTE05 panel05 = new PanelPARTE05(unaBD);
				frame.setContentPane(panel05);
				frame.setVisible(true);
				}
		});
		mnParte05.add(parte05);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////    FONDOS     ///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JMenu fondo = new JMenu("Fondo");
		menuBar.add(fondo);
		
		JMenuItem fondoTuerca = new JMenuItem("Inicio");
		fondoTuerca.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				 unaImagen = "/imagen/8AD.jpg";
				 PanelINICIO inicio = new PanelINICIO();
				 frame.setContentPane(inicio);
				 frame.setVisible(true);
				
			}});
		fondo.add(fondoTuerca);
		
		JMenuItem fondoInvierno = new JMenuItem("Winter is Commit");
		fondoInvierno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 unaImagen = "/imagen/9C9.jpg";
				 PanelINICIO inicio = new PanelINICIO();
				 frame.setContentPane(inicio);
				 frame.setVisible(true);
				
				
			}});
		fondo.add(fondoInvierno);
		
		JMenuItem fondoIlluminati = new JMenuItem("Illuminati");
		fondoIlluminati.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 unaImagen = "/imagen/472.jpg";
				 PanelINICIO inicio = new PanelINICIO();
				 frame.setContentPane(inicio);
				 frame.setVisible(true);
				
				
			}});
		fondo.add(fondoIlluminati);
		
		JMenuItem fondoAbstracto = new JMenuItem("Abstracto");
		fondoAbstracto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 unaImagen = "/imagen/9CB.jpg";
				 PanelINICIO inicio = new PanelINICIO();
				 frame.setContentPane(inicio);
				 frame.setVisible(true);
			}});
		fondo.add(fondoAbstracto);
		
		JMenuItem fondoPuente = new JMenuItem("Puente");
		fondoPuente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 unaImagen = "/imagen/AndresMC54 (5).jpeg";
				 PanelINICIO inicio = new PanelINICIO();
				 frame.setContentPane(inicio);
				 frame.setVisible(true);
				
				
			}});
		fondo.add(fondoPuente);
		
		}
	
////////////////////////////////////////////////////////////////////////////////////////////	

}
