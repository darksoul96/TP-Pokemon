package modelo;

import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
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

	public void batalla(Entrenador e1, Entrenador e2) throws CantidadHechizosExcedidosException {
		double puntaje1, puntaje2;
		Random r = new Random();
		int atacaprimero = r.nextInt(10); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
		ICarta hechizo1 = e1.elegirCarta();
		ICarta hechizo2 = e2.elegirCarta();
		int p1 = r.nextInt(e1.getPokemones().size());
		int p2 = r.nextInt(e2.getPokemones().size());
		Pokemon pokemon1;
		Pokemon pokemon2;
		pokemon1 = e1.getPokemones().get(p1);
		pokemon2 = e2.getPokemones().get(p2);
		if (hechizo1 != null) {
			pokemon2.serHechizado(hechizo1);
		}
		if (hechizo2 != null) {
			pokemon1.serHechizado(hechizo2);
		}
		if (atacaprimero <= 4)
			pokemon1.atacar(pokemon2);
		else
			pokemon1.atacar(pokemon2);
		puntaje1 = calculaPuntaje(pokemon1);
		puntaje2 = calculaPuntaje(pokemon2);
		if (puntaje1 > puntaje2) {
			this.ganador = e1.getNombre();
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 3);
		} else {
			this.ganador = e2.getNombre();
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 3);
		}
	}

	private double calculaPuntaje(Pokemon p) {
		return p.getVitalidad() + p.getAtaque() * 0.4 + p.getEscudo() * 0.3;
	}

	public String getGanador() {
		return ganador;
	}

	public String getPerdedor() {
		return perdedor;
	}

	public Entrenador getEntrenadorUno() {
		return entrenadorUno;
	}

	public Entrenador getEntrenadorDos() {
		return entrenadorDos;
	}

	@Override
	public String toString() {
		return "Participante 1 :" + this.entrenadorUno.getNombre() + " Participante 2; " + this.entrenadorDos.getNombre() + " Ganador: "+this.ganador;
	}

}
