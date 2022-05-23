package model.vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import model.beans.Curso;
import model.beans.Materia;
import model.controladores.CursoControlador;
import model.controladores.MateriaControlador;

import javax.swing.JComboBox;

public class Ventana_Materia extends JPanel {

	
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private  JButton btnPrimero;
	private  JButton btnAnterior;
	private  JButton btnSiguiente;
	private  JButton btnUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private static Ventana_Materia instance = null;
	private JLabel lblAcronimo;
	private JTextField textFieldAcronimo;
	private JLabel lblCursoId;
	private JComboBox comboBoxCursoID;

	
	// Método que devuelve el singleton
			public static Ventana_Materia getInstance () {
				if (instance == null) {
					instance = new Ventana_Materia();
				}
				return instance;
			}

			public Ventana_Materia() {
				
				initialize();
				Materia cu = MateriaControlador.obtenerPrimero();
				//Y si existe establezco sus valores
				try {
					imprimir(cu);
					comprobarBotonesMateria(cu);
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
				//Obtengo el método de la clase Materia y obtengo el primer registro
				Materia cu = MateriaControlador.obtenerPrimero();
				//Y si existe establezco sus valores
				try {
					imprimir(cu);
					comprobarBotonesMateria(cu);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrimero.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Le paso al método de la clase de gestionMateria el parámetro del contenido que hay
				//dentro del textfield del id, y eso en el método se usará para realizar la consulta y 
				//devolver a este resulset, el resultado final, que será el id anterior al que había
				//dentro del textfield.
				Materia cu = MateriaControlador.obtenerAnterior(Integer.parseInt(textFieldID.getText()));
				try {
					imprimir(cu);
					comprobarBotonesMateria(cu);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAnterior.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/previous.png")));
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Lo mismo que el boton de anterior, pero ahora con la consulta al contrario, pero mismo
				//funcionamiento.
				Materia cu = MateriaControlador.obtenerSiguiente(Integer.parseInt(textFieldID.getText()));
				try {
					imprimir(cu);
					comprobarBotonesMateria(cu);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSiguiente.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/next.png")));
		toolBar.add(btnSiguiente);
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obtengo el método de la clase Materia y obtengo el último registro
				Materia cu = MateriaControlador.obtenerUltimo();
				
				//Y si existe establezco sus valores
				try {
					imprimir(cu);
					comprobarBotonesMateria(cu);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnUltimo.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/gotoend.png")));
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
		btnNuevo.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/nuevo.png")));
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
		btnGuardar.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		 btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					eliminarMateria();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(Ventana_Materia.class.getResource("/model/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		panel.add(lblID, gbc_lblID);
		
		textFieldID = new JTextField();
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 0;
		panel.add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 2;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblAcronimo = new JLabel("ACRÓNIMO:");
		lblAcronimo.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAcronimo = new GridBagConstraints();
		gbc_lblAcronimo.anchor = GridBagConstraints.EAST;
		gbc_lblAcronimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcronimo.gridx = 0;
		gbc_lblAcronimo.gridy = 4;
		panel.add(lblAcronimo, gbc_lblAcronimo);
		
		textFieldAcronimo = new JTextField();
		GridBagConstraints gbc_textFieldAcronimo = new GridBagConstraints();
		gbc_textFieldAcronimo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAcronimo.gridx = 1;
		gbc_textFieldAcronimo.gridy = 4;
		panel.add(textFieldAcronimo, gbc_textFieldAcronimo);
		textFieldAcronimo.setColumns(10);
		
		lblCursoId = new JLabel("CURSO ID:");
		lblCursoId.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCursoId = new GridBagConstraints();
		gbc_lblCursoId.anchor = GridBagConstraints.EAST;
		gbc_lblCursoId.insets = new Insets(0, 0, 0, 5);
		gbc_lblCursoId.gridx = 0;
		gbc_lblCursoId.gridy = 6;
		panel.add(lblCursoId, gbc_lblCursoId);
		
		comboBoxCursoID = new JComboBox();
		GridBagConstraints gbc_comboBoxCursoID = new GridBagConstraints();
		gbc_comboBoxCursoID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCursoID.gridx = 1;
		gbc_comboBoxCursoID.gridy = 6;
		panel.add(comboBoxCursoID, gbc_comboBoxCursoID);
		
		cargarValoresCursosEnJComboBox();

	}
	

	/**
	 * Método para comprobar mediante un vinculo con gestion de Materia, si al pulsar un boton,
	 * el registro está en el primer o último id, ir desactivando o activando la funcionalidad 
	 * de los botones.
	 */
	public void comprobarBotonesMateria (Materia ma) {
				if (ma != null) {
		
					// Ahora habilitamos o deshabilitamos botones de navegación
					// Si no existe un anterior deshabilito los botones de primero y anterior
					if (MateriaControlador.obtenerAnterior(ma.getId()) == null) {
						btnPrimero.setEnabled(false);
						btnAnterior.setEnabled(false);
					}
					else {
						btnPrimero.setEnabled(true);
						btnAnterior.setEnabled(true);
					}
					// Si no existe un siguiente deshabilito los botones de último y siguiente
					boolean existeSiguiente = 
							(MateriaControlador.obtenerSiguiente(ma.getId()) == null)? false : true;
					btnUltimo.setEnabled(existeSiguiente);
					btnSiguiente.setEnabled(existeSiguiente);
				}
		
	}
	
	/**
	 * Imprimo los valores del resulset genérico que me da los 3 datos necesarios
	 * de cada Materia
	 * @param rs
	 * @throws SQLException
	 */
	private void imprimir(Materia ma) throws SQLException {
		
			textFieldID.setText("" + ma.getId());
			textFieldNombre.setText(ma.getNombre());
			textFieldAcronimo.setText(ma.getAcronimo());
			seleccionarCursoEnJComboBox(ma.getCurso().getId());
	}
	
	/**
	 * Pongo en blanco todos los textfield y el de ID, lo pongo a 0
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public void borrarCampos() throws SQLException{
		textFieldID.setText("0");
		textFieldNombre.setText("");
		textFieldAcronimo.setText("");
		comboBoxCursoID.setSelectedIndex(-1);
	}
	
	/**
	 * Añado a un nuevo Materia los datos de lo que tenía en otro, esto es para que ambos
	 * punteros apunten a los mismos datos, y así al agregar un nuevo Materia, este aparezca
	 * de tirón con el último id posible, puesto que si no hago esto me saldría siempre con un 0.
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public void botonGuardar() throws SQLException{
		Materia ma = meterValoresaMateria();
		//Guardo el Materia
		MateriaControlador.guardarMateria(ma);
		//Pongo en el textfield de ID, el id que ha conseguido el frabicante de este método
		//en el método de la clase controlador
		textFieldID.setText("" + ma.getId());
		//Y muestro una vez terminado lo anterior, el último registro de la tabla Materia
		MateriaControlador.obtenerUltimo();
		//Hago la comprobación de los primeros botones para deshabilitar si es necesario
		comprobarBotonesMateria(ma);
	}
	
	
	/**
	 * Muestro mensaje en pantalla de un popup, para ofrecer si borrar o no un registro
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public void eliminarMateria() throws SQLException{
		String [] opciones ={"Si","No"};
		int eleccion = JOptionPane.showOptionDialog(null,"¿Quieres borrar un registro?","Borrar Registro",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
		if (eleccion == JOptionPane.YES_OPTION) {
			//Meto de nuevo en un Materia nuevo, los valores a los que estaba apuntado el Materia que introduzco
			//en este método(meterValoresMateria)
			Materia ma = meterValoresaMateria();
			//Borro los datos apuntados
			MateriaControlador.remove(ma);
			
			//Después de borrar el registro hago unas comprobaciones para saber si tiene
			//anterior o siguiente registro, si no tiene ninguno pongo los campos vacíos.
			if(MateriaControlador.obtenerAnterior( ma.getId())!=null) {
				ma = MateriaControlador.obtenerAnterior(ma.getId());
				imprimir(ma);
			}else if(MateriaControlador.obtenerSiguiente(ma.getId()) !=null){
				ma = MateriaControlador.obtenerSiguiente(ma.getId());
				imprimir(ma);
			}else {
				borrarCampos();
			}
			//compruebo la deshabilitación de los primeros botones
			comprobarBotonesMateria(ma);
		}
	}
	
	/**
	 * Únicamente meto en un Materia valores de los que se muestran en la ventana gráfica, y con esto
	 * uso este puntero hacia esos datos, para usarlo en otros métodos para lo que me pueda servir.
	 * @return
	 * @throws SQLException
	 * @throws ErrorBBDDException
	 */
	public Materia meterValoresaMateria()  throws SQLException{
		Materia ma = new Materia();
				ma.setId(Integer.parseInt(textFieldID.getText()));
				ma.setNombre(textFieldNombre.getText());
				ma.setAcronimo(textFieldAcronimo.getText());
				ma.setCurso(getIdCursoseleccionadoEnJComboBox());
		return ma;
	}
	
	private void cargarValoresCursosEnJComboBox () {
		// Cargamos valores dentro del combobox
		List<Curso> listaCursos = CursoControlador.listadoEntidadesSegundoMetodo();
		for (int i = 0; i < listaCursos.size(); i++) {
			comboBoxCursoID.addItem(listaCursos.get(i));
		}
	}
	
	/**
	 * Para seleccionar el id de Fabricante concreto que tiene cada Venta.
	 * @param idFabricante
	 */
	private void seleccionarCursoEnJComboBox (int idCurso) {
		for (int i = 0; i < comboBoxCursoID.getItemCount(); i++) {
			if ( ((Curso) comboBoxCursoID.getItemAt(i)).getId() == idCurso) {
				comboBoxCursoID.setSelectedIndex(i);
			}
		}
	}
	
	
	private Curso getIdCursoseleccionadoEnJComboBox () {
		return ((Curso) comboBoxCursoID.getSelectedItem());
	}

}
