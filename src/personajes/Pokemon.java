package personajes;

import interfaces.Atacable;
import interfaces.Hechizable;
import interfaces.ICarta;

public abstract class Pokemon implements Cloneable, Atacable, Hechizable {
	protected String nombre;
	protected double experiencia = 0;
	protected double escudo;
	protected double vitalidad;
	protected double ataque;
	protected boolean recarga = false;
	protected boolean hechizadoPorNiebla = false;

	public Pokemon(String nombre, double escudo, double vitalidad, double ataque) {
		super();
		this.nombre = nombre;
		this.escudo = escudo;
		this.vitalidad = vitalidad;
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}

	public double getExperiencia() {
		return experiencia;
	}

	public double getEscudo() {
		return escudo;
	}

	public double getVitalidad() {
		return vitalidad;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void atacar(Atacable atacable) {
		if(!this.hechizadoPorNiebla)
			this.golpeInicial(atacable);
		else
			this.fallar();
		this.recarga();
		this.golpeFinal(atacable);
	}

	public void golpeInicial(Atacable atacable) {
		atacable.recibeDano(this.ataque);
		this.ataque = this.ataque / 2;
	}

	public abstract void recarga();

	public abstract void golpeFinal(Atacable atacable);

	@Override
	public String toString() {
		return "Pokemon nombre=" + nombre + ", experiencia=" + experiencia + ", escudo=" + escudo + ", vitalidad="
				+ vitalidad + ", ataque=" + ataque + ", recarga=" + recarga;
	}

	@Override
	public void serHechizado(ICarta carta) {
		carta.hechizar(this);
	}

	public void setExperiencia(double experiencia) {
		this.experiencia = experiencia;
	}
	
	@Override
	public double getAtaque() {
		return this.ataque;
	}
	
	@Override
	public void hechizarTormenta() {
		this.vitalidad = this.vitalidad *0.8;
	}
	
	@Override
	public void hechizarNiebla() {
		this.hechizadoPorNiebla = true;
	}
	
	public void fallar() {
	}
}
