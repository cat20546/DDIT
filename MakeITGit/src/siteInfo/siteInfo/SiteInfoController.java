package siteInfo.siteInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleNode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import siteInfo.frequentQuestion.FrequentQuestionController;
import siteInfo.noticeBoard.NoticeBoardController;

public class SiteInfoController implements Initializable{
	
	/**
	 * SiteInfoController객체, 생성자 및 getter
	 */
	private static SiteInfoController siteInfoController;
	
	public SiteInfoController() {
		siteInfoController=this;
	}
	
	public static SiteInfoController getInstance() {
		return siteInfoController;
	}
	
	/**
	 * 문의사항페이지에서 이전게시판을 기억하게 해주는 변수
	 * 자주묻는질문=0
	 * 1:1문의=1
	 * 공지사항=2
	 */
	private static int siteInfoToolbarFocus;
	
	public int getSiteInfoToolbarFocus() {
		return siteInfoToolbarFocus;
	}

	public void setSiteInfoToolbarFocus(int siteInfoToolbarFocus) {
		SiteInfoController.siteInfoToolbarFocus = siteInfoToolbarFocus;
	}
	
	/**
	 * BorderPane 생성과 getter
	 */
	@FXML
	private BorderPane bpSiteInfoContainer;

	public BorderPane getBpSiteInfoContainer() {
		return bpSiteInfoContainer;
	}
	
	@FXML
	private ToggleGroup toggleSiteInfo;
	
	public ToggleGroup getToggleSiteInfo() {
		return toggleSiteInfo;
	}

	public void setToggleSiteInfo(ToggleGroup toggleSiteInfo) {
		this.toggleSiteInfo = toggleSiteInfo;
	}
	
	@FXML
    private JFXToggleNode btnFrequentQuestions;

    @FXML
    private JFXToggleNode btnInquiry;
    
    @FXML
    private JFXToggleNode btnNoticeBoard;
    
    public JFXToggleNode getBtnFrequentQuestions() {
		return btnFrequentQuestions;
	}

	public JFXToggleNode getBtn1to1Chat() {
		return btnInquiry;
	}

	public JFXToggleNode getBtnNoticeBoard() {
		return btnNoticeBoard;
	}

	@FXML
    private VBox vbSiteInfo;

    @FXML
    void onFrequentQuestions(ActionEvent event) {
		try {
			btnFrequentQuestions.setSelected(true);
    		btnInquiry.setSelected(false);
    		btnNoticeBoard.setSelected(false);
    		
			Parent fQNodes = FXMLLoader.load(getClass().getClassLoader().getResource("siteInfo/frequentQuestion/FrequentQuestion.fxml"));
			bpSiteInfoContainer.setCenter(fQNodes);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onInquiry(ActionEvent event) {
    	try {
			btnFrequentQuestions.setSelected(false);
    		btnInquiry.setSelected(true);
    		btnNoticeBoard.setSelected(false);
    		
			Parent inquiryNodes = FXMLLoader.load(getClass().getClassLoader().getResource("siteInfo/inquiry/Inquiry.fxml"));
			bpSiteInfoContainer.setCenter(inquiryNodes);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void onNoticeBoard(ActionEvent event) {
		try {
			btnFrequentQuestions.setSelected(false);
    		btnInquiry.setSelected(false);
    		btnNoticeBoard.setSelected(true);
			
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/noticeBoard/NoticeBoard.fxml"));
			Parent noticeBoardNodes = loader.load();
			
			NoticeBoardController noticeCon = loader.getController();
			bpSiteInfoContainer.setCenter(noticeBoardNodes);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    /**
	 * 토글 게시판 버튼을 내용과 연결시켜주는 메서드
	 * 자주묻는질문 = 0
	 * 1:1문의 = 1
	 * 공지사항 = 2
	 */
    public void setSelectTogglebtn(int no) {
    	if(no==0) {
    		btnFrequentQuestions.setSelected(true);
    		btnInquiry.setSelected(false);
    		btnNoticeBoard.setSelected(false);
    	}else if(no==1) {
    		btnFrequentQuestions.setSelected(false);
    		btnInquiry.setSelected(true);
    		btnNoticeBoard.setSelected(false);
    	}else if(no==2) {
    		btnFrequentQuestions.setSelected(false);
    		btnInquiry.setSelected(false);
    		btnNoticeBoard.setSelected(true);
    	}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			if(btnNoticeBoard.isSelected()) {
				
				btnNoticeBoard.setSelected(true);
				btnFrequentQuestions.setSelected(false);
	    		btnInquiry.setSelected(false);
	    		
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/noticeBoard/NoticeBoard.fxml"));
				Parent noticeBoardNodes = loader.load();
				NoticeBoardController noticeController = loader.getController();
				bpSiteInfoContainer.setCenter(noticeBoardNodes);
			}else if(btnFrequentQuestions.isSelected()) {
				
				btnFrequentQuestions.setSelected(true);
				btnInquiry.setSelected(false);
	    		btnNoticeBoard.setSelected(false);
	    		
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/frequentQuestion/FrequentQuestion.fxml"));
				Parent frequentQuestionNodes = loader.load();
				FrequentQuestionController frequentQuestionController = loader.getController();
				bpSiteInfoContainer.setCenter(frequentQuestionNodes);
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
