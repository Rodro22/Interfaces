package modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;


public class Planta {
	
	public Integer idplanta;
	public String nombre_planta;
	public Boolean esAcopio;
	public Boolean tieneStock;
	public Stock unStock;
	
	public Stock getUnStock() {
		return unStock;
	}

	public void setUnStock(Stock unStock) {
		this.unStock = unStock;
	}
	public int x, y;
	public static final int d =60;
	public Graphics objetoG;
	
	public Double costoTotal;
	

	
	
	public Integer getIdplanta() {
		return idplanta;
	}

	public void setIdplanta(Integer idplanta) {
		this.idplanta = idplanta;
	}

	public String getNombre_planta() {
		return nombre_planta;
	}

	public void setNombre_planta(String nombre_planta) {
		this.nombre_planta = nombre_planta;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getD() {
		return d;
	}


	public Planta(Integer idplanta, String nombre_planta, Boolean acopio) {
		
		this.idplanta = idplanta;
		this.nombre_planta = nombre_planta;
		this.esAcopio = acopio;
		this.unStock = new Stock();
	}
	public Planta(Integer idplanta, String nombre_planta, Boolean acopio, Stock unStock) {
		
		this.idplanta = idplanta;
		this.nombre_planta = nombre_planta;
		this.esAcopio = acopio;
		this.unStock = unStock;
	}
	
	public Planta(Integer idplanta, String nombre_planta, Boolean acopio, int x, int y) {
		super();
		this.idplanta = idplanta;
		this.nombre_planta = nombre_planta;
		this.esAcopio = acopio;
		this.x = x;
		this.y = y;
	}
	
	public Planta() {}
	
	
	public Planta(int x2, int y2, String nombre_planta2) {
		// TODO Auto-generated constructor stub
		this.x = x2;
		this.y = y2;
		this.nombre_planta = nombre_planta2;
	}
	public Planta(int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x = x2;
		this.y = y2;
	}

	public Integer getId() {
		return idplanta;
	}
	public void setId(Integer idplanta) {
		this.idplanta = idplanta;
	}
	public String getNombre() {
		return nombre_planta;
	}
	public void setNombre(String nombre_planta) {
		this.nombre_planta = nombre_planta;
	}
	public Boolean getEsAcopio() {
		return esAcopio;
	}
	public void setEsAcopio(Boolean acopio) {
		this.esAcopio = acopio;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		if (idplanta == null) {
			if (other.idplanta != null)
				return false;
		} else if (!idplanta.equals(other.idplanta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		//return "Proyecto [id=" + id + ", nombre=" + nombre + ", tareas=" + tareas + "]";
		return this.nombre_planta;
	}
	public void pintar(Graphics g) {
		Integer a = 3;
		if(idplanta<a) {
			g.setColor(Color.green);
			((Graphics2D) g).setStroke(new BasicStroke(3));
			g.drawOval(this.x - d/2, this.y -d/2, d, d);
			g.fillOval(this.x - d/2, this.y -d/2, d, d);
			g.drawString(nombre_planta, x+35, y+35);
			}
		
		else if(idplanta>=a) {
			g.setColor(Color.red);
			((Graphics2D) g).setStroke(new BasicStroke(3));
			g.drawOval(this.x - d/2, this.y -d/2, d, d);
			g.fillOval(this.x - d/2, this.y -d/2, d, d);
			g.drawString(nombre_planta, x+35, y+35);}
		
	}
	

}
