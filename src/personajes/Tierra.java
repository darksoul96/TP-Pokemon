package personajes;

import interfaces.Atacable;

/**
 * Pokemon de tipo Tierra. Vitalidad: 500 Escudo: 200 Fuerza: 40
 * 
 * Recarga: Aumenta su escudo en un 50%. Golpe final: Provoca al adversario un
 * daño equivalente al 100% de su escudo actual + 20% de su daño. Luego el
 * escudo se agota. Recibe Daño: El escudo absorbe el 100% del daño recibido y
 * se desgasta en un 60%
 *
 */
public class Tierra extends Pokemon {

	public Tierra(String nombre, boolean recarga) {
		super(nombre, 200, 500, 40, recarga);
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
		if (this.recarga == true)
			this.escudo = this.escudo * 1.5;

	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.escudo + this.ataque * 0.2);
		this.escudo = 0;

	}

}
