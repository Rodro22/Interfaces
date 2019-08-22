package modelo;

import java.util.ArrayList;
import java.util.List;


public class StockInsumo {
	
	//public int id_insumo;
	//public int id_stock;
	public int cant_max;
	public int cant_disponible;
	
	public Stock stock;
	public Insumo insumo;

	
	public StockInsumo (int id_insumo, int id_stock, int cant_max, int cant_disponible) {
		//this.id_insumo = id_insumo;
		//this.id_stock = id_stock;
		this.cant_max = cant_max;
		this.cant_disponible = cant_disponible;
	}
	public StockInsumo (Insumo insumo, Stock stock, int cant_max, int cant_disponible) {
		this.insumo = insumo;
		this.stock = stock;
		this.cant_max = cant_max;
		this.cant_disponible = cant_disponible;
	}
	
	
	
	
	
}
