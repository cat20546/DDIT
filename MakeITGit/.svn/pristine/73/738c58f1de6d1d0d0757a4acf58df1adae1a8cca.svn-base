package member.deleteAccount;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import main.view.MainView;
import main.view.MainViewController;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

public class DeleteAccountController implements Initializable {
	
	MemberVO currentMemberVO = MainViewController.getCurrentMember();
	
	@FXML
    private JFXButton btnConfimeDel;

    @FXML
    private JFXComboBox<String> cbDeleteReason;

    @FXML
    private JFXCheckBox checkAgreement;

    @FXML
    private JFXTextArea taInputReason;

	@FXML
	void onConfimeDel(ActionEvent event) {

		if (checkAgreement.isSelected() 
				&& cbDeleteReason.getSelectionModel().getSelectedItem() != null
				|| taInputReason.getText() != null) {

			IMemberService service = MemberServiceImpl.getInstance();
			int cnt = service.deleteAccount(currentMemberVO);
			if (cnt > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("니방내방");
				alert.setHeaderText("회원탈퇴 성공");
				alert.setContentText("회원탈퇴를 하셨습니다.");
				alert.showAndWait();
				((Node) (event.getSource())).getScene().getWindow().hide();
				currentMemberVO = null;
				
				try {
					Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/mainView.fxml"));
					Scene scene = new Scene(parent);
					scene.getStylesheets().add(getClass().getClassLoader().getResource("main/view/mainViewCSS.css").toString());
					MainView.getPrimaryStage().setScene(scene);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> selectHeader = FXCollections.observableArrayList("더 이상 이용하지 않음","탈퇴 후 재가입하려고", "원하는 정보가 없어서", "사용하기 불편해서");
		cbDeleteReason.setItems(selectHeader);
	}

}
