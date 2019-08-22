package baseDeDatos;

import java.util.ArrayList;
import modelo.*;
import modelo.*;
import modelo.Camion;
import modelo.Insumo;
import modelo.Planta;
import modelo.Stock;
import modelo.StockInsumo;
import grafo.*;
import arbolesBinarios.*;

import java.util.List;

import auxiliar.*;

public class BaseDeDatos {
	
	public static List<Planta> listaPlantas;
	public static List<Insumo> listaInsumos;
	public static List<StockInsumo> listaStockInsumo;
	public static List<Camion> listaCamiones;
	public static List<Camino> listaCaminos;
	
	public static Grafo<Planta> grafo;
	
	public BaseDeDatos() {
		
		
		Insumo i1 = new Insumo(01,"INSUMO 1", 8.0, "Descripcion", "kg", false);
		Insumo i2 = new Insumo(02, "INSUMO 2", 12.0, "Descripcion", "kg", false);
		Insumo i3 = new Insumo(03, "INSUMO 3", 7.0, "Descripcion", "lts", false);
		Insumo i4 = new Insumo(04, "INSUMO 4", 1.0, "Descripcion", "kg", true);
		Insumo i5 = new Insumo(05, "INSUMO 5", 50.0, "Descripcion", "lts", true);
		
		//Ingresamos los insumos
		
		listaInsumos = new ArrayList<Insumo>();
		listaInsumos.add(i1);
		listaInsumos.add(i2);
		listaInsumos.add(i3);
		listaInsumos.add(i4);
		listaInsumos.add(i5);
		//--------------------------------------
		
		
		//Creamos los Stocks
		
		List<Insumo> l1 = new ArrayList<>();
		l1.add(i1);
		l1.add(i2);
		l1.add(i3);
		l1.add(i4);
		l1.add(i5);
		
		Stock s1 = new Stock(001, 1, l1 );//STOCK S1 DE PLANTA1 (P1)
		
		List<Insumo> l2 = new ArrayList<>();
		l2.add(i1);
		l2.add(i2);
		l2.add(i3);
		l2.add(i4);
		l2.add(i5);
		
		Stock s2 = new Stock(002, 2, l2 );//STOCK S2 DE PLANTA2 (P2)
		
		
		List<Insumo> l3 = new ArrayList<>();
		l3.add(i1);
		l3.add(i2);
		l3.add(i3);
		l3.add(i4);
		l3.add(i5);
		
		Stock s3 = new Stock(003, 3, l3 );//STOCK S3 DE PLANTA3 (P3)
		
		
		List<Insumo> l4 = new ArrayList<>();
		l4.add(i1);
		l4.add(i2);
		l4.add(i3);
		l4.add(i4);
		l4.add(i5);
		
		Stock s4 = new Stock(004, 4, l4 );//STOCK S3 DE PLANTA3 (P4)
		
		List<Insumo> l5 = new ArrayList<>();
		l5.add(i1);
		l5.add(i2);
		l5.add(i3);
		l5.add(i4);
		l5.add(i5);
		
		Stock s5 = new Stock(005, 5, l5 );//STOCK S5 DE PLANTA5 (P5)
		
		List<Insumo> l6 = new ArrayList<>();
		l6.add(i1);
		l6.add(i2);
		l6.add(i3);
		l6.add(i4);
		l6.add(i5);
		
		Stock s6 = new Stock(006, 6, l6 );//STOCK S5 DE PLANTA6 (P6)
		//----------------------------------------------------------
		
		
		//Creamos las plantas
		
		Planta p1 = new Planta(1, "Planta1", true, s1);
		Planta p2 = new Planta(2, "Planta2", true, s2);
		Planta p3 = new Planta(3, "Planta3", false, s3);
		Planta p4 = new Planta(4, "Planta4", false, s4);
		Planta p5 = new Planta(5, "Planta5", false, s5);
		Planta p6 = new Planta(6, "Planta6", false, s6);
		//----------------------------------------------------------
		
		
		
		listaPlantas = new ArrayList<Planta>();//LISTA DE PLANTAS
		listaPlantas.add(p1);
		listaPlantas.add(p2);
		listaPlantas.add(p3);
		listaPlantas.add(p4);
		listaPlantas.add(p5);
		listaPlantas.add(p6);
		//---------------------------------------------------------
		
		//Creamos StockInsumos
		/*
		StockInsumo SI11 = new StockInsumo(01, 001, 100, 100);
		StockInsumo SI12 = new StockInsumo(02, 001, 100, 100);
		StockInsumo SI13= new StockInsumo(03, 001, 100, 100);
		
		StockInsumo SI21 = new StockInsumo(01, 002, 100, 100);
		StockInsumo SI22 = new StockInsumo(02, 002, 100, 80);
		StockInsumo SI23 = new StockInsumo(03, 002, 100, 100);
		
		StockInsumo SI31 = new StockInsumo(01, 003, 100, 80);
		StockInsumo SI32 = new StockInsumo(02, 003, 100, 100);
		StockInsumo SI33 = new StockInsumo(03, 003, 100, 100);
		
		StockInsumo SI41 = new StockInsumo(01, 004, 100, 100);
		StockInsumo SI42 = new StockInsumo(02, 004, 100, 100);
		StockInsumo SI43 = new StockInsumo(03, 004, 100, 50);
		
		StockInsumo SI51 = new StockInsumo(01, 005, 100, 100);
		StockInsumo SI52 = new StockInsumo(02, 005, 100, 100);
		StockInsumo SI53 = new StockInsumo(03, 005, 100, 100);
		
		StockInsumo SI61 = new StockInsumo(01, 006, 100, 100);
		StockInsumo SI62 = new StockInsumo(02, 006, 100, 100);
		StockInsumo SI63 = new StockInsumo(03, 006, 100, 80);
		
		*/
		//-----------------------------------------------------
		//StockInsumo Nuevo
		
		StockInsumo SI11 = new StockInsumo(i1, s1, 100, 100);
		StockInsumo SI12 = new StockInsumo(i2, s1, 100, 100);
		StockInsumo SI13 = new StockInsumo(i3, s1, 100, 100);
		
		StockInsumo SI21 = new StockInsumo(i1, s2, 100, 100);
		StockInsumo SI22 = new StockInsumo(i2, s2, 100, 80);
		StockInsumo SI23 = new StockInsumo(i3, s2, 100, 100);
		
		StockInsumo SI31 = new StockInsumo(i1, s3, 100, 80);
		StockInsumo SI32 = new StockInsumo(i2, s3, 100, 100);
		StockInsumo SI33 = new StockInsumo(i3, s3, 100, 100);
		
		StockInsumo SI41 = new StockInsumo(i1, s4, 100, 100);
		StockInsumo SI42 = new StockInsumo(i2, s4, 100, 100);
		StockInsumo SI43 = new StockInsumo(i3, s4, 100, 50);
		
		StockInsumo SI51 = new StockInsumo(i1, s5, 100, 100);
		StockInsumo SI52 = new StockInsumo(i2, s5, 100, 100);
		StockInsumo SI53 = new StockInsumo(i3, s5, 100, 100);
		
		StockInsumo SI61 = new StockInsumo(i1, s6, 100, 100);
		StockInsumo SI62 = new StockInsumo(i2, s6, 100, 100);
		StockInsumo SI63 = new StockInsumo(i3, s6, 100, 80);
		
		
		//-----------------------------------------------------
		
		listaStockInsumo = new ArrayList<StockInsumo>();//LISTA DE PLANTAS
		listaStockInsumo.add(SI11);
		listaStockInsumo.add(SI12);
		listaStockInsumo.add(SI13);
		listaStockInsumo.add(SI21);
		listaStockInsumo.add(SI22);
		listaStockInsumo.add(SI23);
		listaStockInsumo.add(SI31);
		listaStockInsumo.add(SI32);
		listaStockInsumo.add(SI33);
		listaStockInsumo.add(SI41);
		listaStockInsumo.add(SI42);
		listaStockInsumo.add(SI43);
		listaStockInsumo.add(SI51);
		listaStockInsumo.add(SI52);
		listaStockInsumo.add(SI53);
		listaStockInsumo.add(SI61);
		listaStockInsumo.add(SI62);
		listaStockInsumo.add(SI63);
		
		//-------------------------------------------------------------
		
		//Creando Camiones
		
		Camion c1 = new Camion(01,"Mercedes Benz", 2002, 1000.0);
		Camion c2 = new Camion(02,"Ford", 2002, 1500.0);
		Camion c3 = new Camion(03,"Ivecco", 2014, 1800.0);
		Camion c4 = new Camion(04,"Mercedes Benz", 2005, 1200.0);
		
		listaCamiones = new ArrayList<Camion>();
		listaCamiones.add(c1);
		listaCamiones.add(c2);
		listaCamiones.add(c3);
		listaCamiones.add(c4);
		
		//-------------------------------------------------------------
		
		
		Vertice<Planta> v1 = new Vertice(p1);
		Vertice<Planta> v2 = new Vertice(p2);
		Vertice<Planta> v3 = new Vertice(p3);
		Vertice<Planta> v4 = new Vertice(p4);
		Vertice<Planta> v5 = new Vertice(p5);
		Vertice<Planta> v6 = new Vertice(p6);
		
		
		grafo = new Grafo();
		
		grafo.addNodo(v1);
		grafo.addNodo(v2);
		grafo.addNodo(v3);
		grafo.addNodo(v4);
		grafo.addNodo(v5);
		grafo.addNodo(v6);
		
		
		grafo.conectarFull(v1, v3, 1, 20.0, 10.0, 600.0);
		grafo.conectarFull(v1, v4, 1, 25.0, 15.0, 200.0);
		grafo.conectarFull(v1, v5, 1, 20.0, 10.0, 300.0);
		
		grafo.conectarFull(v3, v4, 1, 5.0, 5.0, 400.0);
		grafo.conectarFull(v3, v6, 1, 20.0, 10.0, 600.0);
		
		grafo.conectarFull(v4, v6, 1, 15.0, 7.0, 500.0);
		grafo.conectarFull(v4, v5, 1, 5.0, 5.0, 600.0);
		grafo.conectarFull(v4, v3, 1, 5.0, 5.0, 400.0);
		
		grafo.conectarFull(v5, v4, 1, 5.0, 5.0, 800.0);
		grafo.conectarFull(v5, v6, 1, 25.0, 10.0, 900.0);
		
		grafo.conectarFull(v6, v2, 1, 10.0, 10.0, 400.0);
		
		
		//---------------------------------------------------
		//Creando caminos
		
		Camino camino1 = new Camino(1,p1, p3,c1, 20.0, 10.0,3000.0); //Ver el peso soportado(ultimo valor).
		Camino camino2 = new Camino(2,p1, p4,c1, 25.0, 15.0,3000.0);
		Camino camino3 = new Camino(3,p1, p5,c1, 20.0, 10.0,3000.0);
		
		Camino camino4 = new Camino(4,p3, p4,c1, 5.0, 5.0,3000.0);
		Camino camino5 = new Camino(5,p3, p6,c1, 20.0, 10.0,3000.0);
		
		Camino camino6 = new Camino(6,p4, p3,c1, 15.0, 7.0,3000.0);
		Camino camino7 = new Camino(7,p4, p5,c1, 5.0, 5.0,3000.0);
		Camino camino8 = new Camino(8,p4, p6,c1, 5.0, 5.0,3000.0);
		
		Camino camino9 = new Camino(9,p5, p4,c1, 5.0, 5.0,3000.0);
		Camino camino10 = new Camino(10,p5, p6,c1, 25.0, 10.0,3000.0);
		
		Camino camino11 = new Camino(11,p6, p2,c1, 10.0, 10.0,3000.0);
		
		listaCaminos = new ArrayList<Camino>();
		
		listaCaminos.add(camino1);
		listaCaminos.add(camino2);
		listaCaminos.add(camino3);
		listaCaminos.add(camino4);
		listaCaminos.add(camino5);
		listaCaminos.add(camino6);
		listaCaminos.add(camino7);
		listaCaminos.add(camino8);
		listaCaminos.add(camino9);
		listaCaminos.add(camino10);
		listaCaminos.add(camino11);
		
		//---------------------------------------------------	
		
		
		
		
	
	
		}
		
		
		

		
		
