package modelo;

import java.util.ArrayList;

import personajes.Entrenador;

public class Grupo {
	private ArrayList<Entrenador> integrantes;
	private String Numero;
	private boolean lleno = false;
	boolean grupoFinalizado = false;
	int cantidadEf =0;

	public void agregarEntrenador(Entrenador e) {
		if (lleno != true)
			integrantes.add(e);
		if (integrantes.size() == 4) {
			lleno = true;
		}
	}

	public synchronized  Enfrentamiento generaEnfrentamiento() {
		Enfrentamiento e = null;
		switch(this.cantidadEf) {
		case 0:
			e = new Enfrentamiento(integrantes.get(0),integrantes.get(1));
			this.cantidadEf++;
			break;
		case 1:
			e = new Enfrentamiento(integrantes.get(2),integrantes.get(3));
			this.cantidadEf++;
			break;
		case 2:
			e = new Enfrentamiento(integrantes.get(0),integrantes.get(2));
			this.cantidadEf++;
			break;
		case 3:
			e = new Enfrentamiento(integrantes.get(1),integrantes.get(3));
			this.cantidadEf++;
			break;
		case 4:
			e = new Enfrentamiento(integrantes.get(0),integrantes.get(3));
			this.cantidadEf++;
			break;
		case 5:
			e = new Enfrentamiento(integrantes.get(1),integrantes.get(2));
			this.cantidadEf++;
			this.grupoFinalizado = true;
			break;
		}
		return e;
	}

	public boolean isLleno() {
		return lleno;
	}

}
