package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private TextField txtNombre;

	@FXML
	private ChoiceBox cbCiudad;

	@FXML
	private ObservableList<String> listaCiudades = FXCollections.observableArrayList("Atlanta", "Boston", "Brooklyn",
			"Charlotte", "Chicago", "Cleveland", "Dallas", "Denver", "Detroit", "Houston", "Indiana", "Los Ángeles",
			"Memphis", "Milwaukee", "Minnesota", "New Orleans", "New York", "Oklahoma City", "Orlando", "Philadelphia",
			"Phoenix", "Portland", "Sacramento", "San Antonio", "San Francisco", "Toronto", "Utah", "Washington");

	@FXML
	private TextField txtGM;

	@FXML
	private TextField txtPropietario;

	@FXML
	private ChoiceBox cbConf;

	@FXML
	private ObservableList<String> listaConferencia = FXCollections.observableArrayList("Este", "Oeste");

	@FXML
	private TableView tablaOeste;

	@FXML
	private TableColumn<Equipo, String> columNombreOeste;
	@FXML
	private TableColumn<Equipo, String> columCiudadOeste;
	@FXML
	private TableColumn<Equipo, String> columGMOeste;
	@FXML
	private TableColumn<Equipo, String> columPropietarioOeste;

	@FXML
	private TableView tablaEste;

	@FXML
	private TableColumn<Equipo, String> columNombreEste;
	@FXML
	private TableColumn<Equipo, String> columCiudadEste;
	@FXML
	private TableColumn<Equipo, String> columGMEste;
	@FXML
	private TableColumn<Equipo, String> columPropietarioEste;

	@FXML
	private Button btnAnadir;

	@FXML
	private void anadirEquipo() {

		if (txtNombre.getText().isEmpty() || cbCiudad.getSelectionModel().isEmpty() || txtGM.getText().isEmpty()
				|| txtPropietario.getText().isEmpty() || cbConf.getSelectionModel().isEmpty()) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Error al insertar");
			alerta.setHeaderText("No se ha introducido el equipo");
			alerta.setContentText("Hay algún campo vacío");
			alerta.showAndWait();
		} else {

			connection = openConnection();
			String query = "INSERT INTO equipos(nombre,ciudadlocal,generalManager,propietario,conferencia) values(?,?,?,?,?)";

			Boolean conf = true;

			if (cbConf.getValue().toString() == "Oeste") {
				System.out.println("Entra en oeste");
				conf = true;
			} else {
				conf = false;
				System.out.println("Entra en este");
			}
			System.out.println(conf);

			try {
				PreparedStatement ps = connection.prepareStatement(query);

				ps.setString(1, txtNombre.getText());
				ps.setString(2, cbCiudad.getValue().toString());
				ps.setString(3, txtGM.getText());
				ps.setString(4, txtPropietario.getText());
				ps.setBoolean(5, conf);

				ps.executeUpdate();
				if (conf == false) {
					ObservableList equiposEste = listarEquiposEste();
					tablaEste.setItems(equiposEste);

				} else {

					ObservableList equiposOeste = listarEquiposOeste();
					tablaOeste.setItems(equiposOeste);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// closeConnection();
		}

	}

	@FXML
	private Button btnBorrar;

	@FXML
	private void borrarEquipo() {

		int indiceSeleccionadoOeste = tablaOeste.getSelectionModel().getSelectedIndex();
		// System.out.println("Índice a borrar oeste: " + indiceSeleccionadoOeste);

		int indiceSeleccionadoEste = tablaEste.getSelectionModel().getSelectedIndex();
		// System.out.println("Indice a borrar este: " + indiceSeleccionadoEste);

		if (indiceSeleccionadoOeste > -1 && indiceSeleccionadoEste < 0) {
			connection = openConnection();

			try {
				String query = "delete from equipos where eq_id=?;";
				PreparedStatement ps = connection.prepareStatement(query);
				Equipo equipo = (Equipo) tablaOeste.getSelectionModel().getSelectedItem();
				ps.setInt(1, equipo.getid());
				System.out.println(equipo);
				ps.executeUpdate();
				ObservableList equiposOeste = listarEquiposOeste();
				tablaOeste.setItems(equiposOeste);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (indiceSeleccionadoOeste > -1 && indiceSeleccionadoEste > 0) {

			connection = openConnection();

			try {
				String query = "delete from equipos where eq_id=?;";
				PreparedStatement ps = connection.prepareStatement(query);
				Equipo equipo = (Equipo) tablaOeste.getSelectionModel().getSelectedItem();
				ps.setInt(1, equipo.getid());
				System.out.println(equipo);
				ps.executeUpdate();
				ObservableList equiposOeste = listarEquiposOeste();
				tablaOeste.setItems(equiposOeste);

				connection = openConnection();
				PreparedStatement ps2 = connection.prepareStatement(query);
				Equipo equipo2 = (Equipo) tablaEste.getSelectionModel().getSelectedItem();
				ps2.setInt(1, equipo2.getid());
				System.out.println(equipo2);
				ps2.executeUpdate();
				ObservableList equiposEste = listarEquiposEste();
				tablaEste.setItems(equiposEste);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (indiceSeleccionadoEste > -1 && indiceSeleccionadoOeste < 0) {
			connection = openConnection();
			try {
				String query = "delete from equipos where eq_id=?;";
				PreparedStatement ps2 = connection.prepareStatement(query);
				Equipo equipo2 = (Equipo) tablaEste.getSelectionModel().getSelectedItem();
				ps2.setInt(1, equipo2.getid());
				System.out.println(equipo2);
				ps2.executeUpdate();
				ObservableList equiposEste = listarEquiposEste();
				tablaEste.setItems(equiposEste);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (indiceSeleccionadoEste < 0 && indiceSeleccionadoOeste < 0) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("No se ha seleccionado ningún equipo a borrar");
			alerta.setContentText("Por favor, selecciona un equipo para borrarlo");
			alerta.showAndWait();
		}
		System.out.println("Índice a borrar oeste: " + indiceSeleccionadoOeste);

		System.out.println("Indice a borrar este: " + indiceSeleccionadoEste);

	}

	@FXML
	private ObservableList<Equipo> listarEquiposOeste() {

		ObservableList<Equipo> confO = FXCollections.observableArrayList();

		ArrayList<Equipo> todos = new ArrayList<>();
		connection = openConnection();

		String query = "SELECT * FROM equipos where conferencia=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Equipo actual = new Equipo(rs.getString("nombre"), rs.getString("ciudadLocal"),
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"),
						rs.getInt("eq_id"));
				todos.add(actual);

				confO.add(actual);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return confO;

	}

	@FXML
	private ObservableList<Equipo> listarEquiposEste() {
		ObservableList<Equipo> confE = FXCollections.observableArrayList();

		ArrayList<Equipo> todos = new ArrayList<>();
		connection = openConnection();

		String query = "SELECT * FROM equipos where conferencia=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setBoolean(1, false);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Equipo actual = new Equipo(rs.getString("nombre"), rs.getString("ciudadLocal"),
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"),
						rs.getInt("eq_id"));
				todos.add(actual);

				confE.add(actual);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
		return confE;

	}

	@FXML
	private void initialize() {
		cbCiudad.setItems(listaCiudades);
		cbConf.setItems(listaConferencia);

		columNombreOeste.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columCiudadOeste.setCellValueFactory(new PropertyValueFactory<>("ciudadLocal"));
		columGMOeste.setCellValueFactory(new PropertyValueFactory<>("generalManager"));
		columPropietarioOeste.setCellValueFactory(new PropertyValueFactory<>("propietario"));

		ObservableList equiposOeste = listarEquiposOeste();
		tablaOeste.setItems(equiposOeste);

		columNombreEste.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columCiudadEste.setCellValueFactory(new PropertyValueFactory<>("ciudadLocal"));
		columGMEste.setCellValueFactory(new PropertyValueFactory<>("generalManager"));
		columPropietarioEste.setCellValueFactory(new PropertyValueFactory<>("propietario"));

		ObservableList equiposEste = listarEquiposEste();
		tablaEste.setItems(equiposEste);

	}

}
