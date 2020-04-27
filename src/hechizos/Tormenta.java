package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase Tormenta que representa el hechizo en cuestion. Aplica la interface
 * ICarta Todos los pokemones ven reducida su vitalidad en un 20% debido a
 * descargas electricas. El pokemon de electricidad se ve inmune a este hechizo.
 *
 */
public class Tormenta implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarTormenta();

	}

}
