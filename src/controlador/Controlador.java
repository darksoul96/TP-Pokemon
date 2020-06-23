package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import modelo.Torneo;
import personajes.Entrenador;
import vista.IVista;
import vista.Ventana;

public class Controlador implements ActionListener, Observer {

	private Torneo torneo;
	private IVista vista;

	public Controlador() {
		this.vista = new Ventana();
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String comando = arg0.getActionCommand();
		if (comando.contentEquals("AGREGAR_ENTRENADOR") || comando.contentEquals("PRE_AGREGAR_ENTRENADOR")) {
			if(comando.contentEquals("PRE_AGREGAR_ENTRENADOR"))
				this.vista.agregarEntrenador();
			else
				torneo.agregarEntrenador(new Entrenador());
		}
		else if(comando.contentEquals("SORTEAR")){
			
		}
	}

	
	public IVista getVista() {
		return vista;
	}

	public void setVista(IVista vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
