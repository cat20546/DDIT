package siteInfo.chat;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import vo.ChatVO;
import vo.MemberVO;

public class ChatBoxController implements Initializable{
	
	MemberVO currentMemberVO;
	ChatVO currentChatVO;
	private static ChatBoxController chatBoxController;
	
	public ChatBoxController() {
		chatBoxController=this;
	}
	
	public static ChatBoxController getInstance() {
		return chatBoxController;
	}
	
    @FXML
    private VBox vbChatBox;
    
    public VBox getVbChatBox() {
		return vbChatBox;
	}

	public void setVbChatBox(VBox vbChatBox) {
		this.vbChatBox = vbChatBox;
	}

	@FXML
    private TextArea taChatContent;
    
    @FXML
    private Label lbUserId;
	
//    public void setChatContent(String content){
//    	if(!currentMemberVO.getMem_id().equals("admin")) {
//    		vbChatBox.setAlignment(Pos.TOP_RIGHT);
//    	}
//    	lbUserId.setText(name);
//    	taChatContent.setText(content);
//    }
    public void setChatContent(ChatVO cv){
//    	currentMemberVO = MainViewController.getCurrentMember();
//    	if(!cv.getMem_id().equals(currentMemberVO.getMem_id())) {
//    		vbChatBox.setAlignment(Pos.TOP_RIGHT);
//    	}else {
//    		vbChatBox.setAlignment(Pos.TOP_LEFT);
//    	}
    	lbUserId.setText(cv.getMem_id());
    	taChatContent.setText(cv.getChat_message());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
