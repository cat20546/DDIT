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

public class OptRoomPriceController implements Initializable {
	@FXML
	private JFXSlider sdFull;

	@FXML
	private JFXButton btnClose;

	@FXML
	private JFXSlider sdMonth;

	public void setOption(double monthPrice, double fullPrice) {
		sdMonth.setValue(monthPrice);
		sdFull.setValue(fullPrice);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnClose.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				SearchRoomViewController.getInstance().setRoomPrice(sdMonth.getValue(), sdFull.getValue());
				((Node) (event.getSource())).getScene().getWindow().hide();
			};
		});
	}
}
