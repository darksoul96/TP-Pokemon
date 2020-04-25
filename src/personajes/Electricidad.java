package personajes;

import interfaces.Atacable;

public class Electricidad extends Pokemon {

	public Electricidad(String nombre, double escudo, double vitalidad, double ataque) {
		super(nombre, 150, 500, 110);
	}

	@Override
	public void recibeDano(double cantidad) {
		if (cantidad < this.escudo)
			this.escudo -= cantidad *1.2;
		else {
			this.vitalidad -= (cantidad - this.escudo);
			this.escudo = 0;
		}

	}


	@Override
	public void recarga() {
		this.ataque = this.ataque *1.2;
		
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.getAtaque() *1.5);
		this.ataque = this.ataque *0.2;
		
	}

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException("No se puede clonar este tipo de pokemon");
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
