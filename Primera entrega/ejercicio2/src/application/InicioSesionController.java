package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InicioSesionController {
	
	
	@FXML
	private TextField user;
	
	@FXML
	private PasswordField pswd;
	
	@FXML
	private Button botonEntrar;
	
	@FXML
	private Label textoGreeting;
	
	@FXML
	public void loginUsuario(ActionEvent event) {
		
		
		
		
		textoGreeting.setText("Bienvenido: "+user.getText());
		user.setText(null);
		pswd.setText(null);
		
		
	}
	
	
}
