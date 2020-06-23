package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import modelo.Torneo;
import personajes.Entrenador;
import vista.IVista;
import vista.Ventana;

public class Controlador implements ActionListener, Observer, KeyListener {

	private Torneo torneo;
	private IVista vista;

	public Controlador() {
		this.vista = new Ventana();
		this.vista.setActionListener(this);
		this.torneo = torneo.getInstanceSingleton();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String comando = arg0.getActionCommand();
		if (comando.contentEquals("CREAR_ENTRENADOR") || comando.contentEquals("PRE_AGREGAR_ENTRENADOR")) {
			if (comando.contentEquals("PRE_AGREGAR_ENTRENADOR"))
				this.vista.agregarEntrenador();
			else {
				torneo.agregarEntrenador(new Entrenador(this.vista.getNombreEntrenador()));
				this.vista.actualizarListaEntrenador(this.torneo.devuelveIterator());
			}
		} else if (comando.contentEquals("SORTEAR")) {
			System.out.println("Sortear");
		}

	}

	public IVista getVista() {
		return vista;
	}

	public void setVista(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
