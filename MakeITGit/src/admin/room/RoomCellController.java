package admin.room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.mainview.MainViewController;
import admin.member.MemberController;
import admin.member.MemberUpdateController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import searchRoom.service.ISearchRoomService;
import searchRoom.service.SearchRoomServiceImpl;
import vo.MemberVO;
import vo.RoomVO;

public class RoomCellController implements Initializable{
	
	ISearchRoomService service = SearchRoomServiceImpl.getInstance();
	
	@FXML
	private Label lbName;
	@FXML
	private Label lbId;
	@FXML
	private VBox mainVox;
	@FXML
	private ImageView ivRoom;
	@FXML
	private Label lbTitle;
	@FXML
    private Label lbRoomTransaction;
	
	RoomVO selectedRoom;
	
	MainViewController controller = MainViewController.getInstance();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainVox.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				
				try {
					// 업데이트 창
					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("admin/room/UpdateRoom.fxml"));
					Parent parent = loader.load();
					RoomUpdateController roomUpdateController = loader.getController();
					roomUpdateController.setCurrentRoom(selectedRoom);
					
					controller.getBpMainContainer().setCenter(parent);
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void setRoomVO(RoomVO selectedRoom) {
		this.selectedRoom = selectedRoom;
		// mem_id로 MemberVO 조회
		String mem_id = selectedRoom.getMem_id();
		
		MemberVO mv = service.getMemberInfo(mem_id);
		
		lbId.setText(selectedRoom.getMem_id());
		lbName.setText(mv.getMem_name());
		lbRoomTransaction.setText(selectedRoom.getRoom_type());
		lbTitle.setText(selectedRoom.getRoom_type()+selectedRoom.getRoom_price());
	}
	
	public void setRoomImage(Image image) {
		ivRoom.setImage(image);
	}

	
}
