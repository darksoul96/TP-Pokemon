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
		this.arena.setEstado(new LimpiezaState(arena));
		enfrentamiento.definicion();
		arena.comenzar(enfrentamiento);
		
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	

}
