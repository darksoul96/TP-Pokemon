package personajes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import interfaces.ICarta;

public class Entrenador implements Cloneable {

	private String nombre;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private int hechizos;
	private ArrayList<ICarta> cartas=new ArrayList<ICarta>();

	public Entrenador(String nombre, ArrayList<ICarta> cartas) {
		this.nombre = nombre;
		this.hechizos = 0;
		this.cartas=cartas;
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

	public void agregarPokemon(Pokemon pokemon) {
		if (!this.pokemones.contains(pokemon))
			this.pokemones.add(pokemon);
	}

	public ArrayList<ICarta> getCartas() {
		return cartas;
	}
	
	
}
