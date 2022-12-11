package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Equipo {
	
	private SimpleStringProperty nombre;
	private SimpleStringProperty ciudadLocal;
	private SimpleStringProperty generalManager;
	private SimpleStringProperty propietario;
	private SimpleBooleanProperty  conferencia;



	public Equipo(String nombre, String ciudadLocal, String generalManager,
			String propietario, boolean conferencia) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.ciudadLocal = new SimpleStringProperty(ciudadLocal);
		this.generalManager = new SimpleStringProperty(generalManager);
		this.propietario = new SimpleStringProperty(propietario);
		this.conferencia = new SimpleBooleanProperty(conferencia);
	}



	public SimpleStringProperty getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre =new SimpleStringProperty(nombre);
	}



	public SimpleStringProperty getCiudadLocal() {
		return ciudadLocal;
	}



	public void setCiudadLocal(String ciudadLocal) {
		this.ciudadLocal = new SimpleStringProperty(ciudadLocal);
	}



	public SimpleStringProperty getGeneralManager() {
		return generalManager;
	}



	public void setGeneralManager(String generalManager) {
		this.generalManager =  new SimpleStringProperty(generalManager);
	}



	public SimpleStringProperty getPropietario() {
		return propietario;
	}



	public void setPropietario(String propietario) {
		this.propietario =  new SimpleStringProperty(propietario);
	}



	public SimpleBooleanProperty getConferencia() {
		return conferencia;
	}



	public void setConferencia(boolean conferencia) {
		this.conferencia = new SimpleBooleanProperty(conferencia);
	}





}
