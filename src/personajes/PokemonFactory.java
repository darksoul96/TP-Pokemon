package personajes;

public class PokemonFactory {
	
	public Pokemon PokemonFactory(String nombre, double escudo, double vitalidad, double ataque, String tipo) {
		if (tipo==null)
			return null;
		else if(tipo=="Agua")
			return new Agua(nombre,escudo,vitalidad,ataque);
		else if (tipo=="Hielo")
			return new Hielo(nombre,escudo,vitalidad,ataque);
		else if (tipo=="Fuego")
			return new Fuego(nombre,escudo,vitalidad,ataque);
		else if (tipo=="Electricidad")
			return new Electricidad(nombre,escudo,vitalidad,ataque);
		else if (tipo=="Psiquico")
			return new Psiquico(nombre,escudo,vitalidad,ataque);
		else if (tipo=="Tierra")
			return new Tierra(nombre,escudo,vitalidad,ataque);
		return null;
	}
	
}
