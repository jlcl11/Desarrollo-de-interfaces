package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Libro {

	private SimpleStringProperty titulo;
	private SimpleStringProperty editorial;
	private SimpleStringProperty autor;
	private SimpleIntegerProperty paginas;
	private int id;

	public Libro(String titulo, String editorial, String autor, int paginas) {

		this.titulo = new SimpleStringProperty(titulo);
		this.editorial = new SimpleStringProperty(editorial);
		this.autor = new SimpleStringProperty(autor);
		this.paginas = new SimpleIntegerProperty(paginas);
	}

	public Libro(int id, String titulo, String editorial, String autor, int paginas) {
		this.id=id;
		this.titulo = new SimpleStringProperty(titulo);
		this.editorial = new SimpleStringProperty(editorial);
		this.autor = new SimpleStringProperty(autor);
		this.paginas = new SimpleIntegerProperty(paginas);
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo.get();
	}

	public void setTitulo(String titulo) {
		this.titulo = new SimpleStringProperty(titulo);
	}

	public String getEditorial() {
		return editorial.get();
	}

	public void setEditorial(String editorial) {
		this.editorial = new SimpleStringProperty(editorial);
	}

	public String getAutor() {
		return autor.get();
	}

	public void setAutor(String autor) {
		this.autor = new SimpleStringProperty(autor);
	}

	public int getPaginas() {
		return paginas.get();
	}

	public void setPaginas(int paginas) {
		this.paginas = new SimpleIntegerProperty(paginas);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", editorial=" + editorial + ", autor=" + autor + ", paginas=" + paginas
				+ ", id=" + id + "]";
	}

}
