package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

/**
 * Clase hechizable que representa el hechizo en cuestion. Si el pokemon es de
 * fuego, reduce la efectividad de sus ataques en un 30%. El resto de los
 * pokemones afectados por este hechizo, tienen una chance del 20% de ver
 * reducida su vitalidad en 15%
 *
 */
public class Viento implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarViento();

	}

}
