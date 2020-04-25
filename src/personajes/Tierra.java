package personajes;

import interfaces.Atacable;

public class Tierra extends Pokemon {

	public Tierra(String nombre, double escudo, double vitalidad, double ataque) {
		super(nombre, 250, 650, 40);
	}

	@Override
	public void recibeDano(double cantidad) {
		if (cantidad < this.escudo)
			this.escudo -= cantidad * 0.6;
		else {
			this.vitalidad -= (cantidad - this.escudo);
			this.escudo = 0;
		}

	}

	@Override
	public void recarga() {
		this.escudo = this.escudo *1.5;
		
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.escudo + this.ataque*0.2);
		this.escudo =0;
		
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
