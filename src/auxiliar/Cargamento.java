package auxiliar;



public class Cargamento {

	public Double pesoMaximo;
	public InsumoFaltante[] elementos;
	
	public int pesoActual;
	public int beneficio;

	public Cargamento(Double pesoMax, int numElem) {
		this.pesoMaximo = pesoMax;
		this.elementos = new InsumoFaltante[numElem];
		this.beneficio = 0;
		this.pesoActual = 0;
	}

	public void aniadir(InsumoFaltante e) {
		for(int i=0; i<this.elementos.length; i++) {	
			if(this.elementos[i] == null) {
				this.elementos[i] = e;
				this.beneficio += e.beneficio;
				this.pesoActual += e.peso;
				break;
											}
													}
									}
	public void clear() {
		this.pesoActual = 0;
		this.beneficio = 0;
		for(int i=0; i < this.elementos.length; i++) {
			this.elementos[i] = null;
												}
						}
	
	public void eliminarElemento(InsumoFaltante e) {
			for(int i=0; i<this.elementos.length; i++) {	
				if(this.elementos[i].equals(e)) {
					this.elementos[i] = null;
					this.beneficio -= e.beneficio;
					this.pesoActual -= e.peso;
					break;
											}
													}
														}
	
	public boolean existeElemento(InsumoFaltante e) {
		for(int i=0; i<this.elementos.length; i++) {	
			if(this.elementos[i] != null && this.elementos[i].equals(e)) {
			return true;		}					}						
			return false;					}
	
	public String toString() {
		
		String cadena = "";
		for(int i=0; i<this.elementos.length; i++) {
			if(this.elementos[i] != null) {
				cadena += elementos[i] + "\n";
			}
		}

		cadena+="Peso: "+ this.pesoActual + "\n";
		cadena+="Beneficio: "+ this.beneficio + "\n";
		
		return cadena;
	}
	

	
	
	
	
}
