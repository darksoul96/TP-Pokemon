package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
import exceptions.PokemonInvalidoException;
import personajes.Entrenador;

/**
 * La clase Torneo sera instanciada una sola vez y es donde se ejecutaran los
 * metodos de competicion del Torneo.
 *
 */
public class Torneo extends Observable implements Serializable {

	private static Torneo torneo;
	private ArrayList<Entrenador> participantes;
	private ArrayList<Entrenador> clasificados;
	private ArrayList<Grupo> grupos;
	private int cantidadDeParticipantes;
	private Arena[] arenas;
	private int fase;

	private Torneo() {
		this.participantes = new ArrayList<Entrenador>();
		this.clasificados = new ArrayList<Entrenador>();
		this.fase =0;
	}

	public static Torneo getInstanceSingleton() {
		if (torneo == null)
			torneo = new Torneo();
		else
			System.out.println("Ya existe instancia de torneo");
		return torneo;
	}

	public ArrayList<Entrenador> getParticipantes() {
		return participantes;
	}
	
	

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}


	public void setParticipantes(ArrayList<Entrenador> participantes) {
		this.participantes = participantes;
	}

	public void eliminarEntrenador(Entrenador e){
		this.participantes.remove(e);
	}
	
	public void agregarEntrenador(Entrenador entrenador) {
		this.participantes.add(entrenador);
	}

	private void inicializarArenas() {
		arenas[0] = new Arena("Arena 1");
		arenas[1] = new Arena("Arena 2");
		arenas[2] = new Arena("Arena 3");
		arenas[3] = new Arena("Arena 4");
	}

	public void generaGrupos(ArrayList<Entrenador> participantes) {
		Grupo g1 = new Grupo("Grupo 1");
		Grupo g2 = new Grupo("Grupo 2");
		Grupo g3 = new Grupo("Grupo 3");
		Grupo g4 = new Grupo("Grupo 4");
		Grupo g5 = new Grupo("Grupo 5");
		Grupo g6 = new Grupo("Grupo 6");
		Grupo g7 = new Grupo("Grupo 7");
		Grupo g8 = new Grupo("Grupo 8");
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

	public void faseDeSorteo() {
		inicializarArenas();
		//Collections.shuffle(participantes);
		generaGrupos(participantes);
		this.fase =1;
		this.notifyObservers(fase);
	}

	public void faseDeGrupos() {
		boolean faseDeGruposFinalizada = false;
		Enfrentamiento[] enfrentamientos = new Enfrentamiento[8];
		Random r = new Random();
		int contador = 0;
		while (faseDeGruposFinalizada == false) {
			for (int i = 0; i < 8; i++) {
				enfrentamientos[i] = grupos.get(i).generaEnfrentamiento();
				if (enfrentamientos[i] != null)
					enfrentamientos[i].setRecursoCompartido(arenas[r.nextInt(3)]);
				if (grupos.get(i).isGrupoFinalizado() == true) {
					contador++;
					if (contador == 8) {
						faseDeGruposFinalizada = true;
					}
				}
			}
			contador = 0;
			for (int i = 0; i < 8; i++)
				enfrentamientos[i].start();
		}
		for (int i = 0; i < 8; i++) {
			this.clasificados.add(this.grupos.get(i).getIntegrantes().get(0));
			this.clasificados.add(this.grupos.get(i).getIntegrantes().get(1));
		}
		Collections.shuffle(clasificados);
		this.fase = 2;
		this.notifyObservers(fase);
	}

	public void faseEliminatoriaSiguiente() {
		if (clasificados.size() != 1) {
			this.juegaRonda(clasificados.size());
		}
		this.notifyObservers(fase);
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
			this.notifyObservers("Dieciseisavos");
			break;
		case 16:
			this.notifyObservers("Octavos");
			break;
		case 8:
			this.notifyObservers("Cuartos");
			break;
		case 4:
			this.notifyObservers("Semis");
			break;
		case 2:
			this.notifyObservers("Final");
			break;
		}
		Random r = new Random();
		int batallas = this.clasificados.size() /2;
		ArrayList <Enfrentamiento> enfrentamientos = new ArrayList<Enfrentamiento>();
		for (int i = 0; i < batallas ; i=i+2) {
			Entrenador e1 = this.clasificados.get(i);
			Entrenador e2 = this.clasificados.get(i + 1);
			Enfrentamiento n = new Enfrentamiento(e1, e2);
			n.setRecursoCompartido(arenas[r.nextInt(3)]);
			enfrentamientos.add(n);
		}
		for(int i = 0; i<batallas ; i++) {
			enfrentamientos.get(i).start();
		}
		Entrenador perdedor;
		for(int i = 0; i<batallas;i++) {
			perdedor = enfrentamientos.get(i).getPerdedor();
			this.clasificados.remove(perdedor);
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

	public Iterator devuelveIteratorEntrenador() {
		return this.participantes.iterator();
	}

	public Iterator devuelveIteratorPokemon(Entrenador entrenador) {
		return entrenador.getPokemones().iterator();
	}

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}
	
	
}
