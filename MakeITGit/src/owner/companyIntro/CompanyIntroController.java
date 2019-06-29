package owner.companyIntro;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class CompanyIntroController extends Application implements Initializable {
	
	@FXML JFXButton pdf;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//버튼 클릭시 pdf파일열기
		pdf.setOnAction(e->{
			
			HostServices hs = getHostServices();
			hs.showDocument("D:/A_TeachingMaterial/3.HighJava/workspace/MakeIT/src/pdf/NBNB.pdf");
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	/*	primaryStage.fullScreenProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!observable.getValue()) {
					primaryStage.setFullScreen(true);
				}
			}
		});*/
		
	}


}
