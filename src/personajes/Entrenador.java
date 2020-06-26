package personajes;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import exceptions.CantidadHechizosExcedidosException;
import hechizos.Niebla;
import hechizos.Tormenta;
import hechizos.Viento;
import interfaces.Clasificable;
import interfaces.ICarta;

/**
 * Clase entrenador que posee Nombre, cantidad de hechizos utilizados, cartas
 * con hechizos, y una lista con sus pokemones.
 *
 */
public class Entrenador implements Comparable<Entrenador>, Cloneable, Clasificable, Serializable {

	private String nombre;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private int cantidadHechizos;
	private ICarta[] cartas = new ICarta[3];
	private ICarta hechizoActivo;
	private Pokemon pokemonActivo;

	public Entrenador(String nombre) {
		this.nombre = nombre;
		this.cantidadHechizos = 2;
		cartas[0] = new Viento();
		cartas[1] = new Tormenta();
		cartas[2] = new Niebla();
		this.cartas = cartas;
	}

	public Entrenador() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	/**
	 * Agrega un pokemon a la lista de pokemones del entrenador, a menos que ya lo
	 * tuviese.
	 * 
	 * @param pokemon no nulo
	 */
	public void agregarPokemon(Pokemon pokemon) {
		if (!this.pokemones.contains(pokemon))
			this.pokemones.add(pokemon);
	}

	public void eliminarPokemon(Pokemon p) {
		this.pokemones.remove(p);
	}

	public ICarta[] getCartas() {
		return cartas;
	}

	/**
	 * @return Una carta para utilizar en un combate
	 * @throws CantidadHechizosExcedidosException Si ya se excedio la cantida de
	 *                                            cartas para usar, sale una
	 *                                            excepcion.
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
		aux = this.getNombre() + " C: " + this.calculaClasificacion();
		return aux;
	}

	/**
	 * Calcula la clasificacion del Entrenador en base a la experiencia de sus
	 * pokemones.
	 */
	@Override
	public double calculaClasificacion() {
		char rango;
		double experiencia = 0;
		for (Pokemon p : this.pokemones)
			experiencia += p.experiencia;

		if (experiencia >= 12)
			rango = '4';
		else if (experiencia >= 10)
			rango = '3';
		else if (experiencia >= 4)
			rango = '2';
		else if (experiencia >= 1)
			rango = '1';
		else
			rango = '0';
		return experiencia ;
	}

	/**
	 * Premio que reciben los pokemones de un entrenador al ganar una batalla.
	 */
	public void premio() {
		for (Pokemon p : this.pokemones)
			p.buffear();
	}

	public ICarta getHechizoActivo() {
		return hechizoActivo;
	}

	public void setHechizoActivo(ICarta hechizoActivo) {
		this.hechizoActivo = hechizoActivo;
	}

	public Pokemon getPokemonActivo() {
		return pokemonActivo;
	}

	public void setPokemonActivo(Pokemon pokemonActivo) {
		this.pokemonActivo = pokemonActivo;
	}

	@Override
	public int compareTo(Entrenador otro) {
		int resultado;
		System.out.println("Entrenador A :" +this.getNombre() + "PUNTOS: " + this.calculaClasificacion() + "Entrenador B: "+ otro.getNombre() + "Clasificacion: "+otro.calculaClasificacion());
		if(this.calculaClasificacion() > otro.calculaClasificacion()) {
			resultado = 1;
		}
		else {
			if(this.calculaClasificacion() == otro.calculaClasificacion()) {
				resultado =0;
			}
			else {
				resultado = -1;
			}
		}

		return resultado;
	}

}
