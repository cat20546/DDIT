package admin.room;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import member.Interest.view.RecentCellController;
import searchRoom.service.ISearchRoomService;
import searchRoom.service.SearchRoomServiceImpl;
import searchRoom.view.CellController;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import javafx.scene.layout.FlowPane;

public class RoomController implements Initializable{

	@FXML 
	private Label btn_room;
	@FXML 
	private Label btn_member;
	@FXML
	private FlowPane fp_flowpane;
	
	private ObservableList<RoomVO> roomList;
	
	ISearchRoomService service = SearchRoomServiceImpl.getInstance();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
				// 호출
				try {
					roomList = service.getRoomList();
					setMainRoomView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
	
	// 리스트에 셀을 셋팅
	private void setMainRoomView() throws SQLException {
		Parent subParent;
		try {
			FXMLLoader loader;
			RoomCellController controller;
			for(int i=0; i<roomList.size(); i++) {
				RoomVO room = roomList.get(i);
				RoomImgVO roomImg = service.getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getClassLoader().getResource("admin/room/RoomCell.fxml"));
				subParent = loader.load();
				fp_flowpane.getChildren().add(subParent);
				controller = loader.getController();
				controller.setRoomImage(new Image(roomImg.getImg_uri()));
				controller.setRoomVO(room);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
