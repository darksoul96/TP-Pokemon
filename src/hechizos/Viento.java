package hechizos;

import interfaces.Hechizable;
import interfaces.ICarta;

public class Viento implements ICarta{

	@Override
	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarViento();
		
	}

}
