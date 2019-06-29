package siteInfo.comment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import main.view.MainViewController;
import siteInfo.articlePage.ArticlePageController;
import siteInfo.service.ISiteInfoService;
import siteInfo.service.ISiteInfoServiceImpl;
import vo.BoardVO;
import vo.CommentVO;
import vo.MemberVO;

public class CommentBoxController implements Initializable{
	
	ISiteInfoService service = ISiteInfoServiceImpl.getInstance();
	private BoardVO currentBoardVO=ArticlePageController.getCurrentBoardVO();
	private MemberVO currentMember = MainViewController.getCurrentMember();
	ObservableList<CommentVO> commentList = service.getCommentList(currentBoardVO.getBoard_id());
	
	@FXML
    private VBox vbCommentBox;

    @FXML
    private VBox vbCommentList;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			FXMLLoader loader;
			CommentListCellController controller;
			Parent parent;
			vbCommentList.getChildren().clear();
			for (int i = 0; i < commentList.size(); i++) {
				CommentVO cv = this.commentList.get(i);
				loader = new FXMLLoader(getClass().getResource("/siteInfo/comment/CommentListCell.fxml"));
				parent = loader.load();
				controller = loader.getController();
				controller.setItem(cv);
				vbCommentList.getChildren().add(parent);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCurrentBoardVO(BoardVO bv) {
    	currentBoardVO = bv;
    }

}
