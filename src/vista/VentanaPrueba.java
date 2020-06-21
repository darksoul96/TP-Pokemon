package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.Checkbox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class VentanaPrueba extends JFrame implements IVista, MouseListener {

	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelEntrenadoresPokemones;
	private JPanel panelMedio;
	private JPanel panelCreacionModificacion;
	private JPanel panelPokemones;
	private JPanel panelEntrenadores;
	private JScrollPane scrollPane;
	private JList listPokemones;
	private JLabel lblPokemones;
	private JScrollPane scrollPane_1;
	private JLabel lblEntrenadores;
	private JList listEntrenadores;
	private JPanel panelSur;
	private JPanel panelBotones;
	private JPanel panelEtapaGrupos;
	private JPanel panelPasarEtapa;
	private JPanel panelBotonPokemon;
	private JPanel panelBotonEntrenador;
	private JPanel panelBotonOpciones;
	private JButton btnAgregarEntrenador;
	private JButton btnEliminarEntrenador;
	private JButton btnModificarEntrenador;
	private JButton btnAgregarPokemon;
	private JButton btnEliminarPokemon;
	private JButton btnModificarPokemon;
	private JButton btnSortear;
	private JPanel panelCM;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane_3;
	private JList list;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panelCMPokemon;
	private JPanel panelCMEntrenador;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private Choice choice;
	private Checkbox checkbox;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrueba() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 682);
		// setBounds(100, 100, 832, 741);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		Dimension defaultSize = new Dimension(1030, 682);

		this.contentPane.setMaximumSize(defaultSize);
		this.contentPane.setMinimumSize(defaultSize);

		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(0, 3, 0, 0)); // columnas central

		this.panelEntrenadoresPokemones = new JPanel();
		this.panelCentral.add(this.panelEntrenadoresPokemones);
		this.panelEntrenadoresPokemones.setLayout(new GridLayout(2, 0, 0, 0));

		this.panelEntrenadores = new JPanel();
		this.panelEntrenadoresPokemones.add(this.panelEntrenadores);
		this.panelEntrenadores.setLayout(new BorderLayout(0, 0));

		this.scrollPane_1 = new JScrollPane();
		this.panelEntrenadores.add(this.scrollPane_1, BorderLayout.CENTER);

		this.lblEntrenadores = new JLabel("Entrenadores");
		this.scrollPane_1.setColumnHeaderView(this.lblEntrenadores);

		this.listEntrenadores = new JList();
		this.scrollPane_1.setViewportView(this.listEntrenadores);

		this.panelPokemones = new JPanel();
		this.panelEntrenadoresPokemones.add(this.panelPokemones);
		this.panelPokemones.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panelPokemones.add(this.scrollPane, BorderLayout.CENTER);

		this.listPokemones = new JList();
		this.scrollPane.setViewportView(this.listPokemones);

		this.lblPokemones = new JLabel("Pokemones");
		this.scrollPane.setColumnHeaderView(this.lblPokemones);

		this.panelMedio = new JPanel();
		this.panelCentral.add(this.panelMedio);
		this.panelMedio.setLayout(new GridLayout(2, 0, 0, 0));

		this.panelEtapaGrupos = new JPanel();
		this.panelMedio.add(this.panelEtapaGrupos);
		this.panelEtapaGrupos.setLayout(new BorderLayout(0, 0));

		this.panelPasarEtapa = new JPanel();
		this.panelPasarEtapa.setBackground(Color.WHITE);
		this.panelEtapaGrupos.add(this.panelPasarEtapa, BorderLayout.NORTH);
		this.panelPasarEtapa.setLayout(new GridLayout(0, 2, 0, 0));
		this.panelPasarEtapa.setPreferredSize(new Dimension(50, 50));

		this.panel = new JPanel();
		this.panelPasarEtapa.add(this.panel);
		this.panel.setLayout(null);

		this.lblNewLabel_1 = new JLabel("Etapa:");
		this.lblNewLabel_1.setBounds(69, 11, 32, 14);
		this.panel.add(this.lblNewLabel_1);

		this.panel_2 = new JPanel();
		this.panelPasarEtapa.add(this.panel_2);
		this.panel_2.setLayout(null);

		this.btnNewButton = new JButton("Siguiente etapa");
		this.btnNewButton.setBounds(22, 11, 121, 28);
		this.panel_2.add(this.btnNewButton);

		this.panelCM = new JPanel();
		this.panelEtapaGrupos.add(this.panelCM, BorderLayout.CENTER);
		this.panelCM.setLayout(new GridLayout(2, 1, 0, 0));

		this.panelCMEntrenador = new JPanel();
		this.panelCM.add(this.panelCMEntrenador);
		this.panelCMEntrenador.setLayout(null);

		this.lblNewLabel = new JLabel("Nombre Entrenador: ");
		this.lblNewLabel.setBounds(38, 44, 107, 14);
		this.panelCMEntrenador.add(this.lblNewLabel);

		this.textField = new JTextField();
		this.textField.setEditable(false);
		this.textField.setColumns(10);
		this.textField.setBounds(182, 43, 86, 20);
		this.panelCMEntrenador.add(this.textField);

		this.btnNewButton_3 = new JButton("Crear");
		this.btnNewButton_3.setEnabled(false);
		this.btnNewButton_3.setBounds(179, 75, 89, 23);
		this.panelCMEntrenador.add(this.btnNewButton_3);

		this.btnNewButton_4 = new JButton("Modificar");
		this.btnNewButton_4.setEnabled(false);
		this.btnNewButton_4.setBounds(46, 76, 89, 23);
		this.panelCMEntrenador.add(this.btnNewButton_4);

		this.panelCMPokemon = new JPanel();
		this.panelCM.add(this.panelCMPokemon);
		this.panelCMPokemon.setLayout(null);

		this.lblNewLabel_2 = new JLabel("Nombre Pokemon:");
		this.lblNewLabel_2.setBounds(41, 11, 101, 14);
		this.panelCMPokemon.add(this.lblNewLabel_2);

		this.textField_1 = new JTextField();
		this.textField_1.setEditable(false);
		this.textField_1.setBounds(183, 8, 86, 20);
		this.panelCMPokemon.add(this.textField_1);
		this.textField_1.setColumns(10);

		this.lblNewLabel_3 = new JLabel("Tipo:");
		this.lblNewLabel_3.setBounds(65, 36, 46, 14);
		this.panelCMPokemon.add(this.lblNewLabel_3);

		this.choice = new Choice();
		this.choice.setEnabled(false);
		this.choice.setBounds(183, 34, 86, 20);
		this.panelCMPokemon.add(this.choice);

		this.checkbox = new Checkbox("Gran Recarga");
		this.checkbox.setEnabled(false);
		this.checkbox.setBounds(183, 60, 95, 22);
		this.panelCMPokemon.add(this.checkbox);

		this.btnNewButton_5 = new JButton("Modificar");
		this.btnNewButton_5.addMouseListener(this);
		this.btnNewButton_5.setEnabled(false);
		this.btnNewButton_5.setBounds(39, 89, 89, 23);
		this.panelCMPokemon.add(this.btnNewButton_5);

		this.btnNewButton_6 = new JButton("Crear");
		this.btnNewButton_6.setEnabled(false);
		this.btnNewButton_6.setBounds(180, 88, 89, 23);
		this.panelCMPokemon.add(this.btnNewButton_6);

		this.panelBotones = new JPanel();
		this.panelBotones
				.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelMedio.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(3, 0, 0, 0));

		this.panelBotonEntrenador = new JPanel();
		this.panelBotones.add(this.panelBotonEntrenador);
		this.panelBotonEntrenador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btnAgregarEntrenador = new JButton("Agregar Entrenador");

		this.panelBotonEntrenador.add(this.btnAgregarEntrenador);

		this.btnEliminarEntrenador = new JButton("Eliminar Entrenador");
		this.panelBotonEntrenador.add(this.btnEliminarEntrenador);

		this.btnModificarEntrenador = new JButton("Modificar Entrenador");
		this.panelBotonEntrenador.add(this.btnModificarEntrenador);

		this.panelBotonPokemon = new JPanel();
		this.panelBotones.add(this.panelBotonPokemon);

		this.btnAgregarPokemon = new JButton("Agregar Pokemon");
		this.panelBotonPokemon.add(this.btnAgregarPokemon);

		this.btnEliminarPokemon = new JButton("Eliminar Pokemon");
		this.panelBotonPokemon.add(this.btnEliminarPokemon);

		this.btnModificarPokemon = new JButton("Modificar Pokemon");
		this.panelBotonPokemon.add(this.btnModificarPokemon);

		this.panelBotonOpciones = new JPanel();
		this.panelBotones.add(this.panelBotonOpciones);

		this.btnSortear = new JButton("Sortear");
		this.panelBotonOpciones.add(this.btnSortear);

		this.btnNewButton_1 = new JButton("Importar Entrenadores");
		this.panelBotonOpciones.add(this.btnNewButton_1);

		this.btnNewButton_2 = new JButton("Exportar entrenadores");
		this.panelBotonOpciones.add(this.btnNewButton_2);
//
		this.panelCreacionModificacion = new JPanel();
		this.panelCentral.add(this.panelCreacionModificacion);
		this.panelCreacionModificacion.setLayout(new GridLayout(2, 1, 0, 0));

		this.panelSur = new JPanel();
		this.panelSur.setBackground(Color.WHITE);
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setPreferredSize(new Dimension(50, 50));
		this.panelSur.setLayout(new BorderLayout(0, 0));

		this.scrollPane_3 = new JScrollPane();
		this.panelSur.add(this.scrollPane_3, BorderLayout.CENTER);

		this.list = new JList();
		this.scrollPane_3.setViewportView(this.list);

		// this.btnNewButton.setVisible(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sortear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarEntrenador() {
		// TODO Auto-generated method stub

	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
}
