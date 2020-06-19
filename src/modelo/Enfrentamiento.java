package modelo;

import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
import interfaces.ICarta;
import personajes.Entrenador;
import personajes.Pokemon;

/**
 * Clase enfrentamiento, funciona como motor del torneo. Contiene atributos de
 * entrenador. Dos participantes y ganador y perdedor.
 *
 */
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

	/**
	 * @param e1 Entrenador e1, pasado desde torneo. Primer participante de la
	 *           batalla
	 * @param e2 Entrenador e2, pasado desde torneo. Segundo participante de la
	 *           batalla.
	 * @return Devuelve un tipo Entrenador, el ganador de ambos.
	 */
	public Entrenador batalla(Entrenador e1, Entrenador e2) {
		double puntaje1, puntaje2;
		Random r = new Random();
		int atacaprimero = r.nextInt(11); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
		ICarta hechizo1;
		System.out.println("Enfrentamiento: \n");
		System.out.println(e1.getNombre() + " se enfrenta a " + e2.getNombre());
		try {
			hechizo1 = e1.elegirCarta();
		} catch (CantidadHechizosExcedidosException e) {
			System.out.println("El entrenador: "+e1.getNombre() + " se ha quedado sin hechizos, no puede utilizar carta");
			hechizo1 = null;
		}
		ICarta hechizo2;
		try {
			hechizo2 = e2.elegirCarta();
		} catch (CantidadHechizosExcedidosException e) {
			System.out.println("El entrenador: "+e2.getNombre() + " se ha quedado sin hechizos, no puede utilizar carta");
			hechizo2 = null;
		}
		int p1 = r.nextInt(e1.getPokemones().size());
		int p2 = r.nextInt(e2.getPokemones().size());
		Pokemon pokemon1;
		Pokemon pokemon2;
		pokemon1 = e1.getPokemones().get(p1);
		pokemon2 = e2.getPokemones().get(p2);
		if (hechizo1 != null) {
			System.out.println("El entrenador " + e1.getNombre() + " ha utilizado una carta.");
			pokemon2.serHechizado(hechizo1);
			e1.setCantidadHechizos(e1.getCantidadHechizos() - 1);
		}
		if (hechizo2 != null) {
			System.out.println("El entrenador " + e2.getNombre() + " ha utilizado una carta.");
			pokemon1.serHechizado(hechizo2);
			e2.setCantidadHechizos(e2.getCantidadHechizos() - 1);
		}
		if (atacaprimero <= 4) {
			System.out.println(pokemon1.getNombre() + " realiza sus ataques");
			pokemon1.atacar(pokemon2);
			System.out.println(pokemon2.getNombre() + " realiza sus ataques");
			pokemon2.atacar(pokemon1);
		} else {
			System.out.println(pokemon2.getNombre() + " realiza sus ataques");
			pokemon2.atacar(pokemon1);
			System.out.println(pokemon1.getNombre() + " realiza sus ataques");
			pokemon1.atacar(pokemon2);
		}

		puntaje1 = calculaPuntaje(pokemon1);
		System.out.println("Puntaje de " + pokemon1.getNombre() + " : " + (int) puntaje1);
		puntaje2 = calculaPuntaje(pokemon2);
		System.out.println("Puntaje de " + pokemon2.getNombre() + " : " + (int) puntaje2);
		if (puntaje1 > puntaje2) {
			this.ganador = e1;
			this.perdedor = e2;
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 3);
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 1);
			e1.premio();
		} else {
			this.ganador = e2;
			this.perdedor = e1;
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 3);
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 1);
			e2.premio();
		}
		pokemon1.reiniciaStats();
		pokemon2.reiniciaStats();
		return this.ganador;
	}

	/**
	 * @param p Se le debe pasar un pokemon no nulo.
	 * @return Devuelve un puntaje en base a las estadisticas del pokemon.
	 */
	private double calculaPuntaje(Pokemon p) {
		return p.getVitalidad() * 0.5 + p.getAtaque() * 0.9 + p.getEscudo() * 0.4;
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
