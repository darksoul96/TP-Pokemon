package interfaces;

public interface Atacable {

	void atacar(Atacable atacable);
	void recibeDano(double ataque);
	double getAtaque();
}
