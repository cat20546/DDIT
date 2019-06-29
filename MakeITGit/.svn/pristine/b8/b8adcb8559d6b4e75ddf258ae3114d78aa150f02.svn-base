package admin.member;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import admin.mainview.MainViewController;
import admin.service.AdminMemberServiceImpl;
import admin.service.IAdminMemberService;
import encryption.Encryption;
import javafx.application.Application;
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
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import vo.MemberVO;

public class MemberUpdateController implements Initializable {

	IAdminMemberService service = AdminMemberServiceImpl.getInstance();

	MemberVO currentMember;

	public MemberVO getCurrentMember() {
		return currentMember;
	}

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
	private JFXButton btn_delete;

	@FXML
	private JFXButton btnSignUp;

	@FXML
	private JFXButton btn_cancel;
	
	@FXML
	private JFXButton btn_update;
	
	
	
	int idChk = 0;
	int emailChk = 0;
	int addrChk = 0;
	int emailIdNum;
	Date birth;

	/**
	 * DB에있는 date값을 localdate로 바꾸기 위한 메서드
	 * 
	 * @param dateString
	 * @return
	 */
	public static final LocalDate LOCAL_DATE(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		return localDate;
	}

	public MemberVO setCurrentMember(MemberVO currentMember) {
		this.currentMember = currentMember;
		// ============== 여기서 부터 정보를 세팅해 주시면 됩니다 ====================
		ObservableList<String> domainList = FXCollections.observableArrayList("naver.com", "daum.net", "gmail.com",
				"hotmail.com", "hanmail.net", "nate.com", "yahoo.co.kr");
		ObservableList<String> phoneIdNumList = FXCollections.observableArrayList("010", "011", "016", "017", "018",
				"019");
		ObservableList<String> authorityList = FXCollections.observableArrayList("임차인", "임대인", "공인중개사");

		tfMemId.setText(currentMember.getMem_id());
		tfMemName.setText(currentMember.getMem_name());
		// 이메일 자르기
		String[] email = currentMember.getMem_mail().split("@");
		tfMail1.setText(email[0]);
		cbMail2.setValue(email[1]);
		tfMemPw.setText(currentMember.getMem_pw());
		// 핸드폰번호 자르기
		String[] phone = currentMember.getMem_phone().split("-");
		cbMemPhone1.setValue(phone[0]);
		// cbMemPhone1.setSelectionModel(phone[0]);;
		tfMemPhone2.setText(phone[1]);
		tfMemPhone3.setText(phone[2]);
		tfMemAddr1.setText(currentMember.getMem_addr1());
		tfMemAddr2.setText(currentMember.getMem_addr2());
		cbMemAuth.setValue(currentMember.getMem_auth());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(sdf.format(currentMember.getMem_birth()), formatter);

		dpMemBirth.setValue(localDate);
		return currentMember;

	}

	@FXML
	void close(ActionEvent event) {

	}

