package modelo;

import java.io.Serializable;
import java.util.Observable;

import interfaces.IStateArena;

public class Arena extends Observable implements Serializable {
	
	private String nombreArena;
	private IStateArena estado;
	
	
	public Arena(String nombre) {
		this.nombreArena=nombre;
		this.estado=new PreliminarState(this);
	}
	
	public Arena() {}
	
	public synchronized void comenzar(Enfrentamiento enfrentamiento) {
		this.estado.comenzar(enfrentamiento);
	}

	
	public IStateArena getEstado() {
		return estado;
	}

	public synchronized void setEstado(IStateArena estado) {
		this.notifyObservers(estado.getNombre());
		this.estado = estado;
	}

	public String getNombreArena() {
		return nombreArena;
	}

	public void setNombreArena(String nombreArena) {
		this.nombreArena = nombreArena;
	}
	
	
}
