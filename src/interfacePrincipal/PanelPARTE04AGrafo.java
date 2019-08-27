package interfacePrincipal;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import graficos.Circulo;
import graficos.Flecha;
import graficos.Lienzo;
import graficos.LienzoAux;
import grafo.Vertice;
import modelo.*;
import java.awt.Color;

public class PanelPARTE04AGrafo extends JInternalFrame {

	public PanelPARTE04AGrafo(List<Planta> listaPlantas, List<Camino> listaCaminos, List<Planta> listaPlantasParaCamino, List<Planta> plantasQueNecesitanInsumo, Boolean control) {
		getContentPane().setForeground(Color.WHITE);

		Vector<Circulo> listaCirculos = new Vector<Circulo>();
		
		for(Planta auxP : listaPlantas) {
			Circulo unCirculo = new Circulo(auxP.getNombre(), auxP.idplanta);
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
		
/////////////////////////////////////////////////////////////////////////////////////		
		ArrayList<Integer> comb1 = new ArrayList<Integer>();
		comb1.add(50);
		comb1.add(30);
		ArrayList<Integer> comb2 = new ArrayList<Integer>();
		comb2.add(50);
		comb2.add(150);
		ArrayList<Integer> comb3 = new ArrayList<Integer>();
		comb3.add(50);
		comb3.add(250);
		
		ArrayList<Integer> comb4 = new ArrayList<Integer>();
		comb4.add(250);
		comb4.add(30);
		ArrayList<Integer> comb5 = new ArrayList<Integer>();
		comb5.add(250);
		comb5.add(150);
		ArrayList<Integer> comb6 = new ArrayList<Integer>();
		comb6.add(250);
		comb6.add(250);
		
		ArrayList<Integer> comb7 = new ArrayList<Integer>();
		comb7.add(500);
		comb7.add(30);
		ArrayList<Integer> comb8 = new ArrayList<Integer>();
		comb8.add(500);
		comb8.add(150);
		ArrayList<Integer> comb9 = new ArrayList<Integer>();
		comb9.add(500);
		comb9.add(250);
		
		ArrayList<Integer> comb10 = new ArrayList<Integer>();
		comb10.add(670);
		comb10.add(30);
		ArrayList<Integer> comb11 = new ArrayList<Integer>();
		comb11.add(670);
		comb11.add(150);
		ArrayList<Integer> comb12 = new ArrayList<Integer>();
		comb12.add(670);
		comb12.add(250);
		
		List<ArrayList<Integer>> combinacionesPosibles = new ArrayList<ArrayList<Integer>>();
		
		combinacionesPosibles.add(comb1);
		combinacionesPosibles.add(comb2);
		combinacionesPosibles.add(comb3);
		combinacionesPosibles.add(comb4);
		combinacionesPosibles.add(comb5);
		combinacionesPosibles.add(comb6);
		combinacionesPosibles.add(comb7);
		combinacionesPosibles.add(comb8);
		combinacionesPosibles.add(comb9);
		combinacionesPosibles.add(comb10);
		combinacionesPosibles.add(comb11);
		combinacionesPosibles.add(comb12);
		
		
		

		

		int n = 12;
		
		for(Circulo unCirculo : listaCirculos) {
			Random aleatorio = new Random(System.currentTimeMillis());
			int intAletorio = aleatorio.nextInt(n);
						
				unCirculo.setX( combinacionesPosibles.get(intAletorio).get(0) );
				unCirculo.setY( combinacionesPosibles.get(intAletorio).get(1) );
				combinacionesPosibles.remove(intAletorio);
				n--;
			}
		
		
		
/////////////////////////////////////////////////////////////////////////////////////		
		
//		listaCirculos.get(0).setX(50);
//		listaCirculos.get(0).setY(160);
//		
//		listaCirculos.get(1).setX(670);
//		listaCirculos.get(1).setY(160);
//		
//		listaCirculos.get(2).setX(250);
//		listaCirculos.get(2).setY(30);
//		
//		listaCirculos.get(3).setX(250);
//		listaCirculos.get(3).setY(160);
//		
//		listaCirculos.get(4).setX(250);
//		listaCirculos.get(4).setY(260);
//		
//		listaCirculos.get(5).setX(500);
//		listaCirculos.get(5).setY(160);
		
		
///////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////	
		
		
		
//		List<Flecha> listaFlechas = null;
//		Vector<Flecha> listaFlechas = new Vector<Flecha>();
//		for(Camino auxC : listaCaminos) {
//			Flecha unaFlecha = new Flecha(String.valueOf(auxC.getId()));
//			listaFlechas.add(unaFlecha);	
//		}
//		
		
		
		//////// ESTE METODO ME AYUDA A PINTAR LA FLECHA  ////////
		Vector<Flecha> listaFlechas = new Vector<Flecha>();
		for(Camino auxC : listaCaminos) {
			Flecha unaFlecha = new Flecha( auxC.getDistancia(), auxC.getDuracion(), auxC.getPeso_soportado(), 0, auxC.getPlanta_init().idplanta, auxC.getPlanta_end().idplanta);
			
			for(Camino caminoMostrar : caminosParaMostrar) {
				if(caminoMostrar.getId() == auxC.getId()) {
				unaFlecha.valorGuia = 1;	}
			}
			
			listaFlechas.add(unaFlecha);	
		}

//		System.out.println(listaFlechas);
		
		for(Flecha unaFlecha : listaFlechas) {
			for(Circulo unCirculo : listaCirculos) {
				if(unaFlecha.idIni == unCirculo.idPlanta) {
					unaFlecha.setX2(unCirculo.getX());
					unaFlecha.setY2(unCirculo.getY());
				}
				if(unaFlecha.idFin == unCirculo.idPlanta) {
					unaFlecha.setX1(unCirculo.getX());
					unaFlecha.setY1(unCirculo.getY());
				}
			}
			
		}
		
//		listaFlechas.get(0).setX2(50);
//		listaFlechas.get(0).setY2(160);
//		listaFlechas.get(0).setX1(250);
//		listaFlechas.get(0).setY1(30);
//		
//		listaFlechas.get(1).setX2(50);
//		listaFlechas.get(1).setY2(160);
//		listaFlechas.get(1).setX1(250);
//		listaFlechas.get(1).setY1(160);
//		
//		listaFlechas.get(2).setX2(50);
//		listaFlechas.get(2).setY2(160);
//		listaFlechas.get(2).setX1(250);
//		listaFlechas.get(2).setY1(260);
//		
//		listaFlechas.get(3).setX2(250);
//		listaFlechas.get(3).setY2(30);
//		listaFlechas.get(3).setX1(250);
//		listaFlechas.get(3).setY1(160);
//		
//		listaFlechas.get(4).setX2(250);
//		listaFlechas.get(4).setY2(30);
//		listaFlechas.get(4).setX1(500);
//		listaFlechas.get(4).setY1(160);
//		
//		listaFlechas.get(5).setX2(250);
//		listaFlechas.get(5).setY2(160);
//		listaFlechas.get(5).setX1(250);
//		listaFlechas.get(5).setY1(30);
//		
//		listaFlechas.get(6).setX2(250);
//		listaFlechas.get(6).setY2(260);
//		listaFlechas.get(6).setX1(250);
//		listaFlechas.get(6).setY1(160);
//		
//		listaFlechas.get(7).setX2(250);
//		listaFlechas.get(7).setY2(160);
//		listaFlechas.get(7).setX1(500);
//		listaFlechas.get(7).setY1(160);
//		
//		listaFlechas.get(8).setX2(250);
//		listaFlechas.get(8).setY2(260);
//		listaFlechas.get(8).setX1(250);
//		listaFlechas.get(8).setY1(160);
//		
//		listaFlechas.get(9).setX2(250);
//		listaFlechas.get(9).setY2(260);
//		listaFlechas.get(9).setX1(500);
//		listaFlechas.get(9).setY1(160);
//		
//		listaFlechas.get(10).setX2(500);
//		listaFlechas.get(10).setY2(160);
//		listaFlechas.get(10).setX1(670);
//		listaFlechas.get(10).setY1(160);
//		

		
		if(control == false) {
			getContentPane().add(new Lienzo(listaCirculos, listaFlechas));
			setVisible(true);
			} else if (control == true) {
				getContentPane().add(new LienzoAux(listaCirculos, listaFlechas));
				setVisible(true);
			}
		

	}
	
	

	
	
	
	
	
	

}
