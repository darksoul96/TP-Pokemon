package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedMap;

import personajes.Entrenador;
import java.util.SortedSet;
import java.util.TreeSet;

public class Grupo {
	private ArrayList<Entrenador> integrantes;
	private ArrayList<Enfrentamiento> enfrentamientos;
	private String nombre;
	private boolean lleno = false;
	boolean grupoFinalizado = false;
	int cantidadEf = 0;

	public Grupo(String nombre) {
		super();
		this.integrantes = new ArrayList<Entrenador>();
		this.enfrentamientos = new ArrayList<Enfrentamiento>();
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
	
	public void actualizaPosiciones() {
		Collections.sort(this.integrantes);
	}

	public ArrayList<Entrenador> getIntegrantes() {
		return integrantes;
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
