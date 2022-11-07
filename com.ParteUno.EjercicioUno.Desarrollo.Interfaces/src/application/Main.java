package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {try {
		StackPane panel = new StackPane();
		
		Rectangle r1 = new Rectangle(400,400,Color.DARKGREEN);
		Rectangle r2 = new Rectangle(300,300,Color.GREEN);
		Rectangle r3 = new Rectangle(200,200,Color.LIGHTGREEN);
		
		panel.getChildren().addAll(r1, r2, r3);
		
		Scene scene = new Scene(panel,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}}
	
	public static void main(String[] args) {
		launch(args);
	}
}
