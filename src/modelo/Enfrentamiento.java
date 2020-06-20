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
public class Enfrentamiento extends Thread {

	private Entrenador entrenadorUno;
	private Entrenador entrenadorDos;
	private Entrenador ganador;
	private Entrenador perdedor;
	private Arena recursoCompartido;

	public Enfrentamiento(Entrenador entrenadorUno, Entrenador entrenadorDos) {
		super();
		this.entrenadorUno = entrenadorUno;
		this.entrenadorDos = entrenadorDos;
		this.recursoCompartido = null;
	}

	/**
	 * @param e1 Entrenador e1, pasado desde torneo. Primer participante de la
	 *           batalla
	 * @param e2 Entrenador e2, pasado desde torneo. Segundo participante de la
	 *           batalla.
	 * @return Devuelve un tipo Entrenador, el ganador de ambos.
	 */
	public Entrenador batalla() {
		double puntaje1, puntaje2;
		Random r = new Random();
		int atacaprimero = r.nextInt(11); // flip a coin, de 0 a 4 ataca primero E1, sino ataca primero E2.
		ICarta hechizo1;
		System.out.println("Enfrentamiento: \n");
		System.out.println(this.entrenadorUno.getNombre() + " se enfrenta a " + this.entrenadorDos.getNombre());
		try {
			hechizo1 = this.entrenadorUno.elegirCarta();
		} catch (CantidadHechizosExcedidosException e) {
			System.out.println("El entrenador: "+this.entrenadorUno.getNombre() + " se ha quedado sin hechizos, no puede utilizar carta");
			hechizo1 = null;
		}
		ICarta hechizo2;
		try {
			hechizo2 = this.entrenadorDos.elegirCarta();
		} catch (CantidadHechizosExcedidosException e) {
			System.out.println("El entrenador: "+this.entrenadorDos.getNombre() + " se ha quedado sin hechizos, no puede utilizar carta");
			hechizo2 = null;
		}
		int p1 = r.nextInt(this.entrenadorUno.getPokemones().size());
		int p2 = r.nextInt(this.entrenadorDos.getPokemones().size());
		Pokemon pokemon1;
		Pokemon pokemon2;
		pokemon1 = this.entrenadorUno.getPokemones().get(p1);
		pokemon2 = this.entrenadorDos.getPokemones().get(p2);
		if (hechizo1 != null) {
			System.out.println("El entrenador " + this.entrenadorUno.getNombre() + " ha utilizado una carta.");
			pokemon2.serHechizado(hechizo1);
			this.entrenadorUno.setCantidadHechizos(this.entrenadorUno.getCantidadHechizos() - 1);
		}
		if (hechizo2 != null) {
			System.out.println("El entrenador " + this.entrenadorDos.getNombre() + " ha utilizado una carta.");
			pokemon1.serHechizado(hechizo2);
			this.entrenadorDos.setCantidadHechizos(this.entrenadorDos.getCantidadHechizos() - 1);
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
			this.ganador = this.entrenadorUno;
			this.perdedor = this.entrenadorDos;
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 3);
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 1);
			this.entrenadorUno.premio();
		} else {
			this.ganador = this.entrenadorDos;
			this.perdedor = this.entrenadorUno;
			pokemon2.setExperiencia(pokemon2.getExperiencia() + 3);
			pokemon1.setExperiencia(pokemon1.getExperiencia() + 1);
			this.entrenadorDos.premio();
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
	
	

	public void setRecursoCompartido(Arena recursoCompartido) {
		this.recursoCompartido = recursoCompartido;
	}

	@Override
	public String toString() {
		return "Participante 1 :" + this.entrenadorUno.getNombre() + " Participante 2: "
				+ this.entrenadorDos.getNombre() + ", Ganador: " + this.ganador.getNombre() + "\n";
	}

	@Override
	public void run() {
		this.recursoCompartido.comenzar(this);
		
	}
	
	
}
