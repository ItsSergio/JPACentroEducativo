package model.componentes;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.cacheyConexion.CacheImagenes;
import model.vistas.PanelAJDialog;
import model.vistas.Ventana_Curso;



public class Menu1 extends JMenuBar{

	public Menu1() {
		
		JMenu menuDeArchivo = new JMenu ("Menú de Gestión");
		menuDeArchivo.add(crearNuevoMenuItem("Cursos", "conectando.gif", KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelAJDialog.meterPanelEnJDialog("JDialogCurso", new Ventana_Curso());
				
			}
		}));
//		menuDeArchivo.add(crearNuevoMenuItem("Materias", "conectando.gif", KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PanelAJDialog.meterPanelEnJDialog("JDialogMateria", new Ventana_Materia());
//				
//			}
//		}));
//		menuDeArchivo.add(crearNuevoMenuItem("Estudiantes", "conectando.gif", KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), new ActionListener() {
//					
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PanelAJDialog.meterPanelEnJDialog("JDialogEstudiante", new Ventana_Estudiante());
//				
//			}
//		}));
//		menuDeArchivo.add(crearNuevoMenuItem("Profesores", "conectando.gif", KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PanelAJDialog.meterPanelEnJDialog("JDialogProfesor", new Ventana_Profesor());
//				
//			}
//		}));
//		menuDeArchivo.add(crearNuevoMenuItem("ValoracionMateria", "conectando.gif", KeyStroke.getKeyStroke(KeyEvent.VK_J, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PanelAJDialog.meterPanelEnJDialog("JDialogValoracionMateria", new Ventana_ValoracionMateria());
//				
//			}
//		}));
		
		
		this.add(menuDeArchivo);
	}
	
	/**
	 * Menú Item para salir de la aplicación
	 * @return
	 */
	public JMenuItem crearNuevoMenuItem (String titulo, String nombreIcono, KeyStroke atajoTeclado, ActionListener action) {
        JMenuItem item = new JMenuItem(titulo);
        item.setIcon(CacheImagenes.getCacheImagenes().getIcono(nombreIcono));
        item.setAccelerator(atajoTeclado);
        item.addActionListener(action);
        return item;
	}

}
