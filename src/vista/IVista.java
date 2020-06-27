package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Enfrentamiento;
import modelo.Grupo;
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
	void pintarFase1();
	void creaArenas(int i);
	void creaGrupos(ArrayList<Grupo> grupos, int cantidad);
	void setActionListenerBotonesNuevos(ActionListener actionListener);
	int devuelveCantidadParticipantes();
	void faseSiguiente(ArrayList<Entrenador> clasificados);
	void repintarGrupos(ArrayList<Grupo> grupos);
	void repintarBatalla(ArrayList<Enfrentamiento> enfrentamientos);
	void repintarArenas(int indice, String nombre);
	void mostrarLogs();
	void redimensionarVentanaOcultarPaneles();
	void mostrarGanador();
	void informarganador(Entrenador arg1);
	
}
