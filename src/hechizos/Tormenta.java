package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase Tormenta que representa el hechizo en cuestion. Aplica la interface ICarta
 *
 */
public class Tormenta implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarTormenta();
		
	}

}
