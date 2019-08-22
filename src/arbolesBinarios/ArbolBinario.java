package arbolesBinarios;

import java.util.ArrayList;
import java.util.List;

import auxiliar.ComparadorCosto;
import modelo.*;


public class ArbolBinario<E> extends ArbolBinarioAbstracto<E>{
public ArbolBinarioAbstracto<E> izquierdo;
public ArbolBinarioAbstracto<E> derecho;


	public ArbolBinario(){
	this.valor = null;
	this.izquierdo = new ArbolVacio<E>();
	this.derecho = new ArbolVacio<E>();
	}
	
	/*
	public ArbolBinario(E e){
	this();
	this.valor=e;
	}
	*/
	
	public ArbolBinario(E e,ArbolBinarioAbstracto<E> i,ArbolBinarioAbstracto<E> d){//MODIFIQUE PARA QUE PUEDA TENER HIJOS HOJA Y ARBOL
	this.valor = e;
	this.izquierdo = i;
	this.derecho = d;
	}
	
	/*
	public ArbolBinario(E insumo){
	this.valor = insumo;
	this.izquierdo= null;
	this.derecho= null;
	}
	*/
	public ArbolBinario(E insumo){
	this.valor = insumo;
	this.izquierdo= new ArbolVacio<E>();;
	this.derecho= new ArbolVacio<E>();;
	}
	
	@Override public boolean esVacio() { return false; }
	@Override public E valor() { return this.valor; }
	
	@Override
	public ArbolBinarioAbstracto<E> izquierdo() { return this.izquierdo; }
	@Override
	public ArbolBinarioAbstracto<E> derecho() { return this.derecho; }
	@Override
	public void agregarDerecho(ArbolBinarioAbstracto<E> a) { this.derecho = a; }
	@Override
	public void agregarIzquierdo(ArbolBinarioAbstracto<E> a) { this.izquierdo= a; }
	@Override
	public boolean contiene(E unValor) {
			return this.valor.equals(unValor) ||
			this.izquierdo.contiene(unValor) || this.derecho.contiene(unValor);
			}
	@Override
	public boolean equals(ArbolBinarioAbstracto<E> a) {
		return valor.equals(a.valor()) && izquierdo.equals(a.izquierdo())
		&& derecho.equals(a.derecho());
		}
	
	@Override
	public Integer profundidad() {
		return Math.max(izquierdo.profundidad() + 1,derecho.profundidad() + 1);//+1 para contar este escalon
	}
	
	@Override
	public List<E> preOrden() {
			List<E> lista = new ArrayList<E>();
			lista.add(this.valor);
			lista.addAll(this.izquierdo.preOrden());
			lista.addAll(this.derecho.preOrden());
			return lista;
			}
	@Override
	public List<E> inOrden() {
			List<E> lista = new ArrayList<E>();
			lista.addAll(this.izquierdo.inOrden());
			lista.add(this.valor);
			lista.addAll(this.derecho.inOrden());
			return lista;
			}
	@Override
	public List<E> posOrden() {
			List<E> lista = new ArrayList<E>();
			lista.addAll(this.izquierdo.posOrden());
			lista.addAll(this.derecho.posOrden());
			lista.add(this.valor);
			return lista;
			}
	
	public int cuentaHojasRec() {
		
			if(this.derecho.esVacio() && this.izquierdo.esVacio()) {
					
				return 2;
			}
				
			if(!this.derecho.esVacio() && !this.izquierdo.esVacio()) {
				
				return (this.derecho.cuentaHojasRec() + this.izquierdo.cuentaHojasRec());
			}
			if(this.derecho.esVacio() && !this.izquierdo.esVacio()) {
				
				return (1 + this.izquierdo.cuentaHojasRec());
			}
			if(!this.derecho.esVacio() && this.izquierdo.esVacio()) {
				
				return (1 + this.derecho.cuentaHojasRec());
			}
			return 0;
			
			}
			
	public int cuentaNodosDeNivel(int nivel) {
		
			if(nivel == 0) {
				
				return 1;
			}
			else {
				if(this.derecho.esVacio() && this.izquierdo.esVacio()) {
				
				if(nivel == 1) {
					
				return 2;}
				else {
				
				return 0;}
				}
				else if(!this.derecho().esVacio() && !this.izquierdo.esVacio()) {
					return (this.derecho().cuentaNodosDeNivel(nivel - 1) + this.izquierdo().cuentaNodosDeNivel(nivel-1));
				}
				else if(this.derecho().esVacio() && !this.izquierdo().esVacio()) {
					return (this.izquierdo().cuentaNodosDeNivel(nivel - 1));
				}
				else if(!this.derecho.esVacio() && this.izquierdo.esVacio()) {
					return (this.derecho().cuentaNodosDeNivel(nivel -1));
				}
					
				
				return 0;	
			}
			
		}


	public void recNombre(ArbolBinarioAbstracto<Insumo> arbol, Insumo insumo) {
	
			if(arbol.valor().compareTo(insumo) < 0) {
				if(arbol.derecho().valor() == null) {
					ArbolBinario<Insumo> aux = new ArbolBinario<Insumo>(insumo);
					//arbol.derecho() = aux;
					arbol.agregarDerecho(aux);
				}
				else {
					this.recNombre(arbol.derecho(), insumo);
				}
			}
			
			if(arbol.valor().compareTo(insumo) > 0) {
				if(arbol.izquierdo().valor() == null) {
					ArbolBinario<Insumo> aux = new ArbolBinario<Insumo>(insumo);
					
					arbol.agregarIzquierdo(aux);
					
				}
				else {
					this.recNombre(arbol.izquierdo(), insumo);
				}
			}
			
			
}

	public void recCosto(ArbolBinarioAbstracto<Insumo> arbol, Insumo insumo) {
	
			ComparadorCosto cc = new ComparadorCosto();
			
			if(cc.compare(arbol.valor(), insumo) < 0) {
				if(arbol.derecho().valor() == null) {
					ArbolBinario<Insumo> aux = new ArbolBinario<Insumo>(insumo);
					
					arbol.agregarDerecho(aux);
				}
				else {
					this.recCosto(arbol.derecho(), insumo);
				}
			}
			
			if(cc.compare(arbol.valor(), insumo) > 0) {
				if(arbol.izquierdo().valor() == null) {
					ArbolBinario<Insumo> aux = new ArbolBinario<Insumo>(insumo);
					
					arbol.agregarIzquierdo(aux);
					
				}
				else {
					this.recCosto(arbol.izquierdo(), insumo);
				}
			}
	
	
}



}

