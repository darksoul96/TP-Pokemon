package modelo;

import java.util.Scanner;

import exceptions.PokemonInvalidoException;
import hechizos.Niebla;
import hechizos.Tormenta;
import hechizos.Viento;
import interfaces.ICarta;
import personajes.Entrenador;
import personajes.PokemonFactory;

public class Prueba {
	
	public static void main(String[] args) {
		ICarta[] cartas = new ICarta[3];
		Torneo torneo = Torneo.getInstanceSingleton();
		Niebla cartaniebla = new Niebla();
		Tormenta cartatormenta = new Tormenta();
		Viento cartaviento = new Viento();
		cartas[0]=cartaviento;
		cartas[1]=cartatormenta;
		cartas[2]=cartaniebla;
		String cadena, nombre, nombreP, tipoP;
		int participantes = 8, cantidad = 0;
		System.out.println("Bienvenido al torneo Pokemon \n");
		System.out.println("Participaran " + participantes + " entrenadores");
		torneo.setCantidadDeParticipantes(8);
		Scanner scanner = new Scanner(System.in);
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
				cadena=scanner.nextLine();
				try {
					torneo.validaPokemon(cadena);
				} catch (PokemonInvalidoException e) {
					System.out.println(e.getMessage());
				}
				finally {
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
		System.out.println(torneo.getEntrenadores().size());
		System.out.println(torneo);
		System.out.println("Participantes correctamente cargados, inciando torneo...");
		torneo.arrancaTorneo();
	}

}
