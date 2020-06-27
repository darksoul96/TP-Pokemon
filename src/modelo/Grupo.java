package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedMap;

import personajes.Entrenador;
import java.util.SortedSet;
import java.util.TreeSet;

public class Grupo implements Serializable {
	private ArrayList<Entrenador> integrantes;
	private ArrayList<Enfrentamiento> enfrentamientos;
	private String nombre;
	private boolean lleno = false;
	boolean grupoFinalizado = false;
	int cantidadEf;

	public Grupo(String nombre) {
		super();
		this.integrantes = new ArrayList<Entrenador>();
		this.enfrentamientos = new ArrayList<Enfrentamiento>();
		this.nombre = nombre;
		this.cantidadEf =0;
	}

	public void agregarEntrenador(Entrenador e) {
		if (lleno != true)
			integrantes.add(e);
		if (integrantes.size() == 4) {
			lleno = true;
		}
	}

	public Enfrentamiento generaEnfrentamiento() {
		Enfrentamiento e = new Enfrentamiento();
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
		//Collections.sort(this.integrantes);
		Entrenador[]clasificados = new Entrenador[4];
		for(int i=0;i<this.integrantes.size();i++) {
			clasificados[i] = this.integrantes.get(i);
		}
		Entrenador aux;
		for(int i=0;i<this.integrantes.size()-1;i++) {
			for(int j=0;j<this.integrantes.size()-i-1;j++) {
				if(clasificados[j].compareTo(clasificados[j+1])>0) {
					System.out.println(clasificados [j] + " es mayor a " + clasificados[j+1]);
					aux = clasificados[j+1];
					clasificados[j+1] = clasificados[j];
					clasificados[j] = aux;
				}
			}
		}
		this.integrantes.removeAll(this.integrantes);
		for(int i=0;i<4;i++) {
			this.integrantes.add(clasificados[i]);
		}
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
