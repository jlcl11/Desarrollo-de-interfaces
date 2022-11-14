package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioSesionController {

	@FXML
	private TextField txtNombre;

	@FXML
	private PasswordField pswdCont;

	@FXML
	private Button botonEntrar;

	@FXML
	private Label lblARellenar;

	@FXML
	public void mostrarMensaje(ActionEvent event) {

		lblARellenar.setText("Bienvenido " + txtNombre.getText());

	}

}
