package modelo;

import interfaces.IStateArena;

public class Arena {
	
	private String nombreArena;
	private IStateArena estado;
	
	
	public Arena(String nombre) {
		this.nombreArena=nombre;
		this.estado=new PreliminarState(this);
	}
	
	public void comenzar(Enfrentamiento enfrentamiento) {
		
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

}
