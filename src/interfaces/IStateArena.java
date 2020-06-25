package interfaces;

import modelo.Enfrentamiento;

public interface IStateArena {

	void comenzar(Enfrentamiento enfrentamiento);
	String getNombre();
}
