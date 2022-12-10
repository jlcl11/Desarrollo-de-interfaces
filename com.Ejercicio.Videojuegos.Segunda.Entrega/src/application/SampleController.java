package application;

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

public class SampleController {

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtPrecio;
	
	@FXML
	private ChoiceBox cbConsola;

	
	
	@FXML
	private void initialize() {
		txtNombre.setText("Hola");
		txtPrecio.setText("buenas");
	
	}
/*
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

	private ObservableList<PojoVideojuego> listaJuegos = FXCollections.observableArrayList(
			new PojoVideojuego("God of War Ragnarok", 70, "Play Station", 18),
			new PojoVideojuego("Halo Infinite", 25, "Play Station", 16),
			new PojoVideojuego("Pokemon Escarlata", 45, "Nintendo Switch", 7),
			new PojoVideojuego("Sea of thieves", 15, "PC", 16));

	@FXML
	private void initialize() {
		cbConsola.setItems(listaConsolas);
		cbPegi.setItems(listaPegis);

		columTitulo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));

		tableVideojuegos.setItems(listaJuegos);
	}

	@FXML
	private Button btnAnadir;

	@FXML
	private void anadirJuego() {

		if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || cbConsola.getSelectionModel().isEmpty()
				|| cbPegi.getSelectionModel().isEmpty()) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Error al insertar");
			alerta.setHeaderText("No se ha introducido el juego");
			alerta.setContentText("Hay algún campo vacío");
			alerta.showAndWait();
		} else {
			if (esNumero(txtPrecio.getText())) {
				PojoVideojuego j = new PojoVideojuego(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()),
						cbConsola.getValue().toString(), (Integer) cbPegi.getValue());
				listaJuegos.add(j);

				txtNombre.clear();
				txtPrecio.clear();
				cbConsola.getSelectionModel().clearSelection();
				cbPegi.getSelectionModel().clearSelection();

			} else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Error al insertar");
				alerta.setHeaderText("No se ha introducido el precio");
				alerta.setContentText("Por favor introduzca el precio en numero");
				alerta.showAndWait();
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
		System.out.println(indiceSeleccionado);
		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Seleccion errónea");
			alerta.setHeaderText("No has seleccionado un juego");
			alerta.setContentText("Selecciona un juego a borrar");
			alerta.showAndWait();
		} else {
			tableVideojuegos.getItems().remove(indiceSeleccionado);
			tableVideojuegos.getSelectionModel().clearSelection();

		}

	}*/

}
