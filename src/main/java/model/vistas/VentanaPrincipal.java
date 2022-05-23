package model.vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import model.componentes.BarraTareas;
import model.componentes.Menu1;


public class VentanaPrincipal  extends JFrame{

	public VentanaPrincipal() {
		super("Ventana de Sergio");
		this.setBounds(0, 0, 600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setJMenuBar(new Menu1());
		this.setLayout(new BorderLayout());
		this.add(new BarraTareas(), BorderLayout.NORTH);
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}

}
