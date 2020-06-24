package vista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import personajes.Entrenador;
import personajes.Pokemon;

public interface IVista {
	
	void setActionListener(ActionListener actionListener);
	void sortear();
	void habilitarAgregarEntrenador();
	void habilitarAgregarPokemon();
	String crearEntrenador();
	String getNombreEntrenador();
	String getNombrePokemon();
	boolean getGranRecarga();
	void actualizarListaEntrenador(Iterator<Entrenador> it);
	void actualizarListaPokemon(Iterator<Pokemon> it);
	Entrenador devolverEntrenadorSeleccionado();
	Pokemon devolverPokemon();
	Pokemon devolverPokemonSeleccionado();
	void habilitarModificarEntrenador();
	void habilitarModificarPokemon();
	
}
