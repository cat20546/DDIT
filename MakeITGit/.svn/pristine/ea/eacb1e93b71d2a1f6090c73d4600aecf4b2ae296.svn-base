package roomInfo.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import data.MIColor;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.view.BuildedSqlMapConfig;
import main.view.MainViewController;
import roomInfo.service.IRoomInfoService;
import roomInfo.service.RoomInfoServiceImpl;
import searchRoom.dao.SearchRoomDaoImpl;
import searchRoom.service.SearchRoomServiceImpl;
import searchRoom.view.CellController;
import searchRoom.view.DeclareController;
import vo.LikeVO;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;

public class RoomInfoController implements Initializable {
	private static RoomInfoController controller;
	{
		controller = this;
	}
	public static RoomInfoController getInstance() {
		return controller;
	}
	
	public RoomVO getCurrentRoom() {
		return currentRoom;
	}
	
	RoomVO currentRoom;
	
	final String ROOM_SIZE_METER = "m²";
	final String ROOM_SIZE_PYONG = "평";
	
	String sizeText = ROOM_SIZE_METER;
	
	SqlMapClient smc = BuildedSqlMapConfig.getInstance();

	List<RoomImgVO> images = null;
	
	int currentImageIndex = 0;
	
	int like_count = 0;
	
	IRoomInfoService service = RoomInfoServiceImpl.getInstance();
	
	@FXML
	private Label lbSize;
	
	@FXML
    private Label lbView;
	
	@FXML
	private Label lbScore;

	@FXML
	private Label lbVeranda;

	@FXML
	private Label lbRoomSize;
	
    @FXML
    private AnchorPane apContainer;

	@FXML
	private Label lbParking;
	
	@FXML
	JFXButton btnList;

	@FXML
	private Label lbDeposit;
	
	@FXML
	private Label lbScoreComment;

	@FXML
	private Label lbLeaseFund;
	
	@FXML
	private WebView wbChart;
	
	@FXML
	private WebView wbBarchart;

	@FXML
	private Label lbHeating;

	@FXML
	private WebView wbRoomLocation;

	@FXML
	private Label lbRoomPrice;

	@FXML
	private ImageView ivRoomImage;

	@FXML
	private JFXTextArea taRoomContent;

	@FXML
	private Label lbPet;

	@FXML
	private Label lbRoomSizeType;

	@FXML
	private Label lbRoomFloor;

	@FXML
	private TextField tfRoomTitle;

	@FXML
	private Label lbRoomTransaction;

	@FXML
	private Label lbAvailable;

	@FXML
	private Label lbMonthPrice;
	
	@FXML
	private Label lbFullPrice;
	
	@FXML
	private HBox hbOptionContainer;
	
	@FXML
	Label lbLikes;
	
	@FXML
	JFXButton btnLike;
	
    @FXML
    private HBox hbRoomContainer;
    
