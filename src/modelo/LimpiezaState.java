package modelo;

import java.util.concurrent.TimeUnit;

import interfaces.IStateArena;

public class LimpiezaState implements IStateArena {
	private String nombre;
	private Arena arena;

	public LimpiezaState(Arena arena) {
		super();
		this.arena = arena;
		this.nombre = "LimpiezaState";
	}

	@Override
	public void comenzar(Enfrentamiento enfrentamiento) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

}
