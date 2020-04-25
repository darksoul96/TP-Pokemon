package personajes;

import interfaces.Atacable;

public class Psiquico extends Pokemon {

	public Psiquico(String nombre) {
		super(nombre, 100, 700, 40);
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

	}

	@Override
	public void recarga() {

	}

}
