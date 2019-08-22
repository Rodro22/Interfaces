package graficos;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

public class LienzoAux extends JPanel implements MouseListener, MouseMotionListener {
	
	private Vector<Circulo> vectorCirculos;
	private Vector<Flecha> vectorFlechas;
	private Point p1, p2;
	//Mover los elementos
	private Circulo CirculoMover;
	private int iCirculo;
	
	
	public LienzoAux() {
		this.vectorCirculos = new Vector<>();
		this.vectorFlechas = new Vector<>();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		}
	
	//
	//
	//Con este metodo puedo inicializar la ventana con Circulos ya creados
	public LienzoAux(Vector<Circulo> listaCirculos) {
		this.vectorCirculos = new Vector<>();
		vectorCirculos = listaCirculos;
	}
	
	//Con este metodo inicializo el grafo completo
	public LienzoAux(Vector<Circulo> listaCirculos, Vector<Flecha> listaFlechas) {
		this.vectorCirculos = new Vector<>();
		vectorCirculos = listaCirculos;
		this.vectorFlechas = new Vector<>();
		vectorFlechas = listaFlechas;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
	}

	
	@Override
	public void paint(Graphics g) {
		//refresca de manera optima cada vez que pintamos en nuestro lienzo
		super.paint(g);
		for(Circulo Circulos : vectorCirculos) {
			
			if(Circulos.idInsumo == 0) { 
					Circulos.pintar(g);
				}
			else if ((Circulos.idInsumo == 1)){
					Circulos.pintar2(g);
			}
			for(Flecha Flecha : vectorFlechas) {
				if(Flecha.valorGuia == 0) {
				Flecha.pintar(g);		
				}else if (Flecha.valorGuia == 1) {
					Flecha.pintar2(g);
				}
			}
		}
									
	}
	


	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//Nos ayuda a detectar cuando presionamos un boton
		int iN = 0;
		for(Circulo Circulo : vectorCirculos) {
			if(new Rectangle(Circulo.getX() - Circulo.d/2, Circulo.getY() - Circulo.d/2, Circulo.d, Circulo.d).contains( e.getPoint() ) ) {
				CirculoMover = Circulo;
				iCirculo = iN;
				break;
			}
			iN++;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Devolvemos todo a sus valores iniciales
		CirculoMover = null;
		iCirculo = -1;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//Nos ayuda a detectar cada vez que arrastremos el mouse
		if(CirculoMover != null) {
			this.vectorCirculos.set(iCirculo, new Circulo( e.getX(), e.getY(), CirculoMover.getNombreCirculo(), CirculoMover.idInsumo ));
			int iE = 0;
			for(Flecha Flecha : vectorFlechas){
				if(new Rectangle(Flecha.getX1() - Circulo.d/2, Flecha.getY1() - Circulo.d/2, Circulo.d, Circulo.d ).contains(e.getPoint())) {
					this.vectorFlechas.set(iE, new Flecha(e.getX(), e.getY(), Flecha.getX2(), Flecha.getY2(), Flecha.distancia, Flecha.duracion, Flecha.peso, Flecha.valorGuia));
				}
				else if(new Rectangle(Flecha.getX2() - Circulo.d/2, Flecha.getY2() - Circulo.d/2, Circulo.d, Circulo.d ).contains(e.getPoint())) {
					this.vectorFlechas.set(iE, new Flecha(Flecha.getX1(), Flecha.getY1(), e.getX(), e.getY(), Flecha.distancia, Flecha.duracion, Flecha.peso, Flecha.valorGuia));
				}
				iE++;
			}
		}
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Con este metodo voy a evitar que se superpongan
	private boolean isEncima(Point p) {
		Rectangle figura = new Rectangle(p.x - Circulo.d/2, p.y - Circulo.d/2, 100, 100);
		for(Circulo N : vectorCirculos) {
			if(new Rectangle(N.getX() - Circulo.d/2, N.getY() - Circulo.d/2, 100, 100).intersects(figura)) {
				return false;
			}
		}
		return true;
	}
	public void estoNecesito(MouseEvent e) {
		if(isEncima(e.getPoint())) {
			vectorCirculos.add(new Circulo(e.getX(), e.getY()));
			repaint();
		}
	}
	
	
	
	
}
