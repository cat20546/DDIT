package owner.registRoom;

import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleNode;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.view.MainViewController;
import owner.main.OwnerMainController;
import owner.service.IRegistRoomService;
import owner.service.RegistRoomServiceImpl;
import regEx.RegEx;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;

public class RegistRoomController implements Initializable {

	MemberVO currentMember = MainViewController.getCurrentMember();
	int imageNum = 0;
	boolean imageExist = false;
	File[] images = new File[3];

	/* 종류선택 */
	@FXML
	private ToggleGroup toggleRoomType;
	@FXML
	private JFXToggleNode chk_one_room;
	@FXML
	private JFXToggleNode chk_two_room;
	@FXML
	private JFXToggleNode chk_three_room;
	@FXML
	private JFXToggleNode chk_office_room;
	@FXML
	private JFXToggleNode chk_apart;

	/*
	 * 건물유형
	 * 
	 * @FXML private ToggleGroup toggleBuildType;
	 * 
	 * @FXML private JFXToggleNode chk_house;
	 * 
	 * @FXML private JFXToggleNode chk_many_house;
	 * 
	 * @FXML private JFXToggleNode chk_villa;
	 * 
	 * @FXML private JFXToggleNode chk_sangga;
	 */

	/* 주소 */
	@FXML
	private WebView wb_location;
	@FXML
	private JFXTextField tf_addr1;
	@FXML
	private JFXButton btn_addr;
	@FXML
	private JFXTextArea lb_doromyoung;
	@FXML
	private JFXTextField tf_addrdong;
	@FXML
	private JFXTextField tf_addrho;

	/* 거래정보 */
	@FXML
	private JFXButton chk_monthly_rent;
	@FXML
	private JFXButton chk_jeonsae_rent;
	@FXML
	private ToggleGroup ToggleTransction;

	/* 기본정보 */
	@FXML
	private ToggleGroup toggleDate;
	@FXML
	private JFXToggleNode chk_immediately;
	@FXML
	private JFXTextField tf_supplyArea;
	@FXML
	private JFXTextField tf_supplyAream;
	@FXML
	private JFXComboBox<Integer> cb_floor;
	@FXML
	private JFXComboBox<Integer> cb_my_floor;
	@FXML
	private JFXComboBox<String> cb_heating;
	@FXML
	private JFXToggleNode chk_date_consult;
	@FXML
	private JFXTextField tf_deposit;

	/* 추가정보 */
	@FXML
	private JFXTextField maintenance;
	@FXML
	private JFXToggleNode btn_no_maintenance;
	@FXML
	private JFXToggleNode btn_yes_maintenance;
	@FXML
	private JFXTextField btn_price_maintenance;
	@FXML
	private JFXToggleNode btn_no_car;
	@FXML
	private JFXToggleNode btn_yes_car;
	@FXML
	private JFXToggleNode btn_no_pet;
	@FXML
	private JFXToggleNode btn_yes_pet;
	@FXML
	private JFXToggleNode btn_no_veranda;
	@FXML
	private JFXToggleNode btn_yes_veranda;
	@FXML
	private JFXToggleNode btn_aircon;
	@FXML
	private JFXToggleNode btn_washer;
	@FXML
	private JFXToggleNode btn_bed;
	@FXML
	private JFXToggleNode btn_desk;
	@FXML
	private JFXToggleNode btn_closet;
	@FXML
	private JFXToggleNode btn_tv;
	@FXML
	private JFXToggleNode btn_refrigerator;
	@FXML
	private JFXToggleNode btn_stove;
	@FXML
	private JFXToggleNode btn_no_leasefund;
	@FXML
	private JFXToggleNode btn_yes_leasefund;
	@FXML
	private ToggleGroup toggleMaintenance;
	@FXML
	private ToggleGroup toggleParking;
	@FXML
	private ToggleGroup togglePet;
	@FXML
	private ToggleGroup toggleBalcony;
	@FXML
	private ToggleGroup toggleLoan;

	/* 상세설명 */
	@FXML
	private JFXTextField ft_title;
	@FXML
	private JFXTextArea tf_comment;

