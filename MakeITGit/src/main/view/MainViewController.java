package main.view;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.application.HostServices;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import owner.companyIntro.CompanyIntroController;
import owner.main.OwnerMainController;
import roomInfo.view.RoomInfoController;
import searchRoom.dao.SearchRoomDaoImpl;
import searchRoom.view.CellController;
import searchRoom.view.SearchRoomViewController;
import siteInfo.siteInfo.SiteInfoController;
import vo.MemberVO;
import vo.RoomImgVO;
import vo.RoomVO;
import vo.SearchLogVO;

public class MainViewController implements Initializable{
	
	private static MainViewController mainViewController;
	private static MemberVO currentMember = null;
    final int MOVE = 250;
    List<TranslateTransition> ttlist;
	
	/**
	 * mainviewcontroll객체생성과 getInstance()
	 */
	public MainViewController() {
		mainViewController = this;
	}
	public static MainViewController getInstance() {
		return mainViewController;
	}
	
	@FXML
	BorderPane bpMainContainer;
	
	public BorderPane getBpMainContainer() {
		return bpMainContainer;
	}
	
	@FXML
    private VBox vbMain;
	@FXML
	ImageView ivLogo;
	@FXML
	JFXButton btnLogin;
	@FXML
	JFXButton btnRegister;
	@FXML
    private Label lbMypage;
	@FXML
    private ImageView ivMemberIcon;
	@FXML
	private TextField tfSearchRoom;
    @FXML
    private ScrollPane spMain;
    @FXML
    private HBox hbLogin;
    @FXML
    private HBox hbNoLogin;
    @FXML
    private JFXButton btnFrequentQuestion;
    @FXML
    private JFXButton btnNoticeBoard;
	@FXML 
	private JFXButton administer;
	@FXML
	private HBox hbRoomContainer;
	@FXML
	private JFXButton btnLogout;
	@FXML JFXButton manual;
	
	public ScrollPane getMainSp() {
		return spMain;
	}
	public void scrollToTop() {
		spMain.setVvalue(0);
	}
	
	/**
	 * 종료버튼 클릭시
	 * @param event
	 */
    @FXML
    void onCloseClick(ActionEvent event) {
    	System.exit(0);
    }
	
	/**
	 * 상단 툴바의 '방찾기' 클릭시
	 * @param event
	 */
    @FXML
    void onSearchRoomClick(ActionEvent event) {
    	Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getClassLoader().getResource("searchRoom/view/searchRoom.fxml"));
			parent.getStylesheets().add(getClass().getResource("../../searchRoom/view/app.css").toString());
			bpMainContainer.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    /**
     * 하단 검색창의 '방찾기' 클릭시
     * 검색창에 공백값을 넣거나 입력하지 않으면
     * 상단 툴바의 '방찾기'클릭과 같은 이벤트를 발생시킨다.
     * 검색창에 입력을 하면
     * 입력한 위치의 좌표값을 받아와
     * 지도에 표시하여 그 위치의 방을 보여준다
     * @param event
     */
    @FXML
    void onMainSearchRoomClick(ActionEvent event) {
    	String searchStr = tfSearchRoom.getText();
    	onSearchRoomClick(event);
    	if(searchStr.trim().isEmpty()) {
    		return;
    	}else {
    		SearchRoomViewController.getInstance().setMainMap(tfSearchRoom.getText());
    	}
    }
    
    /**
     * 중개사 사이트로 이동 버튼 클릭시
     * @param event
     */
    @FXML
    void onRealtorClick(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("니방내방");
    	alert.setHeaderText("Oops!");
    	alert.setContentText("중개사 접근 권한이 없습니다!");
    	alert.showAndWait();
    	return;
    }
    
    /**
     * 방주인 사이트로 이동 버튼 클릭시
     * @param event
     */
    @FXML
    void onOwnerClick(ActionEvent event) {
    	Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getClassLoader().getResource("owner/main/ownerMain.fxml"));
			MainView.getPrimaryStage().setScene(new Scene(parent));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    

