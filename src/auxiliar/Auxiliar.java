package auxiliar;

import java.util.ArrayList;

public class Auxiliar<T> {
	
	
	public T planta;
	public ArrayList<InsumoCant> insumocant;
	
	
	public Auxiliar(T p) {
		this.planta = p;
		this.insumocant = new ArrayList<InsumoCant>();
	}
	public void agregarInsumoCant (InsumoCant insumoCant) {
		this.insumocant.add(insumoCant);
	}
	public T getPlanta(){
		return this.planta;
	}



}
