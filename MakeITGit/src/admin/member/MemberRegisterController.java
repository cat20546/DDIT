package admin.member;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import admin.service.AdminMemberServiceImpl;
import admin.service.IAdminMemberService;
import encryption.Encryption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import vo.MemberVO;

public class MemberRegisterController implements Initializable{
	
	IAdminMemberService service = AdminMemberServiceImpl.getInstance();
	
	@FXML
	private JFXButton btnClose;
	
	@FXML
	private JFXTextField tfMemId;
	
	@FXML
	private JFXButton btnDuplCheck;
	
	@FXML
	private JFXTextField tfMemName;
	
	@FXML
	private JFXTextField tfMail1;
	
	@FXML
	private JFXComboBox<String> cbMail2;
	
	@FXML
	private JFXButton btnReqIdNum;
	
	@FXML
	private JFXTextField tfIdNum;

	@FXML
    private JFXButton btnConfIdNum;
	
	@FXML
	private JFXTextField tfMemPw;
	
	@FXML
	private JFXTextField tfConfMemPw;
	
	@FXML
	private JFXComboBox<String> cbMemPhone1;
	
	@FXML
	private JFXTextField tfMemPhone2;
	
	@FXML
	private JFXTextField tfMemPhone3;
	
	@FXML
	private JFXTextField tfMemAddr1;
	
	@FXML
	private JFXButton btnSearchAddr;
	
	@FXML
	private JFXTextField tfMemAddr2;
	
	@FXML
	private DatePicker dpMemBirth;

    @FXML
    private JFXComboBox<String> cbMemAuth;
    
    @FXML
    private JFXButton btnSignUp1;
    
    @FXML
    private JFXButton btnCancel;
    
    int idChk=0;
    int emailChk=0;
    int addrChk=0;
    int emailIdNum;
    Date birth = null;
    
    @FXML
    void close(ActionEvent event) {
    	
    }
    
    @FXML
    void checkDuplication(ActionEvent event) {
    	
    	String id = tfMemId.getText();
    	if(id.trim().isEmpty()) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("ERROR");
    		error.setContentText("아이디를 입력해주세요");
    		error.showAndWait();
    		return;
    	}
    	
    	
    	
    	int chk = service.checkDuplication(id);
    	
