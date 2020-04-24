package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

public class Tormenta implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarTormenta();
		
	}

}
