package personajes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
import hechizos.Niebla;
import interfaces.Clasificable;
import interfaces.ICarta;

/**
 * Clase entrenador que posee Nombre, cantidad de hechizos utilizados, cartas con hechizos, y una lista con sus pokemones.
 *
 */
public class Entrenador implements Cloneable, Clasificable {

	private String nombre;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private int cantidadHechizos;
	private ICarta[] cartas = new ICarta[3];

	public Entrenador(String nombre, ICarta[] cartas) {
		this.nombre = nombre;
		this.cantidadHechizos = 2;
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

		Entrenador entrenadorClonado = (Entrenador) super.clone();

		for (Pokemon p : this.pokemones)
			entrenadorClonado.pokemones.add((Pokemon) p.clone());

		return entrenadorClonado;
	}

	/** Agrega un pokemon a la lista de pokemones del entrenador, a menos que ya lo tuviese.
	 * @param pokemon no nulo
	 */
	public void agregarPokemon(Pokemon pokemon) {
		if (!this.pokemones.contains(pokemon))
			this.pokemones.add(pokemon);
	}

	public ICarta[] getCartas() {
		return cartas;
	}

	/**
	 * @return Una carta para utilizar en un combate
	 * @throws Si ya se excedio la cantida de cartas para usar, sale una excepcion.
	 */
	public ICarta elegirCarta() throws CantidadHechizosExcedidosException {
		int indicecarta;
		Random r = new Random();
		indicecarta = r.nextInt(4);
		ICarta carta = null;
		if (indicecarta != 3) {
			if (this.getCantidadHechizos() == 0)
				throw new CantidadHechizosExcedidosException(
						"El entrenador " + this.nombre + " se quedo sin cartas de hechizo");
			else
				carta = cartas[indicecarta];
		}
		return carta;
	}

	@Override
	public String toString() {
		String aux;
		aux = "Entrenador: " + this.getNombre() + " Clasificacion: " + this.calculaClasificacion() + " Lista de pokemones: \n";
		for (Pokemon p : pokemones)
			aux += p.toString() + "\n";
		return aux;
	}

	/**
	 * Calcula la clasificacion del Entrenador en base a la experiencia de sus pokemones.
	 */
	@Override
	public char calculaClasificacion() {
		char rango;
		double experiencia = 0;
		for (Pokemon p : this.pokemones)
			experiencia += p.experiencia;
		experiencia /= this.pokemones.size();

		if (experiencia >= 12)
			rango = 'S';
		else if (experiencia >= 10)
			rango = 'A';
		else if (experiencia >= 4)
			rango = 'B';
		else if (experiencia >= 1)
			rango = 'C';
		else
			rango = 'D';
		return rango;
	}

	/**
	 * Premio que reciben los pokemones de un entrenador al ganar una batalla.
	 */
	public void premio() {
		for (Pokemon p : this.pokemones)
			p.buffear();
	}

}
