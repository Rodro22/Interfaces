package modelo;

import java.util.ArrayList;
import java.util.List;


public class Stock {

	public int id_stock;
	public int id_planta;
	public List<Insumo> lista_insumo = new ArrayList<Insumo>(); 
	
	public Stock() {
		
	}
	
	public Stock(int id_stock, List<Insumo> lista_insumo ) {
		this.id_stock = id_stock;
		this.lista_insumo = lista_insumo;
	}
	
	public Stock(int id_stock, int id_planta, List<Insumo> lista_insumo ) {
		this.id_stock = id_stock;
		this.lista_insumo = lista_insumo;
	}

}