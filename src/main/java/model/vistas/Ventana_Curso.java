package model.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import model.beans.Curso;
import model.controladores.CursoControlador;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Curso extends JPanel {
	private JTextField textFieldID;
	private JTextField textFieldDESCRIPCION;
	private  JButton btnPrimero;
	private  JButton btnAnterior;
	private  JButton btnSiguiente;
	private  JButton btnUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private static Ventana_Curso instance = null;
	
	
	// Método que devuelve el singleton
			public static Ventana_Curso getInstance () {
				if (instance == null) {
					instance = new Ventana_Curso();
				}
				return instance;
			}

			public Ventana_Curso() {
				
				initialize();
				Curso cu = CursoControlador.obtenerPrimero();
				//Y si existe establezco sus valores
				try {
					imprimir(cu);
					comprobarBotonesCurso(cu);
					this.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
	public void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtengo el método de la clase Curso y obtengo el primer registro
				Curso cu = CursoControlador.obtenerPrimero();
				//Y si existe establezco sus valores
				try {
					imprimir(cu);
					comprobarBotonesCurso(cu);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrimero.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Le paso al método de la clase de gestionCurso el parámetro del contenido que hay
				//dentro del textfield del id, y eso en el método se usará para realizar la consulta y 
				//devolver a este resulset, el resultado final, que será el id anterior al que había
				//dentro del textfield.
				Curso cu = CursoControlador.obtenerAnterior(Integer.parseInt(textFieldID.getText()));
				try {
					imprimir(cu);
					comprobarBotonesCurso(cu);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAnterior.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/previous.png")));
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Lo mismo que el boton de anterior, pero ahora con la consulta al contrario, pero mismo
				//funcionamiento.
				Curso cu = CursoControlador.obtenerSiguiente(Integer.parseInt(textFieldID.getText()));
				try {
					imprimir(cu);
					comprobarBotonesCurso(cu);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSiguiente.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/next.png")));
		toolBar.add(btnSiguiente);
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obtengo el método de la clase Curso y obtengo el último registro
				Curso cu = CursoControlador.obtenerUltimo();
				
				//Y si existe establezco sus valores
				try {
					imprimir(cu);
					comprobarBotonesCurso(cu);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnUltimo.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					borrarCampos();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNuevo.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonGuardar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGuardar.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		 btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					eliminarCurso();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(Ventana_Curso.class.getResource("/model/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldID = new JTextField();
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 0;
		panel.add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DESCRIPCION:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldDESCRIPCION = new JTextField();
		GridBagConstraints gbc_textFieldDESCRIPCION = new GridBagConstraints();
		gbc_textFieldDESCRIPCION.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDESCRIPCION.gridx = 1;
		gbc_textFieldDESCRIPCION.gridy = 2;
		panel.add(textFieldDESCRIPCION, gbc_textFieldDESCRIPCION);
		textFieldDESCRIPCION.setColumns(10);

	}
	

	/**
	 * Método para comprobar mediante un vinculo con gestion de Curso, si al pulsar un boton,
	 * el registro está en el primer o último id, ir desactivando o activando la funcionalidad 
	 * de los botones.
	 */
	public void comprobarBotonesCurso (Curso cu) {
				if (cu != null) {
		
					// Ahora habilitamos o deshabilitamos botones de navegación
					// Si no existe un anterior deshabilito los botones de primero y anterior
					if (CursoControlador.obtenerAnterior(cu.getId()) == null) {
						btnPrimero.setEnabled(false);
						btnAnterior.setEnabled(false);
					}
					else {
						btnPrimero.setEnabled(true);
						btnAnterior.setEnabled(true);
					}
					// Si no existe un siguiente deshabilito los botones de último y siguiente
					boolean existeSiguiente = 
							(CursoControlador.obtenerSiguiente(cu.getId()) == null)? false : true;
					btnUltimo.setEnabled(existeSiguiente);
					btnSiguiente.setEnabled(existeSiguiente);
				}
		
	}
	
	/**
	 * Imprimo los valores del resulset genérico que me da los 3 datos necesarios
	 * de cada Curso
	 * @param rs
	 * @throws SQLException
	 */
	private void imprimir(Curso cu) throws SQLException {
			comprobarBotonesCurso(cu);
			textFieldID.setText("" + cu.getId());
			textFieldDESCRIPCION.setText(cu.getDescripcion());	
	}
	
	/**
	 * Pongo en blanco todos los textfield y el de ID, lo pongo a 0
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public void borrarCampos() throws SQLException{
		textFieldID.setText("0");
		textFieldDESCRIPCION.setText("");
	}
	
	/**
	 * Añado a un nuevo Curso los datos de lo que tenía en otro, esto es para que ambos
	 * punteros apunten a los mismos datos, y así al agregar un nuevo Curso, este aparezca
	 * de tirón con el último id posible, puesto que si no hago esto me saldría siempre con un 0.
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public void botonGuardar() throws SQLException{
		Curso cu = meterValoresaCurso();
		//Guardo el Curso
		CursoControlador.guardarCurso(cu);
		//Pongo en el textfield de ID, el id que ha conseguido el frabicante de este método
		//en el método de la clase controlador
		textFieldID.setText("" + cu.getId());
		//Y muestro una vez terminado lo anterior, el último registro de la tabla Curso
		CursoControlador.obtenerUltimo();
		//Hago la comprobación de los primeros botones para deshabilitar si es necesario
		comprobarBotonesCurso(cu);
	}
	
	
	/**
	 * Muestro mensaje en pantalla de un popup, para ofrecer si borrar o no un registro
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public void eliminarCurso() throws SQLException{
		String [] opciones ={"Si","No"};
		int eleccion = JOptionPane.showOptionDialog(null,"¿Quieres borrar un registro?","Borrar Registro",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
		if (eleccion == JOptionPane.YES_OPTION) {
			//Meto de nuevo en un Curso nuevo, los valores a los que estaba apuntado el Curso que introduzco
			//en este método(meterValoresCurso)
			Curso cu = meterValoresaCurso();
			//Borro los datos apuntados
			CursoControlador.remove(cu);
			
			//Después de borrar el registro hago unas comprobaciones para saber si tiene
			//anterior o siguiente registro, si no tiene ninguno pongo los campos vacíos.
			if(CursoControlador.obtenerAnterior( cu.getId())!=null) {
				cu = CursoControlador.obtenerAnterior(cu.getId());
				imprimir(cu);
			}else if(CursoControlador.obtenerSiguiente(cu.getId()) !=null){
				cu = CursoControlador.obtenerSiguiente(cu.getId());
				imprimir(cu);
			}else {
				borrarCampos();
			}
			//compruebo la deshabilitación de los primeros botones
			comprobarBotonesCurso(cu);
		}
	}
	
	/**
	 * Únicamente meto en un Curso valores de los que se muestran en la ventana gráfica, y con esto
	 * uso este puntero hacia esos datos, para usarlo en otros métodos para lo que me pueda servir.
	 * @return
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public Curso meterValoresaCurso()  throws SQLException{
		Curso cu = new Curso();
				cu.setId(Integer.parseInt(textFieldID.getText()));
				cu.setDescripcion(textFieldDESCRIPCION.getText());
		return cu;
	}

}
