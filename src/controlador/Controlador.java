package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Torneo;
import vista.IVista;

public class Controlador implements ActionListener {

	private Torneo torneo;
	private IVista vista;

	public Controlador() {
		// aca se setea la vista
		// tambien se le asigna a la ventana que este es su controlador
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
