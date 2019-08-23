package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circulo {
	private int x, y;
	public static final int d = 20;
	private String nombre;
	public int idInsumo;
	
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
	public Circulo(int x, int y, String nombre, int insumo) {
		this.x = x;
		this.y = y;
		this.nombre = nombre;
		this.idInsumo = insumo;
	}
	public Circulo(String nombre) {
		
		this.nombre = nombre;
		this.idInsumo = 0;
		
	}
	
//	Font oldFont=getFont();
//    Font fuente=new Font("Monospaced", Font.BOLD, 36);
//    g.setFont(fuente);
//    g.drawString(texto, 100, 50);
//    g.setFont(oldFont);
//    g.drawString(otroTexto, 100, 70);
	
	public void pintar(Graphics g) {
		g.setColor(Color.green);
		((Graphics2D) g).setStroke(new BasicStroke(3));
		
		g.drawOval(this.x - d/2, this.y -d/2, d, d);
		g.fillOval(this.x - d/2, this.y -d/2, d, d);
//		Font oldFont = getFont();
	    Font fuente = new Font("Monospaced", Font.BOLD, 20);
	    g.setFont(fuente);
		g.drawString(nombre, x-35, y-20);

	}

	public void pintar2(Graphics g) {
		g.setColor(Color.red);
		((Graphics2D) g).setStroke(new BasicStroke(3));

		g.drawOval(this.x - d/2, this.y -d/2, d, d);
		g.fillOval(this.x - d/2, this.y -d/2, d, d);
//		Font oldFont = getFont();
	    Font fuente = new Font("Monospaced", Font.BOLD, 20);
	    g.setFont(fuente);
		g.drawString(nombre, x-35, y-20);
		
		
	}
	
	public void pintar3(Graphics g) {
		g.setColor(Color.red);
		((Graphics2D) g).setStroke(new BasicStroke(3));

		g.drawOval(this.x - d/2, this.y -d/2, d, d);
		g.fillOval(this.x - d/2, this.y -d/2, d, d);
//		Font oldFont = getFont();
	    Font fuente = new Font("Monospaced", Font.BOLD, 20);
	    g.setFont(fuente);
		g.drawString(nombre, x-35, y-20);

	}
	
//	public void pintarInsumo(Graphics g) {
//		
//		if(idInsumo == 0) {
//			g.setColor(Color.green);
//			((Graphics2D) g).setStroke(new BasicStroke(3));
//			g.drawOval(this.x - d/2, this.y -d/2, d, d);
//			g.fillOval(this.x - d/2, this.y -d/2, d, d);
//			g.drawString(nombre, x-35, y-20);
//			}
//		
//		else if(idInsumo != 0) {
//			g.setColor(Color.red);
//			((Graphics2D) g).setStroke(new BasicStroke(3));
//			g.drawOval(this.x - d/2, this.y -d/2, d, d);
//			g.fillOval(this.x - d/2, this.y -d/2, d, d);
//			g.drawString(nombre, x-35, y-20);
//			}
//		
//	}
	
	
	
	
	
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
