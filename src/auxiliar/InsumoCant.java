package auxiliar;

import modelo.Insumo;

public class InsumoCant {
	
	public Insumo insumo;
	public int cantidad;
	public int faltante;
	
	
	public InsumoCant(Insumo insumo, int cantidad, int faltante) {
		this.insumo = insumo;
		this.cantidad = cantidad;
		this.faltante = faltante;
	}

}
