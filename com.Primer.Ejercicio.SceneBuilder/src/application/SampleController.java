package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	private TextField txtMensaje;
	
	@FXML
	private PasswordField contrasenha;
	
	private Label labelMensaje;
	
	@FXML
	public void mostrarMensaje(ActionEvent event) {
		labelMensaje.setText("Bienvenido "+txtMensaje.getText()); 
	}
}
