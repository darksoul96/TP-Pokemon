package personajes;

public class EntrenadorFactory {
	
	public static Entrenador fabricaEntrenador(String Nombre)
	{
		Entrenador entrenador = null;
		if(Nombre==null)
			entrenador = null;
		else
			entrenador = new Entrenador(Nombre);
		return entrenador;

	}

}
