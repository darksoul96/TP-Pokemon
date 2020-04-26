package personajes;

import java.util.Random;

import interfaces.Atacable;
import interfaces.Clasificable;
import interfaces.Hechizable;
import interfaces.ICarta;

public abstract class Pokemon implements Cloneable, Atacable, Hechizable, Clasificable {
	protected String nombre;
	protected double experiencia = 0;
	protected double escudo;
	protected double vitalidad;
	protected double ataque;
	protected boolean recarga = false;
	protected boolean hechizadoPorNiebla = false;

	public Pokemon(String nombre, double escudo, double vitalidad, double ataque, boolean recarga) {
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
		if (!this.hechizadoPorNiebla)
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
		this.vitalidad = this.vitalidad * 0.8;
		System.out.println("El pokemon " + this.nombre + " ha sido hechizado por la carta Tormenta.");
	}

	@Override
	public void hechizarNiebla() {
		Random r = new Random();
		int chanceDeFallar = r.nextInt(10);
		if (chanceDeFallar < 2) {
			this.hechizadoPorNiebla = true;
			System.out.println("El pokemon " + this.nombre + " ha sido hechizado por la carta Niebla.");
		} else {
			System.out.println("El pokemon " + this.nombre + " ha resistido el hechizo de la carta Niebla.");
		}
	}

	@Override
	public void hechizarViento() {
		Random r = new Random();
		int chanceDeReducirVida = r.nextInt(10);
		if (chanceDeReducirVida < 2) {
			this.vitalidad = this.vitalidad * 85;
			System.out.println("El pokemon " + this.nombre + " ha sido hechizado por la carta Viento.");
		}
		else
			System.out.println("El pokemon " + this.nombre + " ha resisitido el hechizo de la carta Viento.");
	}

	public void fallar() {
		System.out.println("El pokemon " + this.nombre + " ha fallado su ataque inicial!");
	}

	@Override
	public char calculaClasificacion() {
		char rango;
		if (this.experiencia > 19.2)
			rango = 'S';
		else if (this.experiencia > 14.4)
			rango = 'A';
		else if (this.experiencia > 9.6)
			rango = 'B';
		else if (this.experiencia > 4.8)
			rango = 'C';
		else
			rango = 'D';
		return rango;
	}

	public void buffear() {
		// TODO Auto-generated method stub
		this.vitalidad *= 1.1;
		this.ataque *= 1.1;
		this.escudo *= 1.1;
	}
}