    /**
     * 관심목록 버튼 클릭시
     * @param event
     */
    @FXML
    void onFavoritClick(ActionEvent event) {
    	if(currentMember == null) {
    		Alert error = new Alert(AlertType.ERROR);
    		error.setTitle("ERROR");
    		error.setContentText("관심목록은 회원만 조회 가능합니다.");
    		error.showAndWait();
    		return;
		}

		Parent parent;
		try {
			parent = FXMLLoader
					.load(getClass().getClassLoader().getResource("member/Interest/view/RecentlySeenRoomList.fxml"));
			bpMainContainer.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /**
     * 방 올리기 버튼 클릭시
     * @param event
     */
    @FXML
    void onRoomRegisterClick(ActionEvent event) {
    	onOwnerClick(event);
    }

    /**
     * 알림 버튼 클릭시
     * @param event
     */
    @FXML
    void onNoticeClick(ActionEvent event) {
    	
    }


    /**
     * 로그인 버튼 클릭시
     * @param event
     */
    @FXML
    void onLoginClick(ActionEvent event) {
    	Parent parent;
    	try {
			parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/login/LogInSignUp.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * 회원가입 버튼 클릭시
     * @param event
     */
    @FXML
    public void onRegisterClick(ActionEvent event) {
    	Parent parent;
    	try {
			parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/signup/SignUp.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 방 찾기 클릭시
     * @param room
     */
    public void onRoomInfoClick(RoomVO room) {
    	// 조회수를 늘립니다.
    	SearchLogVO slvo = new SearchLogVO();
    	
    	slvo.setMem_id(currentMember == null ? "비회원" : currentMember.getMem_id());
    	slvo.setRoom_id(room.getRoom_id());
    	slvo.setSearch_date(new Date(Calendar.getInstance().getTime().getTime()));
    	SearchRoomDaoImpl.getInstance().AddSearchLog(slvo);
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("roomInfo/view/roomInfo.fxml"));
    	Parent parent;
    	try {
			parent = loader.load();
			RoomInfoController controller = loader.getController();
			controller.setRoomVO(room);
			controller.setScrollTop();
			bpMainContainer.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static MemberVO getCurrentMember() {
    	return currentMember;
    }
    
    /**
     * 현재 로그인 한 멤버를 저장하는 메서드
     * @param currentMember
     */
    public void setCurrentMember(MemberVO currentMember) {
    	this.currentMember = currentMember;
    }
    
    public void setDefaultMain() {
    	bpMainContainer.setCenter(vbMain);
    }
    
    /**
     * 로그인시 작동할 메서드들
     */
    public void onLogIn(MemberVO currentMember) {
    	hbLogin.setVisible(true);
    	hbNoLogin.setVisible(false);
    	btnLogout.setVisible(true);
    	MemberVO mv = new MemberVO();
    	if(currentMember.getMem_id().equals("admin")) {
    		administer.setVisible(true);
    	}
    	this.currentMember = currentMember;
    	
    	// 메인화면으로 오게 만들어야함
    	try {
    		MainView.getPrimaryStage().setScene(MainView.getMainScene());
    	}catch(IllegalArgumentException e){
    		OwnerMainController.getInstance().gotoMainPage();
    	}
    	
    	
    	
    	
    }
    
    /**
     * 로그아웃시 작동할 메서드들
     */
    @FXML
    public void onLogoutClick() {
    	hbLogin.setVisible(false);
    	hbNoLogin.setVisible(true);
    	btnLogout.setVisible(false);
    	this.currentMember = null;
//    	bpMainContainer.setCenter(spMain);
    	
    	// 메인화면으로 오게 만들어야함
    	try {
    		MainView.getPrimaryStage().setScene(MainView.getMainScene());
    	}catch(IllegalArgumentException e){
    		OwnerMainController.getInstance().gotoMainPage();
    	}
    }
    
    /**
     * 자주 묻는 질문 게시판으로 가는 메서드
     * setSelectTogglebtn(int)
     * 0 = 자주 묻는 질문
     * 1 = 1:1 채팅
     * 2 = 공지사항
     */
    @FXML
    void onFrequentQuestion(ActionEvent event) {
    	try {
    		FXMLLoader siteInfoLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/siteInfo/SiteInfo.fxml"));
			Parent siteInfoNodes = siteInfoLoader.load();
			SiteInfoController sic = SiteInfoController.getInstance();
			sic.setSelectTogglebtn(0);
			BorderPane sbp = sic.getBpSiteInfoContainer();
			
			FXMLLoader noticeBoardLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/frequentQuestion/FrequentQuestion.fxml"));
			Parent noticeBoardNodes = noticeBoardLoader.load();
			
			sbp.setCenter(noticeBoardNodes);
			bpMainContainer.setCenter(sbp);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 공지사항 게시판으로 가는 메서드
     * setSelectTogglebtn(int)
     * 0 = 자주 묻는 질문
     * 1 = 1:1 채팅
     * 2 = 공지사항
     */
    @FXML
    void showNoticeBoard(ActionEvent event) {
    	try {
			FXMLLoader siteInfoLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/siteInfo/SiteInfo.fxml"));
			Parent siteInfoNodes = siteInfoLoader.load();
			SiteInfoController sic = SiteInfoController.getInstance();
			sic.setSelectTogglebtn(2);
			BorderPane sbp = sic.getBpSiteInfoContainer();
			
			FXMLLoader noticeBoardLoader = new FXMLLoader(getClass().getClassLoader().getResource("siteInfo/noticeBoard/NoticeBoard.fxml"));
			Parent noticeBoardNodes = noticeBoardLoader.load();
			
			sbp.setCenter(noticeBoardNodes);
			bpMainContainer.setCenter(sbp);
			scrollToTop();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 회사 소개를 눌렀을 때
     * @param event
     */
    @FXML
    void onCompanyIntroClick(ActionEvent event) {
    	HostServices hs = new CompanyIntroController().getHostServices();
		hs.showDocument("file:./src/pdf/NBNB.pdf");
    }
    
    /**
     * 이용설명서를 눌렀을 때
     */
    @FXML
    void manual(ActionEvent event) {
    	HostServices hs = new CompanyIntroController().getHostServices();
		hs.showDocument("file:./src/pdf/NBNB.pdf");
    }
    
    /**
     * Top버튼을 눌렀을 때
     * @param event
     */
    @FXML
    void onGotoTopClick(ActionEvent event) {
    	scrollToTop();
    }
    
    
    /**
     * 가이드1	청약준비, 기본용어
     * @param event
     */
    @FXML
    void onGuide1Click(ActionEvent event) {
    	Stage stage = new Stage();
    	VBox vb = new VBox();
    	Scene scene = new Scene(vb);
    	stage.setScene(scene);
    	WebView wv = new WebView();
    	wv.setLayoutX(1600);
    	wv.setLayoutY(2000);
    	vb.getChildren().add(wv);
    	wv.getEngine().load("https://post.naver.com/viewer/postView.nhn?volumeNo=16717859&memberNo=2120568&navigationType=push");
    	stage.show();
    }

    /**
     * 임대차 계약서 작성시 유의점
     * @param event
     */
    @FXML
    void onGuide2Click(ActionEvent event) {
    	Stage stage = new Stage();
    	VBox vb = new VBox();
    	Scene scene = new Scene(vb);
    	stage.setScene(scene);
    	WebView wv = new WebView();
    	wv.setLayoutX(1600);
    	wv.setLayoutY(2000);
    	vb.getChildren().add(wv);
    	wv.getEngine().load("https://post.naver.com/viewer/postView.nhn?volumeNo=16606488&memberNo=2120568");
    	stage.show();
    }

    /**
     * 아파트 베이 보는법
     * @param event
     */
    @FXML
    void onGuide3Click(ActionEvent event) {
    	Stage stage = new Stage();
    	VBox vb = new VBox();
    	Scene scene = new Scene(vb);
    	stage.setScene(scene);
    	WebView wv = new WebView();
    	wv.setLayoutX(1600);
    	wv.setLayoutY(2000);
    	vb.getChildren().add(wv);
    	wv.getEngine().load("https://post.naver.com/viewer/postView.nhn?volumeNo=17096730&memberNo=2120568");
    	stage.show();
    }

    /**
     * 부동산 용어
     * @param event
     */
    @FXML
    void onGuide4Click(ActionEvent event) {
    	Stage stage = new Stage();
    	VBox vb = new VBox();
    	Scene scene = new Scene(vb);
    	stage.setScene(scene);
    	WebView wv = new WebView();
    	wv.setLayoutX(1600);
    	wv.setLayoutY(2000);
    	vb.getChildren().add(wv);
    	wv.getEngine().load("https://post.naver.com/viewer/postView.nhn?volumeNo=16492098&memberNo=2120568&navigationType=push");
    	stage.show();
    }

    /**
     * 등기부등본 보는법
     * @param event
     */
    @FXML
    void onGuide5Click(ActionEvent event) {
    	Stage stage = new Stage();
    	VBox vb = new VBox();
    	Scene scene = new Scene(vb);
    	stage.setScene(scene);
    	WebView wv = new WebView();
    	wv.setLayoutX(1600);
    	wv.setLayoutY(2000);
    	vb.getChildren().add(wv);
    	wv.getEngine().load("https://post.naver.com/viewer/postView.nhn?volumeNo=12467698&memberNo=2120568&navigationType=push");
    	stage.show();
    }

    
    
    void setRooms() {
    	List<RoomVO> roomList = SearchRoomDaoImpl.getInstance().getRoomList();
    	ttlist = new ArrayList<>();
    	Parent subParent;
		try {
			FXMLLoader loader;
			CellController controller;
			for(int i=0; i<roomList.size(); i++) {
				RoomVO room = roomList.get(i);
				RoomImgVO roomImg = SearchRoomDaoImpl.getInstance().getRoomImg(room.getRoom_id());
				loader = new FXMLLoader(getClass().getClassLoader().getResource("searchRoom/view/cell.fxml"));
				subParent = loader.load();
				subParent.getStylesheets().add(getClass().getResource("../../searchRoom/view/cell.css").toString());
				hbRoomContainer.getChildren().add(subParent);
				controller = loader.getController();
				controller.setRoomImage(new Image(roomImg.getImg_uri()));
				controller.setRoomVO(room);
				TranslateTransition tt = new TranslateTransition(new Duration(30000), subParent);
				tt.setFromX(subParent.getLayoutX());
	    		tt.setToX(subParent.getLayoutX() - MOVE*roomList.size());
	    		tt.setCycleCount(10000); 
				ttlist.add(tt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    /**
     * 애니메이션
     */
    void startAnimation() {
    	if(ttlist == null) {
    		return;
    	}
    	if(ttlist.isEmpty()) {
    		return;
    	}
    	Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean sw = false;
				while(true) {
					for(int i =0; i<ttlist.size(); i++) {
						TranslateTransition tt = ttlist.get(i);
						tt.setAutoReverse(true);
						tt.setCycleCount(10);
						tt.play();
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
    	th.start();
    	
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setRooms();
		startAnimation();
		
		administer.setOnAction(e->{
	    	if(currentMember.getMem_id().equals("admin")) {
	    		try {
					Parent root;
					root = FXMLLoader.load(getClass().getClassLoader().getResource("admin/mainview/Administer.fxml"));
					MainView.getPrimaryStage().setScene(new Scene(root));
					root.getStylesheets().add(getClass().getClassLoader().getResource("admin/css/stylesheet.css").toString());
					
				} catch (IOException e2) {
					e2.printStackTrace();
				}
	    	}
		});
		
		
		ivLogo.setImage(new Image("res/logo.png"));
		/**
		 * 니방내방 로고 클릭시
		 */
		ivLogo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event evkent) {
				bpMainContainer.setCenter(vbMain);
			};
		});
		
		/**
		 * 마이페이지 클릭시
		 */
		ivMemberIcon.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				Parent parent;
		    	try {
					parent = FXMLLoader.load(getClass().getClassLoader().getResource("member/mypage/MemberMyPage.fxml"));
					bpMainContainer.setCenter(parent);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
