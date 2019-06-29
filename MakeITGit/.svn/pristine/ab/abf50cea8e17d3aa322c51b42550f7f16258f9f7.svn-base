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

public class OptRoomTypeController implements Initializable {
	@FXML
	private JFXButton btnClose;

	@FXML
	private JFXCheckBox cbOneRoom;

	@FXML
	private JFXCheckBox cbOp;

	@FXML
	private JFXCheckBox cbTwoThreeRoom;
	
	public void setOption(boolean oneRoom, boolean twoThreeRoom, boolean officetel) {
		cbOneRoom.setSelected(oneRoom);
		cbTwoThreeRoom.setSelected(twoThreeRoom);
		cbOp.setSelected(officetel);
	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnClose.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				SearchRoomViewController.getInstance().setRoomType(cbOneRoom.isSelected(), cbTwoThreeRoom.isSelected(), cbOp.isSelected());
				((Node)(event.getSource())).getScene().getWindow().hide();
			};
		});
	}
}
