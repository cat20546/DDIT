package searchRoom.view;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import main.view.MainViewController;
import siteInfo.service.ISiteInfoServiceImpl;
import vo.BoardVO;
import vo.RoomVO;

public class DeclareController implements Initializable {
	RoomVO currentRoom;
	
	
	@FXML
	private Label lbRoomId;

	@FXML
	private JFXCheckBox cbAgree;

	@FXML
	private JFXTextArea taContent;

	/**
	 * 신고 보내기 버튼 클릭시
	 * @param event
	 */
	@FXML
	void onCommitClick(ActionEvent event) {
		if(taContent.getText().trim().isEmpty()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops!");
			alert.setContentText("신고 내용을 적어주세요!");
			alert.showAndWait();
			return;
		}
		if(cbAgree.isSelected() == false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops!");
			alert.setContentText("개인정보 수집 이용에 동의해주세요");
			alert.showAndWait();
			return;
		}
		
		
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(currentRoom.getRoom_id()+"");
		bv.setBoard_category("신고");
		bv.setBoard_date(new Date(Calendar.getInstance().getTime().getTime()));
		bv.setMem_id(MainViewController.getCurrentMember().getMem_id());
		bv.setBoard_content(taContent.getText().trim());
		ISiteInfoServiceImpl.getInstance().upload(bv);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("니방내방");
		alert.setHeaderText("신고해주셔서 감사합니다.");
		alert.setContentText("신고하신 내용은 검토후 조치하겠습니다. 감사합니다.");
		alert.showAndWait();
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	/**
	 * 나가기 클릭시
	 * @param event
	 */
	@FXML
	void onExitClick(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	public void setCurrentRoom(RoomVO rv) {
		this.currentRoom = rv;
		lbRoomId.setText(rv.getRoom_id()+"");
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