	/* 사진정보 */
	@FXML
	private ImageView image_room1;
	@FXML
	private ImageView image_room2;
	@FXML
	private ImageView image_room3;
	@FXML
	private JFXButton image_button;

	/* 등록 취소 */
	@FXML
	private JFXButton btn_cancel;
	
	@FXML
	private JFXButton btn_register;

	@FXML
	private TextField test;

	@FXML
	private JFXCheckBox cbAgree;

	/**
	 * 평수 입력시 자동 입력
	 * 
	 * @param event
	 *            현재는 사용하지 않는 기능입니다.
	 */
	@FXML
	void onSupplyAreaType(ActionEvent event) {

	}

	/**
	 * 이미지 등록 버튼 클릭시
	 * 
	 * @param event
	 */
	@FXML
	void onImageRegistClick(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"), new FileChooser.ExtensionFilter("GIF", "*.gif"));
		File file = fileChooser.showOpenDialog(new Stage());
		if (file == null) {
			return;
		}
		imageExist = true;
		images[imageNum] = file;
		if (imageNum == 0) {
			image_room1.setImage(new Image(file.toURI().toString()));
			System.out.println(file.toURI().toString());
			imageNum = (imageNum + 1) % 3;
		} else if (imageNum == 1) {
			image_room2.setImage(new Image(file.toURI().toString()));
			System.out.println(file.toURI().toString());
			imageNum = (imageNum + 1) % 3;
		} else if (imageNum == 2) {
			image_room3.setImage(new Image(file.toURI().toString()));
			System.out.println(file.toURI().toString());
			imageNum = (imageNum + 1) % 3;
		}
	}
	
	@FXML
    void onBtnCancel(ActionEvent event) {
//		try {
//			FXMLLoader ownerMainPageLoader = new FXMLLoader(getClass().getClassLoader().getResource("owner/registRoom/RegistRoom.fxml"));
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
    }

