package modelo;

import java.io.Serializable;

import interfaces.IStateArena;

public class BatallaState implements IStateArena, Serializable {

	private Arena arena;
	
	public BatallaState(Arena arena) {
		this.arena=arena;
	}

	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		
		
	}



}
