package personajes;

import interfaces.Atacable;

public class Tierra extends Pokemon {

	public Tierra(String nombre,boolean recarga) {
		super(nombre, 250, 650, 40,recarga);
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
		if(this.recarga == true)
			this.escudo = this.escudo *1.5;
		
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.escudo + this.ataque*0.2);
		this.escudo =0;
		
	}

}
