package searchRoom.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.view.BuildedSqlMapConfig;
import searchRoom.service.ISearchRoomService;
import searchRoom.service.SearchRoomServiceImpl;
import vo.RoomImgVO;
import vo.RoomVO;

public class SearchRoomViewController implements Initializable{
	ISearchRoomService service = SearchRoomServiceImpl.getInstance();
	SqlMapClient smc;
	ObservableList<RoomVO> roomList;
	
	private static SearchRoomViewController srViewController;
	
	public SearchRoomViewController() {
		srViewController = this;
	}
	
	public static SearchRoomViewController getInstance() {
		return srViewController;
	}
	
	

    @FXML
    private FlowPane fpContainer;
	@FXML
	WebView webViewMainMap;
	@FXML
	ImageView ivLogo;
    @FXML
    private Label lbRoomNumber;
    @FXML
    private StackPane spCenterPane;
    @FXML
    private Button btnRoomType;
    @FXML
    private Button brnFilter;
    @FXML
    private Button btnRoomSize;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnRoomTransaction;

    @FXML
    private Button btnRoomPrice;

    
    
    private boolean oneRoom = true;
    private boolean twoThreeRoom = true;
    private boolean officetel = true;
    private boolean month = true;
    private boolean full = true;
    private boolean trade = true;
    private int monthPrice = 400;
    private int fullPrice = 10000;
    private int roomSize = 200;
    private boolean bed;
    private boolean desk;
    private boolean tv;
    private boolean air;
    private boolean ref;
    private boolean stove;
    private boolean washer;
    private boolean closet;
    
