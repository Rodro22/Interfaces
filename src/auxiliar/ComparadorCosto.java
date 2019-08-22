package auxiliar;

import java.util.Comparator;

import modelo.*;

public class ComparadorCosto implements Comparator<Insumo>{
	
	
	
	public int compare(Insumo i1, Insumo i2) {
		
		if(i1.costo > i2.costo) {
			return 1;
		}
		else if(i1.costo < i2.costo) {
			return -1;
		}
	
		return 0;
	}

}
