package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase hechizable que representa el hechizo en cuestion.
 *
 */
public class Viento implements ICarta{

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarViento();
		
	}

}
