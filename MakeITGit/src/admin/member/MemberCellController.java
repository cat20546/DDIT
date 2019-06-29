package admin.member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.mainview.MainViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import vo.MemberVO;

public class MemberCellController implements Initializable {
	MemberVO currentMember = null;
	
	{
		currentMember = MainViewController.getCurrentMember();
	}
	
	public MemberVO getCurrentMember() {
		return currentMember;
	}

	public void setCurrentMember(MemberVO currentMember) {
		this.currentMember = currentMember;
	}
	
	
	@FXML 
	private BorderPane memberContainer;
	
	public BorderPane getMainContainer() {
		return memberContainer;
	}
	
	public MemberController getMemberController() {
		return memberController;
	}

	public void setMemberController(MemberController memberController) {
		this.memberController = memberController;
	}

	private MemberController memberController;
	
	@FXML
	private HBox memberCell;
	
	@FXML
	private Label mem_no;
	
	@FXML
	private Label mem_id;
	
	@FXML
	private Label mem_name;
	
	private MemberVO mv;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mem_name.setOnMouseClicked(e-> {
				MemberController controller = MemberController.getInstance();
				
				try {
					// 업데이트 창
					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("admin/member/MemberUpdate.fxml"));
					Parent parent = loader.load();
					MemberUpdateController updateController = loader.getController();
					updateController.setCurrentMember(currentMember);
					
					controller.getMainContainer().setCenter(parent);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
		});
	}
	
	public void setItem(MemberVO mv, int no) { 
		mem_id.setText(mv.getMem_id());
		mem_name.setText(mv.getMem_name());
		this.mv = mv;
	}
}
