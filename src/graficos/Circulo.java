package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circulo {
	private int x, y;
	public static final int d = 30;
	private String nombre;
	
	public int id;
	
	public String getNombreCirculo() {
		return nombre;
	}

	public void setNombreCirculo(String nombreNodo) {
		this.nombre = nombreNodo;
	}

	public Circulo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Circulo(int x, int y, String nombre) {
		this.x = x;
		this.y = y;
		this.nombre = nombre;
	}
	public Circulo(int x, int y, String nombre, int d) {
		this.x = x;
		this.y = y;
		this.nombre = nombre;
		this.id = d;
	}
	public Circulo(String nombre) {
		
		this.nombre = nombre;
		
	}
	
//	Font oldFont=getFont();
//    Font fuente=new Font("Monospaced", Font.BOLD, 36);
//    g.setFont(fuente);
//    g.drawString(texto, 100, 50);
//    g.setFont(oldFont);
//    g.drawString(otroTexto, 100, 70);
	
	public void pintar(Graphics g) {
		g.setColor(Color.blue);
		((Graphics2D) g).setStroke(new BasicStroke(3));

		g.drawOval(this.x - d/2, this.y -d/2, d, d);
		g.fillOval(this.x - d/2, this.y -d/2, d, d);
//		Font oldFont = getFont();
	    Font fuente=new Font("Monospaced", Font.BOLD, 36);
	    g.setFont(fuente);
		g.drawString(nombre, x, y);

	}

	public void pintar2(Graphics g) {
		((Graphics2D)g).setColor(Color.orange);
		((Graphics2D)g).setStroke(new BasicStroke(3));
		g.drawOval(this.x - d/2, this.y -d/2, d, d);
		g.drawString(nombre, x, y);
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



	

}
