package modelo;

import java.io.Serializable;
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
public class Enfrentamiento extends Thread implements Serializable {

	private Entrenador entrenadorUno;
	private Entrenador entrenadorDos;
	private Entrenador ganador;
	private Entrenador perdedor;
	private Arena recursoCompartido;
	private String logPreliminar = "";
	private String logBatalla = "";
	private String logDefinicion = "";

	public Enfrentamiento(Entrenador entrenadorUno, Entrenador entrenadorDos) {
		super();
		this.entrenadorUno = entrenadorUno;
		this.entrenadorDos = entrenadorDos;
		this.recursoCompartido = null;
	}


	public void preparacionEntrenadores() {

		Random r = new Random();
		try {
			this.entrenadorUno.setHechizoActivo(this.entrenadorUno.elegirCarta());
		} catch (CantidadHechizosExcedidosException e) {
			this.entrenadorUno.setHechizoActivo(null);
		}

		try {
			this.entrenadorDos.setHechizoActivo(this.entrenadorDos.elegirCarta());
		} catch (CantidadHechizosExcedidosException e) {
			this.entrenadorDos.setHechizoActivo(null);
		}

		this.entrenadorUno.setPokemonActivo(
				this.entrenadorUno.getPokemones().get(r.nextInt(this.entrenadorUno.getPokemones().size())));
		this.entrenadorDos.setPokemonActivo(
				this.entrenadorDos.getPokemones().get(r.nextInt(this.entrenadorDos.getPokemones().size())));

		this.appendLogPreliminar(this.entrenadorUno + " va a pelear con " + this.entrenadorDos + "\n");
		this.appendLogPreliminar(this.entrenadorUno + "elige a " + this.entrenadorUno.getPokemonActivo().getNombre() + "\n");
		this.appendLogPreliminar(this.entrenadorDos + "elige a " + this.entrenadorDos.getPokemonActivo().getNombre() + "\n");
	}

	
	
	public String getLogPreliminar() {
		return logPreliminar;
	}


	public void setLogPreliminar(String logPreliminar) {
		this.logPreliminar = logPreliminar;
	}


	public String getLogBatalla() {
		return logBatalla;
	}


	public void setLogBatalla(String logBatalla) {
		this.logBatalla = logBatalla;
	}


	public String getLogDefinicion() {
		return logDefinicion;
	}


	public void setLogDefinicion(String logDefinicion) {
		this.logDefinicion = logDefinicion;
	}


	public void batalla() {
		Random r = new Random();
		int atacaprimero = r.nextInt(11);

		if (this.entrenadorUno.getHechizoActivo() != null) {
			this.appendLogBatalla(this.entrenadorUno.getNombre() + " utilizo una carta\n");
			this.entrenadorDos.getPokemonActivo().serHechizado(this.entrenadorUno.getHechizoActivo());
			this.entrenadorUno.setCantidadHechizos(this.entrenadorUno.getCantidadHechizos() - 1);
		}
		if (this.entrenadorDos.getHechizoActivo() != null) {
			this.appendLogBatalla(this.entrenadorDos.getNombre() + " utilizo una carta\n");
			this.entrenadorUno.getPokemonActivo().serHechizado(this.entrenadorDos.getHechizoActivo());
			this.entrenadorDos.setCantidadHechizos(this.entrenadorDos.getCantidadHechizos() - 1);
		}

		if (atacaprimero <= 4) {
			this.appendLogBatalla("El pokemon " + this.entrenadorUno.getPokemonActivo().getNombre() + " ataca\n");
			this.entrenadorUno.getPokemonActivo().atacar(this.entrenadorDos.getPokemonActivo());
			this.appendLogBatalla("El pokemon " + this.entrenadorDos.getPokemonActivo().getNombre() + " ataca\n");
			this.entrenadorDos.getPokemonActivo().atacar(this.entrenadorUno.getPokemonActivo());
		} else {
			this.appendLogBatalla("El pokemon " + this.entrenadorDos.getPokemonActivo().getNombre() + " ataca\n");
			this.entrenadorDos.getPokemonActivo().atacar(this.entrenadorUno.getPokemonActivo());
			this.appendLogBatalla("El pokemon " + this.entrenadorUno.getPokemonActivo().getNombre() + " ataca\n");
			this.entrenadorUno.getPokemonActivo().atacar(this.entrenadorDos.getPokemonActivo());
		}
	}

	public void definicion() {

		double puntaje1, puntaje2;

		puntaje1 = calculaPuntaje(this.entrenadorUno.getPokemonActivo());
		this.appendLogDefinicion(
				"Puntaje " + this.entrenadorUno.getPokemonActivo().getNombre() + ": " + (int) puntaje1 + "\n");

		puntaje2 = calculaPuntaje(this.entrenadorDos.getPokemonActivo());
		this.appendLogDefinicion(
				"Puntaje " + this.entrenadorDos.getPokemonActivo().getNombre() + ": " + (int) puntaje2 + "\n");
		if (puntaje1 > puntaje2) {
			this.ganador = this.entrenadorUno;
			this.perdedor = this.entrenadorDos;
			this.entrenadorUno.getPokemonActivo()
					.setExperiencia(this.entrenadorUno.getPokemonActivo().getExperiencia() + 3);
			this.entrenadorDos.getPokemonActivo()
					.setExperiencia(this.entrenadorDos.getPokemonActivo().getExperiencia() + 1);
			this.entrenadorUno.premio();
		} else {
			this.ganador = this.entrenadorDos;
			this.perdedor = this.entrenadorUno;
			this.entrenadorDos.getPokemonActivo()
					.setExperiencia(this.entrenadorDos.getPokemonActivo().getExperiencia() + 3);
			this.entrenadorUno.getPokemonActivo()
					.setExperiencia(this.entrenadorUno.getPokemonActivo().getExperiencia() + 1);
			this.entrenadorDos.premio();
		}
		this.entrenadorUno.getPokemonActivo().reiniciaStats();
		this.entrenadorDos.getPokemonActivo().reiniciaStats();
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

	public void appendLogPreliminar(String cadena) {
		this.logPreliminar += cadena;
	}

	public void appendLogBatalla(String cadena) {
		this.logBatalla += cadena;
	}

	public void appendLogDefinicion(String cadena) {
		this.logDefinicion += cadena;
	}
}
