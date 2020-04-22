import java.util.ArrayList;

public class Arena {

	private static Arena arena;
	private ArrayList<Entrenador> entrenadores;

	private Arena() {
		this.entrenadores = new ArrayList<Entrenador>();
	}
	
	public static Arena getInstanceSingleton() {
		if(arena==null)
			arena = new Arena();
		else
			System.out.println("Ya existe instancia de arena");
		return arena;
	}

}
