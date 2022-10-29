package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {		try {
		BorderPane panel = new BorderPane();
		Scene scene = new Scene(panel, 400, 400);

		panel.setCenter(new Rectangle(300, 300, Color.DARKBLUE));
		panel.setTop(new Rectangle(400, 50, Color.DARKGREEN));
		panel.setBottom(new Rectangle(400, 50, Color.DARKGREEN));
		panel.setLeft(new Rectangle(50, 300, Color.LIGHTGREEN));
		panel.setRight(new Rectangle(50, 300, Color.ALICEBLUE));
		panel.getChildren();

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}}
	
	public static void main(String[] args) {
		launch(args);
	}
}
