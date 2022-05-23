package model.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.cacheyConexion.CacheImagenes;
import model.vistas.PanelAJDialog;
import model.vistas.Ventana_Curso;




public class BarraTareas extends JToolBar{
	
	private static final long serialVersionUID = 1L;

	public BarraTareas() {
		this.add(creaBoton("Cursos", "conectando.gif", "Cursos", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelAJDialog.meterPanelEnJDialog("JDialogCurso", new Ventana_Curso());
				
			}
		}));
		this.addSeparator();
//		this.add(creaBoton("Materias", "conectando.gif", "Materias", new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				PanelAJDialog.meterPanelEnJDialog("JDialogMateria", new Ventana_Materia());
//			}
//		}));
//		this.addSeparator();
//		this.add(creaBoton("Estudiantes", "conectando.gif", "Estudiantes", new ActionListener() {
//					
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				PanelAJDialog.meterPanelEnJDialog("JDialogEstudiante", new Ventana_Estudiante());
//			}
//		}));
//		this.addSeparator();
//		this.add(creaBoton("Profesores", "conectando.gif", "Profesores", new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				PanelAJDialog.meterPanelEnJDialog("JDialogProfesor", new Ventana_Profesor());
//			}
//		}));
//		this.addSeparator();
//		this.add(creaBoton("ValoracionMateria", "conectando.gif", "ValoracionMateria", new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				PanelAJDialog.meterPanelEnJDialog("JDialogValoracionMateria", new Ventana_ValoracionMateria());
//			}
//		}));
      
	}
	
	/**
	 * 
	 * @param titulo
	 * @param icono
	 * @return
	 */
	private JButton creaBoton(String titulo, String icono, String toolTip, ActionListener action) {
        JButton jbt = new JButton();
        
        jbt.setText(titulo);
        jbt.setToolTipText(toolTip);
        jbt.addActionListener(action);
        
        try {
        	jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));  
          } catch (Exception ex) {
        	  ex.printStackTrace();
          }
        return jbt;
	}

}
