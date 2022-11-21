package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Libro {
	private SimpleStringProperty titulo;
	private SimpleStringProperty editorial;
	private SimpleStringProperty autor;
	private SimpleIntegerProperty nPaginas;

	public Libro(String titulo, String editorial, String autor, Integer nPaginas) {
		super();
		this.titulo = new SimpleStringProperty(titulo);
		this.editorial = new SimpleStringProperty(editorial);
		this.autor = new SimpleStringProperty(autor);
		this.nPaginas = new SimpleIntegerProperty(nPaginas);

	}

	public String getTitulo() {
		return titulo.get();
	}

	public String getAutor() {
		return autor.get();
	}

	public String getEditorial() {
		return editorial.get();
	}

	public int getPaginas() {
		return nPaginas.get();
	}

	public void setTitulo(String titulo) {
		this.titulo = new SimpleStringProperty(titulo);
	}

	public void setAutor(String autor) {
		this.autor = new SimpleStringProperty(autor);
	}

	public void setEditorial(String editorial) {
		this.editorial = new SimpleStringProperty(editorial);
	}

	public void setPaginas(int paginas) {
		this.nPaginas = new SimpleIntegerProperty(paginas);
	}

}
