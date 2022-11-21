package application;

import java.util.Observable;

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
		//columPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));

		tableVideojuegos.setItems(listaJuegos);
	}

}
