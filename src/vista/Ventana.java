package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import modelo.Enfrentamiento;
import modelo.Grupo;
import personajes.Entrenador;
import personajes.Pokemon;
import personajes.PokemonFactory;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Choice;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Checkbox;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;
import javax.swing.JComboBox;

public class Ventana extends JFrame implements IVista, MouseListener, KeyListener, ActionListener {

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
	private DefaultListModel<Entrenador> dlm;
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
	private JPanel panelCM;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNumeroDeParticipantes;
	private JButton btnSiguienteEtapa;
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
	private JScrollPane scrollPaneBatallas;
	private JList listBatallas;
	private JLabel lblNewLabel_4;
	private JPanel panelPanelArenas;
	private JButton btnArena1;
	private JButton[] arenas;
	private JButton btnExportarFase;
	private JButton btnImportarFase;
	private JPanel panelDerecho;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_1;
	private JList listBatalla;
	private JPanel panelBatalla;
	private JPanel[] grupos;
	private JButton btnSortear;
	private JButton btnIniciar;
	private JComboBox comboParticipantes;
	private PanelFaseEliminatoria fase;
	private DefaultListModel modelBatallas = new DefaultListModel();

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
		setBounds(100, 100, 692, 682);
		// setBounds(100, 100, 832, 741);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		Dimension defaultSize = new Dimension(1030, 682);

		this.contentPane.setMaximumSize(defaultSize);
		this.contentPane.setMinimumSize(defaultSize);
		this.contentPane.setLayout(null);

		this.panelCentral = new JPanel();
		this.panelCentral.setBounds(5, 5, 676, 573);
		this.contentPane.add(this.panelCentral);
		this.panelCentral.setLayout(null);

		this.panelEntrenadoresPokemones = new JPanel();
		this.panelEntrenadoresPokemones.setLocation(0, 0);
		this.panelEntrenadoresPokemones.setSize(new Dimension(206, 573));
		this.panelEntrenadoresPokemones.setMaximumSize(new Dimension(100, 32767));
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
		this.listEntrenadores.addMouseListener(this);

		this.scrollPane_1.setViewportView(this.listEntrenadores);

		this.scrollPane_1.setPreferredSize(new Dimension(this.scrollPane_1.getWidth(), this.scrollPane_1.getHeight()));
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
		this.panelMedio.setBounds(216, 0, 460, 573);
		this.panelCentral.add(this.panelMedio);
		this.panelMedio.setLayout(new GridLayout(2, 0, 0, 0));

		this.panelEtapaGrupos = new JPanel();
		this.panelMedio.add(this.panelEtapaGrupos);
		this.panelEtapaGrupos.setLayout(null);

		this.panelPasarEtapa = new JPanel();
		this.panelPasarEtapa.setBounds(0, 0, 460, 50);
		this.panelPasarEtapa.setBackground(Color.WHITE);
		this.panelEtapaGrupos.add(this.panelPasarEtapa);
		this.panelPasarEtapa.setLayout(new GridLayout(0, 2, 0, 0));
		this.panelPasarEtapa.setPreferredSize(new Dimension(50, 50));

		this.panel = new JPanel();
		this.panelPasarEtapa.add(this.panel);
		this.panel.setLayout(null);

		this.lblNumeroDeParticipantes = new JLabel("Participantes:");
		this.lblNumeroDeParticipantes.setToolTipText("Cantidad de participantes");
		this.lblNumeroDeParticipantes.setBounds(24, 11, 120, 14);
		this.panel.add(this.lblNumeroDeParticipantes);

		this.comboParticipantes = new JComboBox();
		this.lblNumeroDeParticipantes.setLabelFor(this.comboParticipantes);
		this.comboParticipantes.setBounds(116, 8, 53, 20);
		this.panel.add(this.comboParticipantes);
		this.comboParticipantes.addItem("8");
		this.comboParticipantes.addItem("16");
		this.comboParticipantes.addItem("32");

		this.panel_2 = new JPanel();
		this.panelPasarEtapa.add(this.panel_2);
		this.panel_2.setLayout(null);

		this.btnSiguienteEtapa = new JButton("Siguiente etapa");
		this.btnSiguienteEtapa.setActionCommand("SIGUIENTE_ETAPA");
		this.btnSiguienteEtapa.setBounds(37, 11, 138, 28);
		this.panel_2.add(this.btnSiguienteEtapa);

		this.panelCM = new JPanel();
		this.panelCM.setBounds(0, 50, 460, 236);
		this.panelEtapaGrupos.add(this.panelCM);
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
		this.textFieldNombrePokemon.addKeyListener(this);
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