    private void setFilter() {
    	ObservableList<RoomVO> filterdList = FXCollections.observableArrayList();
    	for(RoomVO roomVO : roomList) {
    		if(oneRoom = true && roomVO.getRoom_type().equals("원룸")) {
    			
    		}else if(twoThreeRoom && (roomVO.getRoom_type().equals("투룸")||roomVO.getRoom_type().equals("쓰리룸"))) {
    			
    		}else if(officetel && roomVO.getRoom_type().equals("오피스텔")) {
    			
    		}else {
    			continue;
    		}
    		
    		
    		
    		if(month && roomVO.getRoom_transaction().equals("월세")) {
    			
    		}else if(full && roomVO.getRoom_transaction().equals("전세")) {
    			
    		}else if(trade && roomVO.getRoom_transaction().equals("매매")) {
    			
    		}else {
    			continue;
    		}
    		
    		
    		if(roomVO.getRoom_price() <= monthPrice && month && roomVO.getRoom_transaction().equals("월세")) {
    		}else if(roomVO.getRoom_price() <= fullPrice && month && roomVO.getRoom_transaction().equals("전세")) {
    		}else {
    			continue;
    		}
    		
    		
    		if(roomVO.getRoom_size() <= roomSize) {
    		}else {
    			continue;
    		}
    		if(bed) {
    			if(roomVO.getOpt_bed() == 0) {
    				continue;
    			}else {
    			}
    		}
    		if(desk) {
    			if(roomVO.getOpt_desk() == 0) {
    				continue;
    			}else {
    			}
    		}
    		if(tv) {
    			if(roomVO.getOpt_tv() == 0) {
    				continue;
    			}else {
    			}
    		}
    		if(air) {
    			if(roomVO.getOpt_airconditioner() == 0) {
    				continue;
    			}else {
    			}
    		}
    		if(ref) {
    			if(roomVO.getOpt_stove() == 0) {
    				continue;
    			}else {
    			}
    		}
    		if(ref) {
    			if(roomVO.getOpt_washer() == 0) {
    				continue;
    			}else {
    			}
    		}
    		if(ref) {
    			if(roomVO.getOpt_closet() == 0) {
    				continue;
    			}else {
    			}
    		}
    		
    		
    		filterdList.add(roomVO);
    	}
    	
    	fpContainer.getChildren().clear();
    	
    	Parent subParent;
		try {
			FXMLLoader loader;
			CellController controller;
			for(int i=0; i<filterdList.size(); i++) {
				RoomVO room = filterdList.get(i);
				RoomImgVO roomImg = service.getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getResource("../view/cell.fxml"));
				subParent = loader.load();
				subParent.getStylesheets().add(getClass().getResource("../view/cell.css").toString());
				fpContainer.getChildren().add(subParent);
				controller = loader.getController();
				controller.setRoomImage(new Image(roomImg.getImg_uri()));
				controller.setRoomVO(room);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lbRoomNumber.setText(filterdList.size()+"");
    	
    }
	
	
    
    
    
	/**
     * 상단 검색버튼 클릭시
     * @param event
     */
    @FXML
    void onSearchClick(ActionEvent event) {
    	setMainMap(tfSearch.getText());
    	setFilter();
    }
    
    @FXML
    void onRoomTypeClick(ActionEvent event) {
    	btnRoomType.setStyle("-fx-background-color:#CEF6F5");
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/optRoomType.fxml"));
    	try {
			Parent parent = loader.load();
			OptRoomTypeController controller = loader.getController();
			controller.setOption(oneRoom, twoThreeRoom, officetel);
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setX(480);
			stage.setY(230);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();
			
			setFilter();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	btnRoomType.setStyle("-fx-background-color:#FFFFFF");
    	btnRoomType.setTextFill(Color.BLACK);
    }

    @FXML
    void onRoomTransactionClick(ActionEvent event) {
    	btnRoomTransaction.setStyle("-fx-background-color:#CEF6F5");
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/optRoomTransaction.fxml"));
    	try {
			Parent parent = loader.load();
			OptRoomTransactionController controller = loader.getController();
			controller.setOption(month, full, trade);
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setX(700);
			stage.setY(230);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();
			
			setFilter();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	btnRoomTransaction.setStyle("-fx-background-color:#FFFFFF");
    }

    @FXML
    void onRoomPriceClick(ActionEvent event) {
    	btnRoomPrice.setStyle("-fx-background-color:#CEF6F5");
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/optRoomPrice.fxml"));
    	try {
			Parent parent = loader.load();
			OptRoomPriceController controller = loader.getController();
			controller.setOption(monthPrice, fullPrice);
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setX(920);
			stage.setY(230);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();
			
			setFilter();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	btnRoomPrice.setStyle("-fx-background-color:#FFFFFF");
    }

    @FXML
    void onRoomSizeClick(ActionEvent event) {
    	btnRoomSize.setStyle("-fx-background-color:#CEF6F5");
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/optRoomSize.fxml"));
    	try {
			Parent parent = loader.load();
			OptRoomSizeController controller = loader.getController();
			controller.setOption(roomSize);
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setX(1000);
			stage.setY(230);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();
			
			setFilter();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	btnRoomSize.setStyle("-fx-background-color:#FFFFFF");
    }

    @FXML
    void onRoomFilterClick(ActionEvent event) {
    	brnFilter.setStyle("-fx-background-color:#CEF6F5");
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/optRoomFilter.fxml"));
    	try {
			Parent parent = loader.load();
			OptRoomFilterController controller = loader.getController();
			Map<String, Boolean> param = new HashMap<>();
			param.put("bed", this.bed);
			param.put("desk", this.desk);
			param.put("tv", this.tv);
			param.put("air", this.air);
			param.put("ref", this.ref);
			param.put("stove", this.stove);
			param.put("washer", this.washer);
			param.put("closet", this.closet);
			controller.setOption(param);
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setX(1100);
			stage.setY(230);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();
			
			setFilter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	brnFilter.setStyle("-fx-background-color:#FFFFFF");
    }
    
    
    
    
    
    public void setRoomType(boolean oneRoom, boolean twoThreeRoom, boolean Officetel) {
    	this.oneRoom = oneRoom;
    	this.twoThreeRoom = twoThreeRoom;
    	this.officetel = Officetel;
    }
    public void setRoomTransaction(boolean month, boolean full, boolean trade) {
    	this.month = month;
    	this.full = full;
    	this.trade = trade;
    }
    public void setRoomPrice(double monthPrice, double fullPrice) {
    	this.monthPrice = (int)monthPrice;
    	this.fullPrice = (int)fullPrice;
    }
    public void setRoomSize(int roomSize) {
    	this.roomSize = roomSize;
    }
    public void setRoomFilter(Map<String, Boolean> param) {
    	this.bed = param.get("bed");
    	this.desk = param.get("desk");
    	this.tv = param.get("tv");
    	this.air = param.get("air");
    	this.ref = param.get("ref");
    	this.stove = param.get("stove");
    	this.washer = param.get("washer");
    	this.closet = param.get("closet");
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			roomList = service.getRoomList();
			setDatabase();
			setMainRoomView();
			setMainMap();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void setDatabase() throws IOException {
		smc = BuildedSqlMapConfig.getInstance();
	}
	
	private void searchRoomWithOption() {
		Map<String, Object> param = new HashMap<>();
		// 이곳에 검색 알고리즘을 만들어야 합니다.
		
		// 여기까지
	}
	
	/**
	 * @author 정준
	 * @throws SQLException
	 * 메인 뷰에 방을 세팅함
	 */
	private void setMainRoomView() throws SQLException {
		Parent subParent;
		try {
			FXMLLoader loader;
			CellController controller;
			for(int i=0; i<roomList.size(); i++) {
				RoomVO room = roomList.get(i);
				RoomImgVO roomImg = service.getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getResource("../view/cell.fxml"));
				subParent = loader.load();
				subParent.getStylesheets().add(getClass().getResource("../view/cell.css").toString());
				fpContainer.getChildren().add(subParent);
				controller = loader.getController();
				controller.setRoomImage(new Image(roomImg.getImg_uri()));
				controller.setRoomVO(room);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lbRoomNumber.setText(roomList.size()+"");
	}
	
	private void setMainMap() {
		webViewMainMap.getEngine().load("http://yyy9942.cafe24.com/ddit/DaumMap.html");
	}
	public void setMainMap(String searchStr) {
		Map<String, String> resultMap = service.getLatLng(searchStr);
		if(resultMap == null) {
			webViewMainMap.getEngine().load("http://yyy9942.cafe24.com/ddit/DaumMap.html");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("검색 결과");
			alert.setContentText("잘못된 주소를 입력하셨습니다");
			alert.show();
		}else {
			String lat = resultMap.get("lat");
			String lng = resultMap.get("lng");
			webViewMainMap.getEngine().load("http://yyy9942.cafe24.com/ddit/DaumMap.html?lat="+lat+"&lng="+lng);
		}
		
	}
}
