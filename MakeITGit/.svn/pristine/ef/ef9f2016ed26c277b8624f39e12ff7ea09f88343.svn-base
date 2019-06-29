package member.Interest.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import member.Interest.service.IInterestService;
import member.Interest.service.IInterestServiceImpl;
import searchRoom.service.ISearchRoomService;
import searchRoom.service.SearchRoomServiceImpl;
import searchRoom.view.SearchRoomViewController;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;
import javafx.scene.layout.FlowPane;

public class RecentRoomController implements Initializable {
	
	IInterestService service = IInterestServiceImpl.getInstance();
	
	MemberVO currentMember = MainViewController.getCurrentMember();
	
	SearchLogVO searchlog;
	
	
	@FXML 
	private JFXButton btn_recent;
	@FXML 
	private BorderPane Borderpane;
	@FXML 
	private JFXButton btn_favorite;
	@FXML
	private Label lb_cnt;
	@FXML
	private Label lb_category;
	@FXML 
	private FlowPane fp_flowpane;
	
	List<RoomVO> list;
	ObservableList<RoomVO> roomList;
	RoomVO room;

	
	public RoomVO getRoom() {
		return room;
	}

	public void setRoom(RoomVO room) {
		this.room = room;
	}
	
	
	@FXML
    void btn_recent_Action(ActionEvent event) {
		if(currentMember.getMem_id()!=null) {
		List<RoomVO> roomList = service.getSearchRoomLog(currentMember.getMem_id());
		
		ObservableList<RoomVO> data = FXCollections.observableArrayList(roomList);
		
		setDataListRecent(data);
		// 최근목록 방 숫자 카운트
		lb_cnt.setText(roomList.size()+"");
		
		// 카테고리명 추가
		lb_category.setText("최근 본 방");
		
		} else {
			Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("ERROR");
    		error.setContentText("관심목록은 회원만 조회 가능합니다.");
    		error.showAndWait();
    		return;
		}
    }

    @FXML
    void btn_favorite(ActionEvent event) {
	List<RoomVO> roomList = service.getFavoriteLog(currentMember.getMem_id());
		
		ObservableList<RoomVO> data = FXCollections.observableArrayList(roomList);
		
		setDataListFavorite(data);
		// 즐겨찾는목록 방 숫자 카운트
		lb_cnt.setText(roomList.size()+"");
		
		list = service.getFavoriteLog(currentMember.getMem_id());
		
		lb_category.setText("찜한 방");
    }
    
    // 관심목록에 (최근목록)
	private void setDataListRecent(ObservableList<RoomVO> list) {
		this.list = list;
		fp_flowpane.getChildren().clear();
	
		try {
			FXMLLoader loader;
			RecentCellController recentCellController;
			// 화면에 방정보 뿌려줄 개수 구하기
			// vbox, hbox 가로세로 해서 짜고 싶은데 머리한계	
			Parent parent;
			for(int i=0; i<list.size(); i++) {
				RoomVO room = list.get(i);
				
				// 이미지 불러오기
				RoomImgVO roomImg = service.getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getClassLoader().getResource("member/Interest/view/Recentcell.fxml"));
				parent = loader.load();
				recentCellController = loader.getController();
				recentCellController.setItem(room); // setItem을 만들어야합니다!!
				recentCellController.setRoomImage(new Image(roomImg.getImg_uri()));
				fp_flowpane.getChildren().add(parent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 관심목록에(즐겨찾기)
	private void setDataListFavorite(ObservableList<RoomVO> list) {
		fp_flowpane.getChildren().clear();
		try {
			FXMLLoader loader;
			FavoriteCellController favoriteCellController;
			
			// 화면에 방정보 뿌려줄 개수 구하기
			// vbox, hbox 가로세로 해서 짜고 싶은데 머리한계	
			Parent parent;
			for(int i=0; i<list.size(); i++) {
				RoomVO room = list.get(i);
				RoomImgVO roomImg = service.getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getClassLoader().getResource("member/Interest/view/Favoritecell.fxml"));
				parent = loader.load();
				favoriteCellController = loader.getController();
				favoriteCellController.setItemFavorite(room); // setItem을 만들어야합니다!!
			 	favoriteCellController.setRoomImage(new Image(roomImg.getImg_uri()));
			 	fp_flowpane.getChildren().add(parent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(currentMember.getMem_id()!=null) {
		List<RoomVO> roomList = service.getSearchRoomLog(currentMember.getMem_id());
		
		ObservableList<RoomVO> data = FXCollections.observableArrayList(roomList);
		
		setDataListRecent(data);
		
		list = service.getSearchRoomLog(currentMember.getMem_id());
		// 최근목록 방개수 카운트
		lb_cnt.setText(roomList.size()+"");
		
		lb_category.setText("최근 본 방");
		} else {
			Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("ERROR");
    		error.setContentText("관심목록은 회원만 조회 가능합니다.");
    		error.showAndWait();
    		return;
		}
	}
}