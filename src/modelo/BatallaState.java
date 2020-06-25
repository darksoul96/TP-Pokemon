package modelo;

import java.io.Serializable;

import interfaces.IStateArena;

public class BatallaState implements IStateArena, Serializable {

	private Arena arena;
	private String nombre;
	
	public BatallaState(Arena arena) {
		this.arena=arena;
		this.nombre = "BatallaState";
	}

	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}



}
