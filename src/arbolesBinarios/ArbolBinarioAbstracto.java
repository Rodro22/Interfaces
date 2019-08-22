package arbolesBinarios;

import java.util.List;


 public abstract class ArbolBinarioAbstracto<E> {
 public E valor;
 public abstract List<E> preOrden();
 public abstract List<E> inOrden();
 public abstract List<E> posOrden();
 public abstract boolean esVacio();
 public abstract E valor();
 public abstract ArbolBinarioAbstracto<E> izquierdo();
 public abstract ArbolBinarioAbstracto<E> derecho();
 public abstract void agregarDerecho(ArbolBinarioAbstracto<E> a);
 public abstract void agregarIzquierdo(ArbolBinarioAbstracto<E> a);
 public abstract boolean contiene(E unValor);
 public abstract boolean equals(ArbolBinarioAbstracto<E> unArbol);
 public abstract Integer profundidad();
 public abstract int cuentaHojasRec();
 public abstract int cuentaNodosDeNivel(int nivel);
}
