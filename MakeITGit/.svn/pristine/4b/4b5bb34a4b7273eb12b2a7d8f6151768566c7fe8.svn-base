package board.inputPageTemp;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import board.service.IBoardService;
import board.service.IBoardServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import main.view.MainViewController;
import siteInfo.siteInfo.SiteInfoController;
import vo.BoardVO;
import vo.MemberVO;

public class InputPageController implements Initializable{
	
	MemberVO currentMember = MainViewController.getCurrentMember();
	
	static SiteInfoController sic = SiteInfoController.getInstance();
	static int siteInfoToolbarFocus = sic.getSiteInfoToolbarFocus();
	
	@FXML
    private ImageView imageLogo;
    
    @FXML
    private JFXComboBox<String> cbBoard;

    @FXML
    private JFXComboBox<String> cbBoardHeader;

    @FXML
    private JFXTextField tfBoardTitle;
    
    @FXML
    private JFXButton btnAddImage;
    
    @FXML
    private JFXButton btnAddVideo;
    
    @FXML
    private JFXButton btnAddMap;
    
    @FXML
    private JFXButton btnAddFile;
    
    @FXML
    private JFXTextArea taBoardContent;
    
    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnPost;

    @FXML
    void addImage(ActionEvent event) {
    	
    }

    @FXML
    void addVideo(ActionEvent event) {

    }

    @FXML
    void addMap(ActionEvent event) {

    }

    @FXML
    void addFile(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
    	Alert conf = new Alert(AlertType.CONFIRMATION);
    	conf.setTitle("경고");
    	conf.setContentText("게시글 작성을 그만하시겠습니까?");
    	
    	ButtonType result = conf.showAndWait().get();
    	
    	if(result==ButtonType.OK) {
    		
//			try {
//				if(siteInfoToolbarFocus==2) {
//					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/noticeBoard/NoticeBoard.fxml"));
//					Parent noticeBoardNodes = loader.load();
//				}else if(siteInfoToolbarFocus==0) {
//					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/frequentQuestion/FrequentQuestion.fxml"));
//					Parent frequentBoardNodes = loader.load();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
    	}
    }

    @FXML
    void postArticle(ActionEvent event) {
    	
    	BoardVO bv = new BoardVO();
    	
    	bv.setBoard_category(cbBoardHeader.getSelectionModel().getSelectedItem());
    	bv.setBoard_title(tfBoardTitle.getText().trim());
    	bv.setBoard_content(taBoardContent.getText().trim());
    	bv.setBoard_date(new Date(Calendar.getInstance().getTime().getTime()));
    	bv.setMem_id(currentMember.getMem_id());
    	if(bv.getBoard_category()==null) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("게시글 작성 실패");
    		error.setContentText("머리말을 설정해주세요.");
    		error.showAndWait();
    	}else if(bv.getBoard_title().equals("")) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("게시글 작성 실패");
    		error.setContentText("게시글 제목을 작성해주세요.");
    		error.showAndWait();
    	}else if(bv.getBoard_content().equals("")) {
    		Alert confirm = new Alert(AlertType.CONFIRMATION);
    		confirm.setTitle("경고");
    		confirm.setContentText("게시글 내용이 없습니다. 이대로 작성하실겁니까?");

    		ButtonType btnResult = confirm.showAndWait().get();
    		
    		if(btnResult==ButtonType.OK) {
    			IBoardService service = IBoardServiceImpl.getInstance();
    			
    			int cnt = service.postArticle(bv);
    			
    			if (cnt ==1 ) {
    				Alert info = new Alert(AlertType.INFORMATION);
    				info.setTitle("게시글 작성 성공");
    				info.setContentText("게시글을 성공적으로 작성하셨습니다.");
    				info.showAndWait();
    				((Node)(event.getSource())).getScene().getWindow().hide();
    			}else {
    				Alert error = new Alert(AlertType.ERROR);
    				error.setTitle("게시글 작성 실패");
    				error.setContentText("게시글을 작성에 실패하셨습니다.");
    				error.showAndWait();
    			}
    		}
    	}else {
    		IBoardService service = IBoardServiceImpl.getInstance();
			
			int cnt = service.postArticle(bv);
			
			if (cnt ==1 ) {
				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("게시글 작성 성공");
				info.setContentText("게시글을 성공적으로 작성하셨습니다.");
				info.showAndWait();
//				((Node)(event.getSource())).getScene().getWindow().hide();
			}else {
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("게시글 작성 실패");
				error.setContentText("게시글을 작성에 실패하셨습니다.");
				error.showAndWait();
			}
    	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> selectBoard = FXCollections.observableArrayList("","","","");
		ObservableList<String> selectHeader = FXCollections.observableArrayList("공지사항","","","");
		
		cbBoard.setItems(selectBoard);
		cbBoardHeader.setItems(selectHeader);
	}
}
