import java.util.ArrayList;

public class Arena {

	private static Arena arena;
	private ArrayList<Entrenador> entrenadores;
	private ArrayList<Enfrentamiento> enfrentamientos;

	private Arena() {
		this.entrenadores = new ArrayList<Entrenador>();
		this.enfrentamientos = new ArrayList<Enfrentamiento>();
	}

	public static Arena getInstanceSingleton() {
		if (arena == null)
			arena = new Arena();
		else
			System.out.println("Ya existe instancia de arena");
		return arena;
	}

	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

}
