package modelo;

import java.util.ArrayList;

import personajes.Entrenador;

public class Torneo {

	private static Torneo torneo;
	private ArrayList<Entrenador> participantes;
	private ArrayList<Entrenador> clasificados;
	private ArrayList<Enfrentamiento> enfrentamientos;
	private int cantidadDeParticipantes;

	private Torneo() {
		this.participantes = new ArrayList<Entrenador>();
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
		int aux;
		switch (ronda) {
		case 32:
			System.out.println("Decisiesavos");
		case 16:
			System.out.println("Octavos");
		case 8:
			System.out.println("Cuartos");
		case 4:
			System.out.println("Semis");
		case 2:
			System.out.println("Final");
		}
		for (aux = 0; aux < clasificados.size(); aux++) {
			Entrenador perdedor;
			Enfrentamiento n = new Enfrentamiento(this.clasificados.get(aux), this.clasificados.get(aux + 1));
			enfrentamientos.add(n);
			if (n.getPerdedor() == n.getEntrenadorDos().getNombre()) { // esto es super CACA
				perdedor = n.getEntrenadorDos();
			} else {
				perdedor = n.getEntrenadorUno();
			}
			this.clasificados.remove(perdedor);
		}
	}
	
	@Override
	public String toString() {
		String aux = "Lista de participantes: \n";
		for(Entrenador e : participantes)
			aux += e.toString();
		return aux;
	}
}
