package personajes;

import interfaces.Atacable;

public class Fuego extends Pokemon {

	public Fuego(String nombre) {
		super(nombre, 200, 530, 80);
		this.recarga = true;
	}

	@Override
	public void recibeDano(double ataque) {
		if (this.escudo > ataque / 2) {
			this.escudo -= ataque / 2;
			this.vitalidad -= ataque / 2;
		} else {
			this.vitalidad -= (this.escudo - ataque);
			this.escudo = 0;
		}

	}

	@Override
	public void recarga() {
		if (this.recarga = true) {
			this.vitalidad = this.vitalidad * 1.1;
			this.ataque = this.ataque * 1.1;
		}
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.ataque*1.25);
		this.ataque =0;

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
