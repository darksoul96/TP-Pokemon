package personajes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Entrenador implements Cloneable {

	private String nombre;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private int hechizos;

	public Entrenador(String nombre) {
		this.nombre = nombre;
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Entrenador entrenadorClonado = (Entrenador) super.clone();
		// for (int i = 0; i <= this.pokemones.size(); i++)
		// entrenadorClonado.pokemones.add(this.pokemones.get(i));

		for (Pokemon p : this.pokemones)
			entrenadorClonado.pokemones.add((Pokemon) p.clone());

		return entrenadorClonado;
	}
}
