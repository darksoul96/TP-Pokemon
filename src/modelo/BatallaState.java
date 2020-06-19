package modelo;

import interfaces.IStateArena;

public class BatallaState implements IStateArena {

	private Arena arena;
	
	public BatallaState(Arena arena) {
		this.arena=arena;
	}

	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		// TODO Auto-generated method stub
		
	}



}
