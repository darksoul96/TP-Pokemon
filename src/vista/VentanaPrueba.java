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

public class VentanaPrueba extends JFrame {

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
		setBounds(100, 100, 846, 556);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
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
		this.contentPane.add(this.panelSur, BorderLayout.SOUTH);
		
		//this.btnNewButton.setVisible(false);
	}

}
