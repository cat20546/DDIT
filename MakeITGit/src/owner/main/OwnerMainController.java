package owner.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.view.MainView;
import main.view.MainViewController;
import vo.MemberVO;

public class OwnerMainController implements Initializable{
	
	private static OwnerMainController ownerMainController;
	private static MemberVO currentMember = null;
	
	public OwnerMainController() {
		ownerMainController = this;
	}
	public static OwnerMainController getInstance() {
		return ownerMainController;
	}
	
	VBox mainCenter;
	
	
	
	@FXML
    private JFXButton btnOwnerGuide;

    @FXML
    private ImageView ivOwnerLogo;

    @FXML
    private ImageView ivOwnerAdver4;

    @FXML
    private JFXButton btnOwnerLogin;

    @FXML
    private ImageView ivOwnerAdver2;

    @FXML
    private ImageView ivOwnerAdver3;

    @FXML
    private ImageView ivOwnerAdver1;

    @FXML
    private JFXButton btnOwnerRegister;

    @FXML
    private ImageView ivOwnerMain;

    @FXML
    private VBox vbMainContainer;
    
    @FXML
    BorderPane bpOwnerContainer;
    

    @FXML
    private ImageView ivOwnerIcon;
    
    @FXML
    private JFXButton btnGotoMain;

    // 로그인 했을때 보여줄거
    @FXML
    private HBox hbLogin;

    // 비회원일때 보여줄거
    @FXML
    private HBox hbLogout;

    
    @FXML
    void btnStartOwner(ActionEvent event) {
    	onRoomRegisterClick(event);
    }
    
	/**
	 * 로그아웃 클릭시
	 * @param event
	 */
    @FXML
    void onOwnerLogoutClick(ActionEvent event) {
    	main.view.MainViewController.getInstance().onLogoutClick();
    	onLogout();
    }
    
    public void onLogout() {
    	hbLogout.setVisible(true);
    	hbLogin.setVisible(false);
    }

    @FXML
    void onOwnerGuideClick(ActionEvent event) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("owner/companyIntro/companyIntro.fxml"));
    		bpOwnerContainer.setCenter(parent);
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }

    @FXML
    void onRoomRegisterClick(ActionEvent event) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("owner/registRoom/RegistRoom.fxml"));
    		bpOwnerContainer.setCenter(parent);
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    /**
     * 임차인 사이트로 이동 클릭시
     * @param event
     */
    @FXML
    void onGotoMainClick(ActionEvent event) {
    	MainView.getPrimaryStage().setScene(MainView.getMainScene());
    }
    
    /**
     * 내가 올린 공실 클릭시
     * @param event
     */
    @FXML
    void oMyRoomClick(ActionEvent event) {
    	if(MainViewController.getCurrentMember() == null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("니방내방");
    		alert.setHeaderText("Oops!");
    		alert.setContentText("로그인을 먼저 해주세요");
    		alert.showAndWait();
    		return;
    	}
    	
    	try {
    		Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("owner/myRoom/myRoom.fxml"));
    		bpOwnerContainer.setCenter(parent);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    @FXML
    void onOwnerLoginClick(ActionEvent event) {
    	try {
    		Parent parent;
        	try {
    			parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/login/LogInSignUp.fxml"));
    			Stage stage = new Stage();
    			Scene scene = new Scene(parent);
    			stage.setScene(scene);
    			stage.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    public void onLogin() {
    	hbLogout.setVisible(false);
    	hbLogin.setVisible(true);
    }
    
    public void gotoMainPage() {
    	bpOwnerContainer.setCenter(vbMainContainer);
    }


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(main.view.MainViewController.getCurrentMember() != null) {
			onLogin();
		}else {
			onLogout();
		}
		
		
		ivOwnerLogo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				gotoMainPage();
			};
		});
	}
}
