package personajes;

import interfaces.Atacable;

public class Psiquico extends Pokemon {

	public Psiquico(String nombre, double escudo, double vitalidad, double ataque) {
		super(nombre, escudo, vitalidad, ataque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void recibeDano(double ataque) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recarga() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		// TODO Auto-generated method stub
		
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
