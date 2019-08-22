package auxiliar;



public class InsumoFaltante {

	public int peso;
	public double beneficio;
	
	public int id_insumoFaltante;
	public int id_plantaQueLoNecesita;
	
	
	public InsumoFaltante() {}
	
	public InsumoFaltante(int peso, double beneficio) {
		this.peso = peso;
		this.beneficio = beneficio;
	}
	public InsumoFaltante(int peso, double beneficio, int idI, int idP) {
		this.peso = peso;
		this.beneficio = beneficio;
		this.id_insumoFaltante = idI;
		this.id_plantaQueLoNecesita = idP;
	}
	
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		
		if(this == null) return false;
		
		if(getClass() != obj.getClass()) return false;
		
		final InsumoFaltante other = (InsumoFaltante) obj;
		
		if(this.peso != other.peso) return false;
		
		if(this.beneficio != other.beneficio) return false;
		
		return true;
		
	}
	
	public String toString() {
		return "Peso: "+peso+", "+"beneficio: "+beneficio;
	}
}