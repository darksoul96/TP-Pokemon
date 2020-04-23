
public abstract class Pokemon {
	protected String nombre;
	protected double experiencia = 0;
	protected double escudo;
	protected double vitalidad;
	protected double ataque;

	public Pokemon(String nombre, double escudo, double vitalidad, double ataque) {
		super();
		this.nombre = nombre;
		this.escudo = escudo;
		this.vitalidad = vitalidad;
		this.ataque = ataque;
	}

}
