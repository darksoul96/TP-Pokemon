package personajes;

import interfaces.Atacable;

/**
 * Clase de pokemon psiquico. Vitalidad:700 Escudo: 100 Fuerza: 40
 * 
 * Rercarga: Recupera su vitalidad en un 50% si esta herido, sino, gana un 20%
 * de vitalidad.Golpe Final: Realiza el ataque del adversario al adversario + su
 * ataque. Luego se reduce a un 20% Recibe Daño: El escudo absorbe el daño
 * hastsa acabarse, luego baja la vida.
 *
 * 
 */
public class Psiquico extends Pokemon {

	public Psiquico(String nombre, boolean recarga) {
		super(nombre, 100, 700, 40, recarga);
		this.recarga = false;
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
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(atacable.getAtaque() + this.getAtaque());

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException("No se puede clonar este tipo de pokemon");
	}

	@Override
	public void hechizarNiebla() {
		System.out.println("El pokemon " + this.nombre + " al ser de tipo Psiquico, es inmune al hechizo Niebla!");
	}

	@Override
	public void recarga() {
		if (this.recarga == true) {
			if (this.vitalidad < 700)
				this.vitalidad = this.vitalidad + (700 - this.vitalidad) * 0.5;
			else
				this.vitalidad = this.vitalidad * 1.2;
		}

	}

}
