package interfacePrincipal;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import graficos.Circulo;
import graficos.Flecha;
import graficos.Lienzo;
import modelo.*;

public class PanelPARTE04AGrafo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PanelPARTE04AGrafo frame = new PanelPARTE04AGrafo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PanelPARTE04AGrafo(List<Planta> listaPlantas, List<Camino> listaCaminos) {
//		setBounds(100, 100, 500, 600);
//		
//		JInternalFrame ventana2 = new JInternalFrame("Dibujo");
//		ventana2.setSize(600, 600);
//		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ventana2.setVisible(true);
//		ventana.add(new Lienzo());
//		ventana.setSize(600, 600);
//		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ventana.setVisible(true);
		Vector<Circulo> listaCirculos = new Vector<Circulo>();
//		List<Circulo> listaCirculos = null;
		for(Planta auxP : listaPlantas) {
			Circulo unCirculo = new Circulo(auxP.getNombre());
			listaCirculos.add(unCirculo);
		}
		listaCirculos.get(0).setX(50);
		listaCirculos.get(0).setY(160);
		
		listaCirculos.get(1).setX(720);
		listaCirculos.get(1).setY(160);
		
		listaCirculos.get(2).setX(250);
		listaCirculos.get(2).setY(30);
		
		listaCirculos.get(3).setX(250);
		listaCirculos.get(3).setY(160);
		
		listaCirculos.get(4).setX(250);
		listaCirculos.get(4).setY(260);
		
		listaCirculos.get(5).setX(500);
		listaCirculos.get(5).setY(160);
		
//		List<Flecha> listaFlechas = null;
		Vector<Flecha> listaFlechas = new Vector<Flecha>();
		for(Camino auxC : listaCaminos) {
			Flecha unaFlecha = new Flecha(String.valueOf(auxC.getId()));
			listaFlechas.add(unaFlecha);	
		}
		
		listaFlechas.get(0).setX2(50);
		listaFlechas.get(0).setY2(160);
		listaFlechas.get(0).setX1(250);
		listaFlechas.get(0).setY1(30);
		
		listaFlechas.get(1).setX2(50);
		listaFlechas.get(1).setY2(160);
		listaFlechas.get(1).setX1(250);
		listaFlechas.get(1).setY1(160);
		
		listaFlechas.get(2).setX2(50);
		listaFlechas.get(2).setY2(160);
		listaFlechas.get(2).setX1(250);
		listaFlechas.get(2).setY1(260);
		
		listaFlechas.get(3).setX2(250);
		listaFlechas.get(3).setY2(30);
		listaFlechas.get(3).setX1(250);
		listaFlechas.get(3).setY1(160);
		
		listaFlechas.get(4).setX2(250);
		listaFlechas.get(4).setY2(30);
		listaFlechas.get(4).setX1(500);
		listaFlechas.get(4).setY1(160);
		
		listaFlechas.get(5).setX2(250);
		listaFlechas.get(5).setY2(160);
		listaFlechas.get(5).setX1(250);
		listaFlechas.get(5).setY1(30);
		
		listaFlechas.get(6).setX2(250);
		listaFlechas.get(6).setY2(260);
		listaFlechas.get(6).setX1(250);
		listaFlechas.get(6).setY1(160);
		
		listaFlechas.get(7).setX2(250);
		listaFlechas.get(7).setY2(160);
		listaFlechas.get(7).setX1(500);
		listaFlechas.get(7).setY1(160);
		
		listaFlechas.get(8).setX2(250);
		listaFlechas.get(8).setY2(260);
		listaFlechas.get(8).setX1(250);
		listaFlechas.get(8).setY1(160);
		
		listaFlechas.get(9).setX2(250);
		listaFlechas.get(9).setY2(260);
		listaFlechas.get(9).setX1(500);
		listaFlechas.get(9).setY1(160);
		
		listaFlechas.get(10).setX2(500);
		listaFlechas.get(10).setY2(160);
		listaFlechas.get(10).setX1(720);
		listaFlechas.get(10).setY1(160);
		

		
		
		
		
		//Con esto me aparece la venta con cosas ya creadas
		
		Circulo n1 = new Circulo(50, 50 , "p1",1);
		Circulo n2 = new Circulo(150, 150, "p2",2);
		Circulo n3 = new Circulo(300, 150, "p3",3);
		Vector<Circulo> lista = new Vector<Circulo>();
	
		
		lista.add(n1);
		lista.add(n2);
		lista.add(n3);

		Flecha e1 = new Flecha(50,50,150,150, "peso, distancia, duracion");
		Flecha e2 = new Flecha(150,150,300,150, "peso, distancia, duracion");
		Flecha e3 = new Flecha(300,150,50,50, "peso, distancia, duracion");
		Vector<Flecha> listaE = new Vector<Flecha>();
		listaE.add(e1);
		listaE.add(e2);
		listaE.add(e3);
		

	
		add(new Lienzo(listaCirculos, listaFlechas));
//		ventana.setSize(600, 600);
////		ventana.setLocationRelativeTo(null);
//		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);



	}

}
