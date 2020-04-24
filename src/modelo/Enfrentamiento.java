package modelo;
import java.util.Random;

import personajes.Entrenador;

public class Enfrentamiento {

	private Entrenador entrenadorUno;
	private Entrenador entrenadorDos;
	private String ganador;
	private String perdedor;
	
	public Enfrentamiento(Entrenador entrenadorUno, Entrenador entrenadorDos) {
		super();
		this.entrenadorUno = entrenadorUno;
		this.entrenadorDos = entrenadorDos;
	}

	public void batalla() {
		// lo ideal seria que el ganador y el perdedor se setee despues de batalla y no en el constructor
		Random r = new Random();
		int rng = r.nextInt(10); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
	}

	public String getGanador() {
		return ganador;
	}

	public String getPerdedor() {
		return perdedor;
	}
	
	
	
	
}
