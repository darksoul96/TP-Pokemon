package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import personajes.Entrenador;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JList;

public class PanelFaseEliminatoria extends JPanel {
	private JPanel panelNorte;
	private JLabel lblSiguienteRonda;
	private JButton btnSiguienteRonda;
	private JPanel panelSur;
	private JPanel panelEste;
	private JPanel panelCentral;
	private JPanel[][] llaves;
	
	public PanelFaseEliminatoria(ArrayList <Entrenador> clasificados) {
		setLayout(new BorderLayout(0, 0));
		
		this.panelNorte = new JPanel();
		add(this.panelNorte, BorderLayout.NORTH);
		this.panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.lblSiguienteRonda = new JLabel("Siguiente Ronda:");
		this.panelNorte.add(this.lblSiguienteRonda);
		
		this.btnSiguienteRonda = new JButton("Siguiente");
		this.panelNorte.add(this.btnSiguienteRonda);
		
		this.panelSur = new JPanel();
		add(this.panelSur, BorderLayout.SOUTH);
		
		this.panelEste = new JPanel();
		add(this.panelEste, BorderLayout.EAST);
		
		this.panelCentral = new JPanel();
		add(this.panelCentral, BorderLayout.CENTER);
		
		int contador =0;
		this.llaves = new JPanel[clasificados.size()/2][2];
		for(int i=0;i<clasificados.size()/2;i++) {
			for(int j=0;j<2;j++) {
				this.llaves[i][j] = new JPanel();
				this.llaves[i][j] = new JPanel();
				this.llaves[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
				this.panelCentral.add(this.llaves[i][j]);
				this.llaves[i][j].setLayout(new FlowLayout());
				this.llaves[i][j].setLayout(new GridLayout(0, 1));

				DefaultListModel<Entrenador> dlm = new DefaultListModel<Entrenador>();
				JList<Entrenador> lista = new JList<Entrenador>(dlm);
				lista.setSize(new Dimension(0, 547));
				lista.setMaximumSize(new Dimension(0, 547));

				JScrollPane scrollpane = new JScrollPane();
				scrollpane.setBounds(0, 26, 415, 547);
				scrollpane.setPreferredSize(new Dimension(50, 2));
				scrollpane.setViewportView(lista);

				this.llaves[i][j].add(scrollpane);
				scrollpane.setColumnHeaderView(lista);
				dlm.addElement(clasificados.get(contador));
				contador++;
			}
		}
	}

}