	StringBuilder result = new StringBuilder(""); // 공실을 등록할 때 입력하지 않은 값이 있는지 검사하는 값
	// 서비스 콜
	IRegistRoomService service = RegistRoomServiceImpl.getInstance();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tf_supplyArea.setOnKeyReleased(new EventHandler<Event>() {
			public void handle(Event event) {
				String pyong = tf_supplyArea.getText().trim();
				if(RegEx.checkNum(pyong)) {
					tf_supplyAream.setText(Math.round(Integer.parseInt(pyong)*3.30579)+"");
				}
				System.out.println(pyong);
			};
		});
		
		
		
		
		
		
		location();
		/* combobox값 */
		// 난방
		cb_heating.getItems().addAll("지역난방", "중앙난방", "개별난방");
		// 층수
		for (int i = 1; i <= 50; i++) {
			cb_floor.getItems().addAll(i);
		}
		// 해당층수
		for (int i = 1; i <= 50; i++) {
			cb_my_floor.getItems().addAll(i);
		}

		
		/**
		 * 공실 등록 버튼을 눌렀을 때
		 */
		btn_register.setOnAction(e -> {
			result = new StringBuilder(""); // 빈값으로 초기화
			/**
			 * 매물종류 등록
			 */
			RoomVO rv = new RoomVO();
			if (toggleRoomType.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleRoomType.getSelectedToggle();
				rv.setRoom_type(jt.getText());
				System.out.println(jt);
			} else {
				result.append("\n매물종류 ");
			}

			/**
			 * 거래정보 등록
			 */
			if (ToggleTransction.getSelectedToggle() != null) {

				JFXToggleNode jt = (JFXToggleNode) ToggleTransction.getSelectedToggle();
				rv.setRoom_transaction(jt.getText());
				System.out.println(jt);
			} else {
				result.append("\n거래정보 ");
			}
			
			/**
			 * 보증금 등록
			 */
			if(RegEx.checkInt(tf_deposit.getText().trim())) {
				rv.setRoom_deposit(Integer.parseInt(tf_deposit.getText().trim()));
			}else {
				result.append("\n보증금");
			}

			/**
			 * 기본정보 등록
			 */
			if (RegEx.checkNum(tf_supplyAream.getText().trim())) {
				rv.setRoom_size(Integer.parseInt(tf_supplyAream.getText()));
			} else {
				result.append("\n방 크기 ");
			}
			if (cb_floor.getValue() != null) {
				rv.setRoom_floor(cb_floor.getValue());
			} else {
				result.append("\n건물 층수 ");
			}
			if (cb_my_floor.getValue() != null) {
				rv.setRoom_my_floor(cb_my_floor.getValue());
			} else {
				result.append("\n해당 층수 ");
			}
			if (cb_heating.getValue() != null) {
				rv.setRoom_heating_system(cb_heating.getValue());
			} else {
				result.append("\n난방 종류 ");
			}

			// boolean값 처리를 위한 코드
			if (toggleDate.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleDate.getSelectedToggle();
				if (jt.getText().equals("즉시입주")) {
					// 1이면 true이므로 즉시입주
					rv.setRoom_available(1);
				} else {
					// 0이면 false이므로 날짜협의
					rv.setRoom_available(0);
				}
			} else {
				result.append("\n입주날짜 ");
			}

			/**
			 * 상세설명 등록
			 */
			if (ft_title.getText().trim().isEmpty()) {
				result.append("\n방 이름 ");
			} else {
				rv.setRoom_name(ft_title.getText());
			}
			if (tf_comment.getText().trim().isEmpty()) {
				result.append("\n방 정보");
			} else {
				rv.setRoom_comment(tf_comment.getText());
			}

			/**
			 * 추가정보 등록
			 */

			if (RegEx.checkInt(btn_price_maintenance.getText())) {
				rv.setRoom_price(Integer.parseInt(btn_price_maintenance.getText()));
			} else {
				result.append("\n가격 ");
			}

			// 주차여부
			if (toggleParking.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleParking.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					rv.setOpt_parking_lot(1);
				}
			} else {
				result.append("\n주차 여부 ");
			}

			// 반려동물
			if (togglePet.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) togglePet.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					rv.setOpt_pet_availabillity(1);
				}
			} else {
				result.append("\n애완동물 가능여부 ");
			}

			// 베란다
			if (toggleBalcony.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleBalcony.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					rv.setOpt_veranda(1);
				}
			} else {
				result.append("\n베란다 여부");
			}

			// 전세 자금 대출
			if (toggleLoan.getSelectedToggle().isSelected()) {
				JFXToggleNode jt = (JFXToggleNode) toggleLoan.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					rv.setOpt_lease_fund(1);
				}
			} else {
				result.append("\n전세자금 대출 여부");
			}

			// 옵션
			// 에어컨 추가
			if (btn_aircon.isSelected()) {
				if (btn_aircon.getText().equals("에어컨")) {
					rv.setOpt_airconditioner(1);
				}
			}

			// 세탁기 추가
			if (btn_washer.isSelected()) {
				if (btn_washer.getText().equals("세탁기")) {
					rv.setOpt_washer(1);
				}
			}

			// 침대 추가
			if (btn_bed.isSelected()) {
				if (btn_bed.getText().equals("침대")) {
					rv.setOpt_bed(1);
				}
			}

			// 옷장 추가
			if (btn_closet.isSelected()) {
				if (btn_closet.getText().equals("옷장")) {
					rv.setOpt_closet(1);
				}
			}

			// TV 추가
			if (btn_tv.isSelected()) {
				if (btn_tv.getText().equals("TV")) {
					rv.setOpt_tv(1);
				}
			}

			// 냉장고 추가
			if (btn_refrigerator.isSelected()) {
				if (btn_refrigerator.getText().equals("냉장고")) {
					rv.setOpt_refregerator(1);
				}
			}

			// 가스레인지 추가
			if (btn_stove.isSelected()) {
				if (btn_stove.getText().equals("가스레인지")) {
					rv.setOpt_stove(1);
				}
			}

			/**
			 * 주소 검색이 되었는지 여부
			 */
			if (lb_doromyoung.getText().trim().isEmpty()) {
				result.append("주소 ");
			}else {
				String addr2 = "";
				String dong = tf_addrdong.getText().trim();
				String ho = tf_addrho.getText().trim();
				rv.setRoom_addr1(lb_doromyoung.getText().trim());
				if(RegEx.checkInt(dong)) {
					addr2 += dong+"동 ";
				}
				if(RegEx.checkId(ho)) {
					addr2 += ho + "호";
				}
				rv.setRoom_addr2(addr2);
			}

			// 현재 로그인한 멤버를 기준으로 방을 올린다
			rv.setMem_id(currentMember.getMem_id());
			
			// 이미지를 올렸는지 확인한다.
			if(!imageExist) {
				result.append("\n이미지 ");
			}
			
			// 약관에 동의하였는지 확인한다.
			if(!cbAgree.isSelected()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("니방내방");
				alert.setHeaderText("Oops");
				alert.setContentText("약관에 동의하셔야 공실 등록이 가능합니다.");
				alert.showAndWait();
				return;
			}
			
			
			// 옵션이 하나도 선택이 안되었다면 경고창을 띄운다
			if (result.toString().isEmpty()) {
				service.insertRegistRoom(rv);
				// 방을 등록한 후 이미지를 내부 res에 저장한다.
				for(File image : images) {
					if(image==null) {
						break;
					}
					String a = image.getName();
					a = a.substring(a.lastIndexOf("."));
					
					try {
			            String old_name = image.getAbsolutePath();
			            String dbURI = "./src/res/room_img/roomImg"+System.currentTimeMillis()+a;
			             
			            // src/aaa.txt 파일을 읽어서
			            FileInputStream fin = new FileInputStream(old_name);
			            // bbb.txt 파일로 복사합니다.
			            FileOutputStream fout = new FileOutputStream(dbURI);
			            
			            int tmp = 0;
			            while ((tmp = fin.read()) != -1) {
			                fout.write(tmp);                
			            }
			            fin.close();
			            fout.close();
			            int room_id = service.getCurrentRoomId();
			            System.out.println("룸아이디 : " + room_id);
			            RoomImgVO riv = new RoomImgVO();
			            riv.setImg_uri("file:"+dbURI);
			            riv.setRoom_id(room_id);
			            service.uploadImage(riv);
			            
			        }catch(Exception e1) {
			            e1.printStackTrace();
			        }
				}
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("니방내방");
				alert.setHeaderText("성공!");
				alert.setContentText("방 등록에 성공하였습니다.");
				alert.showAndWait();
				OwnerMainController.getInstance().gotoMainPage();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("니방내방");
				alert.setHeaderText("실패!");
				alert.setContentText("입력하지 않은 값이 있습니다..\n 입력해야 하는 값 : " + result.toString());
				alert.showAndWait();
			}
		});
	}

	/**
	 * 위치정보를 선택하는 메서드
	 */
	public void location() {
		btn_addr.setOnAction(e -> {
			String addrStr = tf_addr1.getText().trim();
			if (addrStr.isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Oops!");
				alert.setTitle("니방내방");
				alert.setContentText("먼저 주소창에 주소를 입력해주세요");
				alert.showAndWait();
				return;
			}

			String result = service.getAddress(addrStr);

			if (result == null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Oops!");
				alert.setTitle("니방내방");
				alert.setContentText("주소 검색 결과가 없습니다! 다시 입력해주세요.");
				alert.showAndWait();
				return;
			} else {
				lb_doromyoung.setText(result);
				Map<String, String> map = service.getLatLng(addrStr);
				double lat = Double.parseDouble(map.get("lat"));
				double lng = Double.parseDouble(map.get("lng"));

				wb_location.getEngine()
						.load("http://yyy9942.cafe24.com/ddit/searchMapSmall.html?lat=" + lat + "&lng=" + lng);
			}

		});
	}

	// 오류메시지
	public void errMsg(String headerText, String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("오류");
		alert.setHeaderText(headerText);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	public void infoMsg(String headerText, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("정보");
		alert.setHeaderText(headerText);
		alert.setContentText(msg);
		alert.showAndWait();
	}
}