    @FXML
    private void onRealtorInfoClick() {
    	if(MainViewController.getCurrentMember() == null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops!");
			alert.setContentText("먼저 로그인을 해주세요.");
			alert.showAndWait();
			return;
    	}
    	if(service.isContract(currentRoom.getRoom_id()) != 0) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops!");
			alert.setContentText("이미 계약이 진행중인 방입니다.");
			alert.showAndWait();
			return;
    	}
    	
    	
    	try {
    		Stage stage = new Stage();
    		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("roomInfo/view/wantContract.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    
	/**
	 * 단위 면적 표기 변경 클릭시
	 * @param event
	 */
	@FXML
	void onChangeSizeClick(ActionEvent event) {
		if(sizeText.equals(ROOM_SIZE_PYONG)) {
			sizeText = ROOM_SIZE_METER;
			lbRoomSize.setText(currentRoom.getRoom_size() + sizeText);
			lbSize.setText(currentRoom.getRoom_size() + sizeText);
		}else {
			sizeText = ROOM_SIZE_PYONG;
			lbRoomSize.setText(Math.round(currentRoom.getRoom_size() * 3.305785f) + sizeText);
			lbSize.setText(Math.round(currentRoom.getRoom_size() * 3.305785f) + sizeText);
		}
		lbRoomSizeType.setText(sizeText);
	}

	@FXML
	void onHeartClick(ActionEvent event) {
		MemberVO currentMember = MainViewController.getCurrentMember();
		// 로그인을 안했을 시 null이 넘어온다.
		if(currentMember == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops!");
			alert.setContentText("먼저 로그인을 해주세요.");
			alert.showAndWait();
			return;
		}
		Map<String, Object> param = new HashMap<>();
		param.put("mem_id", currentMember.getMem_id());
		param.put("room_id", currentRoom.getRoom_id());
		
		
		try {
			int memLikeRoom = service.memLikeRoom(param);
			if(memLikeRoom == 0) {
				LikeVO lv = new LikeVO();
				lv.setLike_date(new Date(Calendar.getInstance().getTime().getTime()));
				lv.setMem_id(currentMember.getMem_id());
				lv.setRoom_id(currentRoom.getRoom_id());
				btnLike.setTextFill(Paint.valueOf(MIColor.DEFAULT_BLUE));
				service.insertLike(lv);
			}else {
				LikeVO lv = (LikeVO)smc.queryForObject("roomInfo.getLike", param);
				service.deleteLike(lv.getLike_id());
				btnLike.setTextFill(Paint.valueOf(MIColor.BLUE_GRAY));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		updateLikeCount(currentRoom.getRoom_id());
	}
	
	/**
	 * 스크롤바를 맨 위로 올린다.
	 */
	public void setScrollTop() {
		MainViewController.getInstance().getMainSp().setVvalue(0);
	}
	
	/**
	 * 좋아요 버튼 색상 조정
	 */
	private void setLikeColor() {
		MemberVO currentMember = MainViewController.getCurrentMember();
		// 로그인을 안했을 시 null이 넘어온다.
		if(currentMember == null) {
			return;
		}
		Map<String, Object> param = new HashMap<>();
		param.put("mem_id", currentMember.getMem_id());
		param.put("room_id", currentRoom.getRoom_id());
		try {
			int memLikeRoom = service.memLikeRoom(param);
			if(memLikeRoom == 0) {
				LikeVO lv = new LikeVO();
				lv.setLike_date(new Date(Calendar.getInstance().getTime().getTime()));
				lv.setMem_id(currentMember.getMem_id());
				lv.setRoom_id(currentRoom.getRoom_id());
				btnLike.setTextFill(Paint.valueOf(MIColor.BLUE_GRAY));
			}else {
				LikeVO lv = (LikeVO)smc.queryForObject("roomInfo.getLike", param);
				btnLike.setTextFill(Paint.valueOf(MIColor.DEFAULT_BLUE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 좋아요 갯수를 업데이트한다.
	 * @param roomId
	 */
	private void updateLikeCount(int roomId) {
		like_count = service.getLikeCount(roomId);
		lbLikes.setText(like_count + "");
	}

	/**
	 * 신고 버튼 클릭시
	 * @param event
	 */
	@FXML
	void onReportClick(ActionEvent event) {
		MemberVO currentMember = MainViewController.getCurrentMember();
		if(currentMember == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("니방내방");
			alert.setHeaderText("Oops!");
			alert.setContentText("신고 전 로그인을 해주세요!");
			alert.showAndWait();
			return;
		}
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/declaretion.fxml"));	
			Parent parent = loader.load();
			DeclareController controller = loader.getController();
			controller.setCurrentRoom(currentRoom);
			Stage stage = new Stage();
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(new Scene(parent));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 방 이미지에서 왼쪽을 눌렀을 때
	 * @param event
	 */
	@FXML
	void onRoomImageLeftClick(ActionEvent event) {
		int arrSize = images.size();
		currentImageIndex = (currentImageIndex + arrSize -1)%arrSize;
		ivRoomImage.setImage(new Image(images.get(currentImageIndex).getImg_uri()));
	}

	/**
	 * 방 이미지에서 오른쪽을 눌렀을 때
	 * @param event
	 */
	@FXML
	void onRoomImageRightClick(ActionEvent event) {
		int arrSize = images.size();
		currentImageIndex = (currentImageIndex + 1)%arrSize;
		ivRoomImage.setImage(new Image(images.get(currentImageIndex).getImg_uri()));
	}
	
	/**
	 * 공실 기본정보 세팅
	 * @param currentRoomVO
	 */
	public void setRoomVO(RoomVO currentRoomVO) {
		this.currentRoom = currentRoomVO;
		updateLikeCount(currentRoom.getRoom_id());
		
		lbSize.setText(currentRoom.getRoom_size() + " " + sizeText);
		lbVeranda.setText((currentRoom.getOpt_veranda() == 1) ? "있음" : "없음");
		lbRoomSize.setText(currentRoom.getRoom_size() + " " + sizeText);
		lbParking.setText((currentRoom.getOpt_parking_lot()==1) ? "있음" : "없음");
		lbDeposit.setText(currentRoom.getRoom_deposit() + "만원");
		lbLeaseFund.setText((currentRoom.getOpt_lease_fund()==1)?"가능":"불가능");
		lbHeating.setText(currentRoom.getRoom_heating_system());
		lbRoomPrice.setText(currentRoom.getRoom_price() + "만원");
		taRoomContent.setText(currentRoom.getRoom_comment());
		lbPet.setText((currentRoom.getOpt_pet_availabillity())==1?"가능":"불가능");
		lbRoomSizeType.setText(sizeText);
		lbRoomFloor.setText(currentRoom.getRoom_my_floor() + " / " + currentRoom.getRoom_floor());
		tfRoomTitle.setText(currentRoom.getRoom_name());
		lbRoomTransaction.setText(currentRoom.getRoom_transaction());
		lbAvailable.setText((currentRoom.getRoom_available())==1?"가능":"불가능");
		
		if(currentRoomVO.getRoom_transaction().equals("월세")) {
			lbMonthPrice.setText("월 " + currentRoomVO.getRoom_price() + "만원");
		}else if(currentRoomVO.getRoom_transaction().equals("전세")) {
			lbFullPrice.setText("전세 " + currentRoomVO.getRoom_price() + "만원");
		}
		
		Map<String, String> resultMap = SearchRoomServiceImpl.getInstance().getLatLng(currentRoomVO.getRoom_addr1());
		if(resultMap==null) {
			wbRoomLocation.getEngine().load("http://yyy9942.cafe24.com/ddit/DaumMap.html");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("검색 결과");
			alert.setContentText("잘못된 주소를 입력하셨습니다");
			alert.show();
		}else {
			String lat = resultMap.get("lat");
			String lng = resultMap.get("lng");
			
			wbRoomLocation.getEngine().load("http://yyy9942.cafe24.com/ddit/searchMapBig.html?lat="+lat+"&lng="+lng);
		}
		
		try {
			images = smc.queryForList("roomInfo.getRoomImages",currentRoom.getRoom_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ivRoomImage.setImage(new Image(images.get(0).getImg_uri()));
		
		
		// 여기서부터는 옵션을 줍니다
		
		// 에어컨
		if(currentRoom.getOpt_airconditioner()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_aircon.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 침대
		if(currentRoom.getOpt_bed()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_bed.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 옷장
		if(currentRoom.getOpt_closet()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_closet.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 책상
		if(currentRoom.getOpt_desk()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_desk.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 주차여부
		if(currentRoom.getOpt_parking_lot()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_parking.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 냉장고
		if(currentRoom.getOpt_refregerator()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_refrigerator.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 가스레인지
		if(currentRoom.getOpt_stove()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_stove.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		
		// TV
		if(currentRoom.getOpt_tv()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_tv.png"));
			hbOptionContainer.getChildren().add(iv);
		}
		// 베란다
		if(currentRoom.getOpt_veranda()==1) {
			ImageView iv = new ImageView();
			iv.setFitHeight(100);
			iv.setFitWidth(100);
			iv.setImage(new Image("file:./src/res/opt_icon/opt_veranda.png"));
			hbOptionContainer.getChildren().add(iv);
		}

		setLikeColor();
		
		
		// 뷰 횟수를 조회한다.
		lbView.setText(service.getRoomView(currentRoomVO.getRoom_id())+"");
		
		
		
		// 차트에 들어갈 데이터를 만든다
		int price = (int)((1 - (float)currentRoomVO.getRoom_price() / (currentRoomVO.getRoom_transaction().equals("월세") ? 200 : 20000))*100);
		price = price >= 100 ? 100 : price;
		int commercial = 0;
		int size = (int)(((currentRoomVO.getRoom_size() / (currentRoomVO.getRoom_type().equals("원룸") ? 40f : 80f)))* 100);
		size = size >= 100 ? 100 : size;
		int cnt_option = 0;
		
		if(currentRoomVO.getOpt_airconditioner()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_bed()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_closet()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_desk()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_lease_fund()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_parking_lot()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_pet_availabillity()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_refregerator()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_stove()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_tv()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_veranda()==1)
			cnt_option++;
		if(currentRoomVO.getOpt_washer()==1)
			cnt_option++;
		
		cnt_option = (int)((cnt_option/12f)*100);
		
		
		
		
		
		
		if(resultMap==null) {
			System.out.println("차트에 들어갈 정보없음");
		}else {
			String lat = resultMap.get("lat");
			String lng = resultMap.get("lng");
			Map<String, Float> param = new HashMap<>();
			param.put("lat", Float.parseFloat(lat));
			param.put("lng", Float.parseFloat(lng));
			int cnt = service.getSearchCount(param);
			commercial = (int)((10000 - cnt)/10000f * 100);
		}
		
		
		int totalScore = (price + commercial + size + cnt_option)/4;
		
		
		// 차트를 조작한다
		wbBarchart.getEngine().load("http://yyy9942.cafe24.com/ddit/barchart.html?price="+price+"&cor="+commercial+"&size="+size+"&opt="+cnt_option);
		wbChart.getEngine().load("http://yyy9942.cafe24.com/ddit/chart.html?score="+totalScore);
		
		// 점수를 표기한다
		lbScore.setText(totalScore+"");
		
		// 코멘트를 표기한다.
		String comment = "";
		if(totalScore >= 90) {
			comment = "1순위로 살펴봐야하는 방!";
		}else if(totalScore >= 80) {
			comment = "꼭 한번 봐야 할 방!";
		}else if(totalScore >= 70) {
			comment = "가격대비 괜찮은 방!";
		}else if(totalScore >= 60) {
			comment = "이동네는 보통 이정도";
		}else if(totalScore >= 50) {
			comment = "꼼꼼히 따져보세요";
		}else {
			comment = "자세히 살펴봐야 하는 방";
		}
		lbScoreComment.setText(comment);
		
		// 아래쪽 공인중개사의 다른 방에 리스트를 표기한다
		setBottomRoom();

	}
	
	List<TranslateTransition> ttlist;
	private final int MOVE = 400;
	void setBottomRoom() {
		ttlist = new ArrayList<>();
		hbRoomContainer.getChildren().clear();
		List<RoomVO> list = service.getRealtorRoom(currentRoom.getMem_id());
		Parent subParent;
		try {
			FXMLLoader loader;
			CellController controller;
			for(int i=0; i<list.size(); i++) {
				RoomVO room = list.get(i);
				RoomImgVO roomImg = SearchRoomDaoImpl.getInstance().getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/cell.fxml"));
				subParent = loader.load();
				subParent.getStylesheets().add(getClass().getResource("../../searchRoom/view/cell.css").toString());
				hbRoomContainer.getChildren().add(subParent);
				controller = loader.getController();
				controller.setRoomImage(new Image(roomImg.getImg_uri()));
				controller.setRoomVO(room);
				
				
				TranslateTransition tt = new TranslateTransition(new Duration(300), subParent);
				tt.setFromX(subParent.getLayoutX());
	    		tt.setToX(subParent.getLayoutX() - MOVE);
	    		tt.setCycleCount(1); 
				ttlist.add(tt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 공인중개사의 다른 방에서 왼쪽버튼 클릭시
	 * @param event
	 */
    @FXML
    void onLeftClick(ActionEvent event) {
    	if(!ttlist.isEmpty()) {
    		if(ttlist.get(0).getFromX() >= 300) {
    			return;
    		}
    	}
    	for (TranslateTransition tt : ttlist) {
			tt.setToX(tt.getFromX()+MOVE);
			tt.play();
			tt.setFromX(tt.getFromX()+MOVE);
			tt.setToX(tt.getFromX()-MOVE);
		}
    }
    
	/**
	 * 공인중개사의 다른 방에서 오른쪽버튼 클릭시
	 * 
	 * @param event
	 */
	@FXML
	void onRightClick(ActionEvent event) {
		if(!ttlist.isEmpty()) {
    		if(ttlist.get(ttlist.size()-1).getFromX() <= apContainer.getMaxWidth()) {
    			return;
    		}
    	}
		for(TranslateTransition tt : ttlist) {
    		tt.play();
    		tt.setFromX(tt.getFromX()-MOVE);
    		tt.setToX(tt.getToX()-MOVE);
    	}
	}
	

	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
