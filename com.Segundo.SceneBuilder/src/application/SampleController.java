package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	@FXML
	private TextField txtTitulo;

	@FXML
	private ChoiceBox cbEditorial;

	@FXML
	private TextField txtAutor;

	@FXML
	private TextField txtNPaginas;

	public ObservableList<String> listaEditoriales = FXCollections.observableArrayList("Planeta", "Altaya", "Kadokawa",
			"Penguin libros");

	@FXML
	private TableView<Libro> tableLibros;

	@FXML
	private TableColumn<Libro, String> columTitulo;

	@FXML
	private TableColumn<Libro, String> columEditorial;
	@FXML
	private TableColumn<Libro, String> columAutor;
	@FXML
	private TableColumn<Libro, String> columnPaginas;

	private ObservableList<Libro> listaLibros = FXCollections
			.observableArrayList(new Libro("La Biblia", "Planeta", "Hesús Cristo", 500));

	@FXML
	private void initialize() {
		cbEditorial.setItems(listaEditoriales);
		
		
		columTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		columEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		columAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		columnPaginas.setCellValueFactory(new PropertyValueFactory<>("nPaginas"));
		tableLibros.setItems(listaLibros);
	}
}
