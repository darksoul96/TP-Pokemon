package modelo;
import java.util.Random;

import personajes.Entrenador;

public class Enfrentamiento {

	private Entrenador entrenadorUno;
	private Entrenador entrenadorDos;
	private String ganador;
	private String perdedor;
	
	public Enfrentamiento(Entrenador entrenadorUno, Entrenador entrenadorDos, String ganador, String perdedor) {
		super();
		this.entrenadorUno = entrenadorUno;
		this.entrenadorDos = entrenadorDos;
		this.ganador = ganador;
		this.perdedor = perdedor;
	}

	public void batalla() {
		Random r = new Random();
		int rng = r.nextInt(10); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
	}
}
