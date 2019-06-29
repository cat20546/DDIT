package siteInfo.noticeBoard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import siteInfo.service.ISiteInfoService;
import siteInfo.service.ISiteInfoServiceImpl;
import siteInfo.siteInfo.SiteInfoController;
import vo.BoardVO;
import vo.MemberVO;

public class NoticeBoardController implements Initializable {
	
	ISiteInfoService service = ISiteInfoServiceImpl.getInstance();
	MemberVO currentMember = MainViewController.getCurrentMember();
	SiteInfoController sic = SiteInfoController.getInstance();

	@FXML
	private VBox vbBoardContainer;

	@FXML
	private JFXTextField tfSearch;
	
	@FXML
	private JFXButton btnNewNotice;

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
	
	final int SHOW_MAX_IDX = 7;
	int current_page = 0;
	int max_page;
	int max_idx;
	ObservableList<BoardVO> list;

	// 데이터 리스트를 받아와 게시판 형태로 리스트를 만들어주는 메서드
	public void setDataList(ObservableList<BoardVO> list) {
		max_page = list.size() / SHOW_MAX_IDX;
		max_idx = SHOW_MAX_IDX;

		// 현재 페이지가 마지막 페이지일시 마지막 게시글의 인덱스를 구함
		if (current_page == max_page) {
			max_idx = list.size() - (max_page * SHOW_MAX_IDX);
		}

		try {
			FXMLLoader loader;
			BoardCellController boardCellController;
			Parent parent;
			int startIdx = SHOW_MAX_IDX * current_page;
			for (int i = startIdx; i < startIdx + max_idx; i++) {
				BoardVO bv = list.get(i);
				loader = new FXMLLoader(getClass().getResource("/siteInfo/noticeBoard/BoardCell.fxml"));
				parent = loader.load();
				boardCellController = loader.getController();
				boardCellController.setItem(bv, i);
				vbBoardContainer.getChildren().add(parent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void onNewNotice(ActionEvent event) {
		try {
			FXMLLoader siipLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/siteInfoInput/SiteInfoInputPage.fxml"));
			Parent inputPageNodes = siipLoader.load();
			FXMLLoader siLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/siteInfo/SiteInfo.fxml"));
			sic.getBpSiteInfoContainer().setCenter(inputPageNodes);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// BoardVO 객체를 담아줄 ObservableList를 선언
		list = service.getNoticeBoardList();
		setDataList(list);
		if(currentMember == null) {
			return;
		}
		if(currentMember.getMem_auth().trim().equals("admin")) {
			btnNewNotice.setDisable(false);
			btnNewNotice.setOpacity(SHOW_MAX_IDX);
		}
	}
}
