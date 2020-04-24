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

	public void batalla(Entrenador e1, Entrenador e2) {
		// lo ideal seria que el ganador y el perdedor se setee despues de batalla y no
		// en el constructor

		Random r = new Random();
		int atacaprimero = r.nextInt(10); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
		int hechizo1 = r.nextInt(3);
		int hechizo2 = r.nextInt(3);
		int p1 = r.nextInt(e1.getPokemones().size());
		int p2 = r.nextInt(e2.getPokemones().size());
		Pokemon pokemon1;
		Pokemon pokemon2;
		pokemon1 = e1.getPokemones().get(p1);
		pokemon2 = e2.getPokemones().get(p2);
		if (hechizo1 != 3) {
			pokemon2.serHechizado(e2.getCartas().get(hechizo1));
		}
		if (hechizo2 != 3) {
			pokemon1.serHechizado(e1.getCartas().get(hechizo2));
		}
		if (atacaprimero <= 4)
			pokemon1.atacar(pokemon2);
		else
			pokemon1.atacar(pokemon2);
		if (pokemon1.getVitalidad() > pokemon2.getVitalidad()) {
			this.ganador = e1.getNombre();
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 3);
		} else {
			this.ganador = e2.getNombre();
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 3);
		}

	}

	public String getGanador() {
		return ganador;
	}

	public String getPerdedor() {
		return perdedor;
	}

}
