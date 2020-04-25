package modelo;
import java.util.ArrayList;

import personajes.Entrenador;

public class Torneo {

	private static Torneo torneo;
	private ArrayList<Entrenador> entrenadores;
	private ArrayList<Enfrentamiento> enfrentamientos;

	private Torneo() {
		this.entrenadores = new ArrayList<Entrenador>();
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
		return entrenadores;
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

}
