package modelo;

import java.util.concurrent.TimeUnit;
import interfaces.IStateArena;

public class PreliminarState implements IStateArena {

	private Arena arena;
	
	public PreliminarState(Arena arena) {
		this.arena=arena;
	}


	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BatallaState n = new BatallaState(arena);
		arena.setEstado(n);
		
	}
	
	

}
