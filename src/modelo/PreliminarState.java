package modelo;

import java.util.concurrent.TimeUnit;
import interfaces.IStateArena;

public class PreliminarState implements IStateArena {

	private Arena arena;
	private String nombre;
	
	public PreliminarState(Arena arena) {
		this.arena=arena;
		this.nombre = "PreliminarState";
		
	}


	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enfrentamiento.preparacionEntrenadores();
		arena.setEstado(new BatallaState(arena));
		arena.comenzar(enfrentamiento);
		
	}


	@Override
	public String getNombre() {
		return this.nombre;
	}
	
	
}
