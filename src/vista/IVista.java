package vista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import personajes.Entrenador;

public interface IVista {
	
	void setActionListener(ActionListener actionListener);
	void sortear();
	void agregarEntrenador();
	String crearEntrenador();
	String getNombreEntrenador();
	String getNombrePokemon();
	boolean getGranRecarga();
	void actualizarListaEntrenador(Iterator<Entrenador> it);
}
