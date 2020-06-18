package vista;

import java.awt.BorderLayout;
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
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrueba extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelEntrenadoresPokemones;
	private JPanel panelMedio;
	private JPanel panelBatallas;
	private JPanel panelPokemones;
	private JPanel panelEntrenadores;
	private JScrollPane scrollPane;
	private JList listPokemones;
	private JLabel lblPokemones;
	private JScrollPane scrollPane_1;
	private JLabel lblEntrenadores;
	private JList listEntrenadores;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel;
	private JList listBatallas;
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
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane_3;
	private JList list;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 682);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		Dimension defaultSize = new Dimension(1030,682);
		
		this.contentPane.setMaximumSize(defaultSize);
		this.contentPane.setMinimumSize(defaultSize);

		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(0, 3, 0, 0));

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

		this.panel_1 = new JPanel();
		this.panelEtapaGrupos.add(this.panel_1, BorderLayout.CENTER);

		this.panelBotones = new JPanel();
		this.panelBotones
				.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelMedio.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(3, 0, 0, 0));

		this.panelBotonEntrenador = new JPanel();
		this.panelBotones.add(this.panelBotonEntrenador);
		this.panelBotonEntrenador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btnAgregarEntrenador = new JButton("Agregar Entrenador");
		this.btnAgregarEntrenador.addActionListener(this);
		this.panelBotonEntrenador.add(this.btnAgregarEntrenador);

		this.btnEliminarEntrenador = new JButton("Eliminar Entrenador");
		this.btnEliminarEntrenador.addActionListener(this);
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

		this.panelBatallas = new JPanel();
		this.panelCentral.add(this.panelBatallas);
		this.panelBatallas.setLayout(new BorderLayout(0, 0));

		this.scrollPane_2 = new JScrollPane();
		this.panelBatallas.add(this.scrollPane_2, BorderLayout.CENTER);

		this.lblNewLabel = new JLabel("Batallas");
		this.scrollPane_2.setColumnHeaderView(this.lblNewLabel);

		this.listBatallas = new JList();
		this.scrollPane_2.setViewportView(this.listBatallas);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Agregar Entrenador")) {
			VentanaEntrenador nwe = new VentanaEntrenador();
			nwe.NewScreen();
		}
	}
}
