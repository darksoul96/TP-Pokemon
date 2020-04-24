package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

public class Niebla implements ICarta {

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarNiebla();
	}
	
}
