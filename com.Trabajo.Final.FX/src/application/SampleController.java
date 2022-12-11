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

			Boolean conf = false;

			if (cbConf.getSelectionModel().toString().equals("Este")) {
				conf = false;
			} else {
				conf = true;
			}

			try {
				PreparedStatement ps = connection.prepareStatement(query);

				ps.setString(1, txtNombre.getText());
				ps.setString(2, cbCiudad.getSelectionModel().toString());
				ps.setString(3, txtGM.getText());
				ps.setString(4, txtPropietario.getText());
				ps.setBoolean(5, conf);

				ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			closeConnection();
		}

	}

	@FXML
	private Button btnBorrar;

	@FXML
	private void borrarEquipo() {
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
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"));
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
						rs.getString("generalManager"), rs.getString("propietario"), rs.getBoolean("conferencia"));
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

	//	tablaOeste.setItems(listarEquiposOeste());

		columNombreEste.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columCiudadEste.setCellValueFactory(new PropertyValueFactory<>("ciudadLocal"));
		columGMEste.setCellValueFactory(new PropertyValueFactory<>("generalManager"));
		columPropietarioEste.setCellValueFactory(new PropertyValueFactory<>("propietario"));

		//tablaOeste.setItems(listarEquiposEste());

	}

}
