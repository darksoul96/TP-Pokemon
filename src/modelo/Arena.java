package modelo;

import java.io.Serializable;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import interfaces.IStateArena;

public class Arena extends Observable implements Serializable {
	
	private String nombreArena;
	private IStateArena estado;
	
	
	public Arena(String nombre) {
		this.nombreArena=nombre;
		this.estado=new PreliminarState(this);
	}
	
	public Arena() {}
	
	public synchronized void comenzar(Enfrentamiento enfrentamiento) {
		this.estado.comenzar(enfrentamiento);
	}

	
	public IStateArena getEstado() {
		return estado;
	}

	public synchronized void setEstado(IStateArena estado) {
		this.estado = estado;
		Random r = new Random();
		try {
			TimeUnit.SECONDS.sleep(r.nextInt(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setChanged();
		this.notifyObservers(this);
	}

	public String getNombreArena() {
		return nombreArena;
	}

	public void setNombreArena(String nombreArena) {
		this.nombreArena = nombreArena;
	}

	public void reiniciarEstado() {
		// TODO Auto-generated method stub
		this.setEstado(new PreliminarState(this));
	}
	
	
}
