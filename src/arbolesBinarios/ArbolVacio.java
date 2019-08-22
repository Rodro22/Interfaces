package arbolesBinarios;


import java.util.*;

public class ArbolVacio<E> extends ArbolBinarioAbstracto<E> {

		public ArbolVacio(){
		this.valor=null;
		}
		
		
		@Override
		public void agregarDerecho(ArbolBinarioAbstracto<E> a) {}
		@Override
		public void agregarIzquierdo(ArbolBinarioAbstracto<E> a) {}
		@Override
		public boolean contiene(E unValor) { return false; }
		@Override
		public boolean equals(ArbolBinarioAbstracto<E> unArbol){ return unArbol.esVacio(); }
		@Override
		public Integer profundidad() { return 0; }
		
		
		
		@Override
		public ArrayList<E> preOrden() { return new ArrayList<E>(); }
		@Override
		public ArrayList<E> inOrden() { return new ArrayList<E>(); }
		@Override
		public ArrayList<E> posOrden() { return new ArrayList<E>(); }
		 @Override
		public boolean esVacio() { return true; }
		@Override
		public E valor() { return null; }
		@Override
		public ArbolVacio<E> izquierdo() { return null; }
		@Override
		public ArbolVacio<E> derecho() { return null; }
		
		public int cuentaHojasRec() {
			
			return 1;
			
		}
		
		public int cuentaNodosDeNivel(int nivel) {
			return 0;
		}

}

