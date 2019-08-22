package grafo;



public class Arista<T> {
	
	public Vertice<T> inicio;
	public Vertice<T> fin;
	public Number valor;
	public Double distancia;
	public Double duracion;
	public Double pesoMax;
	
	public Arista(){
		valor=1.0;
	} 
	
	public Arista(Vertice<T> ini,Vertice<T> fin){
		this();
		this.inicio = ini;
		this.fin = fin;
	}
	
	public Arista(Vertice<T> ini,Vertice<T> fin, Double distancia, Double duracion){
		this();
		this.inicio = ini;
		this.fin = fin;
		this.distancia = distancia;
		this.duracion= duracion;
	}
	
	//creo el constructor que incluye a el peso_soportado
	public Arista(Vertice<T> ini, Vertice<T> fin, Number val, Double km, Double tiempo, Double peso){
		this(ini,fin);
		this.valor= val;
		this.distancia = km;
		this.duracion = tiempo;
		this.pesoMax = peso;
	}	

	public Arista(Vertice<T> ini, Vertice<T> fin, Number val){
		this(ini,fin);
		this.valor= val;
	}
	public Arista(Vertice<T> ini, Vertice<T> fin, Number val, Double km, Double tiempo){
		this(ini,fin);
		this.valor= val;
		this.distancia = km;
		this.duracion = tiempo;
	}
	
	public Vertice<T> getInicio() {
		return inicio;
	}
	
	public void setInicio(Vertice<T> inicio) {
		this.inicio = inicio;
	}
	
	public Vertice<T> getFin() {
		return fin;
	}
	
	public void setFin(Vertice<T> fin) {
		this.fin = fin;
	}

	public Number getValor() {
		return valor;
	}

	public void setValor(Number valor) {
		this.valor = valor;
	}
	
	
	@Override
	public String toString() {
		return "( "+this.inicio.getValor()+" --> "+this.fin.getValor()+" )";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Arista<?>) && ((Arista<?>)obj).getValor().equals(this.valor); 
	}
	
}

