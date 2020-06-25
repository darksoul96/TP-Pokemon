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
		this.torneo.addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String comando = arg0.getActionCommand();
		if (comando.contentEquals("CREAR_ENTRENADOR") || comando.contentEquals("PRE_AGREGAR_ENTRENADOR")) {
			if (comando.contentEquals("PRE_AGREGAR_ENTRENADOR"))
				this.vista.habilitarAgregarEntrenador();
			else {
				torneo.agregarEntrenador(new Entrenador(this.vista.getNombreEntrenador()));
				this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());
			}
		} else if (comando.contentEquals("SORTEAR")) {
			this.vista.sortear();
		} else if (comando.contentEquals("PRE_AGREGAR_POKEMON") || comando.contentEquals("CREAR_POKEMON")) {
			if (comando.contentEquals("PRE_AGREGAR_POKEMON"))
				this.vista.habilitarAgregarPokemon();
			else {
				Entrenador e = this.vista.devolverEntrenadorSeleccionado();
				if (e != null) {
					Pokemon p = this.vista.devolverPokemon();
					e.agregarPokemon(p);
					this.vista.actualizarListaPokemon(this.torneo.devuelveIteratorPokemon(e));
				}
			}
		} else if (comando.contentEquals("PRE_MODIFICAR_ENTRENADOR") || comando.contentEquals("MODIFICAR_ENTRENADOR")) {
			if (comando.contentEquals("PRE_MODIFICAR_ENTRENADOR"))
				this.vista.habilitarModificarEntrenador();
			else {
				Entrenador e = this.vista.devolverEntrenadorSeleccionado();
				if (e != null) {
					e.setNombre(this.vista.getNombreEntrenador());
					this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());
				}
			}
		} else if (comando.contentEquals("PRE_MODIFICAR_POKEMON") || comando.contentEquals("MODIFICAR_POKEMON")) {
			if (comando.contentEquals("PRE_MODIFICAR_POKEMON"))
				this.vista.habilitarModificarPokemon();
			else {
				Pokemon p = this.vista.devolverPokemonSeleccionado();
				if (p != null) {
					Entrenador e = this.vista.devolverEntrenadorSeleccionado();
					p.setNombre(this.vista.getNombrePokemon());
					this.vista.actualizarListaPokemon(this.torneo.devuelveIteratorPokemon(e));
				}
			}
		} else if (comando.contentEquals("ELIMINAR_ENTRENADOR")) {
			Entrenador e = this.vista.devolverEntrenadorSeleccionado();

			this.torneo.eliminarEntrenador(e);
			this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());

		} else if (comando.contentEquals("ELIMINAR_POKEMON")) {
			Pokemon p = this.vista.devolverPokemonSeleccionado();
			if (p != null) {
				Entrenador e = this.vista.devolverEntrenadorSeleccionado();
				e.eliminarPokemon(p);
				this.vista.actualizarListaPokemon(this.torneo.devuelveIteratorPokemon(e));
			}
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
		if (arg0.getSource().getClass() == JList.class) {
			JList lista = (JList) arg0.getSource();
			Iterator<Pokemon> it;
			int index = lista.locationToIndex(arg0.getPoint());
			if (index >= 0) {
				Object item = lista.getModel().getElementAt(index);
				System.out.println(item.toString());
				it = this.torneo.devuelveIteratorPokemon((Entrenador) lista.getSelectedValue());
				this.vista.actualizarListaPokemon(it);
			}
		}
	}

}
