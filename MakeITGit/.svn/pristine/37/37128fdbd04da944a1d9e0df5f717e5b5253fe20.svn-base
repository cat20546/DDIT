package member.Interest.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.view.MainViewController;
import roomInfo.view.RoomInfoController;
import searchRoom.dao.SearchRoomDaoImpl;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public class FavoriteCellController implements Initializable{
	
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
    
    private RoomVO currentRoomVO;
    private static MainViewController mainViewController;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roomDetail();
	}
	
	public void roomDetail() {
		mainVox.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				MainViewController mainController = MainViewController.getInstance();
				mainController.onRoomInfoClick(currentRoomVO);
			}
		});
	}
	
	
	public void setItemFavorite(RoomVO selectedRoom) {
		this.currentRoomVO = selectedRoom;
		lb_room_type.setText(currentRoomVO.getRoom_type());
		lb_type_price.setText(currentRoomVO.getRoom_type()+currentRoomVO.getRoom_price()+"만원");
		taContent.setText(currentRoomVO.getRoom_comment());
		
	}
	
	public void setRoomImage(Image image) {
		ivRoom.setImage(image);
	}
}
