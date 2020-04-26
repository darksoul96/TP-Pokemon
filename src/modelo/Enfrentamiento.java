package modelo;

import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
import interfaces.ICarta;
import personajes.Entrenador;
import personajes.Pokemon;

public class Enfrentamiento {

	private Entrenador entrenadorUno;
	private Entrenador entrenadorDos;
	private Entrenador ganador;
	private Entrenador perdedor;

	public Enfrentamiento(Entrenador entrenadorUno, Entrenador entrenadorDos) {
		super();
		this.entrenadorUno = entrenadorUno;
		this.entrenadorDos = entrenadorDos;
	}

	public Entrenador batalla(Entrenador e1, Entrenador e2) {
		double puntaje1, puntaje2;
		Random r = new Random();
		int atacaprimero = r.nextInt(11); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
		ICarta hechizo1;
		try {
			hechizo1 = e1.elegirCarta();
		} catch (CantidadHechizosExcedidosException e) {
			hechizo1=null;
		}
		ICarta hechizo2;
		try {
			hechizo2 = e2.elegirCarta();
		} catch (CantidadHechizosExcedidosException e) {
			hechizo2=null;
		}
		int p1 = r.nextInt(e1.getPokemones().size());
		int p2 = r.nextInt(e2.getPokemones().size());
		Pokemon pokemon1;
		Pokemon pokemon2;
		pokemon1 = e1.getPokemones().get(p1);
		pokemon2 = e2.getPokemones().get(p2);
		if (hechizo1 != null) {
			pokemon2.serHechizado(hechizo1);
			e1.setCantidadHechizos(e1.getCantidadHechizos()-1);
		}
		if (hechizo2 != null) {
			pokemon1.serHechizado(hechizo2);
			e2.setCantidadHechizos(e2.getCantidadHechizos()-1);
		}
		if (atacaprimero <= 4)
			pokemon1.atacar(pokemon2);
		else
			pokemon2.atacar(pokemon1);
		puntaje1 = calculaPuntaje(pokemon1);
		puntaje2 = calculaPuntaje(pokemon2);
		if (puntaje1 > puntaje2) {
			this.ganador = e1;
			this.perdedor = e2;
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 3);
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 1);
			e1.premio();
		} else {
			this.ganador = e2;
			this.perdedor= e1;
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 3);
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 1);
			e2.premio();
		}
		return this.ganador;
	}

	private double calculaPuntaje(Pokemon p) {
		return p.getVitalidad() + p.getAtaque() * 0.4 + p.getEscudo() * 0.3;
	}

	public Entrenador getGanador() {
		return this.ganador;
	}

	public Entrenador getPerdedor() {
		return this.perdedor;
	}

	public Entrenador getEntrenadorUno() {
		return entrenadorUno;
	}

	public Entrenador getEntrenadorDos() {
		return entrenadorDos;
	}

	@Override
	public String toString() {
		return "Participante 1 :" + this.entrenadorUno.getNombre() + " Participante 2: "
				+ this.entrenadorDos.getNombre() + ", Ganador: " + this.ganador.getNombre() + "\n";
	}
}
