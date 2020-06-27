package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import persistencia.PersistenciaBIN;

import javax.swing.JList;

import modelo.Arena;
import modelo.Torneo;
import interfaces.IPersistencia;
import persistencia.PersistenciaBIN;
import personajes.Entrenador;
import personajes.Pokemon;
import vista.IVista;
import vista.Ventana;

public class Controlador implements ActionListener, Observer, KeyListener, MouseListener {

	private Torneo torneo;
	private IVista vista;
	IPersistencia persistencia = new PersistenciaBIN();
	private int cantidad;

	public Controlador() {
		this.vista = new Ventana();
		this.vista.setActionListener(this);
		this.torneo = torneo.getInstanceSingleton();
		this.torneo.addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		if (comando.contentEquals("CREAR_ENTRENADOR") || comando.contentEquals("PRE_AGREGAR_ENTRENADOR")) {
			if (comando.contentEquals("PRE_AGREGAR_ENTRENADOR"))
				this.vista.habilitarAgregarEntrenador();
			else {
				torneo.agregarEntrenador(new Entrenador(this.vista.getNombreEntrenador()));
				this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());
			}
		} else if (comando.contentEquals("LOG"))
			this.vista.mostrarLogs();
		else if (comando.contentEquals("SIGUIENTE_ETAPA")) {
			switch (this.torneo.getFase()) {
			case 0:
				this.vista.creaArenas(4);
				generaFaseDeGrupos();
				this.torneo.setFase(this.torneo.getFase() + 1);
				break;
			case 1:
				generaFaseEliminatoria(1);
				break;
			case 2:
				generaFaseEliminatoria(2);
				//this.torneo.reiniciaEnfrentamientos();
				//this.vista.faseSiguiente(this.torneo.getClasificados());
				//this.torneo.reiniciarArenas();
				//this.torneo.setFase(this.torneo.getFase() + 1);
				break;
			case 3:
				generaFaseEliminatoria(3);
				//this.torneo.reiniciaEnfrentamientos();
				//this.vista.faseSiguiente(this.torneo.getClasificados());
				//this.torneo.reiniciarArenas();
				//this.torneo.setFase(this.torneo.getFase() + 1);
				break;
			case 4:
				generaFaseEliminatoria(4);
				break;
			case 5:
				generaFaseEliminatoria(5);
				break;
			}

		} else if (comando.contentEquals("INICIAR_COMBATES")) {
			if (this.torneo.getFase() == 1) {
				this.torneo.faseDeGrupos();
				this.torneo.actualizaPosiciones(this.torneo.getGrupos());
				this.vista.repintarGrupos(this.torneo.getGrupos());
				for (int i = 0; i < this.torneo.getGrupos().size(); i++) {
					this.vista.repintarBatalla(this.torneo.getGrupos().get(i).getEnfrentamientos());
				}
			} else if (this.torneo.getFase() >= 2) {

				this.torneo.faseEliminatoriaSiguiente();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < this.torneo.getGrupos().size(); i++) {
					this.vista.repintarBatalla(this.torneo.getEnfrentamientos());
				}
			}

		} else if (comando.contentEquals("PRE_AGREGAR_POKEMON") || comando.contentEquals("CREAR_POKEMON")) {
			if (comando.contentEquals("PRE_AGREGAR_POKEMON"))
				this.vista.habilitarAgregarPokemon();
			else {
				Entrenador e = this.vista.devolverEntrenadorSeleccionado();
				if (e != null) {
					Pokemon p = this.vista.devolverPokemon();
					e.agregarPokemon(p);
					this.vista.actualizarListaPokemon(this.torneo.devuelveIteratorPokemon(e));
				}
			}
		} else if (comando.contentEquals("PRE_MODIFICAR_ENTRENADOR") || comando.contentEquals("MODIFICAR_ENTRENADOR")) {
			if (comando.contentEquals("PRE_MODIFICAR_ENTRENADOR"))
				this.vista.habilitarModificarEntrenador();
			else {
				Entrenador e = this.vista.devolverEntrenadorSeleccionado();
				if (e != null) {
					e.setNombre(this.vista.getNombreEntrenador());
					this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());
				}
			}
		} else if (comando.contentEquals("PRE_MODIFICAR_POKEMON") || comando.contentEquals("MODIFICAR_POKEMON")) {
			if (comando.contentEquals("PRE_MODIFICAR_POKEMON"))
				this.vista.habilitarModificarPokemon();
			else {
				Pokemon p = this.vista.devolverPokemonSeleccionado();
				if (p != null) {
					Entrenador e = this.vista.devolverEntrenadorSeleccionado();
					p.setNombre(this.vista.getNombrePokemon());
					this.vista.actualizarListaPokemon(this.torneo.devuelveIteratorPokemon(e));
				}
			}
		} else if (comando.contentEquals("ELIMINAR_ENTRENADOR")) {
			Entrenador e = this.vista.devolverEntrenadorSeleccionado();

			this.torneo.eliminarEntrenador(e);
			this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());

		} else if (comando.contentEquals("ELIMINAR_POKEMON")) {
			Pokemon p = this.vista.devolverPokemonSeleccionado();
			if (p != null) {
				Entrenador e = this.vista.devolverEntrenadorSeleccionado();
				e.eliminarPokemon(p);
				this.vista.actualizarListaPokemon(this.torneo.devuelveIteratorPokemon(e));
			}
		} else if (comando.contentEquals("EXPORTAR_ENTRENADORES")) {
			try {
				persistencia.abrirOutput("Entrenadores.bin");
				persistencia.escribir(this.torneo.getParticipantes());
				persistencia.cerrarOutput();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		} else if (comando.contentEquals("IMPORTAR_ENTRENADORES")) {
			try {
				persistencia.abrirInput("Entrenadores.bin");
				this.torneo.setParticipantes((ArrayList<Entrenador>) persistencia.leer());
				persistencia.cerrarInput();
				this.vista.actualizarListaEntrenador(this.torneo.devuelveIteratorEntrenador());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} 
		else if (comando.contentEquals("IMPORTAR_FASE")) {
			importarFase();
			this.vista.popupImportar();
		} 
		else if (comando.contentEquals("EXPORTAR_FASE")) {
			exportarFase();
			this.vista.popupExportar();
		}

	}
	
	public void exportarFase() {
		try {
			persistencia.abrirOutput("Torneo.bin");
			persistencia.escribir(this.torneo);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void importarFase() {
		try {
			persistencia.abrirInput("Torneo.bin");
			this.torneo = (Torneo) persistencia.leer();
			persistencia.cerrarInput();
			int aux = this.torneo.getFase()-1;
			System.out.println(aux);
			switch (aux) {
			case 0:				// GRUPOS
				generaFaseDeGrupos();
			case 1:	
				this.vista.redimensionarVentanaOcultarPaneles();
				this.vista.creaArenas(4);
				this.vista.pintarFase1();
				this.vista.setActionListenerBotonesNuevos(this);
				generaFaseEliminatoria(1);
				break;
			case 2:
				this.vista.redimensionarVentanaOcultarPaneles();
				this.vista.creaArenas(4);
				this.vista.pintarFase1();
				this.vista.setActionListenerBotonesNuevos(this);
				generaFaseEliminatoria(2);
				break;
			case 3:
				this.vista.redimensionarVentanaOcultarPaneles();
				this.vista.creaArenas(4);
				this.vista.pintarFase1();
				this.vista.setActionListenerBotonesNuevos(this);
				generaFaseEliminatoria(3);
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		if(arg1.getClass() == Arena.class) {
			Arena arenaDesdeTorneo = (Arena) arg1;
			switch (arenaDesdeTorneo.getNombreArena()) {
			case "Arena 1":
				this.vista.repintarArenas(0, arenaDesdeTorneo.getEstado().getNombre());
				break;
			case "Arena 2":
				this.vista.repintarArenas(1, arenaDesdeTorneo.getEstado().getNombre());
				break;
			case "Arena 3":
				this.vista.repintarArenas(2, arenaDesdeTorneo.getEstado().getNombre());
				break;
			case "Arena 4":
				this.vista.repintarArenas(3, arenaDesdeTorneo.getEstado().getNombre());
				break;
			}
		}
		else {
			if(arg1.getClass()==Entrenador.class) {
				System.out.println("INFORMO GANADOR!!!!!!!!!!!!!!!!!!");
				this.vista.informarganador((Entrenador) arg1);
			}
		}
		

	}
	
	
	public void generaFaseDeGrupos() {
		this.cantidad = this.vista.devuelveCantidadParticipantes();
		this.torneo.setCantidadDeParticipantes(this.vista.devuelveCantidadParticipantes());
		this.vista.pintarFase1();
		this.torneo.faseDeSorteo();
		this.vista.creaGrupos(this.torneo.getGrupos(), this.cantidad);
		this.vista.setActionListenerBotonesNuevos(this);
		this.torneo.reiniciarArenas();
	}

	public void generaFaseEliminatoria(int fase) {
		this.torneo.reiniciaEnfrentamientos();
		this.vista.faseSiguiente(this.torneo.getClasificados());
		this.torneo.reiniciarArenas();
		this.torneo.setFase(this.torneo.getFase() + 1);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getSource().getClass() == JList.class) {
			JList lista = (JList) arg0.getSource();
			Iterator<Pokemon> it;
			int index = lista.locationToIndex(arg0.getPoint());
			if (index >= 0) {
				Object item = lista.getModel().getElementAt(index);
				System.out.println(item.toString());
				it = this.torneo.devuelveIteratorPokemon((Entrenador) lista.getSelectedValue());
				this.vista.actualizarListaPokemon(it);
			}
		}
	}

}
