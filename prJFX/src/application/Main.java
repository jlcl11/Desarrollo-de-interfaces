package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		/*Button btn = new Button("Click aquí");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("hola mundo");

			}

		});
		
		StackPane panel=new StackPane();
		//panel.getChildren().add(btn);
		Label lbl=new Label("Holiwis mundo"); 
		panel.setAlignment(lbl, Pos.TOP_CENTER);
		panel.setAlignment(btn,Pos.CENTER);
		panel.getChildren().addAll(lbl,btn);*/
		
		Button benjaminButton1= new Button("Boton 1");
		Button benjaminButton2= new Button("Boton 2");
		Button benjaminButton3= new Button("Boton 3");
		Button benjaminButton4= new Button("Boton 4");
		
		/*VBox panelVertical=new VBox(15);
		panelVertical.setPadding(new Insets(9));
		
		panelVertical.getChildren().addAll(benjaminButton1,benjaminButton2,benjaminButton3);
		
		
		BorderPane panel=new BorderPane();
		
		panel.setRight(panelVertical);*/
		
		GridPane panel=new GridPane();
		
		panel.setVgap(15);
		panel.setHgap(15);
		panel.setPadding(new Insets(15));
		
		panel.add(benjaminButton1, 0, 0);
		panel.add(benjaminButton2, 1, 0);
		panel.add(benjaminButton3, 0, 1);
		panel.add(benjaminButton4, 1, 1);
		
		
		Scene scene = new Scene(panel,300,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Introducción a Java FX");
		primaryStage.getIcons().add(new Image("/application/icon.gif"));
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
