package personajes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import interfaces.ICarta;

public class Entrenador implements Cloneable {

	private String nombre;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private int cantidadHechizos;
	private ArrayList<ICarta> cartas = new ArrayList<ICarta>();
	private int puntaje=0;

	public Entrenador(String nombre, ArrayList<ICarta> cartas) {
		this.nombre = nombre;
		this.cantidadHechizos = 0;
		this.cartas = cartas;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getPokemones() {
		return pokemones;
	}

	public int getCantidadHechizos() {
		return cantidadHechizos;
	}

	public void setCantidadHechizos(int hechizos) {
		this.cantidadHechizos = hechizos;
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

	public ICarta elegirCarta() {
		int indicecarta;
		Random r = new Random();
		indicecarta = r.nextInt(3);
		
		return this.getCartas().get(indicecarta);
	}
	

}
