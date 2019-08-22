package auxiliar;

import java.util.ArrayList;
import java.util.List;


import grafo.*;
import modelo.Insumo;
import modelo.Planta;
import modelo.Recorrido;
import modelo.Stock;
import modelo.StockInsumo;

public class Magica {
	
	
	
	public Magica() {}
	
	
	public List<Vertice<Planta>> filtrarStock2 (int id_insumoSeleccionado, List<StockInsumo> lista_stockInsumo, List<Vertice<Planta>> lista_plantas) {
		//devuelve una lista de Vertice<Planta> donde haga falta id_insumo
		ArrayList<StockInsumo> lista_StockInsumo_f1 = new ArrayList<>();
		//ArrayList<Integer> lista_idStock = new ArrayList<>();
		ArrayList<Stock> lista_stock = new ArrayList<>();
		ArrayList<Vertice<Planta>> lista_plantasFINAL = new ArrayList<>();
		
		
		for(StockInsumo aux : lista_stockInsumo) {
			if(aux.insumo.idinsumo == id_insumoSeleccionado) {
				lista_StockInsumo_f1.add(aux);
			}
		}
		for(StockInsumo aux : lista_StockInsumo_f1) {
			if(aux.cant_max > aux.cant_disponible) {
				//lista_idStock.add(aux.stock.id_stock);
				lista_stock.add(aux.stock);
		}
	}

		for(Vertice<Planta> aux : lista_plantas) {
			//for(Integer : lista_idStock) {
			  for(Stock stock : lista_stock) {
				if(aux.getValor().unStock.id_stock == stock.id_stock ) {
					 lista_plantasFINAL.add(aux);
				}
			}
		}
	
	return lista_plantasFINAL;
	}
	
	public List<Auxiliar<Planta>> filtrarPlantaConSusInsumosCant(List<Insumo> lista_insumos,List<StockInsumo> lista_stockInsumo, List<Vertice<Planta>> lista_plantas) {
		//5.3.b
		//lista todos los insumos faltantes de una planta
		ArrayList<StockInsumo> lista_StockInsumo_f1 = new ArrayList<>();
		//ArrayList<Integer> lista_idStock = new ArrayList<>();
		ArrayList<Stock> lista_stock = new ArrayList<>();
		ArrayList<Vertice<Planta>> lista_plantasFINAL = new ArrayList<>();
		List<Auxiliar<Planta>> lista_aux = new ArrayList<>();
	
		for(StockInsumo aux : lista_stockInsumo) {
			if(aux.cant_max > aux.cant_disponible) {
				//lista_idStock.add(aux.id_stock);
				lista_stock.add(aux.stock);
			}
		}

		for(Vertice<Planta> aux : lista_plantas) {
			//for(Integer id : lista_idStock) {
			  for(Stock stock : lista_stock) {
				if(aux.getValor().unStock.id_stock == stock.id_stock ) {
					lista_plantasFINAL.add(aux);
				}
			}
		}
		
		for (Vertice<Planta> verticex : lista_plantasFINAL) {
			Auxiliar<Planta> auxiliar = new Auxiliar(verticex.getValor());
			for(StockInsumo stockinsumo : lista_stockInsumo) {
				//este for esta a cargo de cargar todos los insumo y sus cantidades
				
				for(Insumo ins : lista_insumos) {
					if(stockinsumo.insumo.idinsumo == ins.idinsumo) {
						if(stockinsumo.cant_max > stockinsumo.cant_disponible) {
							if(verticex.getValor().unStock.id_stock == stockinsumo.stock.id_stock) {
						//lista_aux.add(ins);
						//lista_aux.add(stockinsumo.cant_disponible);
						InsumoCant inscant = new InsumoCant(ins, stockinsumo.cant_disponible,  stockinsumo.cant_max - stockinsumo.cant_disponible);
						auxiliar.insumocant.add(inscant);
						}}
					}
				}
				
			
			}
			
			lista_aux.add(auxiliar);
			
		}
		
		return lista_aux;
	}
	
	
	//plantas: es una lista de Vertices<plantas> que necesitan el insumo
	//recorridos: es una lista con los recorridos desde el inicio al fin
	public Recorrido mejorRecorrido(List<Vertice<Planta>> plantas_que_necesitan_el_insumo, List<Recorrido> recorridos_armados) {
	
		List<Recorrido> lista_aux = new ArrayList<Recorrido>();
		List<Recorrido> lista_recorridos_posibles = new ArrayList<Recorrido>();
		
		
		lista_recorridos_posibles = recorridos_armados;
		
		for(Vertice<Planta> aux : plantas_que_necesitan_el_insumo) {//vertices contiene los vertices que contienen las plantas que necesitan insumos
			
				for(int a=0; a < lista_recorridos_posibles.size(); a++) {
				//System.out.println("contains: " + recorrido.recorrido.contains(aux) );
			
				if(lista_recorridos_posibles.get(a).recorrido.contains(aux)) {
					
;
					lista_aux.add(lista_recorridos_posibles.get(a));		
				}
				else {
					
				}
			
			}
			
		
			
			//lista_recorridos_posibles = lista_aux;
			
			lista_recorridos_posibles.removeAll(lista_recorridos_posibles);
			
			for(Recorrido r : lista_aux) {
			
			lista_recorridos_posibles.add(r);

			}
			lista_aux.clear();
			
			}
		
			return calcularMejorRecorrido(lista_recorridos_posibles);
	}
	
