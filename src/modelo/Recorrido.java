package modelo;

import java.util.List;

import grafo.Vertice;

public class Recorrido {

	
	
	public int id_recorrido;
	public Double duracion_tiempo;
	public Double duracion_km;
	public List<Vertice<Planta>> recorrido;
	//Agregar cantidad maxima
	public Double pesoSoportado;
	
	public Recorrido() {
		
	}
	
	public Recorrido(int id_recorrido, List<Vertice<Planta>> recorrido) {
		
		this.id_recorrido = id_recorrido;
		this.recorrido = recorrido;
		this.duracion_tiempo = 0.0;
		this.duracion_km = 0.0;
		this.pesoSoportado = 0.0;
	}


	
	
}
