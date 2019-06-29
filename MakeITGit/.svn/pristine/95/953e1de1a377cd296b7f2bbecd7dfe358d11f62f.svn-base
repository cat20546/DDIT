package searchRoom.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import vo.RoomVO;

public class CellController implements Initializable{
	@FXML
	VBox mainVox;
	@FXML
	ImageView ivRoom;
	@FXML
	Label lbTitle;
	@FXML
	Label lbContent1;
	@FXML
	JFXTextArea taContent;
	@FXML
    private Label lbRoomTransaction;
	
	RoomVO selectedRoom;
	@FXML Label lbId;
	@FXML Label lbName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainVox.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				MainViewController mainController = MainViewController.getInstance();
				mainController.onRoomInfoClick(selectedRoom);
			}
		});
	}
	
	public void setRoomVO(RoomVO selectedRoom) {
		this.selectedRoom = selectedRoom;
		String title = selectedRoom.getRoom_transaction() + " " + selectedRoom.getRoom_price() + "만원";
		lbTitle.setText(title);
		taContent.setText(selectedRoom.getRoom_comment());
		lbRoomTransaction.setText(selectedRoom.getRoom_type());
	}
	
	public void setRoomImage(Image image) {
		ivRoom.setImage(image);
	}
	
	
	

	
	
}
