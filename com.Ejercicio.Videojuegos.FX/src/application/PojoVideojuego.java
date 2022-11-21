package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PojoVideojuego {

	private SimpleStringProperty nombre;
	private SimpleIntegerProperty precio;
	private SimpleStringProperty consola;
	private SimpleIntegerProperty pegi;

	public PojoVideojuego(String nombre, Integer precio, String consola, Integer pegi) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.precio = new SimpleIntegerProperty(precio);
		this.consola = new SimpleStringProperty(nombre);
		this.pegi = new SimpleIntegerProperty(pegi);
	}

	public String getNombre() {
		return nombre.get();
	}

	public int getPrecio() {
		return precio.get();
	}

	public String getConsola() {
		return consola.get();
	}

	public int getPEGI() {
		return pegi.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public void setPrecio(int precio) {
		this.precio = new SimpleIntegerProperty(precio);
	}

	public void setConsola(String consola) {
		this.consola = new SimpleStringProperty(consola);
	}

	public void setPEGI(int pegi) {
		this.pegi = new SimpleIntegerProperty(pegi);
	}
}
