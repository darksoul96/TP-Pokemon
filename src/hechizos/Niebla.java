package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase niebla que repesenta el hechizo en cuestion.
 * Todos los pokemones ven reducida su visibilidad, 20% de chance de fallar su ataque menos el psiquico.

 *
 */
public class Niebla implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarNiebla();
	}
	
}