	public Recorrido calcularMejorRecorrido(List<Recorrido> lista_recorridos){
		
		Double max=10000000.0;
		int id_aux=0;
		
		Recorrido rec= new Recorrido();
		
		for(int i=0; i < lista_recorridos.size(); i++) {
			
			if(lista_recorridos.get(i).duracion_km < max) {
				
				max = lista_recorridos.get(i).duracion_km;
				id_aux= lista_recorridos.get(i).id_recorrido;
				
			}
			
		}
		
		for(Recorrido aux : lista_recorridos) {
			
			if(id_aux == aux.id_recorrido) {
				
				rec.id_recorrido = aux.id_recorrido;
				rec.duracion_km = aux.duracion_km;
				rec.duracion_tiempo = aux.duracion_tiempo;
				rec.recorrido = aux.recorrido; 
			}
			
		}
		return rec;				}
	
///////////////////////////////////////////////////////////////////////////////////////
	
	public Recorrido mejorRecorridoPorPeso(List<Vertice<Planta>> plantas_que_necesitan_el_insumo, List<Recorrido> recorridos_armados, List<Arista<Planta>> lista_aristas) {
		
		List<Recorrido> lista_aux = new ArrayList<Recorrido>();
		List<Recorrido> lista_recorridos_posibles = new ArrayList<Recorrido>();		
		lista_recorridos_posibles = recorridos_armados;
		
		for(Vertice<Planta> aux : plantas_que_necesitan_el_insumo) {//vertices contiene los vertices que contienen las plantas que necesitan insumos

				for(int a=0; a < lista_recorridos_posibles.size(); a++) {
				//System.out.println("contains: " + recorrido.recorrido.contains(aux) );
			
				if(lista_recorridos_posibles.get(a).recorrido.contains(aux)) {
					lista_aux.add(lista_recorridos_posibles.get(a));		
				}
			
			}
			
			lista_recorridos_posibles.removeAll(lista_recorridos_posibles);
			
			for(Recorrido r : lista_aux) {
			
			lista_recorridos_posibles.add(r);

			}
			lista_aux.clear();
			
			}
		
			return calcularMejorRecorridoPorPeso(lista_recorridos_posibles, lista_aristas);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Recorrido mejorRecorridoPorPesoVer2(List<Vertice<Planta>> plantas_que_necesitan_el_insumo, List<Recorrido> recorridos_armados, List<Arista<Planta>> lista_aristas) {
		
		List<Recorrido> lista_aux = new ArrayList<Recorrido>();
		List<Recorrido> lista_recorridos_posibles = new ArrayList<Recorrido>();		
		lista_recorridos_posibles = recorridos_armados;
		
		for(Vertice<Planta> aux : plantas_que_necesitan_el_insumo) {//vertices contiene los vertices que contienen las plantas que necesitan insumos

				for(int a=0; a < lista_recorridos_posibles.size(); a++) {
				//System.out.println("contains: " + recorrido.recorrido.contains(aux) );
			
				if(lista_recorridos_posibles.get(a).recorrido.contains(aux)) {
					lista_aux.add(lista_recorridos_posibles.get(a));		
				}
			
			}
			
			lista_recorridos_posibles.removeAll(lista_recorridos_posibles);
			
			for(Recorrido r : lista_aux) {
			
			lista_recorridos_posibles.add(r);

			}
			lista_aux.clear();
			
			}
		
			return calcularMejorRecorridoPorPeso(lista_recorridos_posibles, lista_aristas);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Recorrido calcularMejorRecorridoPorPeso(List<Recorrido> lista_recorridos, List<Arista<Planta>> lista_aristas) {
		
		List<Recorrido> lista_aux = new ArrayList<Recorrido>();
		lista_aux = lista_recorridos;
		
		//a cada recorrido se le asigna el atributo "peso_soportado"
		for(Recorrido aux : lista_aux)	{
			Double var_peso_soportado;
			var_peso_soportado = (double) peso_maximo(aux, lista_aristas);
			aux.pesoSoportado = var_peso_soportado;
										}
		Recorrido recorrido_encontrado = new Recorrido();
		recorrido_encontrado = calcularMejorRecorridoAux(lista_aux);
		return recorrido_encontrado;												
		}
	
	
		
	//funcion que me trabaja con las plantas para devolverme el menor peso de un camino	
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
	
	//funciona igual que el otro metodo ya definido
	public Recorrido calcularMejorRecorridoAux(List<Recorrido> lista_recorridos){
		
		Double max=10000000.0;
		int id_aux=0;
		
		Recorrido rec= new Recorrido();
		
		for(int i=0; i < lista_recorridos.size(); i++) 	{
			
			if(lista_recorridos.get(i).pesoSoportado < max) 	{
				max = lista_recorridos.get(i).pesoSoportado;
				id_aux= lista_recorridos.get(i).id_recorrido;	}
														}
		
		for(Recorrido aux : lista_recorridos)	{
			
			if(id_aux == aux.id_recorrido) {				
				rec.id_recorrido = aux.id_recorrido;
				rec.duracion_km = aux.duracion_km;
				rec.duracion_tiempo = aux.duracion_tiempo;
				rec.recorrido = aux.recorrido; 
				rec.pesoSoportado = aux.pesoSoportado;
											}	}
		return rec;
		
	}
	
    public Double buscarPesoDeAristaEntre(Vertice<Planta> v1, Vertice<Planta> v2, List<Arista<Planta>> lista_aristas){
    	for(Arista unaArista : lista_aristas) {
    		
    		if(unaArista.getInicio().equals(v1) && unaArista.getFin().equals(v2)) return unaArista.pesoMax;
    	}
    	return 0.0;
    }
	
    
    
    
	/*
    1º: retornar peso maximo permitido entre las plantas
    2º: retornar los recorridos posibles entre las plantas
    3º: calcular los costos de los insumos faltantes en cada planta
    4º: armar una lista con estos valores
    5º: seleccionar el mejor de estos valores    
    */

	public static void llenarCargamento(Cargamento m_base, Cargamento m_opt, InsumoFaltante[] elementos, boolean llena) {
		
		//comprobar si la mochila actual es mejor que la optima
		if(llena) {
			
			if(m_base.beneficio > m_opt.beneficio) {
				InsumoFaltante[] elementosMochBase = m_base.elementos;
				m_opt.clear();
				
				for(InsumoFaltante elem: elementosMochBase) {
					if(elem != null) m_opt.aniadir(elem);
					
				}
				
			}
			
		} else {
			
			for(int i = 0; i<elementos.length; i++) {
				
				if(! m_base.existeElemento(elementos[i])){
					if(m_base.pesoMaximo > m_base.pesoActual + elementos[i].peso) {
						m_base.aniadir(elementos[i]);
						llenarCargamento(m_base, m_opt, elementos, false);
						m_base.eliminarElemento(elementos[i]);
					} else {
						llenarCargamento(m_base, m_opt, elementos, true);
					}
				}
			}
			
		}
		
	}
    

    
    
    
    
    
    

	
	
	

	
}
