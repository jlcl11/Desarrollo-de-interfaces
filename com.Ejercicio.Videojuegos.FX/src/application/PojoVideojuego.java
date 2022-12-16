package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PojoVideojuego {

	private SimpleStringProperty nombre;
	private SimpleFloatProperty precio;
	private SimpleStringProperty consola;
	private SimpleIntegerProperty pegi;
	private int id;

	public PojoVideojuego(String nombre, float precio, String consola, Integer pegi) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.precio = new SimpleFloatProperty(precio);
		this.consola = new SimpleStringProperty(consola);
		this.pegi = new SimpleIntegerProperty(pegi);
	}

	public PojoVideojuego(int id, String nombre, float precio, String consola, Integer pegi) {
		super();
		this.id = id;
		this.nombre = new SimpleStringProperty(nombre);
		this.precio = new SimpleFloatProperty(precio);
		this.consola = new SimpleStringProperty(consola);
		this.pegi = new SimpleIntegerProperty(pegi);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre.get();
	}

	public float getPrecio() {
		return precio.get();
	}

	public String getConsola() {
		return consola.get();
	}

	public int getPegi() {
		return pegi.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public void setPrecio(float precio) {
		this.precio = new SimpleFloatProperty(precio);
	}

	public void setConsola(String consola) {
		this.consola = new SimpleStringProperty(consola);
	}

	public void setPEGI(int pegi) {
		this.pegi = new SimpleIntegerProperty(pegi);
	}
}
