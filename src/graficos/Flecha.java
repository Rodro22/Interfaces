package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Flecha {

	private int x1, y1, x2, y2;
	private String nombre;
	public Double distancia;
	public Double duracion;
	public Double peso;
	public int valorGuia;

	public Flecha (int x1, int y1, int x2, int y2) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;				}
	
	public Flecha (int x1, int y1, int x2, int y2, String nombre) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;		
		this.nombre = nombre;
		}
	
	public Flecha (String nombre) {
			
		this.nombre = nombre;
		
		}
	
	public Flecha(Double a, Double b, Double c, int guia) {
		this.distancia = a;
		this.duracion = b;
		this.peso = c;
		this.valorGuia = guia;
	}
	
	public Flecha (int x1, int y1, int x2, int y2, Double distanciaAux, Double duracionAux, Double pesoAux, int guiaAux) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;		
		this.distancia = distanciaAux;
		this.duracion = duracionAux;
		this.peso = pesoAux;
		this.valorGuia = guiaAux;
		
		}
	
//	public void pintar(Graphics g) {
//		
//		((Graphics2D)g).setColor(Color.blue);
//		((Graphics2D)g).setStroke(new BasicStroke(1));
//		
//		g.drawLine(x1, y1, x2, y2);
//		
//
//		if(x1>x2 && y1>y2) {
//			g.drawString(nombreEnlace, x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));}
//		if(x1<x2 && y1<y2) {
//			g.drawString(nombreEnlace, x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));}
//		if(x1>x2 && y1<y2) {
//			g.drawString(nombreEnlace, x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));}
//		if(x1<x2 && y1>y2) {
//			g.drawString(nombreEnlace, x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));}
//	
//	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
		//ESTE METODO ME PONE UNA FLECHA
//	public void pintar(Graphics g) {
//	
//		((Graphics2D)g).setColor(Color.blue);
//		((Graphics2D)g).setStroke(new BasicStroke(2));
//		
//		g.drawLine(x1, y1, x2, y2);
//		
//		
//		if(x1>x2 && y1>y2) {
//			g.drawString(nombre, x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
//			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 15);}
//		
//		if(x1<x2 && y1<y2) {
//			g.drawString(nombre, x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
//			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 15);}
//		
//		if(x1>x2 && y1<y2) {
//			g.drawString(nombre, x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
//			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 15);}
//		
//		if(x1<x2 && y1>y2) {
//			g.drawString(nombre, x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
//			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 15);}
//	
//	}
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void pintar(Graphics g) {
		
		((Graphics2D)g).setColor(Color.blue);
		((Graphics2D)g).setStroke(new BasicStroke(2));
		String cadena = this.distancia+", "+ this.duracion+", " +this.peso;
		g.drawLine(x1, y1, x2, y2);
		
		
		if(x1>x2 && y1>y2) {
			g.drawString(cadena, x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 10);}
		
		if(x1<x2 && y1<y2) {
			g.drawString(cadena, x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 10);}
		
		if(x1>x2 && y1<y2) {
			g.drawString(cadena, x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 10);}
		
		if(x1<x2 && y1>y2) {
			g.drawString(cadena, x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.blue, 10);}
	
	}
	
	public void pintar2(Graphics g) {
		
		((Graphics2D)g).setColor(Color.orange);
		((Graphics2D)g).setStroke(new BasicStroke(2));
		String cadena = this.distancia+", "+ this.duracion+", " +this.peso;
		g.drawLine(x1, y1, x2, y2);
		
		
		if(x1>x2 && y1>y2) {
			g.drawString(cadena, x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.orange, 10);}
		
		if(x1<x2 && y1<y2) {
			g.drawString(cadena, x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.orange, 10);}
		
		if(x1>x2 && y1<y2) {
			g.drawString(cadena, x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.orange, 10);}
		
		if(x1<x2 && y1>y2) {
			g.drawString(cadena, x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
			drawArrowHead((Graphics2D) g, x1, y1, x2, y2, Color.orange, 10);}
	
	}
	
///////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////	
	
	public String getNombreFlecha() {
		return nombre;
	}

	public void setNombreFlecha(String nombreEnlace) {
		this.nombre = nombreEnlace;
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
	
    private void drawArrowHead(Graphics2D g2, int x1, int y1, int x2, int y2, Color color, int radio)
    {
    	double phi = Math.toRadians(20);
    	int barb = 15;
        g2.setPaint(color);
        double dy = y1 - y2;
        double dx = x1 - x2;
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = x1 - radio*Math.cos(theta) - barb * Math.cos(rho);
            y = y1 - radio*Math.sin(theta) - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(x1 - radio*Math.cos(theta), y1 - radio*Math.sin(theta), x, y));
            rho = theta - phi;
        }
    }

	
	
}
