package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController extends ObjetoDao {
	private static Connection connection;

	@FXML
	private TextField txtTitulo;

	@FXML
	private ChoiceBox cbEditorial;

	@FXML
	private TextField txtAutor;

	@FXML
	private TextField txtPaginas;
	@FXML
	private Button btnAñadir;

	@FXML
	private Button btnBorrar;

	@FXML
	private TableView<Libro> tableLibros;

	@FXML
	private TableColumn<Libro, String> columnTitulo;

	@FXML
	private TableColumn<Libro, String> columnEditorial;

	@FXML
	private TableColumn<Libro, String> columnAutor;

	@FXML
	private TableColumn<Libro, Integer> columnPaginas;

	public ObservableList<String> listaEditoriales = FXCollections.observableArrayList("Planeta", "Altaya", "Kadokawa",
			"Penguin Libros");

	@FXML
	private void initialize() {

		cbEditorial.setItems(listaEditoriales);

		columnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		columnEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		columnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		columnPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));
		ObservableList listaLibrosBD = getLibrosBd();
		tableLibros.setItems(listaLibrosBD);

	}

	private ObservableList<Libro> getLibrosBd() {

		ObservableList<Libro> listaLibrosBd = FXCollections.observableArrayList();

		DatabaseConnection dbConection = new DatabaseConnection();
		Connection connection = dbConection.getConnection();

		try {
			String query = "select * from libros";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("editorial"),
						rs.getString("autor"), rs.getInt("paginas")

				);
				listaLibrosBd.add(libro);

			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibrosBd;
	}

	@FXML
	public void aniadirLibro(ActionEvent event) {

		connection = openConnection();

		if (txtPaginas.getText().isEmpty() || cbEditorial.getSelectionModel().isEmpty() || txtAutor.getText().isEmpty()
				|| txtPaginas.getText().isEmpty()) {

			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información del libro");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();

		}
		if (!esNumero(txtPaginas.getText())) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Campo mal introducido");
			alerta.setHeaderText("Has introducido mal un campo");
			alerta.setContentText("Revisa que has puesto un número en el nº de páginas");
			alerta.showAndWait();
		} else {
			try {
				String query = "INSERT INTO libros(titulo,editorial,autor,paginas) VALUES(?,?,?,?);";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, txtTitulo.getText());
				ps.setString(2, cbEditorial.getValue().toString());
				ps.setString(3, txtAutor.getText());
				ps.setInt(4, Integer.valueOf(txtPaginas.getText().toString()));

				ps.executeUpdate();

				ObservableList libros = getLibrosBd();
				tableLibros.setItems(libros);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();

	}

	@FXML
	public void borrarLibro(ActionEvent event) {
		int indiceSeleccionado = tableLibros.getSelectionModel().getSelectedIndex();

		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha seleccionado ningún libro a borrar");
			alerta.setContentText("Por favor, selecciona un libro para borrarlo");
			alerta.showAndWait();
		} else {

			connection = openConnection();

			try {
				String query = "delete from libros where id=?;";
				PreparedStatement ps = connection.prepareStatement(query);
				Libro libro = tableLibros.getSelectionModel().getSelectedItem();
				ps.setInt(1, libro.getId());
				ps.executeUpdate();
				ObservableList libros = getLibrosBd();
				tableLibros.setItems(libros);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			closeConnection();

		}
	}

	public static boolean esNumero(String s) {

		boolean resultado;

		try {
			Integer.parseInt(s);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}
}