		public ArbolBinario<Insumo> armarArbolNombre(List<Insumo> lista_insumos) {
			Insumo insumoAux = new Insumo(000, "ZZZZZZZZZZZZ");
				
			
			for(Insumo insumo : lista_insumos) {
				
				if(insumoAux.compareTo(insumo) > 0) {
					
					insumoAux = insumo;
					
				}
			}
			
			ArbolBinario<Insumo> arbol = new ArbolBinario<Insumo>(insumoAux);
			
			
			List<Insumo> lista_insumosaux = new ArrayList<Insumo>();
			
			lista_insumosaux.addAll(listaInsumos);
			
			for(int i=0; i< lista_insumosaux.size();i++) {
				
				if(lista_insumosaux.get(i).idinsumo == insumoAux.idinsumo) {
					lista_insumosaux.remove(i);
				}
				
			}
			
		//HAY QUE BORRARLE LA RAIZ A LISTA_INSUMOS
			//lista_insumos.remove(0);
			
			for(Insumo insx : lista_insumosaux) {
				
				arbol.recNombre(arbol, insx);
				
			}
			
			return arbol;
		}
		
		public ArbolBinario<Insumo> armarArbolCosto(List<Insumo> lista_insumos) {
			
			ComparadorCosto cc = new ComparadorCosto();
			
			Insumo insumoAux = new Insumo(000, "auxiliar", 1000.0);
				
			//BUSCA LA RAIZ(EL MAS CHICO)
			for(Insumo insumo : lista_insumos) {
				
				if(cc.compare(insumoAux, insumo) > 0) {
					//Integer idinsumo, String nombreInsumo, Double costoUnidad, String descripcion, String unidadDeMedida, Boolean esLiquido
					
					
					insumoAux.idinsumo = insumo.idinsumo;
					insumoAux.nombreInsumo = insumo.nombreInsumo;
					insumoAux.costo = insumo.costo;
					insumoAux.descripcion = insumo.descripcion;
					insumoAux.unidadDeMedida = insumo.unidadDeMedida;
					insumoAux.esLiquido = insumo.esLiquido;
				}
			}
			
			
			
			
			ArbolBinario<Insumo> arbol = new ArbolBinario<Insumo>(insumoAux);
			
			List<Insumo> lista_insumosaux = new ArrayList<Insumo>();
			
			lista_insumosaux.addAll(listaInsumos);
			

			for(int i=0; i< lista_insumosaux.size();i++) {
				
				if(lista_insumosaux.get(i).idinsumo == insumoAux.idinsumo) {
					lista_insumosaux.remove(i);
				}
				
			}
			
			
			
			//HAY QUE BORRARLE LA RAIZ A LISTA_INSUMOS
			
			
			for(Insumo insx : lista_insumosaux) {
				
				arbol.recCosto(arbol, insx);
				
			}
			
			return arbol;
			
		}
		
		
	
	
	public List<Planta> getPlantas() {
		return listaPlantas;
	}
	public List<Insumo> getInsumo() {
		return listaInsumos;
	}
	public List<Camion> getCamion() {
		return listaCamiones;
	}
	public List<StockInsumo> getStockInsumo() {
		return listaStockInsumo;
	}
	
	public Grafo<Planta> getGrafo(){
		return grafo;
	}
	//Movimientos en Base de datos
	public void agregarPlanta(Integer id_planta, String nombre_planta, Boolean esAcopio) {
		
		Planta p1 = new Planta(id_planta, nombre_planta, esAcopio);
		listaPlantas.add(p1);
	}
	
	public void borrarPlanta(Integer id_planta) {
		
		for(int i=0; i < listaPlantas.size(); i++) {
			if(listaPlantas.get(i).idplanta == id_planta) {
				listaPlantas.remove(i);
			}//Borramos el objeto planta de la listaPlantas
		}
		
		for(int z=0; z < listaStockInsumo.size(); z++) {
			if(listaStockInsumo.get(z).stock.id_planta == id_planta) {
				listaStockInsumo.remove(z);
			}//Borramos todos los Stockinsumos que tenga dicha planta
		}
	
			
	}
	
	public void agregarStockInsumo(StockInsumo stockInsumo) {
		listaStockInsumo.add(stockInsumo);
	}
		

	
	
	

}
