package modelo;
import java.util.Random;

import interfaces.ICarta;
import personajes.Entrenador;
import personajes.Pokemon;

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

	public void batalla(Entrenador e1, Pokemon p1, Entrenador e2, Pokemon p2) {
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
