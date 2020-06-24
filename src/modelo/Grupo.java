package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedMap;

import personajes.Entrenador;
import java.util.SortedSet;

public class Grupo {
	private ArrayList<Entrenador> integrantes;
	private ArrayList<Enfrentamiento> enfrentamientos;
	private ArrayList<Entrenador> ganadores;
	private String nombre;
	private boolean lleno = false;
	boolean grupoFinalizado = false;
	int cantidadEf = 0;

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void agregarEntrenador(Entrenador e) {
		if (lleno != true)
			integrantes.add(e);
		if (integrantes.size() == 4) {
			lleno = true;
		}
	}

	public Enfrentamiento generaEnfrentamiento() {
		Enfrentamiento e = null;
		switch (this.cantidadEf) {
		case 0:
			e = new Enfrentamiento(integrantes.get(0), integrantes.get(1));
			this.cantidadEf++;
			this.enfrentamientos.add(e);
			break;
		case 1:
			e = new Enfrentamiento(integrantes.get(2), integrantes.get(3));
			this.cantidadEf++;
			this.enfrentamientos.add(e);
			break;
		case 2:
			e = new Enfrentamiento(integrantes.get(0), integrantes.get(2));
			this.cantidadEf++;
			this.enfrentamientos.add(e);
			break;
		case 3:
			e = new Enfrentamiento(integrantes.get(1), integrantes.get(3));
			this.cantidadEf++;
			this.enfrentamientos.add(e);
			break;
		case 4:
			e = new Enfrentamiento(integrantes.get(0), integrantes.get(3));
			this.cantidadEf++;
			this.enfrentamientos.add(e);
			break;
		case 5:
			e = new Enfrentamiento(integrantes.get(1), integrantes.get(2));
			this.cantidadEf++;
			this.enfrentamientos.add(e);
			this.grupoFinalizado = true;
			break;
		}
		return e;
	}
	
	public ArrayList<Entrenador> getPosiciones() {
		int n = enfrentamientos.size();
		ArrayList<Entrenador> posiciones = new ArrayList<Entrenador>();
		ArrayList<Integer> victorias = new ArrayList<Integer>();
		int e1 = 0;
		int e2 = 0;
		int e3 = 0;
		int e4 = 0;
		Entrenador e;
		for (int i = 0; i < n; i++) {
			e = enfrentamientos.get(i).getGanador();
			if(e.equals(integrantes.get(0)))
				e1++;
			else if(e.equals(integrantes.get(1)))
				e2++;
			else if(e.equals(integrantes.get(2)))
				e3++;
			else if(e.equals(integrantes.get(3)))
				e4++;
		}
		victorias.add(e1);
		victorias.add(e2);
		victorias.add(e3);
		victorias.add(e4);
		return ganadores;
	}

	public boolean isLleno() {
		return lleno;
	}

	public boolean isGrupoFinalizado() {
		return grupoFinalizado;
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

	public String getNombre() {
		return nombre;
	}

}