		this.checkboxGranRecarga = new Checkbox("Recarga");
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
		this.btnCrearP.addActionListener(this);
		this.btnCrearP.setActionCommand("CREAR_POKEMON");
		this.btnCrearP.setEnabled(false);
		this.btnCrearP.setBounds(180, 88, 89, 23);
		this.panelCMPokemon.add(this.btnCrearP);

		this.panelBotones = new JPanel();
		this.panelBotones
				.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelMedio.add(this.panelBotones);
		this.panelBotones.setLayout(null);

		this.panelBotonEntrenador = new JPanel();
		this.panelBotonEntrenador.setBounds(6, 17, 448, 87);
		this.panelBotones.add(this.panelBotonEntrenador);
		this.panelBotonEntrenador.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btnAgregarEntrenador = new JButton("Agregar Entrenador");
		this.btnAgregarEntrenador.addActionListener(this);
		this.btnAgregarEntrenador.addKeyListener(this);
		this.btnAgregarEntrenador.setActionCommand("PRE_AGREGAR_ENTRENADOR");

		this.panelBotonEntrenador.add(this.btnAgregarEntrenador);

		this.btnEliminarEntrenador = new JButton("Eliminar Entrenador");
		this.btnEliminarEntrenador.setActionCommand("ELIMINAR_ENTRENADOR");
		this.panelBotonEntrenador.add(this.btnEliminarEntrenador);

		this.btnModificarEntrenador = new JButton("Modificar Entrenador");
		this.btnModificarEntrenador.addActionListener(this);
		this.btnModificarEntrenador.setActionCommand("PRE_MODIFICAR_ENTRENADOR");
		this.panelBotonEntrenador.add(this.btnModificarEntrenador);

		this.panelBotonPokemon = new JPanel();
		this.panelBotonPokemon.setBounds(6, 104, 448, 87);
		this.panelBotones.add(this.panelBotonPokemon);

		this.btnAgregarPokemon = new JButton("Agregar Pokemon");
		this.btnAgregarPokemon.addActionListener(this);
		this.btnAgregarPokemon.setActionCommand("PRE_AGREGAR_POKEMON");
		this.panelBotonPokemon.add(this.btnAgregarPokemon);

		this.btnEliminarPokemon = new JButton("Eliminar Pokemon");
		this.btnEliminarPokemon.setActionCommand("ELIMINAR_POKEMON");
		this.panelBotonPokemon.add(this.btnEliminarPokemon);

		this.btnModificarPokemon = new JButton("Modificar Pokemon");
		this.btnModificarPokemon.setActionCommand("PRE_MODIFICAR_POKEMON");
		this.panelBotonPokemon.add(this.btnModificarPokemon);

		this.panelBotonOpciones = new JPanel();
		this.panelBotonOpciones.setBounds(6, 191, 448, 87);
		this.panelBotones.add(this.panelBotonOpciones);

		this.btnImportarEntrenadores = new JButton("Importar Entrenadores");
		this.btnImportarEntrenadores.addActionListener(this);
		this.btnImportarEntrenadores.setActionCommand("IMPORTAR_ENTRENADORES");
		this.panelBotonOpciones.add(this.btnImportarEntrenadores);

		this.btnExportarEntrenadores = new JButton("Exportar entrenadores");
		this.btnExportarEntrenadores.addActionListener(this);
		this.btnExportarEntrenadores.setActionCommand("EXPORTAR_ENTRENADORES");
		this.panelBotonOpciones.add(this.btnExportarEntrenadores);

		this.btnImportarFase = new JButton("Importar Fase");
		this.btnImportarFase.addActionListener(this);
		this.btnImportarFase.setActionCommand("IMPORTAR_FASE");
		this.panelBotonOpciones.add(this.btnImportarFase);

		this.btnExportarFase = new JButton("Exportar Fase");
		this.btnExportarFase.addActionListener(this);
		this.panelBotonOpciones.add(this.btnExportarFase);

		this.panelSur = new JPanel();
		this.panelSur.setBounds(5, 578, 1014, 70);
		this.panelSur.setBackground(Color.WHITE);
		this.contentPane.add(this.panelSur);
		this.panelSur.setPreferredSize(new Dimension(50, 70));
		this.panelSur.setLayout(null);

		this.panelPanelArenas = new JPanel();
		this.panelPanelArenas.setPreferredSize(new Dimension(37000, 10));
		this.panelPanelArenas.setBounds(0, 0, 1014, 70);
		this.panelSur.add(this.panelPanelArenas);
		this.panelPanelArenas.setLayout(null);

		this.listEntrenadores.setModel(listModelEntrenadores);
		this.listPokemones.setModel(listModelPokemones);

		this.setVisible(true);

