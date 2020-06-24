package personajes;

import interfaces.Atacable;

/**
 * La clase Pokemon Hielo tiene un atributo extra que es granRecarga. Se define al momento de fabricar el pokemon.
 *
 */
public class Hielo extends Pokemon {

	boolean granRecarga = false;
	
	public Hielo(String nombre,boolean recarga,boolean granRecarga) {
		super(nombre,120,500,100,recarga);
		this.granRecarga = granRecarga;
	}

	@Override
	public void recibeDano(double ataque) {
		if (this.escudo > ataque * 0.75) {
			this.escudo -= ataque * 0.75;
			this.vitalidad -= ataque *0.25;
		} else {
			this.vitalidad -= (this.escudo - ataque);
			this.escudo = 0;
		}

	}
	
	@Override
	public void recarga() {
		if (this.recarga == true) {
			this.vitalidad = this.vitalidad * 1.1;
			this.ataque = this.ataque * 1.1;
		}
	}
	
	public void granRecarga() {
		if(this.granRecarga==true)
			this.ataque = 400;
	}

	@Override
	public void golpeFinal(Atacable atacable) {
		atacable.recibeDano(this.ataque*0.9);
		
	}
}
