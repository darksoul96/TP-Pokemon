package hechizos;

import java.io.Serializable;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase niebla que repesenta el hechizo en cuestion.
 * Todos los pokemones ven reducida su visibilidad, 20% de chance de fallar su ataque menos el psiquico.

 *
 */
public class Niebla implements ICarta,Serializable {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarNiebla();
	}
	
}
