package siteInfo.siteInfoUpdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.view.MainViewController;
import siteInfo.articlePage.ArticlePageController;
import siteInfo.noticeBoard.NoticeBoardController;
import siteInfo.service.ISiteInfoService;
import siteInfo.service.ISiteInfoServiceImpl;
import siteInfo.siteInfo.SiteInfoController;
import vo.BoardVO;
import vo.MemberVO;

public class SiteInfoUpdatePageController implements Initializable{
	
	MemberVO currentMember = MainViewController.getCurrentMember();
	SiteInfoController sic = SiteInfoController.getInstance();
	int siteInfoToolbarFocus = sic.getSiteInfoToolbarFocus();
	private BoardVO currentBoardVO;
	boolean fileExist;
	String dBURI;
	File file;
	
	@FXML
    private ImageView imageLogo;
    
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
    private Label lbFileLocation;
    
    @FXML
    private JFXTextArea taBoardContent;
    
    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnUpload;

    @FXML
    void addImage(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
												 new FileChooser.ExtensionFilter("PNG", "*.png"),
												 new FileChooser.ExtensionFilter("GIF", "*.gif"));
		File file = fileChooser.showOpenDialog(new Stage());
		if(file == null) {
			return;
		}
		fileExist = true;
		this.file = file;
		lbFileLocation.setText(file.toURI().toString());
		
		// 확장자 제거
		String fileName = file.getName();
		int index = fileName.lastIndexOf(".");
		String fileNameWODot = fileName.substring(0,index);
		
		try {
			String oldName = file.getAbsolutePath();
			dBURI = "./src/res/board_img/boardImg"+System.currentTimeMillis()+fileNameWODot;
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			System.out.println(fileNameWODot);
			System.out.println(dBURI);
			FileInputStream fin = new FileInputStream(oldName);
			FileOutputStream fos = new FileOutputStream(dBURI);
			
			int content = 0;
			while((content = fin.read())!= -1) {
				fos.write(content);
			}
			fin.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
    void onCancel(ActionEvent event) {
    	Alert conf = new Alert(AlertType.CONFIRMATION);
    	conf.setTitle("경고");
    	conf.setContentText("게시글 수정을 그만하시겠습니까?");
    	
    	ButtonType result = conf.showAndWait().get();
    	
    	if(result==ButtonType.OK) {
    		
    		try {
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/articlePage/ArticlePage.fxml"));
				Parent noticeBoardNodes = loader.load();
				ArticlePageController apc = loader.getController();
				apc.setItem(currentBoardVO);
				BorderPane currentContainer = sic.getBpSiteInfoContainer();
				currentContainer.setCenter(noticeBoardNodes);
			} catch (IOException e) {
				e.printStackTrace();
			}
    			
    	}else {
    		
    	}
    }

	@FXML
	void onEdit(ActionEvent event) {

		BoardVO bv = currentBoardVO;

		bv.setBoard_category(cbBoardHeader.getSelectionModel().getSelectedItem());
		bv.setBoard_title(tfBoardTitle.getText().trim());
		if (fileExist == true) {
			bv.setBoard_img("file : " + dBURI);
		}
		bv.setBoard_content(taBoardContent.getText().trim());
		bv.setBoard_date(new Date(Calendar.getInstance().getTime().getTime()));
		bv.setMem_id(currentMember.getMem_id());
		if (bv.getBoard_category() == null) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("게시글 수정 실패");
			error.setContentText("머리말을 설정해주세요.");
			error.showAndWait();
		} else if (bv.getBoard_title().equals("")) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("게시글 수정 실패");
			error.setContentText("게시글 제목을 작성해주세요.");
			error.showAndWait();
		} else if (bv.getBoard_content().equals("")) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("경고");
			confirm.setContentText("게시글 내용이 없습니다. 이대로 수정하실겁니까?");

			ButtonType btnResult = confirm.showAndWait().get();

			if (btnResult == ButtonType.OK) {
				ISiteInfoService service = ISiteInfoServiceImpl.getInstance();
				int cnt = service.editArticle(bv);

				if (cnt == 1) {
					Alert info = new Alert(AlertType.INFORMATION);
					info.setTitle("게시글 수정 성공");
					info.setContentText("게시글을 성공적으로 수정하셨습니다.");
					info.showAndWait();

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/articlePage/ArticlePage.fxml"));
						Parent articlePageNodes = loader.load();
						ArticlePageController apc = loader.getController();
						apc.setItem(bv);
						BorderPane currentContainer = sic.getBpSiteInfoContainer();
						currentContainer.setCenter(articlePageNodes);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		} else {
			ISiteInfoService service = ISiteInfoServiceImpl.getInstance();
			int cnt = service.editArticle(bv);
			if (cnt == 1) {
				Alert info = new Alert(AlertType.INFORMATION);
				info.setTitle("게시글 수정 성공");
				info.setContentText("게시글을 성공적으로 수정하셨습니다.");
				info.showAndWait();

				try {
					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/articlePage/ArticlePage.fxml"));
					Parent noticeBoardNodes = loader.load();
					ArticlePageController apc = loader.getController();
					apc.setItem(bv);
					BorderPane currentContainer = sic.getBpSiteInfoContainer();
					currentContainer.setCenter(noticeBoardNodes);
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("게시글 수정 실패");
				error.setContentText("게시글을 수정에 실패하셨습니다.");
				error.showAndWait();
			}
		}
	}
    
    public void setItem(BoardVO bv) {
    	this.currentBoardVO = bv;
    	cbBoardHeader.getSelectionModel().select(bv.getBoard_category());
    	tfBoardTitle.setText(bv.getBoard_title());
        lbFileLocation.setText(bv.getBoard_img());
        taBoardContent.setText(bv.getBoard_content());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> selectHeader = FXCollections.observableArrayList("공지사항","자주 묻는 질문");
		cbBoardHeader.setItems(selectHeader);
	}
}
