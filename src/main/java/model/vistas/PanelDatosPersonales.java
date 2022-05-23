package model.vistas;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PanelDatosPersonales extends JPanel {
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldDNI;
	private JTextField textFieldDireccion;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	public JComboBox comboBoxSexo;
	public byte[] imagenEnArrayDeBytes;
	JPanel panel;
	public String color;
	JScrollPane scrollPane;
	JColorChooser jColorChooser;
	ImageIcon icono = new ImageIcon();
	private JTextField textFieldColor;
	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));
		
		 panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(20, 20, 5, 5);
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		panel.add(lblID, gbc_lblID);
		
		textFieldID = new JTextField();
		textFieldID.setEnabled(false);
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.insets = new Insets(20, 0, 5, 20);
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 0;
		panel.add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		scrollPane.setMinimumSize(new Dimension (100,100));
		scrollPane.setMaximumSize(new Dimension (100,100));
		scrollPane.setPreferredSize(new Dimension (100,100));
		panel.add(scrollPane, gbc_scrollPane);
		
		JLabel panelImagen = new JLabel("");
		panelImagen.setIcon(null);
		scrollPane.setViewportView(panelImagen);
		
		JLabel lblNOMBRE = new JLabel("NOMBRE:");
		lblNOMBRE.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNOMBRE = new GridBagConstraints();
		gbc_lblNOMBRE.anchor = GridBagConstraints.EAST;
		gbc_lblNOMBRE.insets = new Insets(0, 20, 5, 5);
		gbc_lblNOMBRE.gridx = 0;
		gbc_lblNOMBRE.gridy = 1;
		panel.add(lblNOMBRE, gbc_lblNOMBRE);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblAPELLIDO1 = new JLabel("APELLIDO 1:");
		lblAPELLIDO1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblAPELLIDO1 = new GridBagConstraints();
		gbc_lblAPELLIDO1.anchor = GridBagConstraints.EAST;
		gbc_lblAPELLIDO1.insets = new Insets(0, 20, 5, 5);
		gbc_lblAPELLIDO1.gridx = 0;
		gbc_lblAPELLIDO1.gridy = 2;
		panel.add(lblAPELLIDO1, gbc_lblAPELLIDO1);
		
		textFieldApellido1 = new JTextField();
		GridBagConstraints gbc_textFieldApellido1 = new GridBagConstraints();
		gbc_textFieldApellido1.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido1.gridx = 1;
		gbc_textFieldApellido1.gridy = 2;
		panel.add(textFieldApellido1, gbc_textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		JLabel lblAPELLIDO2 = new JLabel("APELLIDO 2:");
		lblAPELLIDO2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblAPELLIDO2 = new GridBagConstraints();
		gbc_lblAPELLIDO2.anchor = GridBagConstraints.EAST;
		gbc_lblAPELLIDO2.insets = new Insets(0, 20, 5, 5);
		gbc_lblAPELLIDO2.gridx = 0;
		gbc_lblAPELLIDO2.gridy = 3;
		panel.add(lblAPELLIDO2, gbc_lblAPELLIDO2);
		
		textFieldApellido2 = new JTextField();
		GridBagConstraints gbc_textFieldApellido2 = new GridBagConstraints();
		gbc_textFieldApellido2.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido2.gridx = 1;
		gbc_textFieldApellido2.gridy = 3;
		panel.add(textFieldApellido2, gbc_textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		JLabel lblSexo = new JLabel("SEXO:\r\n");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 20, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 4;
		panel.add(lblSexo, gbc_lblSexo);
		
		comboBoxSexo = new JComboBox();
		GridBagConstraints gbc_comboBoxSexo = new GridBagConstraints();
		gbc_comboBoxSexo.insets = new Insets(0, 0, 5, 20);
		gbc_comboBoxSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSexo.gridx = 1;
		gbc_comboBoxSexo.gridy = 4;
		panel.add(comboBoxSexo, gbc_comboBoxSexo);
		
		JLabel lblDNI = new JLabel("DNI:\r\n");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 20, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 5;
		panel.add(lblDNI, gbc_lblDNI);
		
		textFieldDNI = new JTextField();
		GridBagConstraints gbc_textFieldDNI = new GridBagConstraints();
		gbc_textFieldDNI.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDNI.gridx = 1;
		gbc_textFieldDNI.gridy = 5;
		panel.add(textFieldDNI, gbc_textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JButton btnNewButton = new JButton("Cargar Imagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagenParaPantalla();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 10);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblDIRECCION = new JLabel("DIRECCION:");
		lblDIRECCION.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblDIRECCION = new GridBagConstraints();
		gbc_lblDIRECCION.anchor = GridBagConstraints.EAST;
		gbc_lblDIRECCION.insets = new Insets(0, 20, 5, 5);
		gbc_lblDIRECCION.gridx = 0;
		gbc_lblDIRECCION.gridy = 6;
		panel.add(lblDIRECCION, gbc_lblDIRECCION);
		
		textFieldDireccion = new JTextField();
		GridBagConstraints gbc_textFieldDireccion = new GridBagConstraints();
		gbc_textFieldDireccion.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion.gridx = 1;
		gbc_textFieldDireccion.gridy = 6;
		panel.add(textFieldDireccion, gbc_textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblEMAIL = new JLabel("EMAIL:");
		lblEMAIL.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblEMAIL = new GridBagConstraints();
		gbc_lblEMAIL.anchor = GridBagConstraints.EAST;
		gbc_lblEMAIL.insets = new Insets(0, 20, 5, 5);
		gbc_lblEMAIL.gridx = 0;
		gbc_lblEMAIL.gridy = 7;
		panel.add(lblEMAIL, gbc_lblEMAIL);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 7;
		panel.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTELEFONO = new JLabel("TELEFONO:");
		lblTELEFONO.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTELEFONO = new GridBagConstraints();
		gbc_lblTELEFONO.anchor = GridBagConstraints.EAST;
		gbc_lblTELEFONO.insets = new Insets(0, 20, 5, 5);
		gbc_lblTELEFONO.gridx = 0;
		gbc_lblTELEFONO.gridy = 8;
		panel.add(lblTELEFONO, gbc_lblTELEFONO);
		
		textFieldTelefono = new JTextField();
		GridBagConstraints gbc_textFieldTelefono = new GridBagConstraints();
		gbc_textFieldTelefono.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono.gridx = 1;
		gbc_textFieldTelefono.gridy = 8;
		panel.add(textFieldTelefono, gbc_textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cargar Color");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 10);
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 8;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblColor = new JLabel("COLOR:");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 20, 0, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 9;
		panel.add(lblColor, gbc_lblColor);
		
		textFieldColor = new JTextField();
		GridBagConstraints gbc_textFieldColor = new GridBagConstraints();
		gbc_textFieldColor.insets = new Insets(0, 0, 5, 20);
		gbc_textFieldColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldColor.gridx = 1;
		gbc_textFieldColor.gridy = 9;
		panel.add(textFieldColor, gbc_textFieldColor);
		textFieldColor.setColumns(10);
		
		scrollPane.addMouseListener(new MouseAdapter() {
			 
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            /**
             * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
             * @param e
             */
            private void showPopup(MouseEvent e) {
        		JPopupMenu menu = new JPopupMenu();
        		
        		if(imagenEnArrayDeBytes != null) {
               		ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
           			menu.add(mostrarDimensiones("La imagen tiene unas dimensiones de:" + icono.getIconHeight() + "x" + icono.getIconWidth(), null));
       		}
        		menu.add(mostrarDimensiones("Guardar Imagen", new ActionListener() {

        			@Override
        			public void actionPerformed(ActionEvent e) {
        				seleccionaImagenParaPantalla();
        				
        			}
        			
        			
        		}));

        		if (e.isPopupTrigger()) {
                    menu.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
		
        });
	}
	
	private JMenuItem mostrarDimensiones (String titulo, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(actionListener);
        return item;
	}

	public String getTextFieldID() {
		return textFieldID.getText();
	}

	public void setTextFieldID(int id) {
		this.textFieldID.setText("" + id);
	}

	public String getTextFieldNombre() {
		return textFieldNombre.getText();
	}

	public void setTextFieldNombre(String nombre) {
		this.textFieldNombre.setText(nombre);
	}

	public String getTextFieldApellido1() {
		return textFieldApellido1.getText();
	}

	public void setTextFieldApellido1(String apellido1) {
		this.textFieldApellido1.setText(apellido1);
	}

	public String getTextFieldApellido2() {
		return textFieldApellido2.getText();
	}

	public void setTextFieldApellido2(String apellido2) {
		this.textFieldApellido2.setText(apellido2);
	}

	public String getTextFieldDNI() {
		return textFieldDNI.getText();
	}

	public void setTextFieldDNI(String dni) {
		this.textFieldDNI.setText(dni);
	}

	public String getTextFieldDireccion() {
		return textFieldDireccion.getText();
	}

	public void setTextFieldDireccion(String direccion) {
		this.textFieldDireccion.setText(direccion);
	}

	public String getTextFieldEmail() {
		return textFieldEmail.getText();
	}

	public void setTextFieldEmail(String email) {
		this.textFieldEmail.setText(email);
	}

	public String getTextFieldTelefono() {
		return textFieldTelefono.getText();
	}

	public void setTextFieldTelefono(String telefono) {
		this.textFieldTelefono.setText(telefono);
	}
	
	
	public String getColor() {
		return textFieldColor.getText();
	}

	public void setColor(String color) {
		if(color!= null && !color.equals("")) {
			this.panel.setBackground(Color.decode(color));
		}else {
			this.panel.setBackground(null);
			this.textFieldColor.setText("");
		}
		this.textFieldColor.setText(color);
	}
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.textFieldColor.setText(strColor);
			this.panel.setBackground(color);
		}
	}

	public byte[] getImagenEnArrayDeBytes() {
		return imagenEnArrayDeBytes;
	}

	public void setImagenEnArrayDeBytes(byte[] imagenEnArrayDeBytes) {
		this.imagenEnArrayDeBytes = imagenEnArrayDeBytes;
	
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
		
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
	}

//	public void cargarValoresTipologiaSexosEnJComboBox () {
//		// Cargamos valores dentro del combobox
//		List<TipologiaSexo> listaTipologiaSexos = Controlador_TipologiaSexo.obtenerTodosTipologiaSexos();
//		for (int i = 0; i < listaTipologiaSexos.size(); i++) {
//			comboBoxSexo.addItem(listaTipologiaSexos.get(i));
//		}
//	}
//	
//	/**
//	 * Para seleccionar el id de Fabricante concreto que tiene cada Venta.
//	 * @param idFabricante
//	 */
//	public void seleccionarTipologiaSexoEnJComboBox (int idTipologiaSexo) {
//		for (int i = 0; i < comboBoxSexo.getItemCount(); i++) {
//			if ( ((TipologiaSexo) comboBoxSexo.getItemAt(i)).getId() == idTipologiaSexo) {
//				comboBoxSexo.setSelectedIndex(i);
//			}
//		}
//	}
//	
//	
//	public int getIdTipologiaSexoseleccionadoEnJComboBox () {
//		return ((TipologiaSexo) comboBoxSexo.getSelectedItem()).getId();
//	}
	
	
	public void seleccionaImagenParaPantalla () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().endsWith(".jpg") || 
								f.getAbsolutePath().endsWith(".jpeg")|| 
								f.getAbsolutePath().endsWith(".png")|| 
								f.getAbsolutePath().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					 icono = new ImageIcon(imagenEnArrayDeBytes);
					if(icono.getIconHeight()>100 || icono.getIconWidth()>100) {
						JOptionPane.showMessageDialog(null, "Introduzca porfavor una imagen de 100x100");
					}else {
						setImagenEnArrayDeBytes(imagenEnArrayDeBytes);
					}
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	

}
