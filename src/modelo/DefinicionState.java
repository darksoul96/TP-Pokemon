package modelo;

import interfaces.IStateArena;

public class DefinicionState implements IStateArena {

	private Arena arena;
	private String nombre;
	
	public DefinicionState(Arena arena) {
		this.arena=arena;
		this.nombre = "DefinicionState";
	}

	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	

}
