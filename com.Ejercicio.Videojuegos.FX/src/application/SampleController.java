package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController extends ObjetoDao {
	private static Connection connection;
	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtPrecio;

	@FXML
	private ChoiceBox cbConsola;

	public ObservableList<String> listaConsolas = FXCollections.observableArrayList("Play Station", "Xbox",
			"Nintendo Switch", "PC");

	@FXML
	private ChoiceBox cbPegi;

	@FXML
	private ObservableList<Integer> listaPegis = FXCollections.observableArrayList(3, 7, 12, 16, 18);

	@FXML
	private TableView<PojoVideojuego> tableVideojuegos;

	@FXML
	private TableColumn<PojoVideojuego, String> columTitulo;

	@FXML
	private TableColumn<PojoVideojuego, Integer> columPrecio;

	@FXML
	private TableColumn<PojoVideojuego, String> columConsola;

	@FXML
	private TableColumn<PojoVideojuego, Integer> columPegi;

	@FXML
	private void initialize() {
		cbConsola.setItems(listaConsolas);
		cbPegi.setItems(listaPegis);

		columTitulo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));

		tableVideojuegos.setItems(getJuegosBd());
	}

	private ObservableList<PojoVideojuego> getJuegosBd() {

		ObservableList<PojoVideojuego> listaLibrosBd = FXCollections.observableArrayList();

		DatabaseConnection dbConection = new DatabaseConnection();
		Connection connection = dbConection.getConnection();

		try {
			String query = "select * from juegos";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				PojoVideojuego juego = new PojoVideojuego(rs.getInt("id"), rs.getString("nombre"),
						rs.getFloat("precio"), rs.getString("consola"), rs.getInt("pegi"));

				listaLibrosBd.add(juego);

			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibrosBd;
	}

	@FXML
	private Button btnAnadir;

	@FXML
	private void anadirJuego() {

		connection = openConnection();

		if (txtNombre.getText().isEmpty() || cbConsola.getSelectionModel().isEmpty() || txtPrecio.getText().isEmpty()
				|| cbPegi.getSelectionModel().isEmpty()) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información del juego");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();
		} else if (!esNumero(txtPrecio.getText())) {

			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Campo mal introducido");
			alerta.setHeaderText("Has introducido mal un campo");
			alerta.setContentText("Revisa que has puesto un número en el precio");
			alerta.showAndWait();

		} else {
			try {
				String query = "INSERT INTO juegos(nombre,precio,consola,pegi) VALUES(?,?,?,?);";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, txtNombre.getText());
				ps.setFloat(2, Integer.valueOf(txtPrecio.getText()));
				ps.setString(3, cbConsola.getValue().toString());
				ps.setInt(4, Integer.valueOf(cbPegi.getValue().toString()));
				ps.executeUpdate();
				tableVideojuegos.setItems(getJuegosBd());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean esNumero(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@FXML
	private Button btnBorrar;

	@FXML
	private void borrarJuego() {

		int indiceSeleccionado = tableVideojuegos.getSelectionModel().getSelectedIndex();

		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha seleccionado ningún juego a borrar");
			alerta.setContentText("Por favor, selecciona un juego para borrarlo");
			alerta.showAndWait();
		} else {
			connection = openConnection();

			try {
				String query = "delete from juegos where id=?;";
				PreparedStatement ps = connection.prepareStatement(query);
				PojoVideojuego juega = tableVideojuegos.getSelectionModel().getSelectedItem();
				ps.setInt(1, juega.getId());
				ps.executeUpdate();
				ObservableList juegos = getJuegosBd();
				tableVideojuegos.setItems(juegos);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			closeConnection();
		}

	}

}
