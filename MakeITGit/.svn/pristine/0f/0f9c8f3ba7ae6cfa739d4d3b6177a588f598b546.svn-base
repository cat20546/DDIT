package admin.mainview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/mainview/Administer.fxml"));
		Scene scene = new Scene(root);
		
		scene.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
//		scene.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/table.css").toString());
//		scene.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/cell.css").toString());
		
		Font.loadFont(getClass().getResourceAsStream("윤고딕330.ttf"), 200);
		primaryStage.setTitle("방 등록");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
