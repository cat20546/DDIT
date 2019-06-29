package owner.myRoom;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import main.view.MainViewController;
import owner.service.IRegistRoomService;
import owner.service.RegistRoomServiceImpl;
import vo.RoomVO;

public class MyRoomController implements Initializable {

	IRegistRoomService service = RegistRoomServiceImpl.getInstance();
	List<OwnerRoomCellController> controlls;

	@FXML
	private Label lbRoomCount;

	@FXML
	private FlowPane fpRoomContainer;

	/**
	 * 삭제버튼 클릭시
	 * 
	 * @param event
	 */
	@FXML
	void onDeleteClick(ActionEvent event) {
		StringBuffer sb = new StringBuffer("");
		for (int i = controlls.size() - 1; i >= 0; i--) {
			OwnerRoomCellController controller = controlls.get(i);
			if (controller.isChecked()) {
				// 체크박스를 클릭하였으면...
				service.deleteRoom(controller.getCurrentRoom().getRoom_id());
				sb.append("공실 번호 : " + controller.getCurrentRoom().getRoom_id()
				+ "\n공실 이름 : " + controller.getCurrentRoom().getRoom_name()+ " 이 삭제되었습니다");
				
			} else {
				continue;
			}
		}
		if (sb.toString().isEmpty()) {
			return;
		} else {
			sb.append("공실 등록이 취소되었습니다.\n");
			sb.append("니방내방을 이용해주셔서 감사합니다");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("계약 결과");
			alert.setContentText(sb.toString());
			alert.showAndWait();
		}
		update();
	}

	public void update() {
		fpRoomContainer.getChildren().clear();
		controlls = new ArrayList<>();
		List<RoomVO> roomList = service.getAllMyRoom(MainViewController.getCurrentMember().getMem_id());
		for (RoomVO rv : roomList) {
			try {
				FXMLLoader loader = new FXMLLoader(
						getClass().getClassLoader().getResource("owner/myRoom/ownerRoomCell.fxml"));
				Parent parent = loader.load();
				OwnerRoomCellController controller = loader.getController();
				controlls.add(controller);
				controller.setRoomVO(rv);
				fpRoomContainer.getChildren().add(parent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		lbRoomCount.setText(roomList.size() + "");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		update();
	}
}
