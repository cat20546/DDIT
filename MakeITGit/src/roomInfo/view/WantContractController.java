package roomInfo.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import main.view.MainViewController;
import roomInfo.service.IRoomInfoService;
import roomInfo.service.RoomInfoServiceImpl;
import vo.ContractVO;
import vo.MemberVO;
import vo.RoomVO;

public class WantContractController implements Initializable{
	RoomVO currentRoom;
	
	MemberVO currentMember;
	IRoomInfoService service = RoomInfoServiceImpl.getInstance();
	
	
	
	
	/**
	 * 계약 요청 클릭시
	 * @param event
	 */
	@FXML
    void onContractClick(ActionEvent event) {
		ContractVO cv = new ContractVO();
		cv.setMem_id(currentMember.getMem_id());
		cv.setRoom_id(currentRoom.getRoom_id());
		service.sendContract(cv);
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("니방내방");
		alert.setHeaderText("전송 완료");
		alert.setContentText("중개사에게 계약요청을 진행하였습니다.\n 마이페이지에서 최종 승인을 하시면 계약이 진행됩니다");
		alert.showAndWait();
		((Node)(event.getSource())).getScene().getWindow().hide();
		
    }

	/**
	 * 닫기버튼 클릭시
	 * @param event
	 */
	@FXML
	void onCloseClick(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		currentRoom = RoomInfoController.getInstance().getCurrentRoom();
		currentMember = MainViewController.getInstance().getCurrentMember();
	}
}
