package modelo;

import java.util.ArrayList;

import exception.PokemonInvalidoException;
import exceptions.CantidadHechizosExcedidosException;
import personajes.Entrenador;

public class Torneo {

	private static Torneo torneo;
	private ArrayList<Entrenador> participantes;
	private ArrayList<Entrenador> clasificados;
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

	public void arrancaTorneo() {
		this.clasificados = (ArrayList<Entrenador>) this.participantes.clone();
		if (clasificados.size() == this.cantidadDeParticipantes) {
			while (clasificados.size() != 1) {
				this.juegaRonda(clasificados.size());
			}
		}
	}

	public void setCantidadDeParticipantes(int cantidadDeParticipantes) {
		this.cantidadDeParticipantes = cantidadDeParticipantes;
	}

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
		
		for (int i=0;i<clasificados.size();i++) {
			Entrenador e1,e2,perdedor;
			e1=this.clasificados.get(i);
			e2=this.clasificados.get(i+1);
			Enfrentamiento n = new Enfrentamiento(e1, e2);
			n.batalla(e1, e2);
			enfrentamientos.add(n);
			perdedor = n.getPerdedor();
			this.clasificados.remove(perdedor);
			System.out.println(n);
			System.out.println(clasificados);
		}
	}

	@Override
	public String toString() {
		String aux = "Lista de participantes: \n";
		for (Entrenador e : participantes)
			aux += e.toString() + "\n";
		return aux;
	}
	
	public boolean validaPokemon(String tipo) throws PokemonInvalidoException {
		boolean respuesta=false;
		if (tipo=="fuego" || tipo=="agua" || tipo=="electricidad" || tipo=="hielo" || tipo=="psiquico" || tipo=="tierra")
			respuesta=true;
		else
			throw new PokemonInvalidoException("Tipo de pokemon invalido, ingrese un tipo correcto");
		return respuesta;
	}
}
