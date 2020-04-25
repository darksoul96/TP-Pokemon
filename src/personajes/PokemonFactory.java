package personajes;

public class PokemonFactory {
	
	public static Pokemon fabricaPokemon(String nombre,String tipo,boolean recarga) {
		Pokemon pokemon = null;
		if (tipo==null)
			pokemon = null;
		else if(tipo=="Agua")
			pokemon = new Agua(nombre,recarga);
		else if (tipo=="Hielo")
			pokemon = new Hielo(nombre,recarga,false);
		else if (tipo=="Fuego")
			pokemon = new Fuego(nombre,recarga);
		else if (tipo=="Electricidad")
			pokemon = new Electricidad(nombre,recarga);
		else if (tipo=="Psiquico")
			pokemon = new Psiquico(nombre,recarga);
		else if (tipo=="Tierra")
			pokemon = new Tierra(nombre,recarga);
		return pokemon;
	}
	// CACA PERO NO ME GUSTA TAMPOCO PASAR POR PARAMETRO GRANRECARGA A LOS OTROS QUE NI LA USAN.
	public static Pokemon fabricaPokemon(String nombre,String tipo, boolean recarga, boolean granRecarga) {
		Pokemon pokemon = null;
		if(tipo==null)
			pokemon = null;
		else if (tipo=="Hielo")
			pokemon = new Hielo(nombre,recarga,granRecarga);
		return pokemon;
		
	}
	
}
