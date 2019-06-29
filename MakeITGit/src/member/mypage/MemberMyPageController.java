package member.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.view.BuildedSqlMapConfig;
import main.view.MainViewController;
import vo.MemberVO;

public class MemberMyPageController implements Initializable{
	MemberVO currentMember = MainViewController.getCurrentMember();
	SqlMapClient smc = BuildedSqlMapConfig.getInstance();
	
	/**
	 * 상단 툴바에서 포커스를 표시할 변수입니다.
	 * 0일때는 정보수정
	 * 1일때는 연락할 부동산
	 * 2일때는 내가 쓴 리뷰를 표시합니다
	 */
	public static int toolbarFocus = 0;
	
	@FXML
    private JFXComboBox<String> CbPhone1;
	
	@FXML
    private BorderPane bpMypageContainer;

    @FXML
    private JFXButton btnPhone;

    @FXML
    private JFXTextField tfPhone3;

    @FXML
    private JFXTextField tfPhone2;

    @FXML
    private JFXComboBox<String> cbMemberType;

    @FXML
    private JFXTextField tfCurrentPw;

    @FXML
    private JFXTextField tfUpdatePw;
    
    @FXML
    private JFXTextField tfUpdatePw2;

    @FXML
    private JFXTextField tfEmail;

    @FXML
    private JFXTextField tfMemberName;

    @FXML
    private JFXButton btnReceiveRealtor;
    
    @FXML
    private JFXButton btnEditInfo;
    
    @FXML
    private VBox vbChangeInfo;

    @FXML
    private JFXButton btnMyReview;

    
    /**
     * 정보수정 클릭시
     * @param event
     */
    @FXML
    void onEditInfoClick(ActionEvent event) {
    	if(toolbarFocus==0) {
    		return;
    	}
    	btnEditInfo.setStyle("-fx-background-color:#0080FF");
    	btnReceiveRealtor.setStyle("-fx-background-color:#FFFFFF");
    	btnMyReview.setStyle("-fx-background-color:#FFFFFF");
    	btnEditInfo.setTextFill(Color.WHITE);
    	btnReceiveRealtor.setTextFill(Color.BLACK);
    	btnMyReview.setTextFill(Color.BLACK);
    	
    	toolbarFocus=0;
    	
    	try {
			Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/mypage/vbChangeInfo.fxml"));
			bpMypageContainer.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	
    }
    
    /**
     * 연락한 부동산 클릭시
     * @param event
     */
    @FXML
    void onReceiveClick(ActionEvent event) {
    	if(toolbarFocus==1) {
    		return;
    	}
    	btnEditInfo.setStyle("-fx-background-color:#FFFFFF");
    	btnReceiveRealtor.setStyle("-fx-background-color:#0080FF");
    	btnMyReview.setStyle("-fx-background-color:#FFFFFF");
    	btnReceiveRealtor.setTextFill(Color.WHITE);
    	btnEditInfo.setTextFill(Color.BLACK);
    	btnMyReview.setTextFill(Color.BLACK);
    	toolbarFocus=1;
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("member/mypage/myReceiveContract.fxml"));
    	try {
			Parent parent = loader.load();
			bpMypageContainer.setCenter(parent);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	
    }
    
    /**
     * 내가 쓴 리뷰 클릭시
     */
    @FXML
    void onMyReviewClick(ActionEvent event) {
    	if(toolbarFocus==2) {
    		return;
    	}
    	btnEditInfo.setStyle("-fx-background-color:#FFFFFF");
    	btnReceiveRealtor.setStyle("-fx-background-color:#FFFFFF");
    	btnMyReview.setStyle("-fx-background-color:#0080FF");
    	btnMyReview.setTextFill(Color.WHITE);
    	btnReceiveRealtor.setTextFill(Color.BLACK);
    	btnEditInfo.setTextFill(Color.BLACK);
    	toolbarFocus=2;
    	
    	try {
			Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/mypage/boardDefault.fxml"));
			bpMypageContainer.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/mypage/vbChangeInfo.fxml"));
			bpMypageContainer.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
