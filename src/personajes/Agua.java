package personajes;

import interfaces.Atacable;

public class Agua extends Pokemon {

	public Agua(String nombre) {
		super(nombre, 100, 500, 120);
		this.recarga = true;
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
		atacable.recibeDano(this.ataque);
		this.ataque = this.ataque / 2;

	}

	@Override
	public void recibeDano(double cantidad) {
		if (cantidad < this.escudo)
			this.escudo -= cantidad;
		else {
			this.vitalidad -= (cantidad - this.escudo);
			this.escudo = 0;
		}

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
