package modelo;
import personajes.Entrenador;

public class Enfrentamiento {

	private Entrenador entrenadorUno;
	private Entrenador entrenadorDos;
	private String ganador;
	private String perdedor;

	public Entrenador getEntrenadorUno() {
		return entrenadorUno;
	}

	public void setEntrenadorUno(Entrenador entrenadorUno) {
		this.entrenadorUno = entrenadorUno;
	}

	public Entrenador getEntrenadorDos() {
		return entrenadorDos;
	}

	public void setEntrenadorDos(Entrenador entrenadorDos) {
		this.entrenadorDos = entrenadorDos;
	}

	public String getGanador() {
		return ganador;
	}

	public String getPerdedor() {
		return perdedor;
	}

}
