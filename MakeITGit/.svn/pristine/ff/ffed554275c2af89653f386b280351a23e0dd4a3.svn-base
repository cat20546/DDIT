package member.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;
import vo.ReviewVO;

public class BoardDefaultController implements Initializable {
	
	IMemberService service = MemberServiceImpl.getInstance();
	
	MemberVO currentMember = MainViewController.getCurrentMember();

	ObservableList<ReviewVO> list;
	
	private static BoardDefaultController boardDefaultController;
	
	{
		boardDefaultController = this;
	}
	public static BoardDefaultController getInstance() {
		return boardDefaultController;
	}
	
	
	@FXML
	private VBox vbBoardContainer;

	@FXML
	private JFXTextField tfSearch;

	@FXML
	void onSearchTyped(ActionEvent event) {

	}
	
	@FXML
	void onBtnLeftAction(ActionEvent event) {
		if(current_page != 0) {
			current_page--;
			vbBoardContainer.getChildren().clear();
			setDataList(list);
		}
	}

	@FXML
	void onBtnRightAction(ActionEvent event) {
		if(current_page < max_page) {
			if(list.size() - (max_page * SHOW_MAX_IDX) == 0 && current_page == max_page-1)
				return;
			
			current_page++;
			vbBoardContainer.getChildren().clear();
			setDataList(list);
		}
	}
	
	
	final int SHOW_MAX_IDX = 18;

	int current_page = 0;
	int max_page;
	int max_idx;

	// 데이터 리스트를 받아와 게시판 형태로 리스트를 만들어주는 메서드
	public void setDataList(ObservableList<ReviewVO> list) {
		vbBoardContainer.getChildren().clear();
		max_page = list.size() / SHOW_MAX_IDX;
		max_idx = SHOW_MAX_IDX;

		// 현재 페이지가 마지막 페이지일시 마지막 게시글의 인덱스를 구함
		if (current_page == max_page) {
			max_idx = list.size() - (max_page * SHOW_MAX_IDX);
		}

		try {
			FXMLLoader loader;
			BoardCellController controller;
			Parent parent;
			int startIdx = SHOW_MAX_IDX * current_page;
			for (int i = startIdx; i < startIdx + max_idx; i++) {
				ReviewVO bv = list.get(i);
				loader = new FXMLLoader(getClass().getResource("/member/mypage/BoardCell.fxml"));
				parent = loader.load();
				controller = loader.getController();
				controller.setItem(bv, i);
				vbBoardContainer.getChildren().add(parent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard() {
		list = FXCollections.observableArrayList(service.getMyReview(currentMember.getMem_id()));
		current_page=0;
		setDataList(list);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateBoard();
	}
	
}
