package siteInfo.noticeBoard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import siteInfo.articlePage.ArticlePageController;
import siteInfo.service.ISiteInfoService;
import siteInfo.service.ISiteInfoServiceImpl;
import siteInfo.siteInfo.SiteInfoController;
import vo.BoardVO;
import vo.CommentVO;

public class BoardCellController implements Initializable {
	
	ISiteInfoService service = ISiteInfoServiceImpl.getInstance();
	private BoardVO currentBoardVO=ArticlePageController.getCurrentBoardVO();
	ObservableList<BoardVO> noticeBoardList;
	ObservableList<CommentVO> commentList;
	SiteInfoController siteInfoController;
	
	@FXML
    private HBox boardCell;
	
	@FXML
	private Label lbNo;
	
	@FXML
	private Label lbTitle;

    @FXML
    private Label lbName;

    @FXML
    private Label lbDate;
    
    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnDel;
	
	
	@FXML
    void onBtnEdit(ActionEvent event) {

    }

    @FXML
    void onBtnDel(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boardCell.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				
				try {
					FXMLLoader articlePageLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/articlePage/ArticlePage.fxml"));
					Parent articlePageNodes = articlePageLoader.load();
					ArticlePageController apc = articlePageLoader.getController();
					apc.setCurrentBoardVO(currentBoardVO);
					apc.setItem(currentBoardVO);
					apc.setBoardDataList(noticeBoardList);
					FXMLLoader commentBoxLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/comment/CommentBox.fxml"));
					Parent commentBoxNodes = commentBoxLoader.load();
					int chk = service.checkCommentExist(currentBoardVO.getBoard_id());
					if(chk>0){
						apc.getVbCommentBox().getChildren().add(commentBoxNodes);
					}
					SiteInfoController sic = siteInfoController.getInstance(); 
					BorderPane bp = sic.getBpSiteInfoContainer();
					bp.setCenter(articlePageNodes);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setItem(BoardVO bv, int no) {
		this.currentBoardVO = bv;
		lbNo.setText(no+"");
		lbTitle.setText(bv.getBoard_title());
		lbDate.setText(bv.getBoard_date().toString());
		lbName.setText(bv.getMem_id());
	}
}
