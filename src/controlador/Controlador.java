package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JList;

import modelo.Torneo;
import personajes.Entrenador;
import personajes.Pokemon;
import vista.IVista;
import vista.Ventana;

public class Controlador implements ActionListener, Observer, KeyListener, MouseListener {

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
				this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());
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


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		}
	


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		}
	


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Component c=arg0.getComponent();
		Iterator <Pokemon> it;
		//hasta aca llega
		System.out.println(c.getName());
		if (c.getName()=="listEntrenadores") {
			System.out.println("LLEGO");
			JList lista=(JList) arg0.getSource();
			it=this.torneo.devuelveIteratorPokemon((Entrenador) lista.getSelectedValue());
			this.vista.actualizarListaPokemon(it);
			System.out.println("Hola");
		}
	}

}
