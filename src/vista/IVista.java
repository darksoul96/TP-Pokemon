package vista;

import java.awt.event.ActionListener;

public interface IVista {
	
	void setActionListener(ActionListener actionListener);
	void sortear();
	void agregarEntrenador();
	String crearEntrenador();
	String getNombreEntrenador();
	String getNombrePokemon();
	boolean getGranRecarga();
	void actualizarListaEntrenador(Object o);
}