	@FXML
	void checkDuplication(ActionEvent event) {

		String id = tfMemId.getText();
		if (id.trim().isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("ERROR");
			error.setContentText("아이디를 입력해주세요");
			error.showAndWait();
			return;
		}

		int chk = service.checkDuplication(id);

		if (chk > 0) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("ERROR");
			error.setContentText("동일한 아이디가 존재합니다. 다시 입력해주세요.");
			error.showAndWait();
			tfMemId.setText(null);
			idChk = 0;
		} else {
			Alert conf = new Alert(AlertType.CONFIRMATION);
			conf.setTitle("CONFIRMATION");
			conf.setContentText("사용할 수 있는 아이디입니다. 사용하시겠습니까?");

			ButtonType btnResult = conf.showAndWait().get();
			if (btnResult == ButtonType.OK) {
				tfMemId.setText(id);
				idChk = 1;
			} else {
				tfMemId.setText(null);
				idChk = 0;
			}
		}
	}

	/**
	 * 주소찾기
	 * 
	 * @param event
	 */
	@FXML
	void searchAddress(ActionEvent event) {
		String inputAddr = tfMemAddr1.getText().trim();
		if (inputAddr.isEmpty()) {
			Alert error = new Alert(AlertType.INFORMATION);
			error.setTitle("니방내방");
			error.setContentText("주소를 입력해주세요");
			error.showAndWait();
			return;
		}
		String address = service.getAddress(inputAddr);
		if (address.isEmpty()) {
			Alert error = new Alert(AlertType.INFORMATION);
			error.setTitle("니방내방");
			error.setContentText("잘못된 주소를 입력하셨습니다");
			error.showAndWait();
			return;
		}
		tfMemAddr2.setText(address);
		addrChk = 1;
	}

	@FXML
	void onDatePicked(ActionEvent event) {
		LocalDate date = dpMemBirth.getValue();
		Date sqlDate = Date.valueOf(date);
		birth = sqlDate;

	}

	// 수정 버튼 클릭 이벤트
	@FXML
	void btn_update_action(ActionEvent event) throws IOException {

		String id = tfMemId.getText().trim();
		String name = tfMemName.getText().trim();
		String mail1 = tfMail1.getText().trim();
		String mail2 = (String) cbMail2.getSelectionModel().getSelectedItem();
		String email = mail1 + "@" + mail2;
		String pw = tfMemPw.getText().trim();
		String phone1 = (String) cbMemPhone1.getSelectionModel().getSelectedItem();
		String phone2 = tfMemPhone2.getText().trim();
		String phone3 = tfMemPhone3.getText().trim();
		String phoneNum = phone1 + "-" + phone2 + "-" + phone3;
		String addr1 = tfMemAddr1.getText().trim();
		String addr2 = tfMemAddr2.getText().trim();
		String reason = (String) cbMemAuth.getSelectionModel().getSelectedItem();
		String auth = null;

		if (reason.equals("임차인")) {
			auth = "임차인";
		} else if (reason.equals("임대인")) {
			auth = "임대인";
		} else {
			auth = "공인중개사";
		}

		IAdminMemberService service = AdminMemberServiceImpl.getInstance();

		if (mail1.isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("회원등록 실패");
			error.setContentText("이메일 주소를 입력해주세요");
			error.showAndWait();
		} else if (pw.isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("회원등록 실패");
			error.setContentText("비밀번호를 입력해주세요");
			error.showAndWait();
		} else if (phone1.isEmpty() || phone2.trim().isEmpty() || phone3.trim().isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("회원등록 실패");
			error.setContentText("핸드폰 번호를 입력해주세요.");
			error.showAndWait();
		} else if (addr1.isEmpty() || addr2.trim().isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("회원등록 실패");
			error.setContentText("주소를 입력해주세요.");
			error.showAndWait();
		} /*
			 * else if(addrChk==0) { Alert error = new Alert(AlertType.ERROR);
			 * error.setTitle("회원등록 실패"); error.setContentText("주소를 확인주세요.");
			 * error.showAndWait(); }
			 */else if (auth.isEmpty()) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("회원등록 실패");
			error.setContentText("회원등록 목적을 입력해주세요.");
			error.showAndWait();
		} else {

			// 업데이트 쿼리
			MemberVO mv = new MemberVO(id, pw, name, birth, email, phoneNum, addr1, addr2, auth);
			int cnt = service.updateMember(mv);

			if (cnt > 0) {
				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("회원수정 성공");
				info.setContentText("회원수정에 성공하셨습니다.");
				info.showAndWait();
				// 창닫기
				MemberController mc = new MemberController();
				MemberController membercontroller;
				MainViewController mvc = new MainViewController();
				//MemberController controller = MemberController.getInstance();
				//controller.getMainContainer().setCenter(MemberController.getCenterContainer());
				
				// 회원모드로 화면이동
				try {
					Parent root;
					root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
					root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
					Scene scene = new Scene(root);
					Stage window =(Stage)btn_update.getScene().getWindow();
					window.setScene(scene);
					window.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			} else {
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("회원수정 실패");
				error.setContentText("다시 시도해주세요.");
				error.showAndWait();
				
					
			}	
			}	
	}

	// 삭제버튼 클릭 이벤트

	@FXML
	void btn_delete_Action(ActionEvent event) {
		MemberVO mv = new MemberVO();
		int cnt = service.deleteMember(currentMember.getMem_id());

		if (cnt > 0) {
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("회원삭제 성공");
			info.setContentText("회원삭제에 성공하셨습니다.");
			info.showAndWait();
			
			//회원모드 이동
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
				Scene scene = new Scene(root);
				Stage window =(Stage)btn_update.getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} else {
			Alert info = new Alert(AlertType.INFORMATION);
			info.setTitle("회원삭제 실패");
			info.setContentText("회원삭제에 실패하셨습니다.");
			info.showAndWait();
		}
	}

	/**
	 * 암호화 비밀번호 비교
	 */

	public static boolean checkPassword(String mem_pw, String mem_checkpw) {
		Encryption securityUtil = new Encryption();

		String rtn1 = securityUtil.encryptSHA256(mem_pw);
		String rtn2 = securityUtil.encryptSHA256(mem_checkpw);
		if (rtn1.equals(rtn2)) {
			return true;
		}
		return false;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<String> domainList = FXCollections.observableArrayList("naver.com", "daum.net", "gmail.com",
				"hotmail.com", "hanmail.net", "nate.com", "yahoo.co.kr");
		ObservableList<String> phoneIdNumList = FXCollections.observableArrayList("010", "011", "016", "017", "018",
				"019");
		ObservableList<String> authorityList = FXCollections.observableArrayList("임차인", "임대인", "공인중개사");
		cbMail2.setItems(domainList);
		cbMemPhone1.setItems(phoneIdNumList);
		cbMemAuth.setItems(authorityList);

		cbMemPhone1.getSelectionModel().select(0);
		cbMemAuth.getSelectionModel().select(0);

		// 취소버튼
		btn_cancel.setOnAction(e -> {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
				Scene scene = new Scene(root);
				Stage window =(Stage)btn_update.getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

}
