package admin.member;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import admin.service.AdminMemberServiceImpl;
import admin.service.IAdminMemberService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vo.MemberVO;

public class MemberController implements Initializable{
	
	@FXML 
	private VBox vboxlist;
	
	@FXML 
	private BorderPane memberContainer;
	
	@FXML
	private JFXButton btn_registerId;
	
	// borderpane get, set
	public BorderPane getMainContainer() {
		return memberContainer;
	}
	// vboxlist
	public VBox vboxList() {
		return vboxlist;
	}
	
	private static MemberController myController;
	
	private static VBox centerContainer;
	
	// vboslist set, get
	public VBox getVboxlist() {
		return vboxlist;
	}
	public void setVboxlist(VBox vboxlist) {
		this.vboxlist = vboxlist;
	}

	
	public static VBox getCenterContainer() {
		return centerContainer;
	}
	
	public static MemberController getInstance() {
		return myController;
	}

	{
		myController = this;
	}
	
	//서비스콜
	IAdminMemberService service = AdminMemberServiceImpl.getInstance();
	
	// 페이징처리를 위한 변수
	final int SHOW_MAX_IDX = 18;
	int current_page = 0;
	int max_page;
	int max_idx;
	
	List<MemberVO> memList = service.getAllMemberList();
	ObservableList<MemberVO> data = FXCollections.observableArrayList(memList);

	@FXML 
	private Label btn_member;

	@FXML
	private Label btn_room;
	
	
	// 왼쪽버튼 페이지 클릭
	@FXML
	void onBtnLeftAction(ActionEvent event) {
		if(current_page != 0) {
			current_page--;
			vboxlist.getChildren().clear();
			setDataList(data);
		}
	}

	
	// 오른쪽버튼 페이지 클릭
	@FXML 
	void onBtnRightAction() {
		if(current_page < max_page) {
			if(data.size() - (max_page * SHOW_MAX_IDX) == 0 && current_page == max_page-1)
				return;
			
			current_page++;
			vboxlist.getChildren().clear();
			setDataList(data);
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 사이드바 회원관리 버튼 클릭시 회원관리 메인 페이지로 이동
		btn_member.setOnMouseClicked(e -> {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/member.fxml"));
				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
				Scene scene = new Scene(root);
				Stage window =(Stage)btn_member.getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		// 사이드바 방관리 버튼 클릭시 방 관리 메인 페이지로 이동
		btn_room.setOnMouseClicked(e -> {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/room/RoomList.fxml"));
				root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
				Scene scene = new Scene(root);
				Stage window =(Stage)btn_member.getScene().getWindow();
				window.setScene(scene);
				window.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		// MemberVO 객체를 담아줄 ObservableList를 선언
		
		btn_registerId.setOnAction(e-> {
			try {
				Parent root;
				root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/member/MemberReg.fxml"));
				memberContainer.setCenter(root);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});
		
		/**
		 * DB에 갱신된 데이터를 불러오는 메서드(연결)
		 */
		List<MemberVO> memList = service.getAllMemberList();
		ObservableList<MemberVO> data = FXCollections.observableArrayList(memList);
		
		MemberVO mv = new MemberVO();
		mv.setMem_id("아이디");
		mv.setMem_name("이름");
		data.add(mv);
		setDataList(data);
		
		}

	// 데이터 리스트를 받아와 게시판 형태로 리스트를 만들어주는 메서드
	public void setDataList(ObservableList<MemberVO> list) {
		max_page = list.size() / SHOW_MAX_IDX;
		max_idx = SHOW_MAX_IDX;
		
		// 현재 페이지가 마지막 페이지일시 마지막 게시글의 인덱스를 구함
		if (current_page == max_page) {
			max_idx = list.size() - (max_page * SHOW_MAX_IDX);
		}
	
		
		try {
			FXMLLoader loader;
			MemberCellController controller;
			Parent parent;
			int startIdx = SHOW_MAX_IDX * current_page;
			for(int i=startIdx; i<startIdx + max_idx; i++) {
				MemberVO mv = list.get(i);
				
				loader = new FXMLLoader(getClass().getClassLoader().getResource("admin/member/MemberCell.fxml"));
				parent = loader.load();
				controller = loader.getController();
				controller.setItem(mv, i);
				controller.setCurrentMember(mv);
				vboxlist.getChildren().add(parent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
