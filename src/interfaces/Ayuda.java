package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import imagen.DiagramaDeClases;


public class Ayuda extends JFrame implements ActionListener{

	
	private JFrame ventana = new JFrame();
//	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	private JButton volver = new JButton("volver");
	private JPanel panelVolver = new JPanel();
	private JPanel panelAyuda = new JPanel();

	public Ayuda() throws IOException{
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Ayuda");
		JTabbedPane pestañas = new JTabbedPane();
		
        JPanel panel1 = new JPanel();
        File ficheroDestino1 = new File("Nuevo");
        InputStream inputStream1 = getClass().getResource("/ficheros/Funcion principal.txt").openStream();			
        OutputStream outputStream1 = new FileOutputStream(ficheroDestino1);
        byte[] b1 = new byte[2048];
        int longitud1;
        while ((longitud1 = inputStream1.read(b1)) != -1) {
           outputStream1.write(b1, 0, longitud1);
        }
        inputStream1.close();
        outputStream1.close();
        FileReader fr1 = new FileReader(ficheroDestino1);
        BufferedReader br1 = new BufferedReader(fr1);
        String linea1 = "";
        int numero1 = 1;
        String palabra1= "<html><body>";
        while((linea1 = br1.readLine()) != null){
        	palabra1 += linea1 + "<br>";
        }
        palabra1 += "</body></html>";
        JLabel ayuda1 = new JLabel(palabra1);
        panel1.add(ayuda1);
        fr1.close();
        pestañas.addTab("Función Principal", panel1);	
        
        ///////////////////////////////////////////////////////////////////////
        JPanel panel2=new JPanel();
        File ficheroDestino2 = new File("Enunciado");
        InputStream inputStream2 = getClass().getResource("/ficheros/Enunciado TP.txt").openStream();			
        OutputStream outputStream2 = new FileOutputStream(ficheroDestino2);
        byte[] b2 = new byte[2048];
        int longitud2;
        while ((longitud2 = inputStream2.read(b2)) != -1) {
           outputStream2.write(b2, 0, longitud2);
        }
        inputStream2.close();
        outputStream2.close();
        FileReader fr = new FileReader(ficheroDestino2);
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
        int numero = 1;
        String palabra= "<html><body>";
        while((linea = br.readLine()) != null){
        	palabra += linea + "<br>";
        }
        palabra += "</body></html>";
        JLabel ayuda = new JLabel(palabra);
        panel2.add(ayuda);
        fr.close();
        pestañas.addTab("Enunciado TP 2019", panel2);
        
        /////////////////////////////////////////////////////////////////////
        
        JPanel panel3=new JPanel();
//        PanelINICIO unPanel = new PanelINICIO();
        DiagramaDeClases unPanel = new DiagramaDeClases();
        pestañas.addTab("Diagrama de clases", unPanel);
        
        //////////////////////////////////////////////////////////////////////

        panelAyuda.add(pestañas);
        
        panelVolver.add(volver);
        JScrollPane barraPanel = new JScrollPane(panelAyuda);
        ventana.add(volver);
        ventana.add(barraPanel);
        
	    ventana.setSize(950, 700);
	    ventana.setLocationRelativeTo(null);
	    ventana.setVisible(true);
	    ventana.setResizable(false);
	    barraPanel.setBounds(10,10,800,650);
	    volver.setBounds(830, 350, 90, 35);
	    volver.addActionListener( this);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == volver){
			ventana.dispose();
				
			}
		}


		

}
