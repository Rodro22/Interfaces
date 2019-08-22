package modelo;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class Camino {
	private Integer idcamino;
	private Planta planta_init;
	private Planta planta_end;
	private Camion camion;
	
	private Double distancia;
	private Double duracion;
	private Double peso_soportado;
	
	private int x1, y1, x2, y2;
	private String nombre;
	
	public Camino(Integer idcamino, Planta planta_init, Planta planta_end, Camion camion, Double distancia, Double duracion, Double peso_soportado) {
		super();
		this.idcamino = idcamino;
		this.planta_init = planta_init;
		this.planta_end = planta_end;
		this.camion = camion;
		this.distancia = distancia;
		this.duracion = duracion;
		this.peso_soportado = peso_soportado;
	
	}
	
	public Camino(Integer idcamino, Planta planta_init, Planta planta_end, Double distancia, Double duracion, Double peso_soportado) {
		super();
		this.idcamino = idcamino;
		this.planta_init = planta_init;
		this.planta_end = planta_end;
		this.distancia = distancia;
		this.duracion = duracion;
		this.peso_soportado = peso_soportado;
	
	}
	
	public Camino() {
		super();
	}
	public Camino(int x, int y, int x1, int y1, String nombre, Integer id1) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x1;
		this.y2 = y1;
		this.nombre = nombre;
		this.idcamino = id1;
	}
	
	public Integer getId() {
		return idcamino;
	}
	public void setId(Integer idcamino) {
		this.idcamino = idcamino;
	}
	public Planta getPlantaInit() {
		return planta_init;
	}
	public void setPlantaInit(Planta planta_init) {
		this.planta_init = planta_init;
	}
	public Planta getPlantaEnd() {
		return planta_end;
	}
	public void setPlantaEnd(Planta planta_end) {
		this.planta_end= planta_end;
	}
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion= camion;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getDuracion() {
		return duracion;
	}
	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}
	public Double getPesoSoportado() {
		return peso_soportado;
	}
	public void setPesoSoportado(Double peso_soportado) {
		this.peso_soportado= peso_soportado;
	}
	
	public void pintar(Graphics g) {
		
		if(idcamino>3) {
		((Graphics2D)g).setColor(Color.red);
		((Graphics2D)g).setStroke(new BasicStroke(3));
		
		g.drawLine(x1, y1, x2, y2);

		if(x1>x2 && y1>y2) {
			g.drawString(nombre, x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));}
		if(x1<x2 && y1<y2) {
			g.drawString(nombre, x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));}
		if(x1>x2 && y1<y2) {
			g.drawString(nombre, x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));}
		if(x1<x2 && y1>y2) {
			g.drawString(nombre, x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));}
		}
		
		else if(idcamino<=3) {
		((Graphics2D)g).setColor(Color.black);
		((Graphics2D)g).setStroke(new BasicStroke(3));
		
		g.drawLine(x1, y1, x2, y2);

		if(x1>x2 && y1>y2) {
			g.drawString(nombre, x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));}
		if(x1<x2 && y1<y2) {
			g.drawString(nombre, x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));}
		if(x1>x2 && y1<y2) {
			g.drawString(nombre, x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));}
		if(x1<x2 && y1>y2) {
			g.drawString(nombre, x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));}
		}
	
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camino other = (Camino) obj;
		if (idcamino == null) {
			if (other.idcamino != null)
				return false;
		} else if (!idcamino.equals(other.idcamino))
			return false;
		return true;
	}

	public Integer getIdcamino() {
		return idcamino;
	}

	public void setIdcamino(Integer idcamino) {
		this.idcamino = idcamino;
	}

	public Planta getPlanta_init() {
		return planta_init;
	}

	public void setPlanta_init(Planta planta_init) {
		this.planta_init = planta_init;
	}

	public Planta getPlanta_end() {
		return planta_end;
	}

	public void setPlanta_end(Planta planta_end) {
		this.planta_end = planta_end;
	}

	public Double getPeso_soportado() {
		return peso_soportado;
	}

	public void setPeso_soportado(Double peso_soportado) {
		this.peso_soportado = peso_soportado;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
