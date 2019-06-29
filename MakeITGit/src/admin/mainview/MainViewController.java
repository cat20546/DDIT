package admin.mainview;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.MemberVO;

public class MainViewController implements Initializable{
	private static MemberVO currentMember = null;
	
	private static MainViewController mainViewController;
	
	public MainViewController() {
		mainViewController = this;
	}
	public static MainViewController getInstance() {
		return mainViewController;
	}
	
	public static void setCurrentMember(MemberVO _currentMember) {
		currentMember = _currentMember;
	}
	public static MemberVO getCurrentMember() {
		return currentMember;
	}

	@FXML private Label btn_member;
	
	@FXML private BorderPane bpMainContainer;
	
	@FXML private VBox vbox;
	
	//borderpane get, set
	public BorderPane getBpMainContainer() {
		return bpMainContainer;
	}
	public void setBpMainContainer(BorderPane bpMainContainer) {
		this.bpMainContainer = bpMainContainer;
	}

	@FXML private Label btn_room;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 회원관리 이동
		
		btn_member.setOnMouseClicked(e->{
			Parent root;
			try {
				root = FXMLLoader
						.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
				Scene scene = new Scene(root);
				Stage window =(Stage)btn_member.getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		// 방 관리 이동
		btn_room.setOnMouseClicked(e->{
			Parent parent;
			try {
				parent = FXMLLoader
						.load(getClass().getClassLoader().getResource("admin/room/RoomList.fxml"));
				bpMainContainer.setCenter(parent);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		
	}
}