package personajes;

import interfaces.Atacable;

public class Hielo extends Pokemon {

	public Hielo(String nombre) {
		super(nombre,120,500,100);
	}

	@Override
	public void recibeDano(double ataque) {
		if (this.escudo > ataque * 0.75) {
			this.escudo -= ataque * 0.75;
			this.vitalidad -= ataque *0.25;
		} else {
			this.vitalidad -= (this.escudo - ataque);
			this.escudo = 0;
		}

	}

	@Override
	public void recarga() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.ataque*0.9);
		
	}

	@Override
	public void hechizarViento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hechizarNiebla() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hechizarTormenta() {
		// TODO Auto-generated method stub
		
	}

}
