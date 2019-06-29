package searchRoom.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class OptRoomSizeController implements Initializable {
	@FXML
    private JFXButton btnClose;

    @FXML
    private JFXSlider sdSize;
	
	public void setOption(int roomSize) {
		sdSize.setValue(roomSize);
	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnClose.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				SearchRoomViewController.getInstance().setRoomSize((int)sdSize.getValue());
				((Node)(event.getSource())).getScene().getWindow().hide();
			};
		});
	}
}
