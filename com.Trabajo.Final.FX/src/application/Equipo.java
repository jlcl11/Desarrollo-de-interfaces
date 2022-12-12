package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Equipo {

	private SimpleStringProperty nombre;
	private SimpleStringProperty ciudadLocal;
	private SimpleStringProperty generalManager;
	private SimpleStringProperty propietario;
	private SimpleBooleanProperty conferencia;
	private int id;

	public Equipo(String nombre, String ciudadLocal, String generalManager, String propietario, boolean conferencia) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.ciudadLocal = new SimpleStringProperty(ciudadLocal);
		this.generalManager = new SimpleStringProperty(generalManager);
		this.propietario = new SimpleStringProperty(propietario);
		this.conferencia = new SimpleBooleanProperty(conferencia);
	}

	public Equipo(String nombre, String ciudadLocal, String generalManager, String propietario, boolean conferencia,
			int id) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.ciudadLocal = new SimpleStringProperty(ciudadLocal);
		this.generalManager = new SimpleStringProperty(generalManager);
		this.propietario = new SimpleStringProperty(propietario);
		this.conferencia = new SimpleBooleanProperty(conferencia);
		this.id = id;
	}

	public int getid() {
		return id;
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public String getCiudadLocal() {
		return ciudadLocal.get();
	}

	public void setCiudadLocal(String ciudadLocal) {
		this.ciudadLocal = new SimpleStringProperty(ciudadLocal);
	}

	public String getGeneralManager() {
		return generalManager.get();
	}

	public void setGeneralManager(String generalManager) {
		this.generalManager = new SimpleStringProperty(generalManager);
	}

	public String getPropietario() {
		return propietario.get();
	}

	public void setPropietario(String propietario) {
		this.propietario = new SimpleStringProperty(propietario);
	}

	public boolean getConferencia() {
		return conferencia.get();
	}

	public void setConferencia(boolean conferencia) {
		this.conferencia = new SimpleBooleanProperty(conferencia);
	}

}
