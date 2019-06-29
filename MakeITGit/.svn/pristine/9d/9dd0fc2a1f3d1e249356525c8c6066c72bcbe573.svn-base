package admin.room;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleNode;

import admin.mainview.MainViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import owner.main.OwnerMainController;
import owner.service.IRegistRoomService;
import owner.service.RegistRoomServiceImpl;
import regEx.RegEx;
import roomInfo.service.RoomInfoServiceImpl;
import searchRoom.service.ISearchRoomService;
import searchRoom.service.SearchRoomServiceImpl;
import vo.RoomImgVO;
import vo.RoomVO;

public class RoomUpdateController implements Initializable{
	
	@FXML
    private ToggleGroup togglePet;

    @FXML
    private JFXToggleNode btn_yes_leasefund;

    @FXML
    private JFXToggleNode chk_three_room;

    @FXML
    private JFXComboBox<String> cb_heating;

    @FXML
    private JFXTextField tf_addrdong;

    @FXML
    private WebView wb_location;

    @FXML
    private JFXComboBox<Integer> cb_my_floor;

    @FXML
    private ToggleGroup toggleDate;

    @FXML
    private JFXComboBox<Integer> cb_floor;

    @FXML
    private JFXToggleNode btn_jeonsae;

    @FXML
    private JFXTextField tf_supplyArea;

    @FXML
    private JFXTextField tf_deposit;

    @FXML
    private JFXToggleNode btn_tv;

    @FXML
    private JFXToggleNode chk_oneroom;

    @FXML
    private JFXToggleNode btn_montly;

    @FXML
    private JFXTextField ft_title;

    @FXML
    private JFXButton btn_register1;

    @FXML
    private JFXToggleNode btn_washer;

    @FXML
    private JFXToggleNode chk_apart;

    @FXML
    private JFXTextField btn_price_maintenance;

    @FXML
    private JFXToggleNode btn_no_pet;

    @FXML
    private JFXToggleNode btn_yes_pet;
    
    @FXML
    private JFXToggleNode chk_date_consult;

    @FXML
    private JFXTextField tf_addr1;

    @FXML
    private JFXToggleNode btn_desk;

    @FXML
    private ToggleGroup ToggleTransction;

    @FXML
    private JFXToggleNode chk_immediately;

    @FXML
    private JFXTextField tf_supplyAream;

    @FXML
    private JFXTextArea lb_doromyoung;

    @FXML
    private JFXTextField tf_addrho;

    @FXML
    private ToggleGroup toggleLoan;

    @FXML
    private JFXToggleNode btn_yes_veranda;

    @FXML
    private JFXToggleNode btn_bed;

    @FXML
    private ImageView image_room3;

    @FXML
    private JFXTextArea tf_comment;

    @FXML
    private JFXButton image_button;

    @FXML
    private JFXButton btn_register;

    @FXML
    private ImageView image_room2;

    @FXML
    private JFXButton btn_addr;

    @FXML
    private JFXToggleNode btn_no_car;

    @FXML
    private ImageView image_room1;

    @FXML
    private ToggleGroup toggleParking;

    @FXML
    private JFXToggleNode btn_closet;

    @FXML
    private JFXToggleNode btn_no_veranda;

    @FXML
    private ToggleGroup toggleRoomType;

    @FXML
    private JFXToggleNode chk_office_room;

    @FXML
    private JFXToggleNode btn_aircon;

    @FXML
    private JFXToggleNode btn_yes_car;

    @FXML
    private JFXToggleNode btn_refrigerator;

    @FXML
    private JFXToggleNode btn_stove;

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private JFXToggleNode btn_no_leasefund;

    @FXML
    private JFXToggleNode chk_two_room;

    @FXML
    private ToggleGroup toggleBalcony;
	
    RoomVO currentRoom;
    
    int imageNum = 0;
	boolean imageExist = false;
	File[] images = new File[3];
	
	ISearchRoomService service = SearchRoomServiceImpl.getInstance();
    MainViewController controller = MainViewController.getInstance();
    
    List<RoomImgVO> imageList;
    
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
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> heatingList = FXCollections.observableArrayList("지역난방","중앙난방", "개별난방");
		
		cb_heating.setItems(heatingList);
		
