package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import hechizos.Niebla;
import hechizos.Tormenta;
import hechizos.Viento;
import interfaces.ICarta;
import personajes.Entrenador;
import personajes.PokemonFactory;

public class Prueba {

	public static void main(String[] args) {
		ICarta[] cartas = new ICarta[3];
		Niebla cartaniebla = new Niebla();
		Tormenta cartatormenta = new Tormenta();
		Viento cartaviento = new Viento();
		cartas[0]=cartaviento;
		cartas[1]=cartatormenta;
		cartas[2]=cartaniebla;
		String cadena, nombre, nombreP, tipoP;
		int participantes = 1, cantidad = 0;
		Torneo torneo = Torneo.getInstanceSingleton();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al torneo Pokemon \n");
		System.out.println("Ingrese la cantidad de participantes en el torneo: ");
		while (participantes < 2) {
			try {
				cadena = scanner.nextLine();
				participantes = Integer.parseInt(cadena);

			} catch (NumberFormatException e) {
				System.out.println("Numero no valido, ingrese un entero positivo mayor a 1");

			}
		}
		System.out.println("Participaran " + participantes + " entrenadores");
		torneo.setCantidadDeParticipantes(participantes);
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
		System.out.println(torneo.getEntrenadores().size());
		System.out.println(torneo);
		System.out.println("Participantes correctamente cargados, inciando torneo...");
		torneo.arrancaTorneo();
	}

}
