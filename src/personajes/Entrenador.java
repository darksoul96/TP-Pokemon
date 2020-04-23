package personajes;
import java.util.ArrayList;

public class Entrenador {

	private String nombre;
	private ArrayList<Pokemon> pokemones;
	private int hechizos;

	public Entrenador(String nombre) {
		this.nombre = nombre;
		this.pokemones = new ArrayList<Pokemon>();
		this.hechizos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getPokemones() {
		return pokemones;
	}

	public int getHechizos() {
		return hechizos;
	}

	public void setHechizos(int hechizos) {
		this.hechizos = hechizos;
	}

}