		//취소 버튼
		btn_cancel.setOnAction(e->{
			try {
				// 취소 창
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("admin/room/RoomList.fxml"));
				Parent parent = loader.load();
				controller.getBpMainContainer().setCenter(parent);
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		
		
		// 수정 버튼
		btn_register.setOnAction(e-> {
			ISearchRoomService service = SearchRoomServiceImpl.getInstance();
			IRegistRoomService Regservice = RegistRoomServiceImpl.getInstance();
			
			StringBuilder result = new StringBuilder("");
			
			result = new StringBuilder(""); // 빈값으로 초기화
			/**
			 * 매물종류 등록
			 */
			
//			RoomVO currentRoom = new RoomVO();
			
			if (toggleRoomType.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleRoomType.getSelectedToggle();
				currentRoom.setRoom_type(jt.getText());
				System.out.println(jt);
			} else {
				result.append("\n매물종류 ");
			}

			/**
			 * 거래정보 등록
			 */
			if (ToggleTransction.getSelectedToggle() != null) {

				JFXToggleNode jt = (JFXToggleNode) ToggleTransction.getSelectedToggle();
				currentRoom.setRoom_transaction(jt.getText());
				System.out.println(jt);
			} else {
				result.append("\n거래정보 ");
			}
			
			/**
			 * 보증금 등록
			 */
			if(RegEx.checkInt(tf_deposit.getText().trim())) {
				currentRoom.setRoom_deposit(Integer.parseInt(tf_deposit.getText().trim()));
			}else {
				result.append("\n보증금");
			}

			/**
			 * 기본정보 등록
			 */
			
			if (RegEx.checkNum(tf_supplyArea.getText().trim())) {
				currentRoom.setRoom_size(Integer.parseInt(tf_supplyArea.getText()));
			} else {
				result.append("\n방 크기 ");
			}
			if (RegEx.checkNum(tf_supplyAream.getText().trim())) {
				currentRoom.setRoom_size(Integer.parseInt(tf_supplyAream.getText()));
			} else {
				result.append("\n방 크기 ");
			}
			if (cb_floor.getValue() != null) {
				currentRoom.setRoom_floor(cb_floor.getValue());
			} else {
				result.append("\n건물 층수 ");
			}
			if (cb_my_floor.getValue() != null) {
				currentRoom.setRoom_my_floor(cb_my_floor.getValue());
			} else {
				result.append("\n해당 층수 ");
			}
			if (cb_heating.getValue() != null) {
				currentRoom.setRoom_heating_system(cb_heating.getValue());
			} else {
				result.append("\n난방 종류 ");
			}

			// boolean값 처리를 위한 코드
			if (toggleDate.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleDate.getSelectedToggle();
				if (jt.getText().equals("즉시입주")) {
					// 1이면 true이므로 즉시입주
					currentRoom.setRoom_available(1);
				} else {
					// 0이면 false이므로 날짜협의
					currentRoom.setRoom_available(0);
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
				currentRoom.setRoom_name(ft_title.getText());
			}
			if (tf_comment.getText().trim().isEmpty()) {
				result.append("\n방 정보");
			} else {
				currentRoom.setRoom_comment(tf_comment.getText());
			}

			/**
			 * 추가정보 등록
			 */

			if (RegEx.checkInt(btn_price_maintenance.getText())) {
				currentRoom.setRoom_price(Integer.parseInt(btn_price_maintenance.getText()));
			} else {
				result.append("\n가격 ");
			}

			// 주차여부
			if (toggleParking.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleParking.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					currentRoom.setOpt_parking_lot(1);
				}
			} else {
				result.append("\n주차 여부 ");
			}

			// 반려동물
			if (togglePet.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) togglePet.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					currentRoom.setOpt_pet_availabillity(1);
				}
			} else {
				result.append("\n애완동물 가능여부 ");
			}

			// 베란다
			if (toggleBalcony.getSelectedToggle() != null) {
				JFXToggleNode jt = (JFXToggleNode) toggleBalcony.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					currentRoom.setOpt_veranda(1);
				}
			} else {
				result.append("\n베란다 여부");
			}

			// 전세 자금 대출
			if (toggleLoan.getSelectedToggle().isSelected()) {
				JFXToggleNode jt = (JFXToggleNode) toggleLoan.getSelectedToggle();
				if (jt.getText().equals("불가능")) {
					currentRoom.setOpt_lease_fund(1);
				}
			} else {
				result.append("\n전세자금 대출 여부");
			}

			// 옵션
			// 에어컨 추가
			if (btn_aircon.isSelected()) {
				if (btn_aircon.getText().equals("에어컨")) {
					currentRoom.setOpt_airconditioner(1);
				}
			}

			// 세탁기 추가
			if (btn_washer.isSelected()) {
				if (btn_washer.getText().equals("세탁기")) {
					currentRoom.setOpt_washer(1);
				}
			}

			// 침대 추가
			if (btn_bed.isSelected()) {
				if (btn_bed.getText().equals("침대")) {
					currentRoom.setOpt_bed(1);
				}
			}

			// 옷장 추가
			if (btn_closet.isSelected()) {
				if (btn_closet.getText().equals("옷장")) {
					currentRoom.setOpt_closet(1);
				}
			}
			
			// 책상 추가
			if (btn_desk.isSelected()) {
				if (btn_desk.getText().equals("책상")) {
					currentRoom.setOpt_desk(1);
				}
			}
						
			// TV 추가
			if (btn_tv.isSelected()) {
				if (btn_tv.getText().equals("TV")) {
					currentRoom.setOpt_tv(1);
				}
			}

			// 냉장고 추가
			if (btn_refrigerator.isSelected()) {
				if (btn_refrigerator.getText().equals("냉장고")) {
					currentRoom.setOpt_refregerator(1);
				}
			}

			// 가스레인지 추가
			if (btn_stove.isSelected()) {
				if (btn_stove.getText().equals("가스레인지")) {
					currentRoom.setOpt_stove(1);
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
				currentRoom.setRoom_addr1(lb_doromyoung.getText().trim());
				if(RegEx.checkInt(dong)) {
					addr2 += dong+"동 ";
				}
				if(RegEx.checkId(ho)) {
					addr2 += ho + "호";
				}
				currentRoom.setRoom_addr2(addr2);
			}

			// 현재 로그인한 멤버를 기준으로 방을 올린다
			
			// 이미지를 올렸는지 확인한다.
			if(!imageExist) {
				result.append("\n이미지 ");
			}
			
			/**
			 * 이미지 등록 버튼 클릭시
			 * 
			 * @param event
			 */
			
			// 옵션이 하나도 선택이 안되었다면 경고창을 띄운다
			if (result.toString().isEmpty()) {
				service.updateRoom(currentRoom);
				// 방을 등록한 후 이미지를 내부 res에 저장한다.
				for(int i=0; i<images.length; i++) {
					
					File image = images[i];
					if(image==null) {
						return;
					}
					String a = image.getName();
					a = a.substring(a.lastIndexOf("."));
					String old_name = image.getAbsolutePath();
					String dbURI = "./src/res/room_img/roomImg"+System.currentTimeMillis()+a;
					
					try {
			             
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
			            int room_id = Regservice.getCurrentRoomId();
			            System.out.println("룸아이디 : " + room_id);
			            
			            
			            RoomImgVO riv = imageList.get(i);
			            
			            riv.setImg_uri("file:"+dbURI);
			            riv.setRoom_id(room_id);
			            
			            int cnt = service.updateRoomImg(riv);
			            
			        }catch(IndexOutOfBoundsException ie) {
			        	RoomImgVO riv = new RoomImgVO();
			        	riv.setImg_uri("file:"+dbURI);
			            riv.setRoom_id(Regservice.getCurrentRoomId());
			        	RegistRoomServiceImpl.getInstance().uploadImage(riv);
			        }catch(Exception e1) {
			            e1.printStackTrace();
			        }
				}
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("니방내방");
				alert.setHeaderText("성공!");
				alert.setContentText("방 수정에 성공하였습니다.");
				alert.showAndWait();
				OwnerMainController.getInstance().gotoMainPage();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("니방내방");
				alert.setHeaderText("실패!");
				alert.setContentText("입력하지 않은 값이 있습니다..\n 입력해야 하는 값 : " + result.toString());
				alert.showAndWait();
			}
			
			int cnt = service.updateRoom(currentRoom);
			
		});
	
	}
	
	
	
	public RoomVO setCurrentRoom(RoomVO currentRoom) {
		this.currentRoom = currentRoom;
		
		// 층수
		ObservableList<Integer> cb_floorList = FXCollections.observableArrayList();
		// 해당층수
		ObservableList<Integer> cb_floorMyList = FXCollections.observableArrayList();
		
		// 매물종류 조회
		String type = currentRoom.getRoom_type();
		switch(type) {
		case "원룸":
			chk_oneroom.setSelected(true);
			break;
		case "투룸":
			chk_two_room.setSelected(true);
			break;
		case "쓰리룸":
			chk_three_room.setSelected(true);
			break;
		case "오피스텔":
			chk_office_room.setSelected(true);
			break;
		case "아파트":
			chk_apart.setSelected(true);
			break;
		}
		
		// 주소 조회
		
		lb_doromyoung.setText(currentRoom.getRoom_addr1());
		
		
		// 거래종류 조회
		String Transaction = currentRoom.getRoom_transaction();
		if(Transaction.equals("월세")) {
			btn_montly.setSelected(true);
		} else {
			btn_jeonsae.setSelected(true);
		}
		
		// 기본정보 조회
		String roomSize = currentRoom.getRoom_size()+"";
		tf_supplyArea.setText(roomSize);
		String roomSize2 = Math.round(currentRoom.getRoom_size() * 0.3025f)+"";
		tf_supplyAream.setText(roomSize2);
		
		
		// 난방
		ObservableList<String> heatingList = FXCollections.observableArrayList("지역난방","중앙난방", "개별난방");
		cb_heating.setValue(currentRoom.getRoom_heating_system());
		//건물층수
		// 층수
		for (int i = 1; i <= 50; i++) {
			cb_floor.getItems().add(i);
		}
		// 해당층수
		for (int i = 1; i <= 50; i++) {
			cb_my_floor.getItems().add(i);
		}
		
		int floor = currentRoom.getRoom_floor();
		int my_floor = currentRoom.getRoom_my_floor();
		
		cb_floor.getSelectionModel().select(floor-1);
		cb_my_floor.getSelectionModel().select(my_floor-1);
		
		// 입주 가능일 
		int moveIn = currentRoom.getRoom_available();
		if(moveIn==1) {
			chk_immediately.setSelected(true);
		} else {
			chk_date_consult.setSelected(true);
		}
		
		// 가격
		String price = currentRoom.getRoom_price()+"";
		btn_price_maintenance.setText(price);
		
		// 보증금
		String deposit = currentRoom.getRoom_deposit()+"";
		tf_deposit.setText(deposit);
		
		// 주차여부
		String car = currentRoom.getOpt_parking_lot()+"";
		if(car.equals("불가능")) {
			btn_yes_car.setSelected(true);
		} else {
			btn_no_car.setSelected(true);
		}
		
		// 베란다
		String veranda= currentRoom.getOpt_veranda()+"";
		if(veranda.equals("없음")) {
			btn_yes_veranda.setSelected(true);
		} else {
			btn_no_veranda.setSelected(true);
		}
		
		// 펫
		String pet = currentRoom.getOpt_pet_availabillity()+"";
		if(pet.equals("불가능")) {
			btn_no_pet.setSelected(true);
		} else {
			btn_yes_pet.setSelected(true);
		}
		
		// 옵션
		int aircon = currentRoom.getOpt_airconditioner();
		int washer = currentRoom.getOpt_washer();
		int bed = currentRoom.getOpt_bed();
		int desk = currentRoom.getOpt_desk();
		int closet = currentRoom.getOpt_closet();
		int tv = currentRoom.getOpt_tv();
		int refrigerator = currentRoom.getOpt_refregerator();
		int stove = currentRoom.getOpt_stove();
		
		// 옵션
		if(aircon==1) {
			btn_aircon.setSelected(true); 
		} if(washer==1) {
			btn_washer.setSelected(true);
		} if(bed==1) {
			btn_bed.setSelected(true);
		} if(desk==1) {
			btn_desk.setSelected(true);
		} if(closet==1) {
			btn_closet.setSelected(true);
		} if(tv==1) {
			btn_tv.setSelected(true);
		} if(refrigerator==1) {
			btn_refrigerator.setSelected(true);
		} if(stove==1) {
			btn_stove.setSelected(true);
		}
		
		
		
		//전세자금대출
		String leasefund = currentRoom.getOpt_lease_fund()+"";
		if(leasefund.equals("불가능")) {
			btn_no_leasefund.setSelected(true);
		} else {
			btn_yes_leasefund.setSelected(true);
		}
		
		ft_title.setText(currentRoom.getRoom_name());
		tf_comment.setText(currentRoom.getRoom_comment());
		
		int room_id = currentRoom.getRoom_id();
		imageList = RoomInfoServiceImpl.getInstance().getRoomImages(currentRoom.getRoom_id());
		RoomImgVO img =imageList.get(0);
		image_room1.setImage(new Image(img.getImg_uri()));
		if(imageList.size()>1) {
			img = imageList.get(1);
			image_room2.setImage(new Image(img.getImg_uri()));
		}
		if(imageList.size()>2) {
			img = imageList.get(2);
			image_room3.setImage(new Image(img.getImg_uri()));
		}
		return currentRoom;
	}
	
	/*if(toggleRoomType.getSelectedToggle() !=null) {
	JFXToggleNode jt = (JFXToggleNode)toggleRoomType.getSelectedToggle();
	currentRoom.setRoom_type(jt.getText());
}*/
	
	
}
