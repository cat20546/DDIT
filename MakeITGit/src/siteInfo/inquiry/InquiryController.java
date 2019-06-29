package siteInfo.inquiry;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import main.view.MainViewController;
import member.mailingSystem.Mail;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import siteInfo.chat.MultiChatClientMain;
import vo.MemberVO;

public class InquiryController implements Initializable {
	
	IMemberService service = MemberServiceImpl.getInstance();
	
	MemberVO currentMember = MainViewController.getCurrentMember();
	@FXML
    private JFXButton btnSendInquiry;

    @FXML
    private JFXButton btnRequestChat;

    @FXML
    private JFXTextArea tfIquiryContent;

    @FXML
    private JFXTextField tfIquiryTitle;
    
    int emailChk=0;
    int addrChk=0;
    int emailIdNum;
    
    @FXML
    void onSendInquiry(ActionEvent event) {
    	String title = tfIquiryTitle.getText().trim();
    	String content = (String) ("문의하신 고객님 ID : "+currentMember.getMem_id().trim()+"\n"+
    							   "문의하신 고객님 Email : "+currentMember.getMem_mail()+"\n"+
    							   "문의 내용 : "+tfIquiryContent.getText().trim());
    	
    	String from = currentMember.getMem_mail().trim(); // 보내는 사람의 이메일
    	System.out.println(currentMember.getMem_mail());
		String to = "ddhrdmakeit@gmail.com"; // 받는 사람의 이메일
		String cc = ""; //참조하는 이메일
		String subject = tfIquiryTitle.getText().trim();
		
		System.out.println("메일 전송 중....");
		
			try {
				Mail mt = new Mail();
				mt.sendMail2(from, to, cc, subject, content, title);
				System.out.println("인증 메일을 전송하였습니다.");
			} catch (Exception e) {
				System.out.println("메일 전송에 실패하였습니다.");
				System.out.println("실패 이유 : "+e.getMessage());
			}
		}
		
    
    @FXML
    void onRequestChat(ActionEvent event) {
    	try {
    		Stage secondaryStage = new Stage();
    		MultiChatClientMain mm = new MultiChatClientMain();
    		mm.start(secondaryStage);
    		secondaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
}