		this.choicePokemon.add("Agua");
		this.choicePokemon.add("Electricidad");
		this.choicePokemon.add("Fuego");
		this.choicePokemon.add("Hielo");
		this.choicePokemon.add("Psiquico");
		this.choicePokemon.add("Tierra");
		// this.btnNewButton.setVisible(false);

		this.panelEntrenadoresPokemones.setPreferredSize(new Dimension(50, 37000));
		this.listEntrenadores.setPreferredSize(new Dimension(50, 37000));
		this.listPokemones.setPreferredSize(new Dimension(50, 37000));

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
		this.listEntrenadores.addMouseListener((MouseListener) actionListener); // OJO ACA
	}

	@Override
	public void setActionListenerFaseGrupos(ActionListener actionListener) {
		this.btnSiguienteEtapa.addActionListener(actionListener);
		this.btnIniciar.addActionListener(actionListener);
	}

	@Override
	public void sortear() {
		this.creaArenas(5);
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
		if (!this.textFieldNombreEntrenador.getText().equals(""))
			this.btnCrearE.setEnabled(true);
		if (!this.textFieldNombrePokemon.getText().equals("")) {
			this.btnCrearP.setEnabled(true);
			this.choicePokemon.setEnabled(true);
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

	@Override
	public void actualizarListaPokemon(Iterator<Pokemon> it) {
		// TODO Auto-generated method stub
		this.listModelPokemones.clear();
		while (it.hasNext()) {
			this.listModelPokemones.addElement(it.next());
		}
		this.repaint();
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	@Override
	public Entrenador devolverEntrenadorSeleccionado() {
		// TODO Auto-generated method stub
		return this.listEntrenadores.getSelectedValue();
	}

	@Override
	public Pokemon devolverPokemon() {
		// TODO Auto-generated method stub
		String nombre = this.textFieldNombrePokemon.getText();
		boolean recarga = this.checkboxGranRecarga.getState();
		String tipo = this.choicePokemon.getSelectedItem();
		return PokemonFactory.fabricaPokemon(nombre, tipo, recarga);
	}

	@Override
	public int devuelveCantidadParticipantes() {
		int cantidad = Integer.parseInt((String) this.comboParticipantes.getSelectedItem());
		return cantidad;
	}

	@Override
	public void habilitarAgregarEntrenador() {
		// TODO Auto-generated method stub
		this.textFieldNombreEntrenador.setEditable(true);
	}

	@Override
	public void habilitarAgregarPokemon() {
		// TODO Auto-generated method stub
		this.textFieldNombrePokemon.setEditable(true);
		this.checkboxGranRecarga.setEnabled(true);
	}

	@Override
	public void habilitarModificarEntrenador() {
		// TODO Auto-generated method stub
		this.btnModificarE.setEnabled(true);
	}

	@Override
	public void habilitarModificarPokemon() {
		// TODO Auto-generated method stub
		this.btnModificarP.setEnabled(true);
	}

	@Override
	public Pokemon devolverPokemonSeleccionado() {
		// TODO Auto-generated method stub
		return this.listPokemones.getSelectedValue();
	}

	@Override
	public void creaArenas(int cantidad) {

		this.arenas = new JButton[cantidad];
		this.panelPanelArenas.setLayout(new GridLayout(1, cantidad));

		for (int i = 0; i < cantidad; i++) {
			this.arenas[i] = new JButton("Arena " + i);
			this.panelPanelArenas.add(this.arenas[i]);
		}
		this.panelPanelArenas.revalidate();
		this.validate();
		this.repaint();
	}

	@Override

	public void creaGrupos(ArrayList<Grupo> grupo, int cantidad) {
		int numerogrupo = 1;
		this.grupos = new JPanel[cantidad / 4];
		this.panelMedio.remove(this.panelEtapaGrupos);
		this.panelMedio.remove(this.panelBotones);
		for (int i = 0; i < cantidad / 4; i++) {
			this.grupos[i] = new JPanel();
			this.grupos[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			this.panelMedio.add(this.grupos[i]);
			this.grupos[i].setLayout(new FlowLayout());
			this.grupos[i].setLayout(new GridLayout(0, 1));

			JLabel label = new JLabel("Grupo " + numerogrupo);
			this.dlm = new DefaultListModel<Entrenador>();

			JList<Entrenador> lista = new JList<Entrenador>(dlm);
			lista.setSize(new Dimension(0, 547));
			lista.setMaximumSize(new Dimension(0, 547));

			JScrollPane scrollpane = new JScrollPane();
			scrollpane.setBounds(0, 26, 415, 547);
			scrollpane.setPreferredSize(new Dimension(50, 2));
			scrollpane.setViewportView(lista);

			this.grupos[i].add(scrollpane);
			scrollpane.setColumnHeaderView(lista);
			for (int k = 0; k < 4; k++) {
				this.dlm.addElement(grupo.get(numerogrupo - 1).getIntegrantes().get(k));
			}
			this.grupos[i].add(label);
			numerogrupo++;
		}
		revalidate();
		repaint();
	}

	@Override
	public void repintarArenas(int indice, String nombre) {
		this.arenas[indice].setText(nombre);
	}

	@Override
	public void faseSiguiente(ArrayList<Entrenador> clasificados) {
		for (int i = 0; i < clasificados.size(); i++)
			System.out.println(clasificados.get(i).toString());
		this.panelCentral.setVisible(false);
		this.panelCentral.removeAll();
		this.fase = new PanelFaseEliminatoria(clasificados);
		this.panelCentral.setLayout(new FlowLayout());
		this.panelCentral.add(fase);
		this.panelCentral.setVisible(true);
		for (int i = 0; i < 4; i++) 
			this.arenas[i].setName("Arena " + i);
		
		this.revalidate();
	}

	@Override
	public void pintarFase1() {

		this.setBounds(this.getX(), this.getY(), 1100, 682);

		this.panelDerecho = new JPanel();
		this.panelDerecho.setBounds(679, 5, 415, 300);
		this.contentPane.add(this.panelDerecho);
		this.panelDerecho.setLayout(new GridLayout(0, 1));
		// this.panelDerecho.setLayout(new FlowLayout());

		JPanel rodeabotonsigetapa = new JPanel();
		rodeabotonsigetapa.setSize(50, 50);
		// rodeabotonsigetapa.setLayout(new GridLayout(3,0));
		this.panelDerecho.add(rodeabotonsigetapa);

		this.btnSiguienteEtapa = new JButton("Siguiente etapa");
		this.btnSiguienteEtapa.setActionCommand("SIGUIENTE_ETAPA");
		this.btnSiguienteEtapa.setBounds(22, 11, 121, 28);
		this.btnSiguienteEtapa.setSize(5, 5);
		rodeabotonsigetapa.add(this.btnSiguienteEtapa);

		this.btnIniciar = new JButton("Iniciar Combates");
		this.btnIniciar.setActionCommand("INICIAR_COMBATES");
		this.btnIniciar.setBounds(22, 11, 121, 28);
		this.btnIniciar.setSize(5, 5);
		rodeabotonsigetapa.add(this.btnIniciar);

		this.panelBatalla = new JPanel();
		this.panelBatalla.setBounds(0, 0, 415, 800);
		this.panelDerecho.add(this.panelBatalla);
		this.panelBatalla.setLayout(null);

		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(0, 26, 415, 300);
		this.panelBatalla.add(this.scrollPane_2);
		this.scrollPane_2.setPreferredSize(new Dimension(415, 300));

		this.listBatalla = new JList();
		//this.listBatalla.setSize(new Dimension(0, 800));
		//this.listBatalla.setMaximumSize(new Dimension(0, 800));
		this.scrollPane_2.setViewportView(this.listBatalla);
		//this.scrollPane_2.setColumnHeaderView(this.listBatalla);

		//this.listBatalla.setBounds(this.listBatalla.getX(), this.listBatalla.getY(), 200, 1000);
		this.listBatalla.setModel(this.modelBatallas);
		this.listBatalla.setPreferredSize(new Dimension(200, 800));

		this.lblNewLabel_1 = new JLabel("Batallas");
		this.lblNewLabel_1.setBounds(2, 0, 415, 25);
		this.panelBatalla.add(this.lblNewLabel_1);

		this.panelBotones.setVisible(false);
		this.panelCM.setVisible(false);
		repaint();
	}

	@Override
	public void repintarGrupos(ArrayList<Grupo> grupo) {
		Component c;
		JScrollPane scrollpane;
		System.out.println("GRUPO SIZE" + grupo.size());
		for (int i = 0; i < grupo.size(); i++) {
			this.dlm.clear();
			scrollpane = (JScrollPane) this.grupos[i].getComponent(0);
			c = ((JList) scrollpane.getColumnHeader().getComponent(0));
			for (int j = 0; j < 4; j++) {
				System.out.println(grupo.get(i).getIntegrantes().get(j));
				this.dlm.addElement(grupo.get(i).getIntegrantes().get(j));
			}
			c.repaint();
		}

	}

	@Override
	public void repintarBatalla(ArrayList<Enfrentamiento> enfrentamientos) {
		this.modelBatallas.clear();
		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < enfrentamientos.size(); i++) {
			this.modelBatallas.addElement(enfrentamientos.get(i).getLogBatalla());
			System.out.println(enfrentamientos.get(i).getLogBatalla());
			JOptionPane.showMessageDialog(this, enfrentamientos.get(i).getLogBatalla());
		}
		repaint();
	}

}
