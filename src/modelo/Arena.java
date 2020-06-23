package modelo;

import java.io.Serializable;

import interfaces.IStateArena;

public class Arena implements Serializable {
	
	private String nombreArena;
	private IStateArena estado;
	
	
	public Arena(String nombre) {
		this.nombreArena=nombre;
		this.estado=new PreliminarState(this);
	}
	
	public Arena() {}
	
	public void comenzar(Enfrentamiento enfrentamiento) {
		this.estado.comenzar(enfrentamiento);
	}

	
	public IStateArena getEstado() {
		return estado;
	}

	public void setEstado(IStateArena estado) {
		this.estado = estado;
	}

	public String getNombreArena() {
		return nombreArena;
	}

	public void setNombreArena(String nombreArena) {
		this.nombreArena = nombreArena;
	}
	
	
}
