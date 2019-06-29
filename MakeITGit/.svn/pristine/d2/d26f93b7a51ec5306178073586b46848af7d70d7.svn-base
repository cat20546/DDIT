package searchRoom.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class OptRoomTransactionController implements Initializable {
	@FXML
	private JFXButton btnClose;

	@FXML
	private JFXCheckBox cbMonth;

	@FXML
	private JFXCheckBox cbFull;

	@FXML
	private JFXCheckBox cbTrade;
	
	public void setOption(boolean month, boolean full, boolean transaction) {
		cbMonth.setSelected(month);
		cbFull.setSelected(full);
		cbTrade.setSelected(transaction);
	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnClose.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				SearchRoomViewController.getInstance().setRoomTransaction(cbMonth.isSelected(), cbTrade.isSelected(), cbTrade.isSelected());
				((Node)(event.getSource())).getScene().getWindow().hide();
			};
		});
	}
}
