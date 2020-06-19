package modelo;

import java.util.ArrayList;

import personajes.Entrenador;

public class Grupo {
	private ArrayList<Entrenador> integrantes;
	private String Nunero;
	private boolean lleno = false;
	boolean grupoFinalizado = false;

	public void agregarEntrenador(Entrenador e) {
		if (lleno != true)
			integrantes.add(e);
		if (integrantes.size() == 4) {
			lleno = true;
		}
	}

	synchronized public Enfrentamiento generaEnfrentamiento(Enfrentamiento ef) {
		
		return null;
	}

	public boolean isLleno() {
		return lleno;
	}

}
