package modelo;

import java.util.Scanner;

import exceptions.PokemonInvalidoException;
import hechizos.Niebla;
import hechizos.Tormenta;
import hechizos.Viento;
import interfaces.ICarta;
import personajes.Entrenador;
import personajes.PokemonFactory;

/**
 * Este metodo permite simular un torneo en base a datos precargados o datos
 * ingresados por teclado. Se debe tener en cuenta a la hora de ingresar datos a
 * mano el lanzamiento de exceptions para datos no validos.
 */
public class Prueba {

	public static void main(String[] args) {
		ICarta[] cartas = new ICarta[3];
		Torneo torneo = Torneo.getInstanceSingleton();
		Niebla cartaniebla = new Niebla();
		Tormenta cartatormenta = new Tormenta();
		Viento cartaviento = new Viento();
		cartas[0] = cartaviento;
		cartas[1] = cartatormenta;
		cartas[2] = cartaniebla;
		String cadena, nombre, nombreP, tipoP;
		int participantes = 16, cantidad = 0;
		System.out.println("Bienvenido al torneo Pokemon \n");
		System.out.println("Participaran " + participantes + " entrenadores");
		torneo.setCantidadDeParticipantes(participantes);
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Si desea ejecutar el paquete de entrenadores prearmado, ingrese S, sino ingrese cualquier tecla");
		cadena = scanner.nextLine();
		if (cadena.equalsIgnoreCase("S")) {
			Entrenador e1 = new Entrenador("Juan", cartas);
			e1.agregarPokemon(PokemonFactory.fabricaPokemon("Pikachu", "Electricidad", true));
			e1.agregarPokemon(PokemonFactory.fabricaPokemon("PokemondeTierra", "Tierra", true));
			Entrenador e2 = new Entrenador("Pedro", cartas);
			e2.agregarPokemon(PokemonFactory.fabricaPokemon("Squirtle", "Agua", true));
			Entrenador e3 = new Entrenador("Carlos", cartas);
			e3.agregarPokemon(PokemonFactory.fabricaPokemon("Dragon", "Fuego", true));
			Entrenador e4 = new Entrenador("Ash", cartas);
			e4.agregarPokemon(PokemonFactory.fabricaPokemon("Tortuga", "Tierra", true));
			Entrenador e5 = new Entrenador("Brock", cartas);
			e5.agregarPokemon(PokemonFactory.fabricaPokemon("Cubito", "Hielo", false, true));
			Entrenador e6 = new Entrenador("Legolas", cartas);
			e6.agregarPokemon(PokemonFactory.fabricaPokemon("Pato", "Psiquico", true));
			Entrenador e7 = new Entrenador("Goku", cartas);
			e7.agregarPokemon(PokemonFactory.fabricaPokemon("Charizard", "Fuego", true));
			Entrenador e8 = new Entrenador("Gandalf", cartas);
			e8.agregarPokemon(PokemonFactory.fabricaPokemon("Snorlax", "Tierra", true));
			Entrenador e9 = new Entrenador("Avatar", cartas);
			e9.agregarPokemon(PokemonFactory.fabricaPokemon("Momo", "Tierra", true));
			Entrenador e10 = new Entrenador("Mario", cartas);
			e10.agregarPokemon(PokemonFactory.fabricaPokemon("Luigi", "Fuego", true));
			Entrenador e11 = new Entrenador("Link", cartas);
			e11.agregarPokemon(PokemonFactory.fabricaPokemon("Raichu", "Electricidad", true));
			Entrenador e12 = new Entrenador("Steve", cartas);
			e12.agregarPokemon(PokemonFactory.fabricaPokemon("Ponyta", "Fuego", true));
			Entrenador e13 = new Entrenador("Master Chief", cartas);
			e13.agregarPokemon(PokemonFactory.fabricaPokemon("Alakazam", "Psiquico", true));
			Entrenador e14 = new Entrenador("Geralt", cartas);
			e14.agregarPokemon(PokemonFactory.fabricaPokemon("Arceus", "Tierra", true));
			Entrenador e15 = new Entrenador("Jaina", cartas);
			e15.agregarPokemon(PokemonFactory.fabricaPokemon("Cloyster", "Hielo", false, true));
			Entrenador e16 = new Entrenador("Illidan", cartas);
			e16.agregarPokemon(PokemonFactory.fabricaPokemon("Entei", "Fuego", true));
			torneo.agregarEntrenador(e1);
			torneo.agregarEntrenador(e2);
			torneo.agregarEntrenador(e3);
			torneo.agregarEntrenador(e4);
			torneo.agregarEntrenador(e5);
			torneo.agregarEntrenador(e6);
			torneo.agregarEntrenador(e7);
			torneo.agregarEntrenador(e8);
			torneo.agregarEntrenador(e9);
			torneo.agregarEntrenador(e10);
			torneo.agregarEntrenador(e11);
			torneo.agregarEntrenador(e12);
			torneo.agregarEntrenador(e13);
			torneo.agregarEntrenador(e14);
			torneo.agregarEntrenador(e15);
			torneo.agregarEntrenador(e16);
		} else {
			for (int i = 1; i <= participantes; i++) {
				System.out.println("Ingrese el nombre del entrenador: " + i);
				nombre = scanner.nextLine();
				Entrenador e1 = new Entrenador(nombre, cartas);
				System.out.println("Ingrese cuantos pokemones tiene " + nombre);
				cadena = scanner.nextLine();
				try {
					cantidad = Integer.parseInt(cadena);
				} catch (NumberFormatException e) {
					System.out.println("Numero no valido, ingrese un entero positivo mayor a 1");
				}
				for (int j = 1; j <= cantidad; j++) {
					System.out.println("Ingrese el nombre del pokemon " + j);
					nombreP = scanner.nextLine();
					System.out.println("Ingrese el tipo del pokemon " + j);
					cadena = scanner.nextLine();
					try {
						torneo.validaPokemon(cadena);
					} catch (PokemonInvalidoException e) {
						System.out.println(e.getMessage());
					} finally {
						tipoP = scanner.nextLine();
						if (tipoP.equalsIgnoreCase("Hielo")) {
							System.out.println("Tiene gran recarga? S/N");
							cadena = scanner.nextLine();
							if (cadena.equalsIgnoreCase("S"))
								e1.agregarPokemon(PokemonFactory.fabricaPokemon(nombreP, tipoP, false, true));
							else {
								System.out.println("Tiene recarga? S/N");
								cadena = scanner.nextLine();
								if (cadena.equalsIgnoreCase("S"))
									e1.agregarPokemon(PokemonFactory.fabricaPokemon(nombreP, tipoP, true));
							}
						} else {
							System.out.println("Tiene recarga? S/N");
							cadena = scanner.nextLine();
							if (cadena.equalsIgnoreCase("S"))
								e1.agregarPokemon(PokemonFactory.fabricaPokemon(nombreP, tipoP, true));
							else
								e1.agregarPokemon(PokemonFactory.fabricaPokemon(nombreP, tipoP, false));
						}
						torneo.agregarEntrenador(e1);
					}
				}
			}

		}
		System.out.println(torneo.getEntrenadores().size());
		System.out.println(torneo);
		System.out.println("Participantes correctamente cargados, inciando torneo... \n");
		torneo.arrancaTorneo();
	}

}
