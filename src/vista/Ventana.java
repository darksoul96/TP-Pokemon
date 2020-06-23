package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import personajes.Entrenador;
import personajes.Pokemon;

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
import java.util.Iterator;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;

public class Ventana extends JFrame implements IVista, MouseListener, KeyListener {
	
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelEntrenadoresPokemones;
	private JPanel panelMedio;
	private JPanel panelFaseBatalla;
	private JPanel panelPokemones;
	private JPanel panelEntrenadores;
	private JScrollPane scrollPane;
	private JList<Pokemon> listPokemones;
	private DefaultListModel<Pokemon> listModelPokemones = new DefaultListModel<Pokemon>();
	private JLabel lblPokemones;
	private JScrollPane scrollPane_1;
	private JLabel lblEntrenadores;
	private JList<Entrenador> listEntrenadores;
	private DefaultListModel<Entrenador> listModelEntrenadores = new DefaultListModel<Entrenador>();
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
	private JLabel lblEtapa;
	private JButton btnSiguienteEtapa;
	private JScrollPane scrollPane_3;
	private JList list;
	private JButton btnImportarEntrenadores;
	private JButton btnExportarEntrenadores;
	private JPanel panelCMPokemon;
	private JPanel panelCMEntrenador;
	private JLabel lblNewLabel;
	private JTextField textFieldNombreEntrenador;
	private JButton btnCrearE;
	private JButton btnModificarE;
	private JLabel lblNewLabel_2;
	private JTextField textFieldNombrePokemon;
	private JLabel lblNewLabel_3;
	private Choice choicePokemon;
	private Checkbox checkboxGranRecarga;
	private JButton btnModificarP;
	private JButton btnCrearP;
	private ActionListener actionListener;
	private JScrollPane scrollPaneFases;
	private JScrollPane scrollPaneBatallas;
	private JList listFases;
	private JList listBatallas;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 *//*
		 * public static void main(String[] args) { EventQueue.invokeLater(new
		 * Runnable() { public void run() { try { Ventana frame = new Ventana();
		 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
		 * }
		 * 
		 * /** Create the frame.
		 */
	public Ventana() {
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

		this.lblEtapa = new JLabel("Etapa:");
		this.lblEtapa.setBounds(69, 11, 32, 14);
		this.panel.add(this.lblEtapa);

		this.panel_2 = new JPanel();
		this.panelPasarEtapa.add(this.panel_2);
		this.panel_2.setLayout(null);

		this.btnSiguienteEtapa = new JButton("Siguiente etapa");
		this.btnSiguienteEtapa.setActionCommand("SIGUIENTE_ETAPA");
		this.btnSiguienteEtapa.setBounds(22, 11, 121, 28);
		this.panel_2.add(this.btnSiguienteEtapa);

		this.panelCM = new JPanel();
		this.panelEtapaGrupos.add(this.panelCM, BorderLayout.CENTER);
		this.panelCM.setLayout(new GridLayout(2, 1, 0, 0));

		this.panelCMEntrenador = new JPanel();
		this.panelCM.add(this.panelCMEntrenador);
		this.panelCMEntrenador.setLayout(null);

		this.lblNewLabel = new JLabel("Nombre Entrenador: ");
		this.lblNewLabel.setBounds(38, 44, 107, 14);
		this.panelCMEntrenador.add(this.lblNewLabel);

		this.textFieldNombreEntrenador = new JTextField();
		this.textFieldNombreEntrenador.setEditable(false);
		this.textFieldNombreEntrenador.addKeyListener(this);
		this.textFieldNombreEntrenador.setColumns(10);
		this.textFieldNombreEntrenador.setBounds(182, 43, 86, 20);
		this.panelCMEntrenador.add(this.textFieldNombreEntrenador);

		this.btnCrearE = new JButton("Crear");
		this.btnCrearE.setActionCommand("CREAR_ENTRENADOR");
		this.btnCrearE.setEnabled(false);
		this.btnCrearE.setBounds(182, 74, 89, 23);
		this.panelCMEntrenador.add(this.btnCrearE);

		this.btnModificarE = new JButton("Modificar");
		this.btnModificarE.addKeyListener(this);
		this.btnModificarE.setActionCommand("MODIFICAR_ENTRENADOR");
		this.btnModificarE.setEnabled(false);
		this.btnModificarE.setBounds(46, 76, 89, 23);
		this.panelCMEntrenador.add(this.btnModificarE);

		this.panelCMPokemon = new JPanel();
		this.panelCM.add(this.panelCMPokemon);
		this.panelCMPokemon.setLayout(null);

		this.lblNewLabel_2 = new JLabel("Nombre Pokemon:");
		this.lblNewLabel_2.setBounds(41, 11, 101, 14);
		this.panelCMPokemon.add(this.lblNewLabel_2);

		this.textFieldNombrePokemon = new JTextField();
		this.textFieldNombrePokemon.setEditable(false);
		this.textFieldNombrePokemon.setBounds(183, 8, 86, 20);
		this.panelCMPokemon.add(this.textFieldNombrePokemon);
		this.textFieldNombrePokemon.setColumns(10);

		this.lblNewLabel_3 = new JLabel("Tipo:");
		this.lblNewLabel_3.setBounds(65, 36, 46, 14);
		this.panelCMPokemon.add(this.lblNewLabel_3);

		this.choicePokemon = new Choice();
		this.choicePokemon.setEnabled(false);
		this.choicePokemon.setBounds(183, 34, 86, 20);
		this.panelCMPokemon.add(this.choicePokemon);

		this.checkboxGranRecarga = new Checkbox("Gran Recarga");
		this.checkboxGranRecarga.setEnabled(false);
		this.checkboxGranRecarga.setBounds(183, 60, 95, 22);
		this.panelCMPokemon.add(this.checkboxGranRecarga);

		this.btnModificarP = new JButton("Modificar");
		this.btnModificarP.setActionCommand("MODIFICAR_POKEMON");
		this.btnModificarP.addMouseListener(this);
		this.btnModificarP.setEnabled(false);
		this.btnModificarP.setBounds(39, 89, 89, 23);
		this.panelCMPokemon.add(this.btnModificarP);

		this.btnCrearP = new JButton("Crear");
		this.btnCrearP.setActionCommand("CREAR_POKEMON");
		this.btnCrearP.setEnabled(false);
		this.btnCrearP.setBounds(180, 88, 89, 23);
		this.panelCMPokemon.add(this.btnCrearP);

		this.panelBotones = new JPanel();
		this.panelBotones
				.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelMedio.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(3, 0, 0, 0));

		this.panelBotonEntrenador = new JPanel();
		this.panelBotones.add(this.panelBotonEntrenador);
		this.panelBotonEntrenador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btnAgregarEntrenador = new JButton("Agregar Entrenador");
		this.btnAgregarEntrenador.addKeyListener(this);
		this.btnAgregarEntrenador.setActionCommand("PRE_AGREGAR_ENTRENADOR");

		this.panelBotonEntrenador.add(this.btnAgregarEntrenador);

		this.btnEliminarEntrenador = new JButton("Eliminar Entrenador");
		this.btnEliminarEntrenador.setActionCommand("ELIMINAR_POKEMON");
		this.panelBotonEntrenador.add(this.btnEliminarEntrenador);

		this.btnModificarEntrenador = new JButton("Modificar Entrenador");
		this.btnModificarEntrenador.setActionCommand("PRE_MODIFICAR_ENTRENADOR");
		this.panelBotonEntrenador.add(this.btnModificarEntrenador);

		this.panelBotonPokemon = new JPanel();
		this.panelBotones.add(this.panelBotonPokemon);

		this.btnAgregarPokemon = new JButton("Agregar Pokemon");
		this.btnAgregarPokemon.setActionCommand("PRE_AGREGAR_POKEMON");
		this.panelBotonPokemon.add(this.btnAgregarPokemon);

		this.btnEliminarPokemon = new JButton("Eliminar Pokemon");
		this.btnEliminarPokemon.setActionCommand("ELIMINAR_POKEMON");
		this.panelBotonPokemon.add(this.btnEliminarPokemon);

		this.btnModificarPokemon = new JButton("Modificar Pokemon");
		this.btnModificarPokemon.setActionCommand("PRE_MODIFICAR_POKEMON");
		this.panelBotonPokemon.add(this.btnModificarPokemon);

		this.panelBotonOpciones = new JPanel();
		this.panelBotones.add(this.panelBotonOpciones);

		this.btnSortear = new JButton("Sortear");
		this.btnSortear.setActionCommand("SORTEAR");
		this.panelBotonOpciones.add(this.btnSortear);

		this.btnImportarEntrenadores = new JButton("Importar Entrenadores");
		this.btnImportarEntrenadores.setActionCommand("IMPORTAR_ENTRENADORES");
		this.panelBotonOpciones.add(this.btnImportarEntrenadores);

		this.btnExportarEntrenadores = new JButton("Exportar entrenadores");
		this.btnExportarEntrenadores.setActionCommand("EXPORTAR_ENTRENADORES");
		this.panelBotonOpciones.add(this.btnExportarEntrenadores);
//
		this.panelFaseBatalla = new JPanel();
		this.panelCentral.add(this.panelFaseBatalla);
		this.panelFaseBatalla.setLayout(new GridLayout(2, 1, 0, 0));

		this.scrollPaneFases = new JScrollPane();
		this.panelFaseBatalla.add(this.scrollPaneFases);

		this.listFases = new JList();
		this.listFases.setEnabled(false);
		this.scrollPaneFases.setViewportView(this.listFases);

		this.lblNewLabel_1 = new JLabel("Fases:");
		this.scrollPaneFases.setColumnHeaderView(this.lblNewLabel_1);

		this.scrollPaneBatallas = new JScrollPane();
		this.panelFaseBatalla.add(this.scrollPaneBatallas);

		this.listBatallas = new JList();
		this.listBatallas.setEnabled(false);
		this.scrollPaneBatallas.setViewportView(this.listBatallas);

		this.lblNewLabel_4 = new JLabel("Batallas");
		this.scrollPaneBatallas.setColumnHeaderView(this.lblNewLabel_4);

		this.panelSur = new JPanel();
		this.panelSur.setBackground(Color.WHITE);
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		this.panelSur.setPreferredSize(new Dimension(50, 50));
		this.panelSur.setLayout(new BorderLayout(0, 0));

		this.scrollPane_3 = new JScrollPane();
		this.panelSur.add(this.scrollPane_3, BorderLayout.CENTER);

		this.list = new JList();
		this.scrollPane_3.setViewportView(this.list);

		this.listEntrenadores.setModel(listModelEntrenadores);
		this.listPokemones.setModel(listModelPokemones);

		this.setVisible(true);
		// this.btnNewButton.setVisible(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.actionListener = actionListener;
		this.btnAgregarEntrenador.addActionListener(actionListener);
		this.btnAgregarPokemon.addActionListener(actionListener);
		this.btnCrearE.addActionListener(actionListener);
		this.btnCrearP.addActionListener(actionListener);
		this.btnEliminarEntrenador.addActionListener(actionListener);
		this.btnEliminarPokemon.addActionListener(actionListener);
		this.btnExportarEntrenadores.addActionListener(actionListener);
		this.btnImportarEntrenadores.addActionListener(actionListener);
		this.btnModificarE.addActionListener(actionListener);
		this.btnModificarEntrenador.addActionListener(actionListener);
		this.btnModificarP.addActionListener(actionListener);
		this.btnModificarPokemon.addActionListener(actionListener);
		this.btnSiguienteEtapa.addActionListener(actionListener);
		this.btnSortear.addActionListener(actionListener);

	}

	@Override
	public void sortear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarEntrenador() {
		this.textFieldNombreEntrenador.setEditable(true);
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

	@Override
	public String getNombreEntrenador() {
		// TODO Auto-generated method stub
		return this.textFieldNombreEntrenador.getText();
	}

	@Override
	public String getNombrePokemon() {
		// TODO Auto-generated method stub
		return this.textFieldNombrePokemon.getText();
	}

	@Override
	public boolean getGranRecarga() {
		// TODO Auto-generated method stub
		return this.checkboxGranRecarga.getState();
	}

	@Override
	public String crearEntrenador() {
		// TODO Auto-generated method stub
		return null;
	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {
		if (!this.textFieldNombreEntrenador.getText().equals("")) {
			this.btnCrearE.setEnabled(true);
		} else if (this.listEntrenadores.getComponentCount() != 0) {
			this.btnModificarE.setEnabled(true);
		}
	}

	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void actualizarListaEntrenador(Iterator<Entrenador> it) {
		// TODO Auto-generated method stub
		this.listModelEntrenadores.clear();
		while (it.hasNext()) {
				this.listModelEntrenadores.addElement(it.next());
		}
		this.repaint();
	}

}
