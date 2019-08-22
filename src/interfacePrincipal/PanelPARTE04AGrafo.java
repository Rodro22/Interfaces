package interfacePrincipal;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import graficos.Circulo;
import graficos.Flecha;
import graficos.Lienzo;
import graficos.LienzoAux;
import grafo.Vertice;
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
	public PanelPARTE04AGrafo(List<Planta> listaPlantas, List<Camino> listaCaminos, List<Planta> listaPlantasParaCamino, List<Planta> plantasQueNecesitanInsumo, Boolean control) {

		Vector<Circulo> listaCirculos = new Vector<Circulo>();
		
		for(Planta auxP : listaPlantas) {
			Circulo unCirculo = new Circulo(auxP.getNombre());
			for(Planta auxPF : plantasQueNecesitanInsumo) {
				if(auxPF.idplanta == auxP.idplanta) {
					unCirculo.idInsumo = 1;
				}
			}
			listaCirculos.add(unCirculo);
		}
		
		List<Camino> caminosParaMostrar = new ArrayList<Camino>();
		
		for(Camino unCamino : listaCaminos){
			for(int j = 0; j<listaPlantasParaCamino.size()-1; j++) {
				if(unCamino.getPlanta_init().idplanta == listaPlantasParaCamino.get(j).idplanta) {
					if(unCamino.getPlanta_end().idplanta == listaPlantasParaCamino.get(j+1).idplanta) {
						caminosParaMostrar.add(unCamino);
					}
				}
			}
		}
//		System.out.println(caminosParaMostrar);
		
		
		
		
		listaCirculos.get(0).setX(50);
		listaCirculos.get(0).setY(160);
		
		listaCirculos.get(1).setX(670);
		listaCirculos.get(1).setY(160);
		
		listaCirculos.get(2).setX(250);
		listaCirculos.get(2).setY(30);
		
		listaCirculos.get(3).setX(250);
		listaCirculos.get(3).setY(160);
		
		listaCirculos.get(4).setX(250);
		listaCirculos.get(4).setY(260);
		
		listaCirculos.get(5).setX(500);
		listaCirculos.get(5).setY(160);
///////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////	
		
		
		
//		List<Flecha> listaFlechas = null;
//		Vector<Flecha> listaFlechas = new Vector<Flecha>();
//		for(Camino auxC : listaCaminos) {
//			Flecha unaFlecha = new Flecha(String.valueOf(auxC.getId()));
//			listaFlechas.add(unaFlecha);	
//		}
//		
		
		
		
		Vector<Flecha> listaFlechas = new Vector<Flecha>();
		for(Camino auxC : listaCaminos) {
			Flecha unaFlecha = new Flecha( auxC.getDistancia(), auxC.getDuracion(), auxC.getPeso_soportado(), 0);
			for(Camino caminoMostrar : caminosParaMostrar) {
				if(caminoMostrar.getId() == auxC.getId()) {
				unaFlecha.valorGuia = 1;	}
			}
			listaFlechas.add(unaFlecha);	
		}

//		System.out.println(listaFlechas);
		
		
		
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
		listaFlechas.get(10).setX1(670);
		listaFlechas.get(10).setY1(160);
		

		
		if(control == false) {
			add(new Lienzo(listaCirculos, listaFlechas));
			setVisible(true);
			} else if (control == true) {
				add(new LienzoAux(listaCirculos, listaFlechas));
				setVisible(true);
			}
		

	}
	
	
	
	
	
	
	
	
	

}
