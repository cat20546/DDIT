package member.Interest.view;

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
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public class RecentCellController implements Initializable{
	
	private RoomVO currentRoomVO;
	private RoomImgVO roomImgVO;
	
	@FXML
    private Label lb_room_type;

    @FXML
    private Label lb_type_price;

    @FXML
    private JFXTextArea taContent;

    @FXML
    private ImageView ivRoom;

    @FXML
    private VBox mainVox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainVox.setOnMouseClicked(new EventHandler<Event>() {
		@Override
		public void handle(Event event) {
			MainViewController mainController = MainViewController.getInstance();
			mainController.onRoomInfoClick(currentRoomVO);
		}
	});
		
	}
	
	public void setItem(RoomVO selectedRoom) {
		this.currentRoomVO = selectedRoom;
		lb_room_type.setText(currentRoomVO.getRoom_type());
		lb_type_price.setText(currentRoomVO.getRoom_type()+currentRoomVO.getRoom_price()+"만원");
		taContent.setText(currentRoomVO.getRoom_comment());
		
	}
	
	public void setRoomImage(Image image) {
		ivRoom.setImage(image);
	}
	
	
	
}
