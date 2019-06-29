package main.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView extends Application{
	
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	private static Scene scene;
	
	public static Scene getMainScene() {
		return scene;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.initStyle(StageStyle.UNDECORATED);
		this.primaryStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
		Scene scene = new Scene(root);
		this.scene = scene;
		scene.getStylesheets().add(getClass().getResource("mainViewCSS.css").toString());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
