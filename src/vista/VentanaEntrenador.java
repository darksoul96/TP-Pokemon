package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class VentanaEntrenador implements ActionListener, FocusListener {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textFieldNombreEntrenador;
	private JButton btnAceptarNuevoEntrenador;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEntrenador window = new VentanaEntrenador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaEntrenador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 271, 142);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new BorderLayout(0, 0));

		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_4 = new JPanel();
		this.panel.add(this.panel_4);

		this.lblNewLabel = new JLabel("Nombre Entrenador:");
		this.panel_4.add(this.lblNewLabel);

		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);

		this.textFieldNombreEntrenador = new JTextField();
		this.textFieldNombreEntrenador.addFocusListener(this);

		this.panel_1.add(this.textFieldNombreEntrenador);
		this.textFieldNombreEntrenador.setColumns(10);

		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);

		this.lblNewLabel_1 = new JLabel("");
		this.panel_2.add(this.lblNewLabel_1);

		this.panel_3 = new JPanel();
		this.panel.add(this.panel_3);

		this.btnAceptarNuevoEntrenador = new JButton("Aceptar");
		this.panel_3.add(this.btnAceptarNuevoEntrenador);
		this.btnAceptarNuevoEntrenador.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Aceptar")) {
			if (this.textFieldNombreEntrenador.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Nombre invalido", "Datos invalidos", JOptionPane.ERROR_MESSAGE);
			} else {
				//
			}
		}

	}

	public void focusGained(FocusEvent e) {

	}

	public void focusLost(FocusEvent e) {

	}
}