    	if(chk>0) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("ERROR");
    		error.setContentText("동일한 아이디가 존재합니다. 다시 입력해주세요.");
    		error.showAndWait();
    		tfMemId.setText(null);
    		idChk=0;
    	}else {
    		Alert conf = new Alert(AlertType.CONFIRMATION);
    		conf.setTitle("CONFIRMATION");
    		conf.setContentText("사용할 수 있는 아이디입니다. 사용하시겠습니까?");
    		
    		ButtonType btnResult = conf.showAndWait().get();
    		if(btnResult==ButtonType.OK) {
    			tfMemId.setText(id);
    			idChk=1;
    		}else {
    			tfMemId.setText(null);
    			idChk=0;
    		}
    	}
    }
    
    /**
     * 주소찾기
     * @param event
     */
    @FXML
    void searchAddress(ActionEvent event) {
    	String inputAddr = tfMemAddr1.getText().trim();
    	if(inputAddr.isEmpty()) {
    		Alert error = new Alert(AlertType.INFORMATION);
    		error.setTitle("니방내방");
    		error.setContentText("주소를 입력해주세요");
    		error.showAndWait();
    		return;
    	}
    	String address = service.getAddress(inputAddr);
    	if(address.isEmpty()) {
    		Alert error = new Alert(AlertType.INFORMATION);
    		error.setTitle("니방내방");
    		error.setContentText("잘못된 주소를 입력하셨습니다");
    		error.showAndWait();
    		return;
    	}
    	tfMemAddr2.setText(address);
    	addrChk=1;
    }
    
    @FXML
    void onDatePicked(ActionEvent event) {
    	LocalDate date =  dpMemBirth.getValue();
    	Date sqlDate = Date.valueOf(date);
    	birth = sqlDate;
    }
    
    @FXML
    void signUp(ActionEvent event) {
    	String id = tfMemId.getText().trim();
    	String name = tfMemName.getText().trim();
    	String mail1 = tfMail1.getText().trim();
    	String mail2 = (String) cbMail2.getSelectionModel().getSelectedItem();
    	String email = mail1+"@"+mail2;
    	String pw = tfMemPw.getText().trim();
    	String phone1 = (String) cbMemPhone1.getSelectionModel().getSelectedItem(); 
    	String phone2 = tfMemPhone2.getText().trim();
    	String phone3 = tfMemPhone3.getText().trim();
    	String phoneNum = phone1+"-"+phone2+"-"+phone3;
    	String addr1 = tfMemAddr1.getText().trim();
    	String addr2 = tfMemAddr2.getText().trim();
    	String reason = (String) cbMemAuth.getSelectionModel().getSelectedItem();
    	String auth=null;
    	
    	if (reason.equals("임차인 등록")) {
    		auth="임차인";
    	}else if(reason.equals("임대인 등록")) {
    		auth="임대인";
    	}else {
    		auth="공인중개사";
    	}
    	
    	IAdminMemberService service = AdminMemberServiceImpl.getInstance();
    	
    	if(id.isEmpty()) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("아이디를 입력해주세요");
    		error.showAndWait();
    	}else if(idChk==0) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("아이디 중복 여부를 확인해주세요.");
    		error.showAndWait();
    	}else if(mail1.isEmpty()) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("이메일 주소를 입력해주세요");
    		error.showAndWait();
    	}else if(pw.isEmpty()) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("비밀번호를 입력해주세요");
    		error.showAndWait();
    	}else if(phone1.isEmpty()||phone2.trim().isEmpty()||phone3.trim().isEmpty()) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("핸드폰 번호를 입력해주세요.");
    		error.showAndWait();
    	}else if(addr1.isEmpty()||addr2.trim().isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("회원등록 실패");
			error.setContentText("주소를 입력해주세요.");
			error.showAndWait();
    	}else if(addrChk==0) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("주소를 확인주세요.");
    		error.showAndWait();
    	}else if(auth.isEmpty()) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("회원등록 실패");
    		error.setContentText("회원등록 목적을 입력해주세요.");
    		error.showAndWait();
    	}
    	else {
    		
    		MemberVO mv = new MemberVO(id, pw, name, birth, email, phoneNum, addr1, addr2, auth);
    		int cnt = service.adminInsert(mv);
    		if (cnt>0) {
    			Alert info = new Alert(AlertType.INFORMATION);
    			info.setTitle("회원등록 성공");
    			info.setContentText("회원등록에 성공하셨습니다.");
    			info.showAndWait();
    	
    			try {
    				Parent root;
    				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
    				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
    				Scene scene = new Scene(root);
    				Stage window =(Stage)btnSignUp1.getScene().getWindow();
    				window.setScene(scene);
    				window.show();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    		}else {
    			Alert error = new Alert(AlertType.ERROR);
    			error.setTitle("회원등록 실패");
        		error.setContentText("다시 시도해주세요.");
        		error.showAndWait();
    		}
    	}
    }
	
    
    
    /**
     * 암호화 
     * 비밀번호 비교
     */
    
    
    public static boolean checkPassword(String mem_pw, String mem_checkpw) {
    	Encryption securityUtil = new Encryption();
		
		String rtn1 = securityUtil.encryptSHA256(mem_pw);
		String rtn2 = securityUtil.encryptSHA256(mem_checkpw);
		if(rtn1.equals(rtn2)) {
		return true;
		}
		return false;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		ObservableList<String> domainList = 
				FXCollections.observableArrayList("naver.com", "daum.net", "gmail.com", "hotmail.com", "hanmail.net", "nate.com", "yahoo.co.kr");
		ObservableList<String> phoneIdNumList = 
				FXCollections.observableArrayList("010", "011", "016", "017", "018", "019");
		ObservableList<String> authorityList = 
				FXCollections.observableArrayList("임차인 등록", "임대인 등록", "공인중개사 등록");
		
		cbMail2.setItems(domainList);
		cbMemPhone1.setItems(phoneIdNumList);
		cbMemAuth.setItems(authorityList);
		
		btnCancel.setOnAction(e->{
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
				Scene scene = new Scene(root);
				Stage window =(Stage)btnCancel.getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
	}
	
	
}
