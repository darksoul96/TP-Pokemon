package modelo;

import java.util.ArrayList;
import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
import exceptions.PokemonInvalidoException;
import personajes.Entrenador;

/**
 * La clase Torneo sera instanciada una sola vez y es donde se ejecutaran los
 * metodos de competicion del Torneo.
 *
 */
public class Torneo {

	private static Torneo torneo;
	private ArrayList<Entrenador> participantes;
	private ArrayList<Entrenador> clasificados;
	private ArrayList<Grupo> grupos;
	private ArrayList<Enfrentamiento> enfrentamientos;
	private int cantidadDeParticipantes;

	private Torneo() {
		this.participantes = new ArrayList<Entrenador>();
		this.clasificados = new ArrayList<Entrenador>();
		this.enfrentamientos = new ArrayList<Enfrentamiento>();
	}

	public static Torneo getInstanceSingleton() {
		if (torneo == null)
			torneo = new Torneo();
		else
			System.out.println("Ya existe instancia de torneo");
		return torneo;
	}

	public ArrayList<Entrenador> getEntrenadores() {
		return participantes;
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

	public void agregarEntrenador(Entrenador entrenador) {
		this.participantes.add(entrenador);
	}

	public void generaGrupos(Entrenador[] participantes) { // Cree la clase grupo y hago un arraylist de grupos
		Grupo g1 = new Grupo(); // Cada grupo tiene dentro de si, un arraylist de 4 entrenadores.
		Grupo g2 = new Grupo();
		Grupo g3 = new Grupo();
		Grupo g4 = new Grupo();
		Grupo g5 = new Grupo();
		Grupo g6 = new Grupo();
		Grupo g7 = new Grupo();
		Grupo g8 = new Grupo();
		Random r = new Random();
		int i = 0;
		while (this.participantes.size() != 0) {
			i = r.nextInt(this.participantes.size());
			if (g1.isLleno() != true) {
				g1.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g2.isLleno() != true) {
				g2.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g3.isLleno() != true) {
				g3.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g4.isLleno() != true) {
				g4.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g4.isLleno() != true) {
				g4.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g5.isLleno() != true) {
				g5.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g6.isLleno() != true) {
				g6.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g7.isLleno() != true) {
				g7.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			} else if (g8.isLleno() != true) {
				g8.agregarEntrenador(this.participantes.get(i));
				this.participantes.remove(i);
			}

		}
		this.grupos.add(g1);
		this.grupos.add(g2);
		this.grupos.add(g3);
		this.grupos.add(g4);
		this.grupos.add(g5);
		this.grupos.add(g6);
		this.grupos.add(g7);
		this.grupos.add(g8);
	}

	/**
	 * Inicia el motor de competicion. Posee un arraylist de participantes. Mientras
	 * haya mas de 1 clasificado seguira jugando rondas entre los participantes
	 */
	public void arrancaTorneo() {
		this.clasificados = (ArrayList<Entrenador>) this.participantes.clone();
		if (clasificados.size() == this.cantidadDeParticipantes) {
			while (clasificados.size() != 1) {
				this.juegaRonda(clasificados.size());
			}
			System.out.println("El campeon es " + this.clasificados.get(0));
		}
	}

	public void setCantidadDeParticipantes(int cantidadDeParticipantes) {
		this.cantidadDeParticipantes = cantidadDeParticipantes;
	}

	/**
	 * @param ronda es el numero de ronda en la que se encuentra el torneo.
	 */
	private void juegaRonda(int ronda) {
		switch (ronda) {
		case 32:
			System.out.println("Decisiesavos");
			break;
		case 16:
			System.out.println("Octavos");
			break;
		case 8:
			System.out.println("Cuartos");
			break;
		case 4:
			System.out.println("Semis");
			break;
		case 2:
			System.out.println("Final");
			break;
		}

		for (int i = 0; i < clasificados.size(); i++) {
			Entrenador e1, e2, perdedor;
			e1 = this.clasificados.get(i);
			e2 = this.clasificados.get(i + 1);
			Enfrentamiento n = new Enfrentamiento(e1, e2);
			n.batalla(e1, e2);
			enfrentamientos.add(n);
			perdedor = n.getPerdedor();
			this.clasificados.remove(perdedor);
			System.out.println(n);
			// System.out.println(clasificados);
		}
	}

	@Override
	public String toString() {
		String aux = "Lista de participantes: \n";
		for (Entrenador e : participantes)
			aux += e.toString() + "\n";
		return aux;
	}

	/**
	 * @param tipo String con el texto que debera chequear si es un pokemon
	 * @return Falso si no es un tipo valido de Pokemon, verdadero si lo es
	 * @throws PokemonInvalidoException excepcion que avisa que no se ha ingresado
	 *                                  correctamente un pokemon.
	 */
	public boolean validaPokemon(String tipo) throws PokemonInvalidoException {
		boolean respuesta = false;
		if (tipo == "fuego" || tipo == "agua" || tipo == "electricidad" || tipo == "hielo" || tipo == "psiquico"
				|| tipo == "tierra")
			respuesta = true;
		else
			throw new PokemonInvalidoException("Tipo de pokemon invalido, ingrese un tipo correcto");
		return respuesta;
	}
}
