package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase niebla que repesenta el hechizo en cuestion. 
 *
 */
public class Niebla implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarNiebla();
	}
	
}